package Drawing;
import java.awt.image.BufferedImage;
import java.util.Random;
/**
 * Class related to generating unique objects (figures/solids) and their position on the screen
 */
public class Draw {
    /**
     * Variable related to uploading images
     */
    public BufferedImage img;
    /**
     * Int array with numbers of figures/solid that will be drawn on the screen
     */
    int[] figNum = new int[10];
    /**
     * Int array with X-position of i-figure/solid (i(0-9))
     */
    int[] XdrawPos = new int[10];
    /**
     * Int array with Y-position of i-figure/solid (i(0-9))
     */
    int[] YdrawPos = new int[10];
    /**
     * X and Y position of correct/required figure or solid drawn on the screen
     */
    public static int wantedFigX, wantedFigY;
    /**
     * A name of the required object
     */
    public static String wantedFigName;
    /**
     * A String announcement of correct object
     */
    public static String displayString;
    /**
     * Auxiliary variable to randomizing objects
     */
    public static int varRandWantedFig;
    /**
     * Current game lvl
     */
    public static int lvl=1;

    /**
     * Method that randomizes 10 unique numbers
     */
    public void RandomFig() {

        Random rand = new Random();

        for (int i = 0; i < 10; i++) {
            int whatFig = rand.nextInt(16);
            boolean clone = false;
            for (int k=0; k <10; k++){
                if (whatFig == figNum[k]) {
                    clone = true;
                    break;
                }
            }
            if(!clone){
                figNum[i]=whatFig;
            }
            else{
                i--;
            }
        }
    }
    /**
     * Method that randomizes 10 unique objects X and Y-position on the screen
     */
    public void RandomPosBoxes() {
        int x, y;
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
                y = randY.nextInt(112) + 530;
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
    /**
     * Method that assigns a name to a correct object
     */
    public void WantedFigure(){
        varRandWantedFig=0;
        Random rand = new Random();
        varRandWantedFig = rand.nextInt(10);
        wantedFigX = XdrawPos[varRandWantedFig];
        wantedFigY = YdrawPos[varRandWantedFig];
        if(lvl >=1 && lvl <=5)
        {
            switch (figNum[varRandWantedFig]) {

                case 0:
                    wantedFigName = "BLACK CIRCLE";
                    break;
                case 1:
                    wantedFigName = "BLACK RECTANGLE";
                    break;
                case 2:
                    wantedFigName = "BLACK SQUARE";
                    break;
                case 3:
                    wantedFigName = "BLACK TRIANGLE";
                    break;
                case 4:
                    wantedFigName = "BLUE CIRCLE";
                    break;
                case 5:
                    wantedFigName = "BLUE RECTANGLE";
                    break;
                case 6:
                    wantedFigName = "BLUE SQUARE";
                    break;
                case 7:
                    wantedFigName = "BLUE TRIANGLE";
                    break;
                case 8:
                    wantedFigName = "RED SQUARE";
                    break;
                case 9:
                    wantedFigName = "RED TRIANGLE";
                    break;
                case 10:
                    wantedFigName = "RED CIRCLE";
                    break;
                case 11:
                    wantedFigName = "RED RECTANGLE";
                    break;
                case 12:
                    wantedFigName = "YELLOW SQUARE";
                    break;
                case 13:
                    wantedFigName = "YELLOW RECTANGLE";
                    break;
                case 14:
                    wantedFigName = "YELLOW CIRCLE";
                    break;
                case 15:
                    wantedFigName = "YELLOW TRIANGLE";
                    break;
                default:
                    System.out.println("Figure's name error!");
            }
            displayString = "FIND A " + wantedFigName + "!";
        }
        if(lvl >=6 && lvl <=10)
        {
            switch (figNum[varRandWantedFig]) {

                case 0:
                    wantedFigName = "BLACK SPHERE";
                    break;
                case 1:
                    wantedFigName = "BLACK CUBOID";
                    break;
                case 2:
                    wantedFigName = "BLACK CUBE";
                    break;
                case 3:
                    wantedFigName = "BLACK CONE";
                    break;
                case 4:
                    wantedFigName = "BLUE SPHERE";
                    break;
                case 5:
                    wantedFigName = "BLUE CUBOID";
                    break;
                case 6:
                    wantedFigName = "BLUE CUBE";
                    break;
                case 7:
                    wantedFigName = "BLUE CONE";
                    break;
                case 8:
                    wantedFigName = "RED CUBE";
                    break;
                case 9:
                    wantedFigName = "RED CONE";
                    break;
                case 10:
                    wantedFigName = "RED SPHERE";
                    break;
                case 11:
                    wantedFigName = "RED CUBOID";
                    break;
                case 12:
                    wantedFigName = "YELLOW CUBE";
                    break;
                case 13:
                    wantedFigName = "YELLOW CUBOID";
                    break;
                case 14:
                    wantedFigName = "YELLOW SPHERE";
                    break;
                case 15:
                    wantedFigName = "YELLOW CONE";
                    break;
                default:
                    System.out.println("Figure's name error!");
            }

            displayString = "FIND A " + wantedFigName + "!";

        }

    }


}







