package bb;

import com.google.common.primitives.UnsignedBytes;

public class a extends b {
    public int b(byte[] bArr, int i10) {
        byte b10;
        if ((bArr[i10] & UnsignedBytes.MAX_VALUE) != 164 || (b10 = bArr[i10 + 1] & UnsignedBytes.MAX_VALUE) < 161 || b10 > 243) {
            return -1;
        }
        return b10 - 161;
    }
}
