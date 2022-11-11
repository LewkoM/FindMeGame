package Drawing;

import Major.KeyMove;
import Major.PanelG;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class Player {

    public int xPos;
    public int yPos;
    public int moveSpeed;
    public BufferedImage img, imgBack;


    PanelG panel;
    KeyMove key;


    public Player (PanelG panel, KeyMove key) {
        this.panel=panel;
        this.key = key;

        PlayerSettings();
        PlayerBackIMG();
    }
    public Player(){

    }

    public void PlayerSettings() {

        xPos = 540;
        yPos = 696;
        moveSpeed = 5;

    }

    public void PlayerBackIMG() {
        try{

            img = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/PlayerIMG/mushroom.png")));
            imgBack = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Background/greenback.png")));
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    public void update(){
        if(key.rightPressed){
            if(xPos < 1080) {

                xPos+=moveSpeed;
            }
        }
        if(key.leftPressed){
            if(xPos >= 0) {
                xPos -= moveSpeed;
            }
        }
        if(key.upPressed){
            if(yPos > 0) {
                yPos -= moveSpeed;
            }
        }
        if(key.downPressed){
            if(yPos < 696) {
                yPos += moveSpeed;
            }
        }


    }

    public void drawPlay(Graphics2D graph){

        graph.drawImage(img, xPos,yPos, panel.basicSizeBox * 3/2,panel.basicSizeBox * 3/2,null);
    }
    public void drawBack(Graphics2D graph){

        graph.drawImage(imgBack, 0,0,null);
    }

}
