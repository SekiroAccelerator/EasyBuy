package dao;

import org.apache.ibatis.annotations.Param;
import pojo.Product_Category;

import java.util.List;

public interface Product_CategoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Product_Category record);

    int insertSelective(Product_Category record);

    Product_Category selectByPrimaryKey(Integer id);

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
     * 根据品牌id查询所有该品牌的商品（品牌为3级）
     * @param id
     * @return
     */
    List<Product_Category> selectCategoryByid(@Param(value = "id") Integer id,@Param(value = "shuliang") Integer shuliang);
    /**
     * 3级id查1级id
     */
    Integer oneByThree(Integer id);

    /**
     * 查询所有一级分类
     * @return
     */
    List<Product_Category> selectAllOneId();

    /**
     * 根据一级id查询所有三级分类
     * @param id
     * @return
     */
    List<Product_Category> selectAllTwoIdByOneId(@Param(value = "id")Integer id);

    /**
     * 查询商品三级分类
     * @return
     */
    List<Product_Category> selectByType();

    /**
     * 根据父类id查询三级分类
     * @param pid
     * @return
     */
    List<Product_Category> selectByPid(@Param("pid") Integer pid);
}