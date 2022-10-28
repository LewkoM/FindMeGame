package Drawing;

import Main.Panel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.Objects;


public class Figures extends Draw{

    Panel panel;
    Draw[] figures;

    public Figures (Panel panel)  {
        this.panel = panel;

        figures = new Draw[16];
        FiguresImages();
        RandomFig();
        RandomPosBoxes();
        WantedFigure();
        ///////

    }


    public void FiguresImages()  {

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

    public void draw (Graphics2D graph){

        System.out.println("Figura "+wantedFigName + " X: " + wantedFigX + " Y: "+wantedFigY);
        graph.drawImage(figures[figNum[0]].img, XdrawPos[0] , YdrawPos[0], null);
        System.out.println(displayString);
       //System.out.println("   X1: " + XdrawPos[0]+ "   Y1: " + YdrawPos[0]);
        graph.drawImage(figures[figNum[1]].img, XdrawPos[1] , YdrawPos[1], null);
       // System.out.println("Miejsce 2 " + figNum[1]);
        graph.drawImage(figures[figNum[2]].img, XdrawPos[2] , YdrawPos[2], null);
       // System.out.println("Miejsce 3 " + figNum[2]);
        graph.drawImage(figures[figNum[3]].img, XdrawPos[3] , YdrawPos[3],  null);
        //System.out.println("Miejsce 4 " + figNum[3]);
        graph.drawImage(figures[figNum[4]].img, XdrawPos[4] , YdrawPos[4],  null);
        //System.out.println("Miejsce 5 " + figNum[4]);
        graph.drawImage(figures[figNum[5]].img, XdrawPos[5] , YdrawPos[5],  null);
        //System.out.println("Miejsce 6 " + figNum[5]);
        graph.drawImage(figures[figNum[6]].img, XdrawPos[6] , YdrawPos[6],  null);
        //System.out.println("Miejsce 7 " + figNum[6]);
        graph.drawImage(figures[figNum[7]].img, XdrawPos[7] , YdrawPos[7], null);
        //System.out.println("Miejsce 8 " + figNum[7]);
        graph.drawImage(figures[figNum[8]].img, XdrawPos[8] , YdrawPos[8],  null);
        //System.out.println("Miejsce 9 " + figNum[8]);
        graph.drawImage(figures[figNum[9]].img, XdrawPos[9] , YdrawPos[9],  null);
        //System.out.println("Miejsce 10 " + figNum[9]);




    }
}
