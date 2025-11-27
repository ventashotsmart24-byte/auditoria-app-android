package com.google.android.gms.cast.framework.internal.featurehighlight;

import android.content.res.Resources;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.cast.framework.R;
import com.google.common.primitives.Ints;

final class zzi {
    private final Rect zza = new Rect();
    private final int zzb;
    private final int zzc;
    private final int zzd;
    private final int zze;
    private final zzh zzf;

    public zzi(zzh zzh) {
        this.zzf = zzh;
        Resources resources = zzh.getResources();
        this.zzb = resources.getDimensionPixelSize(R.dimen.cast_libraries_material_featurehighlight_inner_radius);
        this.zzc = resources.getDimensionPixelOffset(R.dimen.cast_libraries_material_featurehighlight_inner_margin);
        this.zzd = resources.getDimensionPixelSize(R.dimen.cast_libraries_material_featurehighlight_text_max_width);
        this.zze = resources.getDimensionPixelSize(R.dimen.cast_libraries_material_featurehighlight_text_horizontal_offset);
    }

    private final int zzb(View view, int i10, int i11, int i12, int i13) {
        int i14;
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int i15 = i12 / 2;
        if (i13 - i10 <= i11 - i13) {
            i14 = (i13 - i15) + this.zze;
        } else {
            i14 = (i13 - i15) - this.zze;
        }
        int i16 = marginLayoutParams.leftMargin;
        if (i14 - i16 < i10) {
            return i10 + i16;
        }
        int i17 = marginLayoutParams.rightMargin;
        if (i14 + i12 + i17 > i11) {
            return (i11 - i12) - i17;
        }
        return i14;
    }

    private final void zzc(View view, int i10, int i11) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        view.measure(View.MeasureSpec.makeMeasureSpec(Math.min((i10 - marginLayoutParams.leftMargin) - marginLayoutParams.rightMargin, this.zzd), Ints.MAX_POWER_OF_TWO), View.MeasureSpec.makeMeasureSpec(i11, Integer.MIN_VALUE));
    }

    public final void zza(Rect rect, Rect rect2) {
        View zzc2 = this.zzf.zzc();
        if (rect.isEmpty() || rect2.isEmpty()) {
            zzc2.layout(0, 0, 0, 0);
        } else {
            int centerY = rect.centerY();
            int centerX = rect.centerX();
            int centerY2 = rect2.centerY();
            int height = rect.height();
            int i10 = this.zzb;
            int max = Math.max(i10 + i10, height) / 2;
            int i11 = this.zzc;
            int i12 = centerY + max + i11;
            if (centerY < centerY2) {
                zzc(zzc2, rect2.width(), rect2.bottom - i12);
                int zzb2 = zzb(zzc2, rect2.left, rect2.right, zzc2.getMeasuredWidth(), centerX);
                zzc2.layout(zzb2, i12, zzc2.getMeasuredWidth() + zzb2, zzc2.getMeasuredHeight() + i12);
            } else {
                int i13 = (centerY - max) - i11;
                zzc(zzc2, rect2.width(), i13 - rect2.top);
                int zzb3 = zzb(zzc2, rect2.left, rect2.right, zzc2.getMeasuredWidth(), centerX);
                zzc2.layout(zzb3, i13 - zzc2.getMeasuredHeight(), zzc2.getMeasuredWidth() + zzb3, i13);
            }
        }
        this.zza.set(zzc2.getLeft(), zzc2.getTop(), zzc2.getRight(), zzc2.getBottom());
        this.zzf.zzg().zzf(rect, this.zza);
        this.zzf.zze().zzb(rect);
    }
}
