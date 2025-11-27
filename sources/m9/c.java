package m9;

import k9.d;
import k9.f;
import kotlin.coroutines.Continuation;
import t9.i;

public abstract class c extends a {
    private final f _context;
    private transient Continuation<Object> intercepted;

    public c(Continuation continuation, f fVar) {
        super(continuation);
        this._context = fVar;
    }

    public f getContext() {
        f fVar = this._context;
        i.d(fVar);
        return fVar;
    }

    public final Continuation<Object> intercepted() {
        Continuation<Object> continuation = this.intercepted;
        if (continuation == null) {
            d dVar = (d) getContext().a(d.f18228e0);
            if (dVar == null || (continuation = dVar.c(this)) == null) {
                continuation = this;
            }
            this.intercepted = continuation;
        }
        return continuation;
    }

    public void releaseIntercepted() {
        Continuation<Object> continuation = this.intercepted;
        if (!(continuation == null || continuation == this)) {
            f.b a10 = getContext().a(d.f18228e0);
            i.d(a10);
            ((d) a10).b(continuation);
        }
        this.intercepted = b.f18983a;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public c(Continuation continuation) {
        this(continuation, continuation != null ? continuation.getContext() : null);
    }
}
