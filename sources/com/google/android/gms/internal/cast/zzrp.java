package com.google.android.gms.internal.cast;

import com.google.common.base.Ascii;

final class zzrp extends zzro {
    public final int zza(int i10, byte[] bArr, int i11, int i12) {
        int i13;
        int i14 = 0;
        while (i13 < i12 && bArr[i13] >= 0) {
            i14 = i13 + 1;
        }
        if (i13 >= i12) {
            return 0;
        }
        while (i13 < i12) {
            int i15 = i13 + 1;
            byte b10 = bArr[i13];
            if (b10 < 0) {
                if (b10 < -32) {
                    if (i15 >= i12) {
                        return b10;
                    }
                    if (b10 >= -62) {
                        i13 = i15 + 1;
                        if (bArr[i15] > -65) {
                        }
                    }
                } else if (b10 < -16) {
                    if (i15 >= i12 - 1) {
                        return zzrr.zza(bArr, i15, i12);
                    }
                    int i16 = i15 + 1;
                    byte b11 = bArr[i15];
                    if (b11 <= -65 && ((b10 != -32 || b11 >= -96) && (b10 != -19 || b11 < -96))) {
                        i13 = i16 + 1;
                        if (bArr[i16] > -65) {
                        }
                    }
                } else if (i15 >= i12 - 2) {
                    return zzrr.zza(bArr, i15, i12);
                } else {
                    int i17 = i15 + 1;
                    byte b12 = bArr[i15];
                    if (b12 <= -65 && (((b10 << Ascii.FS) + (b12 + 112)) >> 30) == 0) {
                        int i18 = i17 + 1;
                        if (bArr[i17] <= -65) {
                            i15 = i18 + 1;
                            if (bArr[i18] > -65) {
                            }
                        }
                    }
                }
                return -1;
            }
            i13 = i15;
        }
        return 0;
    }
}
