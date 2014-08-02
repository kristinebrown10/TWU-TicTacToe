package com.thoughtworks;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.PrintStream;
import java.io.StringReader;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class InputHandlerTest {

    private InputHandler inputHandler;
    private PrintStream mockPrintStream;
    private BufferedReader mockBufferedReader;

    @Before
    public void setUp() throws Exception{
        mockPrintStream = mock(PrintStream.class);
        mockBufferedReader = new BufferedReader(new StringReader("5"));
        inputHandler = new InputHandler(mockPrintStream,mockBufferedReader);
    }

    @Test
    public void shouldReturnUserInput() {
        assertThat(inputHandler.getUserInput(), is(5));
    }
}