package service;

import org.apache.ibatis.annotations.Param;
import pojo.PageBean;
import pojo.Product;

import java.util.List;

public interface ProductService {
    /**
     * id查询
     * @param id
     * @return
     */
    Product selectByPrimaryKey(Integer id);

    /**
     * 总数
     * @return
     */
    int count();

    /**
     * 列表
     * @param isDelete
     * @param pageBean
     * @return
     */
    List<Product> productList(Integer isDelete, PageBean pageBean);


    int deleteByPrimaryKey(Integer id);

    int insertSelective(Product record);

    int updateByPrimaryKeySelective(Product record);

    /**
     3级id看有没有商品
     */
    Product selectLv3(Integer icategoryLevel3Id);
}
