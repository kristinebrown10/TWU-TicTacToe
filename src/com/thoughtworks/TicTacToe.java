package com.thoughtworks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

public class TicTacToe {
    PrintStream out;
    BufferedReader reader;

    public TicTacToe(PrintStream out, BufferedReader reader) {
        this.out = out;
        this.reader = reader;
    }

    public void drawBoard() {
        out.println("   |   |   \n" +
                    "-----------\n" +
                    "   |   |   \n" +
                    "-----------\n" +
                    "   |   |   ");
    }

    public int getUserInput() {
        int inputNum = 0;
        try {
            String input = reader.readLine();
            inputNum = Integer.parseInt(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return inputNum;
    }
}
