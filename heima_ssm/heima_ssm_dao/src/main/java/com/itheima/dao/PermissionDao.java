package com.itheima.dao;

import com.itheima.domain.Permission;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PermissionDao {



    @Select("select p.* from role_permission rp ,permission p where rp.permissionid=p.id and  rp.roleid=#{rid}")
    List<Permission> findByRid(String rid);
}
