package com.thoughtworks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

public class TicTacToe {
    PrintStream out;
    BufferedReader reader;
    Board gameBoard;

    public TicTacToe(PrintStream out, BufferedReader reader) {
        this.out = out;
        this.reader = reader;
        gameBoard = new Board(this.out);
    }

    public void start() {
        gameBoard.drawSelf();
        getUserInput();
        gameBoard.drawSelf();
        getUserInput();
        gameBoard.drawSelf();
    }

    public int getUserInput() {
        int inputNum = 0;
        try {
            String input = reader.readLine();
            inputNum = Integer.parseInt(input);
            gameBoard.fillCell(inputNum);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return inputNum;
    }

    public void drawBoard() {
        gameBoard.drawSelf();
    }
}