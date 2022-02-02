package com.lj.novels.controller;

import com.lj.novels.daomain.Book;
import com.lj.novels.daomain.Page;
import com.lj.novels.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * 页面响应类
 */
@Controller
public class PageController {

    @Autowired
    private BookService bookService;

    /**
     * 返回小说网站主页面
     * @return
     */
    @GetMapping("/bookMain")
    public ModelAndView bookMain(){
        ModelAndView mav = new ModelAndView() ;
        List<Book> bookList = bookService.findBookByLimit(1, "");
        Integer allPage = bookService.allPage("") ;
        Page page = new Page(1,allPage,"",bookList) ;
//        mav.addObject("bookList", bookList) ;
//        mav.addObject("bookName","") ;
//        mav.addObject("nowPage",1) ;
//        mav.addObject("pageLength",allPage) ;

        mav.addObject("page",page) ;

        mav.setViewName("bookMain");
        return mav ;
    }

    //返回登录页
    @GetMapping("/login")
    public String login(){
        return "login";
    }

}
