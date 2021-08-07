package spaceStation.models.planets;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static spaceStation.common.ExceptionMessages.*;

public class PlanetImpl implements Planet {
    private String name;
    private List<String> items;

    public PlanetImpl(String name) {
        setName(name);
        this.items = new ArrayList<>();
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(PLANET_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public Collection<String> getItems() {
        return this.items;
    }

    @Override
    public String getName() {
        return this.name.trim();
    }

    public void addItems(String... items) {
        Collections.addAll(this.items, items);
    }
}
