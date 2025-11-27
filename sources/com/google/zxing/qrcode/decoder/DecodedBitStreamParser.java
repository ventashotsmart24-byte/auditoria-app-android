package com.google.zxing.qrcode.decoder;

import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.common.BitSource;
import com.google.zxing.common.CharacterSetECI;
import com.google.zxing.common.StringUtils;
import java.io.UnsupportedEncodingException;
import java.util.Collection;
import java.util.Map;

final class DecodedBitStreamParser {
    private static final char[] ALPHANUMERIC_CHARS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ $%*+-./:".toCharArray();
    private static final int GB2312_SUBSET = 1;

    private DecodedBitStreamParser() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:59:0x00ea A[LOOP:0: B:1:0x001d->B:59:0x00ea, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00c9 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.zxing.common.DecoderResult decode(byte[] r17, com.google.zxing.qrcode.decoder.Version r18, com.google.zxing.qrcode.decoder.ErrorCorrectionLevel r19, java.util.Map<com.google.zxing.DecodeHintType, ?> r20) {
        /*
            r0 = r18
            com.google.zxing.common.BitSource r7 = new com.google.zxing.common.BitSource
            r8 = r17
            r7.<init>(r8)
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r1 = 50
            r9.<init>(r1)
            java.util.ArrayList r10 = new java.util.ArrayList
            r11 = 1
            r10.<init>(r11)
            r1 = -1
            r2 = 0
            r13 = -1
            r14 = -1
            r15 = 0
            r16 = 0
        L_0x001d:
            int r1 = r7.available()     // Catch:{ IllegalArgumentException -> 0x00ed }
            r2 = 4
            if (r1 >= r2) goto L_0x0028
            com.google.zxing.qrcode.decoder.Mode r1 = com.google.zxing.qrcode.decoder.Mode.TERMINATOR     // Catch:{ IllegalArgumentException -> 0x00ed }
        L_0x0026:
            r6 = r1
            goto L_0x0031
        L_0x0028:
            int r1 = r7.readBits(r2)     // Catch:{ IllegalArgumentException -> 0x00ed }
            com.google.zxing.qrcode.decoder.Mode r1 = com.google.zxing.qrcode.decoder.Mode.forBits(r1)     // Catch:{ IllegalArgumentException -> 0x00ed }
            goto L_0x0026
        L_0x0031:
            com.google.zxing.qrcode.decoder.Mode r5 = com.google.zxing.qrcode.decoder.Mode.TERMINATOR     // Catch:{ IllegalArgumentException -> 0x00ed }
            if (r6 == r5) goto L_0x00c5
            com.google.zxing.qrcode.decoder.Mode r1 = com.google.zxing.qrcode.decoder.Mode.FNC1_FIRST_POSITION     // Catch:{ IllegalArgumentException -> 0x00ed }
            if (r6 == r1) goto L_0x00c1
            com.google.zxing.qrcode.decoder.Mode r1 = com.google.zxing.qrcode.decoder.Mode.FNC1_SECOND_POSITION     // Catch:{ IllegalArgumentException -> 0x00ed }
            if (r6 != r1) goto L_0x003f
            goto L_0x00c1
        L_0x003f:
            com.google.zxing.qrcode.decoder.Mode r1 = com.google.zxing.qrcode.decoder.Mode.STRUCTURED_APPEND     // Catch:{ IllegalArgumentException -> 0x00ed }
            if (r6 != r1) goto L_0x005e
            int r1 = r7.available()     // Catch:{ IllegalArgumentException -> 0x00ed }
            r2 = 16
            if (r1 < r2) goto L_0x0059
            r1 = 8
            int r2 = r7.readBits(r1)     // Catch:{ IllegalArgumentException -> 0x00ed }
            int r1 = r7.readBits(r1)     // Catch:{ IllegalArgumentException -> 0x00ed }
            r14 = r1
            r13 = r2
            goto L_0x00c5
        L_0x0059:
            com.google.zxing.FormatException r0 = com.google.zxing.FormatException.getFormatInstance()     // Catch:{ IllegalArgumentException -> 0x00ed }
            throw r0     // Catch:{ IllegalArgumentException -> 0x00ed }
        L_0x005e:
            com.google.zxing.qrcode.decoder.Mode r1 = com.google.zxing.qrcode.decoder.Mode.ECI     // Catch:{ IllegalArgumentException -> 0x00ed }
            if (r6 != r1) goto L_0x0073
            int r1 = parseECIValue(r7)     // Catch:{ IllegalArgumentException -> 0x00ed }
            com.google.zxing.common.CharacterSetECI r16 = com.google.zxing.common.CharacterSetECI.getCharacterSetECIByValue(r1)     // Catch:{ IllegalArgumentException -> 0x00ed }
            if (r16 == 0) goto L_0x006e
            goto L_0x00c5
        L_0x006e:
            com.google.zxing.FormatException r0 = com.google.zxing.FormatException.getFormatInstance()     // Catch:{ IllegalArgumentException -> 0x00ed }
            throw r0     // Catch:{ IllegalArgumentException -> 0x00ed }
        L_0x0073:
            com.google.zxing.qrcode.decoder.Mode r1 = com.google.zxing.qrcode.decoder.Mode.HANZI     // Catch:{ IllegalArgumentException -> 0x00ed }
            if (r6 != r1) goto L_0x0089
            int r1 = r7.readBits(r2)     // Catch:{ IllegalArgumentException -> 0x00ed }
            int r2 = r6.getCharacterCountBits(r0)     // Catch:{ IllegalArgumentException -> 0x00ed }
            int r2 = r7.readBits(r2)     // Catch:{ IllegalArgumentException -> 0x00ed }
            if (r1 != r11) goto L_0x00c5
            decodeHanziSegment(r7, r9, r2)     // Catch:{ IllegalArgumentException -> 0x00ed }
            goto L_0x00c5
        L_0x0089:
            int r1 = r6.getCharacterCountBits(r0)     // Catch:{ IllegalArgumentException -> 0x00ed }
            int r3 = r7.readBits(r1)     // Catch:{ IllegalArgumentException -> 0x00ed }
            com.google.zxing.qrcode.decoder.Mode r1 = com.google.zxing.qrcode.decoder.Mode.NUMERIC     // Catch:{ IllegalArgumentException -> 0x00ed }
            if (r6 != r1) goto L_0x0099
            decodeNumericSegment(r7, r9, r3)     // Catch:{ IllegalArgumentException -> 0x00ed }
            goto L_0x00c5
        L_0x0099:
            com.google.zxing.qrcode.decoder.Mode r1 = com.google.zxing.qrcode.decoder.Mode.ALPHANUMERIC     // Catch:{ IllegalArgumentException -> 0x00ed }
            if (r6 != r1) goto L_0x00a1
            decodeAlphanumericSegment(r7, r9, r3, r15)     // Catch:{ IllegalArgumentException -> 0x00ed }
            goto L_0x00c5
        L_0x00a1:
            com.google.zxing.qrcode.decoder.Mode r1 = com.google.zxing.qrcode.decoder.Mode.BYTE     // Catch:{ IllegalArgumentException -> 0x00ed }
            if (r6 != r1) goto L_0x00b2
            r1 = r7
            r2 = r9
            r4 = r16
            r11 = r5
            r5 = r10
            r12 = r6
            r6 = r20
            decodeByteSegment(r1, r2, r3, r4, r5, r6)     // Catch:{ IllegalArgumentException -> 0x00ed }
            goto L_0x00c7
        L_0x00b2:
            r11 = r5
            r12 = r6
            com.google.zxing.qrcode.decoder.Mode r1 = com.google.zxing.qrcode.decoder.Mode.KANJI     // Catch:{ IllegalArgumentException -> 0x00ed }
            if (r12 != r1) goto L_0x00bc
            decodeKanjiSegment(r7, r9, r3)     // Catch:{ IllegalArgumentException -> 0x00ed }
            goto L_0x00c7
        L_0x00bc:
            com.google.zxing.FormatException r0 = com.google.zxing.FormatException.getFormatInstance()     // Catch:{ IllegalArgumentException -> 0x00ed }
            throw r0     // Catch:{ IllegalArgumentException -> 0x00ed }
        L_0x00c1:
            r11 = r5
            r12 = r6
            r15 = 1
            goto L_0x00c7
        L_0x00c5:
            r11 = r5
            r12 = r6
        L_0x00c7:
            if (r12 != r11) goto L_0x00ea
            com.google.zxing.common.DecoderResult r7 = new com.google.zxing.common.DecoderResult
            java.lang.String r2 = r9.toString()
            boolean r0 = r10.isEmpty()
            if (r0 == 0) goto L_0x00d7
            r3 = 0
            goto L_0x00d8
        L_0x00d7:
            r3 = r10
        L_0x00d8:
            if (r19 != 0) goto L_0x00dc
            r4 = 0
            goto L_0x00e1
        L_0x00dc:
            java.lang.String r0 = r19.toString()
            r4 = r0
        L_0x00e1:
            r0 = r7
            r1 = r17
            r5 = r13
            r6 = r14
            r0.<init>(r1, r2, r3, r4, r5, r6)
            return r7
        L_0x00ea:
            r11 = 1
            goto L_0x001d
        L_0x00ed:
            com.google.zxing.FormatException r0 = com.google.zxing.FormatException.getFormatInstance()
            goto L_0x00f3
        L_0x00f2:
            throw r0
        L_0x00f3:
            goto L_0x00f2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.qrcode.decoder.DecodedBitStreamParser.decode(byte[], com.google.zxing.qrcode.decoder.Version, com.google.zxing.qrcode.decoder.ErrorCorrectionLevel, java.util.Map):com.google.zxing.common.DecoderResult");
    }

    private static void decodeAlphanumericSegment(BitSource bitSource, StringBuilder sb, int i10, boolean z10) {
        while (i10 > 1) {
            if (bitSource.available() >= 11) {
                int readBits = bitSource.readBits(11);
                sb.append(toAlphaNumericChar(readBits / 45));
                sb.append(toAlphaNumericChar(readBits % 45));
                i10 -= 2;
            } else {
                throw FormatException.getFormatInstance();
            }
        }
        if (i10 == 1) {
            if (bitSource.available() >= 6) {
                sb.append(toAlphaNumericChar(bitSource.readBits(6)));
            } else {
                throw FormatException.getFormatInstance();
            }
        }
        if (z10) {
            for (int length = sb.length(); length < sb.length(); length++) {
                if (sb.charAt(length) == '%') {
                    if (length < sb.length() - 1) {
                        int i11 = length + 1;
                        if (sb.charAt(i11) == '%') {
                            sb.deleteCharAt(i11);
                        }
                    }
                    sb.setCharAt(length, 29);
                }
            }
        }
    }

    private static void decodeByteSegment(BitSource bitSource, StringBuilder sb, int i10, CharacterSetECI characterSetECI, Collection<byte[]> collection, Map<DecodeHintType, ?> map) {
        String str;
        if ((i10 << 3) <= bitSource.available()) {
            byte[] bArr = new byte[i10];
            for (int i11 = 0; i11 < i10; i11++) {
                bArr[i11] = (byte) bitSource.readBits(8);
            }
            if (characterSetECI == null) {
                str = StringUtils.guessEncoding(bArr, map);
            } else {
                str = characterSetECI.name();
            }
            try {
                sb.append(new String(bArr, str));
                collection.add(bArr);
            } catch (UnsupportedEncodingException unused) {
                throw FormatException.getFormatInstance();
            }
        } else {
            throw FormatException.getFormatInstance();
        }
    }

    private static void decodeHanziSegment(BitSource bitSource, StringBuilder sb, int i10) {
        int i11;
        if (i10 * 13 <= bitSource.available()) {
            byte[] bArr = new byte[(i10 * 2)];
            int i12 = 0;
            while (i10 > 0) {
                int readBits = bitSource.readBits(13);
                int i13 = (readBits % 96) | ((readBits / 96) << 8);
                if (i13 < 959) {
                    i11 = 41377;
                } else {
                    i11 = 42657;
                }
                int i14 = i13 + i11;
                bArr[i12] = (byte) (i14 >> 8);
                bArr[i12 + 1] = (byte) i14;
                i12 += 2;
                i10--;
            }
            try {
                sb.append(new String(bArr, StringUtils.GB2312));
            } catch (UnsupportedEncodingException unused) {
                throw FormatException.getFormatInstance();
            }
        } else {
            throw FormatException.getFormatInstance();
        }
    }

    private static void decodeKanjiSegment(BitSource bitSource, StringBuilder sb, int i10) {
        int i11;
        if (i10 * 13 <= bitSource.available()) {
            byte[] bArr = new byte[(i10 * 2)];
            int i12 = 0;
            while (i10 > 0) {
                int readBits = bitSource.readBits(13);
                int i13 = (readBits % 192) | ((readBits / 192) << 8);
                if (i13 < 7936) {
                    i11 = 33088;
                } else {
                    i11 = 49472;
                }
                int i14 = i13 + i11;
                bArr[i12] = (byte) (i14 >> 8);
                bArr[i12 + 1] = (byte) i14;
                i12 += 2;
                i10--;
            }
            try {
                sb.append(new String(bArr, StringUtils.SHIFT_JIS));
            } catch (UnsupportedEncodingException unused) {
                throw FormatException.getFormatInstance();
            }
        } else {
            throw FormatException.getFormatInstance();
        }
    }

    private static void decodeNumericSegment(BitSource bitSource, StringBuilder sb, int i10) {
        while (i10 >= 3) {
            if (bitSource.available() >= 10) {
                int readBits = bitSource.readBits(10);
                if (readBits < 1000) {
                    sb.append(toAlphaNumericChar(readBits / 100));
                    sb.append(toAlphaNumericChar((readBits / 10) % 10));
                    sb.append(toAlphaNumericChar(readBits % 10));
                    i10 -= 3;
                } else {
                    throw FormatException.getFormatInstance();
                }
            } else {
                throw FormatException.getFormatInstance();
            }
        }
        if (i10 == 2) {
            if (bitSource.available() >= 7) {
                int readBits2 = bitSource.readBits(7);
                if (readBits2 < 100) {
                    sb.append(toAlphaNumericChar(readBits2 / 10));
                    sb.append(toAlphaNumericChar(readBits2 % 10));
                    return;
                }
                throw FormatException.getFormatInstance();
            }
            throw FormatException.getFormatInstance();
        } else if (i10 != 1) {
        } else {
            if (bitSource.available() >= 4) {
                int readBits3 = bitSource.readBits(4);
                if (readBits3 < 10) {
                    sb.append(toAlphaNumericChar(readBits3));
                    return;
                }
                throw FormatException.getFormatInstance();
            }
            throw FormatException.getFormatInstance();
        }
    }

    private static int parseECIValue(BitSource bitSource) {
        int readBits = bitSource.readBits(8);
        if ((readBits & 128) == 0) {
            return readBits & 127;
        }
        if ((readBits & 192) == 128) {
            return bitSource.readBits(8) | ((readBits & 63) << 8);
        }
        if ((readBits & 224) == 192) {
            return bitSource.readBits(16) | ((readBits & 31) << 16);
        }
        throw FormatException.getFormatInstance();
    }

    private static char toAlphaNumericChar(int i10) {
        char[] cArr = ALPHANUMERIC_CHARS;
        if (i10 < cArr.length) {
            return cArr[i10];
        }
        throw FormatException.getFormatInstance();
    }
}
