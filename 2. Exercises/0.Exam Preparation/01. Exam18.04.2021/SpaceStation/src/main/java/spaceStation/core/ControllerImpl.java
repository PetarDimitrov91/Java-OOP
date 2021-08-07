package spaceStation.core;

import spaceStation.models.astronauts.Astronaut;
import spaceStation.models.astronauts.Biologist;
import spaceStation.models.astronauts.Geodesist;
import spaceStation.models.astronauts.Meteorologist;
import spaceStation.models.mission.Mission;
import spaceStation.models.mission.MissionImpl;
import spaceStation.models.planets.Planet;
import spaceStation.models.planets.PlanetImpl;
import spaceStation.repositories.AstronautRepository;
import spaceStation.repositories.PlanetRepository;
import spaceStation.repositories.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static spaceStation.common.ConstantMessages.*;
import static spaceStation.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {

    private Repository<Astronaut> astronautRepository;
    private Repository<Planet> planetRepository;
    private int exploredPlanetsCount = 0;

    public ControllerImpl() {
        this.astronautRepository = new AstronautRepository();
        this.planetRepository = new PlanetRepository();
    }

    @Override
    public String addAstronaut(String type, String astronautName) {
        Astronaut astronaut;
        switch (type) {
            case "Biologist":
                astronaut = new Biologist(astronautName);
                break;
            case "Geodesist":
                astronaut = new Geodesist(astronautName);
                break;
            case "Meteorologist":
                astronaut = new Meteorologist(astronautName);
                break;
            default:
                throw new IllegalArgumentException(ASTRONAUT_INVALID_TYPE);
        }
        astronautRepository.add(astronaut);
        return String.format(ASTRONAUT_ADDED, type, astronautName).trim();
    }

    @Override
    public String addPlanet(String planetName, String... items) {
        PlanetImpl planet = new PlanetImpl(planetName);
        planet.addItems(items);
        planetRepository.add(planet);

        return String.format(PLANET_ADDED, planetName).trim();
    }

    @Override
    public String retireAstronaut(String astronautName) {
        Astronaut astronaut = astronautRepository.findByName(astronautName);
        if (astronaut == null) {
            throw new IllegalArgumentException(String.format(ASTRONAUT_DOES_NOT_EXIST, astronautName));
        }
        astronautRepository.remove(astronaut);
        return String.format(ASTRONAUT_RETIRED, astronautName).trim();
    }

    @Override
    public String explorePlanet(String planetName) {
        Mission mission = new MissionImpl();
        int deadAstronauts = 0;
        Planet planet = planetRepository.findByName(planetName);
        List<Astronaut> astronauts = new ArrayList<>();
        for (Astronaut astronaut : astronautRepository.getModels()) {
            if (astronaut.getOxygen() > 60) {
                astronauts.add(astronaut);
            }
        }
        if (astronauts.isEmpty()) {
            throw new IllegalArgumentException(PLANET_ASTRONAUTS_DOES_NOT_EXISTS);
        }
        mission.explore(planet, astronauts);
        for (Astronaut astronaut : astronauts) {
            if (astronaut.getOxygen() <= 0) {
                deadAstronauts++;
            }
        }
        exploredPlanetsCount++;
        return String.format(PLANET_EXPLORED, planetName, deadAstronauts).trim();

    }

    @Override
    public String report() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format(REPORT_PLANET_EXPLORED, this.exploredPlanetsCount)).append(System.lineSeparator());
        builder.append(REPORT_ASTRONAUT_INFO).append(System.lineSeparator());
        for (Astronaut astronaut : astronautRepository.getModels()) {
            String items = astronaut.getBag().getItems().isEmpty()
                    ? "none"
                    : astronaut.getBag().getItems()
                    .stream()
                    .map(String::toString)
                    .collect(Collectors.joining(REPORT_ASTRONAUT_BAG_ITEMS_DELIMITER)).trim();
            builder.append(String.format(REPORT_ASTRONAUT_NAME, astronaut.getName())).append(System.lineSeparator());
            builder.append(String.format(REPORT_ASTRONAUT_OXYGEN, astronaut.getOxygen())).append(System.lineSeparator());
            builder.append(String.format(REPORT_ASTRONAUT_BAG_ITEMS, items)).append(System.lineSeparator());
        }
        return builder.toString().trim();
    }
}
