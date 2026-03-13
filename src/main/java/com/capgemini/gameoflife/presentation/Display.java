package com.capgemini.gameoflife.presentation;

public interface Display {
    void show(boolean[][] board);
    boolean isPaused();
}
