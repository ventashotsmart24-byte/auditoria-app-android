package com.google.android.gms.internal.cast;

public final class zzmv extends zzoy<zzmv, zzmu> implements zzqf {
    /* access modifiers changed from: private */
    public static final zzmv zzb;
    private int zze;
    private int zzf;
    private int zzg;

    static {
        zzmv zzmv = new zzmv();
        zzb = zzmv;
        zzoy.zzA(zzmv.class, zzmv);
    }

    private zzmv() {
    }

    public final Object zzb(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return zzoy.zzz(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဌ\u0001", new Object[]{"zze", "zzf", zzih.zza(), "zzg", zzih.zza()});
        } else if (i11 == 3) {
            return new zzmv();
        } else {
            if (i11 == 4) {
                return new zzmu((zzjy) null);
            }
            if (i11 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
