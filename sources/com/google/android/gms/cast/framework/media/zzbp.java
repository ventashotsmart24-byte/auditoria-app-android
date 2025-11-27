package com.google.android.gms.cast.framework.media;

import java.util.TimerTask;

final class zzbp extends TimerTask {
    final /* synthetic */ RemoteMediaClient zza;
    final /* synthetic */ zzbq zzb;

    public zzbp(zzbq zzbq, RemoteMediaClient remoteMediaClient) {
        this.zzb = zzbq;
        this.zza = remoteMediaClient;
    }

    public final void run() {
        zzbq zzbq = this.zzb;
        zzbq.zza.zzr(zzbq.zzb);
        this.zzb.zza.zzc.postDelayed(this, this.zzb.zzc);
    }
}
