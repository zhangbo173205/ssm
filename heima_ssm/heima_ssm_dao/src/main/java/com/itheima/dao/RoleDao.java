package com.itheima.dao;

import com.itheima.domain.Role;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface RoleDao {


    @Select("select r.* from USERS_ROLE t, role r where t.roleid=r.id and t.userid=#{id}")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "roleName",column = "roleName"),
            @Result(property = "roleDesc",column = "roleDesc"),
            @Result(property = "permissions",column = "id",many = @Many(select = "com.itheima.dao.PermissionDao.findByRid"))
    })
    List<Role> findByUid(String id);

    @Delete("delete from role_permission where PermissionId=#{pid} and roleId=#{rid}")
    void deletePermissionWithRole(@Param("rid")String rid, @Param("pid") String pid) throws Exception;


    List<Role> findAll(Role role)throws Exception;

    @Select("select * from role where id=#{id}")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "roleName",column = "roleName"),
            @Result(property = "roleDesc",column = "roleDesc"),
            @Result(property = "users",column = "id",many = @Many(select = "com.itheima.dao.UserDao.findByRid")),
            @Result(property = "permissions",column = "id",many = @Many(select = "com.itheima.dao.PermissionDao.findByRid"))
    })
    Role findById(String id);

    @Insert("insert into role (roleName,roleDesc) values (#{roleName},#{roleDesc})")
    void save(Role role) throws Exception;
}
