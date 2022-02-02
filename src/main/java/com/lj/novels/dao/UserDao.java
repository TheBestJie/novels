package com.lj.novels.dao;

import com.lj.novels.daomain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserDao {


    @Select("select * from n_user where yhzh = #{yhzh}")
    User selectUserByYhzh(String yhzh) ;

    @Select("select * from n_user where yhbh = #{yhbh}")
    User selectUserByYhbh(Integer yhbh);

}
