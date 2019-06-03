package com.itheima.dao;

import com.itheima.domain.Member;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;


/**
 * @author zb
 * @description
 * @date 2019/5/26
 */
public interface MemberDao {




    @Select("select * from member where id=#{id}")
    Member findById(String id) throws Exception;

    @Select("select id from member where name=#{name}")
    String findId(String name)throws Exception;

    @Insert("insert into member (name,nickname,phoneNum,email) values (#{name},#{nickname},#{phoneNum},#{email})")
    void saveMember(Member member)throws Exception;

    @Update("update member set name=#{name},phoneNum=#{phoneNum},email=#{email} where nickname=#{nickname}")
    void updateMember(Member member)throws Exception;

    @Select("select id from member where nickname=#{nickname} ")
    String findIdBynickname(String nickname) throws Exception;
}
