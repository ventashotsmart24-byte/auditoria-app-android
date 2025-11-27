package com.google.android.gms.internal.cast;

final class zzqi<T> implements zzqp<T> {
    private final zzqe zza;
    private final zzrd<?, ?> zzb;
    private final boolean zzc;
    private final zzoo<?> zzd;

    private zzqi(zzrd<?, ?> zzrd, zzoo<?> zzoo, zzqe zzqe) {
        this.zzb = zzrd;
        this.zzc = zzoo.zzc(zzqe);
        this.zzd = zzoo;
        this.zza = zzqe;
    }

    public static <T> zzqi<T> zzg(zzrd<?, ?> zzrd, zzoo<?> zzoo, zzqe zzqe) {
        return new zzqi<>(zzrd, zzoo, zzqe);
    }

    public final int zza(T t10) {
        zzrd<?, ?> zzrd = this.zzb;
        int zzb2 = zzrd.zzb(zzrd.zzc(t10));
        if (!this.zzc) {
            return zzb2;
        }
        this.zzd.zza(t10);
        throw null;
    }

    public final int zzb(T t10) {
        int hashCode = this.zzb.zzc(t10).hashCode();
        if (!this.zzc) {
            return hashCode;
        }
        this.zzd.zza(t10);
        throw null;
    }

    public final void zzc(T t10) {
        this.zzb.zze(t10);
        this.zzd.zzb(t10);
    }

    public final void zzd(T t10, T t11) {
        zzqr.zzD(this.zzb, t10, t11);
        if (this.zzc) {
            zzqr.zzC(this.zzd, t10, t11);
        }
    }

    public final boolean zze(T t10, T t11) {
        if (!this.zzb.zzc(t10).equals(this.zzb.zzc(t11))) {
            return false;
        }
        if (!this.zzc) {
            return true;
        }
        this.zzd.zza(t10);
        this.zzd.zza(t11);
        throw null;
    }

    public final boolean zzf(T t10) {
        this.zzd.zza(t10);
        throw null;
    }

    public final void zzi(T t10, zzom zzom) {
        this.zzd.zza(t10);
        throw null;
    }
}
