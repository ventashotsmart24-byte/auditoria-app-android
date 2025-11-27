package com.google.android.gms.internal.measurement;

public final class zzgm extends zzkf implements zzln {
    /* access modifiers changed from: private */
    public static final zzgm zza;
    private int zzd;
    private long zze;
    private String zzf = "";
    private String zzg = "";
    private long zzh;
    private float zzi;
    private double zzj;

    static {
        zzgm zzgm = new zzgm();
        zza = zzgm;
        zzkf.zzbL(zzgm.class, zzgm);
    }

    private zzgm() {
    }

    public static zzgl zzd() {
        return (zzgl) zza.zzbx();
    }

    public static /* synthetic */ void zzh(zzgm zzgm, long j10) {
        zzgm.zzd |= 1;
        zzgm.zze = j10;
    }

    public static /* synthetic */ void zzi(zzgm zzgm, String str) {
        str.getClass();
        zzgm.zzd |= 2;
        zzgm.zzf = str;
    }

    public static /* synthetic */ void zzj(zzgm zzgm, String str) {
        str.getClass();
        zzgm.zzd |= 4;
        zzgm.zzg = str;
    }

    public static /* synthetic */ void zzk(zzgm zzgm) {
        zzgm.zzd &= -5;
        zzgm.zzg = zza.zzg;
    }

    public static /* synthetic */ void zzm(zzgm zzgm, long j10) {
        zzgm.zzd |= 8;
        zzgm.zzh = j10;
    }

    public static /* synthetic */ void zzn(zzgm zzgm) {
        zzgm.zzd &= -9;
        zzgm.zzh = 0;
    }

    public static /* synthetic */ void zzo(zzgm zzgm, double d10) {
        zzgm.zzd |= 32;
        zzgm.zzj = d10;
    }

    public static /* synthetic */ void zzp(zzgm zzgm) {
        zzgm.zzd &= -33;
        zzgm.zzj = 0.0d;
    }

    public final double zza() {
        return this.zzj;
    }

    public final long zzb() {
        return this.zzh;
    }

    public final long zzc() {
        return this.zze;
    }

    public final String zzf() {
        return this.zzf;
    }

    public final String zzg() {
        return this.zzg;
    }

    public final Object zzl(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return zzkf.zzbI(zza, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ဂ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004ဂ\u0003\u0005ခ\u0004\u0006က\u0005", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj"});
        } else if (i11 == 3) {
            return new zzgm();
        } else {
            if (i11 == 4) {
                return new zzgl((zzfk) null);
            }
            if (i11 != 5) {
                return null;
            }
            return zza;
        }
    }

    public final boolean zzq() {
        return (this.zzd & 32) != 0;
    }

    public final boolean zzr() {
        return (this.zzd & 8) != 0;
    }

    public final boolean zzs() {
        return (this.zzd & 1) != 0;
    }

    public final boolean zzt() {
        return (this.zzd & 4) != 0;
    }
}
