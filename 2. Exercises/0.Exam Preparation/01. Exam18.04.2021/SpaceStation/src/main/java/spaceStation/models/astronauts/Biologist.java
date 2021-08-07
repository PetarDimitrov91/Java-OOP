package spaceStation.models.astronauts;

public class Biologist extends BaseAstronaut {
    private final static double DEFAULT_OXYGEN = 70;

    public Biologist(String name) {
        super(name, DEFAULT_OXYGEN);
    }

    @Override
    public void breath() {
        if (canBreath()) {
            setOxygen(getOxygen() - 5);
            if (getOxygen() < 0) {
                setOxygen(0);
            }
        }
    }
}
