package Main;

import Drawing.Figures;
import Main.KeyMove;
import Mechanics.Player;
import Mechanics.World;

import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel implements Runnable{

    final int FPS=60;
    public final int basicSizeBox = 48;
    final int columns = 24;
    final int rows = 16;
    final int screenWidth = basicSizeBox * columns; // 48x24 = 1152px
    final int screenHeight = basicSizeBox * rows; // 48x16 = 768px



    KeyMove key = new KeyMove();
    Figures figures = new Figures(this);

    public ScreenDisp scrDisp = new ScreenDisp(this);
    Thread gameThread;
    Player player = new Player(this, key);




    public Panel(){
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.lightGray);
        this.setDoubleBuffered(true);
        this.addKeyListener(key);
        this.setFocusable(true);
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

        player.update();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D graph = (Graphics2D)g;
        scrDisp.draw(graph);
        figures.draw(graph);
        player.draw(graph);
        graph.dispose();
    }
}
