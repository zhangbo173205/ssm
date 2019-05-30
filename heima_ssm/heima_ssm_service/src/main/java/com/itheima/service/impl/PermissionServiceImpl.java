package com.itheima.service.impl;

import com.github.pagehelper.PageHelper;
import com.itheima.dao.PermissionDao;
import com.itheima.dao.RoleDao;
import com.itheima.domain.Permission;
import com.itheima.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zb
 * @description
 * @date 2019/5/30
 */
@Service("permissionService")
public class PermissionServiceImpl implements PermissionService{

    @Autowired
    public PermissionDao permissionDao;
    @Autowired
    public RoleDao roleDao;

    @Override
    public List<Permission> findAll(int page, int pageSize, String sth) throws Exception {
        Permission p=new Permission();
        if (sth!=null){
            p.setPermissionName("%"+sth+"%");
            p.setUrl("%"+sth+"%");
        }
        PageHelper.startPage(page,pageSize);
         return permissionDao.findAll(p);
    }

    @Override
    public Permission findById(String id) throws Exception {

        return permissionDao.findById(id);
    }

    @Override
    public void save(Permission p)throws Exception {
        permissionDao.save(p);
    }

    @Override
    public void deleteById(String id) throws Exception {
        roleDao.deletePermissionWithRole(null,id);
        permissionDao.deleteById(id);
    }
}
