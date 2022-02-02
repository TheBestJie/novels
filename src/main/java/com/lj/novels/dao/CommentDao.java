package com.lj.novels.dao;

import com.lj.novels.daomain.Comment;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CommentDao {

    @Select("select * from n_comment order by plbh desc limit 0,10")
    List<Comment> selectCommentLimit();

    @Select("select * from n_comment where xsbh = #{xsbh} order by plbh desc limit 0,10")
    List<Comment> selectCommentByXsbh(Integer xsbh);

    @Delete("delete from n_comment where plbh = #{plbh}")
    void deleteCommentByPlbh(Integer plbh);

    @Insert("insert into n_comment(xsbh,yhbh,plsj,plnr) values(#{xsbh},#{yhbh},#{plsj},#{plnr})")
    void insertComment(Comment comment);
}
