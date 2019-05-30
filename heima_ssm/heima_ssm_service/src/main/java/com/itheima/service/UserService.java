package com.itheima.service;


import com.itheima.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService{


    List<UserInfo> findAll(int page,int pageSize,String sth) throws Exception;

    void save(UserInfo userInfo) throws Exception;

    UserInfo findById(String id) throws Exception;

    void deleteRoleByUid(String rid, String uid) throws Exception;

    void updateStatus(String id) throws Exception;

    void deleteById(String id) throws Exception;
}
