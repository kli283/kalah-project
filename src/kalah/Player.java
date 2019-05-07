package kalah;

import java.util.ArrayList;

public class Player {
    private ArrayList<House> houses;
    private GameBoard gameBoard = new GameBoard();
    private Store playerStore ;
    private boolean isTop;
    private int playerId;


    public Player(int id, boolean top) {
        playerId = id;
        houses = new ArrayList<>();
        //populating the houses with the initial amount of seeds
        for (int i=0; i<gameBoard.getInitHouses(); i++) {
            houses.add(new House(gameBoard.getInitSeeds()));
        }
        playerStore = new Store();
        isTop = top;
    }

    public int getPlayerHouses() {
        return gameBoard.getInitHouses();
    }

    public ArrayList<House> getHouses() {
        return houses;
    }

    public House getHouse(int houseIndex) {
        return houses.get(houseIndex);
    }

    public int getScore() {
        return playerStore.getStoreVal();
    }

    public void addScore() {
        playerStore.incrementStore();
    }

    public void captureSeeds(int seedAmount) {
        playerStore.capture(seedAmount);

    }

    public int getPlayerId() {
        return playerId;
    }

}
