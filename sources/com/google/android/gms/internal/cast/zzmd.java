package com.google.android.gms.internal.cast;

public final class zzmd extends zzoy<zzmd, zzmc> implements zzqf {
    /* access modifiers changed from: private */
    public static final zzmd zzb;
    private int zze;
    private int zzf;
    private long zzg;
    private int zzh;

    static {
        zzmd zzmd = new zzmd();
        zzb = zzmd;
        zzoy.zzA(zzmd.class, zzmd);
    }

    private zzmd() {
    }

    public final Object zzb(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return zzoy.zzz(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဂ\u0001\u0003ဌ\u0002", new Object[]{"zze", "zzf", zzhm.zza(), "zzg", "zzh", zzfh.zza()});
        } else if (i11 == 3) {
            return new zzmd();
        } else {
            if (i11 == 4) {
                return new zzmc((zzjy) null);
            }
            if (i11 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
