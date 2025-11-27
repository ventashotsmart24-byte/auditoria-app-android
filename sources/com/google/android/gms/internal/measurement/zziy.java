package com.google.android.gms.internal.measurement;

final class zziy extends zzjb {
    private final int zzc;

    public zziy(byte[] bArr, int i10, int i11) {
        super(bArr);
        zzje.zzj(0, i11, bArr.length);
        this.zzc = i11;
    }

    public final byte zza(int i10) {
        int i11 = this.zzc;
        if (((i11 - (i10 + 1)) | i10) >= 0) {
            return this.zza[i10];
        }
        if (i10 < 0) {
            throw new ArrayIndexOutOfBoundsException("Index < 0: " + i10);
        }
        throw new ArrayIndexOutOfBoundsException("Index > length: " + i10 + ", " + i11);
    }

    public final byte zzb(int i10) {
        return this.zza[i10];
    }

    public final int zzc() {
        return 0;
    }

    public final int zzd() {
        return this.zzc;
    }
}
