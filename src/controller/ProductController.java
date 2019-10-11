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
import pojo.Product_Category;
import service.ProductService;
import service.product.goodsService;
import utils.Code;
import utils.DeleteFileUtil;
import utils.Pages;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.*;

@Controller
public class ProductController {

    @Resource
    private ProductService service;

    //商品
    @Resource
    private service.product.goodsService goodsService ;

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

    @RequestMapping("product")
    @ResponseBody
    public Product product(@RequestParam Integer id){
        return service.selectByPrimaryKey(id);
    }

    /**
     * 三级分类查询
     * @return
     */
    @RequestMapping("/products")
    @ResponseBody
    public List<Product_Category> selectByType(){
        return service.selectByType() ;
    }

    /**
     * 根据 对应的三级分类的id查询对应的商品
     * @param id
     * @return
     */
    @RequestMapping("/goods")
    @ResponseBody
    public List<Product> selectByThreeId(@RequestParam(value = "id" ,required = true)String id){
        return goodsService.selectByThreeId(Integer.valueOf(id));
    }

    @RequestMapping("/goods/sort")
    @ResponseBody
    public Pages<Product> selectByType(@RequestParam(value = "id",required = true)String id,
                                       @RequestParam(value = "pageIndex",required = false)String pageIndex,
                                       @RequestParam(value = "type",required = false)String type){
        Pages<Product> pages = new Pages<Product>() ;
        Map<String,Object> params = new HashMap<String,Object>() ;
        params.put("id",id) ;
        int pageNow = 0 ;
        if(pageIndex == null || pageIndex.length() == 0){
            pageNow = 1;
        }else{
            pageNow = Integer.parseInt(pageIndex);
        }
        pages.setPageNow(pageNow);
        if(type != null || type.length() > 0){
            params.put("type",type) ;
        }
        return goodsService.selectByType(params,pages);
    }

    /**
     * 根据二级分类id和三级分类id查询数量和名字
     * @param id
     * @param pid
     * @return
     */
    @RequestMapping("/product/type/sort")
    @ResponseBody
    public Map<String,Object> selectByPidAndId(@RequestParam(value = "id",required = true)String id,
                                               @RequestParam(value = "pid",required = true)String pid){
        return service.selectByPidAndId(Integer.valueOf(pid),Integer.valueOf(id)) ;
    }

    /**
     * 不需要参数的一些固定的查询
     * 1)查询热门款
     * @return
     */
    @RequestMapping("goods/fixed/stock")
    @ResponseBody
    public List<Product> selectByStock(){
        return goodsService.selectByStock();
    }

    /**
     * 不需要参数的一些固定的查询
     * 2)根据价格查询最新热卖品
     * @return
     */
    @RequestMapping("goods/fixed/price")
    @ResponseBody
    public List<Product> selectByPrice(){
        return goodsService.selectByPrice() ;
    }

    /**
     * 中间导航栏的分页查询
     * @param id
     * @param pageIndex
     * @param type
     * @return
     */
    @RequestMapping("index/nav")
    @ResponseBody
    public Pages<Product> selectByCategoryLevel1Id(@RequestParam(value = "id",required = true)String id,
                                                   @RequestParam(value = "pageIndex",required = false)String pageIndex,
                                                   @RequestParam(value = "type",required = false)String type){
        Pages<Product> pages = new Pages<Product>() ;
        Map<String,Object> params = new HashMap<String,Object>() ;
        params.put("id",id) ;
        int pageNow = 0 ;
        if(pageIndex == null || pageIndex.length() == 0){
            pageNow = 1;
        }else{
            pageNow = Integer.parseInt(pageIndex);
        }
        pages.setPageNow(pageNow);
        if(type != null || type.length() > 0){
            params.put("type",type) ;
        }
        return goodsService.selectByCategoryLevel1Id(params,pages);
    }

    /**
     * 根据名字模糊查询商品
     * @param name
     * @return
     */
    @RequestMapping("goods/name")
    @ResponseBody
    public Pages<Product> selectByName(@RequestParam(value = "name",required = true) String name,
                                       @RequestParam(value = "pageIndex",required = false)String pageIndex,
                                       @RequestParam(value = "type",required = false)String type){
        System.out.println(1);
        System.out.println(name);
        Pages<Product> pages = new Pages<Product>() ;
        Map<String,Object> params = new HashMap<String,Object>() ;
        params.put("name",name) ;
        int pageNow = 0 ;
        if(pageIndex == null || pageIndex.length() == 0){
            pageNow = 1;
        }else{
            pageNow = Integer.parseInt(pageIndex);
        }
        pages.setPageNow(pageNow);
        if(type != null || type.length() > 0){
            params.put("type",type) ;
        }
        return goodsService.selectByName(params,pages);
    }
}
