package k5;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.e;
import t9.i;
import u8.b;

public abstract class a extends b {

    /* renamed from: b  reason: collision with root package name */
    public boolean f17563b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f17564c;

    public final boolean P2() {
        if (getActivity() != null) {
            e activity = getActivity();
            i.d(activity);
            if (!activity.isFinishing()) {
                e activity2 = getActivity();
                i.d(activity2);
                if (activity2.isDestroyed() || !isAdded()) {
                    return false;
                }
                return true;
            }
        }
        return false;
    }

    public final boolean Q2() {
        return this.f17563b;
    }

    public final boolean R2() {
        if (!this.f17563b || !this.f17564c) {
            return false;
        }
        return true;
    }

    public final boolean S2() {
        return this.f17564c;
    }

    public abstract void T2();

    public void U2() {
    }

    public void V2() {
        if (this.f17563b && this.f17564c) {
            T2();
        }
    }

    public final void W2(boolean z10) {
        this.f17563b = z10;
    }

    public void onViewCreated(View view, Bundle bundle) {
        i.g(view, "view");
        super.onViewCreated(view, bundle);
        this.f17563b = true;
        if (this.f17564c) {
            T2();
        }
    }

    public void setUserVisibleHint(boolean z10) {
        super.setUserVisibleHint(z10);
        if (getUserVisibleHint()) {
            this.f17564c = true;
            V2();
            return;
        }
        this.f17564c = false;
        U2();
    }
}
