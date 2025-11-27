package com.google.android.gms.internal.cast;

public final class zzkb extends zzoy<zzkb, zzka> implements zzqf {
    private static final zzpe<Integer, zzju> zzb = new zzjz();
    /* access modifiers changed from: private */
    public static final zzkb zze;
    private int zzf;
    private String zzg = "";
    private String zzh = "";
    private zzpd zzi = zzoy.zzu();

    static {
        zzkb zzkb = new zzkb();
        zze = zzkb;
        zzoy.zzA(zzkb.class, zzkb);
    }

    private zzkb() {
    }

    public final Object zzb(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return zzoy.zzz(zze, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003\u001e", new Object[]{"zzf", "zzg", "zzh", "zzi", zzju.zzc()});
        } else if (i11 == 3) {
            return new zzkb();
        } else {
            if (i11 == 4) {
                return new zzka((zzjy) null);
            }
            if (i11 != 5) {
                return null;
            }
            return zze;
        }
    }
}
