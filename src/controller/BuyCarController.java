package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.UserService;
import utils.MyMemcached;

import javax.annotation.Resource;

@Controller
public class BuyCarController {
    @Resource
    private UserService service;

    @RequestMapping("shoucang")
    @ResponseBody
    public void add(String key, Object object){
    }



}
