package com.thoughtworks;

import java.io.BufferedReader;
import java.io.PrintStream;

public class ComputerPlayer extends Player {

    private String[] cells = new String[9];
    String[] temp;
    ThreeInARowChecker checker;
    String playerState;

    public ComputerPlayer(PrintStream out, BufferedReader reader, String playerState, String[] cells) {
        super(out, reader, playerState, cells);
        this.playerState = playerState;
        this.cells = cells;
    }

    @Override
    public int getPlayerInput() {
       for(int i = 0; i < cells.length; i++) {
           if(cells[i].equals(" ")) {
               temp = cells;
               temp[i] = playerState;
               checker = new ThreeInARowChecker(temp, playerState);
               if(checker.threeInARowAcross(i) || checker.threeInARowDown(i)
                       || checker.threeInARowBackwardDiagonal() || checker.threeInARowForwardDiagonal())
                   return (i+1);
               else temp[i] = " ";
           }
       }
       for(int i = 0; i < cells.length; i++) {
            if(cells[i].equals(" ")) {
                return (i+1);
            }
       }
        return -1;
    }


}
