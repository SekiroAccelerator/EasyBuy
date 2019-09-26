package dao;

import pojo.easybuy_order;

public interface easybuy_orderMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(easybuy_order record);

    int insertSelective(easybuy_order record);

    easybuy_order selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(easybuy_order record);

    int updateByPrimaryKey(easybuy_order record);
}