package com.umeng.message.proguard;

import android.content.Context;
import android.content.res.Configuration;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import java.util.concurrent.atomic.AtomicLong;

public class eh extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private a f15899a;

    /* renamed from: b  reason: collision with root package name */
    private Boolean f15900b;

    public static abstract class a {

        /* renamed from: a  reason: collision with root package name */
        private final AtomicLong f15901a = new AtomicLong(-1);

        /* renamed from: b  reason: collision with root package name */
        private final AtomicLong f15902b = new AtomicLong(0);

        /* renamed from: c  reason: collision with root package name */
        private boolean f15903c = false;

        /* renamed from: f  reason: collision with root package name */
        View f15904f;

        /* renamed from: g  reason: collision with root package name */
        public float f15905g = -1.0f;

        /* renamed from: h  reason: collision with root package name */
        public float f15906h = -1.0f;

        /* renamed from: i  reason: collision with root package name */
        public float f15907i = -1.0f;

        /* renamed from: j  reason: collision with root package name */
        public float f15908j = -1.0f;

        /* renamed from: k  reason: collision with root package name */
        public float f15909k = -1.0f;

        /* renamed from: l  reason: collision with root package name */
        public float f15910l = -1.0f;

        /* renamed from: m  reason: collision with root package name */
        public float f15911m = -1.0f;

        /* renamed from: n  reason: collision with root package name */
        public float f15912n = -1.0f;

        public void a() {
        }

        public void b() {
        }

        public abstract void c();

        public abstract void d();

        public final long e() {
            long j10 = this.f15902b.get();
            if (this.f15901a.get() != -1) {
                return j10 + (SystemClock.elapsedRealtime() - this.f15901a.get());
            }
            return j10;
        }

        public void a(Configuration configuration) {
        }

        public final void a(boolean z10) {
            if (this.f15903c != z10) {
                this.f15903c = z10;
                if (!z10) {
                    if (this.f15901a.get() != -1) {
                        AtomicLong atomicLong = this.f15902b;
                        atomicLong.set((atomicLong.get() + SystemClock.elapsedRealtime()) - this.f15901a.get());
                    }
                    this.f15901a.set(-1);
                } else if (this.f15901a.get() == -1) {
                    this.f15901a.set(SystemClock.elapsedRealtime());
                }
            }
        }
    }

    public eh(Context context) {
        super(context);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.f15899a != null) {
            int action = motionEvent.getAction() & 255;
            if (action == 0) {
                this.f15899a.f15905g = motionEvent.getX();
                this.f15899a.f15907i = motionEvent.getY();
                this.f15899a.f15909k = motionEvent.getRawX();
                this.f15899a.f15910l = motionEvent.getRawY();
            } else if (action == 1) {
                this.f15899a.f15906h = motionEvent.getX();
                this.f15899a.f15908j = motionEvent.getY();
                this.f15899a.f15911m = motionEvent.getRawX();
                this.f15899a.f15912n = motionEvent.getRawY();
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public a getOnStatusListener() {
        return this.f15899a;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f15900b = Boolean.TRUE;
        a aVar = this.f15899a;
        if (aVar != null) {
            aVar.c();
            aVar.a(true);
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        a aVar = this.f15899a;
        if (aVar != null) {
            aVar.a(configuration);
        }
    }

    public void onDetachedFromWindow() {
        a aVar;
        super.onDetachedFromWindow();
        if (this.f15900b.booleanValue() && (aVar = this.f15899a) != null) {
            aVar.a(false);
            aVar.d();
        }
        this.f15900b = Boolean.FALSE;
    }

    public void onVisibilityChanged(View view, int i10) {
        boolean z10;
        super.onVisibilityChanged(view, i10);
        a aVar = this.f15899a;
        if (aVar != null) {
            if (!hasWindowFocus() || i10 != 0) {
                z10 = false;
            } else {
                z10 = true;
            }
            aVar.a(z10);
        }
    }

    public void onWindowFocusChanged(boolean z10) {
        boolean z11;
        super.onWindowFocusChanged(z10);
        a aVar = this.f15899a;
        if (aVar != null) {
            if (!z10 || getVisibility() != 0) {
                z11 = false;
            } else {
                z11 = true;
            }
            aVar.a(z11);
            if (z10) {
                aVar.a();
            } else {
                aVar.b();
            }
        }
    }

    public void onWindowVisibilityChanged(int i10) {
        boolean z10;
        super.onWindowVisibilityChanged(i10);
        a aVar = this.f15899a;
        if (aVar != null) {
            if (!hasWindowFocus() || i10 != 0) {
                z10 = false;
            } else {
                z10 = true;
            }
            aVar.a(z10);
        }
    }

    public void setOnStatusListener(a aVar) {
        Boolean bool;
        if (aVar != null) {
            aVar.f15904f = this;
        }
        this.f15899a = aVar;
        if (aVar != null && (bool = this.f15900b) != null) {
            if (bool.booleanValue()) {
                aVar.c();
                aVar.a(true);
                return;
            }
            aVar.a(false);
            aVar.d();
        }
    }
}
