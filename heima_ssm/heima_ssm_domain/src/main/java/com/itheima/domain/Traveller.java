package com.itheima.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author zb
 * @description
 * 旅客表实体类
 * @date 2019/5/26
 */
@Setter
@Getter
@ToString
public class Traveller {

    private String id;         //id
    private String name;       //姓名
    private String sex;        //性别
    private String phoneNum;   //电话
    private Integer credentialsType;  //证件类型 0身份证 1护照 2军官证
    private String credentialsTypeStr;  //解释
    private String credentialsNum;   //证件号码
    private Integer travellerType;   //旅客类型(人群) 0 成人 1 儿童
    private String travellerTypeStr;  //解释


    public String getCredentialsTypeStr() {
        if(credentialsType!=null){
            if(credentialsType==0){
                credentialsTypeStr="身份证";
            }
            if(credentialsType==1){
                credentialsTypeStr="护照";
            }
            if(credentialsType==2){
                credentialsTypeStr="军官证";
            }
        }
        return credentialsTypeStr;
    }

    public String getTravellerTypeStr() {
        if(travellerType!=null){
            if (travellerType==0){
                travellerTypeStr="成人";
            }
            if (travellerType==1){
                travellerTypeStr="儿童";
            }
        }
        return travellerTypeStr;
    }
}
