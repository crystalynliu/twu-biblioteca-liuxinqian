package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> bookList = Book.initialBookList();
    private List<Menu> menuList = Menu.InitialMenuList();


    public static void printWelcomeMessage() {
        System.out.println("Welcome to The Bangalore Public Library, Enjoy you journey!");
    }

    public void printBookList(List<Book> bookList) {
        for(int i = 0; i < bookList.size(); i++){
            Book currentBook = bookList.get(i);
            System.out.println(currentBook.getBookId() + " | "
                    + "name:" + currentBook.getBookName() + " | "
                    + "author:" + currentBook.getAuthor() + " | "
                    + "published:" + currentBook.getYearPublished());
        }
    }
}
