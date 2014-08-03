package com.thoughtworks;

public class Board {
    private String[] cells = new String[9];
    public enum Player {X,O}
    private Player player;
    GameAI gameAI;

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
            } else if(gameIsADraw()) {
                return (drawSelf() + "\nGame is a draw");
            }
            swapPlayer();
        }
        else {
            return ("Location already taken");
        }
        return drawSelf();
    }

    public boolean gameIsOver(int inputNum) {
        return gameIsADraw() || gameIsWon(inputNum);
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

    public boolean gameIsWon(int newMove) {
        newMove--;
        gameAI = new GameAI(cells, player);
        return (gameAI.threeInARowDown(newMove) || gameAI.threeInARowAcross(newMove) ||
                gameAI.threeInARowForwardDiagonal() || gameAI.threeInARowBackwardDiagonal());
    }

    public int getCurrentPlayer() {
        if(player.equals(Player.X)) return 1;
        return 2;
    }

    private void swapPlayer() {
        if(player.equals(Player.X)) player = Player.O;
        else player = Player.X;
    }

    private boolean cellIsEmpty(int cellNum) {
        return cells[cellNum].equals(" ");
    }
}
