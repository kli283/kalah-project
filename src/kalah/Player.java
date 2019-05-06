package kalah;

import java.util.ArrayList;

public class Player {
    private ArrayList<House> houses;
    private House endHouse;
    private GameBoard gameBoard = new GameBoard();

    public Player() {
        houses = new ArrayList<>();
        for (int i=0; i<gameBoard.getInitHouses(); i++) {
            houses.add(new House(gameBoard.getInitHouses()));
        }
        endHouse = new House(gameBoard.getInitHouses());
    }

    public int getPlayerHouses() {
        return gameBoard.getInitHouses();
    }

    public ArrayList<House> getHouses() {
        return houses;
    }

    public House getEndHouse() {
        return endHouse;
    }

    public int getScore() {
        return endHouse.getSeeds().size();
    }
}
