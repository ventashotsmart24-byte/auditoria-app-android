package com.google.android.gms.internal.cast;

public final class zzll extends zzoy<zzll, zzlk> implements zzqf {
    private static final zzpe<Integer, zzjo> zzb = new zzlj();
    /* access modifiers changed from: private */
    public static final zzll zze;
    private int zzf;
    private String zzg = "";
    private boolean zzh;
    private zznm zzi;
    private boolean zzj;
    private zzpd zzk = zzoy.zzu();

    static {
        zzll zzll = new zzll();
        zze = zzll;
        zzoy.zzA(zzll.class, zzll);
    }

    private zzll() {
    }

    public final Object zzb(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return zzoy.zzz(zze, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0000\u0001ဈ\u0000\u0002ဇ\u0001\u0003ဉ\u0002\u0004ဇ\u0003\u0005,", new Object[]{"zzf", "zzg", "zzh", "zzi", "zzj", "zzk", zzjo.zza()});
        } else if (i11 == 3) {
            return new zzll();
        } else {
            if (i11 == 4) {
                return new zzlk((zzjy) null);
            }
            if (i11 != 5) {
                return null;
            }
            return zze;
        }
    }
}
