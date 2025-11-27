package com.google.firebase.ktx;

import ca.y;
import ca.y0;
import com.google.firebase.annotations.concurrent.Blocking;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.components.Qualified;
import java.util.concurrent.Executor;
import t9.i;

public final class FirebaseCommonKtxRegistrar$getComponents$$inlined$coroutineDispatcher$3<T> implements ComponentFactory {
    public static final FirebaseCommonKtxRegistrar$getComponents$$inlined$coroutineDispatcher$3<T> INSTANCE = new FirebaseCommonKtxRegistrar$getComponents$$inlined$coroutineDispatcher$3<>();

    public final y create(ComponentContainer componentContainer) {
        Object obj = componentContainer.get(Qualified.qualified(Blocking.class, Executor.class));
        i.f(obj, "c.get(Qualified.qualifie…a, Executor::class.java))");
        return y0.a((Executor) obj);
    }
}
