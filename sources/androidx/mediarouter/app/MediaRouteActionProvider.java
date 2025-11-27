package androidx.mediarouter.app;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import b0.b;
import java.lang.ref.WeakReference;
import n0.s0;
import n0.t0;

public class MediaRouteActionProvider extends b {

    /* renamed from: d  reason: collision with root package name */
    public final t0 f2423d;

    /* renamed from: e  reason: collision with root package name */
    public final a f2424e;

    /* renamed from: f  reason: collision with root package name */
    public s0 f2425f = s0.f8047c;

    /* renamed from: g  reason: collision with root package name */
    public e f2426g = e.a();

    /* renamed from: h  reason: collision with root package name */
    public MediaRouteButton f2427h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f2428i;

    public static final class a extends t0.b {

        /* renamed from: a  reason: collision with root package name */
        public final WeakReference f2429a;

        public a(MediaRouteActionProvider mediaRouteActionProvider) {
            this.f2429a = new WeakReference(mediaRouteActionProvider);
        }

        public final void a(t0 t0Var) {
            MediaRouteActionProvider mediaRouteActionProvider = (MediaRouteActionProvider) this.f2429a.get();
            if (mediaRouteActionProvider != null) {
                mediaRouteActionProvider.n();
            } else {
                t0Var.q(this);
            }
        }

        public void onProviderAdded(t0 t0Var, t0.h hVar) {
            a(t0Var);
        }

        public void onProviderChanged(t0 t0Var, t0.h hVar) {
            a(t0Var);
        }

        public void onProviderRemoved(t0 t0Var, t0.h hVar) {
            a(t0Var);
        }

        public void onRouteAdded(t0 t0Var, t0.i iVar) {
            a(t0Var);
        }

        public void onRouteChanged(t0 t0Var, t0.i iVar) {
            a(t0Var);
        }

        public void onRouteRemoved(t0 t0Var, t0.i iVar) {
            a(t0Var);
        }
    }

    public MediaRouteActionProvider(Context context) {
        super(context);
        this.f2423d = t0.i(context);
        this.f2424e = new a(this);
    }

    public boolean c() {
        if (this.f2428i || this.f2423d.o(this.f2425f, 1)) {
            return true;
        }
        return false;
    }

    public View d() {
        if (this.f2427h != null) {
            Log.e("MRActionProvider", "onCreateActionView: this ActionProvider is already associated with a menu item. Don't reuse MediaRouteActionProvider instances! Abandoning the old menu item...");
        }
        MediaRouteButton m10 = m();
        this.f2427h = m10;
        m10.setCheatSheetEnabled(true);
        this.f2427h.setRouteSelector(this.f2425f);
        this.f2427h.setAlwaysVisible(this.f2428i);
        this.f2427h.setDialogFactory(this.f2426g);
        this.f2427h.setLayoutParams(new ViewGroup.LayoutParams(-2, -1));
        return this.f2427h;
    }

    public boolean f() {
        MediaRouteButton mediaRouteButton = this.f2427h;
        if (mediaRouteButton != null) {
            return mediaRouteButton.d();
        }
        return false;
    }

    public boolean h() {
        return true;
    }

    public MediaRouteButton m() {
        return new MediaRouteButton(a());
    }

    public void n() {
        i();
    }

    public void o(s0 s0Var) {
        if (s0Var == null) {
            throw new IllegalArgumentException("selector must not be null");
        } else if (!this.f2425f.equals(s0Var)) {
            if (!this.f2425f.f()) {
                this.f2423d.q(this.f2424e);
            }
            if (!s0Var.f()) {
                this.f2423d.a(s0Var, this.f2424e);
            }
            this.f2425f = s0Var;
            n();
            MediaRouteButton mediaRouteButton = this.f2427h;
            if (mediaRouteButton != null) {
                mediaRouteButton.setRouteSelector(s0Var);
            }
        }
    }
}
