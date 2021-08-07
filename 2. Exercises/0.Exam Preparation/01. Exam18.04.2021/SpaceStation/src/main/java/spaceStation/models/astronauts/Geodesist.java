package spaceStation.models.astronauts;

public class Geodesist extends BaseAstronaut {
    private final static double DEFAULT_OXYGEN = 50;

    public Geodesist(String name) {
        super(name, DEFAULT_OXYGEN);
    }
}
