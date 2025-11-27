package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.analytics.pro.bd;
import com.umeng.analytics.pro.bt;
import com.umeng.analytics.pro.cq;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.AnalyticsConstants;
import com.umeng.commonsdk.statistics.common.DataHelper;
import com.umeng.commonsdk.statistics.common.HelperUtils;
import com.umeng.commonsdk.statistics.common.ULog;
import com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback;
import com.umeng.commonsdk.statistics.internal.UMImprintPreProcessCallback;
import com.umeng.commonsdk.statistics.internal.d;
import com.umeng.commonsdk.statistics.proto.e;
import com.umeng.commonsdk.utils.FileLockCallback;
import com.umeng.commonsdk.utils.FileLockUtil;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

public class ImprintHandler implements FileLockCallback {

    /* renamed from: a  reason: collision with root package name */
    private static final String f14917a = "ImprintHandler";

    /* renamed from: b  reason: collision with root package name */
    private static Object f14918b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private static final String f14919c = bd.b().b(bd.f13843c);

    /* renamed from: d  reason: collision with root package name */
    private static final byte[] f14920d = "pbl0".getBytes();

    /* renamed from: f  reason: collision with root package name */
    private static Map<String, ArrayList<UMImprintChangeCallback>> f14921f = new HashMap();

    /* renamed from: g  reason: collision with root package name */
    private static Object f14922g = new Object();

    /* renamed from: j  reason: collision with root package name */
    private static ImprintHandler f14923j = null;

    /* renamed from: k  reason: collision with root package name */
    private static Context f14924k = null;

    /* renamed from: l  reason: collision with root package name */
    private static FileLockUtil f14925l = null;

    /* renamed from: m  reason: collision with root package name */
    private static final int f14926m = 0;

    /* renamed from: n  reason: collision with root package name */
    private static final int f14927n = 1;

    /* renamed from: o  reason: collision with root package name */
    private static Map<String, UMImprintPreProcessCallback> f14928o = new HashMap();

    /* renamed from: p  reason: collision with root package name */
    private static Object f14929p = new Object();

    /* renamed from: e  reason: collision with root package name */
    private d f14930e;

    /* renamed from: h  reason: collision with root package name */
    private a f14931h = new a();

    /* renamed from: i  reason: collision with root package name */
    private com.umeng.commonsdk.statistics.proto.d f14932i = null;

    private ImprintHandler(Context context) {
        f14924k = context.getApplicationContext();
    }

    private static void a(String str, UMImprintChangeCallback uMImprintChangeCallback) {
        synchronized (f14922g) {
            try {
                int i10 = 0;
                if (f14921f.containsKey(str)) {
                    ArrayList arrayList = f14921f.get(str);
                    int size = arrayList.size();
                    ULog.i("--->>> addCallback: before add: callbacks size is: " + size);
                    while (i10 < size) {
                        if (uMImprintChangeCallback == arrayList.get(i10)) {
                            ULog.i("--->>> addCallback: callback has exist, just exit");
                            return;
                        }
                        i10++;
                    }
                    arrayList.add(uMImprintChangeCallback);
                    ULog.i("--->>> addCallback: after add: callbacks size is: " + arrayList.size());
                } else {
                    ArrayList arrayList2 = new ArrayList();
                    int size2 = arrayList2.size();
                    ULog.i("--->>> addCallback: before add: callbacks size is: " + size2);
                    while (i10 < size2) {
                        if (uMImprintChangeCallback == arrayList2.get(i10)) {
                            ULog.i("--->>> addCallback: callback has exist, just exit");
                            return;
                        }
                        i10++;
                    }
                    arrayList2.add(uMImprintChangeCallback);
                    ULog.i("--->>> addCallback: after add: callbacks size is: " + arrayList2.size());
                    f14921f.put(str, arrayList2);
                }
            } catch (Throwable th) {
                UMCrashManager.reportCrash(f14924k, th);
            }
        }
    }

    private static void b(String str, UMImprintChangeCallback uMImprintChangeCallback) {
        if (!TextUtils.isEmpty(str) && uMImprintChangeCallback != null) {
            synchronized (f14922g) {
                try {
                    if (f14921f.containsKey(str)) {
                        ArrayList arrayList = f14921f.get(str);
                        if (arrayList.size() > 0) {
                            int size = arrayList.size();
                            ULog.i("--->>> removeCallback: before remove: callbacks size is: " + size);
                            int i10 = 0;
                            while (true) {
                                if (i10 >= size) {
                                    break;
                                } else if (uMImprintChangeCallback == arrayList.get(i10)) {
                                    ULog.i("--->>> removeCallback: remove index " + i10);
                                    arrayList.remove(i10);
                                    break;
                                } else {
                                    i10++;
                                }
                            }
                            ULog.i("--->>> removeCallback: after remove: callbacks size is: " + arrayList.size());
                            if (arrayList.size() == 0) {
                                ULog.i("--->>> removeCallback: remove key from map: key = " + str);
                                f14921f.remove(str);
                            }
                        }
                    }
                } catch (Throwable th) {
                    UMCrashManager.reportCrash(f14924k, th);
                }
            }
        }
    }

    private boolean c(com.umeng.commonsdk.statistics.proto.d dVar) {
        if (!dVar.i().equals(a(dVar))) {
            return false;
        }
        for (e next : dVar.c().values()) {
            String h10 = next.h();
            if (!TextUtils.isEmpty(h10)) {
                byte[] reverseHexString = DataHelper.reverseHexString(h10);
                byte[] a10 = a(next);
                for (int i10 = 0; i10 < 4; i10++) {
                    if (reverseHexString[i10] != a10[i10]) {
                        return false;
                    }
                }
                continue;
            }
        }
        return true;
    }

    private com.umeng.commonsdk.statistics.proto.d d(com.umeng.commonsdk.statistics.proto.d dVar) {
        Map<String, e> c10 = dVar.c();
        if (c10.containsKey(bt.f13912f)) {
            c10.remove(bt.f13912f);
            this.f14931h.a(bt.f13912f);
            dVar.a(dVar.f());
            dVar.a(a(dVar));
        }
        return dVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0057, code lost:
        r7 = f14928o.get(r5);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.umeng.commonsdk.statistics.proto.d e(com.umeng.commonsdk.statistics.proto.d r10) {
        /*
            r9 = this;
            java.util.Map r0 = r10.c()
            java.util.ArrayList r1 = new java.util.ArrayList
            int r2 = r0.size()
            int r2 = r2 / 2
            r1.<init>(r2)
            java.util.Set r2 = r0.entrySet()
            java.util.Iterator r2 = r2.iterator()
        L_0x0017:
            boolean r3 = r2.hasNext()
            r4 = 0
            if (r3 == 0) goto L_0x00a6
            java.lang.Object r3 = r2.next()
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3
            java.lang.Object r5 = r3.getValue()
            com.umeng.commonsdk.statistics.proto.e r5 = (com.umeng.commonsdk.statistics.proto.e) r5
            boolean r5 = r5.d()
            if (r5 != 0) goto L_0x0038
            java.lang.Object r3 = r3.getKey()
            r1.add(r3)
            goto L_0x0017
        L_0x0038:
            java.lang.Object r5 = r3.getKey()
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Object r3 = r3.getValue()
            com.umeng.commonsdk.statistics.proto.e r3 = (com.umeng.commonsdk.statistics.proto.e) r3
            java.lang.String r3 = r3.f15083a
            java.lang.Object r6 = f14929p
            monitor-enter(r6)
            boolean r7 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x00a3 }
            if (r7 != 0) goto L_0x0069
            java.util.Map<java.lang.String, com.umeng.commonsdk.statistics.internal.UMImprintPreProcessCallback> r7 = f14928o     // Catch:{ all -> 0x00a3 }
            boolean r7 = r7.containsKey(r5)     // Catch:{ all -> 0x00a3 }
            if (r7 == 0) goto L_0x0069
            java.util.Map<java.lang.String, com.umeng.commonsdk.statistics.internal.UMImprintPreProcessCallback> r7 = f14928o     // Catch:{ all -> 0x00a3 }
            java.lang.Object r7 = r7.get(r5)     // Catch:{ all -> 0x00a3 }
            com.umeng.commonsdk.statistics.internal.UMImprintPreProcessCallback r7 = (com.umeng.commonsdk.statistics.internal.UMImprintPreProcessCallback) r7     // Catch:{ all -> 0x00a3 }
            if (r7 == 0) goto L_0x0069
            boolean r7 = r7.onPreProcessImprintKey(r5, r3)     // Catch:{ all -> 0x00a3 }
            if (r7 == 0) goto L_0x0069
            r7 = 1
            goto L_0x006a
        L_0x0069:
            r7 = 0
        L_0x006a:
            monitor-exit(r6)     // Catch:{ all -> 0x00a3 }
            if (r7 == 0) goto L_0x0070
            r1.add(r5)
        L_0x0070:
            java.lang.Object r7 = f14922g
            monitor-enter(r7)
            boolean r6 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x00a0 }
            if (r6 != 0) goto L_0x009d
            java.util.Map<java.lang.String, java.util.ArrayList<com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback>> r6 = f14921f     // Catch:{ all -> 0x00a0 }
            boolean r6 = r6.containsKey(r5)     // Catch:{ all -> 0x00a0 }
            if (r6 == 0) goto L_0x009d
            java.util.Map<java.lang.String, java.util.ArrayList<com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback>> r6 = f14921f     // Catch:{ all -> 0x00a0 }
            java.lang.Object r6 = r6.get(r5)     // Catch:{ all -> 0x00a0 }
            java.util.ArrayList r6 = (java.util.ArrayList) r6     // Catch:{ all -> 0x00a0 }
            if (r6 == 0) goto L_0x009d
        L_0x008b:
            int r8 = r6.size()     // Catch:{ all -> 0x00a0 }
            if (r4 >= r8) goto L_0x009d
            java.lang.Object r8 = r6.get(r4)     // Catch:{ all -> 0x00a0 }
            com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback r8 = (com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback) r8     // Catch:{ all -> 0x00a0 }
            r8.onImprintValueChanged(r5, r3)     // Catch:{ all -> 0x00a0 }
            int r4 = r4 + 1
            goto L_0x008b
        L_0x009d:
            monitor-exit(r7)     // Catch:{ all -> 0x00a0 }
            goto L_0x0017
        L_0x00a0:
            r10 = move-exception
            monitor-exit(r7)     // Catch:{ all -> 0x00a0 }
            throw r10
        L_0x00a3:
            r10 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x00a3 }
            throw r10
        L_0x00a6:
            java.util.Iterator r1 = r1.iterator()
        L_0x00aa:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x00ed
            java.lang.Object r2 = r1.next()
            java.lang.String r2 = (java.lang.String) r2
            java.lang.Object r3 = f14922g
            monitor-enter(r3)
            boolean r5 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x00ea }
            if (r5 != 0) goto L_0x00e5
            java.util.Map<java.lang.String, java.util.ArrayList<com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback>> r5 = f14921f     // Catch:{ all -> 0x00ea }
            boolean r5 = r5.containsKey(r2)     // Catch:{ all -> 0x00ea }
            if (r5 == 0) goto L_0x00e5
            java.util.Map<java.lang.String, java.util.ArrayList<com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback>> r5 = f14921f     // Catch:{ all -> 0x00ea }
            java.lang.Object r5 = r5.get(r2)     // Catch:{ all -> 0x00ea }
            java.util.ArrayList r5 = (java.util.ArrayList) r5     // Catch:{ all -> 0x00ea }
            if (r5 == 0) goto L_0x00e5
            r6 = 0
        L_0x00d2:
            int r7 = r5.size()     // Catch:{ all -> 0x00ea }
            if (r6 >= r7) goto L_0x00e5
            java.lang.Object r7 = r5.get(r6)     // Catch:{ all -> 0x00ea }
            com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback r7 = (com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback) r7     // Catch:{ all -> 0x00ea }
            r8 = 0
            r7.onImprintValueChanged(r2, r8)     // Catch:{ all -> 0x00ea }
            int r6 = r6 + 1
            goto L_0x00d2
        L_0x00e5:
            monitor-exit(r3)     // Catch:{ all -> 0x00ea }
            r0.remove(r2)
            goto L_0x00aa
        L_0x00ea:
            r10 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x00ea }
            throw r10
        L_0x00ed:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.statistics.idtracking.ImprintHandler.e(com.umeng.commonsdk.statistics.proto.d):com.umeng.commonsdk.statistics.proto.d");
    }

    public static synchronized ImprintHandler getImprintService(Context context) {
        ImprintHandler imprintHandler;
        synchronized (ImprintHandler.class) {
            if (f14923j == null) {
                f14923j = new ImprintHandler(context);
                f14925l = new FileLockUtil();
                f14925l.doFileOperateion(new File(f14924k.getFilesDir(), f14919c), (FileLockCallback) f14923j, 0);
            }
            imprintHandler = f14923j;
        }
        return imprintHandler;
    }

    public boolean onFileLock(String str) {
        return false;
    }

    public void registImprintCallback(String str, UMImprintChangeCallback uMImprintChangeCallback) {
        if (!TextUtils.isEmpty(str) && uMImprintChangeCallback != null) {
            a(str, uMImprintChangeCallback);
        }
    }

    public void registPreProcessCallback(String str, UMImprintPreProcessCallback uMImprintPreProcessCallback) {
        if (!TextUtils.isEmpty(str) && uMImprintPreProcessCallback != null) {
            synchronized (f14929p) {
                try {
                    if (!f14928o.containsKey(str)) {
                        f14928o.put(str, uMImprintPreProcessCallback);
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> registPreProcessCallback: key : " + str + " regist success.");
                    } else {
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> key : " + str + " PreProcesser has registed!");
                    }
                } catch (Throwable th) {
                    UMCrashManager.reportCrash(f14924k, th);
                }
            }
        }
    }

    public void unregistImprintCallback(String str, UMImprintChangeCallback uMImprintChangeCallback) {
        if (!TextUtils.isEmpty(str) && uMImprintChangeCallback != null) {
            b(str, uMImprintChangeCallback);
        }
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private Map<String, String> f14933a = new HashMap();

        public a() {
        }

        /* JADX WARNING: Code restructure failed: missing block: B:22:0x005c, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private synchronized void b(com.umeng.commonsdk.statistics.proto.d r6) {
            /*
                r5 = this;
                monitor-enter(r5)
                if (r6 == 0) goto L_0x005b
                boolean r0 = r6.e()     // Catch:{ all -> 0x0059 }
                if (r0 != 0) goto L_0x000a
                goto L_0x005b
            L_0x000a:
                java.util.Map r6 = r6.c()     // Catch:{ all -> 0x0059 }
                java.util.Set r0 = r6.keySet()     // Catch:{ all -> 0x0059 }
                java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x0059 }
            L_0x0016:
                boolean r1 = r0.hasNext()     // Catch:{ all -> 0x0059 }
                if (r1 == 0) goto L_0x0059
                java.lang.Object r1 = r0.next()     // Catch:{ all -> 0x0059 }
                java.lang.String r1 = (java.lang.String) r1     // Catch:{ all -> 0x0059 }
                boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x0059 }
                if (r2 != 0) goto L_0x0016
                java.lang.Object r2 = r6.get(r1)     // Catch:{ all -> 0x0059 }
                com.umeng.commonsdk.statistics.proto.e r2 = (com.umeng.commonsdk.statistics.proto.e) r2     // Catch:{ all -> 0x0059 }
                if (r2 == 0) goto L_0x0016
                java.lang.String r2 = r2.b()     // Catch:{ all -> 0x0059 }
                boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x0059 }
                if (r3 != 0) goto L_0x0016
                java.util.Map<java.lang.String, java.lang.String> r3 = r5.f14933a     // Catch:{ all -> 0x0059 }
                r3.put(r1, r2)     // Catch:{ all -> 0x0059 }
                boolean r3 = com.umeng.commonsdk.statistics.AnalyticsConstants.UM_DEBUG     // Catch:{ all -> 0x0059 }
                if (r3 == 0) goto L_0x0016
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0059 }
                r3.<init>()     // Catch:{ all -> 0x0059 }
                java.lang.String r4 = "imKey is "
                r3.append(r4)     // Catch:{ all -> 0x0059 }
                r3.append(r1)     // Catch:{ all -> 0x0059 }
                java.lang.String r1 = ", imValue is "
                r3.append(r1)     // Catch:{ all -> 0x0059 }
                r3.append(r2)     // Catch:{ all -> 0x0059 }
                goto L_0x0016
            L_0x0059:
                monitor-exit(r5)
                return
            L_0x005b:
                monitor-exit(r5)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.statistics.idtracking.ImprintHandler.a.b(com.umeng.commonsdk.statistics.proto.d):void");
        }

        public synchronized void a(String str) {
            Map<String, String> map = this.f14933a;
            if (map != null && map.size() > 0 && !TextUtils.isEmpty(str) && this.f14933a.containsKey(str)) {
                this.f14933a.remove(str);
            }
        }

        public a(com.umeng.commonsdk.statistics.proto.d dVar) {
            a(dVar);
        }

        public void a(com.umeng.commonsdk.statistics.proto.d dVar) {
            if (dVar != null) {
                b(dVar);
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0023, code lost:
            return r3;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public synchronized java.lang.String a(java.lang.String r2, java.lang.String r3) {
            /*
                r1 = this;
                monitor-enter(r1)
                boolean r0 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x0024 }
                if (r0 != 0) goto L_0x0022
                java.util.Map<java.lang.String, java.lang.String> r0 = r1.f14933a     // Catch:{ all -> 0x0024 }
                int r0 = r0.size()     // Catch:{ all -> 0x0024 }
                if (r0 > 0) goto L_0x0010
                goto L_0x0022
            L_0x0010:
                java.util.Map<java.lang.String, java.lang.String> r0 = r1.f14933a     // Catch:{ all -> 0x0024 }
                java.lang.Object r2 = r0.get(r2)     // Catch:{ all -> 0x0024 }
                java.lang.String r2 = (java.lang.String) r2     // Catch:{ all -> 0x0024 }
                boolean r0 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x0024 }
                if (r0 != 0) goto L_0x0020
                monitor-exit(r1)
                return r2
            L_0x0020:
                monitor-exit(r1)
                return r3
            L_0x0022:
                monitor-exit(r1)
                return r3
            L_0x0024:
                r2 = move-exception
                monitor-exit(r1)
                throw r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.statistics.idtracking.ImprintHandler.a.a(java.lang.String, java.lang.String):java.lang.String");
        }
    }

    public boolean onFileLock(String str, Object obj) {
        return false;
    }

    public boolean onFileLock(File file, int i10) {
        if (i10 == 0) {
            f14923j.e();
        } else if (i10 == 1) {
            f14923j.a(file);
        }
        return true;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:7|8|9|10) */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0024, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0025, code lost:
        com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(f14924k, r1);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0020 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void d() {
        /*
            r4 = this;
            com.umeng.commonsdk.statistics.proto.d r0 = r4.f14932i
            if (r0 != 0) goto L_0x0005
            return
        L_0x0005:
            com.umeng.commonsdk.utils.FileLockUtil r0 = f14925l
            if (r0 == 0) goto L_0x0032
            java.io.File r0 = new java.io.File
            android.content.Context r1 = f14924k
            java.io.File r1 = r1.getFilesDir()
            java.lang.String r2 = f14919c
            r0.<init>(r1, r2)
            boolean r1 = r0.exists()
            if (r1 != 0) goto L_0x002a
            r0.createNewFile()     // Catch:{ IOException -> 0x0020 }
            goto L_0x002a
        L_0x0020:
            r0.createNewFile()     // Catch:{ IOException -> 0x0024 }
            goto L_0x002a
        L_0x0024:
            r1 = move-exception
            android.content.Context r2 = f14924k
            com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(r2, r1)
        L_0x002a:
            com.umeng.commonsdk.utils.FileLockUtil r1 = f14925l
            com.umeng.commonsdk.statistics.idtracking.ImprintHandler r2 = f14923j
            r3 = 1
            r1.doFileOperateion((java.io.File) r0, (com.umeng.commonsdk.utils.FileLockCallback) r2, (int) r3)
        L_0x0032:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.statistics.idtracking.ImprintHandler.d():void");
    }

    public a c() {
        return this.f14931h;
    }

    public void b(com.umeng.commonsdk.statistics.proto.d dVar) {
        String str;
        com.umeng.commonsdk.statistics.proto.d dVar2;
        boolean z10;
        if (dVar == null) {
            if (AnalyticsConstants.UM_DEBUG) {
                UMRTLog.d(UMRTLog.RTLOG_TAG, "Imprint is null");
            }
        } else if (c(dVar)) {
            String str2 = AnalyticsConstants.OS;
            HashMap hashMap = new HashMap();
            synchronized (this) {
                com.umeng.commonsdk.statistics.proto.d dVar3 = this.f14932i;
                com.umeng.commonsdk.statistics.proto.d d10 = d(dVar);
                String str3 = null;
                if (dVar3 == null) {
                    str = null;
                } else {
                    str = dVar3.i();
                }
                if (dVar3 == null) {
                    dVar2 = e(d10);
                } else {
                    dVar2 = a(dVar3, d10, hashMap);
                }
                this.f14932i = dVar2;
                if (dVar2 != null) {
                    str3 = dVar2.i();
                }
                z10 = !a(str, str3);
            }
            com.umeng.commonsdk.statistics.proto.d dVar4 = this.f14932i;
            if (dVar4 != null && z10) {
                this.f14931h.a(dVar4);
                d dVar5 = this.f14930e;
                if (dVar5 != null) {
                    dVar5.onImprintChanged(this.f14931h);
                }
            }
            if (hashMap.size() > 0) {
                synchronized (f14922g) {
                    for (Map.Entry entry : hashMap.entrySet()) {
                        String str4 = (String) entry.getKey();
                        String str5 = (String) entry.getValue();
                        if (!TextUtils.isEmpty(str4) && f14921f.containsKey(str4)) {
                            ULog.i("--->>> target imprint key is: " + str4 + "; value is: " + str5);
                            ArrayList arrayList = f14921f.get(str4);
                            if (arrayList != null) {
                                for (int i10 = 0; i10 < arrayList.size(); i10++) {
                                    ((UMImprintChangeCallback) arrayList.get(i10)).onImprintValueChanged(str4, str5);
                                }
                            }
                        }
                    }
                }
            }
        } else if (AnalyticsConstants.UM_DEBUG) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "Imprint is not valid");
        }
    }

    public void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            synchronized (f14929p) {
                try {
                    if (f14928o.containsKey(str)) {
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> unregistPreProcessCallback: unregist [" + str + "] success.");
                        f14921f.remove(str);
                    } else {
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> unregistPreProcessCallback: can't find [" + str + "], pls regist first.");
                    }
                } catch (Throwable th) {
                    UMCrashManager.reportCrash(f14924k, th);
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0059, code lost:
        r0 = th;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0036 A[SYNTHETIC, Splitter:B:22:0x0036] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void e() {
        /*
            r5 = this;
            java.io.File r0 = new java.io.File
            android.content.Context r1 = f14924k
            java.io.File r1 = r1.getFilesDir()
            java.lang.String r2 = f14919c
            r0.<init>(r1, r2)
            java.lang.Object r1 = f14918b
            monitor-enter(r1)
            boolean r0 = r0.exists()     // Catch:{ all -> 0x005e }
            if (r0 != 0) goto L_0x0018
            monitor-exit(r1)     // Catch:{ all -> 0x005e }
            return
        L_0x0018:
            r0 = 0
            android.content.Context r3 = f14924k     // Catch:{ Exception -> 0x002e, all -> 0x0029 }
            java.io.FileInputStream r2 = r3.openFileInput(r2)     // Catch:{ Exception -> 0x002e, all -> 0x0029 }
            byte[] r0 = com.umeng.commonsdk.statistics.common.HelperUtils.readStreamToByteArray(r2)     // Catch:{ Exception -> 0x0027 }
        L_0x0023:
            com.umeng.commonsdk.statistics.common.HelperUtils.safeClose((java.io.InputStream) r2)     // Catch:{ all -> 0x005e }
            goto L_0x0034
        L_0x0027:
            r3 = move-exception
            goto L_0x0030
        L_0x0029:
            r2 = move-exception
            r4 = r2
            r2 = r0
            r0 = r4
            goto L_0x005a
        L_0x002e:
            r3 = move-exception
            r2 = r0
        L_0x0030:
            r3.printStackTrace()     // Catch:{ all -> 0x0059 }
            goto L_0x0023
        L_0x0034:
            if (r0 == 0) goto L_0x0057
            com.umeng.commonsdk.statistics.proto.d r2 = new com.umeng.commonsdk.statistics.proto.d     // Catch:{ Exception -> 0x0053 }
            r2.<init>()     // Catch:{ Exception -> 0x0053 }
            com.umeng.analytics.pro.ck r3 = new com.umeng.analytics.pro.ck     // Catch:{ Exception -> 0x0053 }
            r3.<init>()     // Catch:{ Exception -> 0x0053 }
            r3.a((com.umeng.analytics.pro.ch) r2, (byte[]) r0)     // Catch:{ Exception -> 0x0053 }
            r5.f14932i = r2     // Catch:{ Exception -> 0x0053 }
            com.umeng.commonsdk.statistics.idtracking.ImprintHandler$a r0 = r5.f14931h     // Catch:{ Exception -> 0x0053 }
            r0.a((com.umeng.commonsdk.statistics.proto.d) r2)     // Catch:{ Exception -> 0x0053 }
            com.umeng.commonsdk.statistics.proto.d r0 = r5.f14932i     // Catch:{ Exception -> 0x0053 }
            com.umeng.commonsdk.statistics.proto.d r0 = r5.d(r0)     // Catch:{ Exception -> 0x0053 }
            r5.f14932i = r0     // Catch:{ Exception -> 0x0053 }
            goto L_0x0057
        L_0x0053:
            r0 = move-exception
            r0.printStackTrace()     // Catch:{ all -> 0x005e }
        L_0x0057:
            monitor-exit(r1)     // Catch:{ all -> 0x005e }
            return
        L_0x0059:
            r0 = move-exception
        L_0x005a:
            com.umeng.commonsdk.statistics.common.HelperUtils.safeClose((java.io.InputStream) r2)     // Catch:{ all -> 0x005e }
            throw r0     // Catch:{ all -> 0x005e }
        L_0x005e:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x005e }
            goto L_0x0062
        L_0x0061:
            throw r0
        L_0x0062:
            goto L_0x0061
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.statistics.idtracking.ImprintHandler.e():void");
    }

    public void a(d dVar) {
        this.f14930e = dVar;
    }

    public String a(com.umeng.commonsdk.statistics.proto.d dVar) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry entry : new TreeMap(dVar.c()).entrySet()) {
            sb.append((String) entry.getKey());
            if (((e) entry.getValue()).d()) {
                sb.append(((e) entry.getValue()).b());
            }
        }
        sb.append(dVar.f15065b);
        return HelperUtils.MD5(sb.toString()).toLowerCase(Locale.US);
    }

    public byte[] a(e eVar) {
        ByteBuffer allocate = ByteBuffer.allocate(8);
        allocate.order((ByteOrder) null);
        allocate.putLong(eVar.e());
        byte[] array = allocate.array();
        byte[] bArr = f14920d;
        byte[] bArr2 = new byte[4];
        for (int i10 = 0; i10 < 4; i10++) {
            bArr2[i10] = (byte) (array[i10] ^ bArr[i10]);
        }
        return bArr2;
    }

    public byte[] a() {
        try {
            synchronized (this) {
                com.umeng.commonsdk.statistics.proto.d dVar = this.f14932i;
                if (dVar == null) {
                    return null;
                }
                if (dVar.b() <= 0) {
                    return null;
                }
                byte[] a10 = new cq().a(this.f14932i);
                return a10;
            }
        } catch (Throwable th) {
            UMCrashManager.reportCrash(f14924k, th);
            return null;
        }
    }

    public synchronized com.umeng.commonsdk.statistics.proto.d b() {
        return this.f14932i;
    }

    private boolean a(String str, String str2) {
        if (str == null) {
            return str2 == null;
        }
        return str.equals(str2);
    }

    private com.umeng.commonsdk.statistics.proto.d a(com.umeng.commonsdk.statistics.proto.d dVar, com.umeng.commonsdk.statistics.proto.d dVar2, Map<String, String> map) {
        ArrayList arrayList;
        UMImprintPreProcessCallback uMImprintPreProcessCallback;
        if (dVar2 == null) {
            return dVar;
        }
        Map<String, e> c10 = dVar.c();
        for (Map.Entry next : dVar2.c().entrySet()) {
            int i10 = 0;
            if (((e) next.getValue()).d()) {
                String str = (String) next.getKey();
                String str2 = ((e) next.getValue()).f15083a;
                synchronized (f14929p) {
                    if (!TextUtils.isEmpty(str) && f14928o.containsKey(str) && (uMImprintPreProcessCallback = f14928o.get(str)) != null && uMImprintPreProcessCallback.onPreProcessImprintKey(str, str2)) {
                        i10 = 1;
                    }
                }
                if (i10 == 0) {
                    c10.put(next.getKey(), next.getValue());
                    synchronized (f14922g) {
                        if (!TextUtils.isEmpty(str) && f14921f.containsKey(str) && f14921f.get(str) != null) {
                            map.put(str, str2);
                        }
                    }
                } else {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> merge: [" + str + "] should be ignored.");
                }
            } else {
                String str3 = (String) next.getKey();
                synchronized (f14922g) {
                    if (!TextUtils.isEmpty(str3) && f14921f.containsKey(str3) && (arrayList = f14921f.get(str3)) != null) {
                        while (i10 < arrayList.size()) {
                            ((UMImprintChangeCallback) arrayList.get(i10)).onImprintValueChanged(str3, (String) null);
                            i10++;
                        }
                    }
                }
                c10.remove(str3);
                this.f14931h.a(str3);
            }
        }
        dVar.a(dVar2.f());
        dVar.a(a(dVar));
        return dVar;
    }

    private void a(File file) {
        if (this.f14932i != null) {
            try {
                synchronized (f14918b) {
                    byte[] a10 = new cq().a(this.f14932i);
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    try {
                        fileOutputStream.write(a10);
                        fileOutputStream.flush();
                    } finally {
                        HelperUtils.safeClose((OutputStream) fileOutputStream);
                    }
                }
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
    }
}
