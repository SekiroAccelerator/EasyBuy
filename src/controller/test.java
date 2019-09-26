package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.User;

@Controller
public class test {
    @RequestMapping("t")
    @ResponseBody
    public User test(){
        User user=new User();
        user.setAge(18);
        user.setName("一方");
        return user;
    }
}
