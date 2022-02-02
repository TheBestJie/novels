package com.lj.novels.daomain;

import java.util.List;

public class Page {
    private Integer nowPage ;
    private Integer maxPage ;
    private String searchContent ;
    private List<Book> bookList ;

    public Page() {
    }

    public Page(Integer nowPage, Integer maxPage, String searchContent, List<Book> bookList) {
        this.nowPage = nowPage;
        this.maxPage = maxPage;
        this.searchContent = searchContent;
        this.bookList = bookList;
    }

    public Integer getNowPage() {
        return nowPage;
    }

    public void setNowPage(Integer nowPage) {
        this.nowPage = nowPage;
    }

    public Integer getMaxPage() {
        return maxPage;
    }

    public void setMaxPage(Integer maxPage) {
        this.maxPage = maxPage;
    }

    public String getSearchContent() {
        return searchContent;
    }

    public void setSearchContent(String searchContent) {
        this.searchContent = searchContent;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }
}
