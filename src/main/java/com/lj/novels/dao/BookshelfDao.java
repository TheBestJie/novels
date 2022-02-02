package com.lj.novels.dao;

import com.lj.novels.daomain.Bookshelf;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BookshelfDao {

    @Select("select * from n_bookshelf where yhbh = #{yhbh}")
    List<Bookshelf> selectBookshelfByYhbh(Integer yhbh);

    @Select("select count(*) from n_bookshelf where yhbh = #{yhbh}")
    Integer selectLengthByYhbh(Integer yhbh);

    @Select("select * from n_bookshelf where yhbh = #{yhbh} and xsbh = #{xsbh}")
    Bookshelf selectBookshelfByYhbhAndXsbh(Integer yhbh, Integer xsbh);

    @Insert("insert into n_bookshelf(yhbh,xsbh) values(#{yhbh},#{xsbh})")
    void insertBookshelf(Bookshelf bookshelf);

    @Delete("delete from n_bookshelf where yhbh=#{yhbh} and xsbh=#{xsbh}")
    void deleteBookshelf(Bookshelf bookshelf);

}
