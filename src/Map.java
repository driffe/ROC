import javax.swing.*;
import java.awt.*;
import java.util.*;

public class Map {
    JFrame frame = new JFrame("Hexxagon");
    public void Board() {
        frame.setVisible(true);
        frame.setSize(1280, 828);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    public void CreateMap() {
        JButton mapArr [][] = new JButton[7][7];
        JPanel pl = new JPanel();
        pl.setBackground(Color.DARK_GRAY);
        pl.setLayout((new GridLayout(7,7)));

        for(int i = 0; i < mapArr.length; i++) {
            for(int j = 0; j < mapArr[i].length; j++) {
                JButton temp = new JButton(i + " " + j);
                pl.add(temp);

                //Add color for player1
                if((i == 0 && j == 0) || (i == mapArr.length - 1 && j == mapArr.length - 1)) {
                    temp.setBackground(Color.red);
                    temp.setOpaque(true);
                    temp.setBorderPainted(false);
                    temp.setFocusPainted(false);
                    temp.setBorderPainted(false);
                    pl.add(temp);

                //Add color for player2
                } else if((i == mapArr.length - 1 && j ==0) || (i == 0 && j == mapArr.length - 1)) {
                    temp.setBackground(Color.yellow);
                    temp.setOpaque(true);
                    temp.setBorderPainted(false);
                    temp.setFocusPainted(false);
                    temp.setBorderPainted(false);
                    pl.add(temp);

                //Add obstacles in the middle
                } else if((i == 2 && j == 3) || (i == 4 && j == 3)) {
                    temp.setBackground(new Color(0x402904));
                    temp.setOpaque(true);
                    temp.setBorderPainted(false);
                    temp.setFocusPainted(false);
                    temp.setBorderPainted(false);
                    pl.add(temp);
                }
                mapArr[i][j] = temp;
            }
        }

        frame.add(pl);
    }

}
