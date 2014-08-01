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
        gameBoard = new Board();
    }

    public void start() {
        drawBoard();
        while (!gameBoard.checkIfGameIsOver()) {
            getUserInput();
        }
    }

    public int getUserInput() {
        int inputNum = 0;
        try {
            String input = reader.readLine();
            inputNum = Integer.parseInt(input);
            out.println(gameBoard.fillCell(inputNum));

        } catch (IOException e) {
            e.printStackTrace();
        }
        return inputNum;
    }

    public void drawBoard() {
        out.println(gameBoard.drawSelf());
    }
}