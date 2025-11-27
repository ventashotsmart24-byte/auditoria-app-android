package n0;

import java.util.concurrent.Executor;
import n0.t0;

public final /* synthetic */ class v0 implements Executor {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ t0.e.c f8168a;

    public /* synthetic */ v0(t0.e.c cVar) {
        this.f8168a = cVar;
    }

    public final void execute(Runnable runnable) {
        this.f8168a.post(runnable);
    }
}
