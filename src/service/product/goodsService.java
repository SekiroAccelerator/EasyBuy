package service.product;

import pojo.Product;
import utils.Pages;

import java.util.List;
import java.util.Map;

public interface goodsService {

    /**
     * 根据三级分类的id去查找对应的商品
     * @param id
     * @return
     */
    List<Product> selectByThreeId(Integer id) ;

    /**
     * 根据条件进行分页查询
     * @param params
     * @param pages
     * @return
     */
    Pages<Product> selectByType(Map<String, Object> params, Pages<Product> pages) ;

    /**
     * 根据库存数量查询热门款
     * @return
     */
    List<Product> selectByStock();

    /**
     * 根据价格查询热卖商品
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
    Pages<Product> selectByCategoryLevel1Id(Map<String, Object> params, Pages<Product> pages);

    /**
     * 根据名字模糊查询商品
     * @param params
     * @param pages
     * @return
     */
    Pages<Product> selectByName(Map<String, Object> params, Pages<Product> pages);

}
