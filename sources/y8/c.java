package y8;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import y8.k;

public final class c {

    /* renamed from: k  reason: collision with root package name */
    public static final c f19946k;

    /* renamed from: a  reason: collision with root package name */
    public final t f19947a;

    /* renamed from: b  reason: collision with root package name */
    public final Executor f19948b;

    /* renamed from: c  reason: collision with root package name */
    public final String f19949c;

    /* renamed from: d  reason: collision with root package name */
    public final b f19950d;

    /* renamed from: e  reason: collision with root package name */
    public final String f19951e;

    /* renamed from: f  reason: collision with root package name */
    public final Object[][] f19952f;

    /* renamed from: g  reason: collision with root package name */
    public final List f19953g;

    /* renamed from: h  reason: collision with root package name */
    public final Boolean f19954h;

    /* renamed from: i  reason: collision with root package name */
    public final Integer f19955i;

    /* renamed from: j  reason: collision with root package name */
    public final Integer f19956j;

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public t f19957a;

        /* renamed from: b  reason: collision with root package name */
        public Executor f19958b;

        /* renamed from: c  reason: collision with root package name */
        public String f19959c;

        /* renamed from: d  reason: collision with root package name */
        public b f19960d;

        /* renamed from: e  reason: collision with root package name */
        public String f19961e;

        /* renamed from: f  reason: collision with root package name */
        public Object[][] f19962f;

        /* renamed from: g  reason: collision with root package name */
        public List f19963g;

        /* renamed from: h  reason: collision with root package name */
        public Boolean f19964h;

        /* renamed from: i  reason: collision with root package name */
        public Integer f19965i;

        /* renamed from: j  reason: collision with root package name */
        public Integer f19966j;

        public final c b() {
            return new c(this);
        }
    }

    /* renamed from: y8.c$c  reason: collision with other inner class name */
    public static final class C0296c {

        /* renamed from: a  reason: collision with root package name */
        public final String f19967a;

        /* renamed from: b  reason: collision with root package name */
        public final Object f19968b;

        public C0296c(String str, Object obj) {
            this.f19967a = str;
            this.f19968b = obj;
        }

        public static C0296c b(String str) {
            Preconditions.checkNotNull(str, "debugString");
            return new C0296c(str, (Object) null);
        }

        public String toString() {
            return this.f19967a;
        }
    }

    static {
        b bVar = new b();
        bVar.f19962f = (Object[][]) Array.newInstance(Object.class, new int[]{0, 2});
        bVar.f19963g = Collections.emptyList();
        f19946k = bVar.b();
    }

    public static b k(c cVar) {
        b bVar = new b();
        bVar.f19957a = cVar.f19947a;
        bVar.f19958b = cVar.f19948b;
        bVar.f19959c = cVar.f19949c;
        bVar.f19960d = cVar.f19950d;
        bVar.f19961e = cVar.f19951e;
        bVar.f19962f = cVar.f19952f;
        bVar.f19963g = cVar.f19953g;
        bVar.f19964h = cVar.f19954h;
        bVar.f19965i = cVar.f19955i;
        bVar.f19966j = cVar.f19956j;
        return bVar;
    }

    public String a() {
        return this.f19949c;
    }

    public String b() {
        return this.f19951e;
    }

    public b c() {
        return this.f19950d;
    }

    public t d() {
        return this.f19947a;
    }

    public Executor e() {
        return this.f19948b;
    }

    public Integer f() {
        return this.f19955i;
    }

    public Integer g() {
        return this.f19956j;
    }

    public Object h(C0296c cVar) {
        Preconditions.checkNotNull(cVar, "key");
        int i10 = 0;
        while (true) {
            Object[][] objArr = this.f19952f;
            if (i10 >= objArr.length) {
                return cVar.f19968b;
            }
            if (cVar.equals(objArr[i10][0])) {
                return this.f19952f[i10][1];
            }
            i10++;
        }
    }

    public List i() {
        return this.f19953g;
    }

    public boolean j() {
        return Boolean.TRUE.equals(this.f19954h);
    }

    public c l(b bVar) {
        b k10 = k(this);
        k10.f19960d = bVar;
        return k10.b();
    }

    public c m(String str) {
        b k10 = k(this);
        k10.f19961e = str;
        return k10.b();
    }

    public c n(t tVar) {
        b k10 = k(this);
        k10.f19957a = tVar;
        return k10.b();
    }

    public c o(long j10, TimeUnit timeUnit) {
        return n(t.a(j10, timeUnit));
    }

    public c p(Executor executor) {
        b k10 = k(this);
        k10.f19958b = executor;
        return k10.b();
    }

    public c q(int i10) {
        boolean z10;
        if (i10 >= 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        Preconditions.checkArgument(z10, "invalid maxsize %s", i10);
        b k10 = k(this);
        k10.f19965i = Integer.valueOf(i10);
        return k10.b();
    }

    public c r(int i10) {
        boolean z10;
        if (i10 >= 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        Preconditions.checkArgument(z10, "invalid maxsize %s", i10);
        b k10 = k(this);
        k10.f19966j = Integer.valueOf(i10);
        return k10.b();
    }

    public c s(C0296c cVar, Object obj) {
        int i10;
        Preconditions.checkNotNull(cVar, "key");
        Preconditions.checkNotNull(obj, "value");
        b k10 = k(this);
        int i11 = 0;
        while (true) {
            Object[][] objArr = this.f19952f;
            if (i11 >= objArr.length) {
                i11 = -1;
                break;
            } else if (cVar.equals(objArr[i11][0])) {
                break;
            } else {
                i11++;
            }
        }
        int length = this.f19952f.length;
        if (i11 == -1) {
            i10 = 1;
        } else {
            i10 = 0;
        }
        Object[][] objArr2 = (Object[][]) Array.newInstance(Object.class, new int[]{length + i10, 2});
        k10.f19962f = objArr2;
        Object[][] objArr3 = this.f19952f;
        System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
        if (i11 == -1) {
            k10.f19962f[this.f19952f.length] = new Object[]{cVar, obj};
        } else {
            k10.f19962f[i11] = new Object[]{cVar, obj};
        }
        return k10.b();
    }

    public c t(k.a aVar) {
        ArrayList arrayList = new ArrayList(this.f19953g.size() + 1);
        arrayList.addAll(this.f19953g);
        arrayList.add(aVar);
        b k10 = k(this);
        k10.f19963g = Collections.unmodifiableList(arrayList);
        return k10.b();
    }

    public String toString() {
        Class<?> cls;
        MoreObjects.ToStringHelper add = MoreObjects.toStringHelper((Object) this).add("deadline", (Object) this.f19947a).add("authority", (Object) this.f19949c).add("callCredentials", (Object) this.f19950d);
        Executor executor = this.f19948b;
        if (executor != null) {
            cls = executor.getClass();
        } else {
            cls = null;
        }
        return add.add("executor", (Object) cls).add("compressorName", (Object) this.f19951e).add("customOptions", (Object) Arrays.deepToString(this.f19952f)).add("waitForReady", j()).add("maxInboundMessageSize", (Object) this.f19955i).add("maxOutboundMessageSize", (Object) this.f19956j).add("streamTracerFactories", (Object) this.f19953g).toString();
    }

    public c u() {
        b k10 = k(this);
        k10.f19964h = Boolean.TRUE;
        return k10.b();
    }

    public c v() {
        b k10 = k(this);
        k10.f19964h = Boolean.FALSE;
        return k10.b();
    }

    public c(b bVar) {
        this.f19947a = bVar.f19957a;
        this.f19948b = bVar.f19958b;
        this.f19949c = bVar.f19959c;
        this.f19950d = bVar.f19960d;
        this.f19951e = bVar.f19961e;
        this.f19952f = bVar.f19962f;
        this.f19953g = bVar.f19963g;
        this.f19954h = bVar.f19964h;
        this.f19955i = bVar.f19965i;
        this.f19956j = bVar.f19966j;
    }
}
