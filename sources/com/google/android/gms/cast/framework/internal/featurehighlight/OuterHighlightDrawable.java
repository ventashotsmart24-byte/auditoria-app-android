package com.google.android.gms.cast.framework.internal.featurehighlight;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import androidx.annotation.Keep;
import com.google.android.gms.cast.framework.R;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.internal.cast.zzda;
import com.google.android.gms.internal.cast.zzdb;
import r.a;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

class OuterHighlightDrawable extends Drawable {
    private final int zza;
    private final int zzb;
    private final int zzc;
    private final Rect zzd = new Rect();
    private final Rect zze = new Rect();
    private final Paint zzf;
    private float zzg;
    private float zzh;
    private float zzi;
    private float zzj;
    private float zzk;
    private float zzl;
    private int zzm;

    public OuterHighlightDrawable(Context context) {
        Paint paint = new Paint();
        this.zzf = paint;
        this.zzh = 1.0f;
        this.zzk = 0.0f;
        this.zzl = 0.0f;
        this.zzm = IjkMediaMeta.FF_PROFILE_H264_HIGH_444_PREDICTIVE;
        if (PlatformVersion.isAtLeastLollipop()) {
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(16843827, typedValue, true);
            zze(a.m(typedValue.data, IjkMediaMeta.FF_PROFILE_H264_HIGH_444_PREDICTIVE));
        } else {
            zze(context.getResources().getColor(R.color.cast_libraries_material_featurehighlight_outer_highlight_default_color));
        }
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
        Resources resources = context.getResources();
        this.zza = resources.getDimensionPixelSize(R.dimen.cast_libraries_material_featurehighlight_center_threshold);
        this.zzb = resources.getDimensionPixelSize(R.dimen.cast_libraries_material_featurehighlight_center_horizontal_offset);
        this.zzc = resources.getDimensionPixelSize(R.dimen.cast_libraries_material_featurehighlight_outer_padding);
    }

    private static final float zzh(float f10, float f11, Rect rect) {
        float f12 = (float) rect.left;
        float f13 = (float) rect.top;
        float f14 = (float) rect.right;
        float f15 = (float) rect.bottom;
        float zza2 = zzdb.zza(f10, f11, f12, f13);
        float zza3 = zzdb.zza(f10, f11, f14, f13);
        float zza4 = zzdb.zza(f10, f11, f14, f15);
        float zza5 = zzdb.zza(f10, f11, f12, f15);
        if (zza2 <= zza3 || zza2 <= zza4 || zza2 <= zza5) {
            if (zza3 > zza4 && zza3 > zza5) {
                zza2 = zza3;
            } else if (zza4 > zza5) {
                zza2 = zza4;
            } else {
                zza2 = zza5;
            }
        }
        return (float) Math.ceil((double) zza2);
    }

    public final void draw(Canvas canvas) {
        canvas.drawCircle(this.zzi + this.zzk, this.zzj + this.zzl, this.zzg * this.zzh, this.zzf);
    }

    public final int getAlpha() {
        return this.zzf.getAlpha();
    }

    public final int getOpacity() {
        return -3;
    }

    public final void setAlpha(int i10) {
        this.zzf.setAlpha(i10);
        invalidateSelf();
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        this.zzf.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Keep
    public void setScale(float f10) {
        this.zzh = f10;
        invalidateSelf();
    }

    @Keep
    public void setTranslationX(float f10) {
        this.zzk = f10;
        invalidateSelf();
    }

    @Keep
    public void setTranslationY(float f10) {
        this.zzl = f10;
        invalidateSelf();
    }

    public final float zza() {
        return this.zzi;
    }

    public final float zzb() {
        return this.zzj;
    }

    public final int zzc() {
        return this.zzf.getColor();
    }

    public final Animator zzd(float f10, float f11) {
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat("scale", new float[]{0.0f, 1.0f}), PropertyValuesHolder.ofFloat("translationX", new float[]{f10, 0.0f}), PropertyValuesHolder.ofFloat("translationY", new float[]{f11, 0.0f}), PropertyValuesHolder.ofInt("alpha", new int[]{0, this.zzm})});
        ofPropertyValuesHolder.setInterpolator(zzda.zzc());
        return ofPropertyValuesHolder.setDuration(350);
    }

    public final void zze(int i10) {
        this.zzf.setColor(i10);
        this.zzm = this.zzf.getAlpha();
        invalidateSelf();
    }

    public final void zzf(Rect rect, Rect rect2) {
        float f10;
        this.zzd.set(rect);
        this.zze.set(rect2);
        float exactCenterX = rect.exactCenterX();
        float exactCenterY = rect.exactCenterY();
        Rect bounds = getBounds();
        if (Math.min(exactCenterY - ((float) bounds.top), ((float) bounds.bottom) - exactCenterY) < ((float) this.zza)) {
            this.zzi = exactCenterX;
            this.zzj = exactCenterY;
        } else {
            if (exactCenterX <= bounds.exactCenterX()) {
                f10 = rect2.exactCenterX() + ((float) this.zzb);
            } else {
                f10 = rect2.exactCenterX() - ((float) this.zzb);
            }
            this.zzi = f10;
            exactCenterY = rect2.exactCenterY();
            this.zzj = exactCenterY;
        }
        this.zzg = ((float) this.zzc) + Math.max(zzh(this.zzi, exactCenterY, rect), zzh(this.zzi, this.zzj, rect2));
        invalidateSelf();
    }

    public final boolean zzg(float f10, float f11) {
        if (zzdb.zza(f10, f11, this.zzi, this.zzj) < this.zzg) {
            return true;
        }
        return false;
    }
}
