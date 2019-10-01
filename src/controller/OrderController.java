package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.Order;
import service.OrderService;
import utils.Pages;


/**
 * 订单控制器
 */
@Controller
public class OrderController {

    @Autowired
    @Qualifier("orderService")
    private OrderService orderService;

    /**
     * 根据userId查询所有的订单项
     * @param userId
     * @param pageNow
     * @return
     */
    @RequestMapping("/selectAllOrder")
    @ResponseBody
    public Pages<Order> selectAllOrder(Integer userId,Integer pageNow){
        return orderService.selectAllOrder(userId,pageNow);
    }

    /**
     * 查询所有的订单项（管理员 ）
     * @param pageNow
     * @return
     */
    @RequestMapping("/selectAllOrder2")
    @ResponseBody
    public Pages<Order> selectAllOrder2(Integer pageNow){
        return orderService.selectAllOrder2(pageNow);
    }

    /**
     * 根据ID主键删除订单号
     * @param id
     * @return
     */
    @RequestMapping("/deleteOrderById")
    @ResponseBody
    public int deleteOrderById(Integer id){
        return orderService.deleteOrderById(id);
    }

    /**
     * 根据ID主键查询订单号
     * @param id
     * @return
     */
    @RequestMapping("/selectOrderById")
    @ResponseBody
    public Order selectOrderById(@RequestParam(value = "orderId") Integer id){
        return orderService.selectOrderById(id);
    }
}
