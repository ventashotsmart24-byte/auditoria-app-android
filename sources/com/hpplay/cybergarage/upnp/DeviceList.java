package com.hpplay.cybergarage.upnp;

import java.util.Vector;

public class DeviceList extends Vector {
    public static final String ELEM_NAME = "deviceList";

    public Device getDevice(int i10) {
        return (Device) get(i10);
    }
}
