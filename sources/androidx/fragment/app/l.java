package androidx.fragment.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import o.h;
import p.a;

public abstract class l extends g {

    /* renamed from: a  reason: collision with root package name */
    public final Activity f2065a;

    /* renamed from: b  reason: collision with root package name */
    public final Context f2066b;

    /* renamed from: c  reason: collision with root package name */
    public final Handler f2067c;

    /* renamed from: d  reason: collision with root package name */
    public final int f2068d;

    /* renamed from: e  reason: collision with root package name */
    public final o f2069e;

    public l(e eVar) {
        this(eVar, eVar, new Handler(), 0);
    }

    /* access modifiers changed from: package-private */
    public Activity e() {
        return this.f2065a;
    }

    /* access modifiers changed from: package-private */
    public Context f() {
        return this.f2066b;
    }

    /* access modifiers changed from: package-private */
    public Handler g() {
        return this.f2067c;
    }

    public abstract void h(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    public abstract Object i();

    public abstract LayoutInflater j();

    public void k(Fragment fragment, String[] strArr, int i10) {
    }

    public abstract boolean l(Fragment fragment);

    public abstract boolean m(String str);

    public void n(Fragment fragment, Intent intent, int i10, Bundle bundle) {
        if (i10 == -1) {
            a.startActivity(this.f2066b, intent, bundle);
            return;
        }
        throw new IllegalStateException("Starting activity with a requestCode requires a FragmentActivity host");
    }

    public void o(Fragment fragment, IntentSender intentSender, int i10, Intent intent, int i11, int i12, int i13, Bundle bundle) {
        if (i10 == -1) {
            h.k(this.f2065a, intentSender, i10, intent, i11, i12, i13, bundle);
        } else {
            throw new IllegalStateException("Starting intent sender with a requestCode requires a FragmentActivity host");
        }
    }

    public abstract void p();

    public l(Activity activity, Context context, Handler handler, int i10) {
        this.f2069e = new p();
        this.f2065a = activity;
        this.f2066b = (Context) a0.h.e(context, "context == null");
        this.f2067c = (Handler) a0.h.e(handler, "handler == null");
        this.f2068d = i10;
    }
}
