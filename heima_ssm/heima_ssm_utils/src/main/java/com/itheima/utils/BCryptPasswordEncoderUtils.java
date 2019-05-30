package com.itheima.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author zb
 * @description
 * @date 2019/5/29
 */
public class BCryptPasswordEncoderUtils {


    private static BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();


    public static String encodingPassword(String password) {
        return bCryptPasswordEncoder.encode(password);
    }

/*
    public static void main(String[] args) {
        String password="123";
        System.out.println(encodingPassword(password));
    }*/
}
