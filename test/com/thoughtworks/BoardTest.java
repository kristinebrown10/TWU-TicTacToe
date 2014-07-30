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
        assertEquals(board.fillCell(5), "   |   |   \n" +
                                        "-----------\n" +
                                        "   | X |   \n" +
                                        "-----------\n" +
                                        "   |   |   ");
    }

    @Test
    public void shouldRedrawBoardWhenPlayer2EntersNumber() {
        board.fillCell(5);
        board.fillCell(2);
        assertEquals(board.drawSelf(), "   | O |   \n" +
                                       "-----------\n" +
                                       "   | X |   \n" +
                                       "-----------\n" +
                                       "   |   |   ");
    }

    @Test
    public void shouldReturnErrorMessageWhenPlayerTriesToPlayInTakenCell() {
        board.fillCell(5);
        assertEquals(board.fillCell(5), "Location already taken");
    }

    @Test
    public void shouldPrintDrawWhenAllCellsAreFilled() {
        board.fillCell(1);
        board.fillCell(2);
        board.fillCell(3);
        board.fillCell(4);
        board.fillCell(5);
        board.fillCell(6);
        board.fillCell(7);
        board.fillCell(8);
        assertThat(board.fillCell(9), CoreMatchers.containsString("Game is a draw"));
        assertThat(board.checkIfGameIsOver(), is(true));
    }

    @Test
    public void shouldDisplayMessageWhenPlayerGetsThreeInARow() {
        board.fillCell(1);
        board.fillCell(9);
        board.fillCell(2);
        board.fillCell(5);
        board.fillCell(3);
        assertEquals(board.drawSelf(), "Player " + board.getCurrentPlayer() + " Wins!");
        assertEquals(board.checkIfGameIsWon(), is(true));
    }
}