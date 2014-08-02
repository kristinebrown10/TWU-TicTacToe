package com.thoughtworks;

import java.io.BufferedReader;
import java.io.PrintStream;

public class TicTacToe {
    PrintStream out;
    BufferedReader reader;
    Board gameBoard;
    InputHandler inputHandler;

    public TicTacToe(PrintStream out, BufferedReader reader) {
        this.out = out;
        this.reader = reader;
        inputHandler = new InputHandler(out, reader);
        gameBoard = new Board();
    }

    public void start() {
        drawBoard();
        while (!gameBoard.gameIsOver()) {
            int inputNum = inputHandler.getUserInput();
            out.println(gameBoard.fillCell(inputNum));
        }
    }

    public void drawBoard() {
        out.println(gameBoard.drawSelf());
    }
}