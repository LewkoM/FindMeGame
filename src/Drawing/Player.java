/**
 * Player, objects, statements drawn on the screen
 */
package Drawing;
import Major.KeyMove;
import Major.PanelG;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;
/**
 * Class connected with player (position, movement etc.)
 */
public class Player {
    /**
     * player X position
     */
    public int xPos;
    /**
     * player Y position
     */
    public int yPos;
    /**
     * player movement speed
     */
    public int moveSpeed;
    /**
     * variable related to uploading images
     */
    public BufferedImage img, imgBack;

    PanelG panel;
    KeyMove key;
    /**
     * Player class constructor
     *
     * @param panel game panel
     * @param key key implementation
     */
    public Player (PanelG panel, KeyMove key) {
        this.panel=panel;
        this.key = key;

        PlayerSettings();
        PlayerAndBackIMG();
    }
    /**
     * Method that sets player's params
     */
    public void PlayerSettings() {
        xPos = 540;
        yPos = 696;
        moveSpeed = 5;
    }
    /**
     * Method that uploads player and background image
     */
    public void PlayerAndBackIMG() {
        try{

            img = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/PlayerIMG/mushroom.png")));
            imgBack = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Background/greenback.png")));
        }catch (IOException e){
            e.printStackTrace();
        }

    }
    /**
     * Method consists of instructions which update the player's position
     */
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
    /**
     * Method that draws player on the screen
     * @param graph Graphics2D
     */
    public void drawPlayer(Graphics2D graph){

        graph.drawImage(img, xPos,yPos,panel.basicSizeBox*3/2,panel.basicSizeBox*3/2, null);
    }
    /**
     * Method that draws background screen
     * @param graph Graphics2D
     */
    public void drawBack(Graphics2D graph){

        graph.drawImage(imgBack, 0,0,null);
    }
}
