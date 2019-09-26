package dao;

import pojo.easybuy_order_detail;

public interface easybuy_order_detailMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(easybuy_order_detail record);

    int insertSelective(easybuy_order_detail record);

    easybuy_order_detail selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(easybuy_order_detail record);

    int updateByPrimaryKey(easybuy_order_detail record);
}