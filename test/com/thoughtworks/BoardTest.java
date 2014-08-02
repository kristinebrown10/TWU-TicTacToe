package com.thoughtworks;

import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class BoardTest {
    private Board board;

    @Before
    public void setUp() throws Exception {
        board = new Board();
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
        assertEquals(board.fillCell(5), myBoard.drawSelf());
    }

    @Test
    public void shouldRedrawBoardWhenPlayer2EntersNumber() {
        board.fillCell(5);
        board.fillCell(2);
        String[] cells = {" ","O"," "," ","X"," "," "," "," "};
        Board myBoard = new Board(cells);
        assertEquals(board.drawSelf(), myBoard.drawSelf());
    }

    @Test
    public void shouldReturnErrorMessageWhenPlayerTriesToPlayInTakenCell() {
        String[] cells = {" "," "," "," ","X"," "," "," "," "};
        Board myBoard = new Board(cells);
        assertEquals(myBoard.fillCell(5), "Location already taken");
    }

    @Test
    public void shouldPrintDrawWhenAllCellsAreFilled() {
        String[] cells = {"X","O","X","O","X","O","X","O"," "};
        Board myBoard = new Board(cells);
        assertThat(myBoard.fillCell(9), CoreMatchers.containsString("Game is a draw"));
        assertThat(myBoard.checkIfGameIsOver(), is(true));
    }

    @Test
    public void shouldDisplayMessageWhenPlayerGetsThreeInARow() {
        String[] cells = {" ","O","X","O","X"," "," "," "," "};
        Board myBoard = new Board(cells);
        assertEquals(myBoard.fillCell(7), myBoard.drawSelf() + "\nPlayer " + myBoard.getCurrentPlayer() + " wins!");
        assertEquals(myBoard.checkIfGameIsWon(7), true);
    }
}