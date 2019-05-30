package com.itheima.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * @author zb
 * @description 用户表
 * @date 2019/5/27
 */
@Setter
@Getter
@ToString
public class UserInfo {

    private String id;
    private String username;
    private String email;
    private String password;
    private String phoneNum;
    private Integer status;
    private String statusStr;
    private List<Role> roles;


    public String getStatusStr() {
        if (status != null) {
              if (status==0){
                  statusStr="未开启";
              }
            if (status==1){
                statusStr="已开启";
            }
        }
        return statusStr;
    }
}
