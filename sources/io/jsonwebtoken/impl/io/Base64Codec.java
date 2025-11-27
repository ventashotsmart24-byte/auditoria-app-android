package io.jsonwebtoken.impl.io;

import com.google.common.base.Ascii;
import io.jsonwebtoken.impl.io.BaseNCodec;
import io.jsonwebtoken.lang.Strings;

class Base64Codec extends BaseNCodec {
    private static final int BITS_PER_ENCODED_BYTE = 6;
    private static final int BYTES_PER_ENCODED_BLOCK = 4;
    private static final int BYTES_PER_UNENCODED_BLOCK = 3;
    private static final byte[] DECODE_TABLE = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, 62, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, Ascii.DC2, 19, Ascii.DC4, Ascii.NAK, Ascii.SYN, Ascii.ETB, Ascii.CAN, Ascii.EM, -1, -1, -1, -1, 63, -1, Ascii.SUB, Ascii.ESC, Ascii.FS, Ascii.GS, Ascii.RS, Ascii.US, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51};
    private static final int MASK_2BITS = 3;
    private static final int MASK_4BITS = 15;
    private static final int MASK_6BITS = 63;
    private static final byte[] STANDARD_ENCODE_TABLE = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
    private static final byte[] URL_SAFE_ENCODE_TABLE = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};
    private final int decodeSize;
    private final byte[] decodeTable;
    private final int encodeSize;
    private final byte[] encodeTable;
    private final byte[] lineSeparator;

    public Base64Codec() {
        this(0);
    }

    private void validateCharacter(int i10, BaseNCodec.Context context) {
        if (isStrictDecoding() && (i10 & context.ibitWorkArea) != 0) {
            throw new IllegalArgumentException("Strict decoding: Last encoded character (before the paddings if any) is a valid base 64 alphabet but not a possible encoding. Expected the discarded bits from the character to be zero.");
        }
    }

    private void validateTrailingCharacter() {
        if (isStrictDecoding()) {
            throw new IllegalArgumentException("Strict decoding: Last encoded character (before the paddings if any) is a valid base 64 alphabet but not a possible encoding. Decoding requires at least two trailing 6-bit characters to create bytes.");
        }
    }

    public void decode(byte[] bArr, int i10, int i11, BaseNCodec.Context context) {
        byte b10;
        if (!context.eof) {
            if (i11 < 0) {
                context.eof = true;
            }
            int i12 = 0;
            while (true) {
                if (i12 >= i11) {
                    break;
                }
                byte[] ensureBufferSize = ensureBufferSize(this.decodeSize, context);
                int i13 = i10 + 1;
                byte b11 = bArr[i10];
                if (b11 == this.pad) {
                    context.eof = true;
                    break;
                }
                if (b11 >= 0) {
                    byte[] bArr2 = DECODE_TABLE;
                    if (b11 < bArr2.length && (b10 = bArr2[b11]) >= 0) {
                        int i14 = (context.modulus + 1) % 4;
                        context.modulus = i14;
                        int i15 = (context.ibitWorkArea << 6) + b10;
                        context.ibitWorkArea = i15;
                        if (i14 == 0) {
                            int i16 = context.pos;
                            int i17 = i16 + 1;
                            ensureBufferSize[i16] = (byte) ((i15 >> 16) & 255);
                            int i18 = i17 + 1;
                            ensureBufferSize[i17] = (byte) ((i15 >> 8) & 255);
                            context.pos = i18 + 1;
                            ensureBufferSize[i18] = (byte) (i15 & 255);
                        }
                    }
                }
                i12++;
                i10 = i13;
            }
            if (context.eof && context.modulus != 0) {
                byte[] ensureBufferSize2 = ensureBufferSize(this.decodeSize, context);
                int i19 = context.modulus;
                if (i19 == 1) {
                    validateTrailingCharacter();
                } else if (i19 == 2) {
                    validateCharacter(15, context);
                    int i20 = context.ibitWorkArea >> 4;
                    context.ibitWorkArea = i20;
                    int i21 = context.pos;
                    context.pos = i21 + 1;
                    ensureBufferSize2[i21] = (byte) (i20 & 255);
                } else if (i19 == 3) {
                    validateCharacter(3, context);
                    int i22 = context.ibitWorkArea >> 2;
                    context.ibitWorkArea = i22;
                    int i23 = context.pos;
                    int i24 = i23 + 1;
                    ensureBufferSize2[i23] = (byte) ((i22 >> 8) & 255);
                    context.pos = i24 + 1;
                    ensureBufferSize2[i24] = (byte) (i22 & 255);
                } else {
                    throw new IllegalStateException("Impossible modulus " + context.modulus);
                }
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v19, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v20, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void encode(byte[] r10, int r11, int r12, io.jsonwebtoken.impl.io.BaseNCodec.Context r13) {
        /*
            r9 = this;
            boolean r0 = r13.eof
            if (r0 == 0) goto L_0x0005
            return
        L_0x0005:
            r0 = 0
            r1 = 1
            if (r12 >= 0) goto L_0x00b7
            r13.eof = r1
            int r10 = r13.modulus
            if (r10 != 0) goto L_0x0014
            int r10 = r9.lineLength
            if (r10 != 0) goto L_0x0014
            return
        L_0x0014:
            int r10 = r9.encodeSize
            byte[] r10 = r9.ensureBufferSize(r10, r13)
            int r11 = r13.pos
            int r12 = r13.modulus
            if (r12 == 0) goto L_0x0099
            if (r12 == r1) goto L_0x006f
            r1 = 2
            if (r12 != r1) goto L_0x0056
            int r12 = r11 + 1
            byte[] r2 = r9.encodeTable
            int r3 = r13.ibitWorkArea
            int r4 = r3 >> 10
            r4 = r4 & 63
            byte r4 = r2[r4]
            r10[r11] = r4
            int r4 = r12 + 1
            int r5 = r3 >> 4
            r5 = r5 & 63
            byte r5 = r2[r5]
            r10[r12] = r5
            int r12 = r4 + 1
            r13.pos = r12
            int r1 = r3 << 2
            r1 = r1 & 63
            byte r1 = r2[r1]
            r10[r4] = r1
            byte[] r1 = STANDARD_ENCODE_TABLE
            if (r2 != r1) goto L_0x0099
            int r1 = r12 + 1
            r13.pos = r1
            byte r1 = r9.pad
            r10[r12] = r1
            goto L_0x0099
        L_0x0056:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r12 = "Impossible modulus "
            r11.append(r12)
            int r12 = r13.modulus
            r11.append(r12)
            java.lang.String r11 = r11.toString()
            r10.<init>(r11)
            throw r10
        L_0x006f:
            int r12 = r11 + 1
            byte[] r1 = r9.encodeTable
            int r2 = r13.ibitWorkArea
            int r3 = r2 >> 2
            r3 = r3 & 63
            byte r3 = r1[r3]
            r10[r11] = r3
            int r3 = r12 + 1
            r13.pos = r3
            int r2 = r2 << 4
            r2 = r2 & 63
            byte r2 = r1[r2]
            r10[r12] = r2
            byte[] r12 = STANDARD_ENCODE_TABLE
            if (r1 != r12) goto L_0x0099
            int r12 = r3 + 1
            byte r1 = r9.pad
            r10[r3] = r1
            int r2 = r12 + 1
            r13.pos = r2
            r10[r12] = r1
        L_0x0099:
            int r12 = r13.currentLinePos
            int r1 = r13.pos
            int r11 = r1 - r11
            int r12 = r12 + r11
            r13.currentLinePos = r12
            int r11 = r9.lineLength
            if (r11 <= 0) goto L_0x0124
            if (r12 <= 0) goto L_0x0124
            byte[] r11 = r9.lineSeparator
            int r12 = r11.length
            java.lang.System.arraycopy(r11, r0, r10, r1, r12)
            int r10 = r13.pos
            byte[] r11 = r9.lineSeparator
            int r11 = r11.length
            int r10 = r10 + r11
            r13.pos = r10
            goto L_0x0124
        L_0x00b7:
            r2 = 0
        L_0x00b8:
            if (r2 >= r12) goto L_0x0124
            int r3 = r9.encodeSize
            byte[] r3 = r9.ensureBufferSize(r3, r13)
            int r4 = r13.modulus
            int r4 = r4 + r1
            int r4 = r4 % 3
            r13.modulus = r4
            int r5 = r11 + 1
            byte r11 = r10[r11]
            if (r11 >= 0) goto L_0x00cf
            int r11 = r11 + 256
        L_0x00cf:
            int r6 = r13.ibitWorkArea
            int r6 = r6 << 8
            int r6 = r6 + r11
            r13.ibitWorkArea = r6
            if (r4 != 0) goto L_0x0120
            int r11 = r13.pos
            int r4 = r11 + 1
            byte[] r7 = r9.encodeTable
            int r8 = r6 >> 18
            r8 = r8 & 63
            byte r8 = r7[r8]
            r3[r11] = r8
            int r11 = r4 + 1
            int r8 = r6 >> 12
            r8 = r8 & 63
            byte r8 = r7[r8]
            r3[r4] = r8
            int r4 = r11 + 1
            int r8 = r6 >> 6
            r8 = r8 & 63
            byte r8 = r7[r8]
            r3[r11] = r8
            int r11 = r4 + 1
            r13.pos = r11
            r6 = r6 & 63
            byte r6 = r7[r6]
            r3[r4] = r6
            int r4 = r13.currentLinePos
            int r4 = r4 + 4
            r13.currentLinePos = r4
            int r6 = r9.lineLength
            if (r6 <= 0) goto L_0x0120
            if (r6 > r4) goto L_0x0120
            byte[] r4 = r9.lineSeparator
            int r6 = r4.length
            java.lang.System.arraycopy(r4, r0, r3, r11, r6)
            int r11 = r13.pos
            byte[] r3 = r9.lineSeparator
            int r3 = r3.length
            int r11 = r11 + r3
            r13.pos = r11
            r13.currentLinePos = r0
        L_0x0120:
            int r2 = r2 + 1
            r11 = r5
            goto L_0x00b8
        L_0x0124:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.jsonwebtoken.impl.io.Base64Codec.encode(byte[], int, int, io.jsonwebtoken.impl.io.BaseNCodec$Context):void");
    }

    public boolean isInAlphabet(byte b10) {
        if (b10 >= 0) {
            byte[] bArr = this.decodeTable;
            if (b10 >= bArr.length || bArr[b10] == -1) {
                return false;
            }
            return true;
        }
        return false;
    }

    public boolean isUrlSafe() {
        if (this.encodeTable == URL_SAFE_ENCODE_TABLE) {
            return true;
        }
        return false;
    }

    public Base64Codec(boolean z10) {
        this(76, BaseNCodec.CHUNK_SEPARATOR, z10);
    }

    public Base64Codec(int i10) {
        this(i10, BaseNCodec.CHUNK_SEPARATOR);
    }

    public Base64Codec(int i10, byte[] bArr) {
        this(i10, bArr, false);
    }

    public Base64Codec(int i10, byte[] bArr, boolean z10) {
        this(i10, bArr, z10, BaseNCodec.DECODING_POLICY_DEFAULT);
    }

    public Base64Codec(int i10, byte[] bArr, boolean z10, CodecPolicy codecPolicy) {
        super(3, 4, i10, BaseNCodec.length(bArr), (byte) 61, codecPolicy);
        this.decodeTable = DECODE_TABLE;
        if (bArr == null) {
            this.encodeSize = 4;
            this.lineSeparator = null;
        } else if (containsAlphabetOrPad(bArr)) {
            String utf8 = Strings.utf8(bArr);
            throw new IllegalArgumentException("lineSeparator must not contain base64 characters: [" + utf8 + "]");
        } else if (i10 > 0) {
            this.encodeSize = bArr.length + 4;
            this.lineSeparator = (byte[]) bArr.clone();
        } else {
            this.encodeSize = 4;
            this.lineSeparator = null;
        }
        this.decodeSize = this.encodeSize - 1;
        this.encodeTable = z10 ? URL_SAFE_ENCODE_TABLE : STANDARD_ENCODE_TABLE;
    }
}
