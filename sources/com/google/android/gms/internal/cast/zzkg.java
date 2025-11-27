package com.google.android.gms.internal.cast;

public final class zzkg extends zzoy<zzkg, zzkf> implements zzqf {
    /* access modifiers changed from: private */
    public static final zzkg zzb;
    private int zze;
    private int zzf;
    private double zzg;
    private double zzh;
    private double zzi;
    private double zzj;

    static {
        zzkg zzkg = new zzkg();
        zzb = zzkg;
        zzoy.zzA(zzkg.class, zzkg);
    }

    private zzkg() {
    }

    public final Object zzb(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return zzoy.zzz(zzb, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဋ\u0000\u0002က\u0001\u0003က\u0002\u0004က\u0003\u0005က\u0004", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi", "zzj"});
        } else if (i11 == 3) {
            return new zzkg();
        } else {
            if (i11 == 4) {
                return new zzkf((zzjy) null);
            }
            if (i11 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
