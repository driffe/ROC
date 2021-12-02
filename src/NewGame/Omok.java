package NewGame;

import javax.swing.*;
import java.awt.*;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Omok {
    public static int outputX = 0;
    public static int outputY = 0;
    public static int turn = 1;
    static RowDirection[] dirs;
    private static void initDirs() {
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
    public static int playerTurn(int turn) {
        if(turn % 2 == 1) {
            return 1;
        } else {
            return 2;
        }
    }
    //Check winner if the player satisfied all winning condition.
    public static int checkWinner(int[][] map) {
        int check = playerTurn(turn);
        initDirs();
        for (int i = 0; i < dirs.length; i +=2) {
            int first = CheckRow.getOccurencesInDirection(map, new int[]{outputY, outputX}, check, dirs[i]);
            int second = CheckRow.getOccurencesInDirection(map, new int[]{outputY, outputX}, check, dirs[i+1]);
            System.out.println(first + " " + second);
            if(first+second >= 4) return 1;
        }
        return 0;
    }
}
