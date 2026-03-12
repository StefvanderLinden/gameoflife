package com.capgemini.gameoflife;

public interface BlockField {
    default boolean[][] getBoard(){
        return new boolean[20][20];
    }
}
