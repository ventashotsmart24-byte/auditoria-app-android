package y8;

import com.google.common.base.Objects;
import java.util.IdentityHashMap;
import java.util.Map;

public final class a {

    /* renamed from: b  reason: collision with root package name */
    public static final IdentityHashMap f19922b;

    /* renamed from: c  reason: collision with root package name */
    public static final a f19923c;

    /* renamed from: a  reason: collision with root package name */
    public final IdentityHashMap f19924a;

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public a f19925a;

        /* renamed from: b  reason: collision with root package name */
        public IdentityHashMap f19926b;

        public a a() {
            if (this.f19926b != null) {
                for (Map.Entry entry : this.f19925a.f19924a.entrySet()) {
                    if (!this.f19926b.containsKey(entry.getKey())) {
                        this.f19926b.put((c) entry.getKey(), entry.getValue());
                    }
                }
                this.f19925a = new a(this.f19926b);
                this.f19926b = null;
            }
            return this.f19925a;
        }

        public final IdentityHashMap b(int i10) {
            if (this.f19926b == null) {
                this.f19926b = new IdentityHashMap(i10);
            }
            return this.f19926b;
        }

        public b c(c cVar) {
            if (this.f19925a.f19924a.containsKey(cVar)) {
                IdentityHashMap identityHashMap = new IdentityHashMap(this.f19925a.f19924a);
                identityHashMap.remove(cVar);
                this.f19925a = new a(identityHashMap);
            }
            IdentityHashMap identityHashMap2 = this.f19926b;
            if (identityHashMap2 != null) {
                identityHashMap2.remove(cVar);
            }
            return this;
        }

        public b d(c cVar, Object obj) {
            b(1).put(cVar, obj);
            return this;
        }

        public b(a aVar) {
            this.f19925a = aVar;
        }
    }

    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        public final String f19927a;

        public c(String str) {
            this.f19927a = str;
        }

        public static c a(String str) {
            return new c(str);
        }

        public String toString() {
            return this.f19927a;
        }
    }

    static {
        IdentityHashMap identityHashMap = new IdentityHashMap();
        f19922b = identityHashMap;
        f19923c = new a(identityHashMap);
    }

    public static b c() {
        return new b();
    }

    public Object b(c cVar) {
        return this.f19924a.get(cVar);
    }

    public b d() {
        return new b();
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0031  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r7) {
        /*
            r6 = this;
            r0 = 1
            if (r6 != r7) goto L_0x0004
            return r0
        L_0x0004:
            r1 = 0
            if (r7 == 0) goto L_0x005a
            java.lang.Class<y8.a> r2 = y8.a.class
            java.lang.Class r3 = r7.getClass()
            if (r2 == r3) goto L_0x0010
            goto L_0x005a
        L_0x0010:
            y8.a r7 = (y8.a) r7
            java.util.IdentityHashMap r2 = r6.f19924a
            int r2 = r2.size()
            java.util.IdentityHashMap r3 = r7.f19924a
            int r3 = r3.size()
            if (r2 == r3) goto L_0x0021
            return r1
        L_0x0021:
            java.util.IdentityHashMap r2 = r6.f19924a
            java.util.Set r2 = r2.entrySet()
            java.util.Iterator r2 = r2.iterator()
        L_0x002b:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0059
            java.lang.Object r3 = r2.next()
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3
            java.util.IdentityHashMap r4 = r7.f19924a
            java.lang.Object r5 = r3.getKey()
            boolean r4 = r4.containsKey(r5)
            if (r4 != 0) goto L_0x0044
            return r1
        L_0x0044:
            java.lang.Object r4 = r3.getValue()
            java.util.IdentityHashMap r5 = r7.f19924a
            java.lang.Object r3 = r3.getKey()
            java.lang.Object r3 = r5.get(r3)
            boolean r3 = com.google.common.base.Objects.equal(r4, r3)
            if (r3 != 0) goto L_0x002b
            return r1
        L_0x0059:
            return r0
        L_0x005a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: y8.a.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        int i10 = 0;
        for (Map.Entry entry : this.f19924a.entrySet()) {
            i10 += Objects.hashCode(entry.getKey(), entry.getValue());
        }
        return i10;
    }

    public String toString() {
        return this.f19924a.toString();
    }

    public a(IdentityHashMap identityHashMap) {
        this.f19924a = identityHashMap;
    }
}
