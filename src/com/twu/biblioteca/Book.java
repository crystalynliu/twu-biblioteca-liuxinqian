package com.twu.biblioteca;

public class Book {
    private int bookId;
    private String bookName;
    private String author;
    private String yearPublished;

    public Book(int bookId, String bookName, String author, String yearPublished){
        this.bookId = bookId;
        this.bookName = bookName;
        this.author = author;
        this.yearPublished = yearPublished;
    }

    public int getBookId(){
        return this.bookId;
    }

    public void setBookId(int bookId){
        this.bookId = bookId;
    }

    public String getBookName(){
        return this.bookName;
    }

    public void setBookName(String bookName){
        this.bookName = bookName;
    }

    public String getAuthor(){
        return this.author;
    }

    public void setAuthor(String author){
        this.author = author;
    }

    public String getYearPublished(){
        return this.yearPublished;
    }

    public void setYearPublished(String yearPublished){
        this.yearPublished = yearPublished;
    }
}
