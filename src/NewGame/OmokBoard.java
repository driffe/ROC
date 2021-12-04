package NewGame;

import javax.swing.*;
import java.awt.*;

public class OmokBoard {
    JButton[][] mapArr;
    JFrame frame;
    OmokController controller;
    OmokBoard(JButton[][] mapArr, JFrame frame) {
        this.mapArr = mapArr;
        this.frame = frame;

    }
    //Make frame with width 1280, height 828
     public void board() {
        frame.setVisible(true);
        frame.setSize(1280, 828);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    //Map for omakMap and able to click for change color.
    public void omakMap() {
        JPanel pl = new JPanel();
        pl.setBackground(Color.DARK_GRAY);
        pl.setLayout((new GridLayout(10,10)));

        for(int i = 0; i < mapArr.length; i++) {
            for(int j = 0; j < mapArr[i].length; j++) {
                JButton temp = new JButton(i + " " + j);
                pl.add(temp);
                temp.setActionCommand("0");
                mapArr[i][j] = temp;
                final int finalI = i;
                final int finalJ = j;
                mapArr[i][j].addActionListener(event1 ->controller.eventButton(finalI,finalJ));
            }
        }
        frame.add(pl);
    }
    public void paintRed(int i, int j) {
        JButton temp = mapArr[i][j];
        temp.setBackground(Color.red);
        temp.setOpaque(true);
        temp.setBorderPainted(false);
        temp.setFocusPainted(false);
        temp.setBorderPainted(false);
    }
    //When button is clicked, change it with yellow(player2) color
    public void paintYellow(int i, int j) {
        JButton temp = mapArr[i][j];
        temp.setBackground(Color.yellow);
        temp.setOpaque(true);
        temp.setBorderPainted(false);
        temp.setFocusPainted(false);
        temp.setBorderPainted(false);
    }
}
