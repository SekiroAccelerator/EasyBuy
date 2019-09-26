package dao;

import pojo.easybuy_product_category;

public interface easybuy_product_categoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(easybuy_product_category record);

    int insertSelective(easybuy_product_category record);

    easybuy_product_category selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(easybuy_product_category record);

    int updateByPrimaryKey(easybuy_product_category record);
}