package com.itheima.domain;

import com.itheima.utils.DateUtils;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * @author zb
 * @description
 * @date 2019/5/31
 */
@Setter
@Getter
@ToString
public class SysLog {

        private String id;
        private Date visitTime;
        private String visitTimeStr;
        private String username;
        private String ip;
        private String url;
        private Long executionTime;
        private String method;

    public String getVisitTimeStr() {
        if (visitTime!=null){
           visitTimeStr= DateUtils.date2String(visitTime);
        }
        return visitTimeStr;
    }
}
