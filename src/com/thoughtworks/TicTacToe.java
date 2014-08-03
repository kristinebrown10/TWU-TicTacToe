package com.thoughtworks;

import java.io.BufferedReader;
import java.io.PrintStream;

public class TicTacToe {
    PrintStream out;
    BufferedReader reader;
    Board gameBoard;
    InputHandler inputHandler;
    Player playerX;
    Player playerO;
    Player currentPlayer;

    public TicTacToe(PrintStream out, BufferedReader reader) {
        this.out = out;
        this.reader = reader;
        inputHandler = new InputHandler(out, reader);
        gameBoard = new Board();
        playerX = new Player(out, reader, "X", gameBoard.passBoard());
        currentPlayer = playerX;
        playerO = new ComputerPlayer(out, reader, "O", gameBoard.passBoard());
    }

    public void start() {
        drawBoard();
        int inputNum = playerX.getPlayerInput();
        out.println(gameBoard.fillCell(inputNum, currentPlayer));
        while (!gameBoard.gameIsOver(inputNum, currentPlayer)) {
            currentPlayer.lookAtBoard(gameBoard.passBoard());
            swapPlayer();
            inputNum = currentPlayer.getPlayerInput();
            out.println(gameBoard.fillCell(inputNum, currentPlayer));
        }
    }

    public void drawBoard() {
        out.println(gameBoard.drawSelf());
    }

    public String getCurrentPlayer() {
        if (currentPlayer.playerIsX())
            return "X";
        return "O";
    }

    public void swapPlayer() {
        if(currentPlayer.playerIsX())
            currentPlayer = playerO;
        else currentPlayer = playerX;
    }
}