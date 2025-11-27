package com.hpplay.cybergarage.upnp.device;

import com.hpplay.cybergarage.upnp.Device;
import com.hpplay.cybergarage.util.ThreadCore;

public class Advertiser extends ThreadCore {
    private Device device;

    public Advertiser(Device device2) {
        setDevice(device2);
    }

    public Device getDevice() {
        return this.device;
    }

    public void run() {
        Device device2 = getDevice();
        long leaseTime = (long) device2.getLeaseTime();
        while (isRunnable()) {
            double d10 = (double) ((float) leaseTime);
            Double.isNaN(d10);
            try {
                Thread.sleep(((leaseTime / 4) + ((long) (d10 * Math.random() * 0.25d))) * 1000);
            } catch (InterruptedException unused) {
            }
            device2.announce();
        }
    }

    public void setDevice(Device device2) {
        this.device = device2;
    }
}
