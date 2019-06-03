package com.itheima.dao;

import com.itheima.domain.Traveller;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author zb
 * @description
 * @date 2019/5/26
 */
public interface TravellerDao {


    @Select("select t.* from order_traveller ot,traveller t where ot.travellerid=t.id and ot.orderid=#{orderId}")
    public List<Traveller> findByOid(String orderId)throws Exception;

    @Insert("insert into traveller (name,sex,phoneNum,credentialsType,credentialsNum,travellerType) values (#{name},#{sex},#{phoneNum},#{credentialsType},#{credentialsNum},#{travellerType})")
    void saveTraveller(Traveller traveller)throws Exception;

    @Select("select id from traveller where name=#{name}")
    String findTid(String name)throws Exception;

    @Update("update traveller set sex=#{sex},phoneNum=#{phoneNum},credentialsType=#{credentialsType},credentialsNum=#{credentialsNum},travellerType=#{travellerType} where name=#{name}")
    void updateTraveller(Traveller traveller);

}
