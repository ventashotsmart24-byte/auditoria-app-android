package com.google.android.gms.internal.cast;

public final class zznb extends zzoy<zznb, zzna> implements zzqf {
    /* access modifiers changed from: private */
    public static final zznb zzb;
    private int zze;
    private zzkg zzf;

    static {
        zznb zznb = new zznb();
        zzb = zznb;
        zzoy.zzA(zznb.class, zznb);
    }

    private zznb() {
    }

    public final Object zzb(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return zzoy.zzz(zzb, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"zze", "zzf"});
        } else if (i11 == 3) {
            return new zznb();
        } else {
            if (i11 == 4) {
                return new zzna((zzjy) null);
            }
            if (i11 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
