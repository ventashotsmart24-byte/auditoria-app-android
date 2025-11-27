package androidx.mediarouter.app;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.ResolveInfo;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import androidx.appcompat.widget.u2;
import androidx.fragment.app.e;
import androidx.fragment.app.o;
import androidx.fragment.app.y;
import androidx.mediarouter.R$attr;
import androidx.mediarouter.R$string;
import androidx.mediarouter.R$styleable;
import b0.c1;
import java.util.ArrayList;
import java.util.List;
import n0.o1;
import n0.s0;
import n0.t0;
import s.h;

public class MediaRouteButton extends View {

    /* renamed from: p  reason: collision with root package name */
    public static a f2430p;

    /* renamed from: q  reason: collision with root package name */
    public static final SparseArray f2431q = new SparseArray(2);

    /* renamed from: r  reason: collision with root package name */
    public static final int[] f2432r = {16842912};

    /* renamed from: s  reason: collision with root package name */
    public static final int[] f2433s = {16842911};

    /* renamed from: a  reason: collision with root package name */
    public final t0 f2434a;

    /* renamed from: b  reason: collision with root package name */
    public final b f2435b;

    /* renamed from: c  reason: collision with root package name */
    public s0 f2436c;

    /* renamed from: d  reason: collision with root package name */
    public e f2437d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f2438e;

    /* renamed from: f  reason: collision with root package name */
    public int f2439f;

    /* renamed from: g  reason: collision with root package name */
    public c f2440g;

    /* renamed from: h  reason: collision with root package name */
    public Drawable f2441h;

    /* renamed from: i  reason: collision with root package name */
    public int f2442i;

    /* renamed from: j  reason: collision with root package name */
    public int f2443j;

    /* renamed from: k  reason: collision with root package name */
    public ColorStateList f2444k;

    /* renamed from: l  reason: collision with root package name */
    public int f2445l;

    /* renamed from: m  reason: collision with root package name */
    public int f2446m;

    /* renamed from: n  reason: collision with root package name */
    public boolean f2447n;

    /* renamed from: o  reason: collision with root package name */
    public boolean f2448o;

    public static final class a extends BroadcastReceiver {

        /* renamed from: a  reason: collision with root package name */
        public final Context f2449a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f2450b = true;

        /* renamed from: c  reason: collision with root package name */
        public List f2451c;

        public a(Context context) {
            this.f2449a = context;
            this.f2451c = new ArrayList();
        }

        public boolean a() {
            return this.f2450b;
        }

        public void b(MediaRouteButton mediaRouteButton) {
            if (this.f2451c.size() == 0) {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                this.f2449a.registerReceiver(this, intentFilter);
            }
            this.f2451c.add(mediaRouteButton);
        }

        public void c(MediaRouteButton mediaRouteButton) {
            this.f2451c.remove(mediaRouteButton);
            if (this.f2451c.size() == 0) {
                this.f2449a.unregisterReceiver(this);
            }
        }

        public void onReceive(Context context, Intent intent) {
            boolean z10;
            if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction()) && this.f2450b != (!intent.getBooleanExtra("noConnectivity", false))) {
                this.f2450b = z10;
                for (MediaRouteButton c10 : this.f2451c) {
                    c10.c();
                }
            }
        }
    }

    public final class b extends t0.b {
        public b() {
        }

        public void onProviderAdded(t0 t0Var, t0.h hVar) {
            MediaRouteButton.this.b();
        }

        public void onProviderChanged(t0 t0Var, t0.h hVar) {
            MediaRouteButton.this.b();
        }

        public void onProviderRemoved(t0 t0Var, t0.h hVar) {
            MediaRouteButton.this.b();
        }

        public void onRouteAdded(t0 t0Var, t0.i iVar) {
            MediaRouteButton.this.b();
        }

        public void onRouteChanged(t0 t0Var, t0.i iVar) {
            MediaRouteButton.this.b();
        }

        public void onRouteRemoved(t0 t0Var, t0.i iVar) {
            MediaRouteButton.this.b();
        }

        public void onRouteSelected(t0 t0Var, t0.i iVar) {
            MediaRouteButton.this.b();
        }

        public void onRouteUnselected(t0 t0Var, t0.i iVar) {
            MediaRouteButton.this.b();
        }
    }

    public final class c extends AsyncTask {

        /* renamed from: a  reason: collision with root package name */
        public final int f2453a;

        /* renamed from: b  reason: collision with root package name */
        public final Context f2454b;

        public c(int i10, Context context) {
            this.f2453a = i10;
            this.f2454b = context;
        }

        public final void a(Drawable drawable) {
            if (drawable != null) {
                MediaRouteButton.f2431q.put(this.f2453a, drawable.getConstantState());
            }
            MediaRouteButton.this.f2440g = null;
        }

        /* renamed from: b */
        public Drawable doInBackground(Void... voidArr) {
            if (((Drawable.ConstantState) MediaRouteButton.f2431q.get(this.f2453a)) == null) {
                return this.f2454b.getResources().getDrawable(this.f2453a);
            }
            return null;
        }

        /* renamed from: c */
        public void onCancelled(Drawable drawable) {
            a(drawable);
        }

        /* renamed from: d */
        public void onPostExecute(Drawable drawable) {
            if (drawable != null) {
                a(drawable);
            } else {
                Drawable.ConstantState constantState = (Drawable.ConstantState) MediaRouteButton.f2431q.get(this.f2453a);
                if (constantState != null) {
                    drawable = constantState.newDrawable();
                }
                MediaRouteButton.this.f2440g = null;
            }
            MediaRouteButton.this.setRemoteIndicatorDrawableInternal(drawable);
        }
    }

    public MediaRouteButton(Context context) {
        this(context, (AttributeSet) null);
    }

    private Activity getActivity() {
        for (Context context = getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
        }
        return null;
    }

    private o getFragmentManager() {
        Activity activity = getActivity();
        if (activity instanceof e) {
            return ((e) activity).getSupportFragmentManager();
        }
        return null;
    }

    public final void a() {
        if (this.f2442i > 0) {
            c cVar = this.f2440g;
            if (cVar != null) {
                cVar.cancel(false);
            }
            c cVar2 = new c(this.f2442i, getContext());
            this.f2440g = cVar2;
            this.f2442i = 0;
            cVar2.executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, new Void[0]);
        }
    }

    public void b() {
        boolean z10;
        int i10;
        boolean z11;
        t0.i m10 = this.f2434a.m();
        boolean z12 = false;
        if (m10.w() || !m10.E(this.f2436c)) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (z10) {
            i10 = m10.c();
        } else {
            i10 = 0;
        }
        if (this.f2443j != i10) {
            this.f2443j = i10;
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            g();
            refreshDrawableState();
        }
        if (i10 == 1) {
            a();
        }
        if (this.f2438e) {
            if (this.f2447n || this.f2434a.o(this.f2436c, 1)) {
                z12 = true;
            }
            setEnabled(z12);
        }
        Drawable drawable = this.f2441h;
        if (drawable != null && (drawable.getCurrent() instanceof AnimationDrawable)) {
            AnimationDrawable animationDrawable = (AnimationDrawable) this.f2441h.getCurrent();
            if (this.f2438e) {
                if ((z11 || i10 == 1) && !animationDrawable.isRunning()) {
                    animationDrawable.start();
                }
            } else if (i10 == 2) {
                if (animationDrawable.isRunning()) {
                    animationDrawable.stop();
                }
                animationDrawable.selectDrawable(animationDrawable.getNumberOfFrames() - 1);
            }
        }
    }

    public void c() {
        int i10;
        boolean z10;
        if (this.f2439f != 0 || this.f2447n || f2430p.a()) {
            i10 = this.f2439f;
        } else {
            i10 = 4;
        }
        super.setVisibility(i10);
        Drawable drawable = this.f2441h;
        if (drawable != null) {
            if (getVisibility() == 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            drawable.setVisible(z10, false);
        }
    }

    public boolean d() {
        if (!this.f2438e) {
            return false;
        }
        o1 k10 = this.f2434a.k();
        if (k10 == null) {
            return e(1);
        }
        if (!k10.c() || !t0.n() || !f()) {
            return e(k10.a());
        }
        return true;
    }

    public void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f2441h != null) {
            this.f2441h.setState(getDrawableState());
            invalidate();
        }
    }

    public final boolean e(int i10) {
        o fragmentManager = getFragmentManager();
        if (fragmentManager != null) {
            t0.i m10 = this.f2434a.m();
            if (m10.w() || !m10.E(this.f2436c)) {
                if (fragmentManager.h0("android.support.v7.mediarouter:MediaRouteChooserDialogFragment") != null) {
                    return false;
                }
                b b10 = this.f2437d.b();
                b10.U2(this.f2436c);
                if (i10 == 2) {
                    b10.V2(true);
                }
                y m11 = fragmentManager.m();
                m11.e(b10, "android.support.v7.mediarouter:MediaRouteChooserDialogFragment");
                m11.i();
            } else if (fragmentManager.h0("android.support.v7.mediarouter:MediaRouteControllerDialogFragment") != null) {
                return false;
            } else {
                d c10 = this.f2437d.c();
                c10.T2(this.f2436c);
                if (i10 == 2) {
                    c10.U2(true);
                }
                y m12 = fragmentManager.m();
                m12.e(c10, "android.support.v7.mediarouter:MediaRouteControllerDialogFragment");
                m12.i();
            }
            return true;
        }
        throw new IllegalStateException("The activity must be a subclass of FragmentActivity");
    }

    public final boolean f() {
        ApplicationInfo applicationInfo;
        Context context = getContext();
        Intent putExtra = new Intent().setAction("com.android.settings.panel.action.MEDIA_OUTPUT").putExtra("com.android.settings.panel.extra.PACKAGE_NAME", context.getPackageName()).putExtra("key_media_session_token", this.f2434a.j());
        for (ResolveInfo resolveInfo : context.getPackageManager().queryIntentActivities(putExtra, 0)) {
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            if (activityInfo != null && (applicationInfo = activityInfo.applicationInfo) != null && (applicationInfo.flags & 129) != 0) {
                context.startActivity(putExtra);
                return true;
            }
        }
        return false;
    }

    public final void g() {
        int i10;
        int i11 = this.f2443j;
        if (i11 == 1) {
            i10 = R$string.mr_cast_button_connecting;
        } else if (i11 != 2) {
            i10 = R$string.mr_cast_button_disconnected;
        } else {
            i10 = R$string.mr_cast_button_connected;
        }
        String string = getContext().getString(i10);
        setContentDescription(string);
        if (!this.f2448o || TextUtils.isEmpty(string)) {
            string = null;
        }
        u2.a(this, string);
    }

    public e getDialogFactory() {
        return this.f2437d;
    }

    public s0 getRouteSelector() {
        return this.f2436c;
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f2441h;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!isInEditMode()) {
            this.f2438e = true;
            if (!this.f2436c.f()) {
                this.f2434a.a(this.f2436c, this.f2435b);
            }
            b();
            f2430p.b(this);
        }
    }

    public int[] onCreateDrawableState(int i10) {
        boolean z10;
        int[] onCreateDrawableState = super.onCreateDrawableState(i10 + 1);
        t0 t0Var = this.f2434a;
        if (t0Var == null) {
            return onCreateDrawableState;
        }
        o1 k10 = t0Var.k();
        if (k10 != null) {
            z10 = k10.b().getBoolean("androidx.mediarouter.media.MediaRouterParams.FIXED_CAST_ICON");
        } else {
            z10 = false;
        }
        if (z10) {
            return onCreateDrawableState;
        }
        int i11 = this.f2443j;
        if (i11 == 1) {
            View.mergeDrawableStates(onCreateDrawableState, f2433s);
        } else if (i11 == 2) {
            View.mergeDrawableStates(onCreateDrawableState, f2432r);
        }
        return onCreateDrawableState;
    }

    public void onDetachedFromWindow() {
        if (!isInEditMode()) {
            this.f2438e = false;
            if (!this.f2436c.f()) {
                this.f2434a.q(this.f2435b);
            }
            f2430p.c(this);
        }
        super.onDetachedFromWindow();
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f2441h != null) {
            int paddingLeft = getPaddingLeft();
            int width = getWidth() - getPaddingRight();
            int paddingTop = getPaddingTop();
            int height = getHeight() - getPaddingBottom();
            int intrinsicWidth = this.f2441h.getIntrinsicWidth();
            int intrinsicHeight = this.f2441h.getIntrinsicHeight();
            int i10 = paddingLeft + (((width - paddingLeft) - intrinsicWidth) / 2);
            int i11 = paddingTop + (((height - paddingTop) - intrinsicHeight) / 2);
            this.f2441h.setBounds(i10, i11, intrinsicWidth + i10, intrinsicHeight + i11);
            this.f2441h.draw(canvas);
        }
    }

    public void onMeasure(int i10, int i11) {
        int i12;
        int size = View.MeasureSpec.getSize(i10);
        int size2 = View.MeasureSpec.getSize(i11);
        int mode = View.MeasureSpec.getMode(i10);
        int mode2 = View.MeasureSpec.getMode(i11);
        int i13 = this.f2445l;
        Drawable drawable = this.f2441h;
        int i14 = 0;
        if (drawable != null) {
            i12 = drawable.getIntrinsicWidth() + getPaddingLeft() + getPaddingRight();
        } else {
            i12 = 0;
        }
        int max = Math.max(i13, i12);
        int i15 = this.f2446m;
        Drawable drawable2 = this.f2441h;
        if (drawable2 != null) {
            i14 = drawable2.getIntrinsicHeight() + getPaddingTop() + getPaddingBottom();
        }
        int max2 = Math.max(i15, i14);
        if (mode == Integer.MIN_VALUE) {
            size = Math.min(size, max);
        } else if (mode != 1073741824) {
            size = max;
        }
        if (mode2 == Integer.MIN_VALUE) {
            size2 = Math.min(size2, max2);
        } else if (mode2 != 1073741824) {
            size2 = max2;
        }
        setMeasuredDimension(size, size2);
    }

    public boolean performClick() {
        boolean performClick = super.performClick();
        if (!performClick) {
            playSoundEffect(0);
        }
        a();
        if (d() || performClick) {
            return true;
        }
        return false;
    }

    public void setAlwaysVisible(boolean z10) {
        if (z10 != this.f2447n) {
            this.f2447n = z10;
            c();
            b();
        }
    }

    public void setCheatSheetEnabled(boolean z10) {
        if (z10 != this.f2448o) {
            this.f2448o = z10;
            g();
        }
    }

    public void setDialogFactory(e eVar) {
        if (eVar != null) {
            this.f2437d = eVar;
            return;
        }
        throw new IllegalArgumentException("factory must not be null");
    }

    public void setRemoteIndicatorDrawable(Drawable drawable) {
        this.f2442i = 0;
        setRemoteIndicatorDrawableInternal(drawable);
    }

    public void setRemoteIndicatorDrawableInternal(Drawable drawable) {
        Drawable drawable2;
        boolean z10;
        c cVar = this.f2440g;
        if (cVar != null) {
            cVar.cancel(false);
        }
        Drawable drawable3 = this.f2441h;
        if (drawable3 != null) {
            drawable3.setCallback((Drawable.Callback) null);
            unscheduleDrawable(this.f2441h);
        }
        if (drawable != null) {
            if (this.f2444k != null) {
                drawable = h.r(drawable.mutate());
                h.o(drawable, this.f2444k);
            }
            drawable.setCallback(this);
            drawable.setState(getDrawableState());
            if (getVisibility() == 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            drawable.setVisible(z10, false);
        }
        this.f2441h = drawable;
        refreshDrawableState();
        if (this.f2438e && (drawable2 = this.f2441h) != null && (drawable2.getCurrent() instanceof AnimationDrawable)) {
            AnimationDrawable animationDrawable = (AnimationDrawable) this.f2441h.getCurrent();
            int i10 = this.f2443j;
            if (i10 == 1) {
                if (!animationDrawable.isRunning()) {
                    animationDrawable.start();
                }
            } else if (i10 == 2) {
                if (animationDrawable.isRunning()) {
                    animationDrawable.stop();
                }
                animationDrawable.selectDrawable(animationDrawable.getNumberOfFrames() - 1);
            }
        }
    }

    public void setRouteSelector(s0 s0Var) {
        if (s0Var == null) {
            throw new IllegalArgumentException("selector must not be null");
        } else if (!this.f2436c.equals(s0Var)) {
            if (this.f2438e) {
                if (!this.f2436c.f()) {
                    this.f2434a.q(this.f2435b);
                }
                if (!s0Var.f()) {
                    this.f2434a.a(s0Var, this.f2435b);
                }
            }
            this.f2436c = s0Var;
            b();
        }
    }

    public void setVisibility(int i10) {
        this.f2439f = i10;
        c();
    }

    public boolean verifyDrawable(Drawable drawable) {
        if (super.verifyDrawable(drawable) || drawable == this.f2441h) {
            return true;
        }
        return false;
    }

    public MediaRouteButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.mediaRouteButtonStyle);
    }

    public MediaRouteButton(Context context, AttributeSet attributeSet, int i10) {
        super(i.a(context), attributeSet, i10);
        Drawable.ConstantState constantState;
        this.f2436c = s0.f8047c;
        this.f2437d = e.a();
        this.f2439f = 0;
        Context context2 = getContext();
        int[] iArr = R$styleable.A;
        TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, iArr, i10, 0);
        c1.i0(this, context2, iArr, attributeSet, obtainStyledAttributes, i10, 0);
        if (isInEditMode()) {
            this.f2434a = null;
            this.f2435b = null;
            this.f2441h = getResources().getDrawable(obtainStyledAttributes.getResourceId(R$styleable.MediaRouteButton_externalRouteEnabledDrawableStatic, 0));
            return;
        }
        this.f2434a = t0.i(context2);
        this.f2435b = new b();
        if (f2430p == null) {
            f2430p = new a(context2.getApplicationContext());
        }
        this.f2444k = obtainStyledAttributes.getColorStateList(R$styleable.MediaRouteButton_mediaRouteButtonTint);
        this.f2445l = obtainStyledAttributes.getDimensionPixelSize(R$styleable.MediaRouteButton_android_minWidth, 0);
        this.f2446m = obtainStyledAttributes.getDimensionPixelSize(R$styleable.MediaRouteButton_android_minHeight, 0);
        int resourceId = obtainStyledAttributes.getResourceId(R$styleable.MediaRouteButton_externalRouteEnabledDrawableStatic, 0);
        this.f2442i = obtainStyledAttributes.getResourceId(R$styleable.MediaRouteButton_externalRouteEnabledDrawable, 0);
        obtainStyledAttributes.recycle();
        int i11 = this.f2442i;
        if (!(i11 == 0 || (constantState = (Drawable.ConstantState) f2431q.get(i11)) == null)) {
            setRemoteIndicatorDrawable(constantState.newDrawable());
        }
        if (this.f2441h == null) {
            if (resourceId != 0) {
                Drawable.ConstantState constantState2 = (Drawable.ConstantState) f2431q.get(resourceId);
                if (constantState2 != null) {
                    setRemoteIndicatorDrawableInternal(constantState2.newDrawable());
                } else {
                    c cVar = new c(resourceId, getContext());
                    this.f2440g = cVar;
                    cVar.executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, new Void[0]);
                }
            } else {
                a();
            }
        }
        g();
        setClickable(true);
    }
}
