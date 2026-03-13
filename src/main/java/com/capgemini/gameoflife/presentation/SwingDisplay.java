package com.capgemini.gameoflife.presentation;

import com.capgemini.gameoflife.BlockField;
import com.capgemini.gameoflife.GameBoard;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingDisplay implements Display {
    private JPanel fullboardpanel;
    private JButton[][] allButtons;
    private BlockField gameBoard;
    private boolean paused;

    public SwingDisplay(BlockField gameBoard) {
        this.gameBoard = gameBoard;
        JFrame frame = new JFrame("Happy Coding");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        fullboardpanel = new JPanel();
        BoxLayout boxLayoutManager = new BoxLayout(fullboardpanel, BoxLayout.Y_AXIS);
        fullboardpanel.setLayout(boxLayoutManager);

        allButtons = new JButton[20][20];

        paused = true;

        for (int j = 0; j < 20; j++) {
            final int row = j;
            JPanel panelrow = new JPanel();
            BoxLayout boxLayoutManagerRow = new BoxLayout(panelrow, BoxLayout.X_AXIS);
            panelrow.setLayout(boxLayoutManagerRow);
            JButton[] buttonRow = new JButton[20];

            for (int i = 0; i < 20; i++) {
                final int column = i;
                buttonRow[i] = new JButton(" ");
                buttonRow[i].addActionListener(e -> {
                    updateBoard(row, column);
                });
                panelrow.add(buttonRow[i]);
            }
            allButtons[j] = buttonRow;
            fullboardpanel.add(panelrow);
        }

        JButton pauseButton = new JButton("PAUSE/UNPAUSE");
        pauseButton.setActionCommand("pause");
        pauseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (paused) {
                    System.out.println("UNPAUSE");
                    paused = false;
                } else {
                    paused = true;
                }

            }
        });
        fullboardpanel.add(pauseButton);
        frame.add(fullboardpanel);


        frame.setSize(900, 800);
        frame.setVisible(true);
        frame.setTitle("Game of Life");
    }

    public boolean isPaused() {
        return this.paused;
    }

    @Override
    public void show(boolean[][] board) {
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                allButtons[i][j].setBackground((board[i][j] ? Color.BLACK : Color.WHITE));
            }
        }


    }

    private void updateBoard(int row, int column) {
        System.out.println(row);
        System.out.println(column);
        gameBoard.fillSquare(row, column);
        show(gameBoard.getBoard());
    }

}
