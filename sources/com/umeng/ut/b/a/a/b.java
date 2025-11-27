package com.umeng.ut.b.a.a;

public class b {
    public static byte[] getBytes(int i10) {
        byte[] bArr = new byte[4];
        bArr[3] = (byte) (i10 % 256);
        int i11 = i10 >> 8;
        bArr[2] = (byte) (i11 % 256);
        int i12 = i11 >> 8;
        bArr[1] = (byte) (i12 % 256);
        bArr[0] = (byte) ((i12 >> 8) % 256);
        return bArr;
    }
}
