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

    private void fillSquares(int[][] positions){
        for (int[] row: positions)
            this.board[row[0]][row[1]] = true;
    }

    public void addGlider(){
        int[][] positions = {  { 0, 1 }, { 1, 2 } , { 2, 0 }, { 2, 1 }, {2, 2} };
        fillSquares(positions);
    }

    public void nextPhase(){
        //true becomes false unless 2 or 3 neighbors
        //false becomes true if exactly 3 neighbors
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                int neighborCount = countNeighbors(row, col);
            }
        }

    }

    private int countNeighbors(int row, int column){
        int neighborCount = 0;
        for (int r = Math.min(row - 1, 0); r < Math.max(20, row + 1); r++){
            for (int c = Math.min(column - 1, 0); c < Math.max(20, column + 1); c++){
                if (board[r][c]){
                    neighborCount += 1;
                }
            }
        }
        return neighborCount;
    }
}
