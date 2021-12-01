package NewGame;

import javax.swing.*;

public class Menu extends JFrame {
    Menu() {
        setTitle("Omok Game");
        createMenu();
        setSize(250, 200);
        setVisible(true);
    }

    void createMenu() {
        JMenuBar mb = new JMenuBar();
        JMenu screenMenu = new JMenu("Project Omok");

        screenMenu.add(new JMenuItem("Description"));

        mb.add(screenMenu);
        mb.add(new JMenu("Rule"));

        setJMenuBar(mb);
    }
}
