package TasksToRefactor.greedyTimes;

public class Bag {
    private long capacity;
    private Gold gold;
    private Gem gem;
    private Currency currency;
    private long totalAmount;


    public Bag(long bagCapacity) {
        this.capacity = bagCapacity;
        this.gold = new Gold();
        this.gem = new Gem();
        this.currency = new Currency();
    }

    public long getCapacity() {
        return this.capacity;
    }
}
