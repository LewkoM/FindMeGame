package Drawing;


import Major.PanelG;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.Objects;


public class Figures extends Draw{
    Graphics2D graph;
    public  boolean gameOver=false;
    public boolean nextLvl=false;
    PanelG panel;
    Draw[] figures;

    int x;
    int y;

    public Figures (PanelG panel)  {
        super();
        this.panel = panel;

        figures = new Draw[16];
        FiguresImages();
        RandomFig();
        RandomPosBoxes();
        WantedFigure();

    }


    public void FiguresImages()  {
        if( lvlpom<=5 && lvlpom >=1)
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


        if(lvlpom >=6 && lvlpom <=10)
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


    public void det() {
        x = panel.player.xPos;
        y = panel.player.yPos;


        Rectangle solidArea = new Rectangle(x + 6, y + 12, 60, 60);

            if (solidArea.intersects(new Rectangle(XdrawPos[xHelp], YdrawPos[xHelp], 50, 50))){
                System.out.println("prawidlowa figura");
                nextLvl=true;

            }
            else if(solidArea.intersects(new Rectangle(XdrawPos[0], YdrawPos[0], 50, 50)) && xHelp!=0){
                System.out.println("nieprawidlowa figura");
                gameOver=true;
            }
            else if(solidArea.intersects(new Rectangle(XdrawPos[1], YdrawPos[1], 50, 50))&& xHelp!=1){
            System.out.println("nieprawidlowa figura");
                gameOver=true;
            }
            else if(solidArea.intersects(new Rectangle(XdrawPos[2], YdrawPos[2], 50, 50))&& xHelp!=2){
                System.out.println("nieprawidlowa figura");
                gameOver=true;
            }
            else if(solidArea.intersects(new Rectangle(XdrawPos[3], YdrawPos[3], 50, 50))&& xHelp!=3){
                System.out.println("nieprawidlowa figura");
                gameOver=true;
            }
            else if(solidArea.intersects(new Rectangle(XdrawPos[4], YdrawPos[4], 50, 50))&& xHelp!=4){
                System.out.println("nieprawidlowa figura");
                gameOver=true;
            }
             else if(solidArea.intersects(new Rectangle(XdrawPos[5], YdrawPos[5], 50, 50))&& xHelp!=5){
                 System.out.println("nieprawidlowa figura");
                gameOver=true;
             }
             else if(solidArea.intersects(new Rectangle(XdrawPos[6], YdrawPos[6], 50, 50))&& xHelp!=6){
                 System.out.println("nieprawidlowa figura");
                gameOver=true;
             }
             else if(solidArea.intersects(new Rectangle(XdrawPos[7], YdrawPos[7], 50, 50))&& xHelp!=7){
                 System.out.println("nieprawidlowa figura");
                gameOver=true;
             }
             else if(solidArea.intersects(new Rectangle(XdrawPos[8], YdrawPos[8], 50, 50))&& xHelp!=8){
                 System.out.println("nieprawidlowa figura");
                gameOver=true;
             }
             else if(solidArea.intersects(new Rectangle(XdrawPos[9], YdrawPos[9], 50, 50))&& xHelp!=9){
                 System.out.println("nieprawidlowa figura");
                gameOver=true;
             }

    }

    public void updateGood(){
        FiguresImages();
        RandomFig();
        RandomPosBoxes();
        WantedFigure();


        displayFindme=true;
        displayGood=true;
    }

    public void updateBad(){
        FiguresImages();
        RandomFig();
        RandomPosBoxes();
        WantedFigure();


        displayFindme=true;
        displayTryAgain=true;
    }


    public void drawFig(Graphics2D graph){
        this.graph = graph;
        //if(panel.player.lvlpom )
        //FiguresImages();
        det();
        figuresDrawing();
        drawDraw(graph);

        System.out.println("Figura "+wantedFigName + " X: " + wantedFigX + " Y: "+wantedFigY);
        System.out.println(displayString);
        System.out.println("to jest xHelp"+xHelp);

    }
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
