package TasksToRefactor.greedyTimes;

import java.util.List;

public class Gold {
    private long value;
    private long amount;

    public Gold (long value){
        this.value += value;
    }

    public void addGold (long amount){
        this.amount += amount;
    }
}
