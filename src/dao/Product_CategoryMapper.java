package dao;

import pojo.Product_Category;

public interface Product_CategoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Product_Category record);

    int insertSelective(Product_Category record);

    Product_Category selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Product_Category record);

    int updateByPrimaryKey(Product_Category record);
}