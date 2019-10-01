package dao;

import pojo.Order_Detail;

import java.util.List;

public interface Order_DetailMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Order_Detail record);

    int insertSelective(Order_Detail record);

    Order_Detail selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Order_Detail record);

    int updateByPrimaryKey(Order_Detail record);

    /**
     * 根据订单ID查询该订单下的所有购买的商品的详细信息
     * @param OrderId
     * @return
     */
    List<Order_Detail> selectDetailByOrderId(Integer OrderId);
}