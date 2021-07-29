package spaceStation.models.astronauts;

import spaceStation.models.bags.Bag;

public abstract class BaseAstronaut implements Astronaut {

    private String name;
    private double oxygen;
    private Bag bag;

    protected BaseAstronaut(String name, double oxygen) {
        setName(name);
        setOxygen(oxygen);
    }

    protected void setName(String name) {
        if (name.isBlank()) {
            throw new NullPointerException("Astronaut name cannot be null or empty.");
        }
        this.name = name;
    }

    protected void setOxygen(double oxygen) {
        if (oxygen < 0) {
            throw new IllegalArgumentException("Cannot create Astronaut with negative oxygen!");
        }
    }

    public void breath() {
        if (canBreath()) {
            this.oxygen -= 10;
        }
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getOxygen() {
        return this.oxygen;
    }

    @Override
    public boolean canBreath() {
        return this.oxygen >= 10;
    }

    @Override
    public Bag getBag() {
        return this.bag;
    }

}
