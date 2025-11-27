package com.google.android.gms.measurement.internal;

final class zzjy {
    final /* synthetic */ zzkc zza;
    private zzjx zzb;

    public zzjy(zzkc zzkc) {
        this.zza = zzkc;
    }

    public final void zza(long j10) {
        this.zzb = new zzjx(this, this.zza.zzt.zzav().currentTimeMillis(), j10);
        this.zza.zzd.postDelayed(this.zzb, 2000);
    }

    public final void zzb() {
        this.zza.zzg();
        zzjx zzjx = this.zzb;
        if (zzjx != null) {
            this.zza.zzd.removeCallbacks(zzjx);
        }
        this.zza.zzt.zzm().zzm.zza(false);
    }
}
