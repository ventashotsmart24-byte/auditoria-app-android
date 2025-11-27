package com.google.firebase.ktx;

import android.content.Context;
import ca.y;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.components.Component;
import com.google.firebase.components.Dependency;
import com.google.firebase.components.Qualified;
import com.umeng.analytics.pro.f;
import java.lang.annotation.Annotation;
import java.util.concurrent.Executor;
import t9.i;

public final class FirebaseKt {
    public static final String LIBRARY_NAME = "fire-core-ktx";

    public static final FirebaseApp app(Firebase firebase, String str) {
        i.g(firebase, "<this>");
        i.g(str, "name");
        FirebaseApp instance = FirebaseApp.getInstance(str);
        i.f(instance, "getInstance(name)");
        return instance;
    }

    private static final /* synthetic */ <T extends Annotation> Component<y> coroutineDispatcher() {
        i.l(4, "T");
        Class<Annotation> cls = Annotation.class;
        Component.Builder<Annotation> builder = Component.builder(Qualified.qualified(cls, y.class));
        i.l(4, "T");
        Component.Builder<Annotation> add = builder.add(Dependency.required((Qualified<?>) Qualified.qualified(cls, Executor.class)));
        i.k();
        Component<Annotation> build = add.factory(FirebaseKt$coroutineDispatcher$1.INSTANCE).build();
        i.f(build, "builder(Qualified.qualif…cher()\n    }\n    .build()");
        return build;
    }

    public static final FirebaseApp getApp(Firebase firebase) {
        i.g(firebase, "<this>");
        FirebaseApp instance = FirebaseApp.getInstance();
        i.f(instance, "getInstance()");
        return instance;
    }

    public static final FirebaseOptions getOptions(Firebase firebase) {
        i.g(firebase, "<this>");
        FirebaseOptions options = getApp(Firebase.INSTANCE).getOptions();
        i.f(options, "Firebase.app.options");
        return options;
    }

    public static final FirebaseApp initialize(Firebase firebase, Context context) {
        i.g(firebase, "<this>");
        i.g(context, f.X);
        return FirebaseApp.initializeApp(context);
    }

    public static final FirebaseApp initialize(Firebase firebase, Context context, FirebaseOptions firebaseOptions) {
        i.g(firebase, "<this>");
        i.g(context, f.X);
        i.g(firebaseOptions, "options");
        FirebaseApp initializeApp = FirebaseApp.initializeApp(context, firebaseOptions);
        i.f(initializeApp, "initializeApp(context, options)");
        return initializeApp;
    }

    public static final FirebaseApp initialize(Firebase firebase, Context context, FirebaseOptions firebaseOptions, String str) {
        i.g(firebase, "<this>");
        i.g(context, f.X);
        i.g(firebaseOptions, "options");
        i.g(str, "name");
        FirebaseApp initializeApp = FirebaseApp.initializeApp(context, firebaseOptions, str);
        i.f(initializeApp, "initializeApp(context, options, name)");
        return initializeApp;
    }
}
