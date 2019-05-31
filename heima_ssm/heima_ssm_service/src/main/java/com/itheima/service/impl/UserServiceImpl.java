package com.itheima.service.impl;

import com.github.pagehelper.PageHelper;
import com.itheima.dao.UserDao;
import com.itheima.domain.Role;
import com.itheima.domain.UserInfo;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


/**
 * @author zb
 * @description
 * @date 2019/5/27
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    public UserDao userDao;
    @Resource(name = "passwordEncoder")
    public BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo=null;
        try {
             userInfo=userDao.findByUserName(username);
         /*   BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            String encodedPassword = passwordEncoder.encode(userInfo.getPassword().trim());
            userInfo.setPassword(encodedPassword);*/
        } catch (Exception e) {
            e.printStackTrace();
        }
        //处理自己的UserInfo封装到user中交给springSecurity进行验证
        //User user=new User(userInfo.getUsername(),userInfo.getPassword(),getAuthority(userInfo.getRoles()));
        User user=new User(userInfo.getUsername(),userInfo.getPassword(),userInfo.getStatus()==0?false:true,true,true,true,getAuthority(userInfo.getRoles()));
        return user;

    }

    public List<SimpleGrantedAuthority> getAuthority(List<Role> roles){
        List<SimpleGrantedAuthority> list=new ArrayList<>();

        for (Role role : roles) {
            list.add(new SimpleGrantedAuthority("ROLE_"+role.getRoleName()));
        }
        list.add(new SimpleGrantedAuthority("ROLE_USER"));
        return list;
    }

    @Override
    public List<UserInfo> findAll(int page,int pageSize,String sth) throws Exception{
        UserInfo userinfo=new UserInfo();
        if(sth!=null&&sth.length()>0){
            userinfo.setId("%"+sth+"%");
            userinfo.setUsername("%"+sth+"%");
        }
        PageHelper.startPage(page,pageSize);
        return userDao.findAll(userinfo);
    }

    @Override
    public void save(UserInfo userInfo) throws Exception {
        String encodedPassword = bCryptPasswordEncoder.encode(userInfo.getPassword());
        userInfo.setPassword(encodedPassword);
        userDao.save(userInfo);
    }

    @Override
    public UserInfo findById(String id) throws Exception {
        return userDao.findById(id);
    }

    @Override
    public void deleteRoleByUid(String rid, String uid) throws Exception {
        userDao.deleteRoleByUid(rid,uid);
    }

    @Override
    public void updateStatus(String id)throws Exception {
        UserInfo userInfo= userDao.findById(id);
        userInfo.setStatus(Math.abs(userInfo.getStatus()-1));
        userDao.update(userInfo);
    }

    @Override
    public void deleteById(String id) throws Exception {
        userDao.deleteRoleByUid(null,id);
        userDao.deleteById(id);
    }

    @Override
    public List<Role> findOtherRole(String uid) throws Exception {

        return userDao.findOtherRole(uid);
    }

    @Override
    public void addRoleToUser(String uid, String[] ids) throws Exception {
        for (String rid : ids) {
            userDao.addRoleToUser(uid,rid);
        }
    }
}
