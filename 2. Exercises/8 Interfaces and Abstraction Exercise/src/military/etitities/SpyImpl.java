package military.etitities;

import military.interfaceses.Spy;

public class SpyImpl extends SoldierImpl implements Spy {

    String codeNumber;

    public SpyImpl(int id, String firstName, String lastName, String codeNumber) {
        super(id, firstName, lastName);
        this.codeNumber = codeNumber;
    }
}
