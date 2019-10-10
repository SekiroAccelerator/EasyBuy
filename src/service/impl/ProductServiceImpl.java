package service.impl;

import dao.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pojo.PageBean;
import pojo.Product;
import service.ProductService;

import java.util.List;

@Service("productService")
public class ProductServiceImpl implements ProductService {
    @Autowired
    @Qualifier("productMapper")
    private ProductMapper productMapper;
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
    public Product selectLv3(Integer icategoryLevel3Id) {
        return productMapper.selectLv3(icategoryLevel3Id);
    }
}
