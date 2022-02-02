package com.lj.novels.service.impl;

import com.lj.novels.dao.BookDao;
import com.lj.novels.dao.BookshelfDao;
import com.lj.novels.dao.CommentDao;
import com.lj.novels.dao.UserDao;
import com.lj.novels.daomain.*;
import com.lj.novels.service.BookService;
import com.lj.novels.util.EmojiUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    @Autowired
    private CommentDao commentDao;

    @Autowired
    private UserDao userDao ;

    @Autowired
    private BookshelfDao bookshelfDao;

    @Override
    public List<Book> findBookByLimit(Integer page, String bookName) {
        Integer _page = (page-1) * 5 ;
        return bookDao.selectBookByLimit(_page, 5, bookName) ;
    }

    @Override
    public Integer allPage(String bookName) {
        Integer bookLength = bookDao.bookLength(bookName) ;
        if(bookLength % 5 != 0){
            return (bookLength / 5 + 1) ;
        }
        return bookLength / 5;
    }

    @Override
    public Book selectBookByXsbh(Integer xsbh) {
        return bookDao.selectBookByXsbh(xsbh);
    }


    @Override
    public BookDesc findBookDescByXsbh(Integer yhbh, Integer xsbh) {
        Book book = bookDao.selectBookByXsbh(xsbh) ;
        Bookshelf bookshelf = bookshelfDao.selectBookshelfByYhbhAndXsbh(yhbh,xsbh) ;
        List<Comment> comments = commentDao.selectCommentByXsbh(xsbh);
        if(comments != null){
            List<UserComment> userComments = new ArrayList<>() ;
            for (Comment comment : comments) {
                User user = userDao.selectUserByYhbh(comment.getYhbh());
                UserComment userComment = new UserComment();
                userComment.setYhbh(user.getYhbh());
                userComment.setYhmc(user.getYhmc());
                userComment.setYhmm(user.getYhmm());
                userComment.setYhzh(user.getYhzh());
                userComment.setPlbh(comment.getPlbh());
                userComment.setPlsj(comment.getPlsj());
                try {
                    userComment.setPlnr(EmojiUtil.utfemojiRecovery(comment.getPlnr()));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                userComments.add(userComment) ;
            }
            return new BookDesc(book, bookshelf, userComments);
        }
        return new BookDesc(book, bookshelf, null) ;
    }

    @Override
    public List<Book> rankings(Set<Object> bookId){
        List<Book> books = new ArrayList<>() ;
        for (Object o : bookId) {
            books.add(bookDao.selectBookByXsbh(Integer.parseInt(((String)o).replace("book_","")))) ;
        }
        return books ;
    }


}
