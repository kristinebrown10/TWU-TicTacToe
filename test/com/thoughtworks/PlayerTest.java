package com.thoughtworks;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.PrintStream;
import java.io.StringReader;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class PlayerTest {

    private Player player;
    private PrintStream mockPrintStream;
    private BufferedReader mockBufferedReader;

    @Before
    public void setUp() throws Exception{
        mockPrintStream = mock(PrintStream.class);
        mockBufferedReader = new BufferedReader(new StringReader("5"));
        String[] cells = {" "," "," "," "," "," "," "," "," "};
        player = new Player(mockPrintStream,mockBufferedReader,"X",cells);
    }

    @Test
    public void shouldReturnPlayerInput() {
        assertThat(player.getPlayerInput(), is(5));
    }

    @Test
    public void shouldReturnPlayerStateAsString() {
        assertThat(player.toString(),is("X"));
    }

    @Test
    public void shouldReturnTrueWhenPlayerIsX() {
        assertThat(player.playerIsX(), is(true));
    }

    @Test
    public void shouldReturn1WhenPlayerIsX() {
        assertThat(player.getPlayerNum(), is(1));
    }
}