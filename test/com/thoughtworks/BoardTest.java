package com.thoughtworks;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class BoardTest {
    private PrintStream mockPrintStream;

    @Before
    public void setUp() throws Exception {
        mockPrintStream = mock(PrintStream.class);
    }

    @Test
    public void shouldDrawBoard() {
        Board board = new Board(mockPrintStream);
        board.drawSelf();
        verify(mockPrintStream, atLeast(1)).println("   |   |   \n" +
                                                    "-----------\n" +
                                                    "   |   |   \n" +
                                                    "-----------\n" +
                                                    "   |   |   ");
    }
}