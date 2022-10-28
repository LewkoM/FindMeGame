package Drawing;

import java.awt.image.BufferedImage;
import java.util.Random;

public class Draw {
    public int x = 0, y = 0;
    public BufferedImage img;
    int[] figNum = new int[10];
    int[] XdrawPos = new int[10];
    int[] YdrawPos = new int[10];
    public int wantedFigX, wantedFigY;
    public String wantedFigName;
    public String displayString;
    public int lvl=1;


    public void RandomFig() {

        Random rand = new Random();

        for (int i = 0; i < 10; i++) {
            int whatFig = rand.nextInt(16);
            boolean clone = false;
            // System.out.println("Nr petli to: "+i+ "Losowa to: "+whatFig );
            for (int k=0; k <10; k++){
                if (whatFig == figNum[k]) {
                    clone = true;
                    break;
                }
            }
            if(!clone){
                figNum[i]=whatFig;
                //System.out.println("to jest liczba: " + (i+1) + " i wynosi:           " + figNum[i]);
            }
            else{
                i--;
            }
        }
    }

    public void RandomPosBoxes() {

        Random randX = new Random();
        Random randY = new Random();

        for (int i = 0; i < 10; i++) {
            if (i < 4) {
                y = randY.nextInt(160);
                YdrawPos[i] = y;
            }
            if (i >= 4 && i < 8) {
                y = randY.nextInt(112) + 304;
                YdrawPos[i] = y;
            } else if (i == 8 || i == 9) {
                y = randY.nextInt(112) + 560;
                YdrawPos[i] = y;
            }
        }

        for (int i = 0; i < 10; i++) {
            if (i == 0 || i == 4 || i == 8) {
                x = randX.nextInt(144);
                XdrawPos[i] = x;
            }
            if (i == 1 || i == 5) {
                x = randX.nextInt(141) + 288;
                XdrawPos[i] = x;
            } else if (i == 2 || i == 6) {
                x = randX.nextInt(144) + 576;
                XdrawPos[i] = x;
            }
            if (i == 3 || i == 7 || i == 9) {
                x = randX.nextInt(192) + 864;
                XdrawPos[i] = x;
            }
        }
    }

    public void WantedFigure(){
        int xHelp;
        Random rand = new Random();
        xHelp = rand.nextInt(10);
        wantedFigX = XdrawPos[xHelp];
        wantedFigY = YdrawPos[xHelp];



        switch(figNum[xHelp]){
            case 0:
                wantedFigName ="BLACK CIRCLE";break;
            case 1:
                wantedFigName ="BLACK RECTANGLE";break;
            case 2:
                wantedFigName ="BLACK SQUARE";break;
            case 3:
                wantedFigName ="BLACK TRIANGLE";break;
            case 4:
                wantedFigName ="BLUE CIRCLE";break;
            case 5:
                wantedFigName ="BLUE RECTANGLE";break;
            case 6:
                wantedFigName ="BLUE SQUARE";break;
            case 7:
                wantedFigName ="BLUE TRIANGLE";break;
            case 8:
                wantedFigName ="RED SQUARE";break;
            case 9:
                wantedFigName ="RED TRIANGLE";break;
            case 10:
                wantedFigName ="RED CIRCLE";break;
            case 11:
                wantedFigName ="RED RECTANGLE";break;
            case 12:
                wantedFigName ="YELLOW SQUARE";break;
            case 13:
                wantedFigName ="YELLOW RECTANGLE";break;
            case 14:
                wantedFigName ="YELLOW CIRCLE";break;
            case 15:
                wantedFigName ="YELLOW TRIANGLE";break;
            default:
                System.out.println("Figure's name error!");
        }
        displayString = "FIND A " + wantedFigName + "!";


    }

}







