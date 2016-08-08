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

    public Library(BufferedReader bufferedReader){
        this.bufferedReader = bufferedReader;
        this.bookList = Book.initialBookList();
        this.menuList = Menu.InitialMenuList();
    }

    public List<Book> getBookList(){
        return bookList;
    }

    public void setBookList(List<Book> bookList){
        this.bookList = bookList;
    }


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

    public void showMenuList(List<Menu> menus) {
        System.out.println("======= Menu List =======");
        for(int i = 0; i < menus.size(); i++ ){
            Menu menu = menus.get(i);
            System.out.println(menu.getMenuId() + " -- " + menu.getMenuName());
        }
        System.out.print("Select on Option about Menu:");
    }

    public void choiceMenu() throws IOException {
        int choiceIndex;
        do{
            showMenuList(menuList);
            choiceIndex = getChoiceIndex();
        }while (choiceIndex != 4);
        System.out.println("You have Quit the Library!");
    }

    public int getChoiceIndex() throws IOException {
        String choiceIndex = bufferedReader.readLine();
        return Integer.parseInt(choiceIndex);
    }

    public void selectOptionFromIndex(int index) throws IOException {
        switch (index){
            case 1: {
                System.out.println("======= Book List =======");
                printBookList(bookList);
                break;
            }
            case 2: {
                System.out.print("please input the number about book:");
                int bookId = getChoiceIndex();
                String message = checkBooksById(bookId) ? "Thank you! Enjoy the book!" : "That book is not available.";
                System.out.println(message);
                break;
            }
        }
    }

    private boolean checkBooksById(int bookId) {
        for(Book book:bookList)
        {
            if(book.getBookId() == bookId){
                return book.getIsCheckout();
            }
        }
        return false;
    }
}
