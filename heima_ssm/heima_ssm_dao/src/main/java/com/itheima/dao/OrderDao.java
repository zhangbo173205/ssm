package com.itheima.dao;

import com.itheima.domain.Orders;
import org.apache.ibatis.annotations.*;
import org.springframework.core.annotation.Order;

import javax.naming.Name;
import java.util.List;



public interface OrderDao {


/*
    @Select("select * from orders")
    @Results(
            value = {
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "orderTime",column = "orderTime"),
            @Result(property = "peopleCount",column = "peopleCount"),
            @Result(property = "orderDesc",column = "orderDesc"),
            @Result(property = "payType",column = "payType"),
            @Result(property = "orderStatus",column = "orderStatus"),
            @Result(property = "product",column = "productId",one = @One(select = "com.itheima.dao.ProductDao.findById"))
    })*/
    public List<Orders> findAll(Orders orders) throws Exception;


    @Select("select * from orders where orderNum=#{orderNum}")
    @Results(
            value = {
                    @Result(id = true,property = "id",column = "id"),
                    @Result(property = "orderNum",column = "orderNum"),
                    @Result(property = "orderTime",column = "orderTime"),
                    @Result(property = "peopleCount",column = "peopleCount"),
                    @Result(property = "orderDesc",column = "orderDesc"),
                    @Result(property = "payType",column = "payType"),
                    @Result(property = "orderStatus",column = "orderStatus"),
                    @Result(property = "product",column = "productId",one = @One(select = "com.itheima.dao.ProductDao.findById")),
                    @Result(property = "member",column = "memberId",one = @One(select = "com.itheima.dao.MemberDao.findById")),
                    @Result(property = "travellers", column = "id", many=@Many(select = "com.itheima.dao.TravellerDao.findByOid"))
            }
    )
    public Orders fundById(String orderNum) throws Exception;

    @Delete("delete from orders where productid=#{pid}")
    public void deleteByPid(String pid) throws Exception;

    @Select("select * from orders where productId=#{id}")
    @Results(
            value = {
                    @Result(id = true,property = "id",column = "id"),
                    @Result(property = "orderNum",column = "orderNum"),
                    @Result(property = "orderTime",column = "orderTime"),
                    @Result(property = "peopleCount",column = "peopleCount"),
                    @Result(property = "orderDesc",column = "orderDesc"),
                    @Result(property = "payType",column = "payType"),
                    @Result(property = "orderStatus",column = "orderStatus"),
                    @Result(property = "product",column = "productId",one = @One(select = "com.itheima.dao.ProductDao.findById")),
                    @Result(property = "member",column = "memberId",one = @One(select = "com.itheima.dao.MemberDao.findById")),
                    @Result(property = "travellers", column = "id", many=@Many(select = "com.itheima.dao.TravellerDao.findByOid"))
            }
    )
    List<Orders> findByPid(String id) throws Exception;

    @Delete("delete from order_traveller where orderid=#{id} ")
    void deleteRoleWithTraveller(String id)throws Exception;

    @Delete("delete from orders where id=#{id}")
    void deleteByid(String id)throws Exception;

    @Insert("insert into orders (orderNum,orderTime,peopleCount,orderDesc,payType,orderStatus,productId,memberId) values (#{orderNum},#{orderTime},#{peopleCount},#{orderDesc},#{payType},#{orderStatus},#{product.id},#{member.id})")
    void saveOrder(Orders order)throws Exception;

    @Select("select id from orders where orderNum=#{orderNum}")
    String findId(String orderNum)throws Exception;

    @Insert("insert into order_traveller values(#{oid},#{tid})")
    void saveOrderWithTraveller(@Param("oid") String oid,@Param("tid") String tid)throws Exception;

    @Update("update orders set orderTime=#{orderTime},orderDesc=#{orderDesc},payType=#{payType},orderStatus=#{orderStatus},productId=#{product.id},memberId=#{member.id}")
    void update(Orders order);
}
