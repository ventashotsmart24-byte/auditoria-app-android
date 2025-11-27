package com.umeng.message.proguard;

import android.app.Activity;
import anet.channel.entity.ConnType;
import com.umeng.message.proguard.bz;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public final class dg extends bz.b {

    /* renamed from: a  reason: collision with root package name */
    private static final dg f15750a = new dg();
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public volatile Future<Void> f15751b;

    private dg() {
    }

    public static dg b() {
        return f15750a;
    }

    public final String a() {
        return ConnType.PK_AUTO;
    }

    public final void c(Activity activity) {
        if (!(activity instanceof cx)) {
            try {
                final dt a10 = dt.a();
                if (a10.f15882a.c(ConnType.PK_AUTO)) {
                    Future<Void> future = this.f15751b;
                    if (future != null && !future.isDone() && !future.isCancelled()) {
                        future.cancel(false);
                    }
                    final Class<?> cls = activity.getClass();
                    this.f15751b = cb.a(new Callable<Void>() {
                        /* JADX WARNING: Code restructure failed: missing block: B:12:0x007c, code lost:
                            r3 = new com.umeng.message.proguard.cz(com.umeng.message.proguard.bx.c.BANNER, r1);
                         */
                        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0096, code lost:
                            r3 = new com.umeng.message.proguard.cz(com.umeng.message.proguard.bx.c.INTERSTITIAL, r1);
                         */
                        /* JADX WARNING: Code restructure failed: missing block: B:22:0x00b0, code lost:
                            r3 = new com.umeng.message.proguard.cz(com.umeng.message.proguard.bx.c.FLOATING_ICON, r1);
                         */
                        /* Code decompiled incorrectly, please refer to instructions dump. */
                        public final /* synthetic */ java.lang.Object call() {
                            /*
                                r8 = this;
                                com.umeng.message.proguard.dg r0 = com.umeng.message.proguard.dg.this
                                java.util.concurrent.Future unused = r0.f15751b = null
                                com.umeng.message.proguard.dt r0 = r0
                                java.lang.Class r1 = r7
                                boolean r0 = r0.a((java.lang.Class<? extends android.app.Activity>) r1)
                                if (r0 != 0) goto L_0x00c2
                                long r0 = java.lang.System.currentTimeMillis()
                                com.umeng.message.proguard.dt r2 = r0
                                com.umeng.message.proguard.du r2 = r2.f15882a
                                java.lang.String r3 = "interval"
                                r4 = 300(0x12c, double:1.48E-321)
                                long r2 = r2.b((java.lang.String) r3, (long) r4)
                                r4 = 1000(0x3e8, double:4.94E-321)
                                long r2 = r2 * r4
                                r4 = 60000(0xea60, double:2.9644E-319)
                                long r2 = java.lang.Math.max(r2, r4)
                                com.umeng.message.proguard.dt r4 = r0
                                com.umeng.message.proguard.du r4 = r4.f15882a
                                r5 = 0
                                java.lang.String r7 = "req"
                                long r4 = r4.b((java.lang.String) r7, (long) r5)
                                long r4 = r0 - r4
                                long r4 = java.lang.Math.abs(r4)
                                int r6 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
                                if (r6 < 0) goto L_0x00c2
                                com.umeng.message.proguard.bz r2 = com.umeng.message.proguard.bz.a()
                                android.app.Activity r2 = r2.b()
                                if (r2 == 0) goto L_0x00c2
                                boolean r3 = com.umeng.message.proguard.ed.a((android.app.Activity) r2)
                                if (r3 != 0) goto L_0x00c2
                                java.lang.Class r3 = r7
                                java.lang.String r3 = r3.getName()
                                java.lang.Class r2 = r2.getClass()
                                java.lang.String r2 = r2.getName()
                                boolean r2 = r3.equals(r2)
                                if (r2 == 0) goto L_0x00c2
                                com.umeng.message.proguard.dt r2 = r0
                                com.umeng.message.proguard.du r2 = r2.f15882a
                                r2.a((java.lang.String) r7, (long) r0)
                                com.umeng.message.proguard.db unused = com.umeng.message.proguard.db.a.f15728a
                                com.umeng.message.proguard.dg$1$1 r0 = new com.umeng.message.proguard.dg$1$1
                                r0.<init>()
                                com.umeng.message.proguard.df r1 = com.umeng.message.proguard.df.a.f15749a
                                com.umeng.message.proguard.bw r1 = r1.f15745b
                                r2 = 1
                                if (r1 == 0) goto L_0x008e
                                com.umeng.message.proguard.cz r3 = new com.umeng.message.proguard.cz
                                com.umeng.message.proguard.bx$c r4 = com.umeng.message.proguard.bx.c.BANNER
                                r3.<init>(r4, r1)
                                com.umeng.message.proguard.dc r1 = com.umeng.message.proguard.dd.a(r3, r0)
                                if (r1 == 0) goto L_0x008e
                                r3.f15718c = r2
                                r1.a()
                            L_0x008e:
                                com.umeng.message.proguard.df r1 = com.umeng.message.proguard.df.a.f15749a
                                com.umeng.message.proguard.bw r1 = r1.f15744a
                                if (r1 == 0) goto L_0x00a8
                                com.umeng.message.proguard.cz r3 = new com.umeng.message.proguard.cz
                                com.umeng.message.proguard.bx$c r4 = com.umeng.message.proguard.bx.c.INTERSTITIAL
                                r3.<init>(r4, r1)
                                com.umeng.message.proguard.dc r1 = com.umeng.message.proguard.dd.a(r3, r0)
                                if (r1 == 0) goto L_0x00a8
                                r3.f15718c = r2
                                r1.a()
                            L_0x00a8:
                                com.umeng.message.proguard.df r1 = com.umeng.message.proguard.df.a.f15749a
                                com.umeng.message.proguard.bw r1 = r1.f15746c
                                if (r1 == 0) goto L_0x00c2
                                com.umeng.message.proguard.cz r3 = new com.umeng.message.proguard.cz
                                com.umeng.message.proguard.bx$c r4 = com.umeng.message.proguard.bx.c.FLOATING_ICON
                                r3.<init>(r4, r1)
                                com.umeng.message.proguard.dc r0 = com.umeng.message.proguard.dd.a(r3, r0)
                                if (r0 == 0) goto L_0x00c2
                                r3.f15718c = r2
                                r0.a()
                            L_0x00c2:
                                r0 = 0
                                return r0
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.umeng.message.proguard.dg.AnonymousClass1.call():java.lang.Object");
                        }
                    }, Math.max(a10.f15882a.b("delay", 7), 5), TimeUnit.SECONDS);
                }
            } catch (Throwable unused) {
            }
        }
    }
}
