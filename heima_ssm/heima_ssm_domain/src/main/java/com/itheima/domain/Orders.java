package com.itheima.domain;

import com.itheima.utils.DateUtils;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.List;

/**
 * @author zb
 * @description 订单实体类
 * @date 2019/5/26
 */
@Setter
@Getter
@ToString
public class Orders {

    private String id;         //id
    private String orderNum;   //订单编号
    private Date orderTime;    //下单时间
    private String orderTimeStr;
    private Integer orderStatus;  //订单状态(0 未支付 1 已支付)
    private String orderStatusStr;
    private int peopleCount;  //出行人数
    private Product product;   //商品
    private List<Traveller> travellers; //旅客
    private Member member;            //会员
    private Integer payType;          //支付方式
    private String payTypeStr;        //支付方式(0 支付宝 1 微信 2其它)
    private String orderDesc;          //订单描述


    public String getOrderTimeStr(){
        if(orderTime!=null){
            orderTimeStr= DateUtils.date2String(orderTime);
        }
        return orderTimeStr;
    }

    public String getOrderStatusStr() {

        if (orderStatus!=null){
            if (orderStatus==0){
                orderStatusStr="未支付";
            }
            if (orderStatus==1){
                orderStatusStr="已支付";
            }
        }
        return orderStatusStr;
    }

    public String getPayTypeStr() {
        if (payType!=null){
            if (payType==0){
                payTypeStr="支付宝";
            }
            if (payType==1){
                payTypeStr="微信";
            }
            if (payType==2){
                payTypeStr="其他";
            }
        }
        return payTypeStr;
    }

}
