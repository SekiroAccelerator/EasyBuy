package dao;

import org.apache.ibatis.annotations.Param;
import pojo.PageBean;
import pojo.Product;

import java.util.List;
import java.util.Map;

public interface ProductMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Product record);

    int insertSelective(Product record);

    Product selectByPrimaryKey(Integer id);

    /**
     3级id看有没有商品
     */
    List<Product> selectLv3(Integer icategoryLevel3Id);

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

    /**
     * 根据三级分类的id去查找对应的商品
     * @param id
     * @return
     */
    List<Product> selectByThreeId(Integer id) ;

    /**
     * 根据根据三级id查询对应条数
     * @param params
     * @return
     */
    int selectByTypeCount(Map<String,Object> params);

    /**
     * 根据条件进行分类查询
     * @param params
     * @return
     */
    List<Product> selectByType(Map<String,Object> params) ;

    /**
     * 根据二级分类id和三级分类id查询数量
     * @param pid
     * @param id
     * @return
     */
    int selectByPidAndId(@Param("pid") Integer pid,@Param("id") Integer id) ;

    /**
     * 根据库存数量查找热门款
     * @return
     */
    List<Product> selectByStock();

    /**
     * 根据价格查找最热卖商品
     * @return
     */
    List<Product> selectByPrice();


    /**
     * 根据一级id查询商品条数
     * @param params
     * @return
     */
    int selectByCategoryLevel1IdCount(Map<String, Object> params);

    /**
     * 根据一级id查询商品
     * @return
     */
    List<Product> selectByCategoryLevel1Id(Map<String, Object> params);

    /**
     * 根据名字查询数量
     * @param params
     * @return
     */
    int selectByNameCount(Map<String,Object> params);

    /**
     * 根据名字模糊查询商品，分页查询
     * @param params
     * @return
     */
    List<Product> selectByName(Map<String,Object> params);
}