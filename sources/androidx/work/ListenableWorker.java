package androidx.work;

import a1.v;
import android.content.Context;
import androidx.annotation.Keep;
import com.google.common.util.concurrent.ListenableFuture;
import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.util.UUID;
import java.util.concurrent.Executor;
import l1.c;

public abstract class ListenableWorker {

    /* renamed from: a  reason: collision with root package name */
    public Context f3334a;

    /* renamed from: b  reason: collision with root package name */
    public WorkerParameters f3335b;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f3336c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f3337d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f3338e;

    public static abstract class a {

        /* renamed from: androidx.work.ListenableWorker$a$a  reason: collision with other inner class name */
        public static final class C0055a extends a {

            /* renamed from: a  reason: collision with root package name */
            public final b f3339a;

            public C0055a() {
                this(b.f3382c);
            }

            public b e() {
                return this.f3339a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || C0055a.class != obj.getClass()) {
                    return false;
                }
                return this.f3339a.equals(((C0055a) obj).f3339a);
            }

            public int hashCode() {
                return (C0055a.class.getName().hashCode() * 31) + this.f3339a.hashCode();
            }

            public String toString() {
                return "Failure {mOutputData=" + this.f3339a + ASCIIPropertyListParser.DICTIONARY_END_TOKEN;
            }

            public C0055a(b bVar) {
                this.f3339a = bVar;
            }
        }

        public static final class b extends a {
            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || b.class != obj.getClass()) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return b.class.getName().hashCode();
            }

            public String toString() {
                return "Retry";
            }
        }

        public static final class c extends a {

            /* renamed from: a  reason: collision with root package name */
            public final b f3340a;

            public c() {
                this(b.f3382c);
            }

            public b e() {
                return this.f3340a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || c.class != obj.getClass()) {
                    return false;
                }
                return this.f3340a.equals(((c) obj).f3340a);
            }

            public int hashCode() {
                return (c.class.getName().hashCode() * 31) + this.f3340a.hashCode();
            }

            public String toString() {
                return "Success {mOutputData=" + this.f3340a + ASCIIPropertyListParser.DICTIONARY_END_TOKEN;
            }

            public c(b bVar) {
                this.f3340a = bVar;
            }
        }

        public static a a() {
            return new C0055a();
        }

        public static a b() {
            return new b();
        }

        public static a c() {
            return new c();
        }

        public static a d(b bVar) {
            return new c(bVar);
        }
    }

    @Keep
    public ListenableWorker(Context context, WorkerParameters workerParameters) {
        if (context == null) {
            throw new IllegalArgumentException("Application Context is null");
        } else if (workerParameters != null) {
            this.f3334a = context;
            this.f3335b = workerParameters;
        } else {
            throw new IllegalArgumentException("WorkerParameters is null");
        }
    }

    public final Context a() {
        return this.f3334a;
    }

    public Executor c() {
        return this.f3335b.a();
    }

    public ListenableFuture e() {
        c s10 = c.s();
        s10.p(new IllegalStateException("Expedited WorkRequests require a ListenableWorker to provide an implementation for `getForegroundInfoAsync()`"));
        return s10;
    }

    public final UUID f() {
        return this.f3335b.c();
    }

    public final b g() {
        return this.f3335b.d();
    }

    public m1.a h() {
        return this.f3335b.e();
    }

    public v i() {
        return this.f3335b.f();
    }

    public boolean j() {
        return this.f3338e;
    }

    public final boolean k() {
        return this.f3336c;
    }

    public final boolean l() {
        return this.f3337d;
    }

    public void m() {
    }

    public void n(boolean z10) {
        this.f3338e = z10;
    }

    public final void o() {
        this.f3337d = true;
    }

    public abstract ListenableFuture p();

    public final void q() {
        this.f3336c = true;
        m();
    }
}
