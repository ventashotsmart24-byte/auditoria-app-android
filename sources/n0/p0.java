package n0;

import android.content.ComponentName;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Executor;

public abstract class p0 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f7969a;

    /* renamed from: b  reason: collision with root package name */
    public final d f7970b;

    /* renamed from: c  reason: collision with root package name */
    public final c f7971c;

    /* renamed from: d  reason: collision with root package name */
    public a f7972d;

    /* renamed from: e  reason: collision with root package name */
    public o0 f7973e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f7974f;

    /* renamed from: g  reason: collision with root package name */
    public q0 f7975g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f7976h;

    public static abstract class a {
        public abstract void a(p0 p0Var, q0 q0Var);
    }

    public static abstract class b extends e {

        /* renamed from: a  reason: collision with root package name */
        public final Object f7977a = new Object();

        /* renamed from: b  reason: collision with root package name */
        public Executor f7978b;

        /* renamed from: c  reason: collision with root package name */
        public d f7979c;

        /* renamed from: d  reason: collision with root package name */
        public n0 f7980d;

        /* renamed from: e  reason: collision with root package name */
        public Collection f7981e;

        public class a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ d f7982a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ n0 f7983b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ Collection f7984c;

            public a(d dVar, n0 n0Var, Collection collection) {
                this.f7982a = dVar;
                this.f7983b = n0Var;
                this.f7984c = collection;
            }

            public void run() {
                this.f7982a.a(b.this, this.f7983b, this.f7984c);
            }
        }

        /* renamed from: n0.p0$b$b  reason: collision with other inner class name */
        public class C0100b implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ d f7986a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ n0 f7987b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ Collection f7988c;

            public C0100b(d dVar, n0 n0Var, Collection collection) {
                this.f7986a = dVar;
                this.f7987b = n0Var;
                this.f7988c = collection;
            }

            public void run() {
                this.f7986a.a(b.this, this.f7987b, this.f7988c);
            }
        }

        public static final class c {

            /* renamed from: a  reason: collision with root package name */
            public final n0 f7990a;

            /* renamed from: b  reason: collision with root package name */
            public final int f7991b;

            /* renamed from: c  reason: collision with root package name */
            public final boolean f7992c;

            /* renamed from: d  reason: collision with root package name */
            public final boolean f7993d;

            /* renamed from: e  reason: collision with root package name */
            public final boolean f7994e;

            public static final class a {

                /* renamed from: a  reason: collision with root package name */
                public final n0 f7995a;

                /* renamed from: b  reason: collision with root package name */
                public int f7996b = 1;

                /* renamed from: c  reason: collision with root package name */
                public boolean f7997c = false;

                /* renamed from: d  reason: collision with root package name */
                public boolean f7998d = false;

                /* renamed from: e  reason: collision with root package name */
                public boolean f7999e = false;

                public a(n0 n0Var) {
                    this.f7995a = n0Var;
                }

                public c a() {
                    return new c(this.f7995a, this.f7996b, this.f7997c, this.f7998d, this.f7999e);
                }

                public a b(boolean z10) {
                    this.f7998d = z10;
                    return this;
                }

                public a c(boolean z10) {
                    this.f7999e = z10;
                    return this;
                }

                public a d(boolean z10) {
                    this.f7997c = z10;
                    return this;
                }

                public a e(int i10) {
                    this.f7996b = i10;
                    return this;
                }
            }

            public c(n0 n0Var, int i10, boolean z10, boolean z11, boolean z12) {
                this.f7990a = n0Var;
                this.f7991b = i10;
                this.f7992c = z10;
                this.f7993d = z11;
                this.f7994e = z12;
            }

            public static c a(Bundle bundle) {
                if (bundle == null) {
                    return null;
                }
                return new c(n0.d(bundle.getBundle("mrDescriptor")), bundle.getInt("selectionState", 1), bundle.getBoolean("isUnselectable", false), bundle.getBoolean("isGroupable", false), bundle.getBoolean("isTransferable", false));
            }

            public n0 b() {
                return this.f7990a;
            }

            public int c() {
                return this.f7991b;
            }

            public boolean d() {
                return this.f7993d;
            }

            public boolean e() {
                return this.f7994e;
            }

            public boolean f() {
                return this.f7992c;
            }
        }

        public interface d {
            void a(b bVar, n0 n0Var, Collection collection);
        }

        public String j() {
            return null;
        }

        public String k() {
            return null;
        }

        public final void l(n0 n0Var, Collection collection) {
            if (n0Var == null) {
                throw new NullPointerException("groupRoute must not be null");
            } else if (collection != null) {
                synchronized (this.f7977a) {
                    Executor executor = this.f7978b;
                    if (executor != null) {
                        executor.execute(new C0100b(this.f7979c, n0Var, collection));
                    } else {
                        this.f7980d = n0Var;
                        this.f7981e = new ArrayList(collection);
                    }
                }
            } else {
                throw new NullPointerException("dynamicRoutes must not be null");
            }
        }

        public abstract void m(String str);

        public abstract void n(String str);

        public abstract void o(List list);

        public void p(Executor executor, d dVar) {
            synchronized (this.f7977a) {
                if (executor == null) {
                    throw new NullPointerException("Executor shouldn't be null");
                } else if (dVar != null) {
                    this.f7978b = executor;
                    this.f7979c = dVar;
                    Collection collection = this.f7981e;
                    if (collection != null && !collection.isEmpty()) {
                        n0 n0Var = this.f7980d;
                        Collection collection2 = this.f7981e;
                        this.f7980d = null;
                        this.f7981e = null;
                        this.f7978b.execute(new a(dVar, n0Var, collection2));
                    }
                } else {
                    throw new NullPointerException("Listener shouldn't be null");
                }
            }
        }
    }

    public final class c extends Handler {
        public c() {
        }

        public void handleMessage(Message message) {
            int i10 = message.what;
            if (i10 == 1) {
                p0.this.l();
            } else if (i10 == 2) {
                p0.this.m();
            }
        }
    }

    public static final class d {

        /* renamed from: a  reason: collision with root package name */
        public final ComponentName f8001a;

        public d(ComponentName componentName) {
            if (componentName != null) {
                this.f8001a = componentName;
                return;
            }
            throw new IllegalArgumentException("componentName must not be null");
        }

        public ComponentName a() {
            return this.f8001a;
        }

        public String b() {
            return this.f8001a.getPackageName();
        }

        public String toString() {
            return "ProviderMetadata{ componentName=" + this.f8001a.flattenToShortString() + " }";
        }
    }

    public static abstract class e {
        public void d() {
        }

        public void e() {
        }

        public abstract void f(int i10);

        public void g() {
        }

        public void h(int i10) {
            g();
        }

        public abstract void i(int i10);
    }

    public p0(Context context) {
        this(context, (d) null);
    }

    public void l() {
        this.f7976h = false;
        a aVar = this.f7972d;
        if (aVar != null) {
            aVar.a(this, this.f7975g);
        }
    }

    public void m() {
        this.f7974f = false;
        u(this.f7973e);
    }

    public final Context n() {
        return this.f7969a;
    }

    public final q0 o() {
        return this.f7975g;
    }

    public final o0 p() {
        return this.f7973e;
    }

    public final d q() {
        return this.f7970b;
    }

    public b r(String str) {
        if (str != null) {
            return null;
        }
        throw new IllegalArgumentException("initialMemberRouteId cannot be null.");
    }

    public abstract e s(String str);

    public e t(String str, String str2) {
        if (str == null) {
            throw new IllegalArgumentException("routeId cannot be null");
        } else if (str2 != null) {
            return s(str);
        } else {
            throw new IllegalArgumentException("routeGroupId cannot be null");
        }
    }

    public abstract void u(o0 o0Var);

    public final void v(a aVar) {
        t0.d();
        this.f7972d = aVar;
    }

    public final void w(q0 q0Var) {
        t0.d();
        if (this.f7975g != q0Var) {
            this.f7975g = q0Var;
            if (!this.f7976h) {
                this.f7976h = true;
                this.f7971c.sendEmptyMessage(1);
            }
        }
    }

    public final void x(o0 o0Var) {
        t0.d();
        if (!a0.c.a(this.f7973e, o0Var)) {
            y(o0Var);
        }
    }

    public final void y(o0 o0Var) {
        this.f7973e = o0Var;
        if (!this.f7974f) {
            this.f7974f = true;
            this.f7971c.sendEmptyMessage(2);
        }
    }

    public p0(Context context, d dVar) {
        this.f7971c = new c();
        if (context != null) {
            this.f7969a = context;
            if (dVar == null) {
                this.f7970b = new d(new ComponentName(context, getClass()));
            } else {
                this.f7970b = dVar;
            }
        } else {
            throw new IllegalArgumentException("context must not be null");
        }
    }
}
