package androidx.transition;

import android.view.View;
import android.view.WindowId;

public class q0 implements r0 {

    /* renamed from: a  reason: collision with root package name */
    public final WindowId f3259a;

    public q0(View view) {
        this.f3259a = view.getWindowId();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof q0) || !((q0) obj).f3259a.equals(this.f3259a)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.f3259a.hashCode();
    }
}
