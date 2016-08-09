package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Library {
    private List<Book> bookList;
    private List<Menu> menuList;

    private InputStreamReader input = new InputStreamReader(System.in);
    private BufferedReader bufferedReader = new BufferedReader(input);

    public Library(BufferedReader bufferedReader) {
        this.bufferedReader = bufferedReader;
        this.bookList = Book.initialBookList();
        this.menuList = Menu.InitialMenuList();
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    public void start() throws IOException {
        printWelcomeMessage();
        printBookList();
        choiceMenu();
    }


    public static void printWelcomeMessage() {
        System.out.println("Welcome to The Bangalore Public Library, Enjoy you journey!");
    }

    public void printBookList() {
        System.out.println("======= Book List =======");
        for (Book book : bookList) {
            if (book.getIsCheckout()) {
                System.out.println(book.getBookId() + " | "
                        + "name:" + book.getBookName() + " | "
                        + "author:" + book.getAuthor() + " | "
                        + "published:" + book.getYearPublished());
            }
        }
    }

    public void showMenuList() {
        System.out.println("======= Menu List =======");
        for (Menu menu : menuList) {
            System.out.println("== "+ menu.getMenuId() + " -- " + menu.getMenuName());
        }
        System.out.println("=========================");
        System.out.print("Select on Option about Menu:");
    }

    public void choiceMenu() throws IOException {
        int choiceIndex;
        do {
            showMenuList();
            choiceIndex = getChoiceIndex();
            selectOptionFromIndex(choiceIndex);
        } while (choiceIndex != 4);
        System.out.println("MESSAGE: You have Quit the Library!");
    }

    public void selectOptionFromIndex(int index) throws IOException {
        switch (index) {
            case 1: {
                printBookList();
                break;
            }
            case 2: {
                getBookStatue(true);
                break;
            }
            case 3: {
                getBookStatue(false);
                break;
            }
            case 4: {
                break;
            }
            default:{
                System.out.println("Error: "+ Menu.invalidMenuMessage);
            }
        }
    }

    private void getBookStatue(boolean isCheckout) throws IOException {
        System.out.print("Please Input the (Number) of Book that You Want to Checkout(Return):");
        int bookId = getChoiceIndex();
        String message;
        if (isCheckout) {
            message = checkBooksById(bookId, isCheckout) ? "MESSAGE: Thank you! Enjoy the book!" : "ERROR: That book is not available.";
        } else {
            message = checkBooksById(bookId, isCheckout) ? "MESSAGE: Thank you for returning the book." : "ERROR: That is not a valid book to return.";
        }
        System.out.println(message);
    }

    private boolean checkBooksById(int bookId, boolean isCheckout) {
        for (Book book : bookList) {
            if (book.getBookId() == bookId) {
                boolean isSuccess = isCheckout ? book.getIsCheckout() : !book.getIsCheckout();
                book.setIsCheckOut(!isCheckout);
                return isSuccess;
            }
        }
        return false;
    }

    public int getChoiceIndex() throws IOException {
        String choiceIndex = bufferedReader.readLine();
        return Integer.parseInt(choiceIndex);
    }
}
