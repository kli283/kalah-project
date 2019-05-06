package kalah;

import java.util.ArrayList;

public class Player {
    private ArrayList<House> houses;
    private GameBoard gameBoard = new GameBoard();
    private Store playerStore ;
    private int playerId;


    public Player(int id) {
        playerId = id;
        houses = new ArrayList<>();
        for (int i=0; i<gameBoard.getInitHouses(); i++) {
            houses.add(new House(gameBoard.getInitSeeds()));
        }
        playerStore = new Store();
    }

    public int getPlayerHouses() {
        return gameBoard.getInitHouses();
    }

    public ArrayList<House> getHouses() {
        return houses;
    }

    public int getScore() {
        return playerStore.getStoreVal();
    }

}
