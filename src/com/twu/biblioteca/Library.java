package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Library {
    private List<Book> bookList = Book.initialBookList();
    private List<Menu> menuList = Menu.InitialMenuList();

    private InputStreamReader input = new InputStreamReader(System.in);
    private BufferedReader bufferedReader = new BufferedReader(input);

    public Library(BufferedReader bufferedReader){
        this.bufferedReader = bufferedReader;
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
}
