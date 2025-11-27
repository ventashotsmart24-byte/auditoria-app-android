package com.alibaba.sdk.android.utils.crashdefend;

import android.content.Context;
import android.text.TextUtils;
import com.taobao.accs.common.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;

public class b {

    /* renamed from: b  reason: collision with root package name */
    private static b f5061b;

    /* renamed from: a  reason: collision with root package name */
    private com.alibaba.sdk.android.utils.a f5062a;

    /* renamed from: a  reason: collision with other field name */
    private a f45a = new a();

    /* renamed from: a  reason: collision with other field name */
    private c f46a;

    /* renamed from: a  reason: collision with other field name */
    private final List<c> f47a = new ArrayList();

    /* renamed from: a  reason: collision with other field name */
    private ExecutorService f48a = null;

    /* renamed from: a  reason: collision with other field name */
    private final int[] f49a = new int[5];
    private Context context;

    /* renamed from: d  reason: collision with root package name */
    private Map<String, String> f5063d = new HashMap();

    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private d f5064a;

        public a(d dVar) {
            this.f5064a = dVar;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:8:0x0030, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0031, code lost:
            r0.getMessage();
         */
        /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r3 = this;
            L_0x0000:
                r0 = 1000(0x3e8, double:4.94E-321)
                java.lang.Thread.sleep(r0)     // Catch:{ InterruptedException -> 0x0034, Exception -> 0x0030, all -> 0x002e }
                com.alibaba.sdk.android.utils.crashdefend.d r0 = r3.f5064a     // Catch:{ InterruptedException -> 0x0034, Exception -> 0x0030, all -> 0x002e }
                int r1 = r0.f5070d     // Catch:{ InterruptedException -> 0x0034, Exception -> 0x0030, all -> 0x002e }
                int r1 = r1 + -1
                r0.f5070d = r1     // Catch:{ InterruptedException -> 0x0034, Exception -> 0x0030, all -> 0x002e }
                if (r1 > 0) goto L_0x0000
                if (r1 > 0) goto L_0x0034
                com.alibaba.sdk.android.utils.crashdefend.b r1 = com.alibaba.sdk.android.utils.crashdefend.b.this     // Catch:{ InterruptedException -> 0x0034, Exception -> 0x0030, all -> 0x002e }
                com.alibaba.sdk.android.utils.crashdefend.c r0 = r0.f5069b     // Catch:{ InterruptedException -> 0x0034, Exception -> 0x0030, all -> 0x002e }
                r1.b(r0)     // Catch:{ InterruptedException -> 0x0034, Exception -> 0x0030, all -> 0x002e }
                com.alibaba.sdk.android.utils.crashdefend.b r0 = com.alibaba.sdk.android.utils.crashdefend.b.this     // Catch:{ InterruptedException -> 0x0034, Exception -> 0x0030, all -> 0x002e }
                android.content.Context r0 = com.alibaba.sdk.android.utils.crashdefend.b.a((com.alibaba.sdk.android.utils.crashdefend.b) r0)     // Catch:{ InterruptedException -> 0x0034, Exception -> 0x0030, all -> 0x002e }
                com.alibaba.sdk.android.utils.crashdefend.b r1 = com.alibaba.sdk.android.utils.crashdefend.b.this     // Catch:{ InterruptedException -> 0x0034, Exception -> 0x0030, all -> 0x002e }
                com.alibaba.sdk.android.utils.crashdefend.a r1 = com.alibaba.sdk.android.utils.crashdefend.b.a((com.alibaba.sdk.android.utils.crashdefend.b) r1)     // Catch:{ InterruptedException -> 0x0034, Exception -> 0x0030, all -> 0x002e }
                com.alibaba.sdk.android.utils.crashdefend.b r2 = com.alibaba.sdk.android.utils.crashdefend.b.this     // Catch:{ InterruptedException -> 0x0034, Exception -> 0x0030, all -> 0x002e }
                java.util.List r2 = com.alibaba.sdk.android.utils.crashdefend.b.a((com.alibaba.sdk.android.utils.crashdefend.b) r2)     // Catch:{ InterruptedException -> 0x0034, Exception -> 0x0030, all -> 0x002e }
                com.alibaba.sdk.android.utils.crashdefend.e.a((android.content.Context) r0, (com.alibaba.sdk.android.utils.crashdefend.a) r1, (java.util.List<com.alibaba.sdk.android.utils.crashdefend.c>) r2)     // Catch:{ InterruptedException -> 0x0034, Exception -> 0x0030, all -> 0x002e }
                goto L_0x0034
            L_0x002e:
                r0 = move-exception
                throw r0
            L_0x0030:
                r0 = move-exception
                r0.getMessage()
            L_0x0034:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.utils.crashdefend.b.a.run():void");
        }
    }

    private b(Context context2, com.alibaba.sdk.android.utils.a aVar) {
        this.context = context2;
        this.f5062a = aVar;
        this.f48a = new f().a();
        for (int i10 = 0; i10 < 5; i10++) {
            this.f49a[i10] = (i10 * 5) + 5;
        }
        this.f5063d.put("sdkId", "utils");
        this.f5063d.put(Constants.KEY_SDK_VERSION, "2.0.0");
        try {
            a();
            b();
        } catch (Exception e10) {
            e10.getMessage();
        }
    }

    public void b(String str, String str2) {
    }

    private void b() {
        this.f46a = null;
        ArrayList arrayList = new ArrayList();
        synchronized (this.f47a) {
            for (c next : this.f47a) {
                if (next.crashCount >= next.f5066a) {
                    arrayList.add(next);
                }
            }
            Iterator it = arrayList.iterator();
            while (true) {
                if (it.hasNext()) {
                    c cVar = (c) it.next();
                    int i10 = cVar.f5068c;
                    if (i10 < 5) {
                        long j10 = this.f45a.f5060a - ((long) this.f49a[i10]);
                        g.a("UtilsSDK", "after restart " + ((cVar.f50a - j10) + 1) + " times, sdk will be restore");
                        if (cVar.f50a < j10) {
                            this.f46a = cVar;
                            break;
                        }
                    } else {
                        StringBuilder sb = new StringBuilder();
                        sb.append("SDK ");
                        sb.append(cVar.f52a);
                        sb.append(" has been closed");
                    }
                } else {
                    break;
                }
            }
            c cVar2 = this.f46a;
            if (cVar2 != null) {
                cVar2.f5068c++;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(this.f46a.f52a);
                sb2.append(" will restore --- startSerialNumber:");
                sb2.append(this.f46a.f50a);
                sb2.append("   crashCount:");
                sb2.append(this.f46a.crashCount);
            }
        }
    }

    public static synchronized b a(Context context2, com.alibaba.sdk.android.utils.a aVar) {
        b bVar;
        synchronized (b.class) {
            if (f5061b == null) {
                f5061b = new b(context2, aVar);
            }
            bVar = f5061b;
        }
        return bVar;
    }

    private void a() {
        if (e.a(this.context, this.f45a, this.f47a)) {
            this.f45a.f5060a++;
            return;
        }
        this.f45a.f5060a = 1;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m20a(c cVar, SDKMessageCallback sDKMessageCallback) {
        if (!(cVar == null || sDKMessageCallback == null)) {
            try {
                if (!TextUtils.isEmpty(cVar.f54b)) {
                    if (!TextUtils.isEmpty(cVar.f52a)) {
                        c a10 = a(cVar, sDKMessageCallback);
                        if (a10 == null) {
                            return false;
                        }
                        boolean a11 = a(a10);
                        int i10 = a10.crashCount;
                        int i11 = a10.f5066a;
                        if (i10 == i11) {
                            a(a10.f52a, a10.f54b, i10, i11);
                        }
                        a10.crashCount++;
                        e.a(this.context, this.f45a, this.f47a);
                        if (a11) {
                            a(a10);
                            StringBuilder sb = new StringBuilder();
                            sb.append("START:");
                            sb.append(a10.f52a);
                            sb.append(" --- limit:");
                            sb.append(a10.f5066a);
                            sb.append("  count:");
                            sb.append(a10.crashCount - 1);
                            sb.append("  restore:");
                            sb.append(a10.f5068c);
                            sb.append("  startSerialNumber:");
                            sb.append(a10.f50a);
                            sb.append("  registerSerialNumber:");
                            sb.append(a10.f53b);
                        } else {
                            sDKMessageCallback.crashDefendMessage(a10.f5066a, a10.crashCount - 1);
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("STOP:");
                            sb2.append(a10.f52a);
                            sb2.append(" --- limit:");
                            sb2.append(a10.f5066a);
                            sb2.append("  count:");
                            sb2.append(a10.crashCount - 1);
                            sb2.append("  restore:");
                            sb2.append(a10.f5068c);
                            sb2.append("  startSerialNumber:");
                            sb2.append(a10.f50a);
                            sb2.append("  registerSerialNumber:");
                            sb2.append(a10.f53b);
                        }
                        return true;
                    }
                }
                return false;
            } catch (Exception e10) {
                e10.getMessage();
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    public void b(c cVar) {
        if (cVar != null) {
            int i10 = cVar.f5068c;
            if (i10 > 0) {
                b(cVar.f52a, cVar.f54b, i10, 5);
            }
            cVar.crashCount = 0;
            cVar.f5068c = 0;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v2, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: com.alibaba.sdk.android.utils.crashdefend.c} */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0088, code lost:
        return r4;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.alibaba.sdk.android.utils.crashdefend.c a(com.alibaba.sdk.android.utils.crashdefend.c r9, com.alibaba.sdk.android.utils.crashdefend.SDKMessageCallback r10) {
        /*
            r8 = this;
            java.util.List<com.alibaba.sdk.android.utils.crashdefend.c> r0 = r8.f47a
            monitor-enter(r0)
            java.util.List<com.alibaba.sdk.android.utils.crashdefend.c> r1 = r8.f47a     // Catch:{ all -> 0x0089 }
            r2 = 1
            r3 = 0
            r4 = 0
            if (r1 == 0) goto L_0x006d
            int r1 = r1.size()     // Catch:{ all -> 0x0089 }
            if (r1 <= 0) goto L_0x006d
            java.util.List<com.alibaba.sdk.android.utils.crashdefend.c> r1 = r8.f47a     // Catch:{ all -> 0x0089 }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x0089 }
        L_0x0016:
            boolean r5 = r1.hasNext()     // Catch:{ all -> 0x0089 }
            if (r5 == 0) goto L_0x006d
            java.lang.Object r5 = r1.next()     // Catch:{ all -> 0x0089 }
            com.alibaba.sdk.android.utils.crashdefend.c r5 = (com.alibaba.sdk.android.utils.crashdefend.c) r5     // Catch:{ all -> 0x0089 }
            if (r5 == 0) goto L_0x0016
            java.lang.String r6 = r5.f52a     // Catch:{ all -> 0x0089 }
            java.lang.String r7 = r9.f52a     // Catch:{ all -> 0x0089 }
            boolean r6 = r6.equals(r7)     // Catch:{ all -> 0x0089 }
            if (r6 == 0) goto L_0x0016
            java.lang.String r1 = r5.f54b     // Catch:{ all -> 0x0089 }
            java.lang.String r6 = r9.f54b     // Catch:{ all -> 0x0089 }
            boolean r1 = r1.equals(r6)     // Catch:{ all -> 0x0089 }
            if (r1 != 0) goto L_0x0048
            java.lang.String r1 = r9.f54b     // Catch:{ all -> 0x0089 }
            r5.f54b = r1     // Catch:{ all -> 0x0089 }
            int r1 = r9.f5066a     // Catch:{ all -> 0x0089 }
            r5.f5066a = r1     // Catch:{ all -> 0x0089 }
            int r1 = r9.f5067b     // Catch:{ all -> 0x0089 }
            r5.f5067b = r1     // Catch:{ all -> 0x0089 }
            r5.crashCount = r3     // Catch:{ all -> 0x0089 }
            r5.f5068c = r3     // Catch:{ all -> 0x0089 }
        L_0x0048:
            boolean r1 = r5.f55c     // Catch:{ all -> 0x0089 }
            if (r1 == 0) goto L_0x0062
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x0089 }
            r10.<init>()     // Catch:{ all -> 0x0089 }
            java.lang.String r1 = "SDK "
            r10.append(r1)     // Catch:{ all -> 0x0089 }
            java.lang.String r9 = r9.f52a     // Catch:{ all -> 0x0089 }
            r10.append(r9)     // Catch:{ all -> 0x0089 }
            java.lang.String r9 = " has been registered"
            r10.append(r9)     // Catch:{ all -> 0x0089 }
            monitor-exit(r0)     // Catch:{ all -> 0x0089 }
            return r4
        L_0x0062:
            r5.f55c = r2     // Catch:{ all -> 0x0089 }
            r5.f51a = r10     // Catch:{ all -> 0x0089 }
            com.alibaba.sdk.android.utils.crashdefend.a r1 = r8.f45a     // Catch:{ all -> 0x0089 }
            long r6 = r1.f5060a     // Catch:{ all -> 0x0089 }
            r5.f53b = r6     // Catch:{ all -> 0x0089 }
            r4 = r5
        L_0x006d:
            if (r4 != 0) goto L_0x0087
            java.lang.Object r9 = r9.clone()     // Catch:{ all -> 0x0089 }
            r4 = r9
            com.alibaba.sdk.android.utils.crashdefend.c r4 = (com.alibaba.sdk.android.utils.crashdefend.c) r4     // Catch:{ all -> 0x0089 }
            r4.f55c = r2     // Catch:{ all -> 0x0089 }
            r4.f51a = r10     // Catch:{ all -> 0x0089 }
            r4.crashCount = r3     // Catch:{ all -> 0x0089 }
            com.alibaba.sdk.android.utils.crashdefend.a r9 = r8.f45a     // Catch:{ all -> 0x0089 }
            long r9 = r9.f5060a     // Catch:{ all -> 0x0089 }
            r4.f53b = r9     // Catch:{ all -> 0x0089 }
            java.util.List<com.alibaba.sdk.android.utils.crashdefend.c> r9 = r8.f47a     // Catch:{ all -> 0x0089 }
            r9.add(r4)     // Catch:{ all -> 0x0089 }
        L_0x0087:
            monitor-exit(r0)     // Catch:{ all -> 0x0089 }
            return r4
        L_0x0089:
            r9 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0089 }
            goto L_0x008d
        L_0x008c:
            throw r9
        L_0x008d:
            goto L_0x008c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.utils.crashdefend.b.a(com.alibaba.sdk.android.utils.crashdefend.c, com.alibaba.sdk.android.utils.crashdefend.SDKMessageCallback):com.alibaba.sdk.android.utils.crashdefend.c");
    }

    private void b(String str, String str2, int i10, int i11) {
        if (this.f5062a != null) {
            HashMap hashMap = new HashMap();
            hashMap.putAll(this.f5063d);
            hashMap.put("crashSdkId", str);
            hashMap.put("crashSdkVer", str2);
            hashMap.put("recoverCount", String.valueOf(i10));
            hashMap.put("recoverThreshold", String.valueOf(i11));
            this.f5062a.sendCustomHit("utils_biz_recover", 0, hashMap);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    private boolean m19a(c cVar) {
        if (cVar.crashCount < cVar.f5066a) {
            cVar.f50a = cVar.f53b;
            return true;
        }
        c cVar2 = this.f46a;
        if (cVar2 == null || !cVar2.f52a.equals(cVar.f52a)) {
            return false;
        }
        cVar.crashCount = cVar.f5066a - 1;
        cVar.f50a = cVar.f53b;
        return true;
    }

    private void a(c cVar) {
        if (cVar != null) {
            d dVar = new d();
            dVar.f5069b = cVar;
            dVar.f5070d = cVar.f5067b;
            a(dVar);
            SDKMessageCallback sDKMessageCallback = cVar.f51a;
            if (sDKMessageCallback != null) {
                sDKMessageCallback.crashDefendMessage(cVar.f5066a, cVar.crashCount - 1);
            }
        }
    }

    private void a(d dVar) {
        if (dVar != null && dVar.f5069b != null) {
            this.f48a.execute(new a(dVar));
        }
    }

    private void a(String str, String str2, int i10, int i11) {
        if (this.f5062a != null) {
            HashMap hashMap = new HashMap();
            hashMap.putAll(this.f5063d);
            hashMap.put("crashSdkId", str);
            hashMap.put("crashSdkVer", str2);
            hashMap.put("curCrashCount", String.valueOf(i10));
            hashMap.put("crashThreshold", String.valueOf(i11));
            this.f5062a.sendCustomHit("utils_biz_crash", 0, hashMap);
        }
    }
}
