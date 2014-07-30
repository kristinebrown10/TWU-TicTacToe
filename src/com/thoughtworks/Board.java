package com.thoughtworks;

import java.io.PrintStream;

public class Board {
    private PrintStream out;

    public Board(PrintStream out) {
        this.out = out;
    }

    public void drawSelf() {
        out.println("   |   |   \n" +
                    "-----------\n" +
                    "   |   |   \n" +
                    "-----------\n" +
                    "   |   |   ");
    }
}
