package com.google.android.gms.cast.framework.media;

import android.graphics.Bitmap;
import com.google.android.gms.cast.framework.media.internal.zza;

final class zzm implements zza {
    final /* synthetic */ zzo zza;
    final /* synthetic */ MediaNotificationService zzb;

    public zzm(MediaNotificationService mediaNotificationService, zzo zzo) {
        this.zzb = mediaNotificationService;
        this.zza = zzo;
    }

    public final void zza(Bitmap bitmap) {
        zzo zzo = this.zza;
        zzo.zzb = bitmap;
        this.zzb.zzn = zzo;
        this.zzb.zzj();
    }
}
