package com.thoughtworks;

import java.io.PrintStream;

public class Board {
    private PrintStream out;
    private String[] cells = new String[9];
    private boolean xTurn;

    public Board(PrintStream out) {
        this.out = out;
        for(int i = 0; i < 9; i++) {
            cells[i] = " ";
        }
        xTurn = true;
    }

    public void drawSelf() {
        out.println(" " + cells[0] + " | " + cells[1] + " | " + cells[2] + " \n" +
                "-----------\n" +
                " " + cells[3] + " | " + cells[4] + " | " + cells[5] + " \n" +
                "-----------\n" +
                " " + cells[6] + " | " + cells[7] + " | " + cells[8] + " ");
    }

    public void fillCell(int playerMove) {
        if(cells[playerMove-1].equals(" ")) {
            if (xTurn) {
                cells[playerMove - 1] = "X";
            } else {
                cells[playerMove - 1] = "O";
            }
            xTurn = !xTurn;
        }
        else
            out.println("Location already taken");
    }
}
