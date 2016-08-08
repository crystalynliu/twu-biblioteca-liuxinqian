package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Book {
    private int bookId;
    private String bookName;
    private String author;
    private String yearPublished;

    public Book(){}

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

    public static List<Book> initialBookList(){
        List<Book> bookList = new ArrayList<Book>();
        bookList.add(new Book(1,"Harry Potter and the Sorcerer's Stone","Rowling","1997"));
        bookList.add(new Book(2,"Charlie and the Chocolate Factory","Dahl","1964"));
        bookList.add(new Book(3,"The Great Gatsby ","Fitzgerald","1925"));
        bookList.add(new Book(4,"The Old Man and the Sea","Hemingway","1952"));
        bookList.add(new Book(5,"The Catcher in the Rye","Salinger","1951"));

        return bookList;
    }

    public void printBookList(List<Book> bookList) {
        for(int i = 0; i < bookList.size(); i++){
            Book currentBook = bookList.get(i);
            System.out.println(currentBook.bookId + " | "
                    + "name:" + currentBook.bookName + " | "
                    + "author:" + currentBook.author + " | "
                    + "published:" + currentBook.yearPublished);
        }
    }
}
