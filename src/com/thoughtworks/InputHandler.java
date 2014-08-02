package com.thoughtworks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

public class InputHandler {

    private BufferedReader reader;
    private PrintStream out;

    public InputHandler(PrintStream out, BufferedReader reader) {
        this.out = out;
        this.reader = reader;
    }

    public int getUserInput() {
        int inputNum = 0;
        try {
            String input = reader.readLine();
            inputNum = Integer.parseInt(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return inputNum;
    }
}
