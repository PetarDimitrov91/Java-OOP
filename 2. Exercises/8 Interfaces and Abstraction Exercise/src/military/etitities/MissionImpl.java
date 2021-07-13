package military.etitities;

import military.interfaceses.Mission;

public class MissionImpl implements Mission {

    private enum Status {
        IN_PROGRESS,
        FINISHED
    }

    private String codeName;
    private Status status;

    public MissionImpl(String codeName, Status status) {
        this.codeName = codeName;
        this.status = status;
    }

    @Override
    public void completeMission() {
        this.status = Status.FINISHED;
    }
}
