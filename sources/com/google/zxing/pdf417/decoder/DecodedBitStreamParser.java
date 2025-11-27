package com.google.zxing.pdf417.decoder;

import com.google.zxing.FormatException;
import com.google.zxing.common.CharacterSetECI;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.pdf417.PDF417ResultMetadata;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;

final class DecodedBitStreamParser {
    private static final int AL = 28;
    private static final int AS = 27;
    private static final int BEGIN_MACRO_PDF417_CONTROL_BLOCK = 928;
    private static final int BEGIN_MACRO_PDF417_OPTIONAL_FIELD = 923;
    private static final int BYTE_COMPACTION_MODE_LATCH = 901;
    private static final int BYTE_COMPACTION_MODE_LATCH_6 = 924;
    private static final Charset DEFAULT_ENCODING = Charset.forName("ISO-8859-1");
    private static final int ECI_CHARSET = 927;
    private static final int ECI_GENERAL_PURPOSE = 926;
    private static final int ECI_USER_DEFINED = 925;
    private static final BigInteger[] EXP900;
    private static final int LL = 27;
    private static final int MACRO_PDF417_TERMINATOR = 922;
    private static final int MAX_NUMERIC_CODEWORDS = 15;
    private static final char[] MIXED_CHARS = "0123456789&\r\t,:#-.$/+%*=^".toCharArray();
    private static final int ML = 28;
    private static final int MODE_SHIFT_TO_BYTE_COMPACTION_MODE = 913;
    private static final int NUMBER_OF_SEQUENCE_CODEWORDS = 2;
    private static final int NUMERIC_COMPACTION_MODE_LATCH = 902;
    private static final int PAL = 29;
    private static final int PL = 25;
    private static final int PS = 29;
    private static final char[] PUNCT_CHARS = ";<>@[\\]_`~!\r\t,:\n-.$/\"|*()?{}'".toCharArray();
    private static final int TEXT_COMPACTION_MODE_LATCH = 900;

    /* renamed from: com.google.zxing.pdf417.decoder.DecodedBitStreamParser$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$zxing$pdf417$decoder$DecodedBitStreamParser$Mode;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|14) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode[] r0 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$google$zxing$pdf417$decoder$DecodedBitStreamParser$Mode = r0
                com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r1 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.ALPHA     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$google$zxing$pdf417$decoder$DecodedBitStreamParser$Mode     // Catch:{ NoSuchFieldError -> 0x001d }
                com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r1 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.LOWER     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$google$zxing$pdf417$decoder$DecodedBitStreamParser$Mode     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r1 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.MIXED     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$google$zxing$pdf417$decoder$DecodedBitStreamParser$Mode     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r1 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.PUNCT     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$com$google$zxing$pdf417$decoder$DecodedBitStreamParser$Mode     // Catch:{ NoSuchFieldError -> 0x003e }
                com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r1 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.ALPHA_SHIFT     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$com$google$zxing$pdf417$decoder$DecodedBitStreamParser$Mode     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r1 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.PUNCT_SHIFT     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.pdf417.decoder.DecodedBitStreamParser.AnonymousClass1.<clinit>():void");
        }
    }

    public enum Mode {
        ALPHA,
        LOWER,
        MIXED,
        PUNCT,
        ALPHA_SHIFT,
        PUNCT_SHIFT
    }

    static {
        BigInteger[] bigIntegerArr = new BigInteger[16];
        EXP900 = bigIntegerArr;
        bigIntegerArr[0] = BigInteger.ONE;
        BigInteger valueOf = BigInteger.valueOf(900);
        bigIntegerArr[1] = valueOf;
        int i10 = 2;
        while (true) {
            BigInteger[] bigIntegerArr2 = EXP900;
            if (i10 < bigIntegerArr2.length) {
                bigIntegerArr2[i10] = bigIntegerArr2[i10 - 1].multiply(valueOf);
                i10++;
            } else {
                return;
            }
        }
    }

    private DecodedBitStreamParser() {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0053, code lost:
        r7 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0054, code lost:
        if (r7 >= 6) goto L_0x0068;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0056, code lost:
        r1.write((byte) ((int) (r18 >> ((5 - r7) * 8))));
        r7 = r7 + 1;
        r2 = MACRO_PDF417_TERMINATOR;
        r3 = BEGIN_MACRO_PDF417_OPTIONAL_FIELD;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int byteCompaction(int r20, int[] r21, java.nio.charset.Charset r22, int r23, java.lang.StringBuilder r24) {
        /*
            r0 = r20
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream
            r1.<init>()
            r2 = 922(0x39a, float:1.292E-42)
            r3 = 923(0x39b, float:1.293E-42)
            r4 = 928(0x3a0, float:1.3E-42)
            r5 = 902(0x386, float:1.264E-42)
            r6 = 900(0x384, double:4.447E-321)
            r8 = 6
            r9 = 924(0x39c, float:1.295E-42)
            r10 = 900(0x384, float:1.261E-42)
            r14 = 0
            r15 = 901(0x385, float:1.263E-42)
            if (r0 != r15) goto L_0x0099
            int[] r0 = new int[r8]
            int r16 = r23 + 1
            r17 = r21[r23]
            r11 = r16
            r12 = r17
            r16 = 0
        L_0x0027:
            r17 = 0
            r18 = 0
        L_0x002b:
            r13 = r21[r14]
            if (r11 >= r13) goto L_0x0083
            if (r16 != 0) goto L_0x0083
            int r13 = r17 + 1
            r0[r17] = r12
            long r18 = r18 * r6
            long r6 = (long) r12
            long r18 = r18 + r6
            int r6 = r11 + 1
            r12 = r21[r11]
            if (r12 == r10) goto L_0x0076
            if (r12 == r15) goto L_0x0076
            if (r12 == r5) goto L_0x0076
            if (r12 == r9) goto L_0x0076
            if (r12 == r4) goto L_0x0076
            if (r12 == r3) goto L_0x0076
            if (r12 != r2) goto L_0x004d
            goto L_0x0076
        L_0x004d:
            int r7 = r13 % 5
            if (r7 != 0) goto L_0x006c
            if (r13 <= 0) goto L_0x006c
            r7 = 0
        L_0x0054:
            if (r7 >= r8) goto L_0x0068
            int r11 = 5 - r7
            int r11 = r11 * 8
            long r2 = r18 >> r11
            int r3 = (int) r2
            byte r2 = (byte) r3
            r1.write(r2)
            int r7 = r7 + 1
            r2 = 922(0x39a, float:1.292E-42)
            r3 = 923(0x39b, float:1.293E-42)
            goto L_0x0054
        L_0x0068:
            r11 = r6
            r6 = 900(0x384, double:4.447E-321)
            goto L_0x0027
        L_0x006c:
            r11 = r6
            r17 = r13
            r2 = 922(0x39a, float:1.292E-42)
            r3 = 923(0x39b, float:1.293E-42)
            r6 = 900(0x384, double:4.447E-321)
            goto L_0x002b
        L_0x0076:
            int r11 = r6 + -1
            r17 = r13
            r2 = 922(0x39a, float:1.292E-42)
            r3 = 923(0x39b, float:1.293E-42)
            r6 = 900(0x384, double:4.447E-321)
            r16 = 1
            goto L_0x002b
        L_0x0083:
            if (r11 != r13) goto L_0x008c
            if (r12 >= r10) goto L_0x008c
            int r2 = r17 + 1
            r0[r17] = r12
            goto L_0x008e
        L_0x008c:
            r2 = r17
        L_0x008e:
            if (r14 >= r2) goto L_0x00ff
            r3 = r0[r14]
            byte r3 = (byte) r3
            r1.write(r3)
            int r14 = r14 + 1
            goto L_0x008e
        L_0x0099:
            if (r0 != r9) goto L_0x00fd
            r0 = r23
            r2 = 0
            r3 = 0
            r6 = 0
        L_0x00a1:
            r11 = r21[r14]
            if (r0 >= r11) goto L_0x00fb
            if (r2 != 0) goto L_0x00fb
            int r11 = r0 + 1
            r0 = r21[r0]
            if (r0 >= r10) goto L_0x00bb
            int r3 = r3 + 1
            r12 = 900(0x384, double:4.447E-321)
            long r6 = r6 * r12
            long r12 = (long) r0
            long r6 = r6 + r12
            r0 = r11
            r12 = 923(0x39b, float:1.293E-42)
            r13 = 922(0x39a, float:1.292E-42)
            goto L_0x00d8
        L_0x00bb:
            if (r0 == r10) goto L_0x00d0
            if (r0 == r15) goto L_0x00d0
            if (r0 == r5) goto L_0x00d0
            if (r0 == r9) goto L_0x00d0
            if (r0 == r4) goto L_0x00d0
            r12 = 923(0x39b, float:1.293E-42)
            r13 = 922(0x39a, float:1.292E-42)
            if (r0 == r12) goto L_0x00d4
            if (r0 != r13) goto L_0x00ce
            goto L_0x00d4
        L_0x00ce:
            r0 = r11
            goto L_0x00d8
        L_0x00d0:
            r12 = 923(0x39b, float:1.293E-42)
            r13 = 922(0x39a, float:1.292E-42)
        L_0x00d4:
            int r11 = r11 + -1
            r0 = r11
            r2 = 1
        L_0x00d8:
            int r11 = r3 % 5
            if (r11 != 0) goto L_0x00f6
            if (r3 <= 0) goto L_0x00f6
            r3 = 0
        L_0x00df:
            if (r3 >= r8) goto L_0x00f3
            int r11 = 5 - r3
            int r11 = r11 * 8
            long r4 = r6 >> r11
            int r5 = (int) r4
            byte r4 = (byte) r5
            r1.write(r4)
            int r3 = r3 + 1
            r4 = 928(0x3a0, float:1.3E-42)
            r5 = 902(0x386, float:1.264E-42)
            goto L_0x00df
        L_0x00f3:
            r3 = 0
            r6 = 0
        L_0x00f6:
            r4 = 928(0x3a0, float:1.3E-42)
            r5 = 902(0x386, float:1.264E-42)
            goto L_0x00a1
        L_0x00fb:
            r11 = r0
            goto L_0x00ff
        L_0x00fd:
            r11 = r23
        L_0x00ff:
            java.lang.String r0 = new java.lang.String
            byte[] r1 = r1.toByteArray()
            r2 = r22
            r0.<init>(r1, r2)
            r1 = r24
            r1.append(r0)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.pdf417.decoder.DecodedBitStreamParser.byteCompaction(int, int[], java.nio.charset.Charset, int, java.lang.StringBuilder):int");
    }

    public static DecoderResult decode(int[] iArr, String str) {
        int i10;
        StringBuilder sb = new StringBuilder(iArr.length << 1);
        Charset charset = DEFAULT_ENCODING;
        int i11 = iArr[1];
        PDF417ResultMetadata pDF417ResultMetadata = new PDF417ResultMetadata();
        int i12 = 2;
        while (i12 < iArr[0]) {
            if (i11 != MODE_SHIFT_TO_BYTE_COMPACTION_MODE) {
                switch (i11) {
                    case 900:
                        i10 = textCompaction(iArr, i12, sb);
                        break;
                    case 901:
                        i10 = byteCompaction(i11, iArr, charset, i12, sb);
                        break;
                    case 902:
                        i10 = numericCompaction(iArr, i12, sb);
                        break;
                    default:
                        switch (i11) {
                            case MACRO_PDF417_TERMINATOR /*922*/:
                            case BEGIN_MACRO_PDF417_OPTIONAL_FIELD /*923*/:
                                throw FormatException.getFormatInstance();
                            case BYTE_COMPACTION_MODE_LATCH_6 /*924*/:
                                break;
                            case ECI_USER_DEFINED /*925*/:
                                i10 = i12 + 1;
                                break;
                            case ECI_GENERAL_PURPOSE /*926*/:
                                i10 = i12 + 2;
                                break;
                            case ECI_CHARSET /*927*/:
                                i10 = i12 + 1;
                                charset = Charset.forName(CharacterSetECI.getCharacterSetECIByValue(iArr[i12]).name());
                                break;
                            case 928:
                                i10 = decodeMacroBlock(iArr, i12, pDF417ResultMetadata);
                                break;
                            default:
                                i10 = textCompaction(iArr, i12 - 1, sb);
                                break;
                        }
                        i10 = byteCompaction(i11, iArr, charset, i12, sb);
                        break;
                }
            } else {
                i10 = i12 + 1;
                sb.append((char) iArr[i12]);
            }
            if (i10 < iArr.length) {
                i12 = i10 + 1;
                i11 = iArr[i10];
            } else {
                throw FormatException.getFormatInstance();
            }
        }
        if (sb.length() != 0) {
            DecoderResult decoderResult = new DecoderResult((byte[]) null, sb.toString(), (List<byte[]>) null, str);
            decoderResult.setOther(pDF417ResultMetadata);
            return decoderResult;
        }
        throw FormatException.getFormatInstance();
    }

    private static String decodeBase900toBase10(int[] iArr, int i10) {
        BigInteger bigInteger = BigInteger.ZERO;
        for (int i11 = 0; i11 < i10; i11++) {
            bigInteger = bigInteger.add(EXP900[(i10 - i11) - 1].multiply(BigInteger.valueOf((long) iArr[i11])));
        }
        String bigInteger2 = bigInteger.toString();
        if (bigInteger2.charAt(0) == '1') {
            return bigInteger2.substring(1);
        }
        throw FormatException.getFormatInstance();
    }

    private static int decodeMacroBlock(int[] iArr, int i10, PDF417ResultMetadata pDF417ResultMetadata) {
        if (i10 + 2 <= iArr[0]) {
            int[] iArr2 = new int[2];
            int i11 = 0;
            while (i11 < 2) {
                iArr2[i11] = iArr[i10];
                i11++;
                i10++;
            }
            pDF417ResultMetadata.setSegmentIndex(Integer.parseInt(decodeBase900toBase10(iArr2, 2)));
            StringBuilder sb = new StringBuilder();
            int textCompaction = textCompaction(iArr, i10, sb);
            pDF417ResultMetadata.setFileId(sb.toString());
            int i12 = iArr[textCompaction];
            if (i12 == BEGIN_MACRO_PDF417_OPTIONAL_FIELD) {
                int i13 = textCompaction + 1;
                int[] iArr3 = new int[(iArr[0] - i13)];
                boolean z10 = false;
                int i14 = 0;
                while (i13 < iArr[0] && !z10) {
                    int i15 = i13 + 1;
                    int i16 = iArr[i13];
                    if (i16 < 900) {
                        iArr3[i14] = i16;
                        i13 = i15;
                        i14++;
                    } else if (i16 == MACRO_PDF417_TERMINATOR) {
                        pDF417ResultMetadata.setLastSegment(true);
                        i13 = i15 + 1;
                        z10 = true;
                    } else {
                        throw FormatException.getFormatInstance();
                    }
                }
                pDF417ResultMetadata.setOptionalData(Arrays.copyOf(iArr3, i14));
                return i13;
            } else if (i12 != MACRO_PDF417_TERMINATOR) {
                return textCompaction;
            } else {
                pDF417ResultMetadata.setLastSegment(true);
                return textCompaction + 1;
            }
        } else {
            throw FormatException.getFormatInstance();
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0049, code lost:
        r1 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0055, code lost:
        r1 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00b6, code lost:
        r10 = 0;
        r15 = r3;
        r3 = r1;
        r1 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x00d7, code lost:
        r10 = (char) r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x00f9, code lost:
        if (r10 == 0) goto L_0x00fe;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x00fb, code lost:
        r0.append(r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x00fe, code lost:
        r5 = r5 + 1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void decodeTextCompaction(int[] r16, int[] r17, int r18, java.lang.StringBuilder r19) {
        /*
            r0 = r19
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r1 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.ALPHA
            r2 = 0
            r4 = r18
            r3 = r1
            r5 = 0
        L_0x0009:
            if (r5 >= r4) goto L_0x0102
            r6 = r16[r5]
            int[] r7 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.AnonymousClass1.$SwitchMap$com$google$zxing$pdf417$decoder$DecodedBitStreamParser$Mode
            int r8 = r1.ordinal()
            r7 = r7[r8]
            r8 = 28
            r9 = 27
            r10 = 32
            r11 = 913(0x391, float:1.28E-42)
            r12 = 900(0x384, float:1.261E-42)
            r13 = 29
            r14 = 26
            switch(r7) {
                case 1: goto L_0x00d3;
                case 2: goto L_0x00aa;
                case 3: goto L_0x0076;
                case 4: goto L_0x0058;
                case 5: goto L_0x0044;
                case 6: goto L_0x0028;
                default: goto L_0x0026;
            }
        L_0x0026:
            goto L_0x00f8
        L_0x0028:
            if (r6 >= r13) goto L_0x002f
            char[] r1 = PUNCT_CHARS
            char r10 = r1[r6]
            goto L_0x0049
        L_0x002f:
            if (r6 != r13) goto L_0x0035
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r1 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.ALPHA
            goto L_0x00f8
        L_0x0035:
            if (r6 != r11) goto L_0x003e
            r1 = r17[r5]
            char r1 = (char) r1
            r0.append(r1)
            goto L_0x0055
        L_0x003e:
            if (r6 != r12) goto L_0x0055
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r1 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.ALPHA
            goto L_0x00f8
        L_0x0044:
            if (r6 >= r14) goto L_0x004c
            int r6 = r6 + 65
            char r10 = (char) r6
        L_0x0049:
            r1 = r3
            goto L_0x00f9
        L_0x004c:
            if (r6 != r14) goto L_0x004f
            goto L_0x0049
        L_0x004f:
            if (r6 != r12) goto L_0x0055
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r1 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.ALPHA
            goto L_0x00f8
        L_0x0055:
            r1 = r3
            goto L_0x00f8
        L_0x0058:
            if (r6 >= r13) goto L_0x0060
            char[] r7 = PUNCT_CHARS
            char r10 = r7[r6]
            goto L_0x00f9
        L_0x0060:
            if (r6 != r13) goto L_0x0066
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r1 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.ALPHA
            goto L_0x00f8
        L_0x0066:
            if (r6 != r11) goto L_0x0070
            r6 = r17[r5]
            char r6 = (char) r6
            r0.append(r6)
            goto L_0x00f8
        L_0x0070:
            if (r6 != r12) goto L_0x00f8
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r1 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.ALPHA
            goto L_0x00f8
        L_0x0076:
            r7 = 25
            if (r6 >= r7) goto L_0x0080
            char[] r7 = MIXED_CHARS
            char r10 = r7[r6]
            goto L_0x00f9
        L_0x0080:
            if (r6 != r7) goto L_0x0086
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r1 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.PUNCT
            goto L_0x00f8
        L_0x0086:
            if (r6 != r14) goto L_0x008a
            goto L_0x00f9
        L_0x008a:
            if (r6 != r9) goto L_0x0090
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r1 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.LOWER
            goto L_0x00f8
        L_0x0090:
            if (r6 != r8) goto L_0x0096
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r1 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.ALPHA
            goto L_0x00f8
        L_0x0096:
            if (r6 != r13) goto L_0x009b
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r3 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.PUNCT_SHIFT
            goto L_0x00b6
        L_0x009b:
            if (r6 != r11) goto L_0x00a5
            r6 = r17[r5]
            char r6 = (char) r6
            r0.append(r6)
            goto L_0x00f8
        L_0x00a5:
            if (r6 != r12) goto L_0x00f8
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r1 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.ALPHA
            goto L_0x00f8
        L_0x00aa:
            if (r6 >= r14) goto L_0x00af
            int r6 = r6 + 97
            goto L_0x00d7
        L_0x00af:
            if (r6 != r14) goto L_0x00b2
            goto L_0x00f9
        L_0x00b2:
            if (r6 != r9) goto L_0x00bb
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r3 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.ALPHA_SHIFT
        L_0x00b6:
            r10 = 0
            r15 = r3
            r3 = r1
            r1 = r15
            goto L_0x00f9
        L_0x00bb:
            if (r6 != r8) goto L_0x00c0
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r1 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.MIXED
            goto L_0x00f8
        L_0x00c0:
            if (r6 != r13) goto L_0x00c5
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r3 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.PUNCT_SHIFT
            goto L_0x00b6
        L_0x00c5:
            if (r6 != r11) goto L_0x00ce
            r6 = r17[r5]
            char r6 = (char) r6
            r0.append(r6)
            goto L_0x00f8
        L_0x00ce:
            if (r6 != r12) goto L_0x00f8
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r1 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.ALPHA
            goto L_0x00f8
        L_0x00d3:
            if (r6 >= r14) goto L_0x00d9
            int r6 = r6 + 65
        L_0x00d7:
            char r10 = (char) r6
            goto L_0x00f9
        L_0x00d9:
            if (r6 != r14) goto L_0x00dc
            goto L_0x00f9
        L_0x00dc:
            if (r6 != r9) goto L_0x00e1
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r1 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.LOWER
            goto L_0x00f8
        L_0x00e1:
            if (r6 != r8) goto L_0x00e6
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r1 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.MIXED
            goto L_0x00f8
        L_0x00e6:
            if (r6 != r13) goto L_0x00eb
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r3 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.PUNCT_SHIFT
            goto L_0x00b6
        L_0x00eb:
            if (r6 != r11) goto L_0x00f4
            r6 = r17[r5]
            char r6 = (char) r6
            r0.append(r6)
            goto L_0x00f8
        L_0x00f4:
            if (r6 != r12) goto L_0x00f8
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r1 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.ALPHA
        L_0x00f8:
            r10 = 0
        L_0x00f9:
            if (r10 == 0) goto L_0x00fe
            r0.append(r10)
        L_0x00fe:
            int r5 = r5 + 1
            goto L_0x0009
        L_0x0102:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.pdf417.decoder.DecodedBitStreamParser.decodeTextCompaction(int[], int[], int, java.lang.StringBuilder):void");
    }

    private static int numericCompaction(int[] iArr, int i10, StringBuilder sb) {
        int[] iArr2 = new int[15];
        boolean z10 = false;
        int i11 = 0;
        while (true) {
            int i12 = iArr[0];
            if (i10 >= i12 || z10) {
                return i10;
            }
            int i13 = i10 + 1;
            int i14 = iArr[i10];
            if (i13 == i12) {
                z10 = true;
            }
            if (i14 < 900) {
                iArr2[i11] = i14;
                i11++;
            } else if (i14 == 900 || i14 == 901 || i14 == BYTE_COMPACTION_MODE_LATCH_6 || i14 == 928 || i14 == BEGIN_MACRO_PDF417_OPTIONAL_FIELD || i14 == MACRO_PDF417_TERMINATOR) {
                i13--;
                z10 = true;
            }
            if ((i11 % 15 == 0 || i14 == 902 || z10) && i11 > 0) {
                sb.append(decodeBase900toBase10(iArr2, i11));
                i11 = 0;
            }
            i10 = i13;
        }
        return i10;
    }

    private static int textCompaction(int[] iArr, int i10, StringBuilder sb) {
        int i11 = iArr[0];
        int[] iArr2 = new int[((i11 - i10) << 1)];
        int[] iArr3 = new int[((i11 - i10) << 1)];
        boolean z10 = false;
        int i12 = 0;
        while (i10 < iArr[0] && !z10) {
            int i13 = i10 + 1;
            int i14 = iArr[i10];
            if (i14 < 900) {
                iArr2[i12] = i14 / 30;
                iArr2[i12 + 1] = i14 % 30;
                i12 += 2;
            } else if (i14 != MODE_SHIFT_TO_BYTE_COMPACTION_MODE) {
                if (i14 != 928) {
                    switch (i14) {
                        case 900:
                            iArr2[i12] = 900;
                            i12++;
                            break;
                        case 901:
                        case 902:
                            break;
                        default:
                            switch (i14) {
                                case MACRO_PDF417_TERMINATOR /*922*/:
                                case BEGIN_MACRO_PDF417_OPTIONAL_FIELD /*923*/:
                                case BYTE_COMPACTION_MODE_LATCH_6 /*924*/:
                                    break;
                            }
                    }
                }
                i10 = i13 - 1;
                z10 = true;
            } else {
                iArr2[i12] = MODE_SHIFT_TO_BYTE_COMPACTION_MODE;
                i10 = i13 + 1;
                iArr3[i12] = iArr[i13];
                i12++;
            }
            i10 = i13;
        }
        decodeTextCompaction(iArr2, iArr3, i12, sb);
        return i10;
    }
}
