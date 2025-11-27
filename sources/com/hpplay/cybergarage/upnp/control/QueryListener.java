package com.hpplay.cybergarage.upnp.control;

import com.hpplay.cybergarage.upnp.StateVariable;

public interface QueryListener {
    boolean queryControlReceived(StateVariable stateVariable);
}
