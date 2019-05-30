package com.itheima.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * @author zb
 * @description
 * 资源权限表
 * @date 2019/5/27
 */
@Setter
@Getter
@ToString
public class Permission {
    private String id;
    private String permissionName;
    private String url;
    private List<Role> roles;
}
