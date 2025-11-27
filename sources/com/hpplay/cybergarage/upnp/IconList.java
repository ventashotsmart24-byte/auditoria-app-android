package com.hpplay.cybergarage.upnp;

import java.util.Vector;

public class IconList extends Vector {
    public static final String ELEM_NAME = "iconList";

    public Icon getIcon(int i10) {
        return (Icon) get(i10);
    }
}
