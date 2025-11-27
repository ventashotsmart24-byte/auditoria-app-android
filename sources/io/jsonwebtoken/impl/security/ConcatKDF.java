package io.jsonwebtoken.impl.security;

import io.jsonwebtoken.impl.lang.Bytes;
import io.jsonwebtoken.impl.lang.CheckedFunction;
import io.jsonwebtoken.lang.Assert;
import java.io.ByteArrayOutputStream;
import java.security.MessageDigest;

final class ConcatKDF extends CryptoAlgorithm {
    private static final long MAX_DERIVED_KEY_BIT_LENGTH = 17179869176L;
    private static final long MAX_HASH_INPUT_BIT_LENGTH = 17179869176L;
    private static final long MAX_HASH_INPUT_BYTE_LENGTH = 2147483647L;
    private static final long MAX_REP_COUNT = 4294967295L;
    /* access modifiers changed from: private */
    public final int hashBitLength;

    public static class ClearableByteArrayOutputStream extends ByteArrayOutputStream {
        public ClearableByteArrayOutputStream(int i10) {
            super(i10);
        }

        public synchronized void reset() {
            super.reset();
            Bytes.clear(this.buf);
        }
    }

    public ConcatKDF(String str) {
        super("ConcatKDF", str);
        boolean z10;
        int intValue = ((Integer) jca().withMessageDigest(new CheckedFunction<MessageDigest, Integer>() {
            public Integer apply(MessageDigest messageDigest) {
                return Integer.valueOf(messageDigest.getDigestLength());
            }
        })).intValue() * 8;
        this.hashBitLength = intValue;
        if (intValue > 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        Assert.state(z10, "MessageDigest length must be a positive value.");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v15, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: byte[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public javax.crypto.SecretKey deriveKey(byte[] r20, long r21, byte[] r23) {
        /*
            r19 = this;
            r9 = r21
            java.lang.String r0 = "Z cannot be null or empty."
            r6 = r20
            io.jsonwebtoken.lang.Assert.notEmpty((byte[]) r6, (java.lang.String) r0)
            r0 = 0
            int r4 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            if (r4 <= 0) goto L_0x0011
            r0 = 1
            goto L_0x0012
        L_0x0011:
            r0 = 0
        L_0x0012:
            java.lang.String r1 = "derivedKeyBitLength must be a positive integer."
            io.jsonwebtoken.lang.Assert.isTrue(r0, r1)
            r0 = 17179869176(0x3fffffff8, double:8.48798316E-314)
            int r4 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            if (r4 > 0) goto L_0x00c0
            r4 = 8
            long r4 = r9 / r4
            if (r23 != 0) goto L_0x0029
            byte[] r7 = io.jsonwebtoken.impl.lang.Bytes.EMPTY
            goto L_0x002b
        L_0x0029:
            r7 = r23
        L_0x002b:
            double r11 = (double) r9
            r13 = r19
            int r8 = r13.hashBitLength
            double r14 = (double) r8
            java.lang.Double.isNaN(r11)
            java.lang.Double.isNaN(r14)
            double r11 = r11 / r14
            double r14 = java.lang.Math.ceil(r11)
            long r14 = (long) r14
            double r2 = (double) r14
            int r17 = (r11 > r2 ? 1 : (r11 == r2 ? 0 : -1))
            if (r17 == 0) goto L_0x0044
            r11 = 1
            goto L_0x0045
        L_0x0044:
            r11 = 0
        L_0x0045:
            r2 = 4294967295(0xffffffff, double:2.1219957905E-314)
            int r12 = (r14 > r2 ? 1 : (r14 == r2 ? 0 : -1))
            if (r12 > 0) goto L_0x0050
            r2 = 1
            goto L_0x0051
        L_0x0050:
            r2 = 0
        L_0x0051:
            java.lang.String r3 = "derivedKeyBitLength is too large."
            io.jsonwebtoken.lang.Assert.state(r2, r3)
            r2 = 4
            byte[] r12 = new byte[r2]
            r12 = {0, 0, 0, 1} // fill-array
            long r2 = io.jsonwebtoken.impl.lang.Bytes.bitLength(r12)
            long r17 = io.jsonwebtoken.impl.lang.Bytes.bitLength(r20)
            long r2 = r2 + r17
            long r17 = io.jsonwebtoken.impl.lang.Bytes.bitLength(r7)
            long r2 = r2 + r17
            int r17 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r17 > 0) goto L_0x0072
            r2 = 1
            goto L_0x0073
        L_0x0072:
            r2 = 0
        L_0x0073:
            java.lang.String r0 = "Hash input is too large."
            io.jsonwebtoken.lang.Assert.state(r2, r0)
            io.jsonwebtoken.impl.security.ConcatKDF$ClearableByteArrayOutputStream r8 = new io.jsonwebtoken.impl.security.ConcatKDF$ClearableByteArrayOutputStream
            int r0 = (int) r4
            r8.<init>(r0)
            byte[] r16 = io.jsonwebtoken.impl.lang.Bytes.EMPTY
            io.jsonwebtoken.impl.security.JcaTemplate r0 = r19.jca()     // Catch:{ all -> 0x00b4 }
            io.jsonwebtoken.impl.security.ConcatKDF$2 r5 = new io.jsonwebtoken.impl.security.ConcatKDF$2     // Catch:{ all -> 0x00b4 }
            r1 = r5
            r2 = r19
            r3 = r14
            r14 = r5
            r5 = r12
            r6 = r20
            r15 = r8
            r8 = r11
            r9 = r21
            r11 = r15
            r1.<init>(r3, r5, r6, r7, r8, r9, r11)     // Catch:{ all -> 0x00b2 }
            java.lang.Object r0 = r0.withMessageDigest(r14)     // Catch:{ all -> 0x00b2 }
            r1 = r0
            byte[] r1 = (byte[]) r1     // Catch:{ all -> 0x00b2 }
            javax.crypto.spec.SecretKeySpec r0 = new javax.crypto.spec.SecretKeySpec     // Catch:{ all -> 0x00ae }
            java.lang.String r2 = "AES"
            r0.<init>(r1, r2)     // Catch:{ all -> 0x00ae }
            io.jsonwebtoken.impl.lang.Bytes.clear(r1)
            io.jsonwebtoken.impl.lang.Bytes.clear(r12)
            r15.reset()
            return r0
        L_0x00ae:
            r0 = move-exception
            r16 = r1
            goto L_0x00b6
        L_0x00b2:
            r0 = move-exception
            goto L_0x00b6
        L_0x00b4:
            r0 = move-exception
            r15 = r8
        L_0x00b6:
            io.jsonwebtoken.impl.lang.Bytes.clear(r16)
            io.jsonwebtoken.impl.lang.Bytes.clear(r12)
            r15.reset()
            throw r0
        L_0x00c0:
            r13 = r19
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "derivedKeyBitLength may not exceed "
            r2.append(r3)
            java.lang.String r0 = io.jsonwebtoken.impl.lang.Bytes.bitsMsg(r0)
            r2.append(r0)
            java.lang.String r0 = ". Specified size: "
            r2.append(r0)
            java.lang.String r0 = io.jsonwebtoken.impl.lang.Bytes.bitsMsg(r21)
            r2.append(r0)
            java.lang.String r0 = "."
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.jsonwebtoken.impl.security.ConcatKDF.deriveKey(byte[], long, byte[]):javax.crypto.SecretKey");
    }
}
