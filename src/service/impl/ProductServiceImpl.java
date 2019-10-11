package service.impl;

import dao.ProductMapper;
import dao.Product_CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pojo.PageBean;
import pojo.Product;
import pojo.Product_Category;
import service.ProductService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("productService")
public class ProductServiceImpl implements ProductService {
    @Autowired
    @Qualifier("productMapper")
    private ProductMapper productMapper;

    @Autowired
    @Qualifier("product_CategoryMapper")
    private Product_CategoryMapper product_category ;

    @Override
    public Product selectByPrimaryKey(Integer id) {
        return productMapper.selectByPrimaryKey(id);
    }

    @Override
    public int count() {
        return productMapper.count();
    }

    @Override
    public List<Product> productList(Integer isDelete,PageBean pageBean) {
        return productMapper.productList(isDelete,pageBean);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return productMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(Product record) {
        return productMapper.insertSelective(record);
    }

    @Override
    public int updateByPrimaryKeySelective(Product record) {
        return productMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public List<Product> selectLv3(Integer icategoryLevel3Id) {
        return productMapper.selectLv3(icategoryLevel3Id);
    }

    //查询三级分类，根据collection 一对多 映射来查询
    @Override
    public List<Product_Category> selectByType() {
        return product_category.selectByType() ;
    }

    //查询二级分类下面的所有三级分类以及数量
    @Override
    public Map<String, Object> selectByPidAndId(Integer pid , Integer id) {
        Map<String,Object> map = new HashMap<String,Object>() ;
        List<Integer> categoryLevel3Id = new ArrayList<Integer>() ;
        List<Product_Category> list = product_category.selectByPid(pid) ;
        //拿到所有的三级分类的id放入集合中
        for(Product_Category product :list){
            categoryLevel3Id.add(product.getId());
        }
        //存放数量的集合
        List<Integer> count = new ArrayList<Integer>() ;
        for(int i=0;i<categoryLevel3Id.size();i++){
            id = categoryLevel3Id.get(i) ;
            count.add(productMapper.selectByPidAndId(pid,id));
        }
        map.put("product_category",list) ;
        map.put("count",count) ;
        return map ;
    }
}
