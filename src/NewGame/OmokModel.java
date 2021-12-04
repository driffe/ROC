package NewGame;

import javax.swing.*;
import java.awt.*;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * Class for model of Omok with methods regarding turns of players.
 */
public class OmokModel {
    private int turn = 1;
    private RowDirection[] dirs;
    private int[][] map;
    OmokModel(int[][] map){
        this.map = map;
        initDirs();
    }
    private void initDirs() {
        dirs = new RowDirection[8];
        dirs[0] = (int[] coords) -> coords[1]--; // left
        dirs[1] = (int[] coords) -> coords[1]++; // right
        dirs[2] = (int[] coords) -> coords[0]--; // up
        dirs[3]= (int[] coords) -> coords[0]++; // down
        dirs[4] = (int[] coords) -> {coords[0]--;coords[1]++;}; // up right
        dirs[6] = (int[] coords) -> {coords[0]--;coords[1]--;}; // up left
        dirs[5]= (int[] coords) -> {coords[0]++;coords[1]--;}; // down left
        dirs[7] = (int[] coords) -> {coords[0]++;coords[1]++;}; //down right
    }

    /**
     * Checks to see whos turn it is
     * @return 1 for player 1; 2 for player 2
     */
    //Give turn to players
    public int playerTurn() {
        if(turn % 2 == 1) {
            return 1;
        } else {
            return 2;
        }
    }

    /**
     * Updates turn for each player
     */
    public void updateTurn() {
        turn++;
    }

    /**
     * Gets square/coordinates from the Omok board
     * @param i
     * @param j
     * @return
     */
    public int getSquare(int i, int j) {
        return map[i][j];
    }

    /**
     * Updates the square/coordinate
     * @param i
     * @param j
     */
    public void updateSquare(int i, int j) {
        map[i][j] = playerTurn();
    }

    /**
     * This uses getOccurencesInDirection method to find out if player has won the game.
     * @param x
     * @param y
     * @return boolean
     */
    //Check winner if the player satisfied all winning condition.
    public boolean checkWinner(int x, int y) {
        int check = playerTurn();
        for (int i = 0; i < dirs.length; i +=2) {
            int first = CheckRow.getOccurencesInDirection(map, new int[]{x, y}, check, dirs[i]);
            int second = CheckRow.getOccurencesInDirection(map, new int[]{x, y}, check, dirs[i+1]);
            System.out.println(first + " " + second);
            if(first+second >= 4) return true;
        }
        return false;
    }
}
