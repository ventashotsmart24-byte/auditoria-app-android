package com.google.zxing.datamatrix.encoder;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;

final class TextEncoder extends C40Encoder {
    public int encodeChar(char c10, StringBuilder sb) {
        if (c10 == ' ') {
            sb.append(3);
            return 1;
        } else if (c10 >= '0' && c10 <= '9') {
            sb.append((char) ((c10 - '0') + 4));
            return 1;
        } else if (c10 >= 'a' && c10 <= 'z') {
            sb.append((char) ((c10 - 'a') + 14));
            return 1;
        } else if (c10 >= 0 && c10 <= 31) {
            sb.append(0);
            sb.append(c10);
            return 2;
        } else if (c10 >= '!' && c10 <= '/') {
            sb.append(1);
            sb.append((char) (c10 - '!'));
            return 2;
        } else if (c10 >= ':' && c10 <= '@') {
            sb.append(1);
            sb.append((char) ((c10 - ASCIIPropertyListParser.DATE_TIME_FIELD_DELIMITER) + 15));
            return 2;
        } else if (c10 >= '[' && c10 <= '_') {
            sb.append(1);
            sb.append((char) ((c10 - '[') + 22));
            return 2;
        } else if (c10 == '`') {
            sb.append(2);
            sb.append((char) (c10 - '`'));
            return 2;
        } else if (c10 >= 'A' && c10 <= 'Z') {
            sb.append(2);
            sb.append((char) ((c10 - 'A') + 1));
            return 2;
        } else if (c10 >= '{' && c10 <= 127) {
            sb.append(2);
            sb.append((char) ((c10 - ASCIIPropertyListParser.DICTIONARY_BEGIN_TOKEN) + 27));
            return 2;
        } else if (c10 >= 128) {
            sb.append("\u0001\u001e");
            return encodeChar((char) (c10 - 128), sb) + 2;
        } else {
            HighLevelEncoder.illegalCharacter(c10);
            return -1;
        }
    }

    public int getEncodingMode() {
        return 2;
    }
}
