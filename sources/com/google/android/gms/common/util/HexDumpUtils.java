package com.google.android.gms.common.util;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.common.primitives.UnsignedBytes;

@KeepForSdk
public final class HexDumpUtils {
    @KeepForSdk
    public static String dump(byte[] bArr, int i10, int i11, boolean z10) {
        int length;
        int i12;
        if (bArr == null || (length = bArr.length) == 0 || i10 < 0 || i11 <= 0 || i10 + i11 > length) {
            return null;
        }
        if (z10) {
            i12 = 75;
        } else {
            i12 = 57;
        }
        StringBuilder sb = new StringBuilder(i12 * ((i11 + 15) / 16));
        int i13 = i11;
        int i14 = 0;
        int i15 = 0;
        while (i13 > 0) {
            if (i14 == 0) {
                if (i11 < 65536) {
                    sb.append(String.format("%04X:", new Object[]{Integer.valueOf(i10)}));
                } else {
                    sb.append(String.format("%08X:", new Object[]{Integer.valueOf(i10)}));
                }
                i15 = i10;
            } else if (i14 == 8) {
                sb.append(" -");
            }
            sb.append(String.format(" %02X", new Object[]{Integer.valueOf(bArr[i10] & UnsignedBytes.MAX_VALUE)}));
            i13--;
            i14++;
            if (z10 && (i14 == 16 || i13 == 0)) {
                int i16 = 16 - i14;
                if (i16 > 0) {
                    for (int i17 = 0; i17 < i16; i17++) {
                        sb.append("   ");
                    }
                }
                if (i16 >= 8) {
                    sb.append("  ");
                }
                sb.append("  ");
                for (int i18 = 0; i18 < i14; i18++) {
                    char c10 = (char) bArr[i15 + i18];
                    if (c10 < ' ' || c10 > '~') {
                        c10 = '.';
                    }
                    sb.append(c10);
                }
            }
            if (i14 == 16 || i13 == 0) {
                sb.append(10);
                i14 = 0;
            }
            i10++;
        }
        return sb.toString();
    }
}
