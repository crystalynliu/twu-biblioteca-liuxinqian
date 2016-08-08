package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class handleBookTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    Library Library = new Library();
    private List<Book> books = new ArrayList<Book>();
    private List<Menu> menus = new ArrayList<Menu>();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        books.add(new Book(1, "Harry Potter and the Sorcerer's Stone", "Rowling", "1997"));
        books.add(new Book(2, "Charlie and the Chocolate Factory", "Dahl", "1964"));

        menus.add(new Menu(1, "LIST BOOKS"));
        menus.add(new Menu(2, "CHOCK OUT BOOK"));
        menus.add(new Menu(3, "RETURN BOOK"));
        menus.add(new Menu(4, "QUIT"));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }

    @Test
    public void print_correct_welcome_message_when_start() {
        String expectation = "Welcome to The Bangalore Public Library, Enjoy you journey!\n";
        Library.printWelcomeMessage();
        assertEquals(expectation, outContent.toString());

    }

    @Test
    public void print_book_list_when_welcome_message_appear() {
        Library.printBookList(books);
        String expectation = "1 | name:Harry Potter and the Sorcerer's Stone | author:Rowling | published:1997\n"
                + "2 | name:Charlie and the Chocolate Factory | author:Dahl | published:1964\n";
        assertEquals(expectation, outContent.toString());
    }

    @Test
    public void print_Menu_list_when_choice_option() {
        Library.showMenuList(menus);
        String expectation = "======= Menu List =======\n"
                + "1 -- LIST BOOKS\n" + "2 -- CHOCK OUT BOOK\n"
                + "3 -- RETURN BOOK\n" + "4 -- QUIT\n"
                + "Select an Option about Menu:";
        assertEquals(expectation, outContent.toString());
    }
}
