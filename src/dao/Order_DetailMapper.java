package dao;

import pojo.Order_Detail;

public interface Order_DetailMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Order_Detail record);

    int insertSelective(Order_Detail record);

    Order_Detail selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Order_Detail record);

    int updateByPrimaryKey(Order_Detail record);
}