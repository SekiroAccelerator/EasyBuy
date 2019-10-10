package controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import pojo.PageBean;
import pojo.Product;
import service.ProductService;
import utils.Code;
import utils.DeleteFileUtil;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Controller
public class ProductController {
    @Resource
    private ProductService service;

    @RequestMapping("product")
    @ResponseBody
    public Product product(@RequestParam Integer id){
        return service.selectByPrimaryKey(id);
    }

    @RequestMapping("productList")
    @ResponseBody
    public PageBean productList(@RequestParam String page,@RequestParam(required = false) Integer isDelete){
        PageBean pageBean=new PageBean();
        pageBean.setPageSize(10);
        pageBean.setCount(service.count());
        pageBean.setPage(Integer.parseInt(page));
        pageBean.setProductList(service.productList(isDelete,pageBean));
        return pageBean;
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @RequestMapping("delProduct")
    @ResponseBody
    public boolean del(@RequestParam Integer id){
        Product product=service.selectByPrimaryKey(id);
        if (product.getFileName()!=null){
            DeleteFileUtil.deleteFile(product.getFileName());
        }
        return service.deleteByPrimaryKey(id)>0;
    }

    /**
     * 修改用户
     * 密码如果没有变动就跳过if,如果变动了就重新加密
     * @param product
     * @return
     */
    @RequestMapping("updateProduct")
    @ResponseBody
    public boolean updateSave(Product product) {
        return service.updateByPrimaryKeySelective(product) > 0;
    }

    /**
     * 添加用户
     * @param file
     * @param json
     * @return
     */
    @RequestMapping("addProduct")
    @ResponseBody
    public Map<String,Object> addProduct(@RequestParam(value = "file",required = false) MultipartFile file,@RequestParam("json") String json) {
        Map<String,Object> map=new HashMap<>();
        String fileName = null;
        Product product=JSON.parseObject(json,Product.class);
        String fileError="error";
        if (!file.isEmpty()) {
            String oldFileName=file.getOriginalFilename();//获得原文件名
            String houZhui= FilenameUtils.getExtension(oldFileName);//tomcat的工具包,拿到文件的后缀名
            int size=5000000;
            if (file.getSize()>size) {
                map.put(fileError,"照片过大");
            }else if (houZhui.equalsIgnoreCase("jpg")||houZhui.equalsIgnoreCase("png")){
                if (houZhui.equalsIgnoreCase("jpg")){
                    fileName= "images" + File.separator +UUID.randomUUID().toString()+".jpg";
                }else {
                    fileName= "images" + File.separator +UUID.randomUUID().toString()+".png";
                }
                File file1=new File("D:\\Workspaces\\EasyBuyWeb",fileName);
                try {
                    file.transferTo(file1);
                } catch (IOException e) {
                    map.put(fileError,"图片上传失败");
                    e.printStackTrace();
                }
            }else {
                map.put(fileError,"格式不正确");
            }
        }
        product.setFileName(fileName);
        product.setCreateTime(new Date());
        int i=service.insertSelective(product);
        if (i==0){
            map.put(fileError,"添加失败!");
        }
        return map;
    }

    /**
     * 修改用户
     * 上传头像
     * @return
     */
    @RequestMapping("picProduct")
    @ResponseBody
    public Map<String,Object> updateSave(@RequestParam(value = "file",required = false) MultipartFile file,@RequestParam("json") String json) {
        Map<String,Object> map=new HashMap<>();
        String fileName = null;
        Product product=JSON.parseObject(json,Product.class);
        String fileError="error";
        if (!file.isEmpty()) {
            String oldFileName=file.getOriginalFilename();//获得原文件名
            String houZhui= FilenameUtils.getExtension(oldFileName);//tomcat的工具包,拿到文件的后缀名
            int size=5000000;
            if (file.getSize()>size) {
                map.put(fileError,"照片过大");
            }else if (houZhui.equalsIgnoreCase("jpg")||houZhui.equalsIgnoreCase("png")){
                if (houZhui.equalsIgnoreCase("jpg")){
                    fileName= "images" + File.separator +UUID.randomUUID().toString()+".jpg";
                }else {
                    fileName= "images" + File.separator +UUID.randomUUID().toString()+".png";
                }
                File file1=new File("D:\\Workspaces\\EasyBuyWeb",fileName);
                try {
                    file.transferTo(file1);
                } catch (IOException e) {
                    map.put(fileError,"图片上传失败");
                    e.printStackTrace();
                }
            }else {
                map.put(fileError,"格式不正确");
            }
        }
        if (product.getFileName()!=null&&!"".equals(product.getFileName())){
            DeleteFileUtil.deleteFile(product.getFileName());
        }
        product.setFileName(fileName);
        service.updateByPrimaryKeySelective(product);
        return map;
    }
}
