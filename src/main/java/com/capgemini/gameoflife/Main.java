package com.capgemini.gameoflife;

import com.capgemini.gameoflife.presentation.GameOfLifeCLI;
import com.capgemini.gameoflife.presentation.SwingDisplay;
import com.capgemini.gameoflife.testdata.TestData;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        var gameBoard = new GameBoard();
        var gameDisplay = new SwingDisplay(gameBoard);

//        gameBoard.addGlider();

        boolean paused = gameDisplay.getPaused();
        gameDisplay.show(gameBoard.getBoard());
        while (true) {
            if (gameDisplay.getPaused()) {
                gameBoard.nextPhase();
            }
            gameDisplay.show(gameBoard.getBoard());
            try {
                TimeUnit.MILLISECONDS.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
