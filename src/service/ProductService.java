package service;

import org.apache.ibatis.annotations.Param;
import pojo.PageBean;
import pojo.Product;
import pojo.Product_Category;

import java.util.List;
import java.util.Map;

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
    List<Product> selectLv3(Integer icategoryLevel3Id);

    //查询各级分类
    List<Product_Category> selectByType();

    //查询二级分类下面的所有三级分类以及数量
    Map<String,Object> selectByPidAndId(Integer pid, Integer id) ;
}
