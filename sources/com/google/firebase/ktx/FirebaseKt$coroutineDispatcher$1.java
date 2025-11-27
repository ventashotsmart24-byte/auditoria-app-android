package com.google.firebase.ktx;

import ca.y;
import ca.y0;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.components.Qualified;
import java.lang.annotation.Annotation;
import java.util.concurrent.Executor;
import t9.i;

public final class FirebaseKt$coroutineDispatcher$1<T> implements ComponentFactory {
    public static final FirebaseKt$coroutineDispatcher$1<T> INSTANCE = new FirebaseKt$coroutineDispatcher$1<>();

    public final y create(ComponentContainer componentContainer) {
        i.l(4, "T");
        Object obj = componentContainer.get(Qualified.qualified(Annotation.class, Executor.class));
        i.f(obj, "c.get(Qualified.qualifie…a, Executor::class.java))");
        return y0.a((Executor) obj);
    }
}
