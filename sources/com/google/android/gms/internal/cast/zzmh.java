package com.google.android.gms.internal.cast;

public final class zzmh extends zzoy<zzmh, zzmg> implements zzqf {
    /* access modifiers changed from: private */
    public static final zzmh zzb;
    private int zze;
    private long zzf;
    private zzpf zzg = zzoy.zzv();
    private zzpf zzh = zzoy.zzv();

    static {
        zzmh zzmh = new zzmh();
        zzb = zzmh;
        zzoy.zzA(zzmh.class, zzmh);
    }

    private zzmh() {
    }

    public final Object zzb(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return zzoy.zzz(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0002\u0000\u0001စ\u0000\u0002\u0017\u0003\u0017", new Object[]{"zze", "zzf", "zzg", "zzh"});
        } else if (i11 == 3) {
            return new zzmh();
        } else {
            if (i11 == 4) {
                return new zzmg((zzjy) null);
            }
            if (i11 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
