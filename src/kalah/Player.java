package kalah;

import java.util.ArrayList;

public class Player {
    private ArrayList<House> houses;
    private House endHouse;

    public Player() {
        houses = new ArrayList<>();
        for (int i=0; i<6; i++) {
            houses.add(new House(4));
        }
        endHouse = new House(0);
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
