package com.thoughtworks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

public class TicTacToe {
    PrintStream out;
    BufferedReader reader;
    String[] board = new String[9];

    public TicTacToe(PrintStream out, BufferedReader reader) {
        this.out = out;
        this.reader = reader;
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
            drawBoard();
        }
        else {
            out.println("Location already taken");
            getUserInput(player);
        }

        return inputNum;
    }

    public void drawBoard() {
        out.println(" " + board[0] + " | " + board[1] + " | " + board[2] + " \n" +
                "-----------\n" +
                " " + board[3] + " | " + board[4] + " | " + board[5] + " \n" +
                "-----------\n" +
                " " + board[6] + " | " + board[7] + " | " + board[8] + " ");
    }
}
