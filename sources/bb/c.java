package bb;

import com.google.common.primitives.UnsignedBytes;

public class c extends b {
    public int b(byte[] bArr, int i10) {
        byte b10;
        if ((bArr[i10] & UnsignedBytes.MAX_VALUE) != 130 || (b10 = bArr[i10 + 1] & UnsignedBytes.MAX_VALUE) < 159 || b10 > 241) {
            return -1;
        }
        return b10 - 159;
    }
}
