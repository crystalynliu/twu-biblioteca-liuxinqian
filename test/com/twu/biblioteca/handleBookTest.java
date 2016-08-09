package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.*;

public class handleBookTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    BufferedReader mockBufferedReader = mock(BufferedReader.class);
    private Library library = new Library(mockBufferedReader);
    private List<Book> books = new ArrayList<Book>();
    private List<Menu> menus = new ArrayList<Menu>();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        books.add(new Book(1, "Harry Potter and the Sorcerer's Stone", "Rowling", "1997"));
        books.add(new Book(2, "Charlie and the Chocolate Factory", "Dahl", "1964"));
        library.setBookList(books);

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
    public void print_book_list_that_book_is_available() {
        library.getBookList().get(0).setIsCheckOut(false);
        library.printBookList();
        String expectation = "======= Book List =======\n"
                + "2 | name:Charlie and the Chocolate Factory | author:Dahl | published:1964\n";
        assertEquals(expectation, outContent.toString());
    }

    @Test
    public void print_Menu_list_when_choice_option() {
        library.showMenuList();
        String expectation = "======= Menu List =======\n"
                + "1 -- LIST BOOKS\n" + "2 -- CHOCK OUT BOOK\n"
                + "3 -- RETURN BOOK\n" + "4 -- QUIT\n"
                + "Select on Option about Menu:";
        assertEquals(expectation, outContent.toString());
    }

    @Test
    public void circle_Print_Menu_when_choice_is_not_quit() throws IOException {

        when(mockBufferedReader.readLine()).thenReturn("1").thenReturn("2").thenReturn("3").thenReturn("4");
        Library mockLibrary = spy(new Library(mockBufferedReader));
        doNothing().when(mockLibrary).selectOptionFromIndex(anyInt());
        mockLibrary.choiceMenu();
        String expectation = "======= Menu List =======\n"
                + "1 -- LIST BOOKS\n" + "2 -- CHOCK OUT BOOK\n"
                + "3 -- RETURN BOOK\n" + "4 -- QUIT\n"
                + "Select on Option about Menu:"
                + "======= Menu List =======\n"
                + "1 -- LIST BOOKS\n" + "2 -- CHOCK OUT BOOK\n"
                + "3 -- RETURN BOOK\n" + "4 -- QUIT\n"
                + "Select on Option about Menu:"
                + "======= Menu List =======\n"
                + "1 -- LIST BOOKS\n" + "2 -- CHOCK OUT BOOK\n"
                + "3 -- RETURN BOOK\n" + "4 -- QUIT\n"
                + "Select on Option about Menu:"
                + "======= Menu List =======\n"
                + "1 -- LIST BOOKS\n" + "2 -- CHOCK OUT BOOK\n"
                + "3 -- RETURN BOOK\n" + "4 -- QUIT\n"
                + "Select on Option about Menu:"+ "You have Quit the Library!\n";
        assertEquals(expectation, outContent.toString());
    }

    @Test
    public void select_option_when_input_menu_index_one() throws IOException {
        library.selectOptionFromIndex(1);
        assertThat(outContent.toString(), containsString("Book List"));
    }

    @Test
    public void select_option_when_input_menu_index_two_that_book_available() throws IOException {
        when(mockBufferedReader.readLine()).thenReturn("2");
        library.selectOptionFromIndex(2);
        String expectation = "please input the number about book:"+ "Thank you! Enjoy the book!\n";
        assertThat(library.getBookList().get(1).getIsCheckout(), is(false));
        assertThat(outContent.toString(), is(expectation));
    }

    @Test
    public void select_option_when_input_menu_index_two_that_book_isExist() throws IOException {
        when(mockBufferedReader.readLine()).thenReturn("6");
        library.selectOptionFromIndex(2);
        String expectation = "please input the number about book:"+ "That book is not available.\n";
        assertThat(library.getBookList().get(0).getIsCheckout(), is(true));
        assertThat(library.getBookList().get(1).getIsCheckout(), is(true));
        assertThat(outContent.toString(), is(expectation));
    }

    @Test
    public void select_option_when_input_menu_index_two_that_book_isAvailable() throws IOException {
        when(mockBufferedReader.readLine()).thenReturn("1");
        library.getBookList().get(0).setIsCheckOut(false);
        library.selectOptionFromIndex(2);
        String expectation = "please input the number about book:"+ "That book is not available.\n";
        assertThat(library.getBookList().get(0).getIsCheckout(), is(false));
        assertThat(outContent.toString(), is(expectation));
    }

    @Test
    public void select_option_when_input_menu_index_three_that_book_available() throws IOException {
        when(mockBufferedReader.readLine()).thenReturn("2");
        library.getBookList().get(1).setIsCheckOut(false);
        library.selectOptionFromIndex(3);
        String expectation = "please input the number about book:"+ "Thank you for returning the book.\n";
        assertThat(library.getBookList().get(1).getIsCheckout(), is(true));
        assertThat(outContent.toString(), is(expectation));
    }

    @Test
    public void select_option_when_input_menu_index_three_that_book_isExist() throws IOException {
        when(mockBufferedReader.readLine()).thenReturn("6");
        library.selectOptionFromIndex(3);
        String expectation = "please input the number about book:"+ "That is not a valid book to return.\n";
        assertThat(library.getBookList().get(0).getIsCheckout(), is(true));
        assertThat(library.getBookList().get(1).getIsCheckout(), is(true));
        assertThat(outContent.toString(), is(expectation));
    }

    @Test
    public void select_option_when_input_menu_index_three_that_book_isAvailable() throws IOException {
        when(mockBufferedReader.readLine()).thenReturn("1");
        library.selectOptionFromIndex(3);
        String expectation = "please input the number about book:"+ "That is not a valid book to return.\n";
        assertThat(library.getBookList().get(0).getIsCheckout(), is(true));
        assertThat(library.getBookList().get(1).getIsCheckout(), is(true));
        assertThat(outContent.toString(), is(expectation));
    }

    @Test
    public void select_option_when_input_menu_index_invalid() throws IOException {
        library.selectOptionFromIndex(5);
        assertThat(outContent.toString(), is("Error: Select a valid option!\n"));
    }

}
