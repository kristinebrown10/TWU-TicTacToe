package com.thoughtworks;

import org.junit.Test;

import static org.junit.Assert.*;

public class GameAITest {
    private GameAI gameAI;

    @Test
    public void shouldReturnTrueWhenThreeInARowBackwardDiagonal(){
        String[] cells = {" ","O","X"," ","X","O","X"," "," "};
        gameAI = new GameAI(cells);
        assertEquals(gameAI.threeInARowBackwardDiagonal(),true);
    }

    @Test
    public void testThreeInARowForwardDiagonal(){
        String[] cells = {"X","O"," "," ","X","O"," "," ","X"};
        gameAI = new GameAI(cells);
        assertEquals(gameAI.threeInARowForwardDiagonal(),true);
    }

    @Test
    public void testThreeInARowAcross(){
        String[] cells = {"X","O"," ","X","X","X","O","O"," "};
        gameAI = new GameAI(cells);
        assertEquals(gameAI.threeInARowAcross(5),true);
    }

    @Test
    public void testThreeInARowDown(){
        String[] cells = {"X","O"," ","X","O"," ","X","O","X"};
        gameAI = new GameAI(cells);
        assertEquals(gameAI.threeInARowDown(6),true);
    }
}