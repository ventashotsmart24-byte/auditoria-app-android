package com.google.android.gms.cast.framework.internal.featurehighlight;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import b0.i;
import com.google.android.gms.cast.framework.R;
import com.google.android.gms.internal.cast.zzcr;
import com.google.android.gms.internal.cast.zzda;

public final class zzh extends ViewGroup {
    private final int[] zza = new int[2];
    private final Rect zzb = new Rect();
    private final Rect zzc = new Rect();
    /* access modifiers changed from: private */
    public final OuterHighlightDrawable zzd;
    private final InnerZoneDrawable zze;
    private View zzf;
    /* access modifiers changed from: private */
    public Animator zzg;
    private final zzi zzh;
    private final i zzi;
    private i zzj;
    /* access modifiers changed from: private */
    public zzg zzk;
    private boolean zzl;
    private HelpTextView zzm;

    public zzh(Context context) {
        super(context);
        setId(R.id.cast_featurehighlight_view);
        setWillNotDraw(false);
        InnerZoneDrawable innerZoneDrawable = new InnerZoneDrawable(context);
        this.zze = innerZoneDrawable;
        innerZoneDrawable.setCallback(this);
        OuterHighlightDrawable outerHighlightDrawable = new OuterHighlightDrawable(context);
        this.zzd = outerHighlightDrawable;
        outerHighlightDrawable.setCallback(this);
        this.zzh = new zzi(this);
        i iVar = new i(context, new zza(this));
        this.zzi = iVar;
        iVar.b(false);
        setVisibility(8);
    }

    public static /* synthetic */ Animator zzb(zzh zzh2) {
        InnerZoneDrawable innerZoneDrawable = zzh2.zze;
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator duration = ObjectAnimator.ofFloat(innerZoneDrawable, "scale", new float[]{1.0f, 1.1f}).setDuration(500);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(innerZoneDrawable, "scale", new float[]{1.1f, 1.0f}).setDuration(500);
        ObjectAnimator duration3 = ObjectAnimator.ofPropertyValuesHolder(innerZoneDrawable, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat("pulseScale", new float[]{1.1f, 2.0f}), PropertyValuesHolder.ofFloat("pulseAlpha", new float[]{1.0f, 0.0f})}).setDuration(500);
        animatorSet.play(duration);
        animatorSet.play(duration2).with(duration3).after(duration);
        animatorSet.setInterpolator(zzda.zzb());
        animatorSet.setStartDelay(500);
        zzcr.zzd(animatorSet, -1, (Runnable) null);
        return animatorSet;
    }

    private final void zzq(Animator animator) {
        Animator animator2 = this.zzg;
        if (animator2 != null) {
            animator2.cancel();
        }
        this.zzg = animator;
        animator.start();
    }

    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams;
    }

    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-2, -2);
    }

    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    public final void onDraw(Canvas canvas) {
        canvas.save();
        this.zzd.draw(canvas);
        this.zze.draw(canvas);
        View view = this.zzf;
        if (view != null) {
            if (view.getParent() != null) {
                Bitmap createBitmap = Bitmap.createBitmap(this.zzf.getWidth(), this.zzf.getHeight(), Bitmap.Config.ARGB_8888);
                this.zzf.draw(new Canvas(createBitmap));
                int zzc2 = this.zzd.zzc();
                int red = Color.red(zzc2);
                int green = Color.green(zzc2);
                int blue = Color.blue(zzc2);
                for (int i10 = 0; i10 < createBitmap.getHeight(); i10++) {
                    for (int i11 = 0; i11 < createBitmap.getWidth(); i11++) {
                        int pixel = createBitmap.getPixel(i11, i10);
                        if (Color.alpha(pixel) != 0) {
                            createBitmap.setPixel(i11, i10, Color.argb(Color.alpha(pixel), red, green, blue));
                        }
                    }
                }
                Rect rect = this.zzb;
                canvas.drawBitmap(createBitmap, (float) rect.left, (float) rect.top, (Paint) null);
            }
            canvas.restore();
            return;
        }
        throw new IllegalStateException("Neither target view nor drawable was set");
    }

    public final void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        View view = this.zzf;
        if (view != null) {
            if (view.getParent() != null) {
                int[] iArr = this.zza;
                View view2 = this.zzf;
                getLocationInWindow(iArr);
                int i14 = iArr[0];
                int i15 = iArr[1];
                view2.getLocationInWindow(iArr);
                iArr[0] = iArr[0] - i14;
                iArr[1] = iArr[1] - i15;
            }
            Rect rect = this.zzb;
            int[] iArr2 = this.zza;
            int i16 = iArr2[0];
            rect.set(i16, iArr2[1], this.zzf.getWidth() + i16, this.zza[1] + this.zzf.getHeight());
            this.zzc.set(i10, i11, i12, i13);
            this.zzd.setBounds(this.zzc);
            this.zze.setBounds(this.zzc);
            this.zzh.zza(this.zzb, this.zzc);
            return;
        }
        throw new IllegalStateException("Target view must be set before layout");
    }

    public final void onMeasure(int i10, int i11) {
        setMeasuredDimension(View.resolveSize(View.MeasureSpec.getSize(i10), i10), View.resolveSize(View.MeasureSpec.getSize(i11), i11));
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.zzl = this.zzb.contains((int) motionEvent.getX(), (int) motionEvent.getY());
            actionMasked = 0;
        }
        if (this.zzl) {
            i iVar = this.zzj;
            if (iVar != null) {
                iVar.a(motionEvent);
                if (actionMasked == 1) {
                    motionEvent = MotionEvent.obtain(motionEvent);
                    motionEvent.setAction(3);
                }
            }
            if (this.zzf.getParent() != null) {
                this.zzf.onTouchEvent(motionEvent);
            }
        } else {
            this.zzi.a(motionEvent);
        }
        return true;
    }

    public final boolean verifyDrawable(Drawable drawable) {
        if (super.verifyDrawable(drawable) || drawable == this.zzd || drawable == this.zze || drawable == null) {
            return true;
        }
        return false;
    }

    public final View zzc() {
        return this.zzm.asView();
    }

    public final InnerZoneDrawable zze() {
        return this.zze;
    }

    public final OuterHighlightDrawable zzg() {
        return this.zzd;
    }

    public final void zzi(Runnable runnable) {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.zzm.asView(), "alpha", new float[]{0.0f}).setDuration(200);
        duration.setInterpolator(zzda.zza());
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.zzd, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat("scale", new float[]{1.125f}), PropertyValuesHolder.ofInt("alpha", new int[]{0})});
        ofPropertyValuesHolder.setInterpolator(zzda.zza());
        Animator duration2 = ofPropertyValuesHolder.setDuration(200);
        Animator zza2 = this.zze.zza();
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(new Animator[]{duration, duration2, zza2});
        animatorSet.addListener(new zze(this, runnable));
        zzq(animatorSet);
    }

    public final void zzj(Runnable runnable) {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.zzm.asView(), "alpha", new float[]{0.0f}).setDuration(200);
        duration.setInterpolator(zzda.zza());
        float exactCenterX = this.zzb.exactCenterX();
        float zza2 = this.zzd.zza();
        float exactCenterY = this.zzb.exactCenterY();
        float zzb2 = this.zzd.zzb();
        OuterHighlightDrawable outerHighlightDrawable = this.zzd;
        PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat("scale", new float[]{0.0f});
        PropertyValuesHolder ofInt = PropertyValuesHolder.ofInt("alpha", new int[]{0});
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(outerHighlightDrawable, new PropertyValuesHolder[]{ofFloat, PropertyValuesHolder.ofFloat("translationX", new float[]{0.0f, exactCenterX - zza2}), PropertyValuesHolder.ofFloat("translationY", new float[]{0.0f, exactCenterY - zzb2}), ofInt});
        ofPropertyValuesHolder.setInterpolator(zzda.zza());
        Animator duration2 = ofPropertyValuesHolder.setDuration(200);
        Animator zza3 = this.zze.zza();
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(new Animator[]{duration, duration2, zza3});
        animatorSet.addListener(new zzf(this, runnable));
        zzq(animatorSet);
    }

    public final void zzk(View view, View view2, boolean z10, zzg zzg2) {
        view.getClass();
        this.zzf = view;
        this.zzk = zzg2;
        i iVar = new i(getContext(), new zzb(this, view, true, zzg2));
        this.zzj = iVar;
        iVar.b(false);
        setVisibility(4);
    }

    public final void zzl(int i10) {
        this.zzd.zze(i10);
    }

    public final void zzm() {
        if (this.zzf != null) {
            setVisibility(0);
            ObjectAnimator duration = ObjectAnimator.ofFloat(this.zzm.asView(), "alpha", new float[]{0.0f, 1.0f}).setDuration(350);
            duration.setInterpolator(zzda.zzc());
            Animator zzd2 = this.zzd.zzd(this.zzb.exactCenterX() - this.zzd.zza(), this.zzb.exactCenterY() - this.zzd.zzb());
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.zze, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat("scale", new float[]{0.0f, 1.0f}), PropertyValuesHolder.ofInt("alpha", new int[]{0, 255})});
            ofPropertyValuesHolder.setInterpolator(zzda.zzc());
            Animator duration2 = ofPropertyValuesHolder.setDuration(350);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(new Animator[]{duration, zzd2, duration2});
            animatorSet.addListener(new zzd(this));
            zzq(animatorSet);
            return;
        }
        throw new IllegalStateException("Target view must be set before animation");
    }

    public final void zzn(Runnable runnable) {
        addOnLayoutChangeListener(new zzc(this, (Runnable) null));
    }

    public final void zzp(HelpTextView helpTextView) {
        helpTextView.getClass();
        this.zzm = helpTextView;
        addView(helpTextView.asView(), 0);
    }

    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new ViewGroup.MarginLayoutParams(layoutParams);
    }
}
