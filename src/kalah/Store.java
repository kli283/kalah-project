package kalah;

public class Store {
    private int storeVal = 0;

    public int getStoreVal() {
        return storeVal;
    }

    public void incrementStore() {
        storeVal++;
    }

    public void capture(int seedAmount) {
        storeVal += seedAmount;
    }
}
