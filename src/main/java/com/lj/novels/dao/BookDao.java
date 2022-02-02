package com.lj.novels.dao;

import com.lj.novels.daomain.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BookDao {

    @Select("select * from n_book where xsmc like concat('%',#{bookName},'%') limit #{page},#{limit}")
    List<Book> selectBookByLimit(Integer page, Integer limit, String bookName);

    @Select("select count(*) from n_book where xsmc like concat('%',#{bookName},'%')")
    Integer bookLength(String bookName);

    @Select("select * from n_book where xsbh = #{xsbh}")
    Book selectBookByXsbh(Integer xsbh) ;

}
