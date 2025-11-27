package com.hpplay.cybergarage.upnp.ssdp;

import com.hpplay.cybergarage.http.HTTP;
import com.hpplay.cybergarage.upnp.UPnP;

public class SSDPSearchResponse extends SSDPResponse {
    public SSDPSearchResponse() {
        setStatusCode(200);
        setCacheControl(30);
        setHeader("Server", UPnP.getServerName());
        setHeader(HTTP.EXT, "");
    }
}
