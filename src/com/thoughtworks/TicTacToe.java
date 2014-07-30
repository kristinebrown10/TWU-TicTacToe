package com.thoughtworks;

import java.io.PrintStream;

public class TicTacToe {
    PrintStream out;
    public TicTacToe(PrintStream out) {
        this.out = out;
    }

    public void drawBoard() {
        out.println("   |   |   \n" +
                    "-----------\n" +
                    "   |   |   \n" +
                    "-----------\n" +
                    "   |   |   ");
    }
}
