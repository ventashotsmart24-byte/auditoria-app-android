package n0;

import android.os.Handler;
import java.util.concurrent.Executor;

public final /* synthetic */ class c0 implements Executor {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Handler f7921a;

    public /* synthetic */ c0(Handler handler) {
        this.f7921a = handler;
    }

    public final void execute(Runnable runnable) {
        this.f7921a.post(runnable);
    }
}
