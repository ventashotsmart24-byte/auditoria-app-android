package androidx.work.impl.background.systemalarm;

import a1.k;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import androidx.work.impl.background.systemalarm.d;
import b1.b;
import f1.d;
import j1.p;
import java.util.Collections;
import java.util.List;
import k1.n;
import k1.r;

public class c implements f1.c, b, r.b {

    /* renamed from: j  reason: collision with root package name */
    public static final String f3423j = k.f("DelayMetCommandHandler");

    /* renamed from: a  reason: collision with root package name */
    public final Context f3424a;

    /* renamed from: b  reason: collision with root package name */
    public final int f3425b;

    /* renamed from: c  reason: collision with root package name */
    public final String f3426c;

    /* renamed from: d  reason: collision with root package name */
    public final d f3427d;

    /* renamed from: e  reason: collision with root package name */
    public final d f3428e;

    /* renamed from: f  reason: collision with root package name */
    public final Object f3429f = new Object();

    /* renamed from: g  reason: collision with root package name */
    public int f3430g = 0;

    /* renamed from: h  reason: collision with root package name */
    public PowerManager.WakeLock f3431h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f3432i = false;

    public c(Context context, int i10, String str, d dVar) {
        this.f3424a = context;
        this.f3425b = i10;
        this.f3427d = dVar;
        this.f3426c = str;
        this.f3428e = new d(context, dVar.f(), this);
    }

    public void a(String str) {
        k.c().a(f3423j, String.format("Exceeded time limits on execution for %s", new Object[]{str}), new Throwable[0]);
        g();
    }

    public void b(List list) {
        g();
    }

    public void c(String str, boolean z10) {
        k.c().a(f3423j, String.format("onExecuted %s, %s", new Object[]{str, Boolean.valueOf(z10)}), new Throwable[0]);
        e();
        if (z10) {
            Intent f10 = a.f(this.f3424a, this.f3426c);
            d dVar = this.f3427d;
            dVar.k(new d.b(dVar, f10, this.f3425b));
        }
        if (this.f3432i) {
            Intent a10 = a.a(this.f3424a);
            d dVar2 = this.f3427d;
            dVar2.k(new d.b(dVar2, a10, this.f3425b));
        }
    }

    public void d(List list) {
        if (list.contains(this.f3426c)) {
            synchronized (this.f3429f) {
                if (this.f3430g == 0) {
                    this.f3430g = 1;
                    k.c().a(f3423j, String.format("onAllConstraintsMet for %s", new Object[]{this.f3426c}), new Throwable[0]);
                    if (this.f3427d.e().j(this.f3426c)) {
                        this.f3427d.h().b(this.f3426c, 600000, this);
                    } else {
                        e();
                    }
                } else {
                    k.c().a(f3423j, String.format("Already started work for %s", new Object[]{this.f3426c}), new Throwable[0]);
                }
            }
        }
    }

    public final void e() {
        synchronized (this.f3429f) {
            this.f3428e.e();
            this.f3427d.h().c(this.f3426c);
            PowerManager.WakeLock wakeLock = this.f3431h;
            if (wakeLock != null && wakeLock.isHeld()) {
                k.c().a(f3423j, String.format("Releasing wakelock %s for WorkSpec %s", new Object[]{this.f3431h, this.f3426c}), new Throwable[0]);
                this.f3431h.release();
            }
        }
    }

    public void f() {
        this.f3431h = n.b(this.f3424a, String.format("%s (%s)", new Object[]{this.f3426c, Integer.valueOf(this.f3425b)}));
        k c10 = k.c();
        String str = f3423j;
        c10.a(str, String.format("Acquiring wakelock %s for WorkSpec %s", new Object[]{this.f3431h, this.f3426c}), new Throwable[0]);
        this.f3431h.acquire();
        p h10 = this.f3427d.g().n().B().h(this.f3426c);
        if (h10 == null) {
            g();
            return;
        }
        boolean b10 = h10.b();
        this.f3432i = b10;
        if (!b10) {
            k.c().a(str, String.format("No constraints for %s", new Object[]{this.f3426c}), new Throwable[0]);
            d(Collections.singletonList(this.f3426c));
            return;
        }
        this.f3428e.d(Collections.singletonList(h10));
    }

    public final void g() {
        synchronized (this.f3429f) {
            if (this.f3430g < 2) {
                this.f3430g = 2;
                k c10 = k.c();
                String str = f3423j;
                c10.a(str, String.format("Stopping work for WorkSpec %s", new Object[]{this.f3426c}), new Throwable[0]);
                Intent g10 = a.g(this.f3424a, this.f3426c);
                d dVar = this.f3427d;
                dVar.k(new d.b(dVar, g10, this.f3425b));
                if (this.f3427d.e().g(this.f3426c)) {
                    k.c().a(str, String.format("WorkSpec %s needs to be rescheduled", new Object[]{this.f3426c}), new Throwable[0]);
                    Intent f10 = a.f(this.f3424a, this.f3426c);
                    d dVar2 = this.f3427d;
                    dVar2.k(new d.b(dVar2, f10, this.f3425b));
                } else {
                    k.c().a(str, String.format("Processor does not have WorkSpec %s. No need to reschedule ", new Object[]{this.f3426c}), new Throwable[0]);
                }
            } else {
                k.c().a(f3423j, String.format("Already stopped work for %s", new Object[]{this.f3426c}), new Throwable[0]);
            }
        }
    }
}
