package service;

import pojo.Order;
import utils.Pages;

import java.util.Map;

public interface OrderService {

    /**
     * 根据用户编号分页查询所有的订单信息
     * @param pageNow
     * @param userId
     * @return
     */
    Pages<Order> selectAllOrder(Integer pageNow, Integer userId);

    /**
     * 根据用户编号分页查询所有的订单信息（管理员）
     * @param pageNow
     * @return
     */
    Pages<Order> selectAllOrder2(Integer pageNow);

    /**
     * 根据ID主键删除订单号
     * @param id
     * @return
     */
    int deleteOrderById(Integer id);

    /**
     * 根据ID主键查询订单号
     * @param id
     * @return
     */
    Order selectOrderById(Integer id);
}
