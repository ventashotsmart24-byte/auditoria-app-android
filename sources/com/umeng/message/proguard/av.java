package com.umeng.message.proguard;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;

final class av implements View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    private final int f15439a;

    /* renamed from: b  reason: collision with root package name */
    private final int f15440b;

    /* renamed from: c  reason: collision with root package name */
    private final int f15441c;

    /* renamed from: d  reason: collision with root package name */
    private final long f15442d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final View f15443e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final a f15444f;

    /* renamed from: g  reason: collision with root package name */
    private int f15445g = 1;

    /* renamed from: h  reason: collision with root package name */
    private float f15446h;

    /* renamed from: i  reason: collision with root package name */
    private float f15447i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f15448j;

    /* renamed from: k  reason: collision with root package name */
    private int f15449k;

    /* renamed from: l  reason: collision with root package name */
    private VelocityTracker f15450l;

    /* renamed from: m  reason: collision with root package name */
    private float f15451m;

    public static abstract class a {
        public abstract void a(View view);
    }

    public av(View view, a aVar) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(view.getContext());
        this.f15439a = viewConfiguration.getScaledTouchSlop();
        this.f15440b = viewConfiguration.getScaledMinimumFlingVelocity() * 16;
        this.f15441c = viewConfiguration.getScaledMaximumFlingVelocity();
        this.f15442d = (long) view.getContext().getResources().getInteger(17694720);
        this.f15443e = view;
        this.f15444f = aVar;
    }

    public final void a(float f10) {
        this.f15443e.setTranslationY(f10);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:38:0x010c, code lost:
        if (r13.f15448j != false) goto L_0x012f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean onTouch(android.view.View r14, android.view.MotionEvent r15) {
        /*
            r13 = this;
            float r14 = r13.f15451m
            r0 = 0
            r15.offsetLocation(r0, r14)
            int r14 = r13.f15445g
            r1 = 2
            if (r14 >= r1) goto L_0x0013
            android.view.View r14 = r13.f15443e
            int r14 = r14.getHeight()
            r13.f15445g = r14
        L_0x0013:
            int r14 = r15.getActionMasked()
            r2 = 0
            if (r14 == 0) goto L_0x0157
            r3 = 0
            r4 = 1065353216(0x3f800000, float:1.0)
            r5 = 1
            if (r14 == r5) goto L_0x00c9
            r6 = 3
            if (r14 == r1) goto L_0x003f
            if (r14 == r6) goto L_0x0027
            goto L_0x0156
        L_0x0027:
            android.view.VelocityTracker r14 = r13.f15450l
            if (r14 == 0) goto L_0x0156
            r13.a(r0, r4, r3)
            android.view.VelocityTracker r14 = r13.f15450l
            r14.recycle()
            r13.f15450l = r3
            r13.f15451m = r0
            r13.f15446h = r0
            r13.f15447i = r0
            r13.f15448j = r2
            goto L_0x0156
        L_0x003f:
            android.view.VelocityTracker r14 = r13.f15450l
            if (r14 == 0) goto L_0x0156
            r14.addMovement(r15)
            float r14 = r15.getRawX()
            float r1 = r13.f15446h
            float r14 = r14 - r1
            float r1 = r15.getRawY()
            float r3 = r13.f15447i
            float r1 = r1 - r3
            float r3 = java.lang.Math.abs(r1)
            int r7 = r13.f15439a
            float r7 = (float) r7
            int r3 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r3 <= 0) goto L_0x009b
            float r3 = java.lang.Math.abs(r14)
            float r7 = java.lang.Math.abs(r1)
            r8 = 1073741824(0x40000000, float:2.0)
            float r7 = r7 / r8
            int r3 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r3 >= 0) goto L_0x009b
            r13.f15448j = r5
            int r14 = (r14 > r0 ? 1 : (r14 == r0 ? 0 : -1))
            if (r14 <= 0) goto L_0x0077
            int r14 = r13.f15439a
            goto L_0x007a
        L_0x0077:
            int r14 = r13.f15439a
            int r14 = -r14
        L_0x007a:
            r13.f15449k = r14
            android.view.View r14 = r13.f15443e
            android.view.ViewParent r14 = r14.getParent()
            r14.requestDisallowInterceptTouchEvent(r5)
            android.view.MotionEvent r14 = android.view.MotionEvent.obtain(r15)
            int r15 = r15.getActionIndex()
            int r15 = r15 << 8
            r15 = r15 | r6
            r14.setAction(r15)
            android.view.View r15 = r13.f15443e
            r15.onTouchEvent(r14)
            r14.recycle()
        L_0x009b:
            boolean r14 = r13.f15448j
            if (r14 == 0) goto L_0x0156
            int r14 = r13.f15449k
            float r14 = (float) r14
            float r14 = r1 - r14
            int r15 = (r14 > r0 ? 1 : (r14 == r0 ? 0 : -1))
            if (r15 <= 0) goto L_0x00aa
            r14 = 0
            r1 = 0
        L_0x00aa:
            r13.f15451m = r1
            r13.a((float) r14)
            r14 = 1056964608(0x3f000000, float:0.5)
            float r15 = java.lang.Math.abs(r1)
            float r15 = r15 * r14
            int r14 = r13.f15445g
            float r14 = (float) r14
            float r15 = r15 / r14
            float r14 = r4 - r15
            float r14 = java.lang.Math.min(r4, r14)
            float r14 = java.lang.Math.max(r0, r14)
            r13.b((float) r14)
            return r5
        L_0x00c9:
            android.view.VelocityTracker r14 = r13.f15450l
            if (r14 == 0) goto L_0x0156
            float r14 = r15.getRawY()
            float r1 = r13.f15447i
            float r14 = r14 - r1
            android.view.VelocityTracker r1 = r13.f15450l
            r1.addMovement(r15)
            android.view.VelocityTracker r15 = r13.f15450l
            r1 = 1000(0x3e8, float:1.401E-42)
            r15.computeCurrentVelocity(r1)
            android.view.VelocityTracker r15 = r13.f15450l
            float r15 = r15.getXVelocity()
            android.view.VelocityTracker r1 = r13.f15450l
            float r1 = r1.getYVelocity()
            float r15 = java.lang.Math.abs(r15)
            float r6 = java.lang.Math.abs(r1)
            int r7 = (r14 > r0 ? 1 : (r14 == r0 ? 0 : -1))
            if (r7 >= 0) goto L_0x010f
            float r7 = java.lang.Math.abs(r14)
            double r7 = (double) r7
            int r9 = r13.f15445g
            double r9 = (double) r9
            r11 = 4611686018427387904(0x4000000000000000, double:2.0)
            java.lang.Double.isNaN(r9)
            double r9 = r9 / r11
            int r11 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r11 <= 0) goto L_0x010f
            boolean r7 = r13.f15448j
            if (r7 == 0) goto L_0x010f
            goto L_0x012f
        L_0x010f:
            int r7 = r13.f15440b
            float r7 = (float) r7
            int r7 = (r7 > r6 ? 1 : (r7 == r6 ? 0 : -1))
            if (r7 > 0) goto L_0x012e
            int r7 = r13.f15441c
            float r7 = (float) r7
            int r7 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1))
            if (r7 > 0) goto L_0x012e
            int r15 = (r15 > r6 ? 1 : (r15 == r6 ? 0 : -1))
            if (r15 >= 0) goto L_0x012e
            boolean r15 = r13.f15448j
            if (r15 == 0) goto L_0x012e
            int r15 = (r1 > r0 ? 1 : (r1 == r0 ? 0 : -1))
            if (r15 >= 0) goto L_0x012e
            int r14 = (r14 > r0 ? 1 : (r14 == r0 ? 0 : -1))
            if (r14 >= 0) goto L_0x012e
            goto L_0x012f
        L_0x012e:
            r5 = 0
        L_0x012f:
            if (r5 == 0) goto L_0x013e
            int r14 = r13.f15445g
            int r14 = -r14
            float r14 = (float) r14
            com.umeng.message.proguard.av$1 r15 = new com.umeng.message.proguard.av$1
            r15.<init>()
            r13.a(r14, r0, r15)
            goto L_0x0145
        L_0x013e:
            boolean r14 = r13.f15448j
            if (r14 == 0) goto L_0x0145
            r13.a(r0, r4, r3)
        L_0x0145:
            android.view.VelocityTracker r14 = r13.f15450l
            if (r14 == 0) goto L_0x014c
            r14.recycle()
        L_0x014c:
            r13.f15450l = r3
            r13.f15451m = r0
            r13.f15446h = r0
            r13.f15447i = r0
            r13.f15448j = r2
        L_0x0156:
            return r2
        L_0x0157:
            float r14 = r15.getRawX()
            r13.f15446h = r14
            float r14 = r15.getRawY()
            r13.f15447i = r14
            android.view.VelocityTracker r14 = android.view.VelocityTracker.obtain()
            r13.f15450l = r14
            r14.addMovement(r15)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.message.proguard.av.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    private void a(float f10, float f11, AnimatorListenerAdapter animatorListenerAdapter) {
        final float translationY = this.f15443e.getTranslationY();
        final float f12 = f10 - translationY;
        final float alpha = this.f15443e.getAlpha();
        final float f13 = f11 - alpha;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        ofFloat.setDuration(this.f15442d);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = translationY + (valueAnimator.getAnimatedFraction() * f12);
                float animatedFraction2 = alpha + (valueAnimator.getAnimatedFraction() * f13);
                av.this.a(animatedFraction);
                av.this.b(animatedFraction2);
            }
        });
        if (animatorListenerAdapter != null) {
            ofFloat.addListener(animatorListenerAdapter);
        }
        ofFloat.start();
    }

    public final void b(float f10) {
        this.f15443e.setAlpha(f10);
    }

    public static /* synthetic */ void a(av avVar) {
        final ViewGroup.LayoutParams layoutParams = avVar.f15443e.getLayoutParams();
        final int width = avVar.f15443e.getWidth();
        ValueAnimator duration = ValueAnimator.ofInt(new int[]{width, 1}).setDuration(avVar.f15442d);
        duration.addListener(new AnimatorListenerAdapter() {
            public final void onAnimationEnd(Animator animator) {
                av.this.f15444f.a(av.this.f15443e);
                av.this.f15443e.setAlpha(1.0f);
                av.this.f15443e.setTranslationY(0.0f);
                layoutParams.width = width;
                av.this.f15443e.setLayoutParams(layoutParams);
            }
        });
        duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                layoutParams.width = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                av.this.f15443e.setLayoutParams(layoutParams);
            }
        });
        duration.start();
    }
}
