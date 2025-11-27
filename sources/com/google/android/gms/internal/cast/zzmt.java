package com.google.android.gms.internal.cast;

public final class zzmt extends zzoy<zzmt, zzms> implements zzqf {
    /* access modifiers changed from: private */
    public static final zzmt zzb;
    private int zze;
    private zzpg<zznf> zzf = zzoy.zzw();
    private zzpg<zzla> zzg = zzoy.zzw();
    private zznb zzh;

    static {
        zzmt zzmt = new zzmt();
        zzb = zzmt;
        zzoy.zzA(zzmt.class, zzmt);
    }

    private zzmt() {
    }

    public final Object zzb(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return zzoy.zzz(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0002\u0000\u0001\u001b\u0002\u001b\u0003ဉ\u0000", new Object[]{"zze", "zzf", zznf.class, "zzg", zzla.class, "zzh"});
        } else if (i11 == 3) {
            return new zzmt();
        } else {
            if (i11 == 4) {
                return new zzms((zzjy) null);
            }
            if (i11 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
