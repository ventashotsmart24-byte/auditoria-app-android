package com.google.android.gms.internal.measurement;

import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class zzjm extends zziu {
    private static final Logger zzb = Logger.getLogger(zzjm.class.getName());
    /* access modifiers changed from: private */
    public static final boolean zzc = zzmy.zzx();
    zzjn zza;

    private zzjm() {
    }

    public /* synthetic */ zzjm(zzjl zzjl) {
    }

    public static int zzA(int i10) {
        if ((i10 & -128) == 0) {
            return 1;
        }
        if ((i10 & -16384) == 0) {
            return 2;
        }
        if ((-2097152 & i10) == 0) {
            return 3;
        }
        return (i10 & -268435456) == 0 ? 4 : 5;
    }

    public static int zzB(long j10) {
        int i10;
        if ((-128 & j10) == 0) {
            return 1;
        }
        if (j10 < 0) {
            return 10;
        }
        if ((-34359738368L & j10) != 0) {
            j10 >>>= 28;
            i10 = 6;
        } else {
            i10 = 2;
        }
        if ((-2097152 & j10) != 0) {
            i10 += 2;
            j10 >>>= 14;
        }
        return (j10 & -16384) != 0 ? i10 + 1 : i10;
    }

    public static zzjm zzC(byte[] bArr) {
        return new zzjj(bArr, 0, bArr.length);
    }

    public static int zzt(zzje zzje) {
        int zzd = zzje.zzd();
        return zzA(zzd) + zzd;
    }

    @Deprecated
    public static int zzu(int i10, zzlm zzlm, zzlx zzlx) {
        int zzA = zzA(i10 << 3);
        return zzA + zzA + ((zzio) zzlm).zzbr(zzlx);
    }

    public static int zzv(int i10) {
        if (i10 >= 0) {
            return zzA(i10);
        }
        return 10;
    }

    public static int zzw(zzks zzks) {
        int zza2 = zzks.zza();
        return zzA(zza2) + zza2;
    }

    public static int zzx(zzlm zzlm, zzlx zzlx) {
        int zzbr = ((zzio) zzlm).zzbr(zzlx);
        return zzA(zzbr) + zzbr;
    }

    public static int zzy(String str) {
        int i10;
        try {
            i10 = zznd.zzc(str);
        } catch (zznc unused) {
            i10 = str.getBytes(zzkn.zzb).length;
        }
        return zzA(i10) + i10;
    }

    public static int zzz(int i10) {
        return zzA(i10 << 3);
    }

    public final void zzD() {
        if (zza() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    public final void zzE(String str, zznc zznc) {
        zzb.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", zznc);
        byte[] bytes = str.getBytes(zzkn.zzb);
        try {
            int length = bytes.length;
            zzq(length);
            zzl(bytes, 0, length);
        } catch (IndexOutOfBoundsException e10) {
            throw new zzjk(e10);
        }
    }

    public abstract int zza();

    public abstract void zzb(byte b10);

    public abstract void zzd(int i10, boolean z10);

    public abstract void zze(int i10, zzje zzje);

    public abstract void zzf(int i10, int i11);

    public abstract void zzg(int i10);

    public abstract void zzh(int i10, long j10);

    public abstract void zzi(long j10);

    public abstract void zzj(int i10, int i11);

    public abstract void zzk(int i10);

    public abstract void zzl(byte[] bArr, int i10, int i11);

    public abstract void zzm(int i10, String str);

    public abstract void zzo(int i10, int i11);

    public abstract void zzp(int i10, int i11);

    public abstract void zzq(int i10);

    public abstract void zzr(int i10, long j10);

    public abstract void zzs(long j10);
}
