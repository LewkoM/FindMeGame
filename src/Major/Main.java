
package Major;

import javax.swing.*;


/**
 * Main game class
 */
public class Main {
    /**
     * Main method that sets window params
     * @param args - args
     */
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
