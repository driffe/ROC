package NewGame;

import javax.swing.*;
import java.awt.*;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Omok implements OmokInterface{
    static int outputX = 0;
    static int outputY = 0;
    static int turn = 1;

    //Give turn to  players
    public int playerTurn(int turn) {
        if(turn % 2 == 1) {
            return 1;
        } else {
            return 2;
        }
    }
    //Check winner if the player satisfied all winning condition.
    public int checkWinner(int[][]map) {
        int check = playerTurn(turn);
        int _x = 0;
        int _y = 0;
        int count = 0;

        //check row
        _x = outputX;
        _y = outputY;
        count = 0;
        try{
            while(map[_y][_x] == check && _x > 0) {
            _x--;
            }

            while(map[_y][++_x] == check && _x <= 10) {
                count++;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            return 0;
        }
        //If there are five same color on map, that player is winner
        if(count == 5) {
            return 1;
        }

        // check column
        _x = outputX;
        _y = outputY;
        count = 0;
        try{
            while(map[_y][_x] == check && _y > 0) {
                _y--;
            }
            while(map[++_y][_x] == check && _y <= 10) {
                count++;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            return 0;
        }

        if(count == 5) {
            return 1;
        }

        _x = outputX;
        _y = outputY;
        count = 0;
        try{
            while(map[_y][_x] == check && _y > 0 && _x > 0) {
                _y--;
                _x--;
            }
            while(map[++_y][++_x] == check && _y <= 10 && _x <= 10) {
                count++;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            return 0;
        }
        //If there are five same color on map, that player is winner
        if(count == 5) {

            return 1;
        }

        // Check diagonal↗
        _x = outputX;
        _y = outputY;
        count = 0;
        try{
            while(map[_y][_x] == check && _y > 0 && _x > 0) {
                _y++;
                _x--;
            }
            while(map[--_y < 0 ? 0 : _y][++_x] == check && _y <= 10 && _x <= 10) {
                count++;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            return 0;
        }
        //If there are five same color on map, that player is winner
        if(count == 5) {
            return 1;
        }

        return 0;
    }
    //Make frame with width 1280, height 828
    public void board(JFrame frame) {
        frame.setVisible(true);
        frame.setSize(1280, 828);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    //Map for omakMap and able to click for change color.
    public void omakMap(JButton[][] mapArr, JFrame frame, int[][] map) {
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
                    if(playerTurn(turn) == 1) {
                        if(map[finalJ][finalI] == 2) {
                            JOptionPane.showMessageDialog(null, "This is already occupied");
                        } else {
                            outputX = finalI;
                            outputY = finalJ;
                            paintRed(mapArr, outputY, outputX);
                            map[outputY][outputX] = 1;
                            if(checkWinner(map) == 1) {
                                JOptionPane.showMessageDialog(null, "end");
                            }
                            turn = turn + 1;
                        }

                    } else {
                        if(map[finalJ][finalI] == 1) {
                            JOptionPane.showMessageDialog(null, "This is already occupied");
                        } else {
                            outputX = finalI;
                            outputY = finalJ;
                            paintYellow(mapArr, outputY, outputX);
                            map[outputY][outputX] = 2;
                            if(checkWinner(map) == 1) {
                                JOptionPane.showMessageDialog(null, "end");
                            }
                            turn = turn + 1;
                        }
                    }
                    System.out.println("------------------------------------");
                });
            }
        }
        frame.add(pl);
    }
    //When button is clicked, change it with red(player1) color
    public void paintRed(JButton[][] mapArr, int i, int j) {
        JButton temp = mapArr[i][j];
        temp.setBackground(Color.red);
        temp.setOpaque(true);
        temp.setBorderPainted(false);
        temp.setFocusPainted(false);
        temp.setBorderPainted(false);
    }
    //When button is clicked, change it with yellow(player2) color
    public void paintYellow(JButton[][] mapArr, int i, int j) {
        JButton temp = mapArr[i][j];
        temp.setBackground(Color.yellow);
        temp.setOpaque(true);
        temp.setBorderPainted(false);
        temp.setFocusPainted(false);
        temp.setBorderPainted(false);
    }
}
