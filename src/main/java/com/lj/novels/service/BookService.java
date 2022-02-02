package com.lj.novels.service;

import com.lj.novels.daomain.Book;
import com.lj.novels.daomain.BookDesc;

import java.util.List;
import java.util.Set;

public interface BookService {

    List<Book> findBookByLimit(Integer page, String bookName);

    Integer allPage(String bookName);

    Book selectBookByXsbh(Integer xsbh) ;

    BookDesc findBookDescByXsbh(Integer yhbh, Integer xsbh);

    public List<Book> rankings(Set<Object> bookId);
}
