package com.hpplay.cybergarage.upnp.device;

import com.hpplay.cybergarage.upnp.ssdp.SSDPPacket;

public interface SearchResponseListener {
    void deviceSearchResponseReceived(SSDPPacket sSDPPacket);
}
