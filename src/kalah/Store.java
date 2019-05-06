package kalah;

public class Store {
    private int storeVal = 0;

    public int getStoreVal() {
        return storeVal;
    }

    public int increaseStore(int numPoints) {
        return storeVal + numPoints;
    }
}
