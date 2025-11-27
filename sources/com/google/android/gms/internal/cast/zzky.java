package com.google.android.gms.internal.cast;

public final class zzky extends zzoy<zzky, zzkx> implements zzqf {
    /* access modifiers changed from: private */
    public static final zzky zzb;
    private int zze;
    private int zzf = 0;
    private Object zzg;
    private long zzh;

    static {
        zzky zzky = new zzky();
        zzb = zzky;
        zzoy.zzA(zzky.class, zzky);
    }

    private zzky() {
    }

    public final Object zzb(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return zzoy.zzz(zzb, "\u0001\u0004\u0001\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001စ\u0000\u0002်\u0000\u0003ဵ\u0000\u0004း\u0000", new Object[]{"zzg", "zzf", "zze", "zzh"});
        } else if (i11 == 3) {
            return new zzky();
        } else {
            if (i11 == 4) {
                return new zzkx((zzjy) null);
            }
            if (i11 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
