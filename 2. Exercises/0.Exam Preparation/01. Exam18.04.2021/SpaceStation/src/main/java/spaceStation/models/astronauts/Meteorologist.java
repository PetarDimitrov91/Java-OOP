package spaceStation.models.astronauts;

public class Meteorologist extends BaseAstronaut {
    private final static double DEFAULT_OXYGEN = 90;

    public Meteorologist(String name) {
        super(name, DEFAULT_OXYGEN);
    }
}
