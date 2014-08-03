package com.thoughtworks;

import org.junit.Test;

import static org.junit.Assert.*;

public class ThreeInARowCheckerTest {
    private ThreeInARowChecker threeInARowChecker;

    @Test
    public void testThreeInARowAcross(){
        String[] cells = {"O","O","O"," ","X"," ","X","O","X"};
        threeInARowChecker = new ThreeInARowChecker(cells, "O");
        assertEquals(threeInARowChecker.threeInARowAcross(2),true);
    }

    @Test
    public void testThreeInARowDown(){
        String[] cells = {"X","O"," ","X","O"," ","X","O","X"};
        threeInARowChecker = new ThreeInARowChecker(cells, "X");
        assertEquals(threeInARowChecker.threeInARowDown(6),true);
    }

    @Test
    public void testThreeInARowForwardDiagonal(){
        String[] cells = {"X","O"," "," ","X","O"," "," ","X"};
        threeInARowChecker = new ThreeInARowChecker(cells, "X");
        assertEquals(threeInARowChecker.threeInARowForwardDiagonal(),true);
    }

    @Test
    public void shouldReturnTrueWhenThreeInARowBackwardDiagonal(){
        String[] cells = {" ","O","X"," ","X","O","X"," "," "};
        threeInARowChecker = new ThreeInARowChecker(cells, "X");
        assertEquals(threeInARowChecker.threeInARowBackwardDiagonal(), true);
    }
}