package com.google.android.gms.internal.cast;

public final class zzlf extends zzoy<zzlf, zzle> implements zzqf {
    /* access modifiers changed from: private */
    public static final zzlf zzb;
    private int zze;
    private int zzf;
    private int zzg;
    private int zzh;
    private int zzi;

    static {
        zzlf zzlf = new zzlf();
        zzb = zzlf;
        zzoy.zzA(zzlf.class, zzlf);
    }

    private zzlf() {
    }

    public final Object zzb(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return zzoy.zzz(zzb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001င\u0000\u0002င\u0001\u0003င\u0002\u0004င\u0003", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi"});
        } else if (i11 == 3) {
            return new zzlf();
        } else {
            if (i11 == 4) {
                return new zzle((zzjy) null);
            }
            if (i11 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
