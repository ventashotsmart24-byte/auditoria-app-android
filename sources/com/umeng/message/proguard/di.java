package com.umeng.message.proguard;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.hpplay.sdk.source.common.global.Constant;
import java.lang.ref.WeakReference;

final class di {

    /* renamed from: a  reason: collision with root package name */
    WeakReference<dl> f15783a;

    public final boolean a(final dl dlVar, Activity activity) {
        int i10;
        try {
            if (activity.isFinishing()) {
                ce.d("Banner", "Activity is finishing or does not have valid window token. Cannot show");
                return false;
            }
            Point a10 = ed.a((Context) activity);
            int min = Math.min(a10.x, a10.y);
            int max = Math.max(a10.x, a10.y);
            int a11 = min - ed.a(32.0f);
            if (dlVar.f15789a.a()) {
                Bitmap bitmap = dlVar.f15789a.f15787b;
                i10 = (bitmap.getHeight() * a11) / bitmap.getWidth();
                int min2 = Math.min(Math.min(max / 5, ed.a(144.0f)), i10);
                if (i10 > min2) {
                    a11 = (a11 * min2) / i10;
                    i10 = min2;
                }
            } else {
                i10 = ed.a(80.0f);
            }
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(a11, i10, Constant.STOP_FROM_SINK, 327968, -3);
            Rect rect = new Rect();
            activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
            layoutParams.y = Math.min(rect.top, ed.a(56.0f)) + ed.a(4.0f);
            layoutParams.dimAmount = 0.3f;
            layoutParams.gravity = 49;
            layoutParams.windowAnimations = 0;
            WindowManager a12 = a((Context) activity);
            ef efVar = dlVar.f15791c;
            if (efVar.getParent() != null) {
                ((ViewGroup) efVar.getParent()).removeView(efVar);
            }
            a12.addView(efVar, layoutParams);
            if (dlVar.f15789a.f15786a.f15606b.optInt("f_close", 0) == 1) {
                dlVar.f15791c.setOnTouchListener(new ek(dlVar.f15791c, new View.OnClickListener() {
                    public final void onClick(View view) {
                        View.OnClickListener onClickListener = dlVar.f15792d;
                        if (onClickListener != null) {
                            onClickListener.onClick(view);
                        }
                    }
                }));
            }
            this.f15783a = new WeakReference<>(dlVar);
            return true;
        } catch (Throwable th) {
            ce.d("Banner", "show failed:", th.getMessage());
            return false;
        }
    }

    public final boolean a() {
        dl dlVar;
        WeakReference<dl> weakReference = this.f15783a;
        if (weakReference == null || (dlVar = weakReference.get()) == null) {
            return false;
        }
        return dlVar.f15791c.isShown();
    }

    public final void a(Activity activity) {
        try {
            WeakReference<dl> weakReference = this.f15783a;
            if (weakReference != null) {
                dl dlVar = weakReference.get();
                if (dlVar != null) {
                    a((Context) activity).removeViewImmediate(dlVar.f15791c);
                    Bitmap bitmap = dlVar.f15789a.f15787b;
                    if (bitmap != null && !bitmap.isRecycled()) {
                        bitmap.recycle();
                    }
                } else {
                    return;
                }
            }
        } catch (Throwable unused) {
        }
        this.f15783a = null;
    }

    private static WindowManager a(Context context) {
        return (WindowManager) context.getSystemService("window");
    }
}
