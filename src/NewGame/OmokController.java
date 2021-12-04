package NewGame;

import javax.swing.*;

public class OmokController {
    Omok omok;
    OmokBoard omokBoard;
    OmokController(Omok omok, OmokBoard omokBoard) {
        this.omok = omok;
        this.omokBoard =omokBoard;
        omokBoard.controller = this;
        omokBoard.board();
        omokBoard.omakMap();
    }
    public void eventButton(int i, int j) {
        if(omok.getSquare(i,j) != 0) {
            JOptionPane.showMessageDialog(null, "This is already occupied");
            return;
        }
        omok.updateSquare(i, j);
        if(omok.playerTurn() == 1) {
            omokBoard.paintRed(i,j);
            if(omok.checkWinner(i,j)) {
                JOptionPane.showMessageDialog(null, "Player1(Red) is winner");
                System.exit(0);
            }
        } else {
            omokBoard.paintYellow(i,j);
            if(omok.checkWinner(i,j)) {
                JOptionPane.showMessageDialog(null, "Player2(Yellow) is winner");
                System.exit(0);
            }
        }
        omok.updateTurn();
        System.out.println("------------------------------------");
    }
}
