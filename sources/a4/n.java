package a4;

import r3.s;
import r3.v;

public abstract class n extends v {
    public n(s sVar) {
        super(sVar.getMetadata());
    }

    public n(n nVar) {
        super((v) nVar);
    }
}
