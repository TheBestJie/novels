package com.lj.novels.controller;

import com.lj.novels.daomain.Book;
import com.lj.novels.daomain.BookDesc;
import com.lj.novels.daomain.Page;
import com.lj.novels.daomain.User;
import com.lj.novels.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    //首页展示
    @GetMapping("/page")
    public ModelAndView nextPage(String xsmc, Integer nowPage){
        ModelAndView mav = new ModelAndView() ;
        Integer allPage = bookService.allPage(xsmc) ;
        if(nowPage < 1){
            nowPage = 1 ;
        }
        if(nowPage >= allPage){
            nowPage = allPage ;
        }
        List<Book> bookList = bookService.findBookByLimit(nowPage, xsmc);

        Page page = new Page(nowPage, allPage, xsmc, bookList) ;
        mav.addObject("page", page) ;

//        mav.addObject("bookList", bookList) ;
//        mav.addObject("bookName",xsmc) ;
//        mav.addObject("nowPage",nowPage) ;
//        mav.addObject("pageLength",allPage) ;

        mav.setViewName("bookMain");
        return mav ;
    }

    //搜索内容展示
    @PostMapping("/search")
    public ModelAndView search(String bookName){
        ModelAndView mav = new ModelAndView() ;
        Integer allPage = bookService.allPage(bookName) ;
        List<Book> bookList = bookService.findBookByLimit(1, bookName);
        Page page = new Page(1,allPage,bookName,bookList) ;
        mav.addObject("page",page) ;
        mav.setViewName("bookMain");
        return mav ;
    }

    //小说详情
    @GetMapping("/bookDesc")
    public ModelAndView bookDesc(@RequestParam("xsbh") Integer xsbh, HttpSession session){
        ModelAndView mav = new ModelAndView() ;
        BookDesc bookDesc = bookService.findBookDescByXsbh(((User)session.getAttribute("user")).getYhbh(),xsbh);
        mav.addObject("bookDesc",bookDesc) ;
        mav.setViewName("bookDesc");
        return mav ;
    }

    //小说目录
    @GetMapping("/read")
    public String read(Integer xsbh,Model model){
        String ml = "books/" + xsbh + "/目录" ;
        model.addAttribute("bookContent",ml);
        return "read";
    }

    //小说具体章节显示
    @GetMapping("/readBook")
    public ModelAndView readBook(Integer xsbh, Integer xszj){
//        ClassPathResource pathResource = new ClassPathResource("templates/books/" + xsbh + "/book/");
        InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("templates/books/" + xsbh + "/book/" + xszj + ".html") ;
        if(inputStream == null){
            xszj = 1 ;
        }
        String ml = "books/" + xsbh + "/book/" + xszj ;
        ModelAndView mav = new ModelAndView();
        mav.addObject("bookNr",ml) ;
        mav.addObject("xsbh",xsbh) ;
        mav.addObject("xszj",xszj) ;
        mav.setViewName("readBook");
        return mav ;
    }
}
