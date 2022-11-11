package Major;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("Find me");

        PanelG panel = new PanelG();
        window.add(panel);
        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);
        panel.stateOfGame();


        panel.startThread();
    }

}
