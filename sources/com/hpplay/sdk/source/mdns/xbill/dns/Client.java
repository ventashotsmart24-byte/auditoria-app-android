package com.hpplay.sdk.source.mdns.xbill.dns;

import java.net.SocketTimeoutException;
import java.nio.channels.SelectionKey;

class Client {
    protected long endTime;
    protected SelectionKey key;

    /* JADX WARNING: Removed duplicated region for block: B:11:0x001b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public Client(java.nio.channels.SelectableChannel r1, long r2) {
        /*
            r0 = this;
            r0.<init>()
            r0.endTime = r2
            java.nio.channels.Selector r2 = java.nio.channels.Selector.open()     // Catch:{ all -> 0x0017 }
            r3 = 0
            r1.configureBlocking(r3)     // Catch:{ all -> 0x0015 }
            r3 = 1
            java.nio.channels.SelectionKey r3 = r1.register(r2, r3)     // Catch:{ all -> 0x0015 }
            r0.key = r3     // Catch:{ all -> 0x0015 }
            return
        L_0x0015:
            r3 = move-exception
            goto L_0x0019
        L_0x0017:
            r3 = move-exception
            r2 = 0
        L_0x0019:
            if (r2 == 0) goto L_0x001e
            r2.close()
        L_0x001e:
            r1.close()
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hpplay.sdk.source.mdns.xbill.dns.Client.<init>(java.nio.channels.SelectableChannel, long):void");
    }

    public static void blockUntil(SelectionKey selectionKey, long j10) {
        int i10;
        long currentTimeMillis = j10 - System.currentTimeMillis();
        if (currentTimeMillis > 0) {
            i10 = selectionKey.selector().select(currentTimeMillis);
        } else if (currentTimeMillis == 0) {
            i10 = selectionKey.selector().selectNow();
        } else {
            i10 = 0;
        }
        if (i10 == 0) {
            throw new SocketTimeoutException();
        }
    }

    public void cleanup() {
        this.key.selector().close();
        this.key.channel().close();
    }
}
