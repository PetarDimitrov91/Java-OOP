package glacialExpedition.models.mission;

import glacialExpedition.models.explorers.Explorer;
import glacialExpedition.models.states.State;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MissionImpl implements Mission {

    public MissionImpl() {
    }

    @Override
    public void explore(State state, Collection<Explorer> explorers) {
        List<String> exhibitsToRemove = new ArrayList<>();
        for (Explorer explorer : explorers) {
            for (String exhibit : state.getExhibits()) {
                if (explorer.canSearch()) {
                    explorer.getSuitcase().getExhibits().add(exhibit);
                    exhibitsToRemove.add(exhibit);
                    explorer.search();
                } else {
                    break;
                }
            }
            state.getExhibits().removeAll(exhibitsToRemove);
        }

    }
}
