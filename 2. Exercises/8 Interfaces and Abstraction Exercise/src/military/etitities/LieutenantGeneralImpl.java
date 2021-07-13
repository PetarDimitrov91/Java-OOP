package military.etitities;

import military.interfaceses.LieutenantGeneral;
import military.interfaceses.Private;

import java.util.ArrayList;
import java.util.List;


public class LieutenantGeneralImpl extends PrivateImpl implements LieutenantGeneral {
    private List<Private> privates;

    public LieutenantGeneralImpl(int id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName, salary);
        this.privates = new ArrayList<>();
    }

    @Override
    public void addPrivate(Private priv) {
        this.privates.add(priv);
    }


}
