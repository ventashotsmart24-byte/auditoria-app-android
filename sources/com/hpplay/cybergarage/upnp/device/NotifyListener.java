package com.hpplay.cybergarage.upnp.device;

import com.hpplay.cybergarage.upnp.ssdp.SSDPPacket;

public interface NotifyListener {
    void deviceNotifyReceived(SSDPPacket sSDPPacket);
}
