package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.Order_Detail;
import service.Order_DetailService;

import java.util.List;

/**
 * 订单商品控制器
 */
@Controller
public class Order_DetailController {

    @Autowired
    @Qualifier("order_DetailService")
    private Order_DetailService order_detailService;

    @RequestMapping("/selectDetailByOrderId")
    @ResponseBody
    public List<Order_Detail> selectDetailByOrderId(Integer orderId){
        return order_detailService.selectDetailByOrderId(orderId);
    }
}