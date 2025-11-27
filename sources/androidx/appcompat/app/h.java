package androidx.appcompat.app;

import android.app.Activity;
import android.app.Dialog;
import android.app.UiModeManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$color;
import androidx.appcompat.R$id;
import androidx.appcompat.R$layout;
import androidx.appcompat.R$style;
import androidx.appcompat.R$styleable;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ContentFrameLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.h1;
import androidx.appcompat.widget.r2;
import androidx.appcompat.widget.s1;
import androidx.appcompat.widget.x2;
import androidx.appcompat.widget.y2;
import androidx.lifecycle.d;
import b0.a2;
import b0.b0;
import b0.b2;
import b0.c1;
import b0.c2;
import b0.f2;
import b0.k;
import g.b;
import g.f;
import java.lang.Thread;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;

public class h extends f implements g.a, LayoutInflater.Factory2 {

    /* renamed from: j0  reason: collision with root package name */
    public static final Map f654j0 = new androidx.collection.a();

    /* renamed from: k0  reason: collision with root package name */
    public static final boolean f655k0;

    /* renamed from: l0  reason: collision with root package name */
    public static final int[] f656l0 = {16842836};

    /* renamed from: m0  reason: collision with root package name */
    public static boolean f657m0 = true;

    /* renamed from: n0  reason: collision with root package name */
    public static final boolean f658n0;
    public boolean A;
    public boolean B;
    public boolean C;
    public boolean D;
    public boolean E;
    public boolean F;
    public p[] G;
    public p H;
    public boolean I;
    public boolean J;
    public boolean K;
    public boolean L;
    public boolean M;
    public int N;
    public int O;
    public boolean Q;
    public boolean S;
    public m V;
    public m W;
    public boolean X;
    public int Y;
    public final Runnable Z;

    /* renamed from: d  reason: collision with root package name */
    public final Object f659d;

    /* renamed from: e  reason: collision with root package name */
    public final Context f660e;

    /* renamed from: f  reason: collision with root package name */
    public Window f661f;

    /* renamed from: f0  reason: collision with root package name */
    public boolean f662f0;

    /* renamed from: g  reason: collision with root package name */
    public k f663g;

    /* renamed from: g0  reason: collision with root package name */
    public Rect f664g0;

    /* renamed from: h  reason: collision with root package name */
    public final e f665h;

    /* renamed from: h0  reason: collision with root package name */
    public Rect f666h0;

    /* renamed from: i  reason: collision with root package name */
    public a f667i;

    /* renamed from: i0  reason: collision with root package name */
    public AppCompatViewInflater f668i0;

    /* renamed from: j  reason: collision with root package name */
    public MenuInflater f669j;

    /* renamed from: k  reason: collision with root package name */
    public CharSequence f670k;

    /* renamed from: l  reason: collision with root package name */
    public h1 f671l;

    /* renamed from: m  reason: collision with root package name */
    public i f672m;

    /* renamed from: n  reason: collision with root package name */
    public q f673n;

    /* renamed from: o  reason: collision with root package name */
    public g.b f674o;

    /* renamed from: p  reason: collision with root package name */
    public ActionBarContextView f675p;

    /* renamed from: q  reason: collision with root package name */
    public PopupWindow f676q;

    /* renamed from: r  reason: collision with root package name */
    public Runnable f677r;

    /* renamed from: s  reason: collision with root package name */
    public a2 f678s;

    /* renamed from: t  reason: collision with root package name */
    public boolean f679t;

    /* renamed from: u  reason: collision with root package name */
    public boolean f680u;

    /* renamed from: v  reason: collision with root package name */
    public ViewGroup f681v;

    /* renamed from: w  reason: collision with root package name */
    public TextView f682w;

    /* renamed from: x  reason: collision with root package name */
    public View f683x;

    /* renamed from: y  reason: collision with root package name */
    public boolean f684y;

    /* renamed from: z  reason: collision with root package name */
    public boolean f685z;

    public static class a implements Thread.UncaughtExceptionHandler {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Thread.UncaughtExceptionHandler f686a;

        public a(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
            this.f686a = uncaughtExceptionHandler;
        }

        public final boolean a(Throwable th) {
            String message;
            if (!(th instanceof Resources.NotFoundException) || (message = th.getMessage()) == null) {
                return false;
            }
            if (message.contains("drawable") || message.contains("Drawable")) {
                return true;
            }
            return false;
        }

        public void uncaughtException(Thread thread, Throwable th) {
            if (a(th)) {
                Resources.NotFoundException notFoundException = new Resources.NotFoundException(th.getMessage() + ". If the resource you are trying to use is a vector resource, you may be referencing it in an unsupported way. See AppCompatDelegate.setCompatVectorFromResourcesEnabled() for more info.");
                notFoundException.initCause(th.getCause());
                notFoundException.setStackTrace(th.getStackTrace());
                this.f686a.uncaughtException(thread, notFoundException);
                return;
            }
            this.f686a.uncaughtException(thread, th);
        }
    }

    public class b implements Runnable {
        public b() {
        }

        public void run() {
            h hVar = h.this;
            if ((hVar.Y & 1) != 0) {
                hVar.T(0);
            }
            h hVar2 = h.this;
            if ((hVar2.Y & 4096) != 0) {
                hVar2.T(108);
            }
            h hVar3 = h.this;
            hVar3.X = false;
            hVar3.Y = 0;
        }
    }

    public class c implements b0 {
        public c() {
        }

        public f2 onApplyWindowInsets(View view, f2 f2Var) {
            int k10 = f2Var.k();
            int I0 = h.this.I0(k10);
            if (k10 != I0) {
                f2Var = f2Var.n(f2Var.i(), I0, f2Var.j(), f2Var.h());
            }
            return c1.X(view, f2Var);
        }
    }

    public class d implements s1.a {
        public d() {
        }

        public void a(Rect rect) {
            rect.top = h.this.I0(rect.top);
        }
    }

    public class e implements ContentFrameLayout.a {
        public e() {
        }

        public void a() {
        }

        public void onDetachedFromWindow() {
            h.this.R();
        }
    }

    public class f implements Runnable {

        public class a extends c2 {
            public a() {
            }

            public void b(View view) {
                h.this.f675p.setAlpha(1.0f);
                h.this.f678s.f((b2) null);
                h.this.f678s = null;
            }

            public void c(View view) {
                h.this.f675p.setVisibility(0);
            }
        }

        public f() {
        }

        public void run() {
            h hVar = h.this;
            hVar.f676q.showAtLocation(hVar.f675p, 55, 0, 0);
            h.this.U();
            if (h.this.B0()) {
                h.this.f675p.setAlpha(0.0f);
                h hVar2 = h.this;
                hVar2.f678s = c1.c(hVar2.f675p).a(1.0f);
                h.this.f678s.f(new a());
                return;
            }
            h.this.f675p.setAlpha(1.0f);
            h.this.f675p.setVisibility(0);
        }
    }

    public class g extends c2 {
        public g() {
        }

        public void b(View view) {
            h.this.f675p.setAlpha(1.0f);
            h.this.f678s.f((b2) null);
            h.this.f678s = null;
        }

        public void c(View view) {
            h.this.f675p.setVisibility(0);
            h.this.f675p.sendAccessibilityEvent(32);
            if (h.this.f675p.getParent() instanceof View) {
                c1.h0((View) h.this.f675p.getParent());
            }
        }
    }

    /* renamed from: androidx.appcompat.app.h$h  reason: collision with other inner class name */
    public class C0013h implements b {
        public C0013h() {
        }
    }

    public final class i implements m.a {
        public i() {
        }

        public boolean a(androidx.appcompat.view.menu.g gVar) {
            Window.Callback d02 = h.this.d0();
            if (d02 == null) {
                return true;
            }
            d02.onMenuOpened(108, gVar);
            return true;
        }

        public void onCloseMenu(androidx.appcompat.view.menu.g gVar, boolean z10) {
            h.this.L(gVar);
        }
    }

    public class j implements b.a {

        /* renamed from: a  reason: collision with root package name */
        public b.a f696a;

        public class a extends c2 {
            public a() {
            }

            public void b(View view) {
                h.this.f675p.setVisibility(8);
                h hVar = h.this;
                PopupWindow popupWindow = hVar.f676q;
                if (popupWindow != null) {
                    popupWindow.dismiss();
                } else if (hVar.f675p.getParent() instanceof View) {
                    c1.h0((View) h.this.f675p.getParent());
                }
                h.this.f675p.removeAllViews();
                h.this.f678s.f((b2) null);
                h.this.f678s = null;
            }
        }

        public j(b.a aVar) {
            this.f696a = aVar;
        }

        public boolean a(g.b bVar, MenuItem menuItem) {
            return this.f696a.a(bVar, menuItem);
        }

        public void b(g.b bVar) {
            this.f696a.b(bVar);
            h hVar = h.this;
            if (hVar.f676q != null) {
                hVar.f661f.getDecorView().removeCallbacks(h.this.f677r);
            }
            h hVar2 = h.this;
            if (hVar2.f675p != null) {
                hVar2.U();
                h hVar3 = h.this;
                hVar3.f678s = c1.c(hVar3.f675p).a(0.0f);
                h.this.f678s.f(new a());
            }
            h hVar4 = h.this;
            e eVar = hVar4.f665h;
            if (eVar != null) {
                eVar.onSupportActionModeFinished(hVar4.f674o);
            }
            h.this.f674o = null;
        }

        public boolean c(g.b bVar, Menu menu) {
            return this.f696a.c(bVar, menu);
        }

        public boolean d(g.b bVar, Menu menu) {
            return this.f696a.d(bVar, menu);
        }
    }

    public class l extends m {

        /* renamed from: c  reason: collision with root package name */
        public final PowerManager f700c;

        public l(Context context) {
            super();
            this.f700c = (PowerManager) context.getSystemService("power");
        }

        public IntentFilter b() {
            if (Build.VERSION.SDK_INT < 21) {
                return null;
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.os.action.POWER_SAVE_MODE_CHANGED");
            return intentFilter;
        }

        public int c() {
            if (Build.VERSION.SDK_INT < 21 || !this.f700c.isPowerSaveMode()) {
                return 1;
            }
            return 2;
        }

        public void d() {
            h.this.F();
        }
    }

    public abstract class m {

        /* renamed from: a  reason: collision with root package name */
        public BroadcastReceiver f702a;

        public class a extends BroadcastReceiver {
            public a() {
            }

            public void onReceive(Context context, Intent intent) {
                m.this.d();
            }
        }

        public m() {
        }

        public void a() {
            BroadcastReceiver broadcastReceiver = this.f702a;
            if (broadcastReceiver != null) {
                try {
                    h.this.f660e.unregisterReceiver(broadcastReceiver);
                } catch (IllegalArgumentException unused) {
                }
                this.f702a = null;
            }
        }

        public abstract IntentFilter b();

        public abstract int c();

        public abstract void d();

        public void e() {
            a();
            IntentFilter b10 = b();
            if (b10 != null && b10.countActions() != 0) {
                if (this.f702a == null) {
                    this.f702a = new a();
                }
                h.this.f660e.registerReceiver(this.f702a, b10);
            }
        }
    }

    public class n extends m {

        /* renamed from: c  reason: collision with root package name */
        public final p f705c;

        public n(p pVar) {
            super();
            this.f705c = pVar;
        }

        public IntentFilter b() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.TIME_SET");
            intentFilter.addAction("android.intent.action.TIMEZONE_CHANGED");
            intentFilter.addAction("android.intent.action.TIME_TICK");
            return intentFilter;
        }

        public int c() {
            if (this.f705c.d()) {
                return 2;
            }
            return 1;
        }

        public void d() {
            h.this.F();
        }
    }

    public class o extends ContentFrameLayout {
        public o(Context context) {
            super(context);
        }

        public final boolean c(int i10, int i11) {
            if (i10 < -5 || i11 < -5 || i10 > getWidth() + 5 || i11 > getHeight() + 5) {
                return true;
            }
            return false;
        }

        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            if (h.this.S(keyEvent) || super.dispatchKeyEvent(keyEvent)) {
                return true;
            }
            return false;
        }

        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            if (motionEvent.getAction() != 0 || !c((int) motionEvent.getX(), (int) motionEvent.getY())) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            h.this.N(0);
            return true;
        }

        public void setBackgroundResource(int i10) {
            setBackgroundDrawable(d.b.d(getContext(), i10));
        }
    }

    public static final class p {

        /* renamed from: a  reason: collision with root package name */
        public int f708a;

        /* renamed from: b  reason: collision with root package name */
        public int f709b;

        /* renamed from: c  reason: collision with root package name */
        public int f710c;

        /* renamed from: d  reason: collision with root package name */
        public int f711d;

        /* renamed from: e  reason: collision with root package name */
        public int f712e;

        /* renamed from: f  reason: collision with root package name */
        public int f713f;

        /* renamed from: g  reason: collision with root package name */
        public ViewGroup f714g;

        /* renamed from: h  reason: collision with root package name */
        public View f715h;

        /* renamed from: i  reason: collision with root package name */
        public View f716i;

        /* renamed from: j  reason: collision with root package name */
        public androidx.appcompat.view.menu.g f717j;

        /* renamed from: k  reason: collision with root package name */
        public androidx.appcompat.view.menu.e f718k;

        /* renamed from: l  reason: collision with root package name */
        public Context f719l;

        /* renamed from: m  reason: collision with root package name */
        public boolean f720m;

        /* renamed from: n  reason: collision with root package name */
        public boolean f721n;

        /* renamed from: o  reason: collision with root package name */
        public boolean f722o;

        /* renamed from: p  reason: collision with root package name */
        public boolean f723p;

        /* renamed from: q  reason: collision with root package name */
        public boolean f724q = false;

        /* renamed from: r  reason: collision with root package name */
        public boolean f725r;

        /* renamed from: s  reason: collision with root package name */
        public Bundle f726s;

        public p(int i10) {
            this.f708a = i10;
        }

        public androidx.appcompat.view.menu.n a(m.a aVar) {
            if (this.f717j == null) {
                return null;
            }
            if (this.f718k == null) {
                androidx.appcompat.view.menu.e eVar = new androidx.appcompat.view.menu.e(this.f719l, R$layout.abc_list_menu_item_layout);
                this.f718k = eVar;
                eVar.setCallback(aVar);
                this.f717j.addMenuPresenter(this.f718k);
            }
            return this.f718k.b(this.f714g);
        }

        public boolean b() {
            if (this.f715h == null) {
                return false;
            }
            if (this.f716i == null && this.f718k.a().getCount() <= 0) {
                return false;
            }
            return true;
        }

        public void c(androidx.appcompat.view.menu.g gVar) {
            androidx.appcompat.view.menu.e eVar;
            androidx.appcompat.view.menu.g gVar2 = this.f717j;
            if (gVar != gVar2) {
                if (gVar2 != null) {
                    gVar2.removeMenuPresenter(this.f718k);
                }
                this.f717j = gVar;
                if (gVar != null && (eVar = this.f718k) != null) {
                    gVar.addMenuPresenter(eVar);
                }
            }
        }

        public void d(Context context) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme newTheme = context.getResources().newTheme();
            newTheme.setTo(context.getTheme());
            newTheme.resolveAttribute(R$attr.actionBarPopupTheme, typedValue, true);
            int i10 = typedValue.resourceId;
            if (i10 != 0) {
                newTheme.applyStyle(i10, true);
            }
            newTheme.resolveAttribute(R$attr.panelMenuListTheme, typedValue, true);
            int i11 = typedValue.resourceId;
            if (i11 != 0) {
                newTheme.applyStyle(i11, true);
            } else {
                newTheme.applyStyle(R$style.Theme_AppCompat_CompactMenu, true);
            }
            g.d dVar = new g.d(context, 0);
            dVar.getTheme().setTo(newTheme);
            this.f719l = dVar;
            TypedArray obtainStyledAttributes = dVar.obtainStyledAttributes(R$styleable.f554o);
            this.f709b = obtainStyledAttributes.getResourceId(R$styleable.AppCompatTheme_panelBackground, 0);
            this.f713f = obtainStyledAttributes.getResourceId(R$styleable.AppCompatTheme_android_windowAnimationStyle, 0);
            obtainStyledAttributes.recycle();
        }
    }

    public final class q implements m.a {
        public q() {
        }

        public boolean a(androidx.appcompat.view.menu.g gVar) {
            Window.Callback d02;
            if (gVar != null) {
                return true;
            }
            h hVar = h.this;
            if (!hVar.A || (d02 = hVar.d0()) == null || h.this.M) {
                return true;
            }
            d02.onMenuOpened(108, gVar);
            return true;
        }

        public void onCloseMenu(androidx.appcompat.view.menu.g gVar, boolean z10) {
            boolean z11;
            androidx.appcompat.view.menu.g rootMenu = gVar.getRootMenu();
            if (rootMenu != gVar) {
                z11 = true;
            } else {
                z11 = false;
            }
            h hVar = h.this;
            if (z11) {
                gVar = rootMenu;
            }
            p X = hVar.X(gVar);
            if (X == null) {
                return;
            }
            if (z11) {
                h.this.K(X.f708a, X, rootMenu);
                h.this.O(X, true);
                return;
            }
            h.this.O(X, z10);
        }
    }

    static {
        boolean z10;
        int i10 = Build.VERSION.SDK_INT;
        boolean z11 = false;
        if (i10 < 21) {
            z10 = true;
        } else {
            z10 = false;
        }
        f655k0 = z10;
        if (i10 >= 21 && i10 <= 25) {
            z11 = true;
        }
        f658n0 = z11;
        if (z10 && !f657m0) {
            Thread.setDefaultUncaughtExceptionHandler(new a(Thread.getDefaultUncaughtExceptionHandler()));
        }
    }

    public h(Activity activity, e eVar) {
        this(activity, (Window) null, eVar, activity);
    }

    public void A(View view, ViewGroup.LayoutParams layoutParams) {
        V();
        ViewGroup viewGroup = (ViewGroup) this.f681v.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        this.f663g.a().onContentChanged();
    }

    public final int A0(int i10) {
        if (i10 == 8) {
            return 108;
        }
        if (i10 == 9) {
            return 109;
        }
        return i10;
    }

    public void B(Toolbar toolbar) {
        if (this.f659d instanceof Activity) {
            a j10 = j();
            if (!(j10 instanceof q)) {
                this.f669j = null;
                if (j10 != null) {
                    j10.n();
                }
                if (toolbar != null) {
                    n nVar = new n(toolbar, c0(), this.f663g);
                    this.f667i = nVar;
                    this.f661f.setCallback(nVar.A());
                } else {
                    this.f667i = null;
                    this.f661f.setCallback(this.f663g);
                }
                l();
                return;
            }
            throw new IllegalStateException("This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_SUPPORT_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.");
        }
    }

    public final boolean B0() {
        ViewGroup viewGroup;
        if (!this.f680u || (viewGroup = this.f681v) == null || !c1.Q(viewGroup)) {
            return false;
        }
        return true;
    }

    public void C(int i10) {
        this.O = i10;
    }

    public final boolean C0(ViewParent viewParent) {
        if (viewParent == null) {
            return false;
        }
        View decorView = this.f661f.getDecorView();
        while (viewParent != null) {
            if (viewParent == decorView || !(viewParent instanceof View) || c1.P((View) viewParent)) {
                return false;
            }
            viewParent = viewParent.getParent();
        }
        return true;
    }

    public final void D(CharSequence charSequence) {
        this.f670k = charSequence;
        h1 h1Var = this.f671l;
        if (h1Var != null) {
            h1Var.setWindowTitle(charSequence);
        } else if (w0() != null) {
            w0().x(charSequence);
        } else {
            TextView textView = this.f682w;
            if (textView != null) {
                textView.setText(charSequence);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0026  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x002a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public g.b D0(g.b.a r8) {
        /*
            r7 = this;
            r7.U()
            g.b r0 = r7.f674o
            if (r0 == 0) goto L_0x000a
            r0.a()
        L_0x000a:
            boolean r0 = r8 instanceof androidx.appcompat.app.h.j
            if (r0 != 0) goto L_0x0014
            androidx.appcompat.app.h$j r0 = new androidx.appcompat.app.h$j
            r0.<init>(r8)
            r8 = r0
        L_0x0014:
            androidx.appcompat.app.e r0 = r7.f665h
            r1 = 0
            if (r0 == 0) goto L_0x0023
            boolean r2 = r7.M
            if (r2 != 0) goto L_0x0023
            g.b r0 = r0.onWindowStartingSupportActionMode(r8)     // Catch:{ AbstractMethodError -> 0x0022 }
            goto L_0x0024
        L_0x0022:
        L_0x0023:
            r0 = r1
        L_0x0024:
            if (r0 == 0) goto L_0x002a
            r7.f674o = r0
            goto L_0x0163
        L_0x002a:
            androidx.appcompat.widget.ActionBarContextView r0 = r7.f675p
            r2 = 0
            r3 = 1
            if (r0 != 0) goto L_0x00d5
            boolean r0 = r7.D
            if (r0 == 0) goto L_0x00b6
            android.util.TypedValue r0 = new android.util.TypedValue
            r0.<init>()
            android.content.Context r4 = r7.f660e
            android.content.res.Resources$Theme r4 = r4.getTheme()
            int r5 = androidx.appcompat.R$attr.actionBarTheme
            r4.resolveAttribute(r5, r0, r3)
            int r5 = r0.resourceId
            if (r5 == 0) goto L_0x0069
            android.content.Context r5 = r7.f660e
            android.content.res.Resources r5 = r5.getResources()
            android.content.res.Resources$Theme r5 = r5.newTheme()
            r5.setTo(r4)
            int r4 = r0.resourceId
            r5.applyStyle(r4, r3)
            g.d r4 = new g.d
            android.content.Context r6 = r7.f660e
            r4.<init>((android.content.Context) r6, (int) r2)
            android.content.res.Resources$Theme r6 = r4.getTheme()
            r6.setTo(r5)
            goto L_0x006b
        L_0x0069:
            android.content.Context r4 = r7.f660e
        L_0x006b:
            androidx.appcompat.widget.ActionBarContextView r5 = new androidx.appcompat.widget.ActionBarContextView
            r5.<init>(r4)
            r7.f675p = r5
            android.widget.PopupWindow r5 = new android.widget.PopupWindow
            int r6 = androidx.appcompat.R$attr.actionModePopupWindowStyle
            r5.<init>(r4, r1, r6)
            r7.f676q = r5
            r6 = 2
            androidx.core.widget.t.b(r5, r6)
            android.widget.PopupWindow r5 = r7.f676q
            androidx.appcompat.widget.ActionBarContextView r6 = r7.f675p
            r5.setContentView(r6)
            android.widget.PopupWindow r5 = r7.f676q
            r6 = -1
            r5.setWidth(r6)
            android.content.res.Resources$Theme r5 = r4.getTheme()
            int r6 = androidx.appcompat.R$attr.actionBarSize
            r5.resolveAttribute(r6, r0, r3)
            int r0 = r0.data
            android.content.res.Resources r4 = r4.getResources()
            android.util.DisplayMetrics r4 = r4.getDisplayMetrics()
            int r0 = android.util.TypedValue.complexToDimensionPixelSize(r0, r4)
            androidx.appcompat.widget.ActionBarContextView r4 = r7.f675p
            r4.setContentHeight(r0)
            android.widget.PopupWindow r0 = r7.f676q
            r4 = -2
            r0.setHeight(r4)
            androidx.appcompat.app.h$f r0 = new androidx.appcompat.app.h$f
            r0.<init>()
            r7.f677r = r0
            goto L_0x00d5
        L_0x00b6:
            android.view.ViewGroup r0 = r7.f681v
            int r4 = androidx.appcompat.R$id.action_mode_bar_stub
            android.view.View r0 = r0.findViewById(r4)
            androidx.appcompat.widget.ViewStubCompat r0 = (androidx.appcompat.widget.ViewStubCompat) r0
            if (r0 == 0) goto L_0x00d5
            android.content.Context r4 = r7.Y()
            android.view.LayoutInflater r4 = android.view.LayoutInflater.from(r4)
            r0.setLayoutInflater(r4)
            android.view.View r0 = r0.a()
            androidx.appcompat.widget.ActionBarContextView r0 = (androidx.appcompat.widget.ActionBarContextView) r0
            r7.f675p = r0
        L_0x00d5:
            androidx.appcompat.widget.ActionBarContextView r0 = r7.f675p
            if (r0 == 0) goto L_0x0163
            r7.U()
            androidx.appcompat.widget.ActionBarContextView r0 = r7.f675p
            r0.k()
            g.e r0 = new g.e
            androidx.appcompat.widget.ActionBarContextView r4 = r7.f675p
            android.content.Context r4 = r4.getContext()
            androidx.appcompat.widget.ActionBarContextView r5 = r7.f675p
            android.widget.PopupWindow r6 = r7.f676q
            if (r6 != 0) goto L_0x00f0
            goto L_0x00f1
        L_0x00f0:
            r3 = 0
        L_0x00f1:
            r0.<init>(r4, r5, r8, r3)
            android.view.Menu r3 = r0.c()
            boolean r8 = r8.d(r0, r3)
            if (r8 == 0) goto L_0x0161
            r0.i()
            androidx.appcompat.widget.ActionBarContextView r8 = r7.f675p
            r8.h(r0)
            r7.f674o = r0
            boolean r8 = r7.B0()
            r0 = 1065353216(0x3f800000, float:1.0)
            if (r8 == 0) goto L_0x012b
            androidx.appcompat.widget.ActionBarContextView r8 = r7.f675p
            r1 = 0
            r8.setAlpha(r1)
            androidx.appcompat.widget.ActionBarContextView r8 = r7.f675p
            b0.a2 r8 = b0.c1.c(r8)
            b0.a2 r8 = r8.a(r0)
            r7.f678s = r8
            androidx.appcompat.app.h$g r0 = new androidx.appcompat.app.h$g
            r0.<init>()
            r8.f(r0)
            goto L_0x0151
        L_0x012b:
            androidx.appcompat.widget.ActionBarContextView r8 = r7.f675p
            r8.setAlpha(r0)
            androidx.appcompat.widget.ActionBarContextView r8 = r7.f675p
            r8.setVisibility(r2)
            androidx.appcompat.widget.ActionBarContextView r8 = r7.f675p
            r0 = 32
            r8.sendAccessibilityEvent(r0)
            androidx.appcompat.widget.ActionBarContextView r8 = r7.f675p
            android.view.ViewParent r8 = r8.getParent()
            boolean r8 = r8 instanceof android.view.View
            if (r8 == 0) goto L_0x0151
            androidx.appcompat.widget.ActionBarContextView r8 = r7.f675p
            android.view.ViewParent r8 = r8.getParent()
            android.view.View r8 = (android.view.View) r8
            b0.c1.h0(r8)
        L_0x0151:
            android.widget.PopupWindow r8 = r7.f676q
            if (r8 == 0) goto L_0x0163
            android.view.Window r8 = r7.f661f
            android.view.View r8 = r8.getDecorView()
            java.lang.Runnable r0 = r7.f677r
            r8.post(r0)
            goto L_0x0163
        L_0x0161:
            r7.f674o = r1
        L_0x0163:
            g.b r8 = r7.f674o
            if (r8 == 0) goto L_0x016e
            androidx.appcompat.app.e r0 = r7.f665h
            if (r0 == 0) goto L_0x016e
            r0.onSupportActionModeStarted(r8)
        L_0x016e:
            g.b r8 = r7.f674o
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.h.D0(g.b$a):g.b");
    }

    public g.b E(b.a aVar) {
        e eVar;
        if (aVar != null) {
            g.b bVar = this.f674o;
            if (bVar != null) {
                bVar.a();
            }
            j jVar = new j(aVar);
            a j10 = j();
            if (j10 != null) {
                g.b y10 = j10.y(jVar);
                this.f674o = y10;
                if (!(y10 == null || (eVar = this.f665h) == null)) {
                    eVar.onSupportActionModeStarted(y10);
                }
            }
            if (this.f674o == null) {
                this.f674o = D0(jVar);
            }
            return this.f674o;
        }
        throw new IllegalArgumentException("ActionMode callback can not be null.");
    }

    public final void E0() {
        if (this.f680u) {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        }
    }

    public boolean F() {
        return G(true);
    }

    public final d F0() {
        Context context = this.f660e;
        while (context != null) {
            if (!(context instanceof d)) {
                if (!(context instanceof ContextWrapper)) {
                    break;
                }
                context = ((ContextWrapper) context).getBaseContext();
            } else {
                return (d) context;
            }
        }
        return null;
    }

    public final boolean G(boolean z10) {
        if (this.M) {
            return false;
        }
        int J2 = J();
        boolean G0 = G0(l0(J2), z10);
        if (J2 == 0) {
            a0().e();
        } else {
            m mVar = this.V;
            if (mVar != null) {
                mVar.a();
            }
        }
        if (J2 == 3) {
            Z().e();
        } else {
            m mVar2 = this.W;
            if (mVar2 != null) {
                mVar2.a();
            }
        }
        return G0;
    }

    public final boolean G0(int i10, boolean z10) {
        int i11;
        int i12 = this.f660e.getApplicationContext().getResources().getConfiguration().uiMode & 48;
        boolean z11 = true;
        if (i10 == 1) {
            i11 = 16;
        } else if (i10 != 2) {
            i11 = i12;
        } else {
            i11 = 32;
        }
        boolean j02 = j0();
        boolean z12 = false;
        if ((f658n0 || i11 != i12) && !j02 && !this.J && (this.f659d instanceof ContextThemeWrapper)) {
            Configuration configuration = new Configuration();
            configuration.uiMode = (configuration.uiMode & -49) | i11;
            try {
                ((ContextThemeWrapper) this.f659d).applyOverrideConfiguration(configuration);
                z12 = true;
            } catch (IllegalStateException e10) {
                Log.e("AppCompatDelegate", "updateForNightMode. Calling applyOverrideConfiguration() failed with an exception. Will fall back to using Resources.updateConfiguration()", e10);
            }
        }
        int i13 = this.f660e.getResources().getConfiguration().uiMode & 48;
        if (!z12 && i13 != i11 && z10 && !j02 && this.J) {
            Object obj = this.f659d;
            if (obj instanceof Activity) {
                o.h.e((Activity) obj);
                z12 = true;
            }
        }
        if (z12 || i13 == i11) {
            z11 = z12;
        } else {
            H0(i11, j02);
        }
        if (z11) {
            Object obj2 = this.f659d;
            if (obj2 instanceof d) {
                ((d) obj2).onNightModeChanged(i10);
            }
        }
        return z11;
    }

    public final void H() {
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) this.f681v.findViewById(16908290);
        View decorView = this.f661f.getDecorView();
        contentFrameLayout.b(decorView.getPaddingLeft(), decorView.getPaddingTop(), decorView.getPaddingRight(), decorView.getPaddingBottom());
        TypedArray obtainStyledAttributes = this.f660e.obtainStyledAttributes(R$styleable.f554o);
        obtainStyledAttributes.getValue(R$styleable.AppCompatTheme_windowMinWidthMajor, contentFrameLayout.getMinWidthMajor());
        obtainStyledAttributes.getValue(R$styleable.AppCompatTheme_windowMinWidthMinor, contentFrameLayout.getMinWidthMinor());
        int i10 = R$styleable.AppCompatTheme_windowFixedWidthMajor;
        if (obtainStyledAttributes.hasValue(i10)) {
            obtainStyledAttributes.getValue(i10, contentFrameLayout.getFixedWidthMajor());
        }
        int i11 = R$styleable.AppCompatTheme_windowFixedWidthMinor;
        if (obtainStyledAttributes.hasValue(i11)) {
            obtainStyledAttributes.getValue(i11, contentFrameLayout.getFixedWidthMinor());
        }
        int i12 = R$styleable.AppCompatTheme_windowFixedHeightMajor;
        if (obtainStyledAttributes.hasValue(i12)) {
            obtainStyledAttributes.getValue(i12, contentFrameLayout.getFixedHeightMajor());
        }
        int i13 = R$styleable.AppCompatTheme_windowFixedHeightMinor;
        if (obtainStyledAttributes.hasValue(i13)) {
            obtainStyledAttributes.getValue(i13, contentFrameLayout.getFixedHeightMinor());
        }
        obtainStyledAttributes.recycle();
        contentFrameLayout.requestLayout();
    }

    public final void H0(int i10, boolean z10) {
        Resources resources = this.f660e.getResources();
        Configuration configuration = new Configuration(resources.getConfiguration());
        configuration.uiMode = i10 | (resources.getConfiguration().uiMode & -49);
        resources.updateConfiguration(configuration, (DisplayMetrics) null);
        int i11 = Build.VERSION.SDK_INT;
        if (i11 < 26) {
            l.a(resources);
        }
        int i12 = this.O;
        if (i12 != 0) {
            this.f660e.setTheme(i12);
            if (i11 >= 23) {
                this.f660e.getTheme().applyStyle(this.O, true);
            }
        }
        if (z10) {
            Object obj = this.f659d;
            if (obj instanceof Activity) {
                Activity activity = (Activity) obj;
                if (activity instanceof androidx.lifecycle.g) {
                    if (((androidx.lifecycle.g) activity).getLifecycle().b().a(d.c.STARTED)) {
                        activity.onConfigurationChanged(configuration);
                    }
                } else if (this.L) {
                    activity.onConfigurationChanged(configuration);
                }
            }
        }
    }

    public final void I(Window window) {
        if (this.f661f == null) {
            Window.Callback callback = window.getCallback();
            if (!(callback instanceof k)) {
                k kVar = new k(callback);
                this.f663g = kVar;
                window.setCallback(kVar);
                r2 t10 = r2.t(this.f660e, (AttributeSet) null, f656l0);
                Drawable h10 = t10.h(0);
                if (h10 != null) {
                    window.setBackgroundDrawable(h10);
                }
                t10.v();
                this.f661f = window;
                return;
            }
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        throw new IllegalStateException("AppCompat has already installed itself into the Window");
    }

    public int I0(int i10) {
        boolean z10;
        int i11;
        boolean z11;
        ActionBarContextView actionBarContextView = this.f675p;
        int i12 = 0;
        if (actionBarContextView == null || !(actionBarContextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            z10 = false;
        } else {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f675p.getLayoutParams();
            boolean z12 = true;
            if (this.f675p.isShown()) {
                if (this.f664g0 == null) {
                    this.f664g0 = new Rect();
                    this.f666h0 = new Rect();
                }
                Rect rect = this.f664g0;
                Rect rect2 = this.f666h0;
                rect.set(0, i10, 0, 0);
                y2.a(this.f681v, rect, rect2);
                if (rect2.top == 0) {
                    i11 = i10;
                } else {
                    i11 = 0;
                }
                if (marginLayoutParams.topMargin != i11) {
                    marginLayoutParams.topMargin = i10;
                    View view = this.f683x;
                    if (view == null) {
                        View view2 = new View(this.f660e);
                        this.f683x = view2;
                        view2.setBackgroundColor(this.f660e.getResources().getColor(R$color.abc_input_method_navigation_guard));
                        this.f681v.addView(this.f683x, -1, new ViewGroup.LayoutParams(-1, i10));
                    } else {
                        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                        if (layoutParams.height != i10) {
                            layoutParams.height = i10;
                            this.f683x.setLayoutParams(layoutParams);
                        }
                    }
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (this.f683x == null) {
                    z12 = false;
                }
                if (!this.C && z12) {
                    i10 = 0;
                }
                boolean z13 = z12;
                z12 = z11;
                z10 = z13;
            } else if (marginLayoutParams.topMargin != 0) {
                marginLayoutParams.topMargin = 0;
                z10 = false;
            } else {
                z10 = false;
                z12 = false;
            }
            if (z12) {
                this.f675p.setLayoutParams(marginLayoutParams);
            }
        }
        View view3 = this.f683x;
        if (view3 != null) {
            if (!z10) {
                i12 = 8;
            }
            view3.setVisibility(i12);
        }
        return i10;
    }

    public final int J() {
        int i10 = this.N;
        if (i10 != -100) {
            return i10;
        }
        return f.f();
    }

    public void K(int i10, p pVar, Menu menu) {
        if (menu == null) {
            if (pVar == null && i10 >= 0) {
                p[] pVarArr = this.G;
                if (i10 < pVarArr.length) {
                    pVar = pVarArr[i10];
                }
            }
            if (pVar != null) {
                menu = pVar.f717j;
            }
        }
        if ((pVar == null || pVar.f722o) && !this.M) {
            this.f663g.a().onPanelClosed(i10, menu);
        }
    }

    public void L(androidx.appcompat.view.menu.g gVar) {
        if (!this.F) {
            this.F = true;
            this.f671l.i();
            Window.Callback d02 = d0();
            if (d02 != null && !this.M) {
                d02.onPanelClosed(108, gVar);
            }
            this.F = false;
        }
    }

    public final void M() {
        m mVar = this.V;
        if (mVar != null) {
            mVar.a();
        }
        m mVar2 = this.W;
        if (mVar2 != null) {
            mVar2.a();
        }
    }

    public void N(int i10) {
        O(b0(i10, true), true);
    }

    public void O(p pVar, boolean z10) {
        ViewGroup viewGroup;
        h1 h1Var;
        if (!z10 || pVar.f708a != 0 || (h1Var = this.f671l) == null || !h1Var.e()) {
            WindowManager windowManager = (WindowManager) this.f660e.getSystemService("window");
            if (!(windowManager == null || !pVar.f722o || (viewGroup = pVar.f714g) == null)) {
                windowManager.removeView(viewGroup);
                if (z10) {
                    K(pVar.f708a, pVar, (Menu) null);
                }
            }
            pVar.f720m = false;
            pVar.f721n = false;
            pVar.f722o = false;
            pVar.f715h = null;
            pVar.f724q = true;
            if (this.H == pVar) {
                this.H = null;
                return;
            }
            return;
        }
        L(pVar.f717j);
    }

    public final ViewGroup P() {
        ViewGroup viewGroup;
        Context context;
        TypedArray obtainStyledAttributes = this.f660e.obtainStyledAttributes(R$styleable.f554o);
        int i10 = R$styleable.AppCompatTheme_windowActionBar;
        if (obtainStyledAttributes.hasValue(i10)) {
            if (obtainStyledAttributes.getBoolean(R$styleable.AppCompatTheme_windowNoTitle, false)) {
                x(1);
            } else if (obtainStyledAttributes.getBoolean(i10, false)) {
                x(108);
            }
            if (obtainStyledAttributes.getBoolean(R$styleable.AppCompatTheme_windowActionBarOverlay, false)) {
                x(109);
            }
            if (obtainStyledAttributes.getBoolean(R$styleable.AppCompatTheme_windowActionModeOverlay, false)) {
                x(10);
            }
            this.D = obtainStyledAttributes.getBoolean(R$styleable.AppCompatTheme_android_windowIsFloating, false);
            obtainStyledAttributes.recycle();
            W();
            this.f661f.getDecorView();
            LayoutInflater from = LayoutInflater.from(this.f660e);
            if (this.E) {
                if (this.C) {
                    viewGroup = (ViewGroup) from.inflate(R$layout.abc_screen_simple_overlay_action_mode, (ViewGroup) null);
                } else {
                    viewGroup = (ViewGroup) from.inflate(R$layout.abc_screen_simple, (ViewGroup) null);
                }
                if (Build.VERSION.SDK_INT >= 21) {
                    c1.y0(viewGroup, new c());
                } else {
                    ((s1) viewGroup).setOnFitSystemWindowsListener(new d());
                }
            } else if (this.D) {
                viewGroup = (ViewGroup) from.inflate(R$layout.abc_dialog_title_material, (ViewGroup) null);
                this.B = false;
                this.A = false;
            } else if (this.A) {
                TypedValue typedValue = new TypedValue();
                this.f660e.getTheme().resolveAttribute(R$attr.actionBarTheme, typedValue, true);
                if (typedValue.resourceId != 0) {
                    context = new g.d(this.f660e, typedValue.resourceId);
                } else {
                    context = this.f660e;
                }
                viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(R$layout.abc_screen_toolbar, (ViewGroup) null);
                h1 h1Var = (h1) viewGroup.findViewById(R$id.decor_content_parent);
                this.f671l = h1Var;
                h1Var.setWindowCallback(d0());
                if (this.B) {
                    this.f671l.h(109);
                }
                if (this.f684y) {
                    this.f671l.h(2);
                }
                if (this.f685z) {
                    this.f671l.h(5);
                }
            } else {
                viewGroup = null;
            }
            if (viewGroup != null) {
                if (this.f671l == null) {
                    this.f682w = (TextView) viewGroup.findViewById(R$id.title);
                }
                y2.c(viewGroup);
                ContentFrameLayout contentFrameLayout = (ContentFrameLayout) viewGroup.findViewById(R$id.action_bar_activity_content);
                ViewGroup viewGroup2 = (ViewGroup) this.f661f.findViewById(16908290);
                if (viewGroup2 != null) {
                    while (viewGroup2.getChildCount() > 0) {
                        View childAt = viewGroup2.getChildAt(0);
                        viewGroup2.removeViewAt(0);
                        contentFrameLayout.addView(childAt);
                    }
                    viewGroup2.setId(-1);
                    contentFrameLayout.setId(16908290);
                    if (viewGroup2 instanceof FrameLayout) {
                        ((FrameLayout) viewGroup2).setForeground((Drawable) null);
                    }
                }
                this.f661f.setContentView(viewGroup);
                contentFrameLayout.setAttachListener(new e());
                return viewGroup;
            }
            throw new IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + this.A + ", windowActionBarOverlay: " + this.B + ", android:windowIsFloating: " + this.D + ", windowActionModeOverlay: " + this.C + ", windowNoTitle: " + this.E + " }");
        }
        obtainStyledAttributes.recycle();
        throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
    }

    public View Q(View view, String str, Context context, AttributeSet attributeSet) {
        boolean z10;
        boolean z11 = false;
        if (this.f668i0 == null) {
            String string = this.f660e.obtainStyledAttributes(R$styleable.f554o).getString(R$styleable.AppCompatTheme_viewInflaterClass);
            if (string == null || AppCompatViewInflater.class.getName().equals(string)) {
                this.f668i0 = new AppCompatViewInflater();
            } else {
                try {
                    this.f668i0 = (AppCompatViewInflater) Class.forName(string).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                } catch (Throwable unused) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Failed to instantiate custom view inflater ");
                    sb.append(string);
                    sb.append(". Falling back to default.");
                    this.f668i0 = new AppCompatViewInflater();
                }
            }
        }
        boolean z12 = f655k0;
        if (z12) {
            if (!(attributeSet instanceof XmlPullParser)) {
                z11 = C0((ViewParent) view);
            } else if (((XmlPullParser) attributeSet).getDepth() > 1) {
                z11 = true;
            }
            z10 = z11;
        } else {
            z10 = false;
        }
        return this.f668i0.createView(view, str, context, attributeSet, z10, z12, true, x2.b());
    }

    public void R() {
        androidx.appcompat.view.menu.g gVar;
        h1 h1Var = this.f671l;
        if (h1Var != null) {
            h1Var.i();
        }
        if (this.f676q != null) {
            this.f661f.getDecorView().removeCallbacks(this.f677r);
            if (this.f676q.isShowing()) {
                try {
                    this.f676q.dismiss();
                } catch (IllegalArgumentException unused) {
                }
            }
            this.f676q = null;
        }
        U();
        p b02 = b0(0, false);
        if (b02 != null && (gVar = b02.f717j) != null) {
            gVar.close();
        }
    }

    public boolean S(KeyEvent keyEvent) {
        View decorView;
        Object obj = this.f659d;
        boolean z10 = true;
        if (((obj instanceof k.a) || (obj instanceof j)) && (decorView = this.f661f.getDecorView()) != null && b0.k.d(decorView, keyEvent)) {
            return true;
        }
        if (keyEvent.getKeyCode() == 82 && this.f663g.a().dispatchKeyEvent(keyEvent)) {
            return true;
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyEvent.getAction() != 0) {
            z10 = false;
        }
        if (z10) {
            return n0(keyCode, keyEvent);
        }
        return q0(keyCode, keyEvent);
    }

    public void T(int i10) {
        p b02;
        p b03 = b0(i10, true);
        if (b03.f717j != null) {
            Bundle bundle = new Bundle();
            b03.f717j.saveActionViewStates(bundle);
            if (bundle.size() > 0) {
                b03.f726s = bundle;
            }
            b03.f717j.stopDispatchingItemsChanged();
            b03.f717j.clear();
        }
        b03.f725r = true;
        b03.f724q = true;
        if ((i10 == 108 || i10 == 0) && this.f671l != null && (b02 = b0(0, false)) != null) {
            b02.f720m = false;
            y0(b02, (KeyEvent) null);
        }
    }

    public void U() {
        a2 a2Var = this.f678s;
        if (a2Var != null) {
            a2Var.b();
        }
    }

    public final void V() {
        if (!this.f680u) {
            this.f681v = P();
            CharSequence c02 = c0();
            if (!TextUtils.isEmpty(c02)) {
                h1 h1Var = this.f671l;
                if (h1Var != null) {
                    h1Var.setWindowTitle(c02);
                } else if (w0() != null) {
                    w0().x(c02);
                } else {
                    TextView textView = this.f682w;
                    if (textView != null) {
                        textView.setText(c02);
                    }
                }
            }
            H();
            u0(this.f681v);
            this.f680u = true;
            p b02 = b0(0, false);
            if (this.M) {
                return;
            }
            if (b02 == null || b02.f717j == null) {
                i0(108);
            }
        }
    }

    public final void W() {
        if (this.f661f == null) {
            Object obj = this.f659d;
            if (obj instanceof Activity) {
                I(((Activity) obj).getWindow());
            }
        }
        if (this.f661f == null) {
            throw new IllegalStateException("We have not been given a Window");
        }
    }

    public p X(Menu menu) {
        int i10;
        p[] pVarArr = this.G;
        if (pVarArr != null) {
            i10 = pVarArr.length;
        } else {
            i10 = 0;
        }
        for (int i11 = 0; i11 < i10; i11++) {
            p pVar = pVarArr[i11];
            if (pVar != null && pVar.f717j == menu) {
                return pVar;
            }
        }
        return null;
    }

    public final Context Y() {
        Context context;
        a j10 = j();
        if (j10 != null) {
            context = j10.k();
        } else {
            context = null;
        }
        if (context == null) {
            return this.f660e;
        }
        return context;
    }

    public final m Z() {
        if (this.W == null) {
            this.W = new l(this.f660e);
        }
        return this.W;
    }

    public void a(View view, ViewGroup.LayoutParams layoutParams) {
        V();
        ((ViewGroup) this.f681v.findViewById(16908290)).addView(view, layoutParams);
        this.f663g.a().onContentChanged();
    }

    public final m a0() {
        if (this.V == null) {
            this.V = new n(p.a(this.f660e));
        }
        return this.V;
    }

    public void b(Context context) {
        G(false);
        this.J = true;
    }

    public p b0(int i10, boolean z10) {
        p[] pVarArr = this.G;
        if (pVarArr == null || pVarArr.length <= i10) {
            p[] pVarArr2 = new p[(i10 + 1)];
            if (pVarArr != null) {
                System.arraycopy(pVarArr, 0, pVarArr2, 0, pVarArr.length);
            }
            this.G = pVarArr2;
            pVarArr = pVarArr2;
        }
        p pVar = pVarArr[i10];
        if (pVar != null) {
            return pVar;
        }
        p pVar2 = new p(i10);
        pVarArr[i10] = pVar2;
        return pVar2;
    }

    public final CharSequence c0() {
        Object obj = this.f659d;
        if (obj instanceof Activity) {
            return ((Activity) obj).getTitle();
        }
        return this.f670k;
    }

    public final Window.Callback d0() {
        return this.f661f.getCallback();
    }

    public View e(int i10) {
        V();
        return this.f661f.findViewById(i10);
    }

    public final void e0() {
        V();
        if (this.A && this.f667i == null) {
            Object obj = this.f659d;
            if (obj instanceof Activity) {
                this.f667i = new q((Activity) this.f659d, this.B);
            } else if (obj instanceof Dialog) {
                this.f667i = new q((Dialog) this.f659d);
            }
            a aVar = this.f667i;
            if (aVar != null) {
                aVar.r(this.f662f0);
            }
        }
    }

    public final boolean f0(p pVar) {
        View view = pVar.f716i;
        if (view != null) {
            pVar.f715h = view;
            return true;
        } else if (pVar.f717j == null) {
            return false;
        } else {
            if (this.f673n == null) {
                this.f673n = new q();
            }
            View view2 = (View) pVar.a(this.f673n);
            pVar.f715h = view2;
            if (view2 != null) {
                return true;
            }
            return false;
        }
    }

    public final b g() {
        return new C0013h();
    }

    public final boolean g0(p pVar) {
        pVar.d(Y());
        pVar.f714g = new o(pVar.f719l);
        pVar.f710c = 81;
        return true;
    }

    public int h() {
        return this.N;
    }

    public final boolean h0(p pVar) {
        Resources.Theme theme;
        Context context = this.f660e;
        int i10 = pVar.f708a;
        if ((i10 == 0 || i10 == 108) && this.f671l != null) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme theme2 = context.getTheme();
            theme2.resolveAttribute(R$attr.actionBarTheme, typedValue, true);
            if (typedValue.resourceId != 0) {
                theme = context.getResources().newTheme();
                theme.setTo(theme2);
                theme.applyStyle(typedValue.resourceId, true);
                theme.resolveAttribute(R$attr.actionBarWidgetTheme, typedValue, true);
            } else {
                theme2.resolveAttribute(R$attr.actionBarWidgetTheme, typedValue, true);
                theme = null;
            }
            if (typedValue.resourceId != 0) {
                if (theme == null) {
                    theme = context.getResources().newTheme();
                    theme.setTo(theme2);
                }
                theme.applyStyle(typedValue.resourceId, true);
            }
            if (theme != null) {
                g.d dVar = new g.d(context, 0);
                dVar.getTheme().setTo(theme);
                context = dVar;
            }
        }
        androidx.appcompat.view.menu.g gVar = new androidx.appcompat.view.menu.g(context);
        gVar.setCallback(this);
        pVar.c(gVar);
        return true;
    }

    public MenuInflater i() {
        Context context;
        if (this.f669j == null) {
            e0();
            a aVar = this.f667i;
            if (aVar != null) {
                context = aVar.k();
            } else {
                context = this.f660e;
            }
            this.f669j = new g.g(context);
        }
        return this.f669j;
    }

    public final void i0(int i10) {
        this.Y = (1 << i10) | this.Y;
        if (!this.X) {
            c1.c0(this.f661f.getDecorView(), this.Z);
            this.X = true;
        }
    }

    public a j() {
        e0();
        return this.f667i;
    }

    public final boolean j0() {
        boolean z10;
        if (!this.S && (this.f659d instanceof Activity)) {
            PackageManager packageManager = this.f660e.getPackageManager();
            if (packageManager == null) {
                return false;
            }
            try {
                ActivityInfo activityInfo = packageManager.getActivityInfo(new ComponentName(this.f660e, this.f659d.getClass()), 0);
                if (activityInfo == null || (activityInfo.configChanges & 512) == 0) {
                    z10 = false;
                } else {
                    z10 = true;
                }
                this.Q = z10;
            } catch (PackageManager.NameNotFoundException unused) {
                this.Q = false;
            }
        }
        this.S = true;
        return this.Q;
    }

    public void k() {
        LayoutInflater from = LayoutInflater.from(this.f660e);
        if (from.getFactory() == null) {
            b0.l.b(from, this);
        } else {
            boolean z10 = from.getFactory2() instanceof h;
        }
    }

    public boolean k0() {
        return this.f679t;
    }

    public void l() {
        a j10 = j();
        if (j10 == null || !j10.l()) {
            i0(0);
        }
    }

    public int l0(int i10) {
        if (i10 == -100) {
            return -1;
        }
        if (i10 == -1) {
            return i10;
        }
        if (i10 != 0) {
            if (i10 == 1 || i10 == 2) {
                return i10;
            }
            if (i10 == 3) {
                return Z().c();
            }
            throw new IllegalStateException("Unknown value set for night mode. Please use one of the MODE_NIGHT values from AppCompatDelegate.");
        } else if (Build.VERSION.SDK_INT < 23 || ((UiModeManager) this.f660e.getSystemService(UiModeManager.class)).getNightMode() != 0) {
            return a0().c();
        } else {
            return -1;
        }
    }

    public boolean m0() {
        g.b bVar = this.f674o;
        if (bVar != null) {
            bVar.a();
            return true;
        }
        a j10 = j();
        if (j10 == null || !j10.h()) {
            return false;
        }
        return true;
    }

    public boolean n0(int i10, KeyEvent keyEvent) {
        boolean z10 = true;
        if (i10 == 4) {
            if ((keyEvent.getFlags() & 128) == 0) {
                z10 = false;
            }
            this.I = z10;
        } else if (i10 == 82) {
            o0(0, keyEvent);
            return true;
        }
        return false;
    }

    public void o(Configuration configuration) {
        a j10;
        if (this.A && this.f680u && (j10 = j()) != null) {
            j10.m(configuration);
        }
        androidx.appcompat.widget.k.b().g(this.f660e);
        G(false);
    }

    public final boolean o0(int i10, KeyEvent keyEvent) {
        if (keyEvent.getRepeatCount() != 0) {
            return false;
        }
        p b02 = b0(i10, true);
        if (!b02.f722o) {
            return y0(b02, keyEvent);
        }
        return false;
    }

    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return Q(view, str, context, attributeSet);
    }

    public boolean onMenuItemSelected(androidx.appcompat.view.menu.g gVar, MenuItem menuItem) {
        p X2;
        Window.Callback d02 = d0();
        if (d02 == null || this.M || (X2 = X(gVar.getRootMenu())) == null) {
            return false;
        }
        return d02.onMenuItemSelected(X2.f708a, menuItem);
    }

    public void onMenuModeChange(androidx.appcompat.view.menu.g gVar) {
        z0(gVar, true);
    }

    public void p(Bundle bundle) {
        String str;
        this.J = true;
        G(false);
        W();
        Object obj = this.f659d;
        if (obj instanceof Activity) {
            try {
                str = o.q.c((Activity) obj);
            } catch (IllegalArgumentException unused) {
                str = null;
            }
            if (str != null) {
                a w02 = w0();
                if (w02 == null) {
                    this.f662f0 = true;
                } else {
                    w02.r(true);
                }
            }
        }
        this.K = true;
    }

    public boolean p0(int i10, KeyEvent keyEvent) {
        a j10 = j();
        if (j10 != null && j10.o(i10, keyEvent)) {
            return true;
        }
        p pVar = this.H;
        if (pVar == null || !x0(pVar, keyEvent.getKeyCode(), keyEvent, 1)) {
            if (this.H == null) {
                p b02 = b0(0, true);
                y0(b02, keyEvent);
                boolean x02 = x0(b02, keyEvent.getKeyCode(), keyEvent, 1);
                b02.f720m = false;
                if (x02) {
                    return true;
                }
            }
            return false;
        }
        p pVar2 = this.H;
        if (pVar2 != null) {
            pVar2.f721n = true;
        }
        return true;
    }

    public void q() {
        f.n(this);
        if (this.X) {
            this.f661f.getDecorView().removeCallbacks(this.Z);
        }
        this.L = false;
        this.M = true;
        a aVar = this.f667i;
        if (aVar != null) {
            aVar.n();
        }
        M();
    }

    public boolean q0(int i10, KeyEvent keyEvent) {
        if (i10 == 4) {
            boolean z10 = this.I;
            this.I = false;
            p b02 = b0(0, false);
            if (b02 != null && b02.f722o) {
                if (!z10) {
                    O(b02, true);
                }
                return true;
            } else if (m0()) {
                return true;
            }
        } else if (i10 == 82) {
            r0(0, keyEvent);
            return true;
        }
        return false;
    }

    public void r(Bundle bundle) {
        V();
    }

    public final boolean r0(int i10, KeyEvent keyEvent) {
        AudioManager audioManager;
        boolean z10;
        h1 h1Var;
        if (this.f674o != null) {
            return false;
        }
        boolean z11 = true;
        p b02 = b0(i10, true);
        if (i10 != 0 || (h1Var = this.f671l) == null || !h1Var.a() || ViewConfiguration.get(this.f660e).hasPermanentMenuKey()) {
            boolean z12 = b02.f722o;
            if (z12 || b02.f721n) {
                O(b02, true);
                z11 = z12;
                if (z11 && (audioManager = (AudioManager) this.f660e.getSystemService("audio")) != null) {
                    audioManager.playSoundEffect(0);
                }
                return z11;
            } else if (b02.f720m) {
                if (b02.f725r) {
                    b02.f720m = false;
                    z10 = y0(b02, keyEvent);
                } else {
                    z10 = true;
                }
                if (z10) {
                    v0(b02, keyEvent);
                    audioManager.playSoundEffect(0);
                    return z11;
                }
            }
        } else {
            if (this.f671l.e()) {
                z11 = this.f671l.b();
            } else if (!this.M && y0(b02, keyEvent)) {
                z11 = this.f671l.c();
            }
            audioManager.playSoundEffect(0);
            return z11;
        }
        z11 = false;
        audioManager.playSoundEffect(0);
        return z11;
    }

    public void s() {
        a j10 = j();
        if (j10 != null) {
            j10.u(true);
        }
    }

    public void s0(int i10) {
        a j10;
        if (i10 == 108 && (j10 = j()) != null) {
            j10.i(true);
        }
    }

    public void t(Bundle bundle) {
        if (this.N != -100) {
            f654j0.put(this.f659d.getClass(), Integer.valueOf(this.N));
        }
    }

    public void t0(int i10) {
        if (i10 == 108) {
            a j10 = j();
            if (j10 != null) {
                j10.i(false);
            }
        } else if (i10 == 0) {
            p b02 = b0(i10, true);
            if (b02.f722o) {
                O(b02, false);
            }
        }
    }

    public void u() {
        this.L = true;
        F();
        f.m(this);
    }

    public void u0(ViewGroup viewGroup) {
    }

    public void v() {
        this.L = false;
        f.n(this);
        a j10 = j();
        if (j10 != null) {
            j10.u(false);
        }
        if (this.f659d instanceof Dialog) {
            M();
        }
    }

    public final void v0(p pVar, KeyEvent keyEvent) {
        int i10;
        ViewGroup.LayoutParams layoutParams;
        boolean z10;
        if (!pVar.f722o && !this.M) {
            if (pVar.f708a == 0) {
                if ((this.f660e.getResources().getConfiguration().screenLayout & 15) == 4) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (z10) {
                    return;
                }
            }
            Window.Callback d02 = d0();
            if (d02 == null || d02.onMenuOpened(pVar.f708a, pVar.f717j)) {
                WindowManager windowManager = (WindowManager) this.f660e.getSystemService("window");
                if (windowManager != null && y0(pVar, keyEvent)) {
                    ViewGroup viewGroup = pVar.f714g;
                    if (viewGroup == null || pVar.f724q) {
                        if (viewGroup == null) {
                            if (!g0(pVar) || pVar.f714g == null) {
                                return;
                            }
                        } else if (pVar.f724q && viewGroup.getChildCount() > 0) {
                            pVar.f714g.removeAllViews();
                        }
                        if (f0(pVar) && pVar.b()) {
                            ViewGroup.LayoutParams layoutParams2 = pVar.f715h.getLayoutParams();
                            if (layoutParams2 == null) {
                                layoutParams2 = new ViewGroup.LayoutParams(-2, -2);
                            }
                            pVar.f714g.setBackgroundResource(pVar.f709b);
                            ViewParent parent = pVar.f715h.getParent();
                            if (parent instanceof ViewGroup) {
                                ((ViewGroup) parent).removeView(pVar.f715h);
                            }
                            pVar.f714g.addView(pVar.f715h, layoutParams2);
                            if (!pVar.f715h.hasFocus()) {
                                pVar.f715h.requestFocus();
                            }
                        } else {
                            return;
                        }
                    } else {
                        View view = pVar.f716i;
                        if (!(view == null || (layoutParams = view.getLayoutParams()) == null || layoutParams.width != -1)) {
                            i10 = -1;
                            pVar.f721n = false;
                            WindowManager.LayoutParams layoutParams3 = new WindowManager.LayoutParams(i10, -2, pVar.f711d, pVar.f712e, 1002, 8519680, -3);
                            layoutParams3.gravity = pVar.f710c;
                            layoutParams3.windowAnimations = pVar.f713f;
                            windowManager.addView(pVar.f714g, layoutParams3);
                            pVar.f722o = true;
                            return;
                        }
                    }
                    i10 = -2;
                    pVar.f721n = false;
                    WindowManager.LayoutParams layoutParams32 = new WindowManager.LayoutParams(i10, -2, pVar.f711d, pVar.f712e, 1002, 8519680, -3);
                    layoutParams32.gravity = pVar.f710c;
                    layoutParams32.windowAnimations = pVar.f713f;
                    windowManager.addView(pVar.f714g, layoutParams32);
                    pVar.f722o = true;
                    return;
                }
                return;
            }
            O(pVar, true);
        }
    }

    public final a w0() {
        return this.f667i;
    }

    public boolean x(int i10) {
        int A0 = A0(i10);
        if (this.E && A0 == 108) {
            return false;
        }
        if (this.A && A0 == 1) {
            this.A = false;
        }
        if (A0 == 1) {
            E0();
            this.E = true;
            return true;
        } else if (A0 == 2) {
            E0();
            this.f684y = true;
            return true;
        } else if (A0 == 5) {
            E0();
            this.f685z = true;
            return true;
        } else if (A0 == 10) {
            E0();
            this.C = true;
            return true;
        } else if (A0 == 108) {
            E0();
            this.A = true;
            return true;
        } else if (A0 != 109) {
            return this.f661f.requestFeature(A0);
        } else {
            E0();
            this.B = true;
            return true;
        }
    }

    public final boolean x0(p pVar, int i10, KeyEvent keyEvent, int i11) {
        androidx.appcompat.view.menu.g gVar;
        boolean z10 = false;
        if (keyEvent.isSystem()) {
            return false;
        }
        if ((pVar.f720m || y0(pVar, keyEvent)) && (gVar = pVar.f717j) != null) {
            z10 = gVar.performShortcut(i10, keyEvent, i11);
        }
        if (z10 && (i11 & 1) == 0 && this.f671l == null) {
            O(pVar, true);
        }
        return z10;
    }

    public void y(int i10) {
        V();
        ViewGroup viewGroup = (ViewGroup) this.f681v.findViewById(16908290);
        viewGroup.removeAllViews();
        LayoutInflater.from(this.f660e).inflate(i10, viewGroup);
        this.f663g.a().onContentChanged();
    }

    public final boolean y0(p pVar, KeyEvent keyEvent) {
        boolean z10;
        int i10;
        boolean z11;
        h1 h1Var;
        h1 h1Var2;
        h1 h1Var3;
        if (this.M) {
            return false;
        }
        if (pVar.f720m) {
            return true;
        }
        p pVar2 = this.H;
        if (!(pVar2 == null || pVar2 == pVar)) {
            O(pVar2, false);
        }
        Window.Callback d02 = d0();
        if (d02 != null) {
            pVar.f716i = d02.onCreatePanelView(pVar.f708a);
        }
        int i11 = pVar.f708a;
        if (i11 == 0 || i11 == 108) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10 && (h1Var3 = this.f671l) != null) {
            h1Var3.f();
        }
        if (pVar.f716i == null && (!z10 || !(w0() instanceof n))) {
            androidx.appcompat.view.menu.g gVar = pVar.f717j;
            if (gVar == null || pVar.f725r) {
                if (gVar == null && (!h0(pVar) || pVar.f717j == null)) {
                    return false;
                }
                if (z10 && this.f671l != null) {
                    if (this.f672m == null) {
                        this.f672m = new i();
                    }
                    this.f671l.d(pVar.f717j, this.f672m);
                }
                pVar.f717j.stopDispatchingItemsChanged();
                if (!d02.onCreatePanelMenu(pVar.f708a, pVar.f717j)) {
                    pVar.c((androidx.appcompat.view.menu.g) null);
                    if (z10 && (h1Var2 = this.f671l) != null) {
                        h1Var2.d((Menu) null, this.f672m);
                    }
                    return false;
                }
                pVar.f725r = false;
            }
            pVar.f717j.stopDispatchingItemsChanged();
            Bundle bundle = pVar.f726s;
            if (bundle != null) {
                pVar.f717j.restoreActionViewStates(bundle);
                pVar.f726s = null;
            }
            if (!d02.onPreparePanel(0, pVar.f716i, pVar.f717j)) {
                if (z10 && (h1Var = this.f671l) != null) {
                    h1Var.d((Menu) null, this.f672m);
                }
                pVar.f717j.startDispatchingItemsChanged();
                return false;
            }
            if (keyEvent != null) {
                i10 = keyEvent.getDeviceId();
            } else {
                i10 = -1;
            }
            if (KeyCharacterMap.load(i10).getKeyboardType() != 1) {
                z11 = true;
            } else {
                z11 = false;
            }
            pVar.f723p = z11;
            pVar.f717j.setQwertyMode(z11);
            pVar.f717j.startDispatchingItemsChanged();
        }
        pVar.f720m = true;
        pVar.f721n = false;
        this.H = pVar;
        return true;
    }

    public void z(View view) {
        V();
        ViewGroup viewGroup = (ViewGroup) this.f681v.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        this.f663g.a().onContentChanged();
    }

    public final void z0(androidx.appcompat.view.menu.g gVar, boolean z10) {
        h1 h1Var = this.f671l;
        if (h1Var == null || !h1Var.a() || (ViewConfiguration.get(this.f660e).hasPermanentMenuKey() && !this.f671l.g())) {
            p b02 = b0(0, true);
            b02.f724q = true;
            O(b02, false);
            v0(b02, (KeyEvent) null);
            return;
        }
        Window.Callback d02 = d0();
        if (this.f671l.e() && z10) {
            this.f671l.b();
            if (!this.M) {
                d02.onPanelClosed(108, b0(0, true).f717j);
            }
        } else if (d02 != null && !this.M) {
            if (this.X && (this.Y & 1) != 0) {
                this.f661f.getDecorView().removeCallbacks(this.Z);
                this.Z.run();
            }
            p b03 = b0(0, true);
            androidx.appcompat.view.menu.g gVar2 = b03.f717j;
            if (gVar2 != null && !b03.f725r && d02.onPreparePanel(0, b03.f716i, gVar2)) {
                d02.onMenuOpened(108, b03.f717j);
                this.f671l.c();
            }
        }
    }

    public h(Dialog dialog, e eVar) {
        this(dialog.getContext(), dialog.getWindow(), eVar, dialog);
    }

    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView((View) null, str, context, attributeSet);
    }

    public h(Context context, Window window, e eVar, Object obj) {
        d F0;
        this.f678s = null;
        this.f679t = true;
        this.N = -100;
        this.Z = new b();
        this.f660e = context;
        this.f665h = eVar;
        this.f659d = obj;
        if (this.N == -100 && (obj instanceof Dialog) && (F0 = F0()) != null) {
            this.N = F0.getDelegate().h();
        }
        if (this.N == -100) {
            Map map = f654j0;
            Integer num = (Integer) map.get(obj.getClass());
            if (num != null) {
                this.N = num.intValue();
                map.remove(obj.getClass());
            }
        }
        if (window != null) {
            I(window);
        }
        androidx.appcompat.widget.k.h();
    }

    public class k extends g.m {
        public k(Window.Callback callback) {
            super(callback);
        }

        public final ActionMode b(ActionMode.Callback callback) {
            f.a aVar = new f.a(h.this.f660e, callback);
            g.b E = h.this.E(aVar);
            if (E != null) {
                return aVar.e(E);
            }
            return null;
        }

        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            if (h.this.S(keyEvent) || super.dispatchKeyEvent(keyEvent)) {
                return true;
            }
            return false;
        }

        public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
            if (super.dispatchKeyShortcutEvent(keyEvent) || h.this.p0(keyEvent.getKeyCode(), keyEvent)) {
                return true;
            }
            return false;
        }

        public void onContentChanged() {
        }

        public boolean onCreatePanelMenu(int i10, Menu menu) {
            if (i10 != 0 || (menu instanceof androidx.appcompat.view.menu.g)) {
                return super.onCreatePanelMenu(i10, menu);
            }
            return false;
        }

        public boolean onMenuOpened(int i10, Menu menu) {
            super.onMenuOpened(i10, menu);
            h.this.s0(i10);
            return true;
        }

        public void onPanelClosed(int i10, Menu menu) {
            super.onPanelClosed(i10, menu);
            h.this.t0(i10);
        }

        public boolean onPreparePanel(int i10, View view, Menu menu) {
            androidx.appcompat.view.menu.g gVar;
            if (menu instanceof androidx.appcompat.view.menu.g) {
                gVar = (androidx.appcompat.view.menu.g) menu;
            } else {
                gVar = null;
            }
            if (i10 == 0 && gVar == null) {
                return false;
            }
            if (gVar != null) {
                gVar.setOverrideVisibleItems(true);
            }
            boolean onPreparePanel = super.onPreparePanel(i10, view, menu);
            if (gVar != null) {
                gVar.setOverrideVisibleItems(false);
            }
            return onPreparePanel;
        }

        public void onProvideKeyboardShortcuts(List list, Menu menu, int i10) {
            androidx.appcompat.view.menu.g gVar;
            p b02 = h.this.b0(0, true);
            if (b02 == null || (gVar = b02.f717j) == null) {
                super.onProvideKeyboardShortcuts(list, menu, i10);
            } else {
                super.onProvideKeyboardShortcuts(list, gVar, i10);
            }
        }

        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
            if (Build.VERSION.SDK_INT >= 23) {
                return null;
            }
            if (h.this.k0()) {
                return b(callback);
            }
            return super.onWindowStartingActionMode(callback);
        }

        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i10) {
            if (!h.this.k0() || i10 != 0) {
                return super.onWindowStartingActionMode(callback, i10);
            }
            return b(callback);
        }
    }
}
