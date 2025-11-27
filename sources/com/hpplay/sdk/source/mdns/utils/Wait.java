package com.hpplay.sdk.source.mdns.utils;

import com.hpplay.sdk.source.mdns.xbill.dns.Options;

public class Wait {
    public static final void forResponse(Iterable iterable) {
        synchronized (iterable) {
            long waitTill = waitTill();
            while (!iterable.iterator().hasNext() && System.currentTimeMillis() < waitTill) {
                try {
                    iterable.wait(waitTill - System.currentTimeMillis());
                } catch (InterruptedException unused) {
                }
            }
        }
    }

    public static final long waitTill() {
        int intValue = Options.intValue("mdns_resolve_wait");
        long currentTimeMillis = System.currentTimeMillis();
        if (intValue <= 0) {
            intValue = 500;
        }
        return currentTimeMillis + ((long) intValue);
    }

    public static final void forResponse(Object obj) {
        synchronized (obj) {
            long waitTill = waitTill();
            while (System.currentTimeMillis() < waitTill) {
                try {
                    obj.wait(waitTill - System.currentTimeMillis());
                } catch (InterruptedException unused) {
                }
            }
        }
    }
}
