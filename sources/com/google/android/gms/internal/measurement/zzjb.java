package com.google.android.gms.internal.measurement;

import java.nio.charset.Charset;

class zzjb extends zzja {
    protected final byte[] zza;

    public zzjb(byte[] bArr) {
        bArr.getClass();
        this.zza = bArr;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzje) || zzd() != ((zzje) obj).zzd()) {
            return false;
        }
        if (zzd() == 0) {
            return true;
        }
        if (!(obj instanceof zzjb)) {
            return obj.equals(this);
        }
        zzjb zzjb = (zzjb) obj;
        int zzk = zzk();
        int zzk2 = zzjb.zzk();
        if (zzk != 0 && zzk2 != 0 && zzk != zzk2) {
            return false;
        }
        int zzd = zzd();
        if (zzd > zzjb.zzd()) {
            int zzd2 = zzd();
            throw new IllegalArgumentException("Length too large: " + zzd + zzd2);
        } else if (zzd <= zzjb.zzd()) {
            byte[] bArr = this.zza;
            byte[] bArr2 = zzjb.zza;
            zzjb.zzc();
            int i10 = 0;
            int i11 = 0;
            while (i10 < zzd) {
                if (bArr[i10] != bArr2[i11]) {
                    return false;
                }
                i10++;
                i11++;
            }
            return true;
        } else {
            int zzd3 = zzjb.zzd();
            throw new IllegalArgumentException("Ran off end of other: 0, " + zzd + ", " + zzd3);
        }
    }

    public byte zza(int i10) {
        return this.zza[i10];
    }

    public byte zzb(int i10) {
        return this.zza[i10];
    }

    public int zzc() {
        return 0;
    }

    public int zzd() {
        return this.zza.length;
    }

    public final int zze(int i10, int i11, int i12) {
        return zzkn.zzd(i10, this.zza, 0, i12);
    }

    public final zzje zzf(int i10, int i11) {
        int zzj = zzje.zzj(0, i11, zzd());
        if (zzj == 0) {
            return zzje.zzb;
        }
        return new zziy(this.zza, 0, zzj);
    }

    public final String zzg(Charset charset) {
        return new String(this.zza, 0, zzd(), charset);
    }

    public final void zzh(zziu zziu) {
        ((zzjj) zziu).zzc(this.zza, 0, zzd());
    }

    public final boolean zzi() {
        return zznd.zzf(this.zza, 0, zzd());
    }
}
