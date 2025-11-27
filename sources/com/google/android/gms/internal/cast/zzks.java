package com.google.android.gms.internal.cast;

public final class zzks extends zzoy<zzks, zzkr> implements zzqf {
    /* access modifiers changed from: private */
    public static final zzks zzb;
    private int zze;
    private int zzf;
    private int zzg;
    private int zzh;
    private boolean zzi;
    private int zzj;

    static {
        zzks zzks = new zzks();
        zzb = zzks;
        zzoy.zzA(zzks.class, zzks);
    }

    private zzks() {
    }

    public final Object zzb(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return zzoy.zzz(zzb, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဌ\u0001\u0003ဌ\u0002\u0004ဇ\u0003\u0005င\u0004", new Object[]{"zze", "zzf", zzih.zza(), "zzg", zzib.zza(), "zzh", zzie.zza(), "zzi", "zzj"});
        } else if (i11 == 3) {
            return new zzks();
        } else {
            if (i11 == 4) {
                return new zzkr((zzjy) null);
            }
            if (i11 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
