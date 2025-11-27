package com.google.android.gms.internal.cast;

public final class zzkw extends zzoy<zzkw, zzkv> implements zzqf {
    /* access modifiers changed from: private */
    public static final zzkw zzb;
    private int zze;
    private int zzf;
    private int zzg;

    static {
        zzkw zzkw = new zzkw();
        zzb = zzkw;
        zzoy.zzA(zzkw.class, zzkw);
    }

    private zzkw() {
    }

    public final Object zzb(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return zzoy.zzz(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဌ\u0001", new Object[]{"zze", "zzf", zzfz.zza(), "zzg", zzfw.zza()});
        } else if (i11 == 3) {
            return new zzkw();
        } else {
            if (i11 == 4) {
                return new zzkv((zzjy) null);
            }
            if (i11 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
