package com.google.android.gms.internal.cast;

public final class zzmp extends zzoy<zzmp, zzmo> implements zzqf {
    /* access modifiers changed from: private */
    public static final zzmp zzb;
    private int zze;
    private boolean zzf;
    private boolean zzg;
    private int zzh;
    private String zzi = "";
    private int zzj;
    private int zzk;
    private String zzl = "";

    static {
        zzmp zzmp = new zzmp();
        zzb = zzmp;
        zzoy.zzA(zzmp.class, zzmp);
    }

    private zzmp() {
    }

    public final Object zzb(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return zzoy.zzz(zzb, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0000\u0000\u0001ဇ\u0000\u0002ဇ\u0001\u0003င\u0002\u0004ဈ\u0003\u0005င\u0004\u0006င\u0005\u0007ဈ\u0006", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl"});
        } else if (i11 == 3) {
            return new zzmp();
        } else {
            if (i11 == 4) {
                return new zzmo((zzjy) null);
            }
            if (i11 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
