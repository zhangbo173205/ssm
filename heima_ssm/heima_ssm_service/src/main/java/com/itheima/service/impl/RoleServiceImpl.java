package com.itheima.service.impl;

import com.github.pagehelper.PageHelper;
import com.itheima.dao.RoleDao;
import com.itheima.dao.UserDao;
import com.itheima.domain.Role;
import com.itheima.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zb
 * @description
 * @date 2019/5/29
 */
@Service("roleService")
public class RoleServiceImpl implements  RoleService {

    @Autowired
    public RoleDao roleDao;

    @Autowired
    public UserDao userDao;


    @Override
    public void deletePermissionWithRole(String rid, String pid) throws Exception {
        //pid="%"+pid+"%";
        roleDao.deletePermissionWithRole(rid,pid);
    }

    @Override
    public List<Role> findAll(int page, int pageSize, String sth) throws Exception {
        Role role=new Role();
        if(sth!=null){
            role.setRoleName("%"+sth+"%");
            role.setRoleDesc("%"+sth+"%");
        }
        PageHelper.startPage(page,pageSize);

        return roleDao.findAll(role);
    }

    @Override
    public Role findById(String id) throws Exception {
        return roleDao.findById(id);
    }

    @Override
    public void save(Role role) throws Exception {
        roleDao.save(role);
    }

    @Override
    public void deleteById(String id)throws Exception {
        roleDao.deletePermissionWithRole(id,null);
        userDao.deleteRoleByUid(id,null);
        roleDao.deleteById(id);
    }
}
