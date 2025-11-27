package androidx.mediarouter.app;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import androidx.fragment.app.d;
import n0.s0;

public class b extends d {

    /* renamed from: a  reason: collision with root package name */
    public boolean f2500a = false;

    /* renamed from: b  reason: collision with root package name */
    public Dialog f2501b;

    /* renamed from: c  reason: collision with root package name */
    public s0 f2502c;

    public b() {
        setCancelable(true);
    }

    public final void Q2() {
        if (this.f2502c == null) {
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.f2502c = s0.d(arguments.getBundle("selector"));
            }
            if (this.f2502c == null) {
                this.f2502c = s0.f8047c;
            }
        }
    }

    public s0 R2() {
        Q2();
        return this.f2502c;
    }

    public a S2(Context context, Bundle bundle) {
        return new a(context);
    }

    public g T2(Context context) {
        return new g(context);
    }

    public void U2(s0 s0Var) {
        if (s0Var != null) {
            Q2();
            if (!this.f2502c.equals(s0Var)) {
                this.f2502c = s0Var;
                Bundle arguments = getArguments();
                if (arguments == null) {
                    arguments = new Bundle();
                }
                arguments.putBundle("selector", s0Var.a());
                setArguments(arguments);
                Dialog dialog = this.f2501b;
                if (dialog == null) {
                    return;
                }
                if (this.f2500a) {
                    ((g) dialog).d(s0Var);
                } else {
                    ((a) dialog).d(s0Var);
                }
            }
        } else {
            throw new IllegalArgumentException("selector must not be null");
        }
    }

    public void V2(boolean z10) {
        if (this.f2501b == null) {
            this.f2500a = z10;
            return;
        }
        throw new IllegalStateException("This must be called before creating dialog");
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        Dialog dialog = this.f2501b;
        if (dialog != null) {
            if (this.f2500a) {
                ((g) dialog).e();
            } else {
                ((a) dialog).e();
            }
        }
    }

    public Dialog onCreateDialog(Bundle bundle) {
        if (this.f2500a) {
            g T2 = T2(getContext());
            this.f2501b = T2;
            T2.d(R2());
        } else {
            a S2 = S2(getContext(), bundle);
            this.f2501b = S2;
            S2.d(R2());
        }
        return this.f2501b;
    }
}
