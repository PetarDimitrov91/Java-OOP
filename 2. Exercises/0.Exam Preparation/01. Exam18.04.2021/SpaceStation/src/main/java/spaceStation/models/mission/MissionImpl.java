package spaceStation.models.mission;

import spaceStation.models.astronauts.Astronaut;
import spaceStation.models.planets.Planet;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MissionImpl implements Mission {
    @Override
    public void explore(Planet planet, Collection<Astronaut> astronauts) {
        List<String> itemsToRemove = new ArrayList<>();

        for (Astronaut astronaut : astronauts) {
            for (String item : planet.getItems()) {
                if (astronaut.canBreath()) {
                    astronaut.getBag().getItems().add(item);
                    itemsToRemove.add(item);
                    astronaut.breath();
                }
                if (!astronaut.canBreath()) {
                    break;
                }
            }
            planet.getItems().removeAll(itemsToRemove);
            itemsToRemove = new ArrayList<>();
        }
    }
}
