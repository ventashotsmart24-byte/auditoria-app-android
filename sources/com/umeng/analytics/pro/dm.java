package com.umeng.analytics.pro;

import java.util.BitSet;

public final class dm extends da {

    public static class a implements di {
        public dg a(du duVar) {
            return new dm(duVar);
        }
    }

    public dm(du duVar) {
        super(duVar);
    }

    public Class<? extends Cdo> D() {
        return dr.class;
    }

    public void a(BitSet bitSet, int i10) {
        for (byte a10 : b(bitSet, i10)) {
            a(a10);
        }
    }

    public BitSet b(int i10) {
        double d10 = (double) i10;
        Double.isNaN(d10);
        int ceil = (int) Math.ceil(d10 / 8.0d);
        byte[] bArr = new byte[ceil];
        for (int i11 = 0; i11 < ceil; i11++) {
            bArr[i11] = u();
        }
        return a(bArr);
    }

    public static BitSet a(byte[] bArr) {
        BitSet bitSet = new BitSet();
        for (int i10 = 0; i10 < bArr.length * 8; i10++) {
            if ((bArr[(bArr.length - (i10 / 8)) - 1] & (1 << (i10 % 8))) > 0) {
                bitSet.set(i10);
            }
        }
        return bitSet;
    }

    public static byte[] b(BitSet bitSet, int i10) {
        double d10 = (double) i10;
        Double.isNaN(d10);
        int ceil = (int) Math.ceil(d10 / 8.0d);
        byte[] bArr = new byte[ceil];
        for (int i11 = 0; i11 < bitSet.length(); i11++) {
            if (bitSet.get(i11)) {
                int i12 = (ceil - (i11 / 8)) - 1;
                bArr[i12] = (byte) ((1 << (i11 % 8)) | bArr[i12]);
            }
        }
        return bArr;
    }
}
