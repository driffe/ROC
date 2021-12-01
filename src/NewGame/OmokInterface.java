package NewGame;

import javax.swing.*;

public interface OmokInterface {
    int playerTurn(int turn);
    int checkWinner(int[][] map);
    void board(JFrame frame);
    void omakMap(JButton[][] mapArr, JFrame frame, int[][] map);
    void paintRed(JButton[][] mapArr, int i, int j);
    void paintYellow(JButton[][] mapArr, int i, int j);
}
