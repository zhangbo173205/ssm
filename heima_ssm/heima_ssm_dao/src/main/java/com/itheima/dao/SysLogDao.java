package com.itheima.dao;

import com.itheima.domain.SysLog;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;

import java.util.List;

/**
 * @author zb
 * @description
 * @date 2019/5/31
 */
public interface SysLogDao {

    @Insert("insert into syslog(visitTime,username,ip,url,executionTime,method) values" +
            "(#{visitTime},#{username},#{ip},#{url},#{executionTime},#{method})")
    void save(SysLog sysLog);

    List<SysLog> findAll(SysLog sysLog);

    @Delete("truncate table syslog")
    void deleteAll()throws Exception;

    @Delete("delete from syslog where id=#{id}")
    void delete(String id)throws Exception;
}
