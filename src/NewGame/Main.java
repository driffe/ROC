package NewGame;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JButton[][] mapArr  = new JButton[10][10];
        int[][] map = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }
        };
        JFrame frame = new JFrame("Omok");
        Omok o = new Omok();
        Menu m = new Menu();

        o.board(frame);
        o.omakMap(mapArr, frame, map);
        m.createMenu();
    }
}
