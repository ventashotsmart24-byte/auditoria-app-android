package kotlin.coroutines;

import k9.f;

public interface Continuation<T> {
    f getContext();

    void resumeWith(Object obj);
}
