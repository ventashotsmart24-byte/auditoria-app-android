package com.google.android.gms.internal.cast;

public final class zzmz extends zzoy<zzmz, zzmy> implements zzqf {
    /* access modifiers changed from: private */
    public static final zzmz zzb;
    private int zze;
    private String zzf = "";
    private zzpg<zzlr> zzg = zzoy.zzw();
    private zzpg<zzlc> zzh = zzoy.zzw();
    private boolean zzi;

    static {
        zzmz zzmz = new zzmz();
        zzb = zzmz;
        zzoy.zzA(zzmz.class, zzmz);
    }

    private zzmz() {
    }

    public final Object zzb(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return zzoy.zzz(zzb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0002\u0000\u0001ဈ\u0000\u0002\u001b\u0003\u001b\u0004ဇ\u0001", new Object[]{"zze", "zzf", "zzg", zzlr.class, "zzh", zzlc.class, "zzi"});
        } else if (i11 == 3) {
            return new zzmz();
        } else {
            if (i11 == 4) {
                return new zzmy((zzjy) null);
            }
            if (i11 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
