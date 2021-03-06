package com.thoughtworks;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.PrintStream;
import java.io.StringReader;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class ComputerPlayerTest {

    private ComputerPlayer computerPlayer;
    private PrintStream mockPrintStream;
    private BufferedReader mockBufferedReader;

    @Before
    public void setUp() throws Exception{
        mockPrintStream = mock(PrintStream.class);
        mockBufferedReader = new BufferedReader(new StringReader("5"));

    }

    @Test
    public void shouldChooseEmptyLocationThatWillWinTheGame() {
        String[] cells = {"X","O","X"," ","O"," "," "," ","X"};
        computerPlayer = new ComputerPlayer(mockPrintStream,mockBufferedReader,"O", cells);
        assertEquals(computerPlayer.getPlayerInput(), 8);
    }

    @Test
    public void shouldChooseEmptyLocationIfPlayerCannotWin() {
        String[] cells = {"X"," ","X"," ","O"," "," "," ","X"};
        computerPlayer = new ComputerPlayer(mockPrintStream,mockBufferedReader,"X", cells);
        assertEquals(computerPlayer.getPlayerInput(), 2);
    }

}