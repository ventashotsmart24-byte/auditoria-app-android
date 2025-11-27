package m9;

import k9.f;
import k9.g;
import kotlin.coroutines.Continuation;

public abstract class i extends a {
    public i(Continuation continuation) {
        super(continuation);
        boolean z10;
        if (continuation != null) {
            if (continuation.getContext() == g.f18231a) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (!z10) {
                throw new IllegalArgumentException("Coroutines with restricted suspension must have EmptyCoroutineContext".toString());
            }
        }
    }

    public f getContext() {
        return g.f18231a;
    }
}
