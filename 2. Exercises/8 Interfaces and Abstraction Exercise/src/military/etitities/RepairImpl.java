package military.etitities;

import military.interfaceses.Repair;

public class RepairImpl implements Repair {

    String partName;
    private int hoursWorked;

    public RepairImpl(String partName, int hoursWorked) {
        this.partName = partName;
        this.hoursWorked = hoursWorked;
    }
}
