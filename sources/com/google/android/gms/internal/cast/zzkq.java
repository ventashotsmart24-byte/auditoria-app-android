package com.google.android.gms.internal.cast;

public final class zzkq extends zzoy<zzkq, zzkp> implements zzqf {
    /* access modifiers changed from: private */
    public static final zzkq zzb;
    private int zze;
    private int zzf;

    static {
        zzkq zzkq = new zzkq();
        zzb = zzkq;
        zzoy.zzA(zzkq.class, zzkq);
    }

    private zzkq() {
    }

    public final Object zzb(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return zzoy.zzz(zzb, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဌ\u0000", new Object[]{"zze", "zzf", zzfk.zza()});
        } else if (i11 == 3) {
            return new zzkq();
        } else {
            if (i11 == 4) {
                return new zzkp((zzjy) null);
            }
            if (i11 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
