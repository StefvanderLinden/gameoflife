package com.capgemini.gameoflife.presentation;

public class GameOfLifeCLI {
    boolean[][] myNumbers = {
            {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false},
            {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false},
            {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false},
            {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false},
            {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false},
            {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false},
            {false, false, false, false, false, false, true,  false, true,  true,  false, true,  true,  false, false, false, false, false, false, false},
            {false, false, false, false, false, false, true,  true,  false, false, true,  false, true,  true,  false, false, false, false, false, false},
            {false, false, false, false, false, false, false, true,  true,  true,  false, true,  true,  false, false, false, false, false, false, false},
            {false, false, false, false, false, false, true,  false, false, true,  true,  true,  false, true,  false, false, false, false, false, false},
            {false, false, false, false, false, false, true,  true,  true,  false, true,  false, true,  true,  false, false, false, false, false, false},
            {false, false, false, false, false, false, false, false, true,  true,  true,  true,  false, false, false, false, false, false, false, false},
            {false, false, false, false, false, false, true,  true,  false, false, true,  true,  true,  false, false, false, false, false, false, false},
            {false, false, false, false, false, false, false, true,  true,  false, true,  true,  false, true,  false, false, false, false, false, false},
            {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false},
            {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false},
            {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false},
            {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false},
            {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false},
            {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false}
    };

    private String getDisplay() {
        var output = "";
        for (boolean[] line: myNumbers) {
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

    public void show() {
        System.out.println(getDisplay());
    }
}