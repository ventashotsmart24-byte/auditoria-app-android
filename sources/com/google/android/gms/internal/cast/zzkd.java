package com.google.android.gms.internal.cast;

public final class zzkd extends zzov<zzke, zzkd> implements zzqf {
    private zzkd() {
        super(zzke.zze);
    }

    public final zzkd zza(Iterable<? extends zzju> iterable) {
        if (this.zzb) {
            zzt();
            this.zzb = false;
        }
        zzke.zze((zzke) this.zza, iterable);
        return this;
    }

    public final zzkd zzb(zzkk zzkk) {
        if (this.zzb) {
            zzt();
            this.zzb = false;
        }
        zzke.zzd((zzke) this.zza, zzkk);
        return this;
    }

    public /* synthetic */ zzkd(zzjy zzjy) {
        super(zzke.zze);
    }
}
