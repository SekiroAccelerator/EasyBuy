package controller;

import com.ndktools.javamd5.Mademd5;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.User;
import service.UserService;
import utils.Code;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;

@Controller
public class UserController {
    @Resource
    private UserService Service;
    @RequestMapping(value = "login",method = RequestMethod.POST)
    @ResponseBody
    public User login(@RequestParam(value = "loginName",required = false) String loginName, @RequestParam(value = "password",required = false) String password) {
        User user =new  User();
        user.setLoginName(loginName);
        if (password!=null&&password.length()>0){
            user.setPassword(Code.jiaMiOne(password));
        }
        return Service.login(user);
    }
}
