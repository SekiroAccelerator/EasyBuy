package service;

import pojo.Product;

public interface ProductService {
    Product selectByPrimaryKey(Integer id);
}
