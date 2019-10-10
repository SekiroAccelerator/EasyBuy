package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.Order;
import pojo.Order_Detail;
import pojo.Product;
import service.OrderService;
import service.Order_DetailService;
import service.ProductService;
import utils.Code;
import utils.Pages;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 订单控制器
 */
@Controller
public class OrderController {

    @Autowired
    @Qualifier("orderService")
    private OrderService orderService;

    @Resource
    private Order_DetailService detailService;

    @Resource
    private ProductService productService;

    /**
     * 根据userId查询所有的订单项
     *
     * @param userId
     * @param pageNow
     * @return
     */
    @RequestMapping("/selectAllOrder")
    @ResponseBody
    public Pages<Order> selectAllOrder(Integer userId, Integer pageNow, Integer state) {
        return orderService.selectAllOrder(userId, pageNow, state);
    }

    /**
     * 查询所有的订单项（管理员 ）
     *
     * @param pageNow
     * @return
     */
    @RequestMapping("/selectAllOrder2")
    @ResponseBody
    public Pages<Order> selectAllOrder2(Integer pageNow, Integer state ,String loginName) {
        return orderService.selectAllOrder2(pageNow, state ,loginName);
    }

    /**
     * 根据ID主键删除订单号
     *
     * @param id
     * @return
     */
    @RequestMapping("/deleteOrderById")
    @ResponseBody
    public int deleteOrderById(Integer id) {
        List<Order_Detail> list=detailService.selectDetailByOrderId(id);
        for (int i = 0; i < list.size(); i++) {
            Product product=productService.selectByPrimaryKey(list.get(i).getProductId());
            product.setStock(product.getStock()+list.get(i).getQuantity());
            productService.updateByPrimaryKeySelective(product);
            detailService.deleteDetailById(list.get(i).getId());
        }
        return orderService.deleteOrderById(id);
    }

    /**
     * 根据ID主键查询订单号
     *
     * @param id
     * @return
     */
    @RequestMapping("/selectOrderById")
    @ResponseBody
    public Order selectOrderById(@RequestParam(value = "orderId") Integer id) {
        return orderService.selectOrderById(id);
    }

    @RequestMapping("/orderStateById")
    @ResponseBody
    public Map orderStateById(@RequestParam Integer userId) {
        Map<String, Object> map = new HashMap<>();
        map.put("state_yes", orderService.selectOrderStateCountById(userId, 1));
        map.put("state_no", orderService.selectOrderStateCountById(userId, 0));
        return map;
    }

    @RequestMapping("/addOrder")
    @ResponseBody
    public Integer addOrder(Order order) {
        order.setCreateTime(new Date());
        order.setSerialNumber(Code.jiaMiOne(order.getId() + order.getCreateTime().toString()));
        boolean flag = orderService.insertSelective(order) > 0;
        if (flag) {
            return order.getId();
        } else {
            return 0;
        }
    }

    @RequestMapping("/payOrder")
    @ResponseBody
    public boolean payOrder(Order order) {
        return orderService.updateByPrimaryKeySelective(order)>0;
    }
}
