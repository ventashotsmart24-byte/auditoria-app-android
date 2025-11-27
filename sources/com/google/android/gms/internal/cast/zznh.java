package com.google.android.gms.internal.cast;

public final class zznh extends zzoy<zznh, zzng> implements zzqf {
    /* access modifiers changed from: private */
    public static final zznh zzb;
    private int zze;
    private int zzf;
    private zzpg<zzmn> zzg = zzoy.zzw();
    private zzpg<zzmn> zzh = zzoy.zzw();
    private int zzi;

    static {
        zznh zznh = new zznh();
        zzb = zznh;
        zzoy.zzA(zznh.class, zznh);
    }

    private zznh() {
    }

    public final Object zzb(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            Class<zzmn> cls = zzmn.class;
            return zzoy.zzz(zzb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0002\u0000\u0001ဌ\u0000\u0002\u001b\u0003\u001b\u0004င\u0001", new Object[]{"zze", "zzf", zzjf.zza(), "zzg", cls, "zzh", cls, "zzi"});
        } else if (i11 == 3) {
            return new zznh();
        } else {
            if (i11 == 4) {
                return new zzng((zzjy) null);
            }
            if (i11 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
