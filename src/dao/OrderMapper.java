package dao;

import pojo.Order;

import java.util.List;
import java.util.Map;

public interface OrderMapper {
    /**
     * 根据ID主键删除订单号
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);

    int insert(Order record);

    /**
     * 选择性添加订单
     * @param record
     * @return
     */
    int insertSelective(Order record);

    /**
     * 根据ID主键查询订单号
     * @param id
     * @return
     */
    Order selectByPrimaryKey(Integer id);

    /**
     * 选择性的修改订单信息
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

    /**
     * 根据userId分页查询所有订单
     * @return
     */
    List<Order> selectOrderLimit(Map<String,Object> map);

    /**
     * 根据userId查询订单数量
     * @param userId
     * @return
     */
    int selectOrderCount(Integer userId);

    /**
     * 分页查询所有订单（管理员）
     * @param map
     * @return
     */
    List<Order> selectOrderLimit2(Map<String,Object> map);

    /**
     * 查询订单数量（管理员）
     * @return
     */
    int selectOrderCount2();

}