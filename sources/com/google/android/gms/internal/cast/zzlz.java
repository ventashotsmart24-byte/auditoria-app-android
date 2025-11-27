package com.google.android.gms.internal.cast;

public final class zzlz extends zzoy<zzlz, zzly> implements zzqf {
    /* access modifiers changed from: private */
    public static final zzlz zzb;
    private int zze;
    private int zzf;
    private int zzg;
    private int zzh;
    private byte zzi = 2;

    static {
        zzlz zzlz = new zzlz();
        zzb = zzlz;
        zzoy.zzA(zzlz.class, zzlz);
    }

    private zzlz() {
    }

    public final Object zzb(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return Byte.valueOf(this.zzi);
        }
        byte b10 = 1;
        if (i11 == 2) {
            return zzoy.zzz(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0001\u0001ᔌ\u0000\u0002င\u0001\u0003ဌ\u0002", new Object[]{"zze", "zzf", zzhj.zza(), "zzg", "zzh", zzjx.zza()});
        } else if (i11 == 3) {
            return new zzlz();
        } else {
            if (i11 == 4) {
                return new zzly((zzjy) null);
            }
            if (i11 == 5) {
                return zzb;
            }
            if (obj == null) {
                b10 = 0;
            }
            this.zzi = b10;
            return null;
        }
    }
}
