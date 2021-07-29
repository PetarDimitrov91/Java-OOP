package spaceStation.models.astronauts;

public class Biologist extends BaseAstronaut {
    private static final double OXYGEN_UNITS = 70;

    protected Biologist(String name) {
        super(name, OXYGEN_UNITS);
    }

    @Override
    public void breath() {
        if (canBreath()) {
            setOxygen(getOxygen() - 5);
        }
    }

    @Override
    public boolean canBreath() {
        return this.getOxygen() >= 5;
    }

}
