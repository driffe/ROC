package NewGame;

import javax.swing.*;
import java.awt.*;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Omok implements OmokInterface{
    static int outputX = 0;
    static int outputY = 0;
    static int turn = 1;

    public int playerTurn(int turn) {
        if(turn % 2 == 1) {
            return 1;
        } else {
            return 2;
        }
    }
    public int checkWinner(int[][]map) {
        int check = playerTurn(turn);
        int _x = 0;
        int _y = 0;
        int count = 0;
        // 가로 체크 코드
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
        if(count == 5) {
            return 1;
        }

        // 세로 체크 코드
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
                // System.out.println(count+"오목체크");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            return 0;
        }

        if(count == 5) {
            //System.out.println(name + "승리");
            return 1;
        }

        // 대각선 ↗
        _x = outputX;
        _y = outputY;
        count = 0;
        try{
            while(map[_y][_x] == check && _y > 0 && _x > 0) {
                _y++;
                _x--;
            }
            while(map[--_y < 0 ? 0 : _y][++_x] == check && _y <= 10 && _x <= 10) {
                // omok[][] 에서 y 값에 조건문을 넣은 이유는 a, 1 을 입력시
                // y 값이 -1 로 음수값으로 넘어가면 오류를 출력해서 조정해 주었습니다.
                count++;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            return 0;
        }

        if(count == 5) {
            return 1;
        }

        return 0;
    }
    public void board(JFrame frame) {
        frame.setVisible(true);
        frame.setSize(1280, 828);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
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
    public void paintRed(JButton[][] mapArr, int i, int j) {
        JButton temp = mapArr[i][j];
        temp.setBackground(Color.red);
        temp.setOpaque(true);
        temp.setBorderPainted(false);
        temp.setFocusPainted(false);
        temp.setBorderPainted(false);
    }
    public void paintYellow(JButton[][] mapArr, int i, int j) {
        JButton temp = mapArr[i][j];
        temp.setBackground(Color.yellow);
        temp.setOpaque(true);
        temp.setBorderPainted(false);
        temp.setFocusPainted(false);
        temp.setBorderPainted(false);
    }
}
