package com.umeng.message.proguard;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;

public final class ek implements View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    private final int f15925a;

    /* renamed from: b  reason: collision with root package name */
    private final int f15926b;

    /* renamed from: c  reason: collision with root package name */
    private final int f15927c;

    /* renamed from: d  reason: collision with root package name */
    private final long f15928d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final View f15929e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final View.OnClickListener f15930f;

    /* renamed from: g  reason: collision with root package name */
    private int f15931g = 1;

    /* renamed from: h  reason: collision with root package name */
    private float f15932h;

    /* renamed from: i  reason: collision with root package name */
    private float f15933i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f15934j;

    /* renamed from: k  reason: collision with root package name */
    private int f15935k;

    /* renamed from: l  reason: collision with root package name */
    private VelocityTracker f15936l;

    /* renamed from: m  reason: collision with root package name */
    private float f15937m;

    public ek(View view, View.OnClickListener onClickListener) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(view.getContext());
        this.f15925a = viewConfiguration.getScaledTouchSlop();
        this.f15926b = viewConfiguration.getScaledMinimumFlingVelocity() * 16;
        this.f15927c = viewConfiguration.getScaledMaximumFlingVelocity();
        this.f15928d = (long) view.getContext().getResources().getInteger(17694720);
        this.f15929e = view;
        this.f15930f = onClickListener;
    }

    public final void a(float f10) {
        this.f15929e.setTranslationY(f10);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:38:0x010a, code lost:
        if (r13.f15934j != false) goto L_0x012d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean onTouch(android.view.View r14, android.view.MotionEvent r15) {
        /*
            r13 = this;
            float r14 = r13.f15937m
            r0 = 0
            r15.offsetLocation(r0, r14)
            int r14 = r13.f15931g
            r1 = 2
            if (r14 >= r1) goto L_0x0013
            android.view.View r14 = r13.f15929e
            int r14 = r14.getHeight()
            r13.f15931g = r14
        L_0x0013:
            int r14 = r15.getActionMasked()
            r2 = 0
            if (r14 == 0) goto L_0x0155
            r3 = 0
            r4 = 1065353216(0x3f800000, float:1.0)
            r5 = 1
            if (r14 == r5) goto L_0x00c7
            r6 = 3
            if (r14 == r1) goto L_0x003f
            if (r14 == r6) goto L_0x0027
            goto L_0x0154
        L_0x0027:
            android.view.VelocityTracker r14 = r13.f15936l
            if (r14 == 0) goto L_0x0154
            r13.a(r0, r4, r3)
            android.view.VelocityTracker r14 = r13.f15936l
            r14.recycle()
            r13.f15936l = r3
            r13.f15937m = r0
            r13.f15932h = r0
            r13.f15933i = r0
            r13.f15934j = r2
            goto L_0x0154
        L_0x003f:
            android.view.VelocityTracker r14 = r13.f15936l
            if (r14 == 0) goto L_0x0154
            r14.addMovement(r15)
            float r14 = r15.getRawX()
            float r1 = r13.f15932h
            float r14 = r14 - r1
            float r1 = r15.getRawY()
            float r3 = r13.f15933i
            float r1 = r1 - r3
            float r3 = java.lang.Math.abs(r1)
            int r7 = r13.f15925a
            float r7 = (float) r7
            r8 = 1073741824(0x40000000, float:2.0)
            int r3 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r3 <= 0) goto L_0x009b
            float r3 = java.lang.Math.abs(r14)
            float r7 = java.lang.Math.abs(r1)
            float r7 = r7 / r8
            int r3 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r3 >= 0) goto L_0x009b
            r13.f15934j = r5
            int r3 = (r14 > r0 ? 1 : (r14 == r0 ? 0 : -1))
            if (r3 <= 0) goto L_0x0077
            int r3 = r13.f15925a
            goto L_0x007a
        L_0x0077:
            int r3 = r13.f15925a
            int r3 = -r3
        L_0x007a:
            r13.f15935k = r3
            android.view.View r3 = r13.f15929e
            android.view.ViewParent r3 = r3.getParent()
            r3.requestDisallowInterceptTouchEvent(r5)
            android.view.MotionEvent r3 = android.view.MotionEvent.obtain(r15)
            int r15 = r15.getActionIndex()
            int r15 = r15 << 8
            r15 = r15 | r6
            r3.setAction(r15)
            android.view.View r15 = r13.f15929e
            r15.onTouchEvent(r3)
            r3.recycle()
        L_0x009b:
            boolean r15 = r13.f15934j
            if (r15 == 0) goto L_0x0154
            int r15 = r13.f15935k
            float r15 = (float) r15
            float r15 = r1 - r15
            int r2 = (r15 > r0 ? 1 : (r15 == r0 ? 0 : -1))
            if (r2 <= 0) goto L_0x00aa
            r15 = 0
            r1 = 0
        L_0x00aa:
            r13.f15937m = r1
            r13.a((float) r15)
            float r14 = java.lang.Math.abs(r14)
            float r14 = r14 * r8
            int r15 = r13.f15931g
            float r15 = (float) r15
            float r14 = r14 / r15
            float r14 = r4 - r14
            float r14 = java.lang.Math.min(r4, r14)
            float r14 = java.lang.Math.max(r0, r14)
            r13.b((float) r14)
            return r5
        L_0x00c7:
            android.view.VelocityTracker r14 = r13.f15936l
            if (r14 == 0) goto L_0x0154
            float r14 = r15.getRawY()
            float r1 = r13.f15933i
            float r14 = r14 - r1
            android.view.VelocityTracker r1 = r13.f15936l
            r1.addMovement(r15)
            android.view.VelocityTracker r15 = r13.f15936l
            r1 = 1000(0x3e8, float:1.401E-42)
            r15.computeCurrentVelocity(r1)
            android.view.VelocityTracker r15 = r13.f15936l
            float r15 = r15.getXVelocity()
            android.view.VelocityTracker r1 = r13.f15936l
            float r1 = r1.getYVelocity()
            float r15 = java.lang.Math.abs(r15)
            float r6 = java.lang.Math.abs(r1)
            int r7 = (r14 > r0 ? 1 : (r14 == r0 ? 0 : -1))
            if (r7 >= 0) goto L_0x010d
            float r7 = java.lang.Math.abs(r14)
            double r7 = (double) r7
            int r9 = r13.f15931g
            double r9 = (double) r9
            r11 = 4611686018427387904(0x4000000000000000, double:2.0)
            java.lang.Double.isNaN(r9)
            double r9 = r9 / r11
            int r11 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r11 <= 0) goto L_0x010d
            boolean r7 = r13.f15934j
            if (r7 == 0) goto L_0x010d
            goto L_0x012d
        L_0x010d:
            int r7 = r13.f15926b
            float r7 = (float) r7
            int r7 = (r7 > r6 ? 1 : (r7 == r6 ? 0 : -1))
            if (r7 > 0) goto L_0x012c
            int r7 = r13.f15927c
            float r7 = (float) r7
            int r7 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1))
            if (r7 > 0) goto L_0x012c
            int r15 = (r15 > r6 ? 1 : (r15 == r6 ? 0 : -1))
            if (r15 >= 0) goto L_0x012c
            boolean r15 = r13.f15934j
            if (r15 == 0) goto L_0x012c
            int r15 = (r1 > r0 ? 1 : (r1 == r0 ? 0 : -1))
            if (r15 >= 0) goto L_0x012c
            int r14 = (r14 > r0 ? 1 : (r14 == r0 ? 0 : -1))
            if (r14 >= 0) goto L_0x012c
            goto L_0x012d
        L_0x012c:
            r5 = 0
        L_0x012d:
            if (r5 == 0) goto L_0x013c
            int r14 = r13.f15931g
            int r14 = -r14
            float r14 = (float) r14
            com.umeng.message.proguard.ek$1 r15 = new com.umeng.message.proguard.ek$1
            r15.<init>()
            r13.a(r14, r0, r15)
            goto L_0x0143
        L_0x013c:
            boolean r14 = r13.f15934j
            if (r14 == 0) goto L_0x0143
            r13.a(r0, r4, r3)
        L_0x0143:
            android.view.VelocityTracker r14 = r13.f15936l
            if (r14 == 0) goto L_0x014a
            r14.recycle()
        L_0x014a:
            r13.f15936l = r3
            r13.f15937m = r0
            r13.f15932h = r0
            r13.f15933i = r0
            r13.f15934j = r2
        L_0x0154:
            return r2
        L_0x0155:
            float r14 = r15.getRawX()
            r13.f15932h = r14
            float r14 = r15.getRawY()
            r13.f15933i = r14
            android.view.VelocityTracker r14 = android.view.VelocityTracker.obtain()
            r13.f15936l = r14
            r14.addMovement(r15)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.message.proguard.ek.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    private void a(float f10, float f11, AnimatorListenerAdapter animatorListenerAdapter) {
        final float translationY = this.f15929e.getTranslationY();
        final float f12 = f10 - translationY;
        final float alpha = this.f15929e.getAlpha();
        final float f13 = f11 - alpha;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        ofFloat.setDuration(this.f15928d);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = translationY + (valueAnimator.getAnimatedFraction() * f12);
                float animatedFraction2 = alpha + (valueAnimator.getAnimatedFraction() * f13);
                ek.this.a(animatedFraction);
                ek.this.b(animatedFraction2);
            }
        });
        if (animatorListenerAdapter != null) {
            ofFloat.addListener(animatorListenerAdapter);
        }
        ofFloat.start();
    }

    public final void b(float f10) {
        this.f15929e.setAlpha(f10);
    }

    public static /* synthetic */ void a(ek ekVar) {
        final ViewGroup.LayoutParams layoutParams = ekVar.f15929e.getLayoutParams();
        final int width = ekVar.f15929e.getWidth();
        ValueAnimator duration = ValueAnimator.ofInt(new int[]{width, 1}).setDuration(ekVar.f15928d);
        duration.addListener(new AnimatorListenerAdapter() {
            public final void onAnimationEnd(Animator animator) {
                ek.this.f15930f.onClick(ek.this.f15929e);
                ek.this.f15929e.setAlpha(1.0f);
                ek.this.f15929e.setTranslationY(0.0f);
                layoutParams.width = width;
                ek.this.f15929e.setLayoutParams(layoutParams);
            }
        });
        duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                layoutParams.width = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                ek.this.f15929e.setLayoutParams(layoutParams);
            }
        });
        duration.start();
    }
}
