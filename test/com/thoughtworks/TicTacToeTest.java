package com.thoughtworks;

import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class TicTacToeTest {

    @Test
    public void drawBoardWhenProgramStarts() {
        PrintStream mockPrintStream = mock(PrintStream.class);
        TicTacToe game = new TicTacToe(mockPrintStream);
        game.drawBoard();
        verify(mockPrintStream).println("   |   |   \n" +
                                        "-----------\n" +
                                        "   |   |   \n" +
                                        "-----------\n" +
                                        "   |   |   ");
    }
}