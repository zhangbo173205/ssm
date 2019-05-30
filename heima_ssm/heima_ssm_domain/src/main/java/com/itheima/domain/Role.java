package com.itheima.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.util.List;

/**
 * @author zb
 * @description
 * 角色表
 * @date 2019/5/27
 */
@Getter
@Setter
@ToString
public class Role {

    private String id;
    private String roleName;
    private String roleDesc;
    private List<Permission> permissions;
    private List<UserInfo> users;
}
