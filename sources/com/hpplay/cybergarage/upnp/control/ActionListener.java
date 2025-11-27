package com.hpplay.cybergarage.upnp.control;

import com.hpplay.cybergarage.upnp.Action;

public interface ActionListener {
    boolean actionControlReceived(Action action);
}
