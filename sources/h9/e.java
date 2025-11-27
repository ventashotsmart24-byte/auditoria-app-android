package h9;

import anet.channel.strategy.dispatch.DispatchConstants;
import t9.g;
import t9.i;
import y9.c;

public final class e implements Comparable {

    /* renamed from: e  reason: collision with root package name */
    public static final a f17308e = new a((g) null);

    /* renamed from: f  reason: collision with root package name */
    public static final e f17309f = f.a();

    /* renamed from: a  reason: collision with root package name */
    public final int f17310a;

    /* renamed from: b  reason: collision with root package name */
    public final int f17311b;

    /* renamed from: c  reason: collision with root package name */
    public final int f17312c;

    /* renamed from: d  reason: collision with root package name */
    public final int f17313d;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }

    public e(int i10, int i11, int i12) {
        this.f17310a = i10;
        this.f17311b = i11;
        this.f17312c = i12;
        this.f17313d = b(i10, i11, i12);
    }

    /* renamed from: a */
    public int compareTo(e eVar) {
        i.g(eVar, DispatchConstants.OTHER);
        return this.f17313d - eVar.f17313d;
    }

    public final int b(int i10, int i11, int i12) {
        boolean z10 = false;
        if (new c(0, 255).f(i10) && new c(0, 255).f(i11) && new c(0, 255).f(i12)) {
            z10 = true;
        }
        if (z10) {
            return (i10 << 16) + (i11 << 8) + i12;
        }
        throw new IllegalArgumentException(("Version components are out of range: " + i10 + '.' + i11 + '.' + i12).toString());
    }

    public boolean equals(Object obj) {
        e eVar;
        if (this == obj) {
            return true;
        }
        if (obj instanceof e) {
            eVar = (e) obj;
        } else {
            eVar = null;
        }
        if (eVar != null && this.f17313d == eVar.f17313d) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.f17313d;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f17310a);
        sb.append('.');
        sb.append(this.f17311b);
        sb.append('.');
        sb.append(this.f17312c);
        return sb.toString();
    }
}
