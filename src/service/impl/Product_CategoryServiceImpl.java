package service.impl;

import dao.Product_CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pojo.Product_Category;
import service.Product_CategoryService;

import java.util.List;


@Service("product_CategoryService")
public class Product_CategoryServiceImpl implements Product_CategoryService {
    @Autowired
    @Qualifier("product_CategoryMapper")
    private Product_CategoryMapper mapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Product_Category record) {
        return mapper.insert(record);
    }

    @Override
    public int insertSelective(Product_Category record) {
        return mapper.insertSelective(record);
    }

    @Override
    public Product_Category selectByPrimaryKey(Integer id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Product_Category> selectCategoryByid(Integer id, Integer shuliang) {
        return mapper.selectCategoryByid(id, shuliang);
    }

    @Override
    public Integer oneByThree(Integer id) {
        return mapper.oneByThree(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Product_Category record) {
        return mapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Product_Category record) {
        return mapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Product_Category> type(Integer type) {
        return mapper.type(type);
    }

    @Override
    public List<Product_Category> typeSon(Integer parentId) {
        return mapper.typeSon(parentId);
    }
}
