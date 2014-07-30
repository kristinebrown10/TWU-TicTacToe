package com.thoughtworks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

public class TicTacToe {
    PrintStream out;
    BufferedReader reader;
    String[] board = new String[9];
    Board gameBoard;

    public TicTacToe(PrintStream out, BufferedReader reader) {
        this.out = out;
        this.reader = reader;
        gameBoard = new Board(this.out);
    }

    public void start() {
        initializeBoard();
        play();
    }

    public void play() {
        int playerNum = 1;
        while(playerNum < 3) {
            if(playerNum%2 == 1)
                getUserInput("X");
            else getUserInput("O");
            playerNum++;
        }
    }

    public void initializeBoard() {
        for(int i = 0; i < 9; i++) {
            board[i] = " ";
        }
        drawBoard();
    }

    public int getUserInput(String player) {
        int inputNum = 0;
        try {
            String input = reader.readLine();
            inputNum = Integer.parseInt(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(board[inputNum-1].equals(" ")) {
            board[inputNum - 1] = player;
            gameBoard.fillCell(inputNum);
            drawBoard();
        }
        else {
            out.println("Location already taken");
            getUserInput(player);
        }
        return inputNum;
    }

    public void drawBoard() {
        gameBoard.drawSelf();
    }
}
