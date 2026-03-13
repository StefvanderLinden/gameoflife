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

        return this.board;
    }

    public void fillSquare(int row,int column) {
        board[row][column] = true;
    }

    private void fillSquares(int[][] positions){
        for (int[] row: positions)
            this.board[row[0]][row[1]] = true;
    }

    private void addGlider(){
        int[][] positions = {  { 0, 1 }, { 1, 2 } , { 2, 0 }, { 2, 1 }, {2, 2} };
        fillSquares(positions);
    }

    public void nextPhase(){
        //true becomes false unless 2 or 3 neighbors
        //false becomes true if exactly 3 neighbors
        boolean[][] newBoard = Arrays.stream(board).map(boolean[]::clone).toArray(boolean[][]::new);

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                int neighborCount = countNeighbors(row, col);
                //3 or 4 neightbors because neighborcount includes the cell itself
                if(board[row][col] && (neighborCount < 3 || neighborCount > 4) ){
                    newBoard[row][col] = false;
                }else if(!board[row][col] && neighborCount == 3){
                    newBoard[row][col] = true;
                }
            }
        }
        board = newBoard.clone();
    }

    private int countNeighbors(int row, int column){
        int neighborCount = 0;
        for (int r = Math.max(row - 1, 0); r < Math.min(20, row + 2); r++){
            for (int c = Math.max(column - 1, 0); c < Math.min(20, column + 2); c++){
                if (board[r][c]){
                    neighborCount += 1;
                }
            }
        }
        if(!board[row][column]){
        }
        return neighborCount;
    }

}
