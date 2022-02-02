package com.lj.novels.service;

import com.lj.novels.daomain.Book;
import com.lj.novels.daomain.BookDesc;

import java.util.List;

public interface BookService {

    List<Book> findBookByLimit(Integer page, String bookName);

    Integer allPage(String bookName);

    Book selectBookByXsbh(Integer xsbh) ;

    BookDesc findBookDescByXsbh(Integer yhbh, Integer xsbh);
}
