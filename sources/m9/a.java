package m9;

import h9.l;
import h9.m;
import h9.t;
import java.io.Serializable;
import kotlin.coroutines.Continuation;
import l9.c;
import t9.i;

public abstract class a implements Continuation, d, Serializable {
    private final Continuation<Object> completion;

    public a(Continuation continuation) {
        this.completion = continuation;
    }

    public Continuation<t> create(Continuation<?> continuation) {
        i.g(continuation, "completion");
        throw new UnsupportedOperationException("create(Continuation) has not been overridden");
    }

    public d getCallerFrame() {
        Continuation<Object> continuation = this.completion;
        if (continuation instanceof d) {
            return (d) continuation;
        }
        return null;
    }

    public final Continuation<Object> getCompletion() {
        return this.completion;
    }

    public StackTraceElement getStackTraceElement() {
        return f.d(this);
    }

    public abstract Object invokeSuspend(Object obj);

    public void releaseIntercepted() {
    }

    public final void resumeWith(Object obj) {
        Continuation continuation = this;
        while (true) {
            g.b(continuation);
            a aVar = (a) continuation;
            Continuation continuation2 = aVar.completion;
            i.d(continuation2);
            try {
                Object invokeSuspend = aVar.invokeSuspend(obj);
                if (invokeSuspend != c.c()) {
                    obj = l.a(invokeSuspend);
                    aVar.releaseIntercepted();
                    if (continuation2 instanceof a) {
                        continuation = continuation2;
                    } else {
                        continuation2.resumeWith(obj);
                        return;
                    }
                } else {
                    return;
                }
            } catch (Throwable th) {
                l.a aVar2 = l.f17317a;
                obj = l.a(m.a(th));
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Continuation at ");
        Object stackTraceElement = getStackTraceElement();
        if (stackTraceElement == null) {
            stackTraceElement = getClass().getName();
        }
        sb.append(stackTraceElement);
        return sb.toString();
    }

    public Continuation<t> create(Object obj, Continuation<?> continuation) {
        i.g(continuation, "completion");
        throw new UnsupportedOperationException("create(Any?;Continuation) has not been overridden");
    }
}
