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
        boolean[][] newBoard = board.clone();
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                int neighborCount = countNeighbors(row, col);
                //3 or 4 neightbors because neighborcount includes the cell itself
                if(board[row][col] && (neighborCount < 3 || neighborCount > 4) ){
                    System.out.println("MADE FALSE" + row + col);
                    newBoard[row][col] = false;
                }else if(!board[row][col] && neighborCount == 3){
                    //TODO this never seems to happen?
                    System.out.println("MADE TRUE" + row + col);
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
                if(row == 1 && column == 0){
                    //TODO why does this count 2 neighbors instead of 3? 0 1 is counted as false; because it was removed? even though I made a new game board
                    System.out.println(r + " " + c + board[r][c]);
                }
            }
        }
        if(!board[row][column]){
            System.out.println("Neighbors" + row + " " + column + ": " + neighborCount);
        }
        return neighborCount;
    }
    //these 2 copied from GameOfLifeCLU
    private String getDisplay() {
        var output = "";
        for (boolean[] line: board) {
            for (boolean value: line) {
                if (value) {
                    output += "[X]";
                } else {
                    output += "[ ]";
                }
            }
            output += "\n";
        }
        return output;
    }

    public void show() {
        System.out.println(getDisplay());
    }
}
