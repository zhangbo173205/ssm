package com.itheima.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author zb
 * @description
 * @date 2019/5/26
 */
@Setter
@Getter
@ToString
public class Member {

    private String id;        //id
    private String name;      //姓名
    private String nickname;  //小名
    private String phoneNum;  //电话
    private String email;     //邮箱
}
