package com.lj.novels.service;

import com.lj.novels.daomain.Book;
import com.lj.novels.daomain.Bookshelf;

import java.util.List;

public interface BookshelfService {

    List<Book> selectBookByYhbh(Integer yhbh);

    void insertBookshelf(Bookshelf bookshelf);

    void deleteBookshelf(Bookshelf bookshelf);

}
