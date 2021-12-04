package NewGame;

import javax.swing.*;
/**
 * Main class for getting all functions. Able to view menu and Omok board to play.
 * @author Seyoung Oh
 * @author Dominic Reed
 * @author Travis Cheng
 */
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
        OmokModel o = new OmokModel(map);
        OmokView board = new OmokView(mapArr, frame);

        Menu m = new Menu();

        OmokController controller = new OmokController(o, board);
        m.createMenu();
    }
}
