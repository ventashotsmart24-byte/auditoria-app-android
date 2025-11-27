package cb;

import com.google.common.primitives.UnsignedBytes;

public class c extends g {
    public int b(byte[] bArr, int i10) {
        byte b10 = bArr[i10] & UnsignedBytes.MAX_VALUE;
        if (b10 < 161) {
            return -1;
        }
        return (((b10 - 161) * 94) + (bArr[i10 + 1] & UnsignedBytes.MAX_VALUE)) - 161;
    }
}
