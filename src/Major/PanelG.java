package Major;
import Drawing.Displaying;
import Drawing.Draw;
import Drawing.Figures;
import Drawing.Player;
import javax.swing.*;
import java.awt.*;

/**
 * Game panel class with screen refreshing implementation
 */
public class PanelG extends JPanel implements Runnable{
    /**
     * State of game (current/previous)
     */
    public  int gameState, previousState;
    public final int playState = 1;
    public final int menuState = 3;
    public final int endState = 2;
    /**
     * Frames per second
     */
    final float FPS=60;
    /**
     * Size of the basic screen box- 48x48px
     */
    public final int basicSizeBox = 48;
    /**
     * Screen columns
     */
    final int columns = 24;
    /**
     * Screen rows
     */
    final int rows = 16;
    /**
     * Width of the screen
     */
    public final int screenWidth = basicSizeBox * columns; // 48x24 = 1152px
    /**
     * Height of the screen
     */
    public final int screenHeight = basicSizeBox * rows; // 48x16 = 768px

    public KeyMove key = new KeyMove(this);
    public Figures figures = new Figures(this);

    Thread gameThread;

    public Player player = new Player(this, key);
    public Displaying newDisp = new Displaying(this);

    /**
     * Game panel constructor with screen settings
     */
    public PanelG(){
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setDoubleBuffered(true);
        this.addKeyListener(key);
        this.setFocusable(true);
    }
    /**
     * Method that sets the initial state of the game
     */
    public void stateOfGame(){
        gameState=playState;
    }
    /**
     * Method that starts the game thread
     */
    public void startThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    /**
     * Screen refresh method- 60 frames per second
     */
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
    /**
     * Method consists of instructions, which sets the game state after specific action
     */
    public void update(){

        if(gameState==playState){
            previousState=playState;
            player.update();

            if(figures.nextLvl){
                Draw.lvl++;
                player.PlayerSettings();
                figures.updateGood();

                figures.nextLvl=false;
            }

            if(figures.gameOver){

                Draw.lvl=1;

                player.PlayerSettings();
                figures.updateBad();

                figures.gameOver=false;
            }
        }
    }
    /**
     * Method that draws objects on the screen (60 times per sec)
     */
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D graph = (Graphics2D)g;

        if(gameState==playState){
            graph.clearRect(0,0, screenWidth, screenHeight);

            player.drawBack(graph);
            player.drawPlayer(graph);
            figures.drawFig(graph);
            newDisp.drawTask(graph);
            newDisp.drawDispl(graph);

        }

        if(gameState==menuState){
            graph.clearRect(0,0, screenWidth, screenHeight);
            player.drawBack(graph);
            player.drawPlayer(graph);
            newDisp.drawDispl(graph);
        }

        if(gameState==endState){
            graph.clearRect(0,0, screenWidth, screenHeight);
            player.drawBack(graph);
            newDisp.EndGameDisp(graph);
        }

        graph.dispose();
    }
}
