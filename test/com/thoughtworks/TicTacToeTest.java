package com.thoughtworks;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.PrintStream;
import java.io.StringReader;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class TicTacToeTest {

    @Test
    public void shouldDrawBoardWhenProgramStarts() {
        PrintStream mockPrintStream = mock(PrintStream.class);
        TicTacToe game = new TicTacToe(mockPrintStream, new BufferedReader(new StringReader("5")));
        game.drawBoard();
        verify(mockPrintStream).println("   |   |   \n" +
                                        "-----------\n" +
                                        "   |   |   \n" +
                                        "-----------\n" +
                                        "   |   |   ");
    }

    @Test
    public void shouldGetUserInput() {
        PrintStream mockPrintStream = mock(PrintStream.class);
        TicTacToe game = new TicTacToe(mockPrintStream, new BufferedReader(new StringReader("5")));
        assertThat(game.getUserInput(), is(5));
    }
//    @Test
//    public void shouldRedrawBoardWhenUserEntersNumber() {
//        //Application app = new Application(library, fakePrintStream, new BufferedReader(new StringReader("2\n1")));
//        PrintStream mockPrintStream = mock(PrintStream.class);
//        TicTacToe game = new TicTacToe(mockPrintStream, new BufferedReader(new StringReader("5")));
//        game.drawBoard();
//        game.getUserInput();
//        game.drawBoard();
//        verify(mockPrintStream).println("   |   |   \n" +
//                                        "-----------\n" +
//                                        "   | X |   \n" +
//                                        "-----------\n" +
//                                        "   |   |   ");
//    }
}