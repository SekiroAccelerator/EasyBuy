package controller;

import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pojo.PageBean;
import pojo.User;
import service.UserService;
import utils.Code;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
public class UserController {
    @Resource
    private UserService service;

    /**
     * 判断用户名是否存在
     *
     * @param loginName
     * @return
     */
    @RequestMapping("/loginNameIsExist")
    @ResponseBody
    public Integer loginNameIsExist(@RequestParam(value = "loginName") String loginName) {
        return service.loginNameIsExist(loginName);
    }

    /**
     * 添加用户
     *
     * @param user
     * @return
     */
    @RequestMapping("/addUser")
    @ResponseBody
    public Integer addUser(User user) {
        return service.addUser(user);
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    @ResponseBody
    public User login(@RequestParam(value = "loginName", required = false) String loginName, @RequestParam(value = "password", required = false) String password) {
        User user = new User();
        user.setLoginName(loginName);
        if (password != null && password.length() > 0) {
            user.setPassword(Code.jiaMiOne(password));
        }
        return service.login(user);
    }

    @RequestMapping(value = "userList")
    @ResponseBody
    public PageBean userList(@RequestParam String page) {
        PageBean pageBean=new PageBean();
        pageBean.setCount(service.count());
        pageBean.setPage(Integer.parseInt(page));
        pageBean.setList(service.userList(pageBean));
        return pageBean;
    }

    /**
     * id查用户
     *
     * @param id
     * @return
     */
    @RequestMapping("user")
    @ResponseBody
    public User userById(@RequestParam String id) {
        return service.userById(id);
    }

    /**
     * 修改用户
     * 密码如果没有变动就跳过if,如果变动了就重新加密
     * @param user
     * @return
     */
    @RequestMapping("updateSave")
    @ResponseBody
    public boolean updateSave(User user) {
        String password=service.userById(user.getId().toString()).getPassword();
        if (!user.getPassword().equals(password)) {
            user.setPassword(Code.jiaMiOne(user.getPassword()));
        }
        return service.updateByPrimaryKeySelective(user) > 0;
    }

    /**
     * 修改用户
     * 密码如果没有变动就跳过if,如果变动了就重新加密
     * @param id
     * @return
     */
    @RequestMapping("picSave")
    @ResponseBody
    public Map<String,Object> updateSave(@RequestParam(value = "id")String id,
                                         @RequestParam(value = "file",required = false) MultipartFile file) {
        Map<String,Object> map=new HashMap<>();
        String fileError="error";
        if (!file.isEmpty()) {
            String oldFileName=file.getOriginalFilename();//获得原文件名
            String houZhui= FilenameUtils.getExtension(oldFileName);//tomcat的工具包,拿到文件的后缀名
            int size=5000000;
            if (file.getSize()>size) {
                map.put(fileError,"照片过大");
            }else if (houZhui.equalsIgnoreCase("jpg")||houZhui.equalsIgnoreCase("png")){
                String fileName;
                if (houZhui.equalsIgnoreCase("jpg")){
                    fileName= UUID.randomUUID().toString()+".jpg";
                }else {
                    fileName= UUID.randomUUID().toString()+".png";
                }
                File file1=new File("D:\\Workspaces\\EasyBuyWeb\\images",fileName);
                if (!file1.exists()){
                    file1.mkdir();
                    User user=service.userById(id);
                    user.setPic(fileName);
                    map.put("flag", service.updatePic(user));
                }
                try {
                    file.transferTo(file1);
                } catch (IOException e) {
                    map.put(fileError,"上传失败");
                    e.printStackTrace();
                }
            }else {
                map.put(fileError,"格式不正确");
            }
        }
        return map;
    }
    @RequestMapping("del")
    @ResponseBody
    public boolean del(@RequestParam String id){
        return service.deleteByPrimaryKey(Integer.parseInt(id))>0;
    }
}
