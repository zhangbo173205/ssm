package com.itheima.service;

import com.itheima.domain.Product;

import java.util.List;

public interface ProductService {

    List<Product> findAll(int page,int pageSize ,String sth)throws Exception;

    void saveProduct(Product product)throws Exception;

    void deleteIds(String[] ids)throws Exception;

    void deleteOne(String id)throws Exception;
}
