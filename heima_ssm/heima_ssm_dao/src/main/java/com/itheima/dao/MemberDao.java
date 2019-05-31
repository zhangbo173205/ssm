package com.itheima.dao;

import com.itheima.domain.Member;
import org.apache.ibatis.annotations.Select;


/**
 * @author zb
 * @description
 * @date 2019/5/26
 */
public interface MemberDao {




    @Select("select * from member where id=#{id}")
    Member findById(String id) throws Exception;
}
