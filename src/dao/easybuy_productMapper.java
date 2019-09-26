package dao;

import pojo.easybuy_product;

public interface easybuy_productMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(easybuy_product record);

    int insertSelective(easybuy_product record);

    easybuy_product selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(easybuy_product record);

    int updateByPrimaryKey(easybuy_product record);
}