package com.lj.novels.service.impl;

import com.lj.novels.dao.BookDao;
import com.lj.novels.dao.BookshelfDao;
import com.lj.novels.daomain.Book;
import com.lj.novels.daomain.Bookshelf;
import com.lj.novels.service.BookshelfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookshelfServiceImpl implements BookshelfService {

    @Autowired
    private BookshelfDao bookshelfDao;

    @Autowired
    private BookDao bookDao;

    @Override
    public List<Book> selectBookByYhbh(Integer yhbh) {
        List<Bookshelf> bookshelfList = bookshelfDao.selectBookshelfByYhbh(yhbh);
        List<Book> bookList = new ArrayList<>() ;
        for (Bookshelf bookshelf : bookshelfList) {
            Book book = bookDao.selectBookByXsbh(bookshelf.getXsbh());
            bookList.add(book) ;
        }
        return bookList ;
    }

    @Override
    public void insertBookshelf(Bookshelf bookshelf) {
        bookshelfDao.insertBookshelf(bookshelf);
    }

    @Override
    public void deleteBookshelf(Bookshelf bookshelf) {
        bookshelfDao.deleteBookshelf(bookshelf);
    }
}
