package com.itheima.dao;


import com.itheima.domain.Product;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author zb
 * @description
 * @date 2019/5/25
 */
public interface ProductDao {


    /*@Select("select * from product")*/
    List<Product> findAll(Product product)throws Exception;

    @Insert("insert into product (productNum,productName,cityName,departureTime,productPrice,productDesc,productStatus) values" +
            " (#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    void save(Product product)throws Exception;


    @Select("select * from product Where id=#{id}")
    Product findById(String id)throws Exception;

    @Delete("delete from product where id=#{id}")
    void deleteById(String id)throws Exception;
}
