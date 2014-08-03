package com.thoughtworks;

import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.PrintStream;
import java.io.StringReader;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;

public class BoardTest {
    private Board board;
    private Player playerX;
    private Player playerO;
    private PrintStream mockPrintStream;
    private BufferedReader mockBufferedReaderX;
    private BufferedReader mockBufferedReaderO;

    @Before
    public void setUp() throws Exception {
        board = new Board();
        mockPrintStream = mock(PrintStream.class);
        mockBufferedReaderX = new BufferedReader(new StringReader("5"));
        mockBufferedReaderO = new BufferedReader(new StringReader("2"));
        playerX = new Player(mockPrintStream, mockBufferedReaderX, "X");
        playerO = new Player(mockPrintStream, mockBufferedReaderO, "O");
    }

    @Test
    public void shouldDrawBoard() {
        assertEquals(board.drawSelf(), "   |   |   \n" +
                "-----------\n" +
                "   |   |   \n" +
                "-----------\n" +
                "   |   |   ");
    }

    @Test
    public void shouldPlaceXWhenPlayer1Goes() {
        String[] cells = {" "," "," "," ","X"," "," "," "," "};
        Board myBoard = new Board(cells);
        assertEquals(board.fillCell(5, playerX), myBoard.drawSelf());
    }

    @Test
    public void shouldRedrawBoardWhenPlayer2EntersNumber() {
        board.fillCell(5, playerX);
        String[] cells = {" ","O"," "," ","X"," "," "," "," "};
        Board myBoard = new Board(cells);
        assertEquals(board.fillCell(2, playerO), myBoard.drawSelf());
    }

    @Test
    public void shouldReturnErrorMessageWhenPlayerTriesToPlayInTakenCell() {
        String[] cells = {" "," "," "," ","X"," "," "," "," "};
        Board myBoard = new Board(cells);
        assertEquals(myBoard.fillCell(5, playerX), "Location already taken");
    }

    @Test
    public void shouldPrintDrawWhenAllCellsAreFilled() {
        String[] cells = {"X","O","X","X","O","O","O","X"," "};
        Board myBoard = new Board(cells);
        assertThat(myBoard.fillCell(9, playerX), CoreMatchers.containsString("Game is a draw"));
        assertThat(myBoard.gameIsADraw(), is(true));
    }

    @Test
    public void shouldDisplayMessageWhenPlayerGetsThreeInARow() {
        String[] cells = {"X","X","O","O","O"," "," ","X"," "};
        Board myBoard = new Board(cells);
        assertEquals(myBoard.fillCell(7, playerO), myBoard.drawSelf() + "\nPlayer " + playerO.getPlayerNum() + " wins!");
        assertEquals(myBoard.gameIsWon(7, playerO), true);
    }
}