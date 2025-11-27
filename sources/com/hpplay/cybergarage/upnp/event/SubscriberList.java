package com.hpplay.cybergarage.upnp.event;

import java.util.Vector;

public class SubscriberList extends Vector {
    public Subscriber getSubscriber(int i10) {
        Object obj;
        try {
            obj = get(i10);
        } catch (Exception unused) {
            obj = null;
        }
        return (Subscriber) obj;
    }
}
