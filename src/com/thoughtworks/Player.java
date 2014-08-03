package com.thoughtworks;

import java.io.BufferedReader;
import java.io.PrintStream;

public class Player {

    InputHandler inputHandler;
    private enum PlayerState {X,O}
    private PlayerState playerState;

    public Player(PrintStream out, BufferedReader reader, String playerState) {
        inputHandler = new InputHandler(out, reader);
        if(playerState.equals(PlayerState.X.toString())) this.playerState = PlayerState.X;
        else this.playerState = PlayerState.O;
    }

    public boolean playerIsX() {
        return (playerState.equals(PlayerState.X));
    }

    public int getPlayerInput() {
        return inputHandler.getUserInput();
    }

    public String toString() {
        return playerState.toString();
    }

    public int getPlayerNum() {
        if(playerIsX())
            return 1;
        else return 2;
    }
}
