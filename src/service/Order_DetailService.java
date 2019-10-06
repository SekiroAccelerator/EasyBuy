package service;

import pojo.Order_Detail;

import java.util.List;

public interface Order_DetailService {

    /**
     * 根据订单编号查询该订单下的所有购买的商品
     * @param orderId
     * @return
     */
    List<Order_Detail> selectDetailByOrderId(Integer orderId);

    /**
     * 根据商品编号删除订单中的商品
     * @param id
     * @return
     */
    int deleteDetailById(Integer id);

    /**
     * 将商品添加到订单
     * @param detail
     * @return
     */
    int addDetail(Order_Detail detail);

    /**
     * 添加
     * @param record
     * @return
     */
    int insertSelective(Order_Detail record);
}
