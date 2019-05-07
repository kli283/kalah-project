package kalah;

public class GameLogic {

    public int playerMove(Manager manager, int inputHouse) {
        inputHouse--;
        Player currentPlayer = manager.getCurrentPlayer();
        if (currentPlayer.isTop()) {
            inputHouse = 5 - inputHouse;
        }

        int seedAmount = currentPlayer.getHouse(inputHouse).getSeeds();
        if (seedAmount == 0) {
            //empty house
            return 0;
        }
        currentPlayer.getHouse(inputHouse).removeSeeds();
        while (seedAmount > 0) {
            if (!currentPlayer.isTop()){
                inputHouse++;
            } else {
                inputHouse--;
            }

            if (inputHouse == -1) {
                currentPlayer.addScore();
            }
            else if (inputHouse < -1) {
                manager.otherPlayer().getHouse(-inputHouse - 2).incrementSeeds();
            }
            else if (inputHouse == 6) {
                currentPlayer.addScore();
            }
            else if (inputHouse > 6) {
                manager.otherPlayer().getHouse(-inputHouse + 12).incrementSeeds();
            }
            else {
                currentPlayer.getHouse(inputHouse).incrementSeeds();
            }

            seedAmount--;

            if ((seedAmount == 0)&&((inputHouse == -1)||(inputHouse == 6))) {
                return 2;
            }
        }
        return 1;
    }
}
