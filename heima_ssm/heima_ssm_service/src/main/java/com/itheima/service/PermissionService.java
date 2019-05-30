package com.itheima.service;


import com.itheima.domain.Permission;

import java.util.List;

public interface PermissionService {

    List<Permission> findAll(int page, int pageSize, String sth) throws Exception;

    Permission findById(String id) throws Exception;

    void save(Permission p)throws Exception;

    void deleteById(String id) throws Exception;
}
