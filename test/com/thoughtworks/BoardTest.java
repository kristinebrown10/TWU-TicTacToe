package com.thoughtworks;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class BoardTest {
    private PrintStream mockPrintStream;
    private Board board;

    @Before
    public void setUp() throws Exception {
        mockPrintStream = mock(PrintStream.class);
        board = new Board(mockPrintStream);
    }

    @Test
    public void shouldDrawBoard() {
        board.drawSelf();
        verify(mockPrintStream, atLeast(1)).println("   |   |   \n" +
                                                    "-----------\n" +
                                                    "   |   |   \n" +
                                                    "-----------\n" +
                                                    "   |   |   ");
    }

    @Test
    public void shouldPlaceXWhenPlayer1Goes() {
        board.fillCell(5);
        board.drawSelf();
        verify(mockPrintStream, atLeast(1)).println("   |   |   \n" +
                                                    "-----------\n" +
                                                    "   | X |   \n" +
                                                    "-----------\n" +
                                                    "   |   |   ");
    }

}