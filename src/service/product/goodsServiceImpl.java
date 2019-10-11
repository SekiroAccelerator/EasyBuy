package service.product;

import dao.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pojo.Product;
import utils.Pages;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("goodsService")
public class goodsServiceImpl implements goodsService {

    @Autowired
    @Qualifier("productMapper")
    private ProductMapper productMapper ;


    /**
     * 根据三级分类的id去查找对应的商品
     * @param id
     * @return
     */
    @Override
    public List<Product> selectByThreeId(Integer id) {
        return productMapper.selectByThreeId(id);
    }

    /**
     * 根据条件进行分页查询
     * @param params
     * @param pages
     * @return
     */
    @Override
    public Pages<Product> selectByType(Map<String, Object> params, Pages<Product> pages) {
        if(!(params.containsKey("start") && params.containsKey("size"))){
            params.put("start",(pages.getPageNow() - 1) * pages.getPageSize());
            params.put("size",pages.getPageSize());
        }
        pages.setCount(productMapper.selectByTypeCount(params));
        pages.setPageCount(pages.getCount());
        pages.setList(productMapper.selectByType(params));
        return pages ;
    }

    /**
     * 根据库存数量查找热门款
     * @return
     */
    @Override
    public List<Product> selectByStock() {
        return productMapper.selectByStock() ;
    }

    /**
     * 根据价格查询热卖商品
     * @return
     */
    @Override
    public List<Product> selectByPrice() {
        return productMapper.selectByPrice() ;
    }

    /**
     * 根据一级id查询商品条数
     * @return
     */
    @Override
    public int selectByCategoryLevel1IdCount(Map<String, Object> params) {
        return productMapper.selectByCategoryLevel1IdCount(params);
    }


    /**
     * 根据一级id查询商品
     * @return
     */
    @Override
    public Pages<Product> selectByCategoryLevel1Id(Map<String, Object> params, Pages<Product> pages) {
        if(!(params.containsKey("start") && params.containsKey("size"))){
            params.put("start",(pages.getPageNow() - 1) * pages.getPageSize());
            params.put("size",pages.getPageSize());
        }
        pages.setCount(productMapper.selectByCategoryLevel1IdCount(params));
        pages.setPageCount(pages.getCount());
        pages.setList(productMapper.selectByCategoryLevel1Id(params));
        return pages ;
    }

    /**
     * 根据名字模糊查询商品
     * @param params
     * @param pages
     * @return
     */
    @Override
    public Pages<Product> selectByName (Map<String, Object> params, Pages<Product> pages) {
        if(!(params.containsKey("start") && params.containsKey("size"))){
            params.put("start",(pages.getPageNow() - 1) * pages.getPageSize());
            params.put("size",pages.getPageSize());
        }
        pages.setCount(productMapper.selectByNameCount(params));
        pages.setPageCount(pages.getCount());
        pages.setList(productMapper.selectByName(params));
        return pages ;
    }
}
