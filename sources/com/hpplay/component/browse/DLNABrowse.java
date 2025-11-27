package com.hpplay.component.browse;

import com.hpplay.component.common.browse.IBrowseResultListener;
import com.hpplay.component.common.utils.CLog;
import com.hpplay.component.common.utils.ModuleIds;
import com.hpplay.component.modulelinker.api.ModuleLinker;

public class DLNABrowse implements Runnable {
    private static final String TAG = "DLNABrowse";
    private boolean isStart;
    private Thread mThread;
    private final Object object = new Object();

    public String getErrorMsg() {
        try {
            Object callMethod = ModuleLinker.getInstance().callMethod(ModuleIds.METHOD_DLNABROWSECONTROLLER_GETERRORMSG, new Object[0]);
            if (callMethod != null) {
                return callMethod.toString();
            }
            return null;
        } catch (Exception e10) {
            CLog.w(TAG, (Throwable) e10);
            return null;
        }
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
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    public synchronized void release() {
        /*
            r5 = this;
            monitor-enter(r5)
            java.lang.String r0 = "DLNABrowse"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0064 }
            r1.<init>()     // Catch:{ all -> 0x0064 }
            int r2 = r5.hashCode()     // Catch:{ all -> 0x0064 }
            r1.append(r2)     // Catch:{ all -> 0x0064 }
            java.lang.String r2 = " dlna browse  release "
            r1.append(r2)     // Catch:{ all -> 0x0064 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0064 }
            com.hpplay.component.common.utils.CLog.i(r0, r1)     // Catch:{ all -> 0x0064 }
            r0 = 0
            r5.isStart = r0     // Catch:{ all -> 0x0064 }
            com.hpplay.component.modulelinker.api.ModuleLinker r1 = com.hpplay.component.modulelinker.api.ModuleLinker.getInstance()     // Catch:{ Exception -> 0x002a }
            java.lang.String r2 = "F05FAFBB9895DCA991391229E0A5DDAF"
            java.lang.Object[] r3 = new java.lang.Object[r0]     // Catch:{ Exception -> 0x002a }
            r1.callMethod(r2, r3)     // Catch:{ Exception -> 0x002a }
            goto L_0x0030
        L_0x002a:
            r1 = move-exception
            java.lang.String r2 = "DLNABrowse"
            com.hpplay.component.common.utils.CLog.w((java.lang.String) r2, (java.lang.Throwable) r1)     // Catch:{ all -> 0x0064 }
        L_0x0030:
            r1 = 0
            com.hpplay.component.modulelinker.api.ModuleLinker r2 = com.hpplay.component.modulelinker.api.ModuleLinker.getInstance()     // Catch:{ Exception -> 0x0040 }
            java.lang.String r3 = "C2D034B9AB3A4DB5C8034763D2A40B58"
            r4 = 1
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ Exception -> 0x0040 }
            r4[r0] = r1     // Catch:{ Exception -> 0x0040 }
            r2.callMethod(r3, r4)     // Catch:{ Exception -> 0x0040 }
            goto L_0x0046
        L_0x0040:
            r0 = move-exception
            java.lang.String r2 = "DLNABrowse"
            com.hpplay.component.common.utils.CLog.w((java.lang.String) r2, (java.lang.Throwable) r0)     // Catch:{ all -> 0x0064 }
        L_0x0046:
            java.lang.Thread r0 = r5.mThread     // Catch:{ all -> 0x0064 }
            if (r0 == 0) goto L_0x004f
            r0.interrupt()     // Catch:{ all -> 0x0064 }
            r5.mThread = r1     // Catch:{ all -> 0x0064 }
        L_0x004f:
            java.lang.Object r0 = r5.object     // Catch:{ Exception -> 0x005c }
            monitor-enter(r0)     // Catch:{ Exception -> 0x005c }
            java.lang.Object r1 = r5.object     // Catch:{ all -> 0x0059 }
            r1.notify()     // Catch:{ all -> 0x0059 }
            monitor-exit(r0)     // Catch:{ all -> 0x0059 }
            goto L_0x0062
        L_0x0059:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0059 }
            throw r1     // Catch:{ Exception -> 0x005c }
        L_0x005c:
            r0 = move-exception
            java.lang.String r1 = "DLNABrowse"
            com.hpplay.component.common.utils.CLog.w((java.lang.String) r1, (java.lang.Throwable) r0)     // Catch:{ all -> 0x0064 }
        L_0x0062:
            monitor-exit(r5)
            return
        L_0x0064:
            r0 = move-exception
            monitor-exit(r5)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hpplay.component.browse.DLNABrowse.release():void");
    }

    public void run() {
        CLog.i(TAG, "-----------> start ");
        try {
            ModuleLinker.getInstance().callMethod(ModuleIds.METHOD_DLNABROWSECONTROLLER_STARTBROWSE, new Object[0]);
        } catch (Exception e10) {
            CLog.w(TAG, (Throwable) e10);
        }
        while (this.isStart) {
            try {
                synchronized (this.object) {
                    try {
                        ModuleLinker.getInstance().callMethod(ModuleIds.METHOD_DLNABROWSECONTROLLER_SEARCH, new Object[0]);
                    } catch (Exception e11) {
                        CLog.w(TAG, (Throwable) e11);
                    }
                    this.object.wait(3000);
                }
            } catch (InterruptedException e12) {
                CLog.w(TAG, (Throwable) e12);
                return;
            }
        }
    }

    public synchronized void startBrowse(IBrowseResultListener iBrowseResultListener) {
        Thread thread;
        CLog.i(TAG, hashCode() + " dlna  startBrowse ");
        if (this.isStart && (thread = this.mThread) != null && thread.isAlive()) {
            CLog.i(TAG, hashCode() + " mThread.isAlive ");
            release();
        }
        try {
            this.isStart = true;
            ModuleLinker.getInstance().callMethod(ModuleIds.METHOD_DLNABROWSECONTROLLER_SETBROWSELISTENER, iBrowseResultListener);
        } catch (Exception e10) {
            CLog.w(TAG, (Throwable) e10);
        }
        Thread thread2 = new Thread(this);
        this.mThread = thread2;
        thread2.setName(TAG);
        this.mThread.start();
    }
}
