package com.itheima.service;

import com.itheima.domain.Permission;
import com.itheima.domain.Role;

import java.util.List;

public interface RoleService {


    void deletePermissionWithRole(String rid, String pid) throws Exception;

    List<Role> findAll(int page, int pageSize, String sth) throws Exception;

    Role findById(String id) throws Exception;

    void save(Role role)throws Exception;

    void deleteById(String id) throws Exception;

    void addPermissionToRole(String rid, String[] ids) throws Exception;

    List<Permission> findOtherPermission(String rid) throws Exception;
}
