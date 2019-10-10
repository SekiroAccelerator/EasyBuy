package controller;

import net.spy.memcached.MemcachedClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.Product;
import service.ProductService;
import service.UserService;

import javax.annotation.Resource;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.*;

@Controller
public class ShouCangController {
    @Resource
    private ProductService service;

    @Resource
    private UserService userService;

    static MemcachedClient mcc;
    Map<Integer,List<Product>> userMap=new HashMap<>();
    List<Product> list;

    static {
        try {
            mcc = new MemcachedClient(new InetSocketAddress("127.0.0.1", 11211));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("shouCangAdd")
    @ResponseBody
    public Map<String, String> shouCangAdd(Integer id,Integer pid) {
        Map<String, String> map = new HashMap<>();
        if (userService.userById(id.toString())==null){
            map.put("message", "请登录后再收藏.");
            return map;
        }
        if (userMap.get(id)==null){
            list=new LinkedList<>();
            userMap.put(id, list);
        }
        for (Product product : userMap.get(id)) {
            if (pid.equals(product.getId())) {
                map.put("message", "收藏失败,该商品已被收藏.");
                return map;
            }
        }
        if (service.selectByPrimaryKey(pid) != null) {
            if (userMap.get(id).size() >= 5) {
                userMap.get(id).remove(0);
            }
            userMap.get(id).add(service.selectByPrimaryKey(pid));
            map.put("message", "收藏成功!");
        } else {
            map.put("message", "收藏失败,找不到该商品.");
        }
        mcc.set("userMap", 0, userMap);
        return map;
    }

    @RequestMapping("shouCangDel")
    @ResponseBody
    public boolean shouCangDel(Integer id,Integer pid) {
        int size=userMap.get(id).size();
        for (int i = 0; i < userMap.get(id).size(); i++) {
            if (pid.equals(userMap.get(id).get(i).getId())){
                userMap.get(id).remove(i);
            }
        }
        mcc.set("userMap", 0, userMap);
        return userMap.get(id).size() < size;

    }

    @RequestMapping("shouCangShow")
    @ResponseBody
    public List<Product> shouCangShow(Integer id) {
        if (userMap.get(id).isEmpty()&&mcc.get("userMap") == null) {
            userMap.get(id).clear();
            mcc.set("userMap", 0, userMap);
        }
        return userMap.get(id);
    }
}
