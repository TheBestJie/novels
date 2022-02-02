package com.lj.novels.controller;

import com.lj.novels.daomain.Comment;
import com.lj.novels.daomain.User;
import com.lj.novels.service.CommentService;
import com.lj.novels.util.EmojiUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import javax.xml.crypto.Data;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class CommentController {

    @Autowired
    private CommentService commentService;

    //删除评论
    @GetMapping("/deleteComment")
    @ResponseBody
    public String deleteComment(@RequestParam("plbh") Integer plbh){
        commentService.deleteCommentByPlbh(plbh);
        return "on" ;
    }

    //添加评论
    @GetMapping("/comment")
    @ResponseBody
    public String comment(String plnr, Integer xsbh, HttpSession session) throws UnsupportedEncodingException {
        plnr = EmojiUtil.emojiConvertToUtf(plnr);
        Date date = new Date() ;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm") ;
        String plsj = sdf.format(date);
        Integer yhbh = ((User)session.getAttribute("user")).getYhbh() ;
        Comment comment = new Comment(null,xsbh,yhbh,plsj,plnr);
        commentService.insertComment(comment);
        return "on" ;
    }
}
