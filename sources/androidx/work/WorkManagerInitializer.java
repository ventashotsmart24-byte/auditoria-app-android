package androidx.work;

import a1.k;
import a1.t;
import android.content.Context;
import androidx.work.a;
import java.util.Collections;
import java.util.List;
import v0.b;

public final class WorkManagerInitializer implements b {

    /* renamed from: a  reason: collision with root package name */
    public static final String f3341a = k.f("WrkMgrInitializer");

    /* renamed from: b */
    public t a(Context context) {
        k.c().a(f3341a, "Initializing WorkManager with default configuration.", new Throwable[0]);
        t.d(context, new a.b().a());
        return t.c(context);
    }

    public List dependencies() {
        return Collections.emptyList();
    }
}
