package com.itheima.service.impl;

import com.github.pagehelper.PageHelper;
import com.itheima.dao.*;
import com.itheima.domain.Orders;
import com.itheima.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zb
 * @description
 * @date 2019/5/26
 */

@Service
public class OrderServiceImpl implements OrderService {



    @Autowired
    private OrderDao orderDao;


    @Override
    public List<Orders> finAll(int page, int pageSize,String sth) throws Exception{
        Orders orders=new Orders();
        if (sth!=null&&sth.length()>0){
            orders.setId("%"+sth+"%");
            orders.setOrderNum("%"+sth+"%");
        }
        PageHelper.startPage(page,pageSize);
        return orderDao.findAll(orders) ;
    }

    @Override
    public Orders findByNum(String num)throws Exception {

        return orderDao.fundById(num);
    }

    @Override
    public List<Orders> findOrdersByPid(String id) throws Exception {
        return orderDao.findByPid(id);
    }

    @Override
    public void deleteIds(String[] ids) throws Exception {
            if (ids!=null&&ids.length>0){
                for (String id : ids) {
                    deleteById(id);
                }
     }
    }


    @Override
    public void saveOrders(Orders order) throws Exception {

    }

    @Override
    public void updateOrders(Orders order) throws Exception {

    }

    @Override
    public void deleteById(String id) throws Exception {


        orderDao.deleteRoleWithTraveller(id);

        orderDao.deleteByid(id);
    }


}
