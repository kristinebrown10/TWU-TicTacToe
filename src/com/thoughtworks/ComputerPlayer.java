package com.thoughtworks;

import java.io.BufferedReader;
import java.io.PrintStream;

public class ComputerPlayer extends Player {
    public ComputerPlayer(PrintStream out, BufferedReader reader, String playerState) {
        super(out, reader, playerState);
    }

    @Override
    public int getPlayerInput() {
       return (int) (Math.random()*9 + 1);
    }
}
