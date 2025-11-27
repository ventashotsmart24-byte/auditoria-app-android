package com.google.android.gms.internal.cast;

public final class zznj extends zzoy<zznj, zzni> implements zzqf {
    /* access modifiers changed from: private */
    public static final zznj zzb;
    private int zze;
    private int zzf;
    private int zzg;
    private zzpg<zzlc> zzh = zzoy.zzw();
    private zzpg<zzlc> zzi = zzoy.zzw();
    private int zzj;

    static {
        zznj zznj = new zznj();
        zzb = zznj;
        zzoy.zzA(zznj.class, zznj);
    }

    private zznj() {
    }

    public final Object zzb(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            Class<zzlc> cls = zzlc.class;
            return zzoy.zzz(zzb, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0002\u0000\u0001ဌ\u0000\u0002ဌ\u0001\u0003\u001b\u0004\u001b\u0005ဌ\u0002", new Object[]{"zze", "zzf", zzji.zza(), "zzg", zzjl.zza(), "zzh", cls, "zzi", cls, "zzj", zzgl.zza()});
        } else if (i11 == 3) {
            return new zznj();
        } else {
            if (i11 == 4) {
                return new zzni((zzjy) null);
            }
            if (i11 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
