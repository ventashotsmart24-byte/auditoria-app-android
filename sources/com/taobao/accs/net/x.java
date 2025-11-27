package com.taobao.accs.net;

class x implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ v f13116a;

    public x(v vVar) {
        this.f13116a = vVar;
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x002b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r2 = this;
            com.taobao.accs.net.v r0 = r2.f13116a
            r0.o()
            com.taobao.accs.net.v r0 = r2.f13116a
            com.taobao.accs.ut.monitor.SessionMonitor r0 = r0.I
            if (r0 == 0) goto L_0x0018
            com.taobao.accs.net.v r0 = r2.f13116a
            com.taobao.accs.ut.monitor.SessionMonitor r0 = r0.I
            java.lang.String r1 = "shut down"
            r0.setCloseReason(r1)
        L_0x0018:
            com.taobao.accs.net.v r0 = r2.f13116a
            java.util.LinkedList r0 = r0.f13103u
            monitor-enter(r0)
            com.taobao.accs.net.v r1 = r2.f13116a     // Catch:{ Exception -> 0x002b }
            java.util.LinkedList r1 = r1.f13103u     // Catch:{ Exception -> 0x002b }
            r1.notifyAll()     // Catch:{ Exception -> 0x002b }
            goto L_0x002b
        L_0x0029:
            r1 = move-exception
            goto L_0x002d
        L_0x002b:
            monitor-exit(r0)     // Catch:{ all -> 0x0029 }
            return
        L_0x002d:
            monitor-exit(r0)     // Catch:{ all -> 0x0029 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.accs.net.x.run():void");
    }
}
