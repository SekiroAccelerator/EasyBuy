package service.impl;

import dao.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pojo.Order;
import service.OrderService;
import utils.Pages;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Transactional(rollbackFor={Exception.class})
@Service("orderService")
public class OrderServiceImpl implements OrderService {

    @Autowired
    @Qualifier("orderMapper")
    private OrderMapper orderMapper;

    /**
     * 根据userId查询所有订单信息
     */
    @Override
    public Pages<Order> selectAllOrder(Integer userId, Integer pageNow){
        Pages<Order> pages = new Pages<Order>();
        pages.setPageSize(5);
        Map<String,Object> map = new HashMap<String,Object>();

        map.put("pageStart",(pageNow-1)*pages.getPageSize());
        map.put("pageSize",pages.getPageSize());
        map.put("userId",userId);

        pages.setPageNow(pageNow);
        int count = orderMapper.selectOrderCount(userId);
        pages.setCount(count);
        pages.setPageCount(pages.getCount());
        pages.setList(orderMapper.selectOrderLimit(map));
        return pages;
    }

    /**
     * 查询所有订单信息（管理员）
     */
    @Override
    public Pages<Order> selectAllOrder2(Integer pageNow){
        Pages<Order> pages = new Pages<Order>();
        pages.setPageSize(5);
        Map<String,Object> map = new HashMap<String,Object>();

        map.put("pageStart",(pageNow-1)*pages.getPageSize());
        map.put("pageSize",pages.getPageSize());

        pages.setPageNow(pageNow);
        int count = orderMapper.selectOrderCount2();
        pages.setCount(count);
        pages.setPageCount(pages.getCount());
        pages.setList(orderMapper.selectOrderLimit2(map));
        return pages;
    }

    /**
     * 根据ID主键删除订单号
     * @param id
     * @return
     */
    @Override
    public int deleteOrderById(Integer id){
        int count = 0;
        try {
            count = orderMapper.deleteByPrimaryKey(id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return count;
    }

    /**
     * 根据ID主键查询订单号
     * @param id
     * @return
     */
    @Override
    public Order selectOrderById(Integer id) {
        return orderMapper.selectByPrimaryKey(id);
    }


}
