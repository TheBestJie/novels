package com.lj.novels.service;

import com.lj.novels.daomain.Comment;

import java.util.List;

public interface CommentService {

    List<Comment> selectCommentLimit();

    List<Comment> selectCommentByXsbh(Integer xsbh);

    void deleteCommentByPlbh(Integer plbh);

    void insertComment(Comment comment);

}
