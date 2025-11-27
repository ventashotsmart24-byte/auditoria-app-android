package da;

import android.os.Handler;
import android.os.Looper;
import ca.j1;
import ca.n0;
import java.util.concurrent.CancellationException;
import k9.f;
import t9.g;
import t9.i;

public final class c extends d {
    private volatile c _immediate;

    /* renamed from: c  reason: collision with root package name */
    public final Handler f16435c;

    /* renamed from: d  reason: collision with root package name */
    public final String f16436d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f16437e;

    /* renamed from: f  reason: collision with root package name */
    public final c f16438f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(Handler handler, String str, boolean z10) {
        super((g) null);
        c cVar = null;
        this.f16435c = handler;
        this.f16436d = str;
        this.f16437e = z10;
        this._immediate = z10 ? this : cVar;
        c cVar2 = this._immediate;
        if (cVar2 == null) {
            cVar2 = new c(handler, str, true);
            this._immediate = cVar2;
        }
        this.f16438f = cVar2;
    }

    public void L(f fVar, Runnable runnable) {
        if (!this.f16435c.post(runnable)) {
            Q(fVar, runnable);
        }
    }

    public boolean M(f fVar) {
        if (!this.f16437e || !i.b(Looper.myLooper(), this.f16435c.getLooper())) {
            return true;
        }
        return false;
    }

    public final void Q(f fVar, Runnable runnable) {
        j1.c(fVar, new CancellationException("The task was rejected, the handler underlying the dispatcher '" + this + "' was closed"));
        n0.b().L(fVar, runnable);
    }

    /* renamed from: R */
    public c O() {
        return this.f16438f;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof c) || ((c) obj).f16435c != this.f16435c) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return System.identityHashCode(this.f16435c);
    }

    public String toString() {
        String P = P();
        if (P != null) {
            return P;
        }
        String str = this.f16436d;
        if (str == null) {
            str = this.f16435c.toString();
        }
        if (!this.f16437e) {
            return str;
        }
        return str + ".immediate";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ c(Handler handler, String str, int i10, g gVar) {
        this(handler, (i10 & 2) != 0 ? null : str);
    }

    public c(Handler handler, String str) {
        this(handler, str, false);
    }
}
