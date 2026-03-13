package com.capgemini.gameoflife;

public interface BlockField {
    boolean[][] getBoard();
    void fillSquare(int row, int column);
    void nextPhase();
}
