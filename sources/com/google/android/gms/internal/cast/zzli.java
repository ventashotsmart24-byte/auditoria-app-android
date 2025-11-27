package com.google.android.gms.internal.cast;

public final class zzli extends zzoy<zzli, zzlh> implements zzqf {
    /* access modifiers changed from: private */
    public static final zzli zzb;
    private int zze;
    private boolean zzf;
    private int zzg;
    private int zzh;
    private int zzi;
    private zzmf zzj;
    private int zzk;

    static {
        zzli zzli = new zzli();
        zzb = zzli;
        zzoy.zzA(zzli.class, zzli);
    }

    private zzli() {
    }

    public final Object zzb(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return zzoy.zzz(zzb, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ဇ\u0000\u0002ဌ\u0001\u0003ဌ\u0002\u0004ဌ\u0003\u0005ဉ\u0004\u0006ဌ\u0005", new Object[]{"zze", "zzf", "zzg", zzgl.zza(), "zzh", zzgr.zza(), "zzi", zzfe.zza(), "zzj", "zzk", zzgo.zza()});
        } else if (i11 == 3) {
            return new zzli();
        } else {
            if (i11 == 4) {
                return new zzlh((zzjy) null);
            }
            if (i11 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
