package com.google.android.gms.internal.cast;

public final class zzmn extends zzoy<zzmn, zzmm> implements zzqf {
    /* access modifiers changed from: private */
    public static final zzmn zzb;
    private int zze;
    private int zzf;
    private String zzg = "";

    static {
        zzmn zzmn = new zzmn();
        zzb = zzmn;
        zzoy.zzA(zzmn.class, zzmn);
    }

    private zzmn() {
    }

    public final Object zzb(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return zzoy.zzz(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001င\u0000\u0002ဈ\u0001", new Object[]{"zze", "zzf", "zzg"});
        } else if (i11 == 3) {
            return new zzmn();
        } else {
            if (i11 == 4) {
                return new zzmm((zzjy) null);
            }
            if (i11 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
