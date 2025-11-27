package com.google.android.gms.measurement.internal;

abstract class zzkh extends zzkg {
    private boolean zza;

    public zzkh(zzkt zzkt) {
        super(zzkt);
        this.zzf.zzM();
    }

    public final void zzW() {
        if (!zzY()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void zzX() {
        if (!this.zza) {
            zzb();
            this.zzf.zzH();
            this.zza = true;
            return;
        }
        throw new IllegalStateException("Can't initialize twice");
    }

    public final boolean zzY() {
        return this.zza;
    }

    public abstract boolean zzb();
}
