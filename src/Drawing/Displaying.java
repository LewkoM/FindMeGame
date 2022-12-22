package Drawing;
import Major.PanelG;
import java.awt.*;
import static Drawing.Draw.displayString;
import static Drawing.Draw.lvl;
/**
 * Class that displays statements on the screen
 */
public class Displaying{
    /**
     * Font types
     */
    Font fontSerif,fontArial;
    Font fontHelvetica;
    Font fontRoman;
    PanelG panel;

    final String textMenu = "Menu:";

    final String textRestart = "Restart game";

    final String textBack = "Back";

    final String textClose = "Close game";
    /**
     * Bad choice statement
     */
    final String textBadChoice = "BAD CHOICE! LEVEL RESTARTED!";
    /**
     * Good choice statement
     */
    final String textGoodChoice = "GOOD CHOICE! LEVEL UP!";
    /**
     * Correct ending game statement
     */
    final String textEndGame = "YOU WON THE GAME! CONGRATULATIONS!";
    /**
     * Single game time statement
     */
    final String finalGameTime = "YOUR TIME IS: ";
    String secZero;
    /**
     * If to display required object name
     */
    boolean displayFindme=true;
    /**
     * If the choice was not correct
     */
    boolean displayTryAgain=false;
    /**
     * if the choice was correct
     */
    boolean displayGood=false;
    /**
     * number of current menu choice line
     */
    public int line=0;
    /**
     * Max level since the game is on
     */
    public int maxLvl=0;
    /**
     * Time to display statement with required object name
     */
    int findmeTime=0;
    /**
     * Time to display bad/good choice statement
     */
    int tryAgainTime=0;
    /**
     * Counted minutes
     */
    int minutes;
    /**
     * Counted seconds
     */
    int seconds;
    /**
     * Counting time variable
     */
    int counter;

    /**
     * Displaying constructor that sets font types
     * @param panel game panel
     */
    public Displaying(PanelG panel){
        this.panel=panel;

        fontSerif = new Font("Stylus", Font.BOLD, 35);
        fontArial = new Font("Arial", Font.PLAIN, 30);
        fontHelvetica = new Font("Helvetica", Font.BOLD, 40);
        fontRoman = new Font("Roman", Font.BOLD, 33);

    }
    /**
     * Method that display action statements on the screen
     * @param graph Graphics2D
     */
    public void drawTask(Graphics2D graph){


        if(displayFindme){
            graph.setFont(fontHelvetica);
            graph.setColor(Color.black);
            int textX = panel.screenWidth/2 - textWidthFunc(displayString,graph)/2;
            graph.drawString(displayString, textX, 600);
            findmeTime++;
        }
        if(findmeTime > 240){
            displayFindme = false;
            findmeTime=0;
        }

        if(displayTryAgain){
            graph.setFont(fontRoman);
            graph.setColor(Color.red);
            int textX = panel.screenWidth/2 - textWidthFunc(textBadChoice,graph)/2;
            graph.drawString(textBadChoice, textX, 520);

            tryAgainTime++;
        }
        if(tryAgainTime > 120){
            displayTryAgain = false;
            tryAgainTime=0;
        }

        if(displayGood){
            graph.setFont(fontRoman);
            graph.setColor(Color.green);
            int textX = panel.screenWidth/2 - textWidthFunc(textGoodChoice,graph)/2;
            graph.drawString(textGoodChoice, textX, 520);

            tryAgainTime++;
        }
        if(tryAgainTime > 120){
            displayGood = false;
            tryAgainTime=0;
        }
    }
    /**
     * Method that drawn level/time iformation and Menu options
     * @param graph Graphics2D
     */
    public void drawDispl(Graphics2D graph){

        if(lvl >= maxLvl){
            maxLvl=lvl;
        }
        if(panel.gameState==panel.playState){
            graph.setColor(Color.black);
            graph.setFont(fontSerif);
            graph.drawString("Lvl: "+lvl,1040 , 760);
            graph.drawString("Best lvl: "+maxLvl,850 , 760);

            //time counting 60FPS- 60 refreshments in one second, every 60 refreshments one second is counted

            counter++;
            secZero="0";
            if(counter%60==0){
                seconds++;
                if(seconds%60==0){
                    minutes++;
                    seconds=0;
                }
            }
            if(seconds>9){
                secZero="";
            }
            graph.drawString("Time: "+minutes+":"+secZero+seconds,10 , 760);

            //stop time counting

        }

        if(panel.gameState== panel.menuState){
            graph.setColor(Color.black);

            int menuHeigh=280;
            int menuWidth=240;
            int menuX = panel.screenWidth/2 -menuWidth/2;
            int menuY = panel.screenHeight/2 -menuHeigh/2;

            graph.fillRoundRect(menuX,menuY,menuWidth,menuHeigh,30,30);
            graph.setColor(Color.white);
            graph.setFont(fontArial);


            graph.drawString(textMenu,menuX+(menuWidth/2 - textWidthFunc(textMenu,graph)/2), menuY+50);

            graph.drawString(textRestart,menuX+(menuWidth/2 - textWidthFunc(textRestart,graph)/2), menuY+140);
            if(line == 0){
                graph.drawString("___________",menuX+(menuWidth/2 - textWidthFunc(textRestart,graph)/2)-5, menuY+145);
                if(panel.key.enterPressed){
                    panel.figures.updateResetGame();
                    panel.gameState= panel.playState;

                }
            }

            graph.drawString(textClose,menuX+(menuWidth/2 - textWidthFunc(textClose,graph)/2), menuY+200);
            if(line == 1) {
                graph.drawString("__________",menuX+(menuWidth/2 - textWidthFunc(textClose,graph)/2)-5, menuY+205);
                if(panel.key.enterPressed){
                   System.exit(1);
                }
            }

            graph.drawString(textBack,menuX+(menuWidth/2 - textWidthFunc(textBack,graph)/2), menuY+260);
            if(line == 2) {
                graph.drawString("_____",menuX+(menuWidth/2 - textWidthFunc(textBack,graph)/2)-7, menuY+265);
                if(panel.key.enterPressed){
                    if(panel.previousState== panel.playState){
                        panel.gameState = panel.playState;
                        line =0;
                    }
                    if(panel.previousState== panel.endState){
                        panel.gameState = panel.endState;
                        line =0;
                    }

                }
            }

        }

    }
    /**
     * Method that display statements if the game is successfully completed
     * @param graph Graphics2D
     */
    public void EndGameDisp(Graphics2D graph){
        graph.setColor(Color.BLUE);
        graph.setFont(fontHelvetica);
        graph.drawString(textEndGame, panel.screenWidth/2 - textWidthFunc(textEndGame,graph)/2, 350);
        graph.drawString(finalGameTime +minutes+":"+secZero+seconds, panel.screenWidth/2 - textWidthFunc(finalGameTime,graph)/2 - 15, 450);
    }
    /**
     * Returning String width
     * @param text String text
     * @param graph Graphics2D
     */
    int textWidthFunc(String text, Graphics2D graph){
        return graph.getFontMetrics().stringWidth(text);
    }
}
