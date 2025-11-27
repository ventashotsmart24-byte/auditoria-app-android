package com.google.android.gms.internal.measurement;

final class zzlq implements zzlx {
    private final zzlm zza;
    private final zzmo zzb;
    private final boolean zzc;
    private final zzjs zzd;

    private zzlq(zzmo zzmo, zzjs zzjs, zzlm zzlm) {
        this.zzb = zzmo;
        this.zzc = zzjs.zzc(zzlm);
        this.zzd = zzjs;
        this.zza = zzlm;
    }

    public static zzlq zzc(zzmo zzmo, zzjs zzjs, zzlm zzlm) {
        return new zzlq(zzmo, zzjs, zzlm);
    }

    public final int zza(Object obj) {
        zzmo zzmo = this.zzb;
        int zzb2 = zzmo.zzb(zzmo.zzd(obj));
        if (!this.zzc) {
            return zzb2;
        }
        this.zzd.zza(obj);
        throw null;
    }

    public final int zzb(Object obj) {
        int hashCode = this.zzb.zzd(obj).hashCode();
        if (!this.zzc) {
            return hashCode;
        }
        this.zzd.zza(obj);
        throw null;
    }

    public final Object zze() {
        zzlm zzlm = this.zza;
        if (zzlm instanceof zzkf) {
            return ((zzkf) zzlm).zzbA();
        }
        return zzlm.zzbG().zzaE();
    }

    public final void zzf(Object obj) {
        this.zzb.zzg(obj);
        this.zzd.zzb(obj);
    }

    public final void zzg(Object obj, Object obj2) {
        zzlz.zzF(this.zzb, obj, obj2);
        if (this.zzc) {
            zzlz.zzE(this.zzd, obj, obj2);
        }
    }

    public final void zzh(Object obj, byte[] bArr, int i10, int i11, zzir zzir) {
        zzkf zzkf = (zzkf) obj;
        if (zzkf.zzc == zzmp.zzc()) {
            zzkf.zzc = zzmp.zzf();
        }
        zzkc zzkc = (zzkc) obj;
        throw null;
    }

    public final void zzi(Object obj, zzng zzng) {
        this.zzd.zza(obj);
        throw null;
    }

    public final boolean zzj(Object obj, Object obj2) {
        if (!this.zzb.zzd(obj).equals(this.zzb.zzd(obj2))) {
            return false;
        }
        if (!this.zzc) {
            return true;
        }
        this.zzd.zza(obj);
        this.zzd.zza(obj2);
        throw null;
    }

    public final boolean zzk(Object obj) {
        this.zzd.zza(obj);
        throw null;
    }
}
