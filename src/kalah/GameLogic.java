package kalah;

public class GameLogic {
    GameBoard gameBoard = new GameBoard();

    public int playerMove(Manager manager, int inputHouse) {

        Player currentPlayer = manager.getCurrentPlayer();
        Player otherPlayer = manager.otherPlayer();


        int seedAmount = currentPlayer.getHouse(inputHouse -1).getSeeds();

        if (seedAmount == 0) {
            //empty house
            return 0;
        }

        currentPlayer.getHouse(inputHouse - 1).removeSeeds();

        for (int i = inputHouse; i < gameBoard.getInitHouses(); i++) {
            if (seedAmount > 0) {
                currentPlayer.getHouse(i).incrementSeeds();
                seedAmount--;
//                System.out.println("BLAAAHHHH");
                if (seedAmount == 0){
                    System.out.println(currentPlayer.getHouse(i).getSeeds());

                    if (currentPlayer.getHouse(i).getSeeds() == 1) {
                        System.out.println("ATTEMPTING CAPTURE");
                        if (!otherPlayer.getHouse(gameBoard.getInitHouses() - i).isEmpty()) {

                            System.out.println("ALMOST CAPTURE");
                            capture(currentPlayer, otherPlayer, i);
                        }
                    }
                }
            }
        }

        Player tempOtherPlayer = otherPlayer;
        while (seedAmount > 0) {
            if (tempOtherPlayer == otherPlayer) {
                currentPlayer.addScore();
                seedAmount--;
                if (seedAmount == 0) {
                    return 2;
                }
            }
            for (int i = 0; i < gameBoard.getInitHouses(); i++) {
                tempOtherPlayer.getHouse(i).incrementSeeds();
                seedAmount--;
                if (seedAmount == 0) {
                    if (currentPlayer.getHouse(i).getSeeds() == 1) {
                        if (tempOtherPlayer == currentPlayer) {
                            System.out.println("ATTEMPTING CAPTURE");
                            System.out.println(i);
                            if (!otherPlayer.getHouse(gameBoard.getInitHouses() - i).isEmpty()) {

                                System.out.println("ALMOST CAPTURE");
                                capture(currentPlayer, otherPlayer, i);
                            }
                        }
                    }
                    return 1;
                }
            }

            if (tempOtherPlayer == currentPlayer){
                tempOtherPlayer = otherPlayer;
            } else {
                tempOtherPlayer = currentPlayer;
            }
        }
        return 1;
    }

    //Function for capturing seeds
    public void capture(Player currentPlayer, Player otherPlayer, int index) {
        System.out.println(index);
        int oppositeIndex = gameBoard.getInitHouses() - index - 1;
        int oppositeSeeds = otherPlayer.getHouse(oppositeIndex).getSeeds();
        if (otherPlayer.getHouse(oppositeIndex).getSeeds() == 0) {
            System.out.println("FAIL EMPTY");
        } else{
            otherPlayer.getHouse(oppositeIndex).removeSeeds();
            currentPlayer.addScore();
            currentPlayer.captureSeeds(oppositeSeeds);
            currentPlayer.getHouse(index).removeSeeds();
        }
    }
}
