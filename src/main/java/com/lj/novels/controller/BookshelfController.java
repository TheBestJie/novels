package com.lj.novels.controller;

import com.lj.novels.daomain.Book;
import com.lj.novels.daomain.Bookshelf;
import com.lj.novels.daomain.User;
import com.lj.novels.service.BookshelfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class BookshelfController {

    @Autowired
    private BookshelfService bookshelfService;

    @Autowired
    private RedisTemplate<String,Object> template;

    //我的书架展示
    @GetMapping("/myBooks")
    public ModelAndView myBooks(HttpSession session){
        ModelAndView mav = new ModelAndView() ;
        List<Book> bookList = bookshelfService.selectBookByYhbh(((User) session.getAttribute("user")).getYhbh());
        mav.addObject("books",bookList) ;
        mav.setViewName("bookshelf");
        return mav;
    }

    //添加到我的书架功能
    @GetMapping("/addBook")
    @ResponseBody
    public String addBook(Integer xsbh,HttpSession session){
        //redis缓存存储
        if(template.opsForZSet().score("book","book_"+xsbh) == null){
            template.opsForZSet().add("book","book_"+xsbh,1) ;
        }else {
            template.opsForZSet().incrementScore("book","book_"+xsbh,1);
        }
        bookshelfService.insertBookshelf(new Bookshelf(null,((User)session.getAttribute("user")).getYhbh(), xsbh));
        return "on" ;
    }

    //移除我的书架
    @GetMapping("/deleteBook")
    @ResponseBody
    public String deleteBook(Integer xsbh, HttpSession session){
        Double score = template.opsForZSet().score("book", "book_" + xsbh);
        if(score != null){
            template.opsForZSet().add("book","book_"+xsbh,score-1);
        }
        bookshelfService.deleteBookshelf(new Bookshelf(null,((User)session.getAttribute("user")).getYhbh(), xsbh));
        return "on" ;
    }

}
