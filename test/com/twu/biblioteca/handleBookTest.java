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
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private Book book = new Book();
    private List<Book> books = new ArrayList<Book>();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
        System.setErr(null);
    }

    @Test
    public void print_book_list_when_welcome_message_appear(){
        books.add(new Book(1,"Harry Potter and the Sorcerer's Stone","Rowling","1997"));
        books.add(new Book(2,"Charlie and the Chocolate Factory","Dahl","1964"));
        book.printBookList(books);
        String expectation = "1 | name:Harry Potter and the Sorcerer's Stone | author:Rowling | published:1997\n"
                            +"2 | name:Charlie and the Chocolate Factory | author:Dahl | published:1964\n";
        assertEquals(expectation, outContent.toString());
    }
}
