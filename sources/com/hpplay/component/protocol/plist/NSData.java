package com.hpplay.component.protocol.plist;

import com.google.common.primitives.UnsignedBytes;
import java.io.File;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.util.Arrays;

public class NSData extends NSObject {
    private final byte[] bytes;

    public NSData(byte[] bArr) {
        this.bytes = bArr;
    }

    public byte[] bytes() {
        return this.bytes;
    }

    public boolean equals(Object obj) {
        if (!obj.getClass().equals(getClass()) || !Arrays.equals(((NSData) obj).bytes, this.bytes)) {
            return false;
        }
        return true;
    }

    public String getBase64EncodedData() {
        return Base64.encodeBytes(this.bytes);
    }

    public void getBytes(ByteBuffer byteBuffer, int i10) {
        byte[] bArr = this.bytes;
        byteBuffer.put(bArr, 0, Math.min(bArr.length, i10));
    }

    public int hashCode() {
        return 335 + Arrays.hashCode(this.bytes);
    }

    public int length() {
        return this.bytes.length;
    }

    public void toASCII(StringBuilder sb, int i10) {
        indent(sb, i10);
        sb.append(ASCIIPropertyListParser.DATA_BEGIN_TOKEN);
        int lastIndexOf = sb.lastIndexOf(NSObject.NEWLINE);
        int i11 = 0;
        while (true) {
            byte[] bArr = this.bytes;
            if (i11 < bArr.length) {
                byte b10 = bArr[i11] & UnsignedBytes.MAX_VALUE;
                if (b10 < 16) {
                    sb.append('0');
                }
                sb.append(Integer.toHexString(b10));
                if (sb.length() - lastIndexOf > 80) {
                    sb.append(NSObject.NEWLINE);
                    lastIndexOf = sb.length();
                } else if ((i11 + 1) % 2 == 0 && i11 != this.bytes.length - 1) {
                    sb.append(' ');
                }
                i11++;
            } else {
                sb.append(ASCIIPropertyListParser.DATA_END_TOKEN);
                return;
            }
        }
    }

    public void toASCIIGnuStep(StringBuilder sb, int i10) {
        toASCII(sb, i10);
    }

    public void toBinary(BinaryPropertyListWriter binaryPropertyListWriter) {
        binaryPropertyListWriter.writeIntHeader(4, this.bytes.length);
        binaryPropertyListWriter.write(this.bytes);
    }

    public void toXML(StringBuilder sb, int i10) {
        indent(sb, i10);
        sb.append("<data>");
        sb.append(NSObject.NEWLINE);
        for (String append : getBase64EncodedData().split("\n")) {
            indent(sb, i10 + 1);
            sb.append(append);
            sb.append(NSObject.NEWLINE);
        }
        indent(sb, i10);
        sb.append("</data>");
    }

    public void getBytes(ByteBuffer byteBuffer, int i10, int i11) {
        byte[] bArr = this.bytes;
        byteBuffer.put(bArr, i10, Math.min(bArr.length, i11));
    }

    public NSData(String str) {
        this.bytes = Base64.decode(str.replaceAll("\\s+", ""), 4);
    }

    public NSData clone() {
        return new NSData((byte[]) this.bytes.clone());
    }

    public NSData(File file) {
        byte[] bArr = new byte[((int) file.length())];
        this.bytes = bArr;
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
        randomAccessFile.read(bArr);
        randomAccessFile.close();
    }
}
