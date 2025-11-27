package com.google.android.gms.internal.cast;

public final class zzkm extends zzoy<zzkm, zzkl> implements zzqf {
    /* access modifiers changed from: private */
    public static final zzkm zzb;
    private int zze;
    private zzlc zzf;
    private boolean zzg;
    private long zzh;
    private int zzi;
    private int zzj;
    private int zzk;
    private int zzl;
    private int zzm;
    private zzmv zzn;
    private int zzo;
    private int zzp;

    static {
        zzkm zzkm = new zzkm();
        zzb = zzkm;
        zzoy.zzA(zzkm.class, zzkm);
    }

    private zzkm() {
    }

    public static zzkl zza() {
        return (zzkl) zzb.zzr();
    }

    public static zzkl zzc(zzkm zzkm) {
        zzov zzr = zzb.zzr();
        zzr.zzo(zzkm);
        return (zzkl) zzr;
    }

    public static zzkm zze() {
        return zzb;
    }

    public static /* synthetic */ void zzf(zzkm zzkm, zzlc zzlc) {
        zzlc.getClass();
        zzkm.zzf = zzlc;
        zzkm.zze |= 1;
    }

    public static /* synthetic */ void zzg(zzkm zzkm, boolean z10) {
        zzkm.zze |= 2;
        zzkm.zzg = z10;
    }

    public static /* synthetic */ void zzh(zzkm zzkm, long j10) {
        zzkm.zze |= 4;
        zzkm.zzh = j10;
    }

    public static /* synthetic */ void zzi(zzkm zzkm, int i10) {
        zzkm.zze |= 64;
        zzkm.zzl = i10;
    }

    public static /* synthetic */ void zzj(zzkm zzkm, int i10) {
        zzkm.zze |= 128;
        zzkm.zzm = i10;
    }

    public static /* synthetic */ void zzk(zzkm zzkm, int i10) {
        zzkm.zze |= 1024;
        zzkm.zzp = i10;
    }

    public final Object zzb(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return zzoy.zzz(zzb, "\u0001\u000b\u0000\u0001\u0001\u000b\u000b\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဇ\u0001\u0003စ\u0002\u0004ဆ\u0003\u0005ဌ\u0004\u0006ဌ\u0005\u0007င\u0006\bင\u0007\tဉ\b\nဌ\t\u000bင\n", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi", "zzj", zzfb.zza(), "zzk", zzey.zza(), "zzl", "zzm", "zzn", "zzo", zzgo.zza(), "zzp"});
        } else if (i11 == 3) {
            return new zzkm();
        } else {
            if (i11 == 4) {
                return new zzkl((zzjy) null);
            }
            if (i11 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
