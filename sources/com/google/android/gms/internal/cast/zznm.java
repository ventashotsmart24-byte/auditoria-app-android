package com.google.android.gms.internal.cast;

public final class zznm extends zzoy<zznm, zznl> implements zzqf {
    private static final zzpe<Integer, zzjo> zzb = new zznk();
    /* access modifiers changed from: private */
    public static final zznm zze;
    private int zzf;
    private int zzg;
    private int zzh;
    private zzpd zzi = zzoy.zzu();
    private int zzj;

    static {
        zznm zznm = new zznm();
        zze = zznm;
        zzoy.zzA(zznm.class, zznm);
    }

    private zznm() {
    }

    public final Object zzb(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return zzoy.zzz(zze, "\u0001\u0004\u0000\u0001\u0001\u0005\u0004\u0000\u0001\u0000\u0001ဌ\u0000\u0002ဌ\u0001\u0003\u001e\u0005ဌ\u0002", new Object[]{"zzf", "zzg", zzjr.zza(), "zzh", zzgl.zza(), "zzi", zzjo.zza(), "zzj", zzft.zza()});
        } else if (i11 == 3) {
            return new zznm();
        } else {
            if (i11 == 4) {
                return new zznl((zzjy) null);
            }
            if (i11 != 5) {
                return null;
            }
            return zze;
        }
    }
}
