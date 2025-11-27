package com.google.android.gms.cast.framework.media.widget;

import android.graphics.Bitmap;
import com.google.android.gms.cast.framework.media.internal.zza;

final class zzh implements zza {
    final /* synthetic */ ExpandedControllerActivity zza;

    public zzh(ExpandedControllerActivity expandedControllerActivity) {
        this.zza = expandedControllerActivity;
    }

    public final void zza(Bitmap bitmap) {
        if (bitmap != null) {
            if (this.zza.zzE != null) {
                this.zza.zzE.setVisibility(8);
            }
            if (this.zza.zzD != null) {
                this.zza.zzD.setVisibility(0);
                this.zza.zzD.setImageBitmap(bitmap);
            }
        }
    }
}
