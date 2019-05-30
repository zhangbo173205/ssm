package com.itheima.dao;

import com.itheima.domain.Permission;
import com.sun.xml.internal.bind.v2.model.core.ID;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface PermissionDao {



    @Select("select p.* from role_permission rp ,permission p where rp.permissionid=p.id and  rp.roleid=#{rid}")
    List<Permission> findByRid(String rid) throws Exception;


    List<Permission> findAll(Permission p) throws Exception;

    @Select("select * from permission where id=#{id}")
    @Results({
            @Result(id=true,property ="id",column = "id"),
            @Result(property = "permissionName",column = "permissionName"),
            @Result(property = "url",column = "url"),
            @Result(property = "roles",column = "id",many = @Many(select = "com.itheima.dao.RoleDao.findRoleWithPermissionByPid")),
    })
    Permission findById(String id) throws Exception;

    @Insert("insert into permission (permissionName,url) values (#{permissionName},#{url})")
    void save(Permission p)throws Exception;

    @Delete("delete from permission where id=#{id}")
    void deleteById(String id);
}
