package com.google.android.gms.cast.framework.media;

import com.google.android.gms.cast.TextTrackStyle;

final class zzaf extends zzbl {
    final /* synthetic */ TextTrackStyle zza;
    final /* synthetic */ RemoteMediaClient zzb;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzaf(RemoteMediaClient remoteMediaClient, TextTrackStyle textTrackStyle) {
        super(remoteMediaClient, false);
        this.zzb = remoteMediaClient;
        this.zza = textTrackStyle;
    }

    public final void zza() {
        this.zzb.zzd.zzH(zzb(), this.zza);
    }
}
