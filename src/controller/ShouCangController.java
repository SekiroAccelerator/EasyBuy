package controller;

import net.spy.memcached.MemcachedClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.Product;
import service.ProductService;

import javax.annotation.Resource;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Controller
public class ShouCangController {
    @Resource
    private ProductService service;

    static MemcachedClient mcc;
    Set<Product> set=new HashSet<>();

    static {
        try {
            mcc = new MemcachedClient(new InetSocketAddress("127.0.0.1", 11211));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("shouCangAdd")
    @ResponseBody
    public Map<String,String> shouCangAdd(Integer id) {
        Map<String,String> map=new HashMap<>();
        if (set.size() < 5) {
            int size = set.size();
            if (service.selectByPrimaryKey(id)!=null){
                set.add(service.selectByPrimaryKey(id));
                mcc.set("set", 900, set);
                if (set.size() > size){
                    map.put("message","收藏成功!");
                }else {
                    map.put("message","收藏失败,该商品已被收藏.");
                }
            }else {
                map.put("message","收藏失败,找不到该商品.");
            }
        }else {
            map.put("message","收藏夹已满,请清理后再收藏!");
        }
        return map;
    }

    @RequestMapping("shouCangDel")
    @ResponseBody
    public boolean shouCangDel(Integer id) {
        int size = set.size();
        set.remove(service.selectByPrimaryKey(id));
        mcc.set("set", 900, set);
        return set.size() < size;

    }

    @RequestMapping("shouCangShow")
    @ResponseBody
    public Object shouCangShow() {
        if (mcc.get("set")!=null){
            return mcc.get("set");
        }else {
            set.clear();
            mcc.set("set", 900, set);
            return mcc.get("set");
        }
    }

}
