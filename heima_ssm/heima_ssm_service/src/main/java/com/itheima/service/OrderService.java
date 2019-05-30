package com.itheima.service;

import com.itheima.domain.Orders;
import org.springframework.stereotype.Service;

import java.util.List;



public interface OrderService {


    public List<Orders> finAll(int page,int pageSize,String sth)throws Exception;

    Orders findByNum(String num)throws Exception;


}
