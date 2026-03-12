package com.capgemini.gameoflife;

import java.util.Arrays;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        System.out.println("Hello World!");
        GameBoard testBoard = new GameBoard();
        testBoard.addGlider();
        boolean[][] gameboard = testBoard.getBoard();
        System.out.println(Arrays.deepToString(gameboard));


    }
}
