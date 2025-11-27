package b1;

import a1.q;
import android.os.Handler;
import android.os.Looper;
import x.f;

public class a implements q {

    /* renamed from: a  reason: collision with root package name */
    public final Handler f4120a = f.a(Looper.getMainLooper());

    public void a(Runnable runnable) {
        this.f4120a.removeCallbacks(runnable);
    }

    public void b(long j10, Runnable runnable) {
        this.f4120a.postDelayed(runnable, j10);
    }
}
