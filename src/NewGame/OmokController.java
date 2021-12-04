package NewGame;

import javax.swing.*;
/**
 * class for control the omok. Call omokModel and omokView, and able to control them
 * @author Seyoung Oh
 * @author Dominic Reed
 * @author Travis Cheng
 */
public class OmokController {
    OmokModel omokModel;
    OmokView omokView;
    OmokController(OmokModel omokModel, OmokView omokView) {
        this.omokModel = omokModel;
        this.omokView = omokView;
        omokView.controller = this;
        omokView.board();
        omokView.omakMap();
    }
    /**
     * Class for checking the winner and whether it's occupied or not, everytime the players put their color on the board.
     * @param i
     * @param j
     */
    public void eventButton(int i, int j) {
        if(omokModel.getSquare(i,j) != 0) {
            JOptionPane.showMessageDialog(null, "This is already occupied");
            return;
        }
        omokModel.updateSquare(i, j);
        if(omokModel.playerTurn() == 1) {
            omokView.paintRed(i,j);
            if(omokModel.checkWinner(i,j)) {
                JOptionPane.showMessageDialog(null, "Player1(Red) is winner");
                System.exit(0);
            }
        } else {
            omokView.paintYellow(i,j);
            if(omokModel.checkWinner(i,j)) {
                JOptionPane.showMessageDialog(null, "Player2(Yellow) is winner");
                System.exit(0);
            }
        }
        omokModel.updateTurn();
        System.out.println("------------------------------------");
    }
}
