package com.thoughtworks;

public class ThreeInARowChecker {
    public String cells[];
    private String player;

    public ThreeInARowChecker(String cells[], String player) {
        this.cells = cells;
        this.player = player;
    }

    public boolean threeInARowAcross(int newMove) {
        int horizontal = 0;
        newMove = newMove/3;
        for (int i = newMove*3; i < newMove*3 + 3; i++) {
            if(cells[i].equals(player)) horizontal++;
        }
        return (horizontal == 3);
    }

    public boolean threeInARowDown(int newMove) {
        int vertical = 0;
        for (int i = newMove%3; i < cells.length; i += 3) {
            if(cells[i].equals(player)) vertical++;
        }
        return (vertical == 3);
    }

    public boolean threeInARowForwardDiagonal() {
        int diagonal1 = 0;
        for (int i = 0; i < cells.length; i += 4) {
            if (cells[i].equals(player)) diagonal1++;
        }
        return (diagonal1 == 3);
    }

    public boolean threeInARowBackwardDiagonal() {
        int diagonal2 = 0;
        for (int i = 2; i < cells.length - 1; i += 2) {
            if (cells[i].equals(player)) diagonal2++;
        }
        return (diagonal2 == 3);
    }
}
