package com.google.android.gms.internal.cast;

public final class zznd extends zzoy<zznd, zznc> implements zzqf {
    /* access modifiers changed from: private */
    public static final zznd zzb;
    private int zze;
    private long zzf;
    private boolean zzg;
    private long zzh;
    private boolean zzi;

    static {
        zznd zznd = new zznd();
        zzb = zznd;
        zzoy.zzA(zznd.class, zznd);
    }

    private zznd() {
    }

    public final Object zzb(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return zzoy.zzz(zzb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဂ\u0000\u0002ဇ\u0001\u0003ဂ\u0002\u0004ဇ\u0003", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi"});
        } else if (i11 == 3) {
            return new zznd();
        } else {
            if (i11 == 4) {
                return new zznc((zzjy) null);
            }
            if (i11 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
