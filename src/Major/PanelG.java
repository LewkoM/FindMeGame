package Major;

import Drawing.Displaying;
import Drawing.Draw;
import Drawing.Figures;
import Drawing.Player;
import javax.swing.*;
import java.awt.*;


public class PanelG extends JPanel implements Runnable{

    final float FPS=60;
    public final int basicSizeBox = 48;
    final int columns = 24;
    final int rows = 16;
    public final int screenWidth = basicSizeBox * columns; // 48x24 = 1152px
    public final int screenHeight = basicSizeBox * rows; // 48x16 = 768px


    KeyMove key = new KeyMove();
    Figures figures = new Figures(this);

    Thread gameThread;

   public Player player = new Player(this, key);
     Draw newDraw = new Draw();
     Displaying newDisp = new Displaying(newDraw);

    //stan gry
    public int gameState;
    public final int playState = 1;
    public final int pauseState = 0;


    public PanelG(){
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.lightGray);
        this.setDoubleBuffered(true);
        this.addKeyListener(key);
        this.setFocusable(true);

    }

    public void stateOfGame(){
        gameState=playState;


    }

    public void startThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {

        double drawInterval = 1000000000/FPS; // time in nanoseconds
        double delta = 0;
        long thenTime = System.nanoTime();
        long nowTime;

        while(gameThread != null){
            nowTime = System.nanoTime();
            delta += (nowTime - thenTime)/ drawInterval;
            thenTime = nowTime;

            if(delta >= 1){
                update();
                repaint();
                delta--;
            }
        }
    }

    public void update(){
        if(gameState==playState){
            player.update();

            if(figures.nextLvl){
                newDraw.lvlpom++;
                player.PlayerSettings();
                figures.updateGood();

                figures.nextLvl=false;

            }
            if(figures.gameOver){
                newDraw.lvlpom=1;
                player.PlayerSettings();
                figures.updateBad();

                figures.gameOver=false;
               // newDisp.drawDisp2();

            }
        }

    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D graph = (Graphics2D)g;


        player.drawBack(graph);
        player.drawPlay(graph);
        newDraw.drawDraw(graph);

        newDisp.drawDispl(graph);
        figures.drawFig(graph);


        graph.dispose();


    }
}
