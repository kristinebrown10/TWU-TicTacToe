package com.thoughtworks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

public class TicTacToe {
    PrintStream out;
    BufferedReader reader;
    String[] board = {" "," "," "," "," "," "," "," "," "};

    public TicTacToe(PrintStream out, BufferedReader reader) {
        this.out = out;
        this.reader = reader;
    }

    public void start() {
        drawBoard();
        getUserInput();
    }

    public void drawBoard() {
        out.println(" " + board[0] + " | " + board[1] + " | " + board[2] + " \n" +
                    "-----------\n" +
                    " " + board[3] + " | " + board[4] + " | " + board[5] + " \n" +
                    "-----------\n" +
                    " " + board[6] + " | " + board[7] + " | " + board[8] + " ");
    }

    public int getUserInput() {
        int inputNum = 0;
        try {
            String input = reader.readLine();
            inputNum = Integer.parseInt(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        board[inputNum-1] = "X";
        drawBoard();
        return inputNum;
    }
}
