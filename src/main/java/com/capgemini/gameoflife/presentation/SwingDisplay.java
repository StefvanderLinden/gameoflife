package com.capgemini.gameoflife.presentation;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import java.awt.*;

public class SwingDisplay implements Display {
        private JPanel fullboardpanel;
        private JButton[][] allButtons;

    public SwingDisplay() {
        JFrame frame = new JFrame("Happy Coding");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        fullboardpanel = new JPanel();
        BoxLayout boxLayoutManager = new BoxLayout(fullboardpanel, BoxLayout.Y_AXIS);
        fullboardpanel.setLayout(boxLayoutManager);

        allButtons = new JButton[20][20];

        for (int j = 0; j < 20; j++) {
            JPanel panelrow = new JPanel();
            BoxLayout boxLayoutManagerRow = new BoxLayout(panelrow, BoxLayout.X_AXIS);
            panelrow.setLayout(boxLayoutManagerRow);
            JButton[] buttonRow = new JButton[20];

            for (int i = 0; i < 20; i++) {
                buttonRow[i] = new JButton(" ");
                panelrow.add(buttonRow[i]);
            }
            allButtons[j] = buttonRow;
            fullboardpanel.add(panelrow);
        }

        frame.add(fullboardpanel);


        frame.setSize(900, 800);
        frame.setVisible(true);
    }

    @Override
    public void show(boolean[][] board) {
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                allButtons[i][j].setBackground((board[i][j] ? Color.BLACK: Color.WHITE));
            }
        }


    }
}
