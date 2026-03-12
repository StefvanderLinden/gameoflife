package com.capgemini.gameoflife;

import java.util.Arrays;

public class GameBoard implements BlockField {
    private boolean[][] board = new boolean[20][20];

    GameBoard(){
        this.board = new boolean[20][20];
        for (boolean[] row: board)
            Arrays.fill(row, false);
    }

    @Override
    public boolean[][] getBoard() {

        //System.out.println(Arrays.deepToString(this.board));
        return this.board;
    }
}
