package spaceStation.models.bags;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Backpack implements Bag {
    private List<String> items;

    public Backpack() {
        this.items = new ArrayList<>();
    }

    //return unmodifiable list!!!
    @Override
    public Collection<String> getItems() {
        return this.items;
    }
}
