package com.hpplay.sdk.source.mdns;

import com.hpplay.sdk.source.mdns.MulticastDNSCache;
import com.hpplay.sdk.source.mdns.xbill.dns.MulticastDNSUtils;
import com.hpplay.sdk.source.mdns.xbill.dns.RRset;
import com.hpplay.sdk.source.mdns.xbill.dns.Record;
import java.lang.ref.WeakReference;
import java.util.logging.Level;

public class MonitorTask extends Thread {
    private static final String TAG = "MonitorTask";
    private boolean isShutdown;
    private WeakReference<MulticastDNSCache> mWeakReference;

    public MonitorTask(MulticastDNSCache multicastDNSCache) {
        this(false);
        this.mWeakReference = new WeakReference<>(multicastDNSCache);
    }

    private void processElement(ElementHelper elementHelper, MulticastDNSCache multicastDNSCache) {
        try {
            if (elementHelper.getElement() instanceof RRset) {
                RRset rRset = (RRset) elementHelper.getElement();
                if (this.isShutdown) {
                    for (Record record : MulticastDNSUtils.extractRecords(rRset)) {
                        if (elementHelper.getCredibility() >= 4) {
                            MulticastDNSUtils.setTLLForRecord(record, 0);
                        }
                    }
                }
                MulticastDNSCache.CacheMonitor cacheMonitor = multicastDNSCache.getCacheMonitor();
                int expiresIn = elementHelper.getExpiresIn();
                if (expiresIn > 0) {
                    if (rRset.getTTL() > 0) {
                        cacheMonitor.check(rRset, elementHelper.getCredibility(), expiresIn);
                        return;
                    }
                }
                cacheMonitor.expired(rRset, elementHelper.getCredibility());
            } else if (elementHelper.getElement() != null) {
                elementHelper.getElement().getClass();
            }
        } catch (Exception e10) {
            MulticastDNSCache.logger.log(Level.WARNING, e10.getMessage(), e10);
        }
    }

    public void release() {
        this.isShutdown = true;
        interrupt();
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processLoop(RegionMaker.java:225)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processLoop(RegionMaker.java:225)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    public void run() {
        /*
            r9 = this;
            java.lang.String r0 = "MonitorTask"
            r9.setName(r0)
        L_0x0005:
            boolean r0 = r9.isShutdown
            if (r0 != 0) goto L_0x00a6
            java.lang.ref.WeakReference<com.hpplay.sdk.source.mdns.MulticastDNSCache> r0 = r9.mWeakReference     // Catch:{ Exception -> 0x00a3 }
            java.lang.Object r0 = r0.get()     // Catch:{ Exception -> 0x00a3 }
            com.hpplay.sdk.source.mdns.MulticastDNSCache r0 = (com.hpplay.sdk.source.mdns.MulticastDNSCache) r0     // Catch:{ Exception -> 0x00a3 }
            if (r0 != 0) goto L_0x0015
            goto L_0x00a6
        L_0x0015:
            com.hpplay.sdk.source.mdns.MulticastDNSCache$CacheMonitor r1 = r0.getCacheMonitor()     // Catch:{ Exception -> 0x00a3 }
            if (r1 == 0) goto L_0x00a2
            boolean r2 = r9.isShutdown     // Catch:{ Exception -> 0x00a3 }
            if (r2 == 0) goto L_0x0021
            goto L_0x00a2
        L_0x0021:
            r1.begin()     // Catch:{ Exception -> 0x0025 }
            goto L_0x0031
        L_0x0025:
            r2 = move-exception
            java.util.logging.Logger r3 = com.hpplay.sdk.source.mdns.MulticastDNSCache.logger     // Catch:{ Exception -> 0x00a3 }
            java.util.logging.Level r4 = java.util.logging.Level.WARNING     // Catch:{ Exception -> 0x00a3 }
            java.lang.String r5 = r2.getMessage()     // Catch:{ Exception -> 0x00a3 }
            r3.log(r4, r5, r2)     // Catch:{ Exception -> 0x00a3 }
        L_0x0031:
            monitor-enter(r9)     // Catch:{ Exception -> 0x00a3 }
            java.util.LinkedHashMap r2 = r0.dataCopy     // Catch:{ all -> 0x009f }
            java.util.Collection r2 = r2.values()     // Catch:{ all -> 0x009f }
            int r3 = r2.size()     // Catch:{ all -> 0x009f }
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ all -> 0x009f }
            java.lang.Object[] r2 = r2.toArray(r3)     // Catch:{ all -> 0x009f }
            monitor-exit(r9)     // Catch:{ all -> 0x009f }
            r3 = 0
            r4 = 0
        L_0x0045:
            int r5 = r2.length     // Catch:{ Exception -> 0x00a3 }
            if (r4 >= r5) goto L_0x0088
            r5 = r2[r4]     // Catch:{ Exception -> 0x0079 }
            boolean r6 = r5 instanceof java.util.List     // Catch:{ Exception -> 0x0079 }
            if (r6 == 0) goto L_0x0070
            java.util.List r5 = (java.util.List) r5     // Catch:{ Exception -> 0x0079 }
            monitor-enter(r9)     // Catch:{ Exception -> 0x0079 }
            int r6 = r5.size()     // Catch:{ all -> 0x006d }
            java.lang.Object[] r6 = new java.lang.Object[r6]     // Catch:{ all -> 0x006d }
            java.lang.Object[] r5 = r5.toArray(r6)     // Catch:{ all -> 0x006d }
            monitor-exit(r9)     // Catch:{ all -> 0x006d }
            r6 = 0
        L_0x005d:
            int r7 = r5.length     // Catch:{ Exception -> 0x0079 }
            if (r6 >= r7) goto L_0x0085
            com.hpplay.sdk.source.mdns.ElementHelper r7 = new com.hpplay.sdk.source.mdns.ElementHelper     // Catch:{ Exception -> 0x0079 }
            r8 = r5[r6]     // Catch:{ Exception -> 0x0079 }
            r7.<init>(r0, r8)     // Catch:{ Exception -> 0x0079 }
            r9.processElement(r7, r0)     // Catch:{ Exception -> 0x0079 }
            int r6 = r6 + 1
            goto L_0x005d
        L_0x006d:
            r5 = move-exception
            monitor-exit(r9)     // Catch:{ all -> 0x006d }
            throw r5     // Catch:{ Exception -> 0x0079 }
        L_0x0070:
            com.hpplay.sdk.source.mdns.ElementHelper r6 = new com.hpplay.sdk.source.mdns.ElementHelper     // Catch:{ Exception -> 0x0079 }
            r6.<init>(r0, r5)     // Catch:{ Exception -> 0x0079 }
            r9.processElement(r6, r0)     // Catch:{ Exception -> 0x0079 }
            goto L_0x0085
        L_0x0079:
            r5 = move-exception
            java.util.logging.Logger r6 = com.hpplay.sdk.source.mdns.MulticastDNSCache.logger     // Catch:{ Exception -> 0x00a3 }
            java.util.logging.Level r7 = java.util.logging.Level.WARNING     // Catch:{ Exception -> 0x00a3 }
            java.lang.String r8 = r5.getMessage()     // Catch:{ Exception -> 0x00a3 }
            r6.log(r7, r8, r5)     // Catch:{ Exception -> 0x00a3 }
        L_0x0085:
            int r4 = r4 + 1
            goto L_0x0045
        L_0x0088:
            r1.end()     // Catch:{ Exception -> 0x008c }
            goto L_0x0098
        L_0x008c:
            r0 = move-exception
            java.util.logging.Logger r1 = com.hpplay.sdk.source.mdns.MulticastDNSCache.logger     // Catch:{ Exception -> 0x00a3 }
            java.util.logging.Level r2 = java.util.logging.Level.WARNING     // Catch:{ Exception -> 0x00a3 }
            java.lang.String r3 = r0.getMessage()     // Catch:{ Exception -> 0x00a3 }
            r1.log(r2, r3, r0)     // Catch:{ Exception -> 0x00a3 }
        L_0x0098:
            r0 = 1000(0x3e8, double:4.94E-321)
            java.lang.Thread.sleep(r0)     // Catch:{ Exception -> 0x00a3 }
            goto L_0x0005
        L_0x009f:
            r0 = move-exception
            monitor-exit(r9)     // Catch:{ all -> 0x009f }
            throw r0     // Catch:{ Exception -> 0x00a3 }
        L_0x00a2:
            return
        L_0x00a3:
            goto L_0x0005
        L_0x00a6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hpplay.sdk.source.mdns.MonitorTask.run():void");
    }

    public MonitorTask(boolean z10) {
        this.isShutdown = z10;
    }
}
