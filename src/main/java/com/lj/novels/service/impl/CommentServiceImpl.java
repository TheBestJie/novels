package com.lj.novels.service.impl;

import com.lj.novels.dao.CommentDao;
import com.lj.novels.daomain.Comment;
import com.lj.novels.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentDao commentDao;


    @Override
    public List<Comment> selectCommentLimit() {
        return commentDao.selectCommentLimit();
    }

    @Override
    public List<Comment> selectCommentByXsbh(Integer xsbh) {
        return commentDao.selectCommentByXsbh(xsbh);
    }

    @Override
    public void deleteCommentByPlbh(Integer plbh) {
        commentDao.deleteCommentByPlbh(plbh);
    }

    @Override
    public void insertComment(Comment comment) {
        commentDao.insertComment(comment);
    }


}
