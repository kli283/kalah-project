package kalah;

import java.util.ArrayList;

public class House {
    private int seeds;
    private boolean isEmpty;

    public House(int initialSeeds) {
        seeds = initialSeeds;
        if (seeds == 0){
            isEmpty = true;
        } else {
            isEmpty = false;
        }
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

    public boolean isEmpty() {
        return isEmpty;
    }
}
