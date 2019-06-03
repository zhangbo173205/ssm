package com.itheima.service.impl;

import com.github.pagehelper.PageHelper;
import com.itheima.dao.*;
import com.itheima.domain.Member;
import com.itheima.domain.Orders;
import com.itheima.domain.Product;
import com.itheima.domain.Traveller;
import com.itheima.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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


    @Autowired
    private MemberDao memberDao;
    @Autowired
    private TravellerDao travellerDao;


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
        Member member = order.getMember();
        String mid="";
        if (member!=null&&member.getName()!=null){
            memberDao.saveMember(member);
           mid= memberDao.findId(member.getName());
           member.setId(mid);
        }
        order.setMember(member);
        orderDao.saveOrder(order);
        List<Traveller> travellers = order.getTravellers();
        List<String> list=new ArrayList<>();

        String oid=orderDao.findId(order.getOrderNum());
        if (travellers!=null){
            for (Traveller traveller : travellers) {
                if (traveller.getName()!=null) {
                    travellerDao.saveTraveller(traveller);
                    String id = travellerDao.findTid(traveller.getName());
                    list.add(id);
                }
            }

        }
        for (String tid : list) {
            orderDao.saveOrderWithTraveller(oid,tid);
        }


    }

    @Override
    public void updateOrders(Orders order) throws Exception {
        Orders order1 = findByNum(order.getOrderNum());
        String mid="";
        Member member = order.getMember();

        if (member.getNickname().equals(order1.getMember().getNickname())){
            memberDao.updateMember(member);
            mid=memberDao.findId(order1.getMember().getName());
            member.setId(mid);
        }else{
            memberDao.saveMember(member);
            mid=memberDao.findIdBynickname(member.getNickname());
            member.setId(mid);
        }
        order.setMember(member);
        orderDao.update(order);
        List<Traveller> travellers = order.getTravellers();
        for (Traveller traveller : travellers) {
            if (traveller!=null){
                String tid = travellerDao.findTid(traveller.getName());
                if (tid!=null){
                    travellerDao.updateTraveller(traveller);
                }else{
                    travellerDao.saveTraveller(traveller);
                }
            }
        }
    }

    @Override
    public void deleteById(String id) throws Exception {


        orderDao.deleteRoleWithTraveller(id);

        orderDao.deleteByid(id);
    }


}
