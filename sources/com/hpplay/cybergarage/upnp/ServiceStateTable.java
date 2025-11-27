package com.hpplay.cybergarage.upnp;

import java.util.Vector;

public class ServiceStateTable extends Vector {
    public static final String ELEM_NAME = "serviceStateTable";

    public StateVariable getStateVariable(int i10) {
        return (StateVariable) get(i10);
    }
}
