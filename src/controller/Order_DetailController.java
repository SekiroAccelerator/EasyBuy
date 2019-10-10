package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.Order_Detail;
import pojo.Product;
import service.Order_DetailService;
import service.ProductService;

import javax.annotation.Resource;
import java.util.List;

/**
 * 订单商品控制器
 */
@Controller
public class Order_DetailController {

    @Autowired
    @Qualifier("order_DetailService")
    private Order_DetailService order_detailService;

    @Resource
    private ProductService productService;

    @RequestMapping("/selectDetailByOrderId")
    @ResponseBody
    public List<Order_Detail> selectDetailByOrderId(Integer orderId){
        return order_detailService.selectDetailByOrderId(orderId);
    }

    @RequestMapping("/addOrderDetail")
    @ResponseBody
    public boolean addOrder(Order_Detail order_Detail){
        Product product = productService.selectByPrimaryKey(order_Detail.getProductId());
        product.setStock(product.getStock()-order_Detail.getQuantity());
        productService.updateByPrimaryKeySelective(product);
        return order_detailService.insertSelective(order_Detail)>0;
    }
}
