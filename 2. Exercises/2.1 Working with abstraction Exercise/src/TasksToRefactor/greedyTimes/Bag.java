package TasksToRefactor.greedyTimes;

import java.util.ArrayList;
import java.util.List;

public class Bag {
    private long capacity;
    private List<Gem> gems;
    private List<Currency> currency;
    private long totalAmount;


    public Bag(long bagCapacity) {
        this.capacity = bagCapacity;
        this.gems = new ArrayList<>();
        this.currency = new ArrayList<>();
    }

    public long getCapacity() {
        return this.capacity;
    }
}
