package com.google.android.gms.internal.cast;

public final class zzlc extends zzoy<zzlc, zzlb> implements zzqf {
    /* access modifiers changed from: private */
    public static final zzlc zzb;
    private int zze;
    private String zzf = "";
    private String zzg = "";

    static {
        zzlc zzlc = new zzlc();
        zzb = zzlc;
        zzoy.zzA(zzlc.class, zzlc);
    }

    private zzlc() {
    }

    public static zzlb zza() {
        return (zzlb) zzb.zzr();
    }

    public static /* synthetic */ void zzd(zzlc zzlc, String str) {
        str.getClass();
        zzlc.zze |= 1;
        zzlc.zzf = str;
    }

    public final Object zzb(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return zzoy.zzz(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001", new Object[]{"zze", "zzf", "zzg"});
        } else if (i11 == 3) {
            return new zzlc();
        } else {
            if (i11 == 4) {
                return new zzlb((zzjy) null);
            }
            if (i11 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
