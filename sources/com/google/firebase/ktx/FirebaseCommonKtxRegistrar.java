package com.google.firebase.ktx;

import androidx.annotation.Keep;
import ca.y;
import com.google.firebase.annotations.concurrent.Background;
import com.google.firebase.annotations.concurrent.Blocking;
import com.google.firebase.annotations.concurrent.Lightweight;
import com.google.firebase.annotations.concurrent.UiThread;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.firebase.components.Qualified;
import com.google.firebase.platforminfo.LibraryVersionComponent;
import i9.j;
import java.util.List;
import java.util.concurrent.Executor;
import t9.i;

@Keep
public final class FirebaseCommonKtxRegistrar implements ComponentRegistrar {
    public List<Component<?>> getComponents() {
        Class<Background> cls = Background.class;
        Class<y> cls2 = y.class;
        Class<Executor> cls3 = Executor.class;
        Component<y> build = Component.builder(Qualified.qualified(cls, cls2)).add(Dependency.required((Qualified<?>) Qualified.qualified(cls, cls3))).factory(FirebaseCommonKtxRegistrar$getComponents$$inlined$coroutineDispatcher$1.INSTANCE).build();
        i.f(build, "builder(Qualified.qualif…cher()\n    }\n    .build()");
        Class<Lightweight> cls4 = Lightweight.class;
        Component<Lightweight> build2 = Component.builder(Qualified.qualified(cls4, cls2)).add(Dependency.required((Qualified<?>) Qualified.qualified(cls4, cls3))).factory(FirebaseCommonKtxRegistrar$getComponents$$inlined$coroutineDispatcher$2.INSTANCE).build();
        i.f(build2, "builder(Qualified.qualif…cher()\n    }\n    .build()");
        Class<Blocking> cls5 = Blocking.class;
        Component<Blocking> build3 = Component.builder(Qualified.qualified(cls5, cls2)).add(Dependency.required((Qualified<?>) Qualified.qualified(cls5, cls3))).factory(FirebaseCommonKtxRegistrar$getComponents$$inlined$coroutineDispatcher$3.INSTANCE).build();
        i.f(build3, "builder(Qualified.qualif…cher()\n    }\n    .build()");
        Class<UiThread> cls6 = UiThread.class;
        Component<UiThread> build4 = Component.builder(Qualified.qualified(cls6, cls2)).add(Dependency.required((Qualified<?>) Qualified.qualified(cls6, cls3))).factory(FirebaseCommonKtxRegistrar$getComponents$$inlined$coroutineDispatcher$4.INSTANCE).build();
        i.f(build4, "builder(Qualified.qualif…cher()\n    }\n    .build()");
        return j.g(LibraryVersionComponent.create(FirebaseKt.LIBRARY_NAME, "20.3.1"), build, build2, build3, build4);
    }
}
