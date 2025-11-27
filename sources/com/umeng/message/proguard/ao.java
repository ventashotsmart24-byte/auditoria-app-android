package com.umeng.message.proguard;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import com.hpplay.sdk.source.common.global.Constant;
import com.umeng.message.common.UPLog;
import com.umeng.message.proguard.ao;
import com.umeng.message.proguard.av;
import java.lang.ref.WeakReference;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public final class ao {

    /* renamed from: a  reason: collision with root package name */
    private static final as f15398a = new as();
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static WeakReference<Activity> f15399b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static Future<?> f15400c;

    public static abstract class a {
        public abstract void a(ap apVar, boolean z10);
    }

    private static void c() {
        Future<?> future = f15400c;
        if (future != null && !future.isDone() && !future.isCancelled()) {
            future.cancel(false);
        }
        f15400c = null;
    }

    public static void a(Activity activity, ap apVar, a aVar) {
        c();
        f15399b = new WeakReference<>(activity);
        activity.runOnUiThread(new Runnable(activity, new aq(activity, apVar), aVar) {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ Activity f15416a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ aq f15417b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ ao.a f15418c;

            {
                this.f15416a = r2;
                this.f15417b = r3;
                this.f15418c = r4;
            }

            public final void run() {
                boolean z10;
                try {
                    if (this.f15416a.isFinishing()) {
                        UPLog.e("Pop", "Activity finish. cannot show");
                        try {
                            this.f15418c.a(this.f15417b.b(), false);
                            return;
                        } catch (Throwable th) {
                            UPLog.e("Pop", "callback fail", th.getMessage());
                            return;
                        }
                    } else {
                        if (as.this.a()) {
                            as.this.a(this.f15416a);
                        }
                        WindowManager a10 = as.a((Context) this.f15416a);
                        at atVar = this.f15417b.f15405b;
                        if (ak.a().c().f15395g) {
                            as asVar = as.this;
                            aq aqVar = this.f15417b;
                            av avVar = null;
                            if (aqVar != null) {
                                View.OnClickListener onClickListener = aqVar.f15406c;
                                if (onClickListener != null) {
                                    avVar = new av(aqVar.f15405b, new av.a(onClickListener) {

                                        /* renamed from: a  reason: collision with root package name */
                                        final /* synthetic */ View.OnClickListener f15425a;

                                        {
                                            this.f15425a = r2;
                                        }

                                        public final void a(View view) {
                                            this.f15425a.onClick(view);
                                        }
                                    });
                                }
                            }
                            this.f15417b.f15405b.setOnTouchListener(avVar);
                        }
                        Activity activity = this.f15416a;
                        int i10 = this.f15417b.f15407d;
                        Point point = new Point();
                        as.a((Context) activity).getDefaultDisplay().getRealSize(point);
                        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(Math.min(point.x, point.y) - bo.a(32.0f), i10, Constant.STOP_FROM_SINK, 327968, -3);
                        Rect rect = new Rect();
                        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                        layoutParams.y = Math.min(rect.top, bo.a(56.0f)) + bo.a(4.0f);
                        layoutParams.dimAmount = 0.3f;
                        layoutParams.gravity = 49;
                        layoutParams.windowAnimations = 0;
                        a10.addView(atVar, layoutParams);
                        as asVar2 = as.this;
                        asVar2.f15415a = this.f15417b;
                        try {
                            atVar.setAlpha(0.0f);
                            atVar.measure(-2, -2);
                            atVar.animate().translationX(0.0f).translationY((float) (atVar.getMeasuredHeight() * -1)).setDuration(1).setListener(new AnimatorListenerAdapter(atVar) {

                                /* renamed from: a  reason: collision with root package name */
                                final /* synthetic */ View f15420a;

                                {
                                    this.f15420a = r2;
                                }

                                public final void onAnimationEnd(Animator animator) {
                                    super.onAnimationEnd(animator);
                                    this.f15420a.animate().translationX(0.0f).translationY(0.0f).alpha(1.0f).setDuration(500).setListener((Animator.AnimatorListener) null);
                                }
                            });
                            try {
                                this.f15418c.a(this.f15417b.b(), true);
                                return;
                            } catch (Throwable th2) {
                                UPLog.e("Pop", "callback fail", th2.getMessage());
                                return;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            z10 = true;
                            try {
                                UPLog.e("Pop", "show fail", th.getMessage());
                                try {
                                    this.f15418c.a(this.f15417b.b(), z10);
                                    return;
                                } catch (Throwable th4) {
                                    UPLog.e("Pop", "callback fail", th4.getMessage());
                                    return;
                                }
                            } catch (Throwable th5) {
                                UPLog.e("Pop", "callback fail", th5.getMessage());
                            }
                        }
                    }
                } catch (Throwable th6) {
                    th = th6;
                    z10 = false;
                    UPLog.e("Pop", "show fail", th.getMessage());
                    this.f15418c.a(this.f15417b.b(), z10);
                    return;
                }
                throw th;
            }
        });
        f15400c = b.a(new Runnable() {
            public final void run() {
                Activity activity;
                WeakReference a10 = ao.f15399b;
                if (a10 != null && (activity = (Activity) a10.get()) != null) {
                    Future unused = ao.f15400c = null;
                    ao.a(activity);
                }
            }
        }, ak.a().c().f15389a, TimeUnit.MILLISECONDS);
    }

    public static void a(Activity activity) {
        try {
            c();
            f15398a.a(activity);
        } catch (Throwable unused) {
        }
        f15399b = null;
    }

    public static void a(String str) {
        Activity activity;
        WeakReference<Activity> weakReference = f15399b;
        if (weakReference != null && (activity = weakReference.get()) != null && !activity.isFinishing()) {
            aq aqVar = f15398a.f15415a;
            boolean z10 = false;
            if (aqVar != null && TextUtils.equals(str, aqVar.a())) {
                z10 = aqVar.f15405b.isShown();
            }
            if (z10) {
                a(activity);
            }
        }
    }
}
