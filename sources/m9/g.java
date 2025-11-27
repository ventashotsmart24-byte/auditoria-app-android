package m9;

import kotlin.coroutines.Continuation;
import t9.i;

public abstract class g {
    public static final Continuation a(Continuation continuation) {
        i.g(continuation, "completion");
        return continuation;
    }

    public static final void b(Continuation continuation) {
        i.g(continuation, "frame");
    }

    public static final void c(Continuation continuation) {
        i.g(continuation, "frame");
    }
}
