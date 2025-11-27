package com.google.android.gms.internal.cast;

import java.util.Iterator;

public final class zzke extends zzoy<zzke, zzkd> implements zzqf {
    private static final zzpe<Integer, zzju> zzb = new zzkc();
    /* access modifiers changed from: private */
    public static final zzke zze;
    private int zzf;
    private zzkk zzg;
    private zzmb zzh;
    private zzpg<zzlx> zzi = zzoy.zzw();
    private zzpd zzj = zzoy.zzu();

    static {
        zzke zzke = new zzke();
        zze = zzke;
        zzoy.zzA(zzke.class, zzke);
    }

    private zzke() {
    }

    public static zzkd zza() {
        return (zzkd) zze.zzr();
    }

    public static /* synthetic */ void zzd(zzke zzke, zzkk zzkk) {
        zzkk.getClass();
        zzke.zzg = zzkk;
        zzke.zzf |= 1;
    }

    public static /* synthetic */ void zze(zzke zzke, Iterable iterable) {
        int i10;
        zzpd zzpd = zzke.zzj;
        if (!zzpd.zzc()) {
            int size = zzpd.size();
            if (size == 0) {
                i10 = 10;
            } else {
                i10 = size + size;
            }
            zzke.zzj = zzpd.zzf(i10);
        }
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            zzke.zzj.zzh(((zzju) it.next()).zza());
        }
    }

    public final Object zzb(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return zzoy.zzz(zze, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0002\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003\u001b\u0004\u001e", new Object[]{"zzf", "zzg", "zzh", "zzi", zzlx.class, "zzj", zzju.zzc()});
        } else if (i11 == 3) {
            return new zzke();
        } else {
            if (i11 == 4) {
                return new zzkd((zzjy) null);
            }
            if (i11 != 5) {
                return null;
            }
            return zze;
        }
    }
}
