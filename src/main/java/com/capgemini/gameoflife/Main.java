package com.capgemini.gameoflife;

import com.capgemini.gameoflife.presentation.GameOfLifeCLI;
import com.capgemini.gameoflife.testdata.TestData;

public class Main {
    public static void main(String[] args) {
        var board = TestData.testboard;

        System.out.println("hi");
        var cli = new GameOfLifeCLI();
        cli.show(board);
    }
}
