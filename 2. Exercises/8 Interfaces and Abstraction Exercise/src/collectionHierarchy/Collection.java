package collectionHierarchy;

import java.util.List;

public abstract class Collection<R> implements Addable,AddRemovable {
    private static final int MAX_SIZE = 100;
    private List<String> items;

    public Collection(List<String> items) {
        this.items = items;
    }
}
