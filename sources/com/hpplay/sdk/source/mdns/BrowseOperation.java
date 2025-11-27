package com.hpplay.sdk.source.mdns;

import com.hpplay.sdk.source.mdns.xbill.dns.AAAARecord;
import com.hpplay.sdk.source.mdns.xbill.dns.ARecord;
import com.hpplay.sdk.source.mdns.xbill.dns.Header;
import com.hpplay.sdk.source.mdns.xbill.dns.Message;
import com.hpplay.sdk.source.mdns.xbill.dns.MulticastDNSUtils;
import com.hpplay.sdk.source.mdns.xbill.dns.PTRRecord;
import com.hpplay.sdk.source.mdns.xbill.dns.Record;
import com.hpplay.sdk.source.mdns.xbill.dns.ResolverListener;
import com.hpplay.sdk.source.mdns.xbill.dns.SRVRecord;
import com.hpplay.sdk.source.mdns.xbill.dns.TXTRecord;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

class BrowseOperation extends Thread implements ResolverListener {
    private static final String TAG = "BrowseOperation";
    private int broadcastDelay = 0;
    private int dclass;
    private DNSSDListener dnssdListener;
    private final AtomicBoolean isQuit = new AtomicBoolean();
    private String mErrorMsg;
    protected Message[] mMessages;
    protected Querier mQuerier;
    private ResolverListener resolverListener;
    private final Map services = new LinkedHashMap();

    public BrowseOperation(ResolverListener resolverListener2, Message[] messageArr, Querier querier, int i10) {
        setName(TAG);
        StringBuilder sb = new StringBuilder();
        sb.append(" sBrowseOperation  create hashCode : ");
        sb.append(hashCode());
        if (resolverListener2 != null) {
            registerListener(resolverListener2);
        }
        this.mMessages = messageArr;
        this.mQuerier = querier;
        this.dclass = i10;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x007c, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0082, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean answersQuery(com.hpplay.sdk.source.mdns.xbill.dns.Record r15) {
        /*
            r14 = this;
            monitor-enter(r14)
            java.util.concurrent.atomic.AtomicBoolean r0 = r14.isQuit     // Catch:{ all -> 0x0083 }
            boolean r0 = r0.get()     // Catch:{ all -> 0x0083 }
            r1 = 0
            if (r0 == 0) goto L_0x000c
            monitor-exit(r14)
            return r1
        L_0x000c:
            if (r15 == 0) goto L_0x0081
            com.hpplay.sdk.source.mdns.xbill.dns.Message[] r0 = r14.mMessages     // Catch:{ all -> 0x0083 }
            if (r0 == 0) goto L_0x0081
            int r2 = r0.length     // Catch:{ all -> 0x0083 }
            r3 = 0
        L_0x0014:
            if (r3 >= r2) goto L_0x0081
            r4 = r0[r3]     // Catch:{ all -> 0x0083 }
            int[] r5 = new int[]{r1}     // Catch:{ all -> 0x0083 }
            com.hpplay.sdk.source.mdns.xbill.dns.Record[] r4 = com.hpplay.sdk.source.mdns.xbill.dns.MulticastDNSUtils.extractRecords(r4, r5)     // Catch:{ all -> 0x0083 }
            int r5 = r4.length     // Catch:{ all -> 0x0083 }
            r6 = 0
        L_0x0022:
            if (r6 >= r5) goto L_0x007e
            r7 = r4[r6]     // Catch:{ all -> 0x0083 }
            com.hpplay.sdk.source.mdns.xbill.dns.Name r8 = r7.getName()     // Catch:{ all -> 0x0083 }
            com.hpplay.sdk.source.mdns.xbill.dns.Name r9 = r15.getName()     // Catch:{ all -> 0x0083 }
            int r10 = r7.getType()     // Catch:{ all -> 0x0083 }
            int r11 = r15.getType()     // Catch:{ all -> 0x0083 }
            int r7 = r7.getDClass()     // Catch:{ all -> 0x0083 }
            int r12 = r15.getDClass()     // Catch:{ all -> 0x0083 }
            r13 = 255(0xff, float:3.57E-43)
            if (r10 == r13) goto L_0x0044
            if (r10 != r11) goto L_0x0078
        L_0x0044:
            boolean r10 = r8.equals(r9)     // Catch:{ all -> 0x0083 }
            if (r10 != 0) goto L_0x006f
            boolean r10 = r8.subdomain(r9)     // Catch:{ all -> 0x0083 }
            if (r10 != 0) goto L_0x006f
            java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x0083 }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x0083 }
            r10.<init>()     // Catch:{ all -> 0x0083 }
            java.lang.String r11 = "."
            r10.append(r11)     // Catch:{ all -> 0x0083 }
            java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x0083 }
            r10.append(r8)     // Catch:{ all -> 0x0083 }
            java.lang.String r8 = r10.toString()     // Catch:{ all -> 0x0083 }
            boolean r8 = r9.endsWith(r8)     // Catch:{ all -> 0x0083 }
            if (r8 == 0) goto L_0x0078
        L_0x006f:
            if (r7 == r13) goto L_0x007b
            r7 = r7 & 32767(0x7fff, float:4.5916E-41)
            r8 = r12 & 32767(0x7fff, float:4.5916E-41)
            if (r7 != r8) goto L_0x0078
            goto L_0x007b
        L_0x0078:
            int r6 = r6 + 1
            goto L_0x0022
        L_0x007b:
            monitor-exit(r14)
            r15 = 1
            return r15
        L_0x007e:
            int r3 = r3 + 1
            goto L_0x0014
        L_0x0081:
            monitor-exit(r14)
            return r1
        L_0x0083:
            r15 = move-exception
            monitor-exit(r14)
            goto L_0x0087
        L_0x0086:
            throw r15
        L_0x0087:
            goto L_0x0086
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hpplay.sdk.source.mdns.BrowseOperation.answersQuery(com.hpplay.sdk.source.mdns.xbill.dns.Record):boolean");
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
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
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
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    public synchronized void convertMassge(java.lang.Object r12, com.hpplay.sdk.source.mdns.xbill.dns.Message r13) {
        /*
            r11 = this;
            monitor-enter(r11)
            if (r13 == 0) goto L_0x0181
            java.util.concurrent.atomic.AtomicBoolean r0 = r11.isQuit     // Catch:{ all -> 0x017e }
            boolean r0 = r0.get()     // Catch:{ all -> 0x017e }
            if (r0 == 0) goto L_0x000d
            goto L_0x0181
        L_0x000d:
            java.util.LinkedHashSet r0 = new java.util.LinkedHashSet     // Catch:{ all -> 0x017e }
            r0.<init>()     // Catch:{ all -> 0x017e }
            java.util.LinkedList r1 = new java.util.LinkedList     // Catch:{ all -> 0x017e }
            r1.<init>()     // Catch:{ all -> 0x017e }
            java.util.LinkedList r2 = new java.util.LinkedList     // Catch:{ all -> 0x017e }
            r2.<init>()     // Catch:{ all -> 0x017e }
            r3 = 1
            r4 = 2
            r5 = 3
            int[] r4 = new int[]{r3, r4, r5}     // Catch:{ all -> 0x017e }
            com.hpplay.sdk.source.mdns.xbill.dns.Record[] r4 = com.hpplay.sdk.source.mdns.xbill.dns.MulticastDNSUtils.extractRecords(r13, r4)     // Catch:{ all -> 0x017e }
            int r5 = r4.length     // Catch:{ all -> 0x017e }
            r6 = 0
            r7 = 0
        L_0x002a:
            r8 = 12
            if (r7 >= r5) goto L_0x0069
            r9 = r4[r7]     // Catch:{ all -> 0x017e }
            boolean r10 = r11.answersQuery(r9)     // Catch:{ all -> 0x017e }
            if (r10 == 0) goto L_0x0063
            com.hpplay.sdk.source.mdns.xbill.dns.Name r10 = r9.getAdditionalName()     // Catch:{ all -> 0x017e }
            if (r10 == 0) goto L_0x003f
            r0.add(r10)     // Catch:{ all -> 0x017e }
        L_0x003f:
            int r10 = r9.getType()     // Catch:{ all -> 0x017e }
            if (r10 == r8) goto L_0x0055
            r8 = 33
            if (r10 == r8) goto L_0x004a
            goto L_0x005f
        L_0x004a:
            r8 = r9
            com.hpplay.sdk.source.mdns.xbill.dns.SRVRecord r8 = (com.hpplay.sdk.source.mdns.xbill.dns.SRVRecord) r8     // Catch:{ all -> 0x017e }
            com.hpplay.sdk.source.mdns.xbill.dns.Name r8 = r8.getTarget()     // Catch:{ all -> 0x017e }
            r0.add(r8)     // Catch:{ all -> 0x017e }
            goto L_0x005f
        L_0x0055:
            r8 = r9
            com.hpplay.sdk.source.mdns.xbill.dns.PTRRecord r8 = (com.hpplay.sdk.source.mdns.xbill.dns.PTRRecord) r8     // Catch:{ all -> 0x017e }
            com.hpplay.sdk.source.mdns.xbill.dns.Name r8 = r8.getTarget()     // Catch:{ all -> 0x017e }
            r0.add(r8)     // Catch:{ all -> 0x017e }
        L_0x005f:
            r2.add(r9)     // Catch:{ all -> 0x017e }
            goto L_0x0066
        L_0x0063:
            r1.add(r9)     // Catch:{ all -> 0x017e }
        L_0x0066:
            int r7 = r7 + 1
            goto L_0x002a
        L_0x0069:
            java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x017e }
        L_0x006d:
            boolean r4 = r1.hasNext()     // Catch:{ all -> 0x017e }
            if (r4 == 0) goto L_0x0087
            java.lang.Object r4 = r1.next()     // Catch:{ all -> 0x017e }
            com.hpplay.sdk.source.mdns.xbill.dns.Record r4 = (com.hpplay.sdk.source.mdns.xbill.dns.Record) r4     // Catch:{ all -> 0x017e }
            com.hpplay.sdk.source.mdns.xbill.dns.Name r5 = r4.getName()     // Catch:{ all -> 0x017e }
            boolean r5 = r0.contains(r5)     // Catch:{ all -> 0x017e }
            if (r5 == 0) goto L_0x006d
            r2.add(r4)     // Catch:{ all -> 0x017e }
            goto L_0x006d
        L_0x0087:
            int r0 = r2.size()     // Catch:{ all -> 0x017e }
            if (r0 <= 0) goto L_0x017c
            com.hpplay.sdk.source.mdns.DNSSDListener r0 = r11.dnssdListener     // Catch:{ all -> 0x017e }
            if (r0 == 0) goto L_0x0094
            r0.receiveMessage(r12, r13)     // Catch:{ all -> 0x017e }
        L_0x0094:
            java.util.HashMap r13 = new java.util.HashMap     // Catch:{ all -> 0x017e }
            r13.<init>()     // Catch:{ all -> 0x017e }
            java.util.HashMap r0 = new java.util.HashMap     // Catch:{ all -> 0x017e }
            r0.<init>()     // Catch:{ all -> 0x017e }
            java.util.Iterator r1 = r2.iterator()     // Catch:{ all -> 0x017e }
        L_0x00a2:
            boolean r2 = r1.hasNext()     // Catch:{ all -> 0x017e }
            if (r2 == 0) goto L_0x0148
            java.lang.Object r2 = r1.next()     // Catch:{ all -> 0x017e }
            com.hpplay.sdk.source.mdns.xbill.dns.Record r2 = (com.hpplay.sdk.source.mdns.xbill.dns.Record) r2     // Catch:{ all -> 0x017e }
            int r4 = r2.getType()     // Catch:{ Exception -> 0x00a2 }
            if (r4 == r8) goto L_0x00b5
            goto L_0x00a2
        L_0x00b5:
            java.util.concurrent.atomic.AtomicBoolean r4 = r11.isQuit     // Catch:{ Exception -> 0x00a2 }
            boolean r4 = r4.get()     // Catch:{ Exception -> 0x00a2 }
            if (r4 == 0) goto L_0x00bf
            monitor-exit(r11)
            return
        L_0x00bf:
            com.hpplay.sdk.source.mdns.xbill.dns.PTRRecord r2 = (com.hpplay.sdk.source.mdns.xbill.dns.PTRRecord) r2     // Catch:{ Exception -> 0x00a2 }
            long r4 = r2.getTTL()     // Catch:{ Exception -> 0x00a2 }
            r9 = 0
            int r7 = (r4 > r9 ? 1 : (r4 == r9 ? 0 : -1))
            if (r7 <= 0) goto L_0x0121
            com.hpplay.sdk.source.mdns.xbill.dns.Message[] r4 = new com.hpplay.sdk.source.mdns.xbill.dns.Message[r3]     // Catch:{ Exception -> 0x00a2 }
            com.hpplay.sdk.source.mdns.Querier r5 = r11.mQuerier     // Catch:{ Exception -> 0x00a2 }
            com.hpplay.sdk.source.mdns.xbill.dns.Name r2 = r2.getTarget()     // Catch:{ Exception -> 0x00a2 }
            int r7 = r11.dclass     // Catch:{ Exception -> 0x00a2 }
            r9 = 255(0xff, float:3.57E-43)
            com.hpplay.sdk.source.mdns.xbill.dns.Record r2 = com.hpplay.sdk.source.mdns.xbill.dns.Record.newRecord(r2, r9, r7)     // Catch:{ Exception -> 0x00a2 }
            com.hpplay.sdk.source.mdns.xbill.dns.Message r2 = com.hpplay.sdk.source.mdns.xbill.dns.Message.newQuery(r2)     // Catch:{ Exception -> 0x00a2 }
            com.hpplay.sdk.source.mdns.xbill.dns.Message r2 = r5.send(r2)     // Catch:{ Exception -> 0x00a2 }
            r4[r6] = r2     // Catch:{ Exception -> 0x00a2 }
            com.hpplay.sdk.source.mdns.ServiceInstance[] r2 = r11.extractServiceInstances((com.hpplay.sdk.source.mdns.xbill.dns.Message[]) r4)     // Catch:{ Exception -> 0x00a2 }
            int r4 = r2.length     // Catch:{ Exception -> 0x00a2 }
            if (r4 <= 0) goto L_0x00a2
            java.util.Map r4 = r11.services     // Catch:{ Exception -> 0x00a2 }
            monitor-enter(r4)     // Catch:{ Exception -> 0x00a2 }
            r5 = 0
        L_0x00f0:
            int r7 = r2.length     // Catch:{ all -> 0x011e }
            if (r5 >= r7) goto L_0x011c
            java.util.Map r7 = r11.services     // Catch:{ all -> 0x011e }
            r9 = r2[r5]     // Catch:{ all -> 0x011e }
            com.hpplay.sdk.source.mdns.ServiceName r9 = r9.getName()     // Catch:{ all -> 0x011e }
            boolean r7 = r7.containsKey(r9)     // Catch:{ all -> 0x011e }
            if (r7 != 0) goto L_0x0119
            java.util.Map r7 = r11.services     // Catch:{ all -> 0x011e }
            r9 = r2[r5]     // Catch:{ all -> 0x011e }
            com.hpplay.sdk.source.mdns.ServiceName r9 = r9.getName()     // Catch:{ all -> 0x011e }
            r10 = r2[r5]     // Catch:{ all -> 0x011e }
            r7.put(r9, r10)     // Catch:{ all -> 0x011e }
            r7 = r2[r5]     // Catch:{ all -> 0x011e }
            com.hpplay.sdk.source.mdns.ServiceName r7 = r7.getName()     // Catch:{ all -> 0x011e }
            r9 = r2[r5]     // Catch:{ all -> 0x011e }
            r13.put(r7, r9)     // Catch:{ all -> 0x011e }
        L_0x0119:
            int r5 = r5 + 1
            goto L_0x00f0
        L_0x011c:
            monitor-exit(r4)     // Catch:{ all -> 0x011e }
            goto L_0x00a2
        L_0x011e:
            r2 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x011e }
            throw r2     // Catch:{ Exception -> 0x00a2 }
        L_0x0121:
            java.util.Map r4 = r11.services     // Catch:{ Exception -> 0x00a2 }
            monitor-enter(r4)     // Catch:{ Exception -> 0x00a2 }
            java.util.Map r5 = r11.services     // Catch:{ all -> 0x0145 }
            com.hpplay.sdk.source.mdns.xbill.dns.Name r2 = r2.getTarget()     // Catch:{ all -> 0x0145 }
            java.lang.Object r2 = r5.get(r2)     // Catch:{ all -> 0x0145 }
            com.hpplay.sdk.source.mdns.ServiceInstance r2 = (com.hpplay.sdk.source.mdns.ServiceInstance) r2     // Catch:{ all -> 0x0145 }
            if (r2 == 0) goto L_0x0142
            java.util.Map r5 = r11.services     // Catch:{ all -> 0x0145 }
            com.hpplay.sdk.source.mdns.ServiceName r7 = r2.getName()     // Catch:{ all -> 0x0145 }
            r5.remove(r7)     // Catch:{ all -> 0x0145 }
            com.hpplay.sdk.source.mdns.ServiceName r5 = r2.getName()     // Catch:{ all -> 0x0145 }
            r0.put(r5, r2)     // Catch:{ all -> 0x0145 }
        L_0x0142:
            monitor-exit(r4)     // Catch:{ all -> 0x0145 }
            goto L_0x00a2
        L_0x0145:
            r2 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x0145 }
            throw r2     // Catch:{ Exception -> 0x00a2 }
        L_0x0148:
            java.util.Collection r13 = r13.values()     // Catch:{ all -> 0x017e }
            java.util.Iterator r13 = r13.iterator()     // Catch:{ all -> 0x017e }
        L_0x0150:
            boolean r1 = r13.hasNext()     // Catch:{ all -> 0x017e }
            if (r1 == 0) goto L_0x0162
            java.lang.Object r1 = r13.next()     // Catch:{ all -> 0x017e }
            com.hpplay.sdk.source.mdns.ServiceInstance r1 = (com.hpplay.sdk.source.mdns.ServiceInstance) r1     // Catch:{ all -> 0x017e }
            com.hpplay.sdk.source.mdns.DNSSDListener r2 = r11.dnssdListener     // Catch:{ Exception -> 0x0150 }
            r2.serviceDiscovered(r12, r1)     // Catch:{ Exception -> 0x0150 }
            goto L_0x0150
        L_0x0162:
            java.util.Collection r13 = r0.values()     // Catch:{ all -> 0x017e }
            java.util.Iterator r13 = r13.iterator()     // Catch:{ all -> 0x017e }
        L_0x016a:
            boolean r0 = r13.hasNext()     // Catch:{ all -> 0x017e }
            if (r0 == 0) goto L_0x017c
            java.lang.Object r0 = r13.next()     // Catch:{ all -> 0x017e }
            com.hpplay.sdk.source.mdns.ServiceInstance r0 = (com.hpplay.sdk.source.mdns.ServiceInstance) r0     // Catch:{ all -> 0x017e }
            com.hpplay.sdk.source.mdns.DNSSDListener r1 = r11.dnssdListener     // Catch:{ Exception -> 0x016a }
            r1.serviceRemoved(r12, r0)     // Catch:{ Exception -> 0x016a }
            goto L_0x016a
        L_0x017c:
            monitor-exit(r11)
            return
        L_0x017e:
            r12 = move-exception
            monitor-exit(r11)
            throw r12
        L_0x0181:
            monitor-exit(r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hpplay.sdk.source.mdns.BrowseOperation.convertMassge(java.lang.Object, com.hpplay.sdk.source.mdns.xbill.dns.Message):void");
    }

    public ServiceInstance[] extractServiceInstances(Message... messageArr) {
        Record[] recordArr = null;
        for (Message extractRecords : messageArr) {
            Record[] extractRecords2 = MulticastDNSUtils.extractRecords(extractRecords, 2, 1, 3);
            if (recordArr == null) {
                recordArr = extractRecords2;
            } else {
                int length = recordArr.length + extractRecords2.length;
                Record[] recordArr2 = new Record[length];
                System.arraycopy(recordArr, 0, recordArr2, 0, length);
                System.arraycopy(extractRecords2, 0, recordArr2, length, extractRecords2.length);
                recordArr = recordArr2;
            }
        }
        return extractServiceInstances(recordArr);
    }

    public String getErrorMsg() {
        return this.mErrorMsg;
    }

    public Message[] getQueries() {
        return this.mMessages;
    }

    public AtomicBoolean getQuitSwitch() {
        return this.isQuit;
    }

    public void handleException(Object obj, Exception exc) {
        ResolverListener resolverListener2 = this.resolverListener;
        if (resolverListener2 != null) {
            resolverListener2.handleException(obj, exc);
        }
    }

    public boolean matchesBrowse(Message message) {
        for (Record answersQuery : MulticastDNSUtils.extractRecords(message, 1, 2, 3)) {
            if (answersQuery(answersQuery)) {
                return true;
            }
        }
        return false;
    }

    public void receiveMessage(Object obj, Message message) {
        if (message != null) {
            Header header = message.getHeader();
            if ((header.getFlag(0) || header.getFlag(5)) && matchesBrowse(message)) {
                try {
                    convertMassge(obj, message);
                } catch (Exception unused) {
                }
            }
        }
    }

    public ResolverListener registerListener(ResolverListener resolverListener2) {
        this.resolverListener = resolverListener2;
        return resolverListener2;
    }

    public void release() {
        this.isQuit.set(true);
        this.resolverListener = null;
        this.dnssdListener = null;
        interrupt();
        StringBuilder sb = new StringBuilder();
        sb.append(" browse release  hashCode :");
        sb.append(hashCode());
        try {
            this.mQuerier.close();
            this.mMessages = null;
        } catch (Exception unused) {
        }
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:20:0x0052 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r6 = this;
            r0 = 0
            com.hpplay.sdk.source.mdns.Querier r1 = r6.mQuerier     // Catch:{ Exception -> 0x0008 }
            boolean r1 = r1.initNetWorkState()     // Catch:{ Exception -> 0x0008 }
            goto L_0x0010
        L_0x0008:
            r1 = move-exception
            java.lang.String r1 = android.util.Log.getStackTraceString(r1)
            r6.mErrorMsg = r1
            r1 = 0
        L_0x0010:
            if (r1 == 0) goto L_0x0052
            com.hpplay.sdk.source.mdns.Querier r1 = r6.mQuerier     // Catch:{ Exception -> 0x0052 }
            r1.registerListener(r6)     // Catch:{ Exception -> 0x0052 }
        L_0x0017:
            java.util.concurrent.atomic.AtomicBoolean r1 = r6.isQuit     // Catch:{ Exception -> 0x0052 }
            boolean r1 = r1.get()     // Catch:{ Exception -> 0x0052 }
            if (r1 != 0) goto L_0x0052
            boolean r1 = r6.isInterrupted()     // Catch:{ Exception -> 0x0052 }
            if (r1 != 0) goto L_0x0052
            int r1 = r6.broadcastDelay     // Catch:{ Exception -> 0x0052 }
            if (r1 <= 0) goto L_0x0032
            int r1 = r1 * 2
            r2 = 3600(0xe10, float:5.045E-42)
            int r1 = java.lang.Math.min(r1, r2)     // Catch:{ Exception -> 0x0052 }
            goto L_0x0033
        L_0x0032:
            r1 = 1
        L_0x0033:
            r6.broadcastDelay = r1     // Catch:{ Exception -> 0x0052 }
            com.hpplay.sdk.source.mdns.xbill.dns.Message[] r1 = r6.mMessages     // Catch:{ Exception -> 0x0052 }
            int r2 = r1.length     // Catch:{ Exception -> 0x0052 }
            r3 = 0
        L_0x0039:
            if (r3 >= r2) goto L_0x004b
            r4 = r1[r3]     // Catch:{ Exception -> 0x0052 }
            com.hpplay.sdk.source.mdns.Querier r5 = r6.mQuerier     // Catch:{ Exception -> 0x0052 }
            java.lang.Object r4 = r4.clone()     // Catch:{ Exception -> 0x0052 }
            com.hpplay.sdk.source.mdns.xbill.dns.Message r4 = (com.hpplay.sdk.source.mdns.xbill.dns.Message) r4     // Catch:{ Exception -> 0x0052 }
            r5.broadcast(r4, r0)     // Catch:{ Exception -> 0x0052 }
            int r3 = r3 + 1
            goto L_0x0039
        L_0x004b:
            int r1 = r6.broadcastDelay     // Catch:{ Exception -> 0x0052 }
            long r1 = (long) r1     // Catch:{ Exception -> 0x0052 }
            java.lang.Thread.sleep(r1)     // Catch:{ Exception -> 0x0052 }
            goto L_0x0017
        L_0x0052:
            com.hpplay.sdk.source.mdns.Querier r0 = r6.mQuerier     // Catch:{ Exception -> 0x005a }
            r0.close()     // Catch:{ Exception -> 0x005a }
            r0 = 0
            r6.mQuerier = r0     // Catch:{ Exception -> 0x005a }
        L_0x005a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hpplay.sdk.source.mdns.BrowseOperation.run():void");
    }

    public void setDNSSDListener(DNSSDListener dNSSDListener) {
        this.dnssdListener = dNSSDListener;
    }

    public ResolverListener unregisterListener(ResolverListener resolverListener2) {
        this.resolverListener = null;
        return null;
    }

    public ServiceInstance[] extractServiceInstances(Record[] recordArr) {
        HashMap hashMap = new HashMap();
        Arrays.sort(recordArr, new ServiceRecodSorter());
        for (SRVRecord sRVRecord : recordArr) {
            int type = sRVRecord.getType();
            if (type == 1) {
                ARecord aRecord = (ARecord) sRVRecord;
                for (ServiceInstance serviceInstance : hashMap.values()) {
                    if (aRecord.getName().equals(serviceInstance.getHost())) {
                        if (aRecord.getTTL() > 0) {
                            serviceInstance.addAddress(aRecord.getAddress());
                        } else {
                            serviceInstance.removeAddress(aRecord.getAddress());
                        }
                    }
                }
            } else if (type == 12) {
                PTRRecord pTRRecord = (PTRRecord) sRVRecord;
                ServiceInstance serviceInstance2 = (ServiceInstance) hashMap.get(pTRRecord.getTarget());
                if (serviceInstance2 != null) {
                    if (pTRRecord.getTTL() > 0) {
                        serviceInstance2.addPointer(pTRRecord.getName());
                    } else {
                        serviceInstance2.removePointer(pTRRecord.getName());
                    }
                }
            } else if (type == 16) {
                TXTRecord tXTRecord = (TXTRecord) sRVRecord;
                ServiceInstance serviceInstance3 = (ServiceInstance) hashMap.get(tXTRecord.getName());
                if (serviceInstance3 != null) {
                    if (tXTRecord.getTTL() > 0) {
                        serviceInstance3.addTextRecords(tXTRecord);
                    } else {
                        serviceInstance3.removeTextRecords(tXTRecord);
                    }
                }
            } else if (type == 28) {
                AAAARecord aAAARecord = (AAAARecord) sRVRecord;
                for (ServiceInstance serviceInstance4 : hashMap.values()) {
                    if (aAAARecord.getName().equals(serviceInstance4.getHost())) {
                        if (aAAARecord.getTTL() > 0) {
                            serviceInstance4.addAddress(aAAARecord.getAddress());
                        } else {
                            serviceInstance4.removeAddress(aAAARecord.getAddress());
                        }
                    }
                }
            } else if (type == 33) {
                try {
                    ServiceInstance serviceInstance5 = new ServiceInstance(sRVRecord);
                    hashMap.put(serviceInstance5.getName(), serviceInstance5);
                } catch (Exception unused) {
                }
            }
        }
        return (ServiceInstance[]) hashMap.values().toArray(new ServiceInstance[hashMap.size()]);
    }
}
