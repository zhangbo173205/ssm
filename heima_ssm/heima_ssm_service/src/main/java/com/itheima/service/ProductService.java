package com.itheima.service;

import com.itheima.domain.Product;

import java.util.List;

public interface ProductService {

    List<Product> findAll(int page,int pageSize ,String sth)throws Exception;

    void saveProduct(Product product)throws Exception;

    void deleteIds(String[] ids)throws Exception;

    void deleteOne(String id)throws Exception;

    Product findByPnum(Product product)throws Exception;

    void updateStatusClose(String[] ids) throws Exception;

    void updateStatusOpen(String[] ids) throws Exception;

    Product findByPid(String id) throws Exception;

    void updateProduct(Product product) throws Exception;

    List<Product> findAllForOrder() throws Exception;

}
