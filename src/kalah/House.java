package kalah;

import java.util.ArrayList;

public class House {
    private int seeds;

    public House(int initialSeeds) {
        seeds = initialSeeds;
    }

    public int getSeeds() {
        return seeds;
    }

    public int incrementSeeds() {
        return seeds++;
    }

    public int removeSeeds() {
        return seeds = 0;
    }
}
