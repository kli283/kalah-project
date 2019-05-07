package kalah;

import com.qualitascorpus.testsupport.IO;
import com.qualitascorpus.testsupport.TextIOAssertionException;

public class Controller {


    public void gameRun(IO io, Manager manager) {
        GameLogic gameLogic = new GameLogic();
        UI printer = manager.getGameUI();
        int validMove = 1;

        while (!gameEnd(manager)){
            Integer input = moveInput(manager.getGameIO(), manager);
            //player quits
            if (input.equals(-1)) {
                printer.gameOver(io);
                printer.drawBoard(io, manager);
                break;
            }
            validMove = gameLogic.playerMove(manager, input);
            if (validMove == 1) {
                manager.switchPlayer();
            } else if (validMove == 0) {
                printer.emptyHouse(io);
            }
        }
//        printer.gameOver(io);
//        printer.drawBoard(io, manager);
//        printer.printFinal(io, manager);

    }

    public boolean gameEnd(Manager manager) {
        int seedCount = 0;
        //checking if there are any seeds in the all houses
        for (House house : manager.getP1().getHouses()) {
            seedCount += house.getSeeds();
        }
        if (seedCount == 0) {
            return true;
        }
        return false;
    }


    public int moveInput(IO io, Manager manager) {
        Integer input;
        int cancelResult = -1;
        int invalidMove = -2;
        int maxHouses = manager.getCurrentPlayer().getPlayerHouses();
        manager.getGameUI().drawBoard(io, manager);

        int playerNum = manager.getCurrentPlayer().getPlayerId();

        String playerPrompt = "Player P" + playerNum + "'s turn - Specify house number or 'q' to quit: ";
        String quitString = "q";

//        io.println(playerPrompt);
        try {
            //Using readInteger because it accepts a range of int with one accepted string

            input = io.readInteger(playerPrompt, 0, maxHouses, cancelResult, quitString);
        } catch (TextIOAssertionException e){
            return cancelResult;
        }
        if (input.equals(cancelResult)){
            return cancelResult;
        } else if ((input > maxHouses) || (input < 0)) {
            return invalidMove;
        } else {
            // valid move
            return input;
        }
    }
}
