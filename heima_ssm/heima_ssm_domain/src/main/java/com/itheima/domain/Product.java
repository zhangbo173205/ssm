package com.itheima.domain;


import com.itheima.utils.DateUtils;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


import java.util.Date;

/**
 * @author zb
 * @description
 * @date 2019/5/25
 */

@Setter
@Getter
@ToString
public class Product {
    private String id;
    private String productNum;
    private String productName;
    private String cityName;
    private Date departureTime;
    private String departureTimeStr;
    private double productPrice;
    private String productDesc;
    private Integer productStatus;
    private String productStatusStr;


    public String getDepartureTimeStr()  {
        if (departureTime!=null){
            departureTimeStr= DateUtils.date2String(departureTime);
        }
        return departureTimeStr;
    }
    public String getProductStatusStr() {
        if (productStatus!=null){
            if (productStatus==0){
                productStatusStr="关闭";
            }
            if (productStatus==1){
                productStatusStr="开启";
            }
        }
        return productStatusStr;
    }
}
