package Drawing;

import Major.PanelG;

import java.awt.*;

import static Drawing.Draw.lvlpom;

public class Displaying{
    Font fontSerif;
    Draw drawP;

    public Displaying(Draw drawP){
        this.drawP=drawP;

        fontSerif = new Font("Serif", Font.BOLD, 40);
    }


    public void drawDispl(Graphics2D graph){
        graph.setColor(Color.black);
        graph.setFont(fontSerif);
        graph.drawString("lvl: "+lvlpom,1040 , 760);
        //if(Figures.gameOver){
         //   graph.drawString(,500 , 350);
       // }



    }

}
