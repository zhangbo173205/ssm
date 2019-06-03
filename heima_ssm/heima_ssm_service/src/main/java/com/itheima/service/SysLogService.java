package com.itheima.service;

import com.itheima.domain.SysLog;

import java.util.List;

public interface SysLogService {
    void save(SysLog sysLog) throws Exception;

    List<SysLog> findAll(int page, int pageSize, String sth) throws Exception;

    void deleteIds(String[] ids) throws Exception;

    void deleteAll() throws Exception;
}
