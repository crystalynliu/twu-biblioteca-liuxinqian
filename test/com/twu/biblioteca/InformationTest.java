package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class InformationTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

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
    public void  print_correct_welcome_message_when_start() throws IOException {
        BibliotecaApp app = new BibliotecaApp();
        String expectation = "Welcome to The Bangalore Public Library, Enjoy you journey!\n";
        app.printWelcomeMessage();
        assertEquals(expectation, outContent.toString());

    }
}
