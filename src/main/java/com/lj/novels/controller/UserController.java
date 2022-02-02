package com.lj.novels.controller;

import com.lj.novels.daomain.Book;
import com.lj.novels.daomain.Page;
import com.lj.novels.daomain.User;
import com.lj.novels.service.BookService;
import com.lj.novels.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UserController {


    @Autowired
    private UserService userService ;

    @Autowired
    private BookService bookService;


    //登录验证
    @PostMapping("/login")
    public ModelAndView login(@RequestParam("username") String username, @RequestParam("password") String password, HttpSession session){
        ModelAndView mav = new ModelAndView() ;
        User user = userService.findUserByUsername(username) ;
        if(user != null && user.getYhmm().equals(password)){
            List<Book> bookList = bookService.findBookByLimit(1, "");
            Integer allPage = bookService.allPage("") ;
            Page page = new Page(1,allPage,"",bookList) ;
            session.setAttribute("user",user);
            mav.addObject("page",page) ;
            mav.setViewName("bookMain");
        }

        return mav ;
    }

    //退出操作
    @GetMapping("/exit")
    public ModelAndView exit(HttpSession session){
        ModelAndView mav = new ModelAndView() ;
        session.setAttribute("user",null);
        List<Book> bookList = bookService.findBookByLimit(1, "");
        Integer allPage = bookService.allPage("") ;
        Page page = new Page(1,allPage,"",bookList) ;
        mav.addObject("page",page) ;
        mav.setViewName("bookMain");
        return mav ;
    }

}
