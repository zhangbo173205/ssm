package com.itheima.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author zb
 * @description
 * 日期转化
 * @date 2019/5/25
 */
public class DateUtils {

    private static SimpleDateFormat sd=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    //日期转换为字符
    public static String date2String(Date date){
        return sd.format(date);
    }


    //字符转日期
    public static Date str2Date(String str){
        try {
            return sd.parse(str);
        } catch (ParseException e) {
            throw  new RuntimeException(e);
        }
    }
}
