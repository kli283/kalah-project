package kalah;

import com.qualitascorpus.testsupport.IO;
import com.qualitascorpus.testsupport.TextIOAssertionException;

public class Controller {

    private int playerNum = 1;


    public void gameRun(Manager manager) {
        while (!gameEnd(manager)){
            int input = moveInput(manager.getGameIO(), manager);
            //player quits
            if (input == -1) {
                break;
            } else {

            }
        }


    }

    public boolean gameEnd(Manager manager) {
        int seedCount = 0;
        //checking if there are any seeds in the all houses
        for (House house : manager.getP1().getHouses()) {
            seedCount += house.getSeeds().size();
        }
        if (seedCount == 0) {
            return true;
        }
        return false;
    }


    public int moveInput(IO io, Manager manager) {
        int input;
        int maxHouses = manager.getP1().getPlayerHouses();
        manager.getGameUI().drawBoard(io, manager.getP1(), manager.getP2());

        String playerPrompt = "Player " + playerNum + "'s turn - Specify house number or 'q' to quit: ";
        String quitString = "q";

        int quitValue = -1;
        try {
            //Using readInteger because it accepts a range of int with one accepted string
            input = io.readInteger(playerPrompt, 0, maxHouses, quitValue, quitString);
        } catch (TextIOAssertionException e){
            return quitValue;
        }

        if ((input > maxHouses) || (input < 0)) {
            return quitValue;
        } else {
            return input;
        }




    }
}
