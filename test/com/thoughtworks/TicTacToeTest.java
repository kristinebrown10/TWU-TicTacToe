package com.thoughtworks;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.PrintStream;
import java.io.StringReader;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class TicTacToeTest {

    private PrintStream mockPrintStream;
    private TicTacToe game;

    @Before
    public void setUp() throws Exception {
        mockPrintStream = mock(PrintStream.class);
        game = new TicTacToe(mockPrintStream, new BufferedReader(new StringReader("5\n2")));
    }

    @Test
    public void shouldDrawBoardWhenProgramStarts() {
        game.start();
        verify(mockPrintStream, atLeast(1)).println("   |   |   \n" +
                                        "-----------\n" +
                                        "   |   |   \n" +
                                        "-----------\n" +
                                        "   |   |   ");
    }

    @Test
    public void shouldGetUserInput() {
        assertThat(game.getUserInput(), is(5));
    }

    @Test
    public void shouldRedrawBoardWhenUserEntersNumber() {
        game.getUserInput();
        game.drawBoard();
        verify(mockPrintStream).println("   |   |   \n" +
                                        "-----------\n" +
                                        "   | X |   \n" +
                                        "-----------\n" +
                                        "   |   |   ");
    }

}