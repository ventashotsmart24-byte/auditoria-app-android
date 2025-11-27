package com.google.android.gms.cast.framework.media;

import com.google.android.gms.cast.MediaSeekOptions;

final class zzbb extends zzbl {
    final /* synthetic */ MediaSeekOptions zza;
    final /* synthetic */ RemoteMediaClient zzb;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzbb(RemoteMediaClient remoteMediaClient, MediaSeekOptions mediaSeekOptions) {
        super(remoteMediaClient, false);
        this.zzb = remoteMediaClient;
        this.zza = mediaSeekOptions;
    }

    public final void zza() {
        this.zzb.zzd.zzC(zzb(), this.zza);
    }
}
