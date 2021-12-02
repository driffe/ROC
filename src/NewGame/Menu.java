package NewGame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame implements ActionListener {
    static JMenuBar mb;
    static JMenu screenMenu;
    static JMenuItem description, rule;
    static JLabel label;
    static JFrame f;

    public void createMenu() {
        Menu menu = new Menu();

        f = new JFrame("Menu demo");
        mb = new JMenuBar();
        //menu
        screenMenu = new JMenu("Project Omok");
        //label
        label = new JLabel("Team ROC Final Project", JLabel.CENTER);
        //submenu of Project Omok
        description = new JMenuItem("Description");
        rule = new JMenuItem("Rule");
        // Add ActionListener to menuItems
        description.addActionListener(menu);
        rule.addActionListener(menu);
        //Add menu items to menu
        screenMenu.add(description);
        screenMenu.add(rule);
        //Add menu to menu bar
        mb.add(screenMenu);

        f.setJMenuBar(mb);
        f.add(label);
        f.setTitle("Omok Game");
        f.setSize(500, 500);
        f.setVisible(true);
    }
    public void actionPerformed(ActionEvent e)
    {
        String s = e.getActionCommand();
        if(s.equalsIgnoreCase("description")) {
            label.setText("We made Omok game When you satisfied the winning condition, End the program.");

        } else if(s.equalsIgnoreCase("rule")) {
            label.setText(("Make 5 in a row (row, column, diagonal) The Red start first."));
        }

        // set the label to the menuItem that is selected
    }
}
