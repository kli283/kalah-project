package kalah;

import com.qualitascorpus.testsupport.IO;
import com.qualitascorpus.testsupport.TextIOAssertionException;

public class Controller {
    private Player p1 = new Player();
    private Player p2 = new Player();
    private int playerNum = 1;

    public void startMove(IO io) {
        new UI().drawBoard(io, p1, p2);
        int input;
        String playerPrompt = "Player " + playerNum + "'s turn - Specify house number or 'q' to quit: ";
        String quitString = "q";
        int quitValue = -1;

        try {
            //Using readInteger because it accepts a range of int with one accepted string
            input = io.readInteger(playerPrompt, 0, p1.getPlayerHouses(), quitValue, quitString);
        } catch (TextIOAssertionException e){
            input = quitValue;
        }



    }
}
