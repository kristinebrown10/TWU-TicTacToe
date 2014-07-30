package com.thoughtworks;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
	// write your code here
        TicTacToe game = new TicTacToe(System.out, new BufferedReader(new InputStreamReader(System.in)));
        game.drawBoard();
        game.getUserInput();
    }
}
