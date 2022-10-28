package Mechanics;

import Main.KeyMove;
import Main.Panel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class Player extends World {

    Panel panel;
    KeyMove key;

    public Player (Panel panel, KeyMove key) {
        this.panel=panel;
        this.key = key;
        PlayerSettings();
        PlayerIMG();
    }

    public void PlayerSettings() {

        xPos = 540;
        yPos = 696;
        moveSpeed = 5;

    }

    public void PlayerIMG() {
        try{

            img = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/PlayerIMG/mushroom.png")));

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

    public void draw(Graphics2D graph){

        graph.drawImage(img, xPos,yPos, panel.basicSizeBox * 3/2,panel.basicSizeBox * 3/2,null);
    }
}
