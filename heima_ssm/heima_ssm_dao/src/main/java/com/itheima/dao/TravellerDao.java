package com.itheima.dao;

import com.itheima.domain.Traveller;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author zb
 * @description
 * @date 2019/5/26
 */
public interface TravellerDao {


    @Select("select t.* from order_traveller ot,traveller t where ot.travellerid=t.id and ot.orderid=#{orderId}")
    public List<Traveller> findByOid(String orderId)throws Exception;
}
