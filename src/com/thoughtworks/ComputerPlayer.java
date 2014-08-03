package com.thoughtworks;

import java.io.BufferedReader;
import java.io.PrintStream;

public class ComputerPlayer extends Player {

    private String[] cells = new String[9];
    String[] temp;
    ThreeInARowChecker checker;

    public ComputerPlayer(PrintStream out, BufferedReader reader, String playerState, String[] cells) {
        super(out, reader, playerState, cells);
        this.cells = cells;
    }

    @Override
    public int getPlayerInput() {
       for(int i = 0; i < cells.length; i++) {
           if(cells[i].equals(" ")) {
               temp = cells;
               temp[i] = super.toString();
               checker = new ThreeInARowChecker(cells, super.toString());
               if(checker.threeInARowAcross(i+1) || checker.threeInARowDown(i+1)
                       || checker.threeInARowBackwardDiagonal() || checker.threeInARowForwardDiagonal())
                   return (i+1);
           }
       }
       return 0;
    }


}
