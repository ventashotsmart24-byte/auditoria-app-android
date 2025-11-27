package com.google.android.gms.internal.cast;

public final class zzko extends zzoy<zzko, zzkn> implements zzqf {
    /* access modifiers changed from: private */
    public static final zzko zzb;
    private int zze;
    private int zzf;
    private int zzg;
    private int zzh;
    private int zzi;

    static {
        zzko zzko = new zzko();
        zzb = zzko;
        zzoy.zzA(zzko.class, zzko);
    }

    private zzko() {
    }

    public final Object zzb(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return zzoy.zzz(zzb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဋ\u0000\u0002ဋ\u0001\u0003ဌ\u0002\u0004င\u0003", new Object[]{"zze", "zzf", "zzg", "zzh", zzhg.zza(), "zzi"});
        } else if (i11 == 3) {
            return new zzko();
        } else {
            if (i11 == 4) {
                return new zzkn((zzjy) null);
            }
            if (i11 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
