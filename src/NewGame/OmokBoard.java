package NewGame;

import javax.swing.*;
import java.awt.*;

public class OmokBoard {
    //Make frame with width 1280, height 828
     public static void board(JFrame frame) {
        frame.setVisible(true);
        frame.setSize(1280, 828);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    //Map for omakMap and able to click for change color.
    public static void omakMap(JButton[][] mapArr, JFrame frame, int[][] map) {
        JPanel pl = new JPanel();
        pl.setBackground(Color.DARK_GRAY);
        pl.setLayout((new GridLayout(10,10)));

        for(int i = 0; i < map.length; i++) {
            for(int j = 0; j < map[i].length; j++) {
                JButton temp = new JButton(i + " " + j);
                pl.add(temp);
                //Add color for player1
                if(map[j][i] == 1) {
                    temp.setBackground(Color.red);
                    temp.setOpaque(true);
                    temp.setBorderPainted(false);
                    temp.setFocusPainted(false);
                    temp.setBorderPainted(false);
                    //temp.addActionListener(instance);
                    temp.setActionCommand("1");
                    pl.add(temp);

                    //Add color for player2
                } else if(map[j][i] == 2) {
                    temp.setBackground(Color.yellow);
                    temp.setOpaque(true);
                    temp.setBorderPainted(false);
                    temp.setFocusPainted(false);
                    temp.setBorderPainted(false);
                    //temp.addActionListener(instance);
                    temp.setActionCommand("2");
                    pl.add(temp);

                    //Add obstacles in the middle
                }  else {
                    //temp.addActionListener(instance);
                    temp.setActionCommand("0");
                }
                mapArr[j][i] = temp;

                int finalI = i;
                int finalJ = j;

                mapArr[finalJ][finalI].addActionListener(event1 ->{
                    if(Omok.playerTurn(Omok.turn) == 1) {
                        if(map[finalJ][finalI] == 2) {
                            JOptionPane.showMessageDialog(null, "This is already occupied");
                        } else {
                            Omok.outputX = finalI;
                            Omok.outputY = finalJ;
                            int outputX = Omok.outputX;
                            int outputY = Omok.outputY;
                            paintRed(mapArr, outputY, outputX);
                            map[outputY][outputX] = 1;
                            if(Omok.checkWinner(map) == 1) {
                                JOptionPane.showMessageDialog(null, "Player1(Red) is winner");
                                System.exit(0);
                            }
                            Omok.turn++;
                        }

                    } else {
                        if(map[finalJ][finalI] == 1) {
                            JOptionPane.showMessageDialog(null, "This is already occupied");
                        } else {
                            Omok.outputX = finalI;
                            Omok.outputY = finalJ;
                            int outputX = Omok.outputX;
                            int outputY = Omok.outputY;
                            paintYellow(mapArr, outputY, outputX);
                            map[outputY][outputX] = 2;
                            if(Omok.checkWinner(map) == 1) {
                                JOptionPane.showMessageDialog(null, "Player2(yellow) is winner");
                                System.exit(0);
                            }
                            Omok.turn++;
                        }
                    }
                    System.out.println("------------------------------------");
                });
            }
        }
        frame.add(pl);
    }
    public static void paintRed(JButton[][] mapArr, int i, int j) {
        JButton temp = mapArr[i][j];
        temp.setBackground(Color.red);
        temp.setOpaque(true);
        temp.setBorderPainted(false);
        temp.setFocusPainted(false);
        temp.setBorderPainted(false);
    }
    //When button is clicked, change it with yellow(player2) color
    public static void paintYellow(JButton[][] mapArr, int i, int j) {
        JButton temp = mapArr[i][j];
        temp.setBackground(Color.yellow);
        temp.setOpaque(true);
        temp.setBorderPainted(false);
        temp.setFocusPainted(false);
        temp.setBorderPainted(false);
    }
}
