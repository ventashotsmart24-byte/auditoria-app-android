package androidx.work;

import a1.g;
import a1.i;
import a1.q;
import a1.v;
import android.os.Build;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public final Executor f3357a;

    /* renamed from: b  reason: collision with root package name */
    public final Executor f3358b;

    /* renamed from: c  reason: collision with root package name */
    public final v f3359c;

    /* renamed from: d  reason: collision with root package name */
    public final i f3360d;

    /* renamed from: e  reason: collision with root package name */
    public final q f3361e;

    /* renamed from: f  reason: collision with root package name */
    public final String f3362f;

    /* renamed from: g  reason: collision with root package name */
    public final int f3363g;

    /* renamed from: h  reason: collision with root package name */
    public final int f3364h;

    /* renamed from: i  reason: collision with root package name */
    public final int f3365i;

    /* renamed from: j  reason: collision with root package name */
    public final int f3366j;

    /* renamed from: k  reason: collision with root package name */
    public final boolean f3367k;

    /* renamed from: androidx.work.a$a  reason: collision with other inner class name */
    public class C0056a implements ThreadFactory {

        /* renamed from: a  reason: collision with root package name */
        public final AtomicInteger f3368a = new AtomicInteger(0);

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f3369b;

        public C0056a(boolean z10) {
            this.f3369b = z10;
        }

        public Thread newThread(Runnable runnable) {
            String str;
            if (this.f3369b) {
                str = "WM.task-";
            } else {
                str = "androidx.work-";
            }
            return new Thread(runnable, str + this.f3368a.incrementAndGet());
        }
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public Executor f3371a;

        /* renamed from: b  reason: collision with root package name */
        public v f3372b;

        /* renamed from: c  reason: collision with root package name */
        public i f3373c;

        /* renamed from: d  reason: collision with root package name */
        public Executor f3374d;

        /* renamed from: e  reason: collision with root package name */
        public q f3375e;

        /* renamed from: f  reason: collision with root package name */
        public String f3376f;

        /* renamed from: g  reason: collision with root package name */
        public int f3377g = 4;

        /* renamed from: h  reason: collision with root package name */
        public int f3378h = 0;

        /* renamed from: i  reason: collision with root package name */
        public int f3379i = Integer.MAX_VALUE;

        /* renamed from: j  reason: collision with root package name */
        public int f3380j = 20;

        public a a() {
            return new a(this);
        }
    }

    public a(b bVar) {
        Executor executor = bVar.f3371a;
        if (executor == null) {
            this.f3357a = a(false);
        } else {
            this.f3357a = executor;
        }
        Executor executor2 = bVar.f3374d;
        if (executor2 == null) {
            this.f3367k = true;
            this.f3358b = a(true);
        } else {
            this.f3367k = false;
            this.f3358b = executor2;
        }
        v vVar = bVar.f3372b;
        if (vVar == null) {
            this.f3359c = v.c();
        } else {
            this.f3359c = vVar;
        }
        i iVar = bVar.f3373c;
        if (iVar == null) {
            this.f3360d = i.c();
        } else {
            this.f3360d = iVar;
        }
        q qVar = bVar.f3375e;
        if (qVar == null) {
            this.f3361e = new b1.a();
        } else {
            this.f3361e = qVar;
        }
        this.f3363g = bVar.f3377g;
        this.f3364h = bVar.f3378h;
        this.f3365i = bVar.f3379i;
        this.f3366j = bVar.f3380j;
        this.f3362f = bVar.f3376f;
    }

    public final Executor a(boolean z10) {
        return Executors.newFixedThreadPool(Math.max(2, Math.min(Runtime.getRuntime().availableProcessors() - 1, 4)), b(z10));
    }

    public final ThreadFactory b(boolean z10) {
        return new C0056a(z10);
    }

    public String c() {
        return this.f3362f;
    }

    public g d() {
        return null;
    }

    public Executor e() {
        return this.f3357a;
    }

    public i f() {
        return this.f3360d;
    }

    public int g() {
        return this.f3365i;
    }

    public int h() {
        if (Build.VERSION.SDK_INT == 23) {
            return this.f3366j / 2;
        }
        return this.f3366j;
    }

    public int i() {
        return this.f3364h;
    }

    public int j() {
        return this.f3363g;
    }

    public q k() {
        return this.f3361e;
    }

    public Executor l() {
        return this.f3358b;
    }

    public v m() {
        return this.f3359c;
    }
}
