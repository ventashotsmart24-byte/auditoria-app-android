package com.hpplay.component.protocol.encrypt;

import com.google.common.primitives.UnsignedBytes;

public class Verify16 {
    final int crypto_verify_16_ref_BYTES = 16;

    public static int crypto_verify(byte[] bArr, int i10, byte[] bArr2) {
        byte b10 = 0;
        for (int i11 = 0; i11 < 15; i11++) {
            b10 |= (bArr[i10 + i11] ^ bArr2[i11]) & UnsignedBytes.MAX_VALUE;
        }
        return (((b10 - 1) >>> 8) & 1) - 1;
    }
}
