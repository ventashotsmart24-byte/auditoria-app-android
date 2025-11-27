package com.google.android.gms.cast.framework.media;

final class zzae extends zzbl {
    final /* synthetic */ long[] zza;
    final /* synthetic */ RemoteMediaClient zzb;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzae(RemoteMediaClient remoteMediaClient, long[] jArr) {
        super(remoteMediaClient, false);
        this.zzb = remoteMediaClient;
        this.zza = jArr;
    }

    public final void zza() {
        this.zzb.zzd.zzD(zzb(), this.zza);
    }
}
