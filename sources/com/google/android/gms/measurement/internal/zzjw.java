package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import anet.channel.entity.ConnType;

public final /* synthetic */ class zzjw implements Runnable {
    public final /* synthetic */ zzjx zza;

    public /* synthetic */ zzjw(zzjx zzjx) {
        this.zza = zzjx;
    }

    public final void run() {
        zzjx zzjx = this.zza;
        zzjy zzjy = zzjx.zzc;
        long j10 = zzjx.zza;
        long j11 = zzjx.zzb;
        zzjy.zza.zzg();
        zzjy.zza.zzt.zzay().zzc().zza("Application going to the background");
        zzjy.zza.zzt.zzm().zzm.zza(true);
        Bundle bundle = new Bundle();
        if (!zzjy.zza.zzt.zzf().zzu()) {
            zzjy.zza.zzb.zzb(j11);
            zzjy.zza.zzb.zzd(false, false, j11);
        }
        zzjy.zza.zzt.zzq().zzH(ConnType.PK_AUTO, "_ab", j10, bundle);
    }
}
