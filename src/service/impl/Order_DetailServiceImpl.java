package service.impl;

import dao.Order_DetailMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pojo.Order_Detail;
import service.Order_DetailService;

import java.util.List;

@Transactional(rollbackFor={Exception.class})
@Service("order_DetailService")
public class Order_DetailServiceImpl implements Order_DetailService {

    @Autowired
    @Qualifier("order_DetailMapper")
    private Order_DetailMapper order_detailMapper;

    /**
     * 根据商品编号删除订单中的商品
     * @param id
     * @return
     */
    @Override
    public int deleteDetailById(Integer id) {
        int count = 0;

        try {
            count = order_detailMapper.deleteByPrimaryKey(id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return count;
    }

    /**
     * 将商品添加到订单
     * @param detail
     * @return
     */
    @Override
    public int addDetail(Order_Detail detail) {
        int count = 0;

        try {
            count = order_detailMapper.updateByPrimaryKeySelective(detail);
        }catch (Exception e){
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public int insertSelective(Order_Detail record) {
        return order_detailMapper.insertSelective(record);
    }

    /**
     * 根据订单ID查询该订单下的所有购买的商品的详细信息
     * @param orderId
     * @return
     */
    @Override
    public List<Order_Detail> selectDetailByOrderId(Integer orderId){
        return order_detailMapper.selectDetailByOrderId(orderId);
    }
}
