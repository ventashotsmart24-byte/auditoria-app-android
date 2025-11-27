package com.google.android.gms.internal.cast;

import android.graphics.Bitmap;
import com.google.android.gms.cast.framework.media.internal.zza;

final class zzax implements zza {
    final /* synthetic */ zzay zza;

    public zzax(zzay zzay) {
        this.zza = zzay;
    }

    public final void zza(Bitmap bitmap) {
        if (bitmap != null) {
            if (this.zza.zzd != null) {
                this.zza.zzd.setVisibility(4);
            }
            this.zza.zza.setVisibility(0);
            this.zza.zza.setImageBitmap(bitmap);
        }
    }
}
