package com.thoughtworks;

public class Board {
    private String[] cells = new String[9];
    ThreeInARowChecker threeInARowChecker;

    public Board() {
        for(int i = 0; i < 9; i++) {
            cells[i] = " ";
        }
    }

    public Board(String[] cells) {
       this.cells = cells;
    }

    public String drawSelf() {
        return(" " + cells[0] + " | " + cells[1] + " | " + cells[2] + " \n" +
               "-----------\n" +
               " " + cells[3] + " | " + cells[4] + " | " + cells[5] + " \n" +
               "-----------\n" +
               " " + cells[6] + " | " + cells[7] + " | " + cells[8] + " ");
    }

    public String fillCell(int playerMove, Player currentPlayer) {
        int cellNum = playerMove - 1;
        if(cellIsEmpty(cellNum)) {
            cells[cellNum] = currentPlayer.toString();
            if(gameIsWon(playerMove, currentPlayer)) {
                return (drawSelf() + "\nPlayer " + currentPlayer.getPlayerNum() + " wins!");
            } else if(gameIsADraw()) {
                return (drawSelf() + "\nGame is a draw");
            }
        }
        else {
            return ("Location already taken");
        }
        return drawSelf();
    }

    public boolean gameIsOver(int inputNum, Player currentPlayer) {
        return gameIsADraw() || gameIsWon(inputNum, currentPlayer);
    }

    public boolean gameIsADraw() {
        boolean gameIsADraw = true;
        for(String cell : cells) {
            if(cell.equals(" ")) {
                gameIsADraw = false;
            }
        }
        return gameIsADraw;
    }

    public boolean gameIsWon(int newMove, Player currentPlayer) {
        newMove--;
        threeInARowChecker = new ThreeInARowChecker(cells, currentPlayer.toString());
        return (threeInARowChecker.threeInARowDown(newMove) || threeInARowChecker.threeInARowAcross(newMove) ||
                threeInARowChecker.threeInARowForwardDiagonal() || threeInARowChecker.threeInARowBackwardDiagonal());
    }

    private boolean cellIsEmpty(int cellNum) {
        return cells[cellNum].equals(" ");
    }

    public String[] passBoard() {
        return cells;
    }
}