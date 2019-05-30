package com.itheima.dao;


import com.itheima.domain.UserInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.security.core.parameters.P;

import java.util.List;

/**
 * @author zb
 * @description
 * @date 2019/5/27
 */
public interface UserDao {


    @Select("select * from users where username=#{username}")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "username",column = "username"),
            @Result(property = "email",column = "email"),
            @Result(property = "password",column = "password"),
            @Result(property = "phoneNum",column = "phoneNum"),
            @Result(property = "status",column = "status"),
            @Result(property = "roles",column = "id",many = @Many(select = "com.itheima.dao.RoleDao.findByUid"))
    })
     public UserInfo findByUserName(String username) throws Exception;

    List<UserInfo> findAll(UserInfo userInfo) throws Exception;

    @Insert("insert into users (email,username,password,phoneNum,status) values (#{email},#{username},#{password},#{phoneNum},#{status})")
    void save(UserInfo userInfo) throws Exception;

    @Select("select * from users where id=#{id}")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "username",column = "username"),
            @Result(property = "email",column = "email"),
            @Result(property = "password",column = "password"),
            @Result(property = "phoneNum",column = "phoneNum"),
            @Result(property = "status",column = "status"),
            @Result(property = "roles",column = "id",many = @Many(select = "com.itheima.dao.RoleDao.findByUid"))
    })
    UserInfo findById(String id) throws Exception;


    void deleteRoleByUid(@Param("rid") String rid, @Param("uid")String uid) throws Exception;

    @Delete("delete from users where id=#{id}")
    void deleteById(String id) throws Exception;

    @Update("update users set status=#{status} where id=#{id}")
    void update(UserInfo userInfo);


    @Select("select u.*  from users_role ur ,users u where ur.userid=u.id and ur.roleid=#{rid}")
    List<UserInfo> findByRid(String rid);
}
