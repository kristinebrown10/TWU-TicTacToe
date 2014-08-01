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

    public String drawSelf() {
        return(" " + cells[0] + " | " + cells[1] + " | " + cells[2] + " \n" +
                "-----------\n" +
                " " + cells[3] + " | " + cells[4] + " | " + cells[5] + " \n" +
                "-----------\n" +
                " " + cells[6] + " | " + cells[7] + " | " + cells[8] + " ");
    }

    public String fillCell(int playerMove) {
        if(cells[playerMove-1].equals(" ")) {
            cells[playerMove - 1] = player.toString();
            if(checkIfGameIsOver()) {
                return (drawSelf() + "\nGame is a draw");
            }
            else if(checkIfGameIsWon(playerMove)) {
                return (drawSelf() + "\nPlayer " + getCurrentPlayer() + " wins!");
            }
            if(player.equals(Player.X)) player = Player.O;
            else player = Player.X;
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

    public boolean checkIfGameIsWon(int newMove) {
        boolean threeInARow = false;
        newMove--;
        int vertical = 0;
        int horizontal = 0;
        int diagonal1 = 0;
        int diagonal2 = 0;

        for (int i = newMove%3; i < cells.length; i += 3) {
            if(cells[i].equals(player.toString())) vertical++;
        }

        for (int i = newMove/3+2; i < newMove/3 + 5; i++) {
            if(cells[i].equals(player.toString())) horizontal++;
        }

        if(newMove%4 == 0) {
            for(int i = 0; i < cells.length; i += 4) {
                if(cells[i].equals(player.toString())) diagonal1++;
            }
        }
        else if(newMove%2 == 0) {
            for(int i = 2; i < cells.length-1; i += 2) {
                if(cells[i].equals(player.toString())) diagonal2++;
            }
        }

        if (vertical == 3 || horizontal == 3 || diagonal1 == 3 || diagonal2 == 3) {
            threeInARow = true;
        }

        return threeInARow;
    }

    public int getCurrentPlayer() {
        if(player.equals(Player.X)) return 1;
        return 2;
    }
}
