package com.hpplay.sdk.source.mdns.xbill.dns;

import java.util.EventListener;

public interface ResolverListener extends EventListener {
    void handleException(Object obj, Exception exc);

    void receiveMessage(Object obj, Message message);
}
