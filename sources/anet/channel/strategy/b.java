package anet.channel.strategy;

class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f3914a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ a f3915b;

    public b(a aVar, String str) {
        this.f3915b = aVar;
        this.f3914a = str;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x003c A[Catch:{ Exception -> 0x0022 }] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x004a A[Catch:{ Exception -> 0x0022 }] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00e2 A[Catch:{ Exception -> 0x0022 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r15 = this;
            java.lang.String r0 = "host"
            java.lang.String r1 = "localDns"
            java.lang.String r2 = "awcn.LocalDnsStrategy"
            r3 = 0
            r4 = 2
            r5 = 1
            r6 = 0
            java.lang.String r7 = r15.f3914a     // Catch:{ UnknownHostException -> 0x0025 }
            java.net.InetAddress r7 = java.net.InetAddress.getByName(r7)     // Catch:{ UnknownHostException -> 0x0025 }
            java.lang.String r7 = r7.getHostAddress()     // Catch:{ UnknownHostException -> 0x0025 }
            java.lang.Object[] r8 = new java.lang.Object[r4]     // Catch:{ UnknownHostException -> 0x0020 }
            java.lang.String r9 = r15.f3914a     // Catch:{ UnknownHostException -> 0x0020 }
            r8[r3] = r9     // Catch:{ UnknownHostException -> 0x0020 }
            r8[r5] = r7     // Catch:{ UnknownHostException -> 0x0020 }
            anet.channel.util.ALog.i(r2, r1, r6, r8)     // Catch:{ UnknownHostException -> 0x0020 }
            goto L_0x0036
        L_0x0020:
            r8 = move-exception
            goto L_0x0027
        L_0x0022:
            goto L_0x00ea
        L_0x0025:
            r8 = move-exception
            r7 = r6
        L_0x0027:
            java.lang.Object[] r9 = new java.lang.Object[r4]     // Catch:{ Exception -> 0x0022 }
            java.lang.String r10 = r15.f3914a     // Catch:{ Exception -> 0x0022 }
            r9[r3] = r10     // Catch:{ Exception -> 0x0022 }
            java.lang.String r8 = r8.getMessage()     // Catch:{ Exception -> 0x0022 }
            r9[r5] = r8     // Catch:{ Exception -> 0x0022 }
            anet.channel.util.ALog.e(r2, r1, r6, r9)     // Catch:{ Exception -> 0x0022 }
        L_0x0036:
            boolean r1 = android.text.TextUtils.isEmpty(r7)     // Catch:{ Exception -> 0x0022 }
            if (r1 == 0) goto L_0x0044
            java.lang.String r1 = "174658"
            java.lang.String r7 = r15.f3914a     // Catch:{ Exception -> 0x0022 }
            java.lang.String r7 = anet.channel.strategy.utils.c.a(r1, r7)     // Catch:{ Exception -> 0x0022 }
        L_0x0044:
            boolean r1 = android.text.TextUtils.isEmpty(r7)     // Catch:{ Exception -> 0x0022 }
            if (r1 != 0) goto L_0x00e2
            java.util.LinkedList r1 = new java.util.LinkedList     // Catch:{ Exception -> 0x0022 }
            r1.<init>()     // Catch:{ Exception -> 0x0022 }
            anet.channel.strategy.StrategyTemplate r8 = anet.channel.strategy.StrategyTemplate.getInstance()     // Catch:{ Exception -> 0x0022 }
            java.lang.String r9 = r15.f3914a     // Catch:{ Exception -> 0x0022 }
            anet.channel.strategy.ConnProtocol r10 = r8.getConnProtocol(r9)     // Catch:{ Exception -> 0x0022 }
            if (r10 == 0) goto L_0x007b
            anet.channel.strategy.a r8 = r15.f3915b     // Catch:{ Exception -> 0x0022 }
            boolean r8 = r8.a((anet.channel.strategy.ConnProtocol) r10)     // Catch:{ Exception -> 0x0022 }
            if (r8 != 0) goto L_0x0068
            r8 = 80
            r9 = 80
            goto L_0x006c
        L_0x0068:
            r8 = 443(0x1bb, float:6.21E-43)
            r9 = 443(0x1bb, float:6.21E-43)
        L_0x006c:
            r11 = 0
            r12 = 0
            r13 = 1
            r14 = 45000(0xafc8, float:6.3058E-41)
            r8 = r7
            anet.channel.strategy.IPConnStrategy r8 = anet.channel.strategy.IPConnStrategy.a(r8, r9, r10, r11, r12, r13, r14)     // Catch:{ Exception -> 0x0022 }
            r1.add(r8)     // Catch:{ Exception -> 0x0022 }
            goto L_0x0095
        L_0x007b:
            java.lang.String r8 = "http2"
            java.lang.String r9 = "0rtt"
            java.lang.String r10 = "open"
            anet.channel.strategy.ConnProtocol r10 = anet.channel.strategy.ConnProtocol.valueOf(r8, r9, r10)     // Catch:{ Exception -> 0x0022 }
            r9 = 443(0x1bb, float:6.21E-43)
            r11 = 0
            r12 = 0
            r13 = 1
            r14 = 45000(0xafc8, float:6.3058E-41)
            r8 = r7
            anet.channel.strategy.IPConnStrategy r8 = anet.channel.strategy.IPConnStrategy.a(r8, r9, r10, r11, r12, r13, r14)     // Catch:{ Exception -> 0x0022 }
            r1.add(r8)     // Catch:{ Exception -> 0x0022 }
        L_0x0095:
            r9 = 443(0x1bb, float:6.21E-43)
            anet.channel.strategy.ConnProtocol r10 = anet.channel.strategy.ConnProtocol.HTTPS     // Catch:{ Exception -> 0x0022 }
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r8 = r7
            anet.channel.strategy.IPConnStrategy r8 = anet.channel.strategy.IPConnStrategy.a(r8, r9, r10, r11, r12, r13, r14)     // Catch:{ Exception -> 0x0022 }
            r1.add(r8)     // Catch:{ Exception -> 0x0022 }
            r9 = 80
            anet.channel.strategy.ConnProtocol r10 = anet.channel.strategy.ConnProtocol.HTTP     // Catch:{ Exception -> 0x0022 }
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r8 = r7
            anet.channel.strategy.IPConnStrategy r8 = anet.channel.strategy.IPConnStrategy.a(r8, r9, r10, r11, r12, r13, r14)     // Catch:{ Exception -> 0x0022 }
            r1.add(r8)     // Catch:{ Exception -> 0x0022 }
            anet.channel.strategy.a r8 = r15.f3915b     // Catch:{ Exception -> 0x0022 }
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.util.List<anet.channel.strategy.IPConnStrategy>> r8 = r8.f3913a     // Catch:{ Exception -> 0x0022 }
            java.lang.String r9 = r15.f3914a     // Catch:{ Exception -> 0x0022 }
            r8.put(r9, r1)     // Catch:{ Exception -> 0x0022 }
            boolean r8 = anet.channel.util.ALog.isPrintLog(r5)     // Catch:{ Exception -> 0x0022 }
            if (r8 == 0) goto L_0x00fd
            java.lang.String r8 = "resolve ip by local dns"
            r9 = 6
            java.lang.Object[] r9 = new java.lang.Object[r9]     // Catch:{ Exception -> 0x0022 }
            r9[r3] = r0     // Catch:{ Exception -> 0x0022 }
            java.lang.String r10 = r15.f3914a     // Catch:{ Exception -> 0x0022 }
            r9[r5] = r10     // Catch:{ Exception -> 0x0022 }
            java.lang.String r10 = "ip"
            r9[r4] = r10     // Catch:{ Exception -> 0x0022 }
            r10 = 3
            r9[r10] = r7     // Catch:{ Exception -> 0x0022 }
            java.lang.String r7 = "list"
            r10 = 4
            r9[r10] = r7     // Catch:{ Exception -> 0x0022 }
            r7 = 5
            r9[r7] = r1     // Catch:{ Exception -> 0x0022 }
            anet.channel.util.ALog.d(r2, r8, r6, r9)     // Catch:{ Exception -> 0x0022 }
            goto L_0x00fd
        L_0x00e2:
            java.net.UnknownHostException r1 = new java.net.UnknownHostException     // Catch:{ Exception -> 0x0022 }
            java.lang.String r7 = r15.f3914a     // Catch:{ Exception -> 0x0022 }
            r1.<init>(r7)     // Catch:{ Exception -> 0x0022 }
            throw r1     // Catch:{ Exception -> 0x0022 }
        L_0x00ea:
            boolean r1 = anet.channel.util.ALog.isPrintLog(r5)
            if (r1 == 0) goto L_0x00fd
            java.lang.Object[] r1 = new java.lang.Object[r4]
            r1[r3] = r0
            java.lang.String r0 = r15.f3914a
            r1[r5] = r0
            java.lang.String r0 = "resolve ip by local dns failed"
            anet.channel.util.ALog.d(r2, r0, r6, r1)
        L_0x00fd:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: anet.channel.strategy.b.run():void");
    }
}
