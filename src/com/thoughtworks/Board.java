package com.thoughtworks;

public class Board {
    private String[] cells = new String[9];
    private boolean xTurn;

    public Board() {
        for(int i = 0; i < 9; i++) {
            cells[i] = " ";
        }
        xTurn = true;
    }

    public String drawSelf() {
        return(" " + cells[0] + " | " + cells[1] + " | " + cells[2] + " \n" +
                "-----------\n" +
                " " + cells[3] + " | " + cells[4] + " | " + cells[5] + " \n" +
                "-----------\n" +
                " " + cells[6] + " | " + cells[7] + " | " + cells[8] + " ");
    }

    public String fillCell(int playerMove) {
        if(cells[playerMove-1].equals(" ")) {
            if (xTurn) {
                cells[playerMove - 1] = "X";
            } else {
                cells[playerMove - 1] = "O";
            }
            xTurn = !xTurn;
            if(checkIfGameIsOver()) {
                return (drawSelf() + "\nGame is a draw");
            }
        }
        else {
            return ("Location already taken");
        }
        return drawSelf();
    }

    public boolean checkIfGameIsOver() {
        boolean gameOver = true;
        for(String cell : cells) {
            if(cell.equals(" ")) {
                gameOver = false;
            }
        }
        return gameOver;
    }
}
