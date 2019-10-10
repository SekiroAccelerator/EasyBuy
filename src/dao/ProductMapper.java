package dao;

import org.apache.ibatis.annotations.Param;
import pojo.PageBean;
import pojo.Product;

import java.util.List;

public interface ProductMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Product record);

    int insertSelective(Product record);

    Product selectByPrimaryKey(Integer id);

    /**
     3级id看有没有商品
     */
    Product selectLv3(Integer icategoryLevel3Id);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);

    /**
     * 总数
     * @return
     */
    int count();

    /**
     * 列表
     *
     * @param isDelete
     * @param pageBean
     * @return
     */
    List<Product> productList(@Param("isDelete") Integer isDelete,@Param("pageBean") PageBean pageBean);
}