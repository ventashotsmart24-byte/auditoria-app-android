package kotlinx.coroutines.internal;

import ca.j0;
import ca.p1;
import h9.c;
import k9.f;

public final class t extends p1 implements j0 {

    /* renamed from: c  reason: collision with root package name */
    public final Throwable f18299c;

    /* renamed from: d  reason: collision with root package name */
    public final String f18300d;

    public t(Throwable th, String str) {
        this.f18299c = th;
        this.f18300d = str;
    }

    public boolean M(f fVar) {
        R();
        throw new c();
    }

    public p1 O() {
        return this;
    }

    /* renamed from: Q */
    public Void L(f fVar, Runnable runnable) {
        R();
        throw new c();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0023, code lost:
        if (r1 == null) goto L_0x0025;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Void R() {
        /*
            r4 = this;
            java.lang.Throwable r0 = r4.f18299c
            if (r0 == 0) goto L_0x0036
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Module with the Main dispatcher had failed to initialize"
            r0.append(r1)
            java.lang.String r1 = r4.f18300d
            if (r1 == 0) goto L_0x0025
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = ". "
            r2.append(r3)
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            if (r1 != 0) goto L_0x0027
        L_0x0025:
            java.lang.String r1 = ""
        L_0x0027:
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.Throwable r2 = r4.f18299c
            r1.<init>(r0, r2)
            throw r1
        L_0x0036:
            kotlinx.coroutines.internal.s.d()
            h9.c r0 = new h9.c
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.t.R():java.lang.Void");
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("Dispatchers.Main[missing");
        if (this.f18299c != null) {
            str = ", cause=" + this.f18299c;
        } else {
            str = "";
        }
        sb.append(str);
        sb.append(']');
        return sb.toString();
    }
}
