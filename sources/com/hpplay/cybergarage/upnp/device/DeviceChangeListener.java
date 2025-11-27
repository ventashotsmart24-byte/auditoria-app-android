package com.hpplay.cybergarage.upnp.device;

import com.hpplay.cybergarage.upnp.Device;

public interface DeviceChangeListener {
    void deviceAdded(int i10, Device device);

    void deviceAdded(Device device);

    void deviceRemoved(Device device);
}
