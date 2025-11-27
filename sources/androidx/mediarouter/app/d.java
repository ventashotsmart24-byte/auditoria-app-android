package androidx.mediarouter.app;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import n0.s0;

public class d extends androidx.fragment.app.d {

    /* renamed from: a  reason: collision with root package name */
    public boolean f2579a = false;

    /* renamed from: b  reason: collision with root package name */
    public Dialog f2580b;

    /* renamed from: c  reason: collision with root package name */
    public s0 f2581c;

    public d() {
        setCancelable(true);
    }

    public final void Q2() {
        if (this.f2581c == null) {
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.f2581c = s0.d(arguments.getBundle("selector"));
            }
            if (this.f2581c == null) {
                this.f2581c = s0.f8047c;
            }
        }
    }

    public c R2(Context context, Bundle bundle) {
        return new c(context);
    }

    public h S2(Context context) {
        return new h(context);
    }

    public void T2(s0 s0Var) {
        if (s0Var != null) {
            Q2();
            if (!this.f2581c.equals(s0Var)) {
                this.f2581c = s0Var;
                Bundle arguments = getArguments();
                if (arguments == null) {
                    arguments = new Bundle();
                }
                arguments.putBundle("selector", s0Var.a());
                setArguments(arguments);
                Dialog dialog = this.f2580b;
                if (dialog != null && this.f2579a) {
                    ((h) dialog).j(s0Var);
                    return;
                }
                return;
            }
            return;
        }
        throw new IllegalArgumentException("selector must not be null");
    }

    public void U2(boolean z10) {
        if (this.f2580b == null) {
            this.f2579a = z10;
            return;
        }
        throw new IllegalStateException("This must be called before creating dialog");
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        Dialog dialog = this.f2580b;
        if (dialog == null) {
            return;
        }
        if (this.f2579a) {
            ((h) dialog).l();
        } else {
            ((c) dialog).A();
        }
    }

    public Dialog onCreateDialog(Bundle bundle) {
        if (this.f2579a) {
            h S2 = S2(getContext());
            this.f2580b = S2;
            S2.j(this.f2581c);
        } else {
            this.f2580b = R2(getContext(), bundle);
        }
        return this.f2580b;
    }

    public void onStop() {
        super.onStop();
        Dialog dialog = this.f2580b;
        if (dialog != null && !this.f2579a) {
            ((c) dialog).e(false);
        }
    }
}
