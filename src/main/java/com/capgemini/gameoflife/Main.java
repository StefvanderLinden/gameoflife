package com.capgemini.gameoflife;

import com.capgemini.gameoflife.presentation.GameOfLifeCLI;
import com.capgemini.gameoflife.presentation.SwingDisplay;
import com.capgemini.gameoflife.testdata.TestData;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        var gameBoard = new GameBoard();
        var gameDisplay = new SwingDisplay();

        gameBoard.addGlider();
//        int[][] positions = {{ 10, 10 },{ 10, 11 },{ 10, 12 }};
//        gameBoard.fillSquares(positions);

        gameDisplay.show(gameBoard.getBoard());
        while(true) {
            try {
                TimeUnit.MILLISECONDS.sleep(250);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            gameBoard.nextPhase();
            gameDisplay.show(gameBoard.getBoard());
        }
    }
}
