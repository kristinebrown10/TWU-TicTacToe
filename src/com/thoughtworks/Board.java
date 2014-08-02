package com.thoughtworks;

public class Board {
    private String[] cells = new String[9];
    private enum Player {X,O}
    private Player player;

    public Board() {
        for(int i = 0; i < 9; i++) {
            cells[i] = " ";
        }
        player = Player.X;
    }

    public Board(String[] cells) {
       this.cells = cells;
       player = Player.X;
    }

    public String drawSelf() {
        return(" " + cells[0] + " | " + cells[1] + " | " + cells[2] + " \n" +
               "-----------\n" +
               " " + cells[3] + " | " + cells[4] + " | " + cells[5] + " \n" +
               "-----------\n" +
               " " + cells[6] + " | " + cells[7] + " | " + cells[8] + " ");
    }

    public String fillCell(int playerMove) {
        int cellNum = playerMove - 1;
        if(cellIsEmpty(cellNum)) {
            cells[cellNum] = player.toString();
            if(gameIsWon(playerMove)) {
                return (drawSelf() + "\nPlayer " + getCurrentPlayer() + " wins!");
            } else if(gameIsOver()) {
                return (drawSelf() + "\nGame is a draw");
            }
            swapPlayer();
        }
        else {
            return ("Location already taken");
        }
        return drawSelf();
    }

    private void swapPlayer() {
        if(player.equals(Player.X)) player = Player.O;
        else player = Player.X;
    }

    private boolean cellIsEmpty(int cellNum) {
        return cells[cellNum].equals(" ");
    }

    public boolean gameIsOver() {
        boolean gameOver = true;
        for(String cell : cells) {
            if(cell.equals(" ")) {
                gameOver = false;
            }
        }
        return gameOver;
    }

    public boolean gameIsWon(int newMove) {
        boolean threeInARow = false;
        newMove--;

        if (threeInARowDown(newMove) || threeInARowAcross(newMove) ||
                threeInARowForwardDiagonal(newMove) || threeInARowBackwardDiagonal(newMove)) {
            return true;
        }

        return false;
    }

    private boolean threeInARowBackwardDiagonal(int newMove) {
        int diagonal2 = 0;
        if(newMove%4 != 0 && newMove%2 == 0) {
            for (int i = 2; i < cells.length - 1; i += 2) {
                if (cells[i].equals(player.toString())) diagonal2++;
            }
        }
        if(diagonal2 == 3) return true;
        return false;
    }

    private boolean threeInARowForwardDiagonal(int newMove) {
        int diagonal1 = 0;
        if(newMove%4 == 0) {
            for (int i = 0; i < cells.length; i += 4) {
                if (cells[i].equals(player.toString())) diagonal1++;
            }
        }
        if(diagonal1 == 3) return true;
        return false;
    }

    private boolean threeInARowAcross(int newMove) {
        int horizontal = 0;
        for (int i = newMove/3+2; i < newMove/3 + 5; i++) {
            if(cells[i].equals(player.toString())) horizontal++;
        }
        if(horizontal == 3) return true;
        return false;
    }

    private boolean threeInARowDown(int newMove) {
        int vertical = 0;
        for (int i = newMove%3; i < cells.length; i += 3) {
            if(cells[i].equals(player.toString())) vertical++;
        }
        if(vertical == 3) return true;
        return false;
    }

    public int getCurrentPlayer() {
        if(player.equals(Player.X)) return 1;
        return 2;
    }
}
