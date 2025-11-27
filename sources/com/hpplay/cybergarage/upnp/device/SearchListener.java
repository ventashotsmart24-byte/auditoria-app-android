package com.hpplay.cybergarage.upnp.device;

import com.hpplay.cybergarage.upnp.ssdp.SSDPPacket;

public interface SearchListener {
    void deviceSearchReceived(SSDPPacket sSDPPacket);
}
