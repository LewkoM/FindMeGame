package Major;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyMove implements KeyListener {

    public boolean upPressed, downPressed, rightPressed, leftPressed, textHint;

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int x = e.getKeyCode();
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
        if(x == KeyEvent.VK_H){
            textHint = true;
        }
    }

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
        if(x == KeyEvent.VK_H){
            textHint = false;
        }
    }
}
