package b1;

import a1.k;
import a1.n;
import a1.t;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.os.Build;
import androidx.work.R$bool;
import androidx.work.WorkerParameters;
import androidx.work.a;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.utils.ForceStopRunnable;
import e1.f0;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import k1.h;
import k1.l;
import k1.m;
import m1.b;

public class j extends t {

    /* renamed from: j  reason: collision with root package name */
    public static final String f4151j = k.f("WorkManagerImpl");

    /* renamed from: k  reason: collision with root package name */
    public static j f4152k = null;

    /* renamed from: l  reason: collision with root package name */
    public static j f4153l = null;

    /* renamed from: m  reason: collision with root package name */
    public static final Object f4154m = new Object();

    /* renamed from: a  reason: collision with root package name */
    public Context f4155a;

    /* renamed from: b  reason: collision with root package name */
    public a f4156b;

    /* renamed from: c  reason: collision with root package name */
    public WorkDatabase f4157c;

    /* renamed from: d  reason: collision with root package name */
    public m1.a f4158d;

    /* renamed from: e  reason: collision with root package name */
    public List f4159e;

    /* renamed from: f  reason: collision with root package name */
    public d f4160f;

    /* renamed from: g  reason: collision with root package name */
    public h f4161g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f4162h;

    /* renamed from: i  reason: collision with root package name */
    public BroadcastReceiver.PendingResult f4163i;

    public j(Context context, a aVar, m1.a aVar2) {
        this(context, aVar, aVar2, context.getResources().getBoolean(R$bool.workmanager_test_configuration));
    }

    public static void d(Context context, a aVar) {
        synchronized (f4154m) {
            j jVar = f4152k;
            if (jVar != null) {
                if (f4153l != null) {
                    throw new IllegalStateException("WorkManager is already initialized.  Did you try to initialize it manually without disabling WorkManagerInitializer? See WorkManager#initialize(Context, Configuration) or the class level Javadoc for more information.");
                }
            }
            if (jVar == null) {
                Context applicationContext = context.getApplicationContext();
                if (f4153l == null) {
                    f4153l = new j(applicationContext, aVar, new b(aVar.l()));
                }
                f4152k = f4153l;
            }
        }
    }

    public static j i() {
        synchronized (f4154m) {
            j jVar = f4152k;
            if (jVar != null) {
                return jVar;
            }
            j jVar2 = f4153l;
            return jVar2;
        }
    }

    public static j j(Context context) {
        j i10;
        synchronized (f4154m) {
            i10 = i();
            if (i10 == null) {
                context.getApplicationContext();
                throw new IllegalStateException("WorkManager is not initialized properly.  You have explicitly disabled WorkManagerInitializer in your manifest, have not manually called WorkManager#initialize at this point, and your Application does not implement Configuration.Provider.");
            }
        }
        return i10;
    }

    public n b(List list) {
        if (!list.isEmpty()) {
            return new g(this, list).a();
        }
        throw new IllegalArgumentException("enqueue needs at least one WorkRequest.");
    }

    public n e(UUID uuid) {
        k1.a b10 = k1.a.b(uuid, this);
        this.f4158d.b(b10);
        return b10.d();
    }

    public List f(Context context, a aVar, m1.a aVar2) {
        return Arrays.asList(new e[]{f.a(context, this), new c1.b(context, aVar, aVar2, this)});
    }

    public Context g() {
        return this.f4155a;
    }

    public a h() {
        return this.f4156b;
    }

    public h k() {
        return this.f4161g;
    }

    public d l() {
        return this.f4160f;
    }

    public List m() {
        return this.f4159e;
    }

    public WorkDatabase n() {
        return this.f4157c;
    }

    public m1.a o() {
        return this.f4158d;
    }

    public final void p(Context context, a aVar, m1.a aVar2, WorkDatabase workDatabase, List list, d dVar) {
        Context applicationContext = context.getApplicationContext();
        this.f4155a = applicationContext;
        this.f4156b = aVar;
        this.f4158d = aVar2;
        this.f4157c = workDatabase;
        this.f4159e = list;
        this.f4160f = dVar;
        this.f4161g = new h(workDatabase);
        this.f4162h = false;
        if (Build.VERSION.SDK_INT < 24 || !applicationContext.isDeviceProtectedStorage()) {
            this.f4158d.b(new ForceStopRunnable(applicationContext, this));
            return;
        }
        throw new IllegalStateException("Cannot initialize WorkManager in direct boot mode");
    }

    public void q() {
        synchronized (f4154m) {
            this.f4162h = true;
            BroadcastReceiver.PendingResult pendingResult = this.f4163i;
            if (pendingResult != null) {
                pendingResult.finish();
                this.f4163i = null;
            }
        }
    }

    public void r() {
        if (Build.VERSION.SDK_INT >= 23) {
            f0.b(g());
        }
        n().B().k();
        f.b(h(), n(), m());
    }

    public void s(BroadcastReceiver.PendingResult pendingResult) {
        synchronized (f4154m) {
            this.f4163i = pendingResult;
            if (this.f4162h) {
                pendingResult.finish();
                this.f4163i = null;
            }
        }
    }

    public void t(String str) {
        u(str, (WorkerParameters.a) null);
    }

    public void u(String str, WorkerParameters.a aVar) {
        this.f4158d.b(new l(this, str, aVar));
    }

    public void v(String str) {
        this.f4158d.b(new m(this, str, true));
    }

    public void w(String str) {
        this.f4158d.b(new m(this, str, false));
    }

    public j(Context context, a aVar, m1.a aVar2, boolean z10) {
        this(context, aVar, aVar2, WorkDatabase.s(context.getApplicationContext(), aVar2.c(), z10));
    }

    public j(Context context, a aVar, m1.a aVar2, WorkDatabase workDatabase) {
        Context applicationContext = context.getApplicationContext();
        k.e(new k.a(aVar.j()));
        Context context2 = context;
        a aVar3 = aVar;
        m1.a aVar4 = aVar2;
        WorkDatabase workDatabase2 = workDatabase;
        List f10 = f(applicationContext, aVar, aVar2);
        p(context2, aVar3, aVar4, workDatabase2, f10, new d(context2, aVar3, aVar4, workDatabase2, f10));
    }
}
