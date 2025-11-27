package com.google.android.gms.cast.framework.media;

final class zzau extends zzbl {
    final /* synthetic */ int[] zza;
    final /* synthetic */ RemoteMediaClient zzb;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzau(RemoteMediaClient remoteMediaClient, boolean z10, int[] iArr) {
        super(remoteMediaClient, true);
        this.zzb = remoteMediaClient;
        this.zza = iArr;
    }

    public final void zza() {
        this.zzb.zzd.zzv(zzb(), this.zza);
    }
}
