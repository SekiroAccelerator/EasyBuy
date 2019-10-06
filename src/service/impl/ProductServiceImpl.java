package service.impl;

import dao.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pojo.Product;
import service.ProductService;
@Service("productService")
public class ProductServiceImpl implements ProductService {
    @Autowired
    @Qualifier("productMapper")
    private ProductMapper productMapper;
    @Override
    public Product selectByPrimaryKey(Integer id) {
        return productMapper.selectByPrimaryKey(id);
    }
}
