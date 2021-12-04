package NewGame;

import javax.swing.*;
import java.awt.*;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Omok {
    private int turn = 1;
    private RowDirection[] dirs;
    private int[][] map;
    Omok(int[][] map){
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
    //Give turn to players
    public int playerTurn() {
        if(turn % 2 == 1) {
            return 1;
        } else {
            return 2;
        }
    }

    public void updateTurn() {
        turn++;
    }

    public int getSquare(int i, int j) {
        return map[i][j];
    }

    public void updateSquare(int i, int j) {
        map[i][j] = playerTurn();
    }

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
