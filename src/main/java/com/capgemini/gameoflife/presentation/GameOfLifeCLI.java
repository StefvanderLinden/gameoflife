package com.capgemini.gameoflife.presentation;

public class GameOfLifeCLI implements Display {

    private String getDisplay(boolean[][] board) {
        var output = "";
        for (boolean[] line: board) {
            for (boolean value: line) {
                if (value) {
                    output += "[X]";
                } else {
                    output += "[ ]";
                }
            }
            output += "\n";
        }
        return output;
    }

    @Override
    public void show(boolean[][] board) {
        System.out.println(getDisplay(board));
    }

    @Override
    public boolean isPaused() {
        return false;
    }
}