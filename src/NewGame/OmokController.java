package NewGame;

import javax.swing.*;

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
