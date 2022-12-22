package Major;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
/**
 * Class Keymove with key implementation
 */
public class KeyMove implements KeyListener {
    /**
     * Variables related to pressed keys on user's keyboard
     */
    public boolean upPressed, downPressed, rightPressed, leftPressed, enterPressed;
    PanelG panel;
    /**
     * Keymove constructor
     * @param panel game panel
     */
    public KeyMove (PanelG panel){
        this.panel=panel;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    /**
     * Method that takes action when keys pressed
     */
    @Override
    public void keyPressed(KeyEvent e) {
        int x = e.getKeyCode();

        if(panel.gameState == panel.playState){
            panel.previousState= panel.playState;
            if(x == KeyEvent.VK_UP){
                upPressed = true;
            }
            if(x == KeyEvent.VK_DOWN){
                downPressed = true;
            }
            if(x == KeyEvent.VK_RIGHT){
                rightPressed = true;
            }
            if(x == KeyEvent.VK_LEFT){
                leftPressed = true;
            }
            if(x == KeyEvent.VK_M){
                panel.gameState=panel.menuState;
            }
        }

        else if(panel.gameState == panel.menuState){

            if(x == KeyEvent.VK_ENTER){
                enterPressed=true;
            }

            if(x == KeyEvent.VK_DOWN){
                if(panel.newDisp.line==0){
                    panel.newDisp.line=1;
                }
                else if(panel.newDisp.line==1){
                    panel.newDisp.line=2;
                }
                else if(panel.newDisp.line==2){
                    panel.newDisp.line=0;
                }
            }
            if(x == KeyEvent.VK_UP){
                if(panel.newDisp.line==0){
                    panel.newDisp.line=2;
                }
                else if(panel.newDisp.line==1){
                    panel.newDisp.line=0;
                }
                else if(panel.newDisp.line==2){
                    panel.newDisp.line=1;
                }
            }
        }

        else if(panel.gameState == panel.endState){
            panel.previousState= panel.endState;
            if(x == KeyEvent.VK_M){
                panel.gameState=panel.menuState;
            }
        }
    }

    /**
     * Method that takes action when keys released
     */
    @Override
    public void keyReleased(KeyEvent e) {
        int x = e.getKeyCode();

        if(x == KeyEvent.VK_UP){
           upPressed = false;
        }
        if(x == KeyEvent.VK_DOWN){
            downPressed = false;
        }
        if(x == KeyEvent.VK_RIGHT){
            rightPressed = false;
        }
        if(x == KeyEvent.VK_LEFT){
            leftPressed = false;
        }
        if(x == KeyEvent.VK_ENTER){
            enterPressed = false;
        }
    }
}
