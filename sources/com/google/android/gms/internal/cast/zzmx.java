package com.google.android.gms.internal.cast;

public final class zzmx extends zzoy<zzmx, zzmw> implements zzqf {
    /* access modifiers changed from: private */
    public static final zzmx zzb;
    private int zze;
    private zzlc zzf;
    private int zzg;
    private int zzh;
    private int zzi;
    private int zzj;
    private long zzk;
    private zzpg<zzlc> zzl = zzoy.zzw();

    static {
        zzmx zzmx = new zzmx();
        zzb = zzmx;
        zzoy.zzA(zzmx.class, zzmx);
    }

    private zzmx() {
    }

    public final Object zzb(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return zzoy.zzz(zzb, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0001\u0000\u0001ဉ\u0000\u0002ဌ\u0001\u0003ဌ\u0002\u0004ဌ\u0003\u0005ဌ\u0004\u0006ဂ\u0005\u0007\u001b", new Object[]{"zze", "zzf", "zzg", zzin.zza(), "zzh", zzik.zza(), "zzi", zzgl.zza(), "zzj", zzfh.zza(), "zzk", "zzl", zzlc.class});
        } else if (i11 == 3) {
            return new zzmx();
        } else {
            if (i11 == 4) {
                return new zzmw((zzjy) null);
            }
            if (i11 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
