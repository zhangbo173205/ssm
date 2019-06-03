package com.itheima.service.impl;


import com.github.pagehelper.PageHelper;
import com.itheima.dao.SysLogDao;
import com.itheima.domain.SysLog;
import com.itheima.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zb
 * @description
 * @date 2019/5/31
 */
@Service("sysLogService")
public class SysLogServiceImpl implements SysLogService {

    @Autowired
    public SysLogDao sysLogDao;

    @Override
    public void save(SysLog sysLog) throws Exception {
        sysLogDao.save(sysLog);
    }

    @Override
    public List<SysLog> findAll(int page, int pageSize, String sth) throws Exception {
        SysLog sysLog=new SysLog();
        if (sth!=null&&sth.length()>0){
            sysLog.setMethod("%"+sth+"%");
            sysLog.setUsername("%"+sth+"%");
        }
        PageHelper.startPage(page,pageSize);
        return sysLogDao.findAll(sysLog);
    }

    @Override
    public void deleteIds(String[] ids) throws Exception {
        if (ids!=null&&ids.length>0){
            for (String id : ids) {
                sysLogDao.delete(id);
            }
        }
    }

    @Override
    public void deleteAll() throws Exception {
          sysLogDao.deleteAll();
    }
}
