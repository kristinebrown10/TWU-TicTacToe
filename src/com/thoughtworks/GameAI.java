package com.thoughtworks;

public class GameAI {
    public String cells[];
    private Board.Player player;

    public GameAI(String cells[], Board.Player player) {
        this.cells = cells;
        this.player = player;
    }

    public boolean threeInARowAcross(int newMove) {
        int horizontal = 0;
        for (int i = newMove/3+2; i < newMove/3 + 5; i++) {
            if(cells[i].equals(player.toString())) horizontal++;
        }
        return (horizontal == 3);
    }

    public boolean threeInARowDown(int newMove) {
        int vertical = 0;
        for (int i = newMove%3; i < cells.length; i += 3) {
            if(cells[i].equals(player.toString())) vertical++;
        }
        return (vertical == 3);
    }

    public boolean threeInARowForwardDiagonal() {
        int diagonal1 = 0;
        for (int i = 0; i < cells.length; i += 4) {
            if (cells[i].equals(player.toString())) diagonal1++;
        }
        return (diagonal1 == 3);
    }

    public boolean threeInARowBackwardDiagonal() {
        int diagonal2 = 0;
        for (int i = 2; i < cells.length - 1; i += 2) {
            if (cells[i].equals(player.toString())) diagonal2++;
        }
        return (diagonal2 == 3);
    }
}
