package Main;

import Drawing.Draw;

import java.awt.*;


public class ScreenDisp {

    Panel panel;
    Font fontCastellar;
    Font fontHelvetica;
    String text;
    boolean displayFindme=true;
    int findmeTime=0;
    int lvl;

    public ScreenDisp(Panel panel){
        this.panel=panel;
        fontCastellar = new Font("Helvetica", Font.BOLD, 20);
        fontHelvetica = new Font("Helvetica", Font.ITALIC, 40);
        Draw draw = new Draw();
        text = draw.displayString;
        lvl = draw.lvl;
    }



    public void draw(Graphics2D graph){
       graph.setFont(fontCastellar);
        graph.setColor(Color.black);
        graph.drawString("lvl: "+lvl,1100 , 760);
        if(displayFindme){
            graph.setFont(fontHelvetica);
            graph.setColor(Color.red);
            int textWidth = graph.getFontMetrics().stringWidth(text);
            int textX = panel.screenWidth/2 - textWidth/2; 
            graph.drawString(text, textX, 600);
            findmeTime++;
        }
        if(findmeTime > 90){
            displayFindme = false;
            findmeTime=0;
        }

    }
}
