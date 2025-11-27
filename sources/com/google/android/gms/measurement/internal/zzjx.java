package com.google.android.gms.measurement.internal;

final class zzjx implements Runnable {
    final long zza;
    final long zzb;
    final /* synthetic */ zzjy zzc;

    public zzjx(zzjy zzjy, long j10, long j11) {
        this.zzc = zzjy;
        this.zza = j10;
        this.zzb = j11;
    }

    public final void run() {
        this.zzc.zza.zzt.zzaz().zzp(new zzjw(this));
    }
}
