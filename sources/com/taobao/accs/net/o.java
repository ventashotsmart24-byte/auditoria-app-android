package com.taobao.accs.net;

import com.taobao.accs.data.Message;

class o implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Message f13080a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ k f13081b;

    public o(k kVar, Message message) {
        this.f13081b = kVar;
        this.f13080a = message;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v3, resolved type: anet.channel.Session} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v4, resolved type: anet.channel.Session} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v5, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v6, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v8, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v9, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v10, resolved type: anet.channel.Session} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v11, resolved type: anet.channel.Session} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v21, resolved type: anet.channel.Session} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v23, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v24, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r0v40 */
    /* JADX WARNING: type inference failed for: r0v42, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r0v44 */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x003d, code lost:
        if ("accs-impaas".equals(r1.f13080a.serviceId) != false) goto L_0x003f;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0197 A[Catch:{ Exception -> 0x00a5, all -> 0x0308 }] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x01a3 A[Catch:{ Exception -> 0x00a5, all -> 0x0308 }] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x024a  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x02c0  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x02e4  */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r28 = this;
            r1 = r28
            java.lang.String r2 = "sendMessage"
            java.lang.String r3 = "accs-impaas"
            java.lang.String r4 = "status"
            java.lang.String r5 = "sendMessage end"
            java.lang.String r6 = "accs"
            java.lang.String r7 = "dataId"
            com.taobao.accs.data.Message r0 = r1.f13080a
            if (r0 == 0) goto L_0x03e7
            com.taobao.accs.ut.monitor.NetPerformanceMonitor r0 = r0.getNetPermanceMonitor()
            if (r0 == 0) goto L_0x0021
            com.taobao.accs.data.Message r0 = r1.f13080a
            com.taobao.accs.ut.monitor.NetPerformanceMonitor r0 = r0.getNetPermanceMonitor()
            r0.onTakeFromQueue()
        L_0x0021:
            com.taobao.accs.data.Message r0 = r1.f13080a
            int r8 = r0.getType()
            r10 = 4
            r11 = 2
            r12 = 1
            r13 = 0
            com.taobao.accs.utl.ALog$Level r0 = com.taobao.accs.utl.ALog.Level.D     // Catch:{ all -> 0x0308 }
            boolean r0 = com.taobao.accs.utl.ALog.isPrintLog(r0)     // Catch:{ all -> 0x0308 }
            java.lang.String r14 = "type"
            if (r0 != 0) goto L_0x003f
            com.taobao.accs.data.Message r0 = r1.f13080a     // Catch:{ all -> 0x0308 }
            java.lang.String r0 = r0.serviceId     // Catch:{ all -> 0x0308 }
            boolean r0 = r3.equals(r0)     // Catch:{ all -> 0x0308 }
            if (r0 == 0) goto L_0x0060
        L_0x003f:
            com.taobao.accs.net.k r0 = r1.f13081b     // Catch:{ all -> 0x0308 }
            java.lang.String r0 = r0.d()     // Catch:{ all -> 0x0308 }
            java.lang.String r15 = "sendMessage start"
            java.lang.Object[] r9 = new java.lang.Object[r10]     // Catch:{ all -> 0x0308 }
            r9[r13] = r7     // Catch:{ all -> 0x0308 }
            com.taobao.accs.data.Message r10 = r1.f13080a     // Catch:{ all -> 0x0308 }
            java.lang.String r10 = r10.getDataId()     // Catch:{ all -> 0x0308 }
            r9[r12] = r10     // Catch:{ all -> 0x0308 }
            r9[r11] = r14     // Catch:{ all -> 0x0308 }
            java.lang.String r10 = com.taobao.accs.data.Message.MsgType.name(r8)     // Catch:{ all -> 0x0308 }
            r16 = 3
            r9[r16] = r10     // Catch:{ all -> 0x0308 }
            com.taobao.accs.utl.ALog.e(r0, r15, r9)     // Catch:{ all -> 0x0308 }
        L_0x0060:
            r9 = 0
            if (r8 != r12) goto L_0x022f
            com.taobao.accs.data.Message r0 = r1.f13080a     // Catch:{ all -> 0x0308 }
            java.net.URL r10 = r0.host     // Catch:{ all -> 0x0308 }
            if (r10 != 0) goto L_0x0074
            com.taobao.accs.net.k r10 = r1.f13081b     // Catch:{ all -> 0x0308 }
            com.taobao.accs.data.d r10 = r10.f13029e     // Catch:{ all -> 0x0308 }
            r14 = -5
            r10.a((com.taobao.accs.data.Message) r0, (int) r14)     // Catch:{ all -> 0x0308 }
            r13 = 1
            goto L_0x0247
        L_0x0074:
            com.taobao.accs.net.k r0 = r1.f13081b     // Catch:{ all -> 0x0308 }
            com.taobao.accs.AccsClientConfig r0 = r0.f13033i     // Catch:{ all -> 0x0308 }
            java.lang.String r0 = r0.getAppKey()     // Catch:{ all -> 0x0308 }
            anet.channel.SessionCenter r0 = anet.channel.SessionCenter.getInstance((java.lang.String) r0)     // Catch:{ all -> 0x0308 }
            com.taobao.accs.net.k r10 = r1.f13081b     // Catch:{ all -> 0x0308 }
            com.taobao.accs.data.Message r14 = r1.f13080a     // Catch:{ all -> 0x0308 }
            java.net.URL r14 = r14.host     // Catch:{ all -> 0x0308 }
            java.lang.String r14 = r14.getHost()     // Catch:{ all -> 0x0308 }
            r10.a((anet.channel.SessionCenter) r0, (java.lang.String) r14, (boolean) r13)     // Catch:{ all -> 0x0308 }
            com.taobao.accs.data.Message r10 = r1.f13080a     // Catch:{ Exception -> 0x00a5 }
            java.net.URL r10 = r10.host     // Catch:{ Exception -> 0x00a5 }
            java.lang.String r10 = r10.toString()     // Catch:{ Exception -> 0x00a5 }
            anet.channel.entity.ConnType$TypeLevel r14 = anet.channel.entity.ConnType.TypeLevel.SPDY     // Catch:{ Exception -> 0x00a5 }
            long r11 = com.taobao.accs.utl.t.d()     // Catch:{ Exception -> 0x00a5 }
            anet.channel.Session r0 = r0.getThrowsException((java.lang.String) r10, (anet.channel.entity.ConnType.TypeLevel) r14, (long) r11)     // Catch:{ Exception -> 0x00a5 }
            r27 = r9
            r9 = r0
            r0 = r27
            goto L_0x00b7
        L_0x00a5:
            r0 = move-exception
            com.taobao.accs.net.k r10 = r1.f13081b     // Catch:{ all -> 0x0308 }
            java.lang.String r10 = r10.d()     // Catch:{ all -> 0x0308 }
            java.lang.String r11 = "get session null"
            java.lang.Object[] r12 = new java.lang.Object[r13]     // Catch:{ all -> 0x0308 }
            com.taobao.accs.utl.ALog.e(r10, r11, r0, r12)     // Catch:{ all -> 0x0308 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0308 }
        L_0x00b7:
            if (r9 == 0) goto L_0x022b
            com.taobao.accs.data.Message r10 = r1.f13080a     // Catch:{ all -> 0x0308 }
            com.taobao.accs.net.k r11 = r1.f13081b     // Catch:{ all -> 0x0308 }
            android.content.Context r12 = r11.f13028d     // Catch:{ all -> 0x0308 }
            int r11 = r11.f13027c     // Catch:{ all -> 0x0308 }
            byte[] r10 = r10.build(r12, r11)     // Catch:{ all -> 0x0308 }
            com.taobao.accs.data.Message r11 = r1.f13080a     // Catch:{ all -> 0x0308 }
            java.lang.String r11 = r11.serviceId     // Catch:{ all -> 0x0308 }
            boolean r11 = r6.equals(r11)     // Catch:{ all -> 0x0308 }
            java.lang.String r12 = "len"
            r18 = 5
            java.lang.String r19 = "host"
            java.lang.String r20 = "command"
            r15 = 10
            if (r11 != 0) goto L_0x0133
            com.taobao.accs.data.Message r11 = r1.f13080a     // Catch:{ all -> 0x0308 }
            java.lang.String r11 = r11.serviceId     // Catch:{ all -> 0x0308 }
            boolean r11 = r3.equals(r11)     // Catch:{ all -> 0x0308 }
            if (r11 == 0) goto L_0x00e4
            goto L_0x0133
        L_0x00e4:
            com.taobao.accs.utl.ALog$Level r11 = com.taobao.accs.utl.ALog.Level.I     // Catch:{ all -> 0x0308 }
            boolean r11 = com.taobao.accs.utl.ALog.isPrintLog(r11)     // Catch:{ all -> 0x0308 }
            if (r11 == 0) goto L_0x0179
            com.taobao.accs.net.k r11 = r1.f13081b     // Catch:{ all -> 0x0308 }
            java.lang.String r11 = r11.d()     // Catch:{ all -> 0x0308 }
            java.lang.Object[] r15 = new java.lang.Object[r15]     // Catch:{ all -> 0x0308 }
            r15[r13] = r7     // Catch:{ all -> 0x0308 }
            com.taobao.accs.data.Message r13 = r1.f13080a     // Catch:{ all -> 0x0308 }
            java.lang.String r13 = r13.getDataId()     // Catch:{ all -> 0x0308 }
            r17 = 1
            r15[r17] = r13     // Catch:{ all -> 0x0308 }
            r13 = 2
            r15[r13] = r20     // Catch:{ all -> 0x0308 }
            com.taobao.accs.data.Message r13 = r1.f13080a     // Catch:{ all -> 0x0308 }
            java.lang.Integer r14 = r13.command     // Catch:{ all -> 0x0308 }
            r16 = 3
            r15[r16] = r14     // Catch:{ all -> 0x0308 }
            r14 = 4
            r15[r14] = r19     // Catch:{ all -> 0x0308 }
            java.net.URL r13 = r13.host     // Catch:{ all -> 0x0308 }
            r15[r18] = r13     // Catch:{ all -> 0x0308 }
            r13 = 6
            r15[r13] = r12     // Catch:{ all -> 0x0308 }
            if (r10 != 0) goto L_0x0119
            r12 = 0
            goto L_0x011a
        L_0x0119:
            int r12 = r10.length     // Catch:{ all -> 0x0308 }
        L_0x011a:
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)     // Catch:{ all -> 0x0308 }
            r13 = 7
            r15[r13] = r12     // Catch:{ all -> 0x0308 }
            java.lang.String r12 = "utdid"
            r13 = 8
            r15[r13] = r12     // Catch:{ all -> 0x0308 }
            com.taobao.accs.net.k r12 = r1.f13081b     // Catch:{ all -> 0x0308 }
            java.lang.String r12 = r12.f13034j     // Catch:{ all -> 0x0308 }
            r13 = 9
            r15[r13] = r12     // Catch:{ all -> 0x0308 }
            com.taobao.accs.utl.ALog.d(r11, r2, r15)     // Catch:{ all -> 0x0308 }
            goto L_0x0179
        L_0x0133:
            com.taobao.accs.net.k r11 = r1.f13081b     // Catch:{ all -> 0x0308 }
            java.lang.String r11 = r11.d()     // Catch:{ all -> 0x0308 }
            java.lang.Object[] r13 = new java.lang.Object[r15]     // Catch:{ all -> 0x0308 }
            r14 = 0
            r13[r14] = r7     // Catch:{ all -> 0x0308 }
            com.taobao.accs.data.Message r14 = r1.f13080a     // Catch:{ all -> 0x0308 }
            java.lang.String r14 = r14.getDataId()     // Catch:{ all -> 0x0308 }
            r15 = 1
            r13[r15] = r14     // Catch:{ all -> 0x0308 }
            r14 = 2
            r13[r14] = r20     // Catch:{ all -> 0x0308 }
            com.taobao.accs.data.Message r14 = r1.f13080a     // Catch:{ all -> 0x0308 }
            java.lang.Integer r15 = r14.command     // Catch:{ all -> 0x0308 }
            r16 = 3
            r13[r16] = r15     // Catch:{ all -> 0x0308 }
            r15 = 4
            r13[r15] = r19     // Catch:{ all -> 0x0308 }
            java.net.URL r14 = r14.host     // Catch:{ all -> 0x0308 }
            r13[r18] = r14     // Catch:{ all -> 0x0308 }
            r14 = 6
            r13[r14] = r12     // Catch:{ all -> 0x0308 }
            if (r10 != 0) goto L_0x0160
            r12 = 0
            goto L_0x0161
        L_0x0160:
            int r12 = r10.length     // Catch:{ all -> 0x0308 }
        L_0x0161:
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)     // Catch:{ all -> 0x0308 }
            r14 = 7
            r13[r14] = r12     // Catch:{ all -> 0x0308 }
            java.lang.String r12 = "utdid"
            r14 = 8
            r13[r14] = r12     // Catch:{ all -> 0x0308 }
            com.taobao.accs.net.k r12 = r1.f13081b     // Catch:{ all -> 0x0308 }
            java.lang.String r12 = r12.f13034j     // Catch:{ all -> 0x0308 }
            r14 = 9
            r13[r14] = r12     // Catch:{ all -> 0x0308 }
            com.taobao.accs.utl.ALog.e(r11, r2, r13)     // Catch:{ all -> 0x0308 }
        L_0x0179:
            com.taobao.accs.data.Message r11 = r1.f13080a     // Catch:{ all -> 0x0308 }
            long r12 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0308 }
            r11.setSendTime(r12)     // Catch:{ all -> 0x0308 }
            java.util.Objects.requireNonNull(r10)     // Catch:{ all -> 0x0308 }
            int r11 = r10.length     // Catch:{ all -> 0x0308 }
            r12 = 49152(0xc000, float:6.8877E-41)
            if (r11 <= r12) goto L_0x01a3
            com.taobao.accs.data.Message r11 = r1.f13080a     // Catch:{ all -> 0x0308 }
            java.lang.Integer r11 = r11.command     // Catch:{ all -> 0x0308 }
            int r11 = r11.intValue()     // Catch:{ all -> 0x0308 }
            r12 = 102(0x66, float:1.43E-43)
            if (r11 == r12) goto L_0x01a3
            com.taobao.accs.net.k r9 = r1.f13081b     // Catch:{ all -> 0x0308 }
            com.taobao.accs.data.d r9 = r9.f13029e     // Catch:{ all -> 0x0308 }
            com.taobao.accs.data.Message r10 = r1.f13080a     // Catch:{ all -> 0x0308 }
            r11 = -4
            r9.a((com.taobao.accs.data.Message) r10, (int) r11)     // Catch:{ all -> 0x0308 }
            goto L_0x0229
        L_0x01a3:
            com.taobao.accs.net.k r11 = r1.f13081b     // Catch:{ all -> 0x0308 }
            com.taobao.accs.data.d r11 = r11.f13029e     // Catch:{ all -> 0x0308 }
            com.taobao.accs.data.Message r12 = r1.f13080a     // Catch:{ all -> 0x0308 }
            r11.a((com.taobao.accs.data.Message) r12)     // Catch:{ all -> 0x0308 }
            com.taobao.accs.data.Message r11 = r1.f13080a     // Catch:{ all -> 0x0308 }
            boolean r12 = r11.isAck     // Catch:{ all -> 0x0308 }
            if (r12 == 0) goto L_0x01bc
            com.taobao.accs.data.Message$Id r11 = r11.getMsgId()     // Catch:{ all -> 0x0308 }
            int r11 = r11.getId()     // Catch:{ all -> 0x0308 }
            int r11 = -r11
            goto L_0x01c4
        L_0x01bc:
            com.taobao.accs.data.Message$Id r11 = r11.getMsgId()     // Catch:{ all -> 0x0308 }
            int r11 = r11.getId()     // Catch:{ all -> 0x0308 }
        L_0x01c4:
            com.taobao.accs.data.Message r12 = r1.f13080a     // Catch:{ all -> 0x0308 }
            boolean r12 = r12.isAck     // Catch:{ all -> 0x0308 }
            if (r12 == 0) goto L_0x01d7
            com.taobao.accs.net.k r12 = r1.f13081b     // Catch:{ all -> 0x0308 }
            java.util.LinkedHashMap<java.lang.Integer, com.taobao.accs.data.Message> r12 = r12.f13036l     // Catch:{ all -> 0x0308 }
            java.lang.Integer r13 = java.lang.Integer.valueOf(r11)     // Catch:{ all -> 0x0308 }
            com.taobao.accs.data.Message r14 = r1.f13080a     // Catch:{ all -> 0x0308 }
            r12.put(r13, r14)     // Catch:{ all -> 0x0308 }
        L_0x01d7:
            r12 = 200(0xc8, float:2.8E-43)
            r9.sendCustomFrame(r11, r10, r12)     // Catch:{ all -> 0x0308 }
            com.taobao.accs.data.Message r9 = r1.f13080a     // Catch:{ all -> 0x0308 }
            com.taobao.accs.ut.monitor.NetPerformanceMonitor r9 = r9.getNetPermanceMonitor()     // Catch:{ all -> 0x0308 }
            if (r9 == 0) goto L_0x01ed
            com.taobao.accs.data.Message r9 = r1.f13080a     // Catch:{ all -> 0x0308 }
            com.taobao.accs.ut.monitor.NetPerformanceMonitor r9 = r9.getNetPermanceMonitor()     // Catch:{ all -> 0x0308 }
            r9.onSendData()     // Catch:{ all -> 0x0308 }
        L_0x01ed:
            com.taobao.accs.net.k r9 = r1.f13081b     // Catch:{ all -> 0x0308 }
            com.taobao.accs.data.Message r11 = r1.f13080a     // Catch:{ all -> 0x0308 }
            java.lang.String r11 = r11.getDataId()     // Catch:{ all -> 0x0308 }
            com.taobao.accs.net.k r12 = r1.f13081b     // Catch:{ all -> 0x0308 }
            com.taobao.accs.AccsClientConfig r12 = r12.f13033i     // Catch:{ all -> 0x0308 }
            boolean r12 = r12.isQuickReconnect()     // Catch:{ all -> 0x0308 }
            com.taobao.accs.data.Message r13 = r1.f13080a     // Catch:{ all -> 0x0308 }
            int r13 = r13.timeout     // Catch:{ all -> 0x0308 }
            long r13 = (long) r13     // Catch:{ all -> 0x0308 }
            r9.a((java.lang.String) r11, (boolean) r12, (long) r13)     // Catch:{ all -> 0x0308 }
            com.taobao.accs.net.k r9 = r1.f13081b     // Catch:{ all -> 0x0308 }
            com.taobao.accs.data.d r9 = r9.f13029e     // Catch:{ all -> 0x0308 }
            com.taobao.accs.ut.monitor.TrafficsMonitor$a r11 = new com.taobao.accs.ut.monitor.TrafficsMonitor$a     // Catch:{ all -> 0x0308 }
            com.taobao.accs.data.Message r12 = r1.f13080a     // Catch:{ all -> 0x0308 }
            java.lang.String r12 = r12.serviceId     // Catch:{ all -> 0x0308 }
            boolean r23 = anet.channel.GlobalAppRuntimeInfo.isAppBackground()     // Catch:{ all -> 0x0308 }
            com.taobao.accs.data.Message r13 = r1.f13080a     // Catch:{ all -> 0x0308 }
            java.net.URL r13 = r13.host     // Catch:{ all -> 0x0308 }
            java.lang.String r24 = r13.toString()     // Catch:{ all -> 0x0308 }
            int r10 = r10.length     // Catch:{ all -> 0x0308 }
            long r13 = (long) r10     // Catch:{ all -> 0x0308 }
            r21 = r11
            r22 = r12
            r25 = r13
            r21.<init>(r22, r23, r24, r25)     // Catch:{ all -> 0x0308 }
            r9.a((com.taobao.accs.ut.monitor.TrafficsMonitor.a) r11)     // Catch:{ all -> 0x0308 }
        L_0x0229:
            r2 = 1
            goto L_0x022c
        L_0x022b:
            r2 = 0
        L_0x022c:
            r9 = r0
            r13 = 1
            goto L_0x0248
        L_0x022f:
            com.taobao.accs.net.k r0 = r1.f13081b     // Catch:{ all -> 0x0308 }
            java.lang.String r0 = r0.d()     // Catch:{ all -> 0x0308 }
            java.lang.String r10 = "sendMessage skip"
            r11 = 2
            java.lang.Object[] r12 = new java.lang.Object[r11]     // Catch:{ all -> 0x0308 }
            r11 = 0
            r12[r11] = r14     // Catch:{ all -> 0x0308 }
            java.lang.String r11 = com.taobao.accs.data.Message.MsgType.name(r8)     // Catch:{ all -> 0x0308 }
            r13 = 1
            r12[r13] = r11     // Catch:{ all -> 0x0308 }
            com.taobao.accs.utl.ALog.e(r0, r10, r12)     // Catch:{ all -> 0x0308 }
        L_0x0247:
            r2 = 1
        L_0x0248:
            if (r2 != 0) goto L_0x02ab
            java.lang.String r0 = "conn time out"
            java.lang.String r10 = "session_error"
            r11 = -11
            if (r8 != r13) goto L_0x0294
            com.taobao.accs.data.Message r8 = r1.f13080a
            boolean r8 = r8.isTimeOut()
            if (r8 != 0) goto L_0x0266
            com.taobao.accs.net.k r8 = r1.f13081b
            com.taobao.accs.data.Message r12 = r1.f13080a
            r13 = 2000(0x7d0, float:2.803E-42)
            boolean r8 = r8.a((com.taobao.accs.data.Message) r12, (int) r13)
            if (r8 != 0) goto L_0x027d
        L_0x0266:
            com.taobao.accs.net.k r8 = r1.f13081b
            com.taobao.accs.data.d r8 = r8.f13029e
            com.taobao.accs.data.Message r12 = r1.f13080a
            r8.a((com.taobao.accs.data.Message) r12, (int) r11)
            com.taobao.accs.data.Message r8 = r1.f13080a
            java.lang.String r8 = r8.serviceId
            if (r9 != 0) goto L_0x0276
            r9 = r0
        L_0x0276:
            java.lang.String r0 = java.lang.String.valueOf(r11)
            com.taobao.accs.utl.k.a(r6, r10, r8, r9, r0)
        L_0x027d:
            com.taobao.accs.data.Message r0 = r1.f13080a
            int r8 = r0.retryTimes
            r9 = 1
            if (r8 != r9) goto L_0x02ab
            com.taobao.accs.ut.monitor.NetPerformanceMonitor r0 = r0.getNetPermanceMonitor()
            if (r0 == 0) goto L_0x02ab
            java.lang.String r0 = "total_accs"
            r8 = 0
            java.lang.String r10 = "resend"
            com.taobao.accs.utl.k.a(r6, r10, r0, r8)
            goto L_0x02ab
        L_0x0294:
            com.taobao.accs.net.k r8 = r1.f13081b
            com.taobao.accs.data.d r8 = r8.f13029e
            com.taobao.accs.data.Message r12 = r1.f13080a
            r8.a((com.taobao.accs.data.Message) r12, (int) r11)
            com.taobao.accs.data.Message r8 = r1.f13080a
            java.lang.String r8 = r8.serviceId
            if (r9 != 0) goto L_0x02a4
            r9 = r0
        L_0x02a4:
            java.lang.String r0 = java.lang.String.valueOf(r11)
            com.taobao.accs.utl.k.a(r6, r10, r8, r9, r0)
        L_0x02ab:
            com.taobao.accs.data.Message r0 = r1.f13080a
            java.lang.String r0 = r0.serviceId
            boolean r0 = r6.equals(r0)
            if (r0 != 0) goto L_0x02e4
            com.taobao.accs.data.Message r0 = r1.f13080a
            java.lang.String r0 = r0.serviceId
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x02c0
            goto L_0x02e4
        L_0x02c0:
            com.taobao.accs.net.k r0 = r1.f13081b
            java.lang.String r0 = r0.d()
            r3 = 4
            java.lang.Object[] r3 = new java.lang.Object[r3]
            r6 = 0
            r3[r6] = r7
            com.taobao.accs.data.Message r6 = r1.f13080a
            java.lang.String r6 = r6.getDataId()
            r7 = 1
            r3[r7] = r6
            r6 = 2
            r3[r6] = r4
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            r4 = 3
            r3[r4] = r2
            com.taobao.accs.utl.ALog.e(r0, r5, r3)
            goto L_0x03e7
        L_0x02e4:
            com.taobao.accs.net.k r0 = r1.f13081b
            java.lang.String r0 = r0.d()
            r3 = 4
            java.lang.Object[] r3 = new java.lang.Object[r3]
            r6 = 0
            r3[r6] = r7
            com.taobao.accs.data.Message r6 = r1.f13080a
            java.lang.String r6 = r6.getDataId()
            r7 = 1
            r3[r7] = r6
            r6 = 2
            r3[r6] = r4
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            r4 = 3
            r3[r4] = r2
            com.taobao.accs.utl.ALog.e(r0, r5, r3)
            goto L_0x03e7
        L_0x0308:
            r0 = move-exception
            java.lang.String r8 = "send_fail"
            com.taobao.accs.data.Message r9 = r1.f13080a     // Catch:{ all -> 0x038f }
            java.lang.String r9 = r9.serviceId     // Catch:{ all -> 0x038f }
            java.lang.String r10 = ""
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x038f }
            r11.<init>()     // Catch:{ all -> 0x038f }
            com.taobao.accs.net.k r12 = r1.f13081b     // Catch:{ all -> 0x038f }
            int r12 = r12.f13027c     // Catch:{ all -> 0x038f }
            r11.append(r12)     // Catch:{ all -> 0x038f }
            java.lang.String r12 = r0.toString()     // Catch:{ all -> 0x038f }
            r11.append(r12)     // Catch:{ all -> 0x038f }
            java.lang.String r11 = r11.toString()     // Catch:{ all -> 0x038f }
            com.taobao.accs.utl.k.a(r6, r8, r9, r10, r11)     // Catch:{ all -> 0x038f }
            com.taobao.accs.net.k r8 = r1.f13081b     // Catch:{ all -> 0x038f }
            java.lang.String r8 = r8.d()     // Catch:{ all -> 0x038f }
            r9 = 0
            java.lang.Object[] r10 = new java.lang.Object[r9]     // Catch:{ all -> 0x038f }
            com.taobao.accs.utl.ALog.e(r8, r2, r0, r10)     // Catch:{ all -> 0x038f }
            com.taobao.accs.data.Message r0 = r1.f13080a
            java.lang.String r0 = r0.serviceId
            boolean r0 = r6.equals(r0)
            if (r0 != 0) goto L_0x036e
            com.taobao.accs.data.Message r0 = r1.f13080a
            java.lang.String r0 = r0.serviceId
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x034c
            goto L_0x036e
        L_0x034c:
            com.taobao.accs.net.k r0 = r1.f13081b
            java.lang.String r0 = r0.d()
            r2 = 4
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r3 = 0
            r2[r3] = r7
            com.taobao.accs.data.Message r3 = r1.f13080a
            java.lang.String r3 = r3.getDataId()
            r6 = 1
            r2[r6] = r3
            r3 = 2
            r2[r3] = r4
            java.lang.Boolean r3 = java.lang.Boolean.TRUE
            r4 = 3
            r2[r4] = r3
            com.taobao.accs.utl.ALog.e(r0, r5, r2)
            goto L_0x03e7
        L_0x036e:
            com.taobao.accs.net.k r0 = r1.f13081b
            java.lang.String r0 = r0.d()
            r2 = 4
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r3 = 0
            r2[r3] = r7
            com.taobao.accs.data.Message r3 = r1.f13080a
            java.lang.String r3 = r3.getDataId()
            r6 = 1
            r2[r6] = r3
            r3 = 2
            r2[r3] = r4
            java.lang.Boolean r3 = java.lang.Boolean.TRUE
            r4 = 3
            r2[r4] = r3
            com.taobao.accs.utl.ALog.e(r0, r5, r2)
            goto L_0x03e7
        L_0x038f:
            r0 = move-exception
            com.taobao.accs.data.Message r2 = r1.f13080a
            java.lang.String r2 = r2.serviceId
            boolean r2 = r6.equals(r2)
            if (r2 != 0) goto L_0x03c6
            com.taobao.accs.data.Message r2 = r1.f13080a
            java.lang.String r2 = r2.serviceId
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x03a5
            goto L_0x03c6
        L_0x03a5:
            com.taobao.accs.net.k r2 = r1.f13081b
            java.lang.String r2 = r2.d()
            r3 = 4
            java.lang.Object[] r3 = new java.lang.Object[r3]
            r6 = 0
            r3[r6] = r7
            com.taobao.accs.data.Message r6 = r1.f13080a
            java.lang.String r6 = r6.getDataId()
            r7 = 1
            r3[r7] = r6
            r6 = 2
            r3[r6] = r4
            java.lang.Boolean r4 = java.lang.Boolean.TRUE
            r6 = 3
            r3[r6] = r4
            com.taobao.accs.utl.ALog.e(r2, r5, r3)
            goto L_0x03e6
        L_0x03c6:
            com.taobao.accs.net.k r2 = r1.f13081b
            java.lang.String r2 = r2.d()
            r3 = 4
            java.lang.Object[] r3 = new java.lang.Object[r3]
            r6 = 0
            r3[r6] = r7
            com.taobao.accs.data.Message r6 = r1.f13080a
            java.lang.String r6 = r6.getDataId()
            r7 = 1
            r3[r7] = r6
            r6 = 2
            r3[r6] = r4
            java.lang.Boolean r4 = java.lang.Boolean.TRUE
            r6 = 3
            r3[r6] = r4
            com.taobao.accs.utl.ALog.e(r2, r5, r3)
        L_0x03e6:
            throw r0
        L_0x03e7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.accs.net.o.run():void");
    }
}
