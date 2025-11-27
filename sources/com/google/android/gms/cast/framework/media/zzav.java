package com.google.android.gms.cast.framework.media;

final class zzav extends zzbl {
    final /* synthetic */ int zza;
    final /* synthetic */ int zzb;
    final /* synthetic */ int zzc;
    final /* synthetic */ RemoteMediaClient zzd;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzav(RemoteMediaClient remoteMediaClient, boolean z10, int i10, int i11, int i12) {
        super(remoteMediaClient, true);
        this.zzd = remoteMediaClient;
        this.zza = i10;
        this.zzb = i11;
        this.zzc = i12;
    }

    public final void zza() {
        this.zzd.zzd.zzt(zzb(), this.zza, this.zzb, this.zzc);
    }
}
