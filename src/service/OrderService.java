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
    Pages<Order> selectAllOrder(Integer pageNow, Integer userId,Integer state);

    /**
     * 根据用户编号分页查询所有的订单信息（管理员）
     * @param pageNow
     * @param state
     * @param loginName
     * @return
     */
    Pages<Order> selectAllOrder2(Integer pageNow, Integer state ,String loginName);

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

    /**
     * id和状态查订单数量
     * @param userId
     * @param state
     * @return
     */
    int selectOrderStateCountById(Integer userId,Integer state);

    /**
     * 选择性添加订单
     * @param record
     * @return
     */
    int insertSelective(Order record);

    /**
     * 选择性的修改订单信息
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Order record);
}
