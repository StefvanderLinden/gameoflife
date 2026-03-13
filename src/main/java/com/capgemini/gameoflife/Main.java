package com.capgemini.gameoflife;

import com.capgemini.gameoflife.presentation.Display;
import com.capgemini.gameoflife.presentation.SwingDisplay;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        BlockField gameBoard = new GameBoard();
        Display gameDisplay = new SwingDisplay(gameBoard);

//        gameBoard.addGlider();S

        boolean paused = gameDisplay.isPaused();
        gameDisplay.show(gameBoard.getBoard());
        while (true) {
            if (!gameDisplay.isPaused()) {
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
