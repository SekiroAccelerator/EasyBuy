package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.User;
import service.UserService;

import javax.annotation.Resource;

@Controller
public class UserController {
    @Resource
    private UserService Service;
    @RequestMapping("login")
    @ResponseBody
    public boolean login(@RequestParam(required = false) String loginName, @RequestParam(required = false) String password) {
        User user =new  User();
        user.setLoginName(loginName);
        user.setPassword(password);
        if (Service.login(user)!=null){
            return true;
        }else {
            return false;
        }
    }
}
