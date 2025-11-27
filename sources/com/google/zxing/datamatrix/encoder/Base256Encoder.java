package com.google.zxing.datamatrix.encoder;

import com.hpplay.sdk.source.mdns.xbill.dns.Type;

final class Base256Encoder implements Encoder {
    private static char randomize255State(char c10, int i10) {
        int i11 = c10 + ((i10 * 149) % 255) + 1;
        if (i11 <= 255) {
            return (char) i11;
        }
        return (char) (i11 - 256);
    }

    public void encode(EncoderContext encoderContext) {
        boolean z10;
        StringBuilder sb = new StringBuilder();
        sb.append(0);
        while (true) {
            if (!encoderContext.hasMoreCharacters()) {
                break;
            }
            sb.append(encoderContext.getCurrentChar());
            encoderContext.pos++;
            int lookAheadTest = HighLevelEncoder.lookAheadTest(encoderContext.getMessage(), encoderContext.pos, getEncodingMode());
            if (lookAheadTest != getEncodingMode()) {
                encoderContext.signalEncoderChange(lookAheadTest);
                break;
            }
        }
        int length = sb.length() - 1;
        int codewordCount = encoderContext.getCodewordCount() + length + 1;
        encoderContext.updateSymbolInfo(codewordCount);
        if (encoderContext.getSymbolInfo().getDataCapacity() - codewordCount > 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (encoderContext.hasMoreCharacters() || z10) {
            if (length <= 249) {
                sb.setCharAt(0, (char) length);
            } else if (length <= 1555) {
                sb.setCharAt(0, (char) ((length / 250) + Type.TKEY));
                sb.insert(1, (char) (length % 250));
            } else {
                throw new IllegalStateException("Message length not in valid ranges: " + length);
            }
        }
        int length2 = sb.length();
        for (int i10 = 0; i10 < length2; i10++) {
            encoderContext.writeCodeword(randomize255State(sb.charAt(i10), encoderContext.getCodewordCount() + 1));
        }
    }

    public int getEncodingMode() {
        return 5;
    }
}
