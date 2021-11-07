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
        JButton mapArr [][] = new JButton[6][6];
        JPanel pl = new JPanel();
        pl.setBackground(Color.DARK_GRAY);
        pl.setLayout((new GridLayout(6,7)));

        for(int i = 0; i < mapArr.length; i++) {
            for(int j = 0; j < mapArr[i].length; j++) {
                JButton temp = new JButton(i + " " + j);
                pl.add(temp);
                mapArr[i][j] = temp;
            }
        }
        frame.add(pl);
    }

}
