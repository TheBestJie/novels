package com.lj.novels.daomain;

import java.util.List;

public class BookDesc {

    private Book book ;
    private Bookshelf bookshelf;
    private List<UserComment> userComments ;

    public BookDesc() {
    }

    public BookDesc(Book book, Bookshelf bookshelf, List<UserComment> userComments) {
        this.book = book;
        this.bookshelf = bookshelf;
        this.userComments = userComments;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Bookshelf getBookshelf() {
        return bookshelf;
    }

    public void setBookshelf(Bookshelf bookshelf) {
        this.bookshelf = bookshelf;
    }

    public List<UserComment> getUserComments() {
        return userComments;
    }

    public void setUserComments(List<UserComment> userComments) {
        this.userComments = userComments;
    }
}
