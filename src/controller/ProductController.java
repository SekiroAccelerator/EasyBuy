package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.Product;
import service.ProductService;

import javax.annotation.Resource;

@Controller
public class ProductController {
    @Resource
    private ProductService service;

    @RequestMapping("product")
    @ResponseBody
    public Product add(@RequestParam Integer id){
        return service.selectByPrimaryKey(id);
    }



}
