package com.google.android.gms.cast.framework.media;

import java.util.List;

final class zzax extends zzbl {
    final /* synthetic */ String zza;
    final /* synthetic */ RemoteMediaClient zzb;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzax(RemoteMediaClient remoteMediaClient, boolean z10, String str, List list) {
        super(remoteMediaClient, true);
        this.zzb = remoteMediaClient;
        this.zza = str;
    }

    public final void zza() {
        this.zzb.zzd.zzs(this.zza, (List) null);
    }
}
