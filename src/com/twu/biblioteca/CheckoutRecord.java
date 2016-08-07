package com.twu.biblioteca;

public class CheckoutRecord {
    private int recordId;
    private Book book;
    private String checkoutSuccess = "Thank you! Enjoy the book";
    private String checkoutUnsuccess = "That book is not available.";
    private String returnSuccess = "Thank you for returning the book.";
    private String returnUnSuccess = "That is not a valid book to return.";

    public CheckoutRecord(int recordId, Book book){
        this.recordId = recordId;
        this.book = book;
    }

    public int getRecordId(){
        return this.recordId;
    }

    public void setRecordId(int recordId){
        this.recordId = recordId;
    }

    public Book getBook(){
        return this.book;
    }

    public void setBook(Book book){
        this.book = book;
    }
}
