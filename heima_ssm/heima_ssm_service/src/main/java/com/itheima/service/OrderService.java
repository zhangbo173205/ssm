package com.itheima.service;

import com.itheima.domain.Orders;


import java.util.List;



public interface OrderService {


    List<Orders> finAll(int page,int pageSize,String sth)throws Exception;

    Orders findByNum(String num)throws Exception;


    List<Orders> findOrdersByPid(String id) throws Exception;

    void deleteIds(String[] ids) throws Exception;


    void saveOrders(Orders order) throws Exception;

    void updateOrders(Orders order) throws Exception;

    void deleteById(String id) throws Exception;

}
