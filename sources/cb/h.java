package cb;

import com.google.common.primitives.UnsignedBytes;

public class h extends g {
    public int b(byte[] bArr, int i10) {
        int i11;
        byte b10 = bArr[i10] & UnsignedBytes.MAX_VALUE;
        if (b10 >= 129 && b10 <= 159) {
            i11 = b10 - 129;
        } else if (b10 < 224 || b10 > 239) {
            return -1;
        } else {
            i11 = (b10 - 224) + 31;
        }
        int i12 = i11 * 188;
        byte b11 = bArr[i10 + 1] & UnsignedBytes.MAX_VALUE;
        int i13 = i12 + (b11 - 64);
        return b11 >= 128 ? i13 - 1 : i13;
    }
}
