package service;

import org.apache.ibatis.annotations.Param;
import pojo.Product_Category;

import java.util.List;

public interface Product_CategoryService {
    int deleteByPrimaryKey(Integer id);

    int insert(Product_Category record);

    int insertSelective(Product_Category record);

    int updateByPrimaryKeySelective(Product_Category record);

    int updateByPrimaryKey(Product_Category record);

    /**
     * 分类查询
     * @param type
     * @return
     */
    List<Product_Category> type(Integer type);

    /**
     * 分类查询二
     * @param parentId
     * @return
     */
    List<Product_Category> typeSon(Integer parentId);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    Product_Category selectByPrimaryKey(Integer id);

    /**
     * 根据品牌id查询所有该品牌的商品（品牌为3级）
     * @param id
     * @return
     */
    List<Product_Category> selectCategoryByid(Integer id,Integer shuliang);

    /**
     * 3级id查1级id
     */
    Integer oneByThree(Integer id);
}
