package com.google.android.gms.cast.framework.media;

import com.google.android.gms.cast.MediaLoadRequestData;

final class zzaw extends zzbl {
    final /* synthetic */ MediaLoadRequestData zza;
    final /* synthetic */ RemoteMediaClient zzb;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzaw(RemoteMediaClient remoteMediaClient, MediaLoadRequestData mediaLoadRequestData) {
        super(remoteMediaClient, false);
        this.zzb = remoteMediaClient;
        this.zza = mediaLoadRequestData;
    }

    public final void zza() {
        this.zzb.zzd.zzp(zzb(), this.zza);
    }
}
