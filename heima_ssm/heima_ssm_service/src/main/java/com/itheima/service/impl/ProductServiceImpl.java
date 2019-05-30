package com.itheima.service.impl;

import com.github.pagehelper.PageHelper;
import com.itheima.dao.OrderDao;
import com.itheima.dao.ProductDao;
import com.itheima.domain.Product;
import com.itheima.service.OrderService;
import com.itheima.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

/**
 * @author zb
 * @description
 * @date 2019/5/25
 */
@Service("productService")
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDao productDao;

    @Autowired
    private OrderDao orderDao;


    public List<Product> findAll(int page,int pageSize,String sth) throws Exception{
        Product product=new Product();
        if (sth!=null&&sth.length()>0){
            product.setProductName("%"+sth+"%");
            product.setProductDesc("%"+sth+"%");
        }
        PageHelper.startPage(page,pageSize);
        return productDao.findAll(product);
    }

    @Override
    public void saveProduct(Product product)throws Exception {
        productDao.save(product);
    }

    @Override
    public void deleteIds(String[] ids)throws Exception {
        for (String id : ids) {
            productDao.deleteById(id);
            orderDao.deleteByPid(id);
        }
    }

    @Override
    public void deleteOne(String id)throws Exception {
        productDao.deleteById(id);
    }


}
