package k1;

import a1.k;
import a1.n;
import android.text.TextUtils;
import androidx.work.b;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.background.systemalarm.RescheduleReceiver;
import androidx.work.impl.workers.ConstraintTrackingWorker;
import b1.c;
import b1.e;
import b1.f;
import b1.g;
import b1.j;
import j1.p;
import java.util.List;

public class b implements Runnable {

    /* renamed from: c  reason: collision with root package name */
    public static final String f7236c = k.f("EnqueueRunnable");

    /* renamed from: a  reason: collision with root package name */
    public final g f7237a;

    /* renamed from: b  reason: collision with root package name */
    public final c f7238b = new c();

    public b(g gVar) {
        this.f7237a = gVar;
    }

    public static boolean b(g gVar) {
        boolean c10 = c(gVar.g(), gVar.f(), (String[]) g.l(gVar).toArray(new String[0]), gVar.d(), gVar.b());
        gVar.k();
        return c10;
    }

    /* JADX WARNING: Removed duplicated region for block: B:105:0x0195  */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x0199  */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x01ae  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x01b8  */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x01e1 A[LOOP:7: B:120:0x01db->B:122:0x01e1, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x01fa  */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x020a A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0093  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0159  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean c(b1.j r19, java.util.List r20, java.lang.String[] r21, java.lang.String r22, a1.d r23) {
        /*
            r0 = r19
            r1 = r21
            r2 = r22
            r3 = r23
            long r4 = java.lang.System.currentTimeMillis()
            androidx.work.impl.WorkDatabase r6 = r19.n()
            r7 = 1
            if (r1 == 0) goto L_0x0018
            int r9 = r1.length
            if (r9 <= 0) goto L_0x0018
            r9 = 1
            goto L_0x0019
        L_0x0018:
            r9 = 0
        L_0x0019:
            if (r9 == 0) goto L_0x005d
            int r10 = r1.length
            r11 = 0
            r12 = 1
            r13 = 0
            r14 = 0
        L_0x0020:
            if (r11 >= r10) goto L_0x0060
            r15 = r1[r11]
            j1.q r8 = r6.B()
            j1.p r8 = r8.h(r15)
            if (r8 != 0) goto L_0x0045
            a1.k r0 = a1.k.c()
            java.lang.String r1 = f7236c
            java.lang.Object[] r2 = new java.lang.Object[r7]
            r3 = 0
            r2[r3] = r15
            java.lang.String r4 = "Prerequisite %s doesn't exist; not enqueuing"
            java.lang.String r2 = java.lang.String.format(r4, r2)
            java.lang.Throwable[] r4 = new java.lang.Throwable[r3]
            r0.b(r1, r2, r4)
            return r3
        L_0x0045:
            a1.s r8 = r8.f7090b
            a1.s r15 = a1.s.SUCCEEDED
            if (r8 != r15) goto L_0x004d
            r15 = 1
            goto L_0x004e
        L_0x004d:
            r15 = 0
        L_0x004e:
            r12 = r12 & r15
            a1.s r15 = a1.s.FAILED
            if (r8 != r15) goto L_0x0055
            r14 = 1
            goto L_0x005a
        L_0x0055:
            a1.s r15 = a1.s.CANCELLED
            if (r8 != r15) goto L_0x005a
            r13 = 1
        L_0x005a:
            int r11 = r11 + 1
            goto L_0x0020
        L_0x005d:
            r12 = 1
            r13 = 0
            r14 = 0
        L_0x0060:
            boolean r8 = android.text.TextUtils.isEmpty(r22)
            r8 = r8 ^ r7
            if (r8 == 0) goto L_0x006b
            if (r9 != 0) goto L_0x006b
            r10 = 1
            goto L_0x006c
        L_0x006b:
            r10 = 0
        L_0x006c:
            if (r10 == 0) goto L_0x014e
            j1.q r10 = r6.B()
            java.util.List r10 = r10.m(r2)
            boolean r11 = r10.isEmpty()
            if (r11 != 0) goto L_0x014e
            a1.d r11 = a1.d.APPEND
            if (r3 == r11) goto L_0x00ca
            a1.d r11 = a1.d.APPEND_OR_REPLACE
            if (r3 != r11) goto L_0x0085
            goto L_0x00ca
        L_0x0085:
            a1.d r11 = a1.d.KEEP
            if (r3 != r11) goto L_0x00a5
            java.util.Iterator r3 = r10.iterator()
        L_0x008d:
            boolean r11 = r3.hasNext()
            if (r11 == 0) goto L_0x00a5
            java.lang.Object r11 = r3.next()
            j1.p$b r11 = (j1.p.b) r11
            a1.s r11 = r11.f7108b
            a1.s r15 = a1.s.ENQUEUED
            if (r11 == r15) goto L_0x00a3
            a1.s r15 = a1.s.RUNNING
            if (r11 != r15) goto L_0x008d
        L_0x00a3:
            r11 = 0
            return r11
        L_0x00a5:
            r11 = 0
            k1.a r3 = k1.a.c(r2, r0, r11)
            r3.run()
            j1.q r3 = r6.B()
            java.util.Iterator r10 = r10.iterator()
        L_0x00b5:
            boolean r15 = r10.hasNext()
            if (r15 == 0) goto L_0x00c7
            java.lang.Object r15 = r10.next()
            j1.p$b r15 = (j1.p.b) r15
            java.lang.String r15 = r15.f7107a
            r3.a(r15)
            goto L_0x00b5
        L_0x00c7:
            r3 = 1
            goto L_0x014f
        L_0x00ca:
            r11 = 0
            j1.b r9 = r6.t()
            java.util.ArrayList r15 = new java.util.ArrayList
            r15.<init>()
            java.util.Iterator r10 = r10.iterator()
        L_0x00d8:
            boolean r16 = r10.hasNext()
            if (r16 == 0) goto L_0x0113
            java.lang.Object r16 = r10.next()
            r7 = r16
            j1.p$b r7 = (j1.p.b) r7
            java.lang.String r11 = r7.f7107a
            boolean r11 = r9.d(r11)
            if (r11 != 0) goto L_0x010c
            a1.s r11 = r7.f7108b
            r17 = r9
            a1.s r9 = a1.s.SUCCEEDED
            if (r11 != r9) goto L_0x00f8
            r9 = 1
            goto L_0x00f9
        L_0x00f8:
            r9 = 0
        L_0x00f9:
            r9 = r9 & r12
            a1.s r12 = a1.s.FAILED
            if (r11 != r12) goto L_0x0100
            r14 = 1
            goto L_0x0105
        L_0x0100:
            a1.s r12 = a1.s.CANCELLED
            if (r11 != r12) goto L_0x0105
            r13 = 1
        L_0x0105:
            java.lang.String r7 = r7.f7107a
            r15.add(r7)
            r12 = r9
            goto L_0x010e
        L_0x010c:
            r17 = r9
        L_0x010e:
            r9 = r17
            r7 = 1
            r11 = 0
            goto L_0x00d8
        L_0x0113:
            a1.d r7 = a1.d.APPEND_OR_REPLACE
            if (r3 != r7) goto L_0x0140
            if (r13 != 0) goto L_0x011b
            if (r14 == 0) goto L_0x0140
        L_0x011b:
            j1.q r3 = r6.B()
            java.util.List r7 = r3.m(r2)
            java.util.Iterator r7 = r7.iterator()
        L_0x0127:
            boolean r9 = r7.hasNext()
            if (r9 == 0) goto L_0x0139
            java.lang.Object r9 = r7.next()
            j1.p$b r9 = (j1.p.b) r9
            java.lang.String r9 = r9.f7107a
            r3.a(r9)
            goto L_0x0127
        L_0x0139:
            java.util.List r15 = java.util.Collections.emptyList()
            r3 = 0
            r13 = 0
            goto L_0x0141
        L_0x0140:
            r3 = r14
        L_0x0141:
            java.lang.Object[] r1 = r15.toArray(r1)
            java.lang.String[] r1 = (java.lang.String[]) r1
            int r7 = r1.length
            if (r7 <= 0) goto L_0x014c
            r9 = 1
            goto L_0x014d
        L_0x014c:
            r9 = 0
        L_0x014d:
            r14 = r3
        L_0x014e:
            r3 = 0
        L_0x014f:
            java.util.Iterator r7 = r20.iterator()
        L_0x0153:
            boolean r10 = r7.hasNext()
            if (r10 == 0) goto L_0x0210
            java.lang.Object r10 = r7.next()
            a1.u r10 = (a1.u) r10
            j1.p r11 = r10.c()
            if (r9 == 0) goto L_0x017a
            if (r12 != 0) goto L_0x017a
            if (r14 == 0) goto L_0x016e
            a1.s r15 = a1.s.FAILED
            r11.f7090b = r15
            goto L_0x0182
        L_0x016e:
            if (r13 == 0) goto L_0x0175
            a1.s r15 = a1.s.CANCELLED
            r11.f7090b = r15
            goto L_0x0182
        L_0x0175:
            a1.s r15 = a1.s.BLOCKED
            r11.f7090b = r15
            goto L_0x0182
        L_0x017a:
            boolean r15 = r11.d()
            if (r15 != 0) goto L_0x0185
            r11.f7102n = r4
        L_0x0182:
            r17 = r4
            goto L_0x018b
        L_0x0185:
            r17 = r4
            r4 = 0
            r11.f7102n = r4
        L_0x018b:
            int r4 = android.os.Build.VERSION.SDK_INT
            r5 = 23
            if (r4 < r5) goto L_0x0199
            r5 = 25
            if (r4 > r5) goto L_0x0199
            g(r11)
            goto L_0x01a8
        L_0x0199:
            r5 = 22
            if (r4 > r5) goto L_0x01a8
            java.lang.String r4 = "androidx.work.impl.background.gcm.GcmScheduler"
            boolean r4 = h(r0, r4)
            if (r4 == 0) goto L_0x01a8
            g(r11)
        L_0x01a8:
            a1.s r4 = r11.f7090b
            a1.s r5 = a1.s.ENQUEUED
            if (r4 != r5) goto L_0x01af
            r3 = 1
        L_0x01af:
            j1.q r4 = r6.B()
            r4.e(r11)
            if (r9 == 0) goto L_0x01d3
            int r4 = r1.length
            r5 = 0
        L_0x01ba:
            if (r5 >= r4) goto L_0x01d3
            r11 = r1[r5]
            j1.a r15 = new j1.a
            java.lang.String r0 = r10.a()
            r15.<init>(r0, r11)
            j1.b r0 = r6.t()
            r0.c(r15)
            int r5 = r5 + 1
            r0 = r19
            goto L_0x01ba
        L_0x01d3:
            java.util.Set r0 = r10.b()
            java.util.Iterator r0 = r0.iterator()
        L_0x01db:
            boolean r4 = r0.hasNext()
            if (r4 == 0) goto L_0x01f8
            java.lang.Object r4 = r0.next()
            java.lang.String r4 = (java.lang.String) r4
            j1.t r5 = r6.C()
            j1.s r11 = new j1.s
            java.lang.String r15 = r10.a()
            r11.<init>(r4, r15)
            r5.b(r11)
            goto L_0x01db
        L_0x01f8:
            if (r8 == 0) goto L_0x020a
            j1.k r0 = r6.z()
            j1.j r4 = new j1.j
            java.lang.String r5 = r10.a()
            r4.<init>(r2, r5)
            r0.a(r4)
        L_0x020a:
            r0 = r19
            r4 = r17
            goto L_0x0153
        L_0x0210:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: k1.b.c(b1.j, java.util.List, java.lang.String[], java.lang.String, a1.d):boolean");
    }

    public static boolean e(g gVar) {
        List<g> e10 = gVar.e();
        boolean z10 = false;
        if (e10 != null) {
            boolean z11 = false;
            for (g gVar2 : e10) {
                if (!gVar2.j()) {
                    z11 |= e(gVar2);
                } else {
                    k.c().h(f7236c, String.format("Already enqueued work ids (%s).", new Object[]{TextUtils.join(", ", gVar2.c())}), new Throwable[0]);
                }
            }
            z10 = z11;
        }
        return b(gVar) | z10;
    }

    public static void g(p pVar) {
        a1.b bVar = pVar.f7098j;
        String str = pVar.f7091c;
        Class<ConstraintTrackingWorker> cls = ConstraintTrackingWorker.class;
        if (str.equals(cls.getName())) {
            return;
        }
        if (bVar.f() || bVar.i()) {
            b.a aVar = new b.a();
            aVar.c(pVar.f7093e).e("androidx.work.impl.workers.ConstraintTrackingWorker.ARGUMENT_CLASS_NAME", str);
            pVar.f7091c = cls.getName();
            pVar.f7093e = aVar.a();
        }
    }

    public static boolean h(j jVar, String str) {
        try {
            Class<?> cls = Class.forName(str);
            for (e eVar : jVar.m()) {
                if (cls.isAssignableFrom(eVar.getClass())) {
                    return true;
                }
            }
        } catch (ClassNotFoundException unused) {
        }
        return false;
    }

    public boolean a() {
        WorkDatabase n10 = this.f7237a.g().n();
        n10.c();
        try {
            boolean e10 = e(this.f7237a);
            n10.r();
            return e10;
        } finally {
            n10.g();
        }
    }

    public n d() {
        return this.f7238b;
    }

    public void f() {
        j g10 = this.f7237a.g();
        f.b(g10.h(), g10.n(), g10.m());
    }

    public void run() {
        try {
            if (!this.f7237a.h()) {
                if (a()) {
                    g.a(this.f7237a.g().g(), RescheduleReceiver.class, true);
                    f();
                }
                this.f7238b.a(n.f125a);
                return;
            }
            throw new IllegalStateException(String.format("WorkContinuation has cycles (%s)", new Object[]{this.f7237a}));
        } catch (Throwable th) {
            this.f7238b.a(new n.b.a(th));
        }
    }
}
