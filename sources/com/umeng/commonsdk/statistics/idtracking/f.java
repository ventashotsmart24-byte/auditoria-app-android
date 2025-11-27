package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;
import android.text.TextUtils;
import com.hpplay.component.common.ParamsMap;
import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import com.umeng.analytics.pro.bd;
import com.umeng.analytics.pro.ch;
import com.umeng.analytics.pro.ck;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.statistics.AnalyticsConstants;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.statistics.common.HelperUtils;
import com.umeng.commonsdk.statistics.common.MLog;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import com.umeng.commonsdk.statistics.proto.b;
import com.umeng.commonsdk.statistics.proto.c;
import com.umeng.commonsdk.utils.d;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class f {

    /* renamed from: a  reason: collision with root package name */
    public static final long f14949a = 86400000;

    /* renamed from: b  reason: collision with root package name */
    public static f f14950b;

    /* renamed from: c  reason: collision with root package name */
    private static final String f14951c = bd.b().b("id");

    /* renamed from: j  reason: collision with root package name */
    private static Object f14952j = new Object();

    /* renamed from: d  reason: collision with root package name */
    private File f14953d;

    /* renamed from: e  reason: collision with root package name */
    private c f14954e = null;

    /* renamed from: f  reason: collision with root package name */
    private long f14955f;

    /* renamed from: g  reason: collision with root package name */
    private long f14956g;

    /* renamed from: h  reason: collision with root package name */
    private Set<a> f14957h = new HashSet();

    /* renamed from: i  reason: collision with root package name */
    private a f14958i = null;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private Context f14959a;

        /* renamed from: b  reason: collision with root package name */
        private Set<String> f14960b = new HashSet();

        public a(Context context) {
            this.f14959a = context;
        }

        public synchronized boolean a(String str) {
            return !this.f14960b.contains(str);
        }

        public synchronized void b(String str) {
            this.f14960b.add(str);
        }

        public void c(String str) {
            this.f14960b.remove(str);
        }

        public synchronized void a() {
            if (!this.f14960b.isEmpty()) {
                StringBuilder sb = new StringBuilder();
                for (String append : this.f14960b) {
                    sb.append(append);
                    sb.append(ASCIIPropertyListParser.ARRAY_ITEM_DELIMITER_TOKEN);
                }
                sb.deleteCharAt(sb.length() - 1);
                PreferenceWrapper.getDefault(this.f14959a).edit().putString("invld_id", sb.toString()).commit();
            }
        }

        public synchronized void b() {
            String[] split;
            String string = PreferenceWrapper.getDefault(this.f14959a).getString("invld_id", (String) null);
            if (!TextUtils.isEmpty(string) && (split = string.split(",")) != null) {
                for (String str : split) {
                    if (!TextUtils.isEmpty(str)) {
                        this.f14960b.add(str);
                    }
                }
            }
        }
    }

    public f(Context context) {
        this.f14953d = new File(context.getFilesDir(), f14951c);
        this.f14956g = 86400000;
        a aVar = new a(context);
        this.f14958i = aVar;
        aVar.b();
    }

    public static synchronized void a() {
        synchronized (f.class) {
            f fVar = f14950b;
            if (fVar != null) {
                fVar.e();
                f14950b = null;
            }
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
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    private synchronized void h() {
        /*
            r7 = this;
            monitor-enter(r7)
            com.umeng.commonsdk.statistics.proto.c r0 = new com.umeng.commonsdk.statistics.proto.c     // Catch:{ all -> 0x0061 }
            r0.<init>()     // Catch:{ all -> 0x0061 }
            java.util.HashMap r1 = new java.util.HashMap     // Catch:{ all -> 0x0061 }
            r1.<init>()     // Catch:{ all -> 0x0061 }
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ all -> 0x0061 }
            r2.<init>()     // Catch:{ all -> 0x0061 }
            java.util.Set<com.umeng.commonsdk.statistics.idtracking.a> r3 = r7.f14957h     // Catch:{ all -> 0x0061 }
            java.util.Iterator r3 = r3.iterator()     // Catch:{ all -> 0x0061 }
        L_0x0016:
            boolean r4 = r3.hasNext()     // Catch:{ all -> 0x0061 }
            if (r4 == 0) goto L_0x0052
            java.lang.Object r4 = r3.next()     // Catch:{ all -> 0x0061 }
            com.umeng.commonsdk.statistics.idtracking.a r4 = (com.umeng.commonsdk.statistics.idtracking.a) r4     // Catch:{ all -> 0x0061 }
            boolean r5 = r4.c()     // Catch:{ all -> 0x0061 }
            if (r5 != 0) goto L_0x0029
            goto L_0x0016
        L_0x0029:
            com.umeng.commonsdk.statistics.proto.b r5 = r4.d()     // Catch:{ all -> 0x0061 }
            if (r5 == 0) goto L_0x003a
            java.lang.String r5 = r4.b()     // Catch:{ all -> 0x0061 }
            com.umeng.commonsdk.statistics.proto.b r6 = r4.d()     // Catch:{ all -> 0x0061 }
            r1.put(r5, r6)     // Catch:{ all -> 0x0061 }
        L_0x003a:
            java.util.List r5 = r4.e()     // Catch:{ all -> 0x0061 }
            if (r5 == 0) goto L_0x0016
            java.util.List r5 = r4.e()     // Catch:{ all -> 0x0061 }
            boolean r5 = r5.isEmpty()     // Catch:{ all -> 0x0061 }
            if (r5 != 0) goto L_0x0016
            java.util.List r4 = r4.e()     // Catch:{ all -> 0x0061 }
            r2.addAll(r4)     // Catch:{ all -> 0x0061 }
            goto L_0x0016
        L_0x0052:
            r0.a((java.util.List<com.umeng.commonsdk.statistics.proto.a>) r2)     // Catch:{ all -> 0x0061 }
            r0.a((java.util.Map<java.lang.String, com.umeng.commonsdk.statistics.proto.b>) r1)     // Catch:{ all -> 0x0061 }
            monitor-enter(r7)     // Catch:{ all -> 0x0061 }
            r7.f14954e = r0     // Catch:{ all -> 0x005e }
            monitor-exit(r7)     // Catch:{ all -> 0x005e }
            monitor-exit(r7)
            return
        L_0x005e:
            r0 = move-exception
            monitor-exit(r7)     // Catch:{ all -> 0x005e }
            throw r0     // Catch:{ all -> 0x0061 }
        L_0x0061:
            r0 = move-exception
            monitor-exit(r7)
            goto L_0x0065
        L_0x0064:
            throw r0
        L_0x0065:
            goto L_0x0064
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.statistics.idtracking.f.h():void");
    }

    private c i() {
        FileInputStream fileInputStream;
        synchronized (f14952j) {
            if (!this.f14953d.exists()) {
                return null;
            }
            try {
                fileInputStream = new FileInputStream(this.f14953d);
                try {
                    byte[] readStreamToByteArray = HelperUtils.readStreamToByteArray(fileInputStream);
                    c cVar = new c();
                    new ck().a((ch) cVar, readStreamToByteArray);
                    HelperUtils.safeClose((InputStream) fileInputStream);
                    return cVar;
                } catch (Exception e10) {
                    e = e10;
                    try {
                        e.printStackTrace();
                        HelperUtils.safeClose((InputStream) fileInputStream);
                        return null;
                    } catch (Throwable th) {
                        th = th;
                        HelperUtils.safeClose((InputStream) fileInputStream);
                        throw th;
                    }
                }
            } catch (Exception e11) {
                e = e11;
                fileInputStream = null;
                e.printStackTrace();
                HelperUtils.safeClose((InputStream) fileInputStream);
                return null;
            } catch (Throwable th2) {
                th = th2;
                fileInputStream = null;
                HelperUtils.safeClose((InputStream) fileInputStream);
                throw th;
            }
        }
    }

    public synchronized void b() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f14955f >= this.f14956g) {
            boolean z10 = false;
            for (a next : this.f14957h) {
                if (next.c()) {
                    if (next.a()) {
                        if (!next.c()) {
                            this.f14958i.b(next.b());
                        }
                        z10 = true;
                    }
                }
            }
            if (z10) {
                h();
                this.f14958i.a();
                g();
            }
            this.f14955f = currentTimeMillis;
        }
    }

    public synchronized c c() {
        return this.f14954e;
    }

    public String d() {
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0043, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void e() {
        /*
            r5 = this;
            monitor-enter(r5)
            com.umeng.commonsdk.statistics.idtracking.f r0 = f14950b     // Catch:{ all -> 0x0044 }
            if (r0 != 0) goto L_0x0007
            monitor-exit(r5)
            return
        L_0x0007:
            java.util.Set<com.umeng.commonsdk.statistics.idtracking.a> r0 = r5.f14957h     // Catch:{ all -> 0x0044 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x0044 }
            r1 = 0
            r2 = 0
        L_0x000f:
            boolean r3 = r0.hasNext()     // Catch:{ all -> 0x0044 }
            if (r3 == 0) goto L_0x0038
            java.lang.Object r3 = r0.next()     // Catch:{ all -> 0x0044 }
            com.umeng.commonsdk.statistics.idtracking.a r3 = (com.umeng.commonsdk.statistics.idtracking.a) r3     // Catch:{ all -> 0x0044 }
            boolean r4 = r3.c()     // Catch:{ all -> 0x0044 }
            if (r4 != 0) goto L_0x0022
            goto L_0x000f
        L_0x0022:
            java.util.List r4 = r3.e()     // Catch:{ all -> 0x0044 }
            if (r4 == 0) goto L_0x000f
            java.util.List r4 = r3.e()     // Catch:{ all -> 0x0044 }
            boolean r4 = r4.isEmpty()     // Catch:{ all -> 0x0044 }
            if (r4 != 0) goto L_0x000f
            r2 = 0
            r3.a((java.util.List<com.umeng.commonsdk.statistics.proto.a>) r2)     // Catch:{ all -> 0x0044 }
            r2 = 1
            goto L_0x000f
        L_0x0038:
            if (r2 == 0) goto L_0x0042
            com.umeng.commonsdk.statistics.proto.c r0 = r5.f14954e     // Catch:{ all -> 0x0044 }
            r0.b(r1)     // Catch:{ all -> 0x0044 }
            r5.g()     // Catch:{ all -> 0x0044 }
        L_0x0042:
            monitor-exit(r5)
            return
        L_0x0044:
            r0 = move-exception
            monitor-exit(r5)
            goto L_0x0048
        L_0x0047:
            throw r0
        L_0x0048:
            goto L_0x0047
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.statistics.idtracking.f.e():void");
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
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    public synchronized void f() {
        /*
            r4 = this;
            monitor-enter(r4)
            com.umeng.commonsdk.statistics.proto.c r0 = r4.i()     // Catch:{ all -> 0x005a }
            if (r0 != 0) goto L_0x0009
            monitor-exit(r4)
            return
        L_0x0009:
            r4.a((com.umeng.commonsdk.statistics.proto.c) r0)     // Catch:{ all -> 0x005a }
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ all -> 0x005a }
            java.util.Set<com.umeng.commonsdk.statistics.idtracking.a> r2 = r4.f14957h     // Catch:{ all -> 0x005a }
            int r2 = r2.size()     // Catch:{ all -> 0x005a }
            r1.<init>(r2)     // Catch:{ all -> 0x005a }
            monitor-enter(r4)     // Catch:{ all -> 0x005a }
            r4.f14954e = r0     // Catch:{ all -> 0x0057 }
            java.util.Set<com.umeng.commonsdk.statistics.idtracking.a> r0 = r4.f14957h     // Catch:{ all -> 0x0057 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x0057 }
        L_0x0020:
            boolean r2 = r0.hasNext()     // Catch:{ all -> 0x0057 }
            if (r2 == 0) goto L_0x003b
            java.lang.Object r2 = r0.next()     // Catch:{ all -> 0x0057 }
            com.umeng.commonsdk.statistics.idtracking.a r2 = (com.umeng.commonsdk.statistics.idtracking.a) r2     // Catch:{ all -> 0x0057 }
            com.umeng.commonsdk.statistics.proto.c r3 = r4.f14954e     // Catch:{ all -> 0x0057 }
            r2.a((com.umeng.commonsdk.statistics.proto.c) r3)     // Catch:{ all -> 0x0057 }
            boolean r3 = r2.c()     // Catch:{ all -> 0x0057 }
            if (r3 != 0) goto L_0x0020
            r1.add(r2)     // Catch:{ all -> 0x0057 }
            goto L_0x0020
        L_0x003b:
            java.util.Iterator r0 = r1.iterator()     // Catch:{ all -> 0x0057 }
        L_0x003f:
            boolean r1 = r0.hasNext()     // Catch:{ all -> 0x0057 }
            if (r1 == 0) goto L_0x0051
            java.lang.Object r1 = r0.next()     // Catch:{ all -> 0x0057 }
            com.umeng.commonsdk.statistics.idtracking.a r1 = (com.umeng.commonsdk.statistics.idtracking.a) r1     // Catch:{ all -> 0x0057 }
            java.util.Set<com.umeng.commonsdk.statistics.idtracking.a> r2 = r4.f14957h     // Catch:{ all -> 0x0057 }
            r2.remove(r1)     // Catch:{ all -> 0x0057 }
            goto L_0x003f
        L_0x0051:
            monitor-exit(r4)     // Catch:{ all -> 0x0057 }
            r4.h()     // Catch:{ all -> 0x005a }
            monitor-exit(r4)
            return
        L_0x0057:
            r0 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x0057 }
            throw r0     // Catch:{ all -> 0x005a }
        L_0x005a:
            r0 = move-exception
            monitor-exit(r4)
            goto L_0x005e
        L_0x005d:
            throw r0
        L_0x005e:
            goto L_0x005d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.statistics.idtracking.f.f():void");
    }

    public synchronized void g() {
        c cVar = this.f14954e;
        if (cVar != null) {
            b(cVar);
        }
    }

    public static synchronized f a(Context context) {
        f fVar;
        synchronized (f.class) {
            if (f14950b == null) {
                f fVar2 = new f(context);
                f14950b = fVar2;
                fVar2.a((a) new g(context));
                f14950b.a((a) new b(context));
                f14950b.a((a) new k(context));
                f14950b.a((a) new e(context));
                f14950b.a((a) new d(context));
                f14950b.a((a) new h(context));
                f14950b.a((a) new j());
                if (FieldManager.allow(d.G)) {
                    f14950b.a((a) new i(context));
                    if (DeviceConfig.isHonorDevice()) {
                        f14950b.a((a) new c(context));
                    }
                }
                f14950b.f();
            }
            fVar = f14950b;
        }
        return fVar;
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
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    private void b(com.umeng.commonsdk.statistics.proto.c r3) {
        /*
            r2 = this;
            java.lang.Object r0 = f14952j
            monitor-enter(r0)
            if (r3 == 0) goto L_0x0022
            monitor-enter(r2)     // Catch:{ Exception -> 0x001e }
            r2.a((com.umeng.commonsdk.statistics.proto.c) r3)     // Catch:{ all -> 0x001b }
            com.umeng.analytics.pro.cq r1 = new com.umeng.analytics.pro.cq     // Catch:{ all -> 0x001b }
            r1.<init>()     // Catch:{ all -> 0x001b }
            byte[] r3 = r1.a(r3)     // Catch:{ all -> 0x001b }
            monitor-exit(r2)     // Catch:{ all -> 0x001b }
            if (r3 == 0) goto L_0x0022
            java.io.File r1 = r2.f14953d     // Catch:{ Exception -> 0x001e }
            com.umeng.commonsdk.statistics.common.HelperUtils.writeFile((java.io.File) r1, (byte[]) r3)     // Catch:{ Exception -> 0x001e }
            goto L_0x0022
        L_0x001b:
            r3 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x001b }
            throw r3     // Catch:{ Exception -> 0x001e }
        L_0x001e:
            r3 = move-exception
            r3.printStackTrace()     // Catch:{ all -> 0x0024 }
        L_0x0022:
            monitor-exit(r0)     // Catch:{ all -> 0x0024 }
            return
        L_0x0024:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0024 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.statistics.idtracking.f.b(com.umeng.commonsdk.statistics.proto.c):void");
    }

    private boolean a(a aVar) {
        if (this.f14958i.a(aVar.b())) {
            return this.f14957h.add(aVar);
        }
        if (!AnalyticsConstants.UM_DEBUG) {
            return false;
        }
        MLog.w("invalid domain: " + aVar.b());
        return false;
    }

    public void a(long j10) {
        this.f14956g = j10;
    }

    private void a(c cVar) {
        Map<String, b> map;
        if (cVar != null && (map = cVar.f15045a) != null) {
            if (map.containsKey(ParamsMap.DeviceParams.KEY_MAC) && !FieldManager.allow(d.f15127h)) {
                cVar.f15045a.remove(ParamsMap.DeviceParams.KEY_MAC);
            }
            if (cVar.f15045a.containsKey("imei") && !FieldManager.allow(d.f15126g)) {
                cVar.f15045a.remove("imei");
            }
            if (cVar.f15045a.containsKey("android_id") && !FieldManager.allow(d.f15128i)) {
                cVar.f15045a.remove("android_id");
            }
            if (cVar.f15045a.containsKey("serial") && !FieldManager.allow(d.f15129j)) {
                cVar.f15045a.remove("serial");
            }
            if (cVar.f15045a.containsKey("idfa") && !FieldManager.allow(d.f15142w)) {
                cVar.f15045a.remove("idfa");
            }
            if (cVar.f15045a.containsKey("oaid") && !FieldManager.allow(d.G)) {
                cVar.f15045a.remove("oaid");
            }
        }
    }
}
