package com.google.android.gms.internal.cast;

public final class zzkk extends zzoy<zzkk, zzkj> implements zzqf {
    /* access modifiers changed from: private */
    public static final zzkk zzb;
    private int zze;
    private String zzf = "";
    private String zzg = "";

    static {
        zzkk zzkk = new zzkk();
        zzb = zzkk;
        zzoy.zzA(zzkk.class, zzkk);
    }

    private zzkk() {
    }

    public static zzkj zza() {
        return (zzkj) zzb.zzr();
    }

    public static /* synthetic */ void zzd(zzkk zzkk, String str) {
        str.getClass();
        zzkk.zze |= 1;
        zzkk.zzf = str;
    }

    public static /* synthetic */ void zze(zzkk zzkk, String str) {
        str.getClass();
        zzkk.zze |= 2;
        zzkk.zzg = str;
    }

    public final Object zzb(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return zzoy.zzz(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001", new Object[]{"zze", "zzf", "zzg"});
        } else if (i11 == 3) {
            return new zzkk();
        } else {
            if (i11 == 4) {
                return new zzkj((zzjy) null);
            }
            if (i11 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
