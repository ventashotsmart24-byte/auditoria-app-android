package o7;

import com.raizlabs.android.dbflow.sql.language.Operator;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import s7.c;

public final class a {

    /* renamed from: j  reason: collision with root package name */
    public static final String f19090j = "a";

    /* renamed from: a  reason: collision with root package name */
    public final d[] f19091a;

    /* renamed from: b  reason: collision with root package name */
    public final c f19092b;

    /* renamed from: c  reason: collision with root package name */
    public final c f19093c;

    /* renamed from: d  reason: collision with root package name */
    public final r7.a f19094d;

    /* renamed from: e  reason: collision with root package name */
    public final e f19095e;

    /* renamed from: f  reason: collision with root package name */
    public volatile com.qiniu.android.dns.a f19096f;

    /* renamed from: g  reason: collision with root package name */
    public volatile int f19097g;

    /* renamed from: h  reason: collision with root package name */
    public volatile boolean f19098h;

    /* renamed from: i  reason: collision with root package name */
    public ConcurrentHashMap f19099i;

    public static class b implements e {
        public b() {
        }

        public String[] a(String[] strArr) {
            return strArr;
        }
    }

    public a(com.qiniu.android.dns.a aVar, d[] dVarArr, c cVar) {
        this(aVar, dVarArr, cVar, (e) null);
    }

    public static String[] i(f[] fVarArr) {
        if (fVarArr == null || fVarArr.length == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList(fVarArr.length);
        for (f fVar : fVarArr) {
            arrayList.add(fVar.f19104a);
        }
        if (arrayList.size() == 0) {
            return null;
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public static void j(f[] fVarArr) {
        if (fVarArr != null && fVarArr.length > 1) {
            f fVar = fVarArr[0];
            System.arraycopy(fVarArr, 1, fVarArr, 0, fVarArr.length - 1);
            fVarArr[fVarArr.length - 1] = fVar;
        }
    }

    public static f[] k(f[] fVarArr) {
        ArrayList arrayList = new ArrayList(fVarArr.length);
        for (f fVar : fVarArr) {
            if (fVar != null && fVar.f19105b == 1) {
                arrayList.add(fVar);
            }
        }
        return (f[]) arrayList.toArray(new f[arrayList.size()]);
    }

    public static boolean l(String str) {
        if (str == null || str.length() < 7 || str.length() > 15 || str.contains(Operator.Operation.MINUS)) {
            return false;
        }
        try {
            int indexOf = str.indexOf(46);
            if (indexOf != -1 && Integer.parseInt(str.substring(0, indexOf)) > 255) {
                return false;
            }
            int i10 = indexOf + 1;
            int indexOf2 = str.indexOf(46, i10);
            if (indexOf2 != -1 && Integer.parseInt(str.substring(i10, indexOf2)) > 255) {
                return false;
            }
            int i11 = indexOf2 + 1;
            int indexOf3 = str.indexOf(46, i11);
            if (indexOf3 == -1 || Integer.parseInt(str.substring(i11, indexOf3)) <= 255 || Integer.parseInt(str.substring(indexOf3 + 1, str.length() - 1)) <= 255 || str.charAt(str.length() - 1) == '.') {
                return true;
            }
            return false;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    public final void a() {
        synchronized (this.f19093c) {
            this.f19093c.clear();
        }
    }

    public final synchronized Object b(String str) {
        Object obj = this.f19099i.get(str);
        if (obj != null) {
            return obj;
        }
        Object obj2 = new Object();
        this.f19099i.put(str, obj2);
        return obj2;
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
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
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
    public final void c() {
        /*
            r5 = this;
            o7.d[] r0 = r5.f19091a
            monitor-enter(r0)
            boolean r1 = r5.f19098h     // Catch:{ all -> 0x002e }
            if (r1 != 0) goto L_0x002c
            r1 = 1
            o7.c r2 = r5.f19092b     // Catch:{ IOException -> 0x0026 }
            s7.c r2 = r2.load()     // Catch:{ IOException -> 0x0026 }
            if (r2 == 0) goto L_0x002a
            int r3 = r2.size()     // Catch:{ IOException -> 0x0026 }
            if (r3 == 0) goto L_0x002a
            s7.c r3 = r5.f19093c     // Catch:{ IOException -> 0x0026 }
            monitor-enter(r3)     // Catch:{ IOException -> 0x0026 }
            s7.c r4 = r5.f19093c     // Catch:{ all -> 0x0023 }
            r4.putAll(r2)     // Catch:{ all -> 0x0023 }
            monitor-exit(r3)     // Catch:{ all -> 0x0023 }
            r5.f19098h = r1     // Catch:{ IOException -> 0x0026 }
            monitor-exit(r0)     // Catch:{ all -> 0x002e }
            return
        L_0x0023:
            r2 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0023 }
            throw r2     // Catch:{ IOException -> 0x0026 }
        L_0x0026:
            r2 = move-exception
            r2.printStackTrace()     // Catch:{ all -> 0x002e }
        L_0x002a:
            r5.f19098h = r1     // Catch:{ all -> 0x002e }
        L_0x002c:
            monitor-exit(r0)     // Catch:{ all -> 0x002e }
            return
        L_0x002e:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x002e }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: o7.a.c():void");
    }

    public void d(com.qiniu.android.dns.a aVar) {
        a();
        if (aVar == null) {
            aVar = com.qiniu.android.dns.a.f12874d;
        }
        this.f19096f = aVar;
        synchronized (this.f19091a) {
            this.f19097g = 0;
        }
    }

    public String[] e(String str) {
        return f(new b(str));
    }

    public String[] f(b bVar) {
        if (bVar != null) {
            String str = bVar.f19100a;
            if (str == null || str.trim().length() == 0) {
                throw new IOException("empty domain " + bVar.f19100a);
            } else if (l(bVar.f19100a)) {
                return new String[]{bVar.f19100a};
            } else {
                String[] g10 = g(bVar);
                if (g10 == null || g10.length <= 1) {
                    return g10;
                }
                return this.f19095e.a(g10);
            }
        } else {
            throw new IOException("null domain");
        }
    }

    public final String[] g(b bVar) {
        f[] h10 = h(bVar);
        if (h10 == null || h10.length == 0) {
            return null;
        }
        return i(h10);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
        r1 = r10.f19097g;
        r6 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0044, code lost:
        r7 = r10.f19091a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0047, code lost:
        if (r6 >= r7.length) goto L_0x0086;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
        r2 = r7[(r1 + r6) % r7.length].a(r11, r10.f19096f);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0056, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:?, code lost:
        r7 = new java.io.IOException(r5);
        r5.printStackTrace();
        r5 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0061, code lost:
        r5 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0062, code lost:
        r5.printStackTrace();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final o7.f[] h(o7.b r11) {
        /*
            r10 = this;
            r10.c()
            java.lang.String r0 = r11.f19100a
            java.lang.Object r0 = r10.b(r0)
            monitor-enter(r0)
            s7.c r1 = r10.f19093c     // Catch:{ all -> 0x00c0 }
            monitor-enter(r1)     // Catch:{ all -> 0x00c0 }
            s7.c r2 = r10.f19093c     // Catch:{ all -> 0x00bd }
            int r2 = r2.size()     // Catch:{ all -> 0x00bd }
            r3 = 1
            r4 = 0
            r5 = 0
            if (r2 == 0) goto L_0x003f
            s7.c r2 = r10.f19093c     // Catch:{ all -> 0x00bd }
            java.lang.String r6 = r11.f19100a     // Catch:{ all -> 0x00bd }
            java.lang.Object r2 = r2.get(r6)     // Catch:{ all -> 0x00bd }
            o7.f[] r2 = (o7.f[]) r2     // Catch:{ all -> 0x00bd }
            if (r2 == 0) goto L_0x0040
            int r6 = r2.length     // Catch:{ all -> 0x00bd }
            if (r6 == 0) goto L_0x0040
            r6 = r2[r4]     // Catch:{ all -> 0x00bd }
            boolean r6 = r6.a()     // Catch:{ all -> 0x00bd }
            if (r6 != 0) goto L_0x003f
            int r11 = r2.length     // Catch:{ all -> 0x00bd }
            if (r11 <= r3) goto L_0x0035
            j(r2)     // Catch:{ all -> 0x00bd }
        L_0x0035:
            java.lang.String r11 = f19090j     // Catch:{ all -> 0x00bd }
            java.lang.String r3 = "hit httpdns cache"
            s7.b.b(r11, r3)     // Catch:{ all -> 0x00bd }
            monitor-exit(r1)     // Catch:{ all -> 0x00bd }
            monitor-exit(r0)     // Catch:{ all -> 0x00c0 }
            return r2
        L_0x003f:
            r2 = r5
        L_0x0040:
            monitor-exit(r1)     // Catch:{ all -> 0x00bd }
            int r1 = r10.f19097g     // Catch:{ all -> 0x00c0 }
            r6 = 0
        L_0x0044:
            o7.d[] r7 = r10.f19091a     // Catch:{ all -> 0x00c0 }
            int r8 = r7.length     // Catch:{ all -> 0x00c0 }
            if (r6 >= r8) goto L_0x0086
            int r8 = r1 + r6
            int r9 = r7.length     // Catch:{ all -> 0x00c0 }
            int r8 = r8 % r9
            r7 = r7[r8]     // Catch:{ IOException -> 0x0061, Exception -> 0x0056 }
            com.qiniu.android.dns.a r8 = r10.f19096f     // Catch:{ IOException -> 0x0061, Exception -> 0x0056 }
            o7.f[] r2 = r7.a(r11, r8)     // Catch:{ IOException -> 0x0061, Exception -> 0x0056 }
            goto L_0x0065
        L_0x0056:
            r5 = move-exception
            java.io.IOException r7 = new java.io.IOException     // Catch:{ all -> 0x00c0 }
            r7.<init>(r5)     // Catch:{ all -> 0x00c0 }
            r5.printStackTrace()     // Catch:{ all -> 0x00c0 }
            r5 = r7
            goto L_0x0065
        L_0x0061:
            r5 = move-exception
            r5.printStackTrace()     // Catch:{ all -> 0x00c0 }
        L_0x0065:
            if (r2 == 0) goto L_0x006a
            int r7 = r2.length     // Catch:{ all -> 0x00c0 }
            if (r7 != 0) goto L_0x0086
        L_0x006a:
            o7.d[] r7 = r10.f19091a     // Catch:{ all -> 0x00c0 }
            monitor-enter(r7)     // Catch:{ all -> 0x00c0 }
            int r8 = r10.f19097g     // Catch:{ all -> 0x0083 }
            if (r8 != r1) goto L_0x007f
            int r8 = r10.f19097g     // Catch:{ all -> 0x0083 }
            int r8 = r8 + r3
            r10.f19097g = r8     // Catch:{ all -> 0x0083 }
            int r8 = r10.f19097g     // Catch:{ all -> 0x0083 }
            o7.d[] r9 = r10.f19091a     // Catch:{ all -> 0x0083 }
            int r9 = r9.length     // Catch:{ all -> 0x0083 }
            if (r8 != r9) goto L_0x007f
            r10.f19097g = r4     // Catch:{ all -> 0x0083 }
        L_0x007f:
            monitor-exit(r7)     // Catch:{ all -> 0x0083 }
            int r6 = r6 + 1
            goto L_0x0044
        L_0x0083:
            r11 = move-exception
            monitor-exit(r7)     // Catch:{ all -> 0x0083 }
            throw r11     // Catch:{ all -> 0x00c0 }
        L_0x0086:
            if (r2 == 0) goto L_0x00b2
            int r1 = r2.length     // Catch:{ all -> 0x00c0 }
            if (r1 != 0) goto L_0x008c
            goto L_0x00b2
        L_0x008c:
            o7.f[] r1 = k(r2)     // Catch:{ all -> 0x00c0 }
            int r2 = r1.length     // Catch:{ all -> 0x00c0 }
            if (r2 == 0) goto L_0x00aa
            s7.c r2 = r10.f19093c     // Catch:{ all -> 0x00c0 }
            monitor-enter(r2)     // Catch:{ all -> 0x00c0 }
            s7.c r3 = r10.f19093c     // Catch:{ all -> 0x00a7 }
            java.lang.String r11 = r11.f19100a     // Catch:{ all -> 0x00a7 }
            r3.put(r11, r1)     // Catch:{ all -> 0x00a7 }
            o7.c r11 = r10.f19092b     // Catch:{ all -> 0x00a7 }
            s7.c r3 = r10.f19093c     // Catch:{ all -> 0x00a7 }
            r11.a(r3)     // Catch:{ all -> 0x00a7 }
            monitor-exit(r2)     // Catch:{ all -> 0x00a7 }
            monitor-exit(r0)     // Catch:{ all -> 0x00c0 }
            return r1
        L_0x00a7:
            r11 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x00a7 }
            throw r11     // Catch:{ all -> 0x00c0 }
        L_0x00aa:
            java.net.UnknownHostException r11 = new java.net.UnknownHostException     // Catch:{ all -> 0x00c0 }
            java.lang.String r1 = "no A records"
            r11.<init>(r1)     // Catch:{ all -> 0x00c0 }
            throw r11     // Catch:{ all -> 0x00c0 }
        L_0x00b2:
            if (r5 != 0) goto L_0x00bc
            java.net.UnknownHostException r1 = new java.net.UnknownHostException     // Catch:{ all -> 0x00c0 }
            java.lang.String r11 = r11.f19100a     // Catch:{ all -> 0x00c0 }
            r1.<init>(r11)     // Catch:{ all -> 0x00c0 }
            throw r1     // Catch:{ all -> 0x00c0 }
        L_0x00bc:
            throw r5     // Catch:{ all -> 0x00c0 }
        L_0x00bd:
            r11 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x00bd }
            throw r11     // Catch:{ all -> 0x00c0 }
        L_0x00c0:
            r11 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00c0 }
            goto L_0x00c4
        L_0x00c3:
            throw r11
        L_0x00c4:
            goto L_0x00c3
        */
        throw new UnsupportedOperationException("Method not decompiled: o7.a.h(o7.b):o7.f[]");
    }

    public a(com.qiniu.android.dns.a aVar, d[] dVarArr, c cVar, e eVar) {
        this.f19094d = new r7.a();
        this.f19096f = null;
        this.f19097g = 0;
        this.f19098h = false;
        this.f19099i = new ConcurrentHashMap(24);
        this.f19096f = aVar == null ? com.qiniu.android.dns.a.f12874d : aVar;
        this.f19091a = (d[]) dVarArr.clone();
        this.f19092b = cVar;
        this.f19093c = new c();
        this.f19095e = eVar == null ? new b() : eVar;
    }
}
