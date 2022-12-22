package Drawing;

import Major.PanelG;
import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.Objects;

/**
 * Class related to uploading and drawing objects (figures/solids), and collision detection
 */
public class Figures extends Draw{
    Graphics2D graph;
    /**
     * Says if game is over 
     */
    public  boolean gameOver=false;
    /**
     * Says if the object choice is correct 
     */
    public boolean nextLvl=false;
    PanelG panel;
    /**
     * Draw array of figures
     */
    Draw[] figures;
    /**
     * Figures constructor
     * @param panel game panel
     */
    public Figures (PanelG panel)  {
        super();
        this.panel = panel;

        figures = new Draw[16];
        figuresImages();
        RandomFig();
        RandomPosBoxes();
        WantedFigure();
    }
    /**
     * Method that uploads figures/solids images
     */
    public void figuresImages()  {
        if( lvl<=5 && lvl >=1)
        {
            try {
                figures[0] = new Draw();
                figures[0].img = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/FIGNEW/BlackCircle.png")));

                figures[1] = new Draw();
                figures[1].img = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/FIGNEW/BlackRectangle.png")));

                figures[2] = new Draw();
                figures[2].img = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/FIGNEW/BlackSquare.png")));

                figures[3] = new Draw();
                figures[3].img = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/FIGNEW/BlackTriangle.png")));

                figures[4] = new Draw();
                figures[4].img = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/FIGNEW/BlueCircle.png")));

                figures[5] = new Draw();
                figures[5].img = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/FIGNEW/BlueRectangle.png")));

                figures[6] = new Draw();
                figures[6].img = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/FIGNEW/BlueSquare.png")));

                figures[7] = new Draw();
                figures[7].img = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/FIGNEW/BlueTriangle.png")));

                figures[8] = new Draw();
                figures[8].img = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/FIGNEW/RedSquare.png")));

                figures[9] = new Draw();
                figures[9].img = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/FIGNEW/RedTriangle.png")));

                figures[10] = new Draw();
                figures[10].img = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/FIGNEW/RedCircle.png")));

                figures[11] = new Draw();
                figures[11].img = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/FIGNEW/RedRectangle.png")));

                figures[12] = new Draw();
                figures[12].img = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/FIGNEW/YellowSquare.png")));

                figures[13] = new Draw();
                figures[13].img = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/FIGNEW/YellowRectangle.png")));

                figures[14] = new Draw();
                figures[14].img = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/FIGNEW/YellowCircle.png")));

                figures[15] = new Draw();
                figures[15].img = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/FIGNEW/YellowTriangle.png")));



            }catch (IOException e){

                e.printStackTrace();

            }
        }


        if(lvl >=6 && lvl <=10)
        {
            try {
                figures[0] = new Draw();
                figures[0].img = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/SOLIDS/BlackSphere.png")));

                figures[1] = new Draw();
                figures[1].img = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/SOLIDS/BlackCuboid.png")));

                figures[2] = new Draw();
                figures[2].img = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/SOLIDS/BlackCube.png")));

                figures[3] = new Draw();
                figures[3].img = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/SOLIDS/BlackCone.png")));

                figures[4] = new Draw();
                figures[4].img = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/SOLIDS/BlueSphere.png")));

                figures[5] = new Draw();
                figures[5].img = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/SOLIDS/BlueCuboid.png")));

                figures[6] = new Draw();
                figures[6].img = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/SOLIDS/BlueCube.png")));

                figures[7] = new Draw();
                figures[7].img = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/SOLIDS/BlueCone.png")));

                figures[8] = new Draw();
                figures[8].img = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/SOLIDS/RedCube.png")));

                figures[9] = new Draw();
                figures[9].img = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/SOLIDS/RedCone.png")));

                figures[10] = new Draw();
                figures[10].img = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/SOLIDS/RedSphere.png")));

                figures[11] = new Draw();
                figures[11].img = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/SOLIDS/RedCuboid.png")));

                figures[12] = new Draw();
                figures[12].img = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/SOLIDS/YellowCube.png")));

                figures[13] = new Draw();
                figures[13].img = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/SOLIDS/YellowCuboid.png")));

                figures[14] = new Draw();
                figures[14].img = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/SOLIDS/YellowSphere.png")));

                figures[15] = new Draw();
                figures[15].img = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/SOLIDS/YellowCone.png")));



            }catch (IOException e){

                e.printStackTrace();

            }
        }
    }
    /**
     * Method that detects a collision between player and drawn objects
     */
    public void detection() {

        Rectangle playerArea = new Rectangle(panel.player.xPos + 6, panel.player.yPos + 12, 60, 60);

            if (playerArea.intersects(new Rectangle(XdrawPos[varRandWantedFig], YdrawPos[varRandWantedFig], 50, 50))){
                nextLvl=true;
            }
            else if(playerArea.intersects(new Rectangle(XdrawPos[0], YdrawPos[0], 50, 50)) && varRandWantedFig!=0){
                gameOver=true;
            }
            else if(playerArea.intersects(new Rectangle(XdrawPos[1], YdrawPos[1], 50, 50))&& varRandWantedFig!=1){
                gameOver=true;
            }
            else if(playerArea.intersects(new Rectangle(XdrawPos[2], YdrawPos[2], 50, 50))&& varRandWantedFig!=2){
                gameOver=true;
            }
            else if(playerArea.intersects(new Rectangle(XdrawPos[3], YdrawPos[3], 50, 50))&& varRandWantedFig!=3){
                gameOver=true;
            }
            else if(playerArea.intersects(new Rectangle(XdrawPos[4], YdrawPos[4], 50, 50))&& varRandWantedFig!=4){
                gameOver=true;
            }
            else if(playerArea.intersects(new Rectangle(XdrawPos[5], YdrawPos[5], 50, 50))&& varRandWantedFig!=5){
                gameOver=true;
            }
            else if(playerArea.intersects(new Rectangle(XdrawPos[6], YdrawPos[6], 50, 50))&& varRandWantedFig!=6){
                gameOver=true;
            }
            else if(playerArea.intersects(new Rectangle(XdrawPos[7], YdrawPos[7], 50, 50))&& varRandWantedFig!=7){
                gameOver=true;
            }
            else if(playerArea.intersects(new Rectangle(XdrawPos[8], YdrawPos[8], 50, 50))&& varRandWantedFig!=8){
                gameOver=true;
            }
            else if(playerArea.intersects(new Rectangle(XdrawPos[9], YdrawPos[9], 50, 50))&& varRandWantedFig!=9){
                gameOver=true;
            }
    }
    /**
     * Updates when the choice is correct
     */
    public void updateGood(){
        if(lvl==11){
            panel.gameState=panel.endState;
            lvl=1;
        }
        figuresImages();
        RandomFig();
        RandomPosBoxes();
        WantedFigure();

        panel.newDisp.findmeTime=0;
        panel.newDisp.displayFindme=true;
        panel.newDisp.displayGood=true;
    }
    /**
     * Updates when the choice is not correct
     */
    public void updateBad(){
        figuresImages();
        RandomFig();
        RandomPosBoxes();
        WantedFigure();

        panel.newDisp.findmeTime=0;
        panel.newDisp.displayFindme=true;
        panel.newDisp.displayTryAgain=true;
    }
    /**
     * Updates when the game is to be restarted by the user
     */
    public void updateResetGame(){
        panel.newDisp.seconds=0;
        panel.newDisp.minutes=0;
        lvl=1;
        figuresImages();
        RandomFig();
        RandomPosBoxes();
        WantedFigure();
        panel.player.PlayerSettings();
        panel.newDisp.displayGood=false;
        panel.newDisp.findmeTime=0;
        panel.newDisp.displayFindme=true;
    }
    /**
     * Method that draws 10 objects on the screen
     * @param graph Graphics2D
     */
    public void drawFig(Graphics2D graph){
        this.graph = graph;
        detection();
        figuresDrawing();

        //System.out.println("Figura "+wantedFigName + " X: " + wantedFigX + " Y: "+wantedFigY); // help display in the terminal
        //System.out.println(displayString);


    }
    /**
     * Addition to the drawing method
     */
    public void figuresDrawing(){
        graph.drawImage(figures[figNum[0]].img, XdrawPos[0] , YdrawPos[0], null);
        graph.drawImage(figures[figNum[1]].img, XdrawPos[1] , YdrawPos[1], null);
        graph.drawImage(figures[figNum[2]].img, XdrawPos[2] , YdrawPos[2], null);
        graph.drawImage(figures[figNum[3]].img, XdrawPos[3] , YdrawPos[3],  null);
        graph.drawImage(figures[figNum[4]].img, XdrawPos[4] , YdrawPos[4],  null);
        graph.drawImage(figures[figNum[5]].img, XdrawPos[5] , YdrawPos[5],  null);
        graph.drawImage(figures[figNum[6]].img, XdrawPos[6] , YdrawPos[6],  null);
        graph.drawImage(figures[figNum[7]].img, XdrawPos[7] , YdrawPos[7], null);
        graph.drawImage(figures[figNum[8]].img, XdrawPos[8] , YdrawPos[8],  null);
        graph.drawImage(figures[figNum[9]].img, XdrawPos[9] , YdrawPos[9],  null);
    }
}
