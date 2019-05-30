package com.itheima.utils;



import org.springframework.core.convert.converter.Converter;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author zb
 * @description
 * 把字符串传化为日期
 * @date 2019/5/18
 */
public class StringToDateConverter implements Converter<String,Date> {


    /**
     * string source 传入的字符串
     * @param source
     * @return
     */
    @Override
    public Date convert(String source){

        if (source==null){
            throw new RuntimeException("请传入数据");
        }

        try {
            Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(source);
            return date;
        } catch (Exception e) {
            throw new RuntimeException("数据类型转换异常");
        }
    }
}
