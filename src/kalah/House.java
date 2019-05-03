package kalah;

import java.util.ArrayList;

public class House {
    private ArrayList<Seed> seeds;

    public House(int initialSeeds) {
        seeds = new ArrayList<>();
        for (int i=0; i<initialSeeds; i++) {
            seeds.add(new Seed());
        }
    }

    public ArrayList<Seed> getSeeds() {
        return seeds;
    }
}
