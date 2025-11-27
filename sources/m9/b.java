package m9;

import k9.f;
import kotlin.coroutines.Continuation;

public final class b implements Continuation {

    /* renamed from: a  reason: collision with root package name */
    public static final b f18983a = new b();

    public f getContext() {
        throw new IllegalStateException("This continuation is already complete".toString());
    }

    public void resumeWith(Object obj) {
        throw new IllegalStateException("This continuation is already complete".toString());
    }

    public String toString() {
        return "This continuation is already complete";
    }
}
