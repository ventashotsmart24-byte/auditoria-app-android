package com.hpplay.cybergarage.upnp.ssdp;

import com.hpplay.cybergarage.http.HTTP;
import com.raizlabs.android.dbflow.sql.language.Operator;

public class SSDPNotifyRequest extends SSDPRequest {
    public SSDPNotifyRequest() {
        setMethod(HTTP.NOTIFY);
        setURI(Operator.Operation.MULTIPLY);
    }
}
