package com.hpplay.sdk.source.mdns.xbill.dns;

import com.google.common.primitives.UnsignedBytes;
import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.io.PrintStream;
import java.io.Serializable;
import java.text.DecimalFormat;

public class Name implements Serializable, Comparable {
    private static final int LABEL_COMPRESSION = 192;
    private static final int LABEL_MASK = 192;
    private static final int LABEL_NORMAL = 0;
    private static final int MAXLABEL = 63;
    private static final int MAXLABELS = 128;
    private static final int MAXNAME = 255;
    private static final int MAXOFFSETS = 7;
    private static final DecimalFormat byteFormat;
    public static final Name empty;
    private static final byte[] emptyLabel = {0};
    private static final byte[] lowercase = new byte[256];
    public static final Name root;
    private static final long serialVersionUID = -7257019940971525644L;
    private static final Name wild;
    private static final byte[] wildLabel = {1, 42};
    private int hashcode;
    private byte[] name;
    private long offsets;

    static {
        DecimalFormat decimalFormat = new DecimalFormat();
        byteFormat = decimalFormat;
        decimalFormat.setMinimumIntegerDigits(3);
        int i10 = 0;
        while (true) {
            byte[] bArr = lowercase;
            if (i10 < bArr.length) {
                if (i10 < 65 || i10 > 90) {
                    bArr[i10] = (byte) i10;
                } else {
                    bArr[i10] = (byte) ((i10 - 65) + 97);
                }
                i10++;
            } else {
                Name name2 = new Name();
                root = name2;
                name2.appendSafe(emptyLabel, 0, 1);
                Name name3 = new Name();
                empty = name3;
                name3.name = new byte[0];
                Name name4 = new Name();
                wild = name4;
                name4.appendSafe(wildLabel, 0, 1);
                return;
            }
        }
    }

    private Name() {
    }

    private final void append(byte[] bArr, int i10, int i11) {
        int i12;
        byte[] bArr2 = this.name;
        if (bArr2 == null) {
            i12 = 0;
        } else {
            i12 = bArr2.length - offset(0);
        }
        int i13 = i10;
        int i14 = 0;
        int i15 = 0;
        while (i14 < i11) {
            byte b10 = bArr[i13];
            if (b10 <= 63) {
                int i16 = b10 + 1;
                i13 += i16;
                i15 += i16;
                i14++;
            } else {
                throw new IllegalStateException("invalid label");
            }
        }
        int i17 = i12 + i15;
        if (i17 <= 255) {
            int i18 = getlabels();
            int i19 = i18 + i11;
            if (i19 <= 128) {
                byte[] bArr3 = new byte[i17];
                if (i12 != 0) {
                    System.arraycopy(this.name, offset(0), bArr3, 0, i12);
                }
                System.arraycopy(bArr, i10, bArr3, i12, i15);
                this.name = bArr3;
                for (int i20 = 0; i20 < i11; i20++) {
                    setoffset(i18 + i20, i12);
                    i12 += bArr3[i12] + 1;
                }
                setlabels(i19);
                return;
            }
            throw new IllegalStateException("too many labels");
        }
        throw new Exception();
    }

    private final void appendFromString(String str, byte[] bArr, int i10, int i11) {
        try {
            append(bArr, i10, i11);
        } catch (Exception unused) {
            throw parseException(str, "Name too long");
        }
    }

    private final void appendSafe(byte[] bArr, int i10, int i11) {
        try {
            append(bArr, i10, i11);
        } catch (Exception unused) {
        }
    }

    private String byteString(byte[] bArr, int i10) {
        StringBuffer stringBuffer = new StringBuffer();
        int i11 = i10 + 1;
        byte b10 = bArr[i10];
        for (int i12 = i11; i12 < i11 + b10; i12++) {
            byte b11 = bArr[i12] & UnsignedBytes.MAX_VALUE;
            if (b11 <= 32 || b11 >= Byte.MAX_VALUE) {
                stringBuffer.append(ASCIIPropertyListParser.QUOTEDSTRING_ESCAPE_TOKEN);
                stringBuffer.append(byteFormat.format((long) b11));
            } else if (b11 == 34 || b11 == 40 || b11 == 41 || b11 == 46 || b11 == 59 || b11 == 92 || b11 == 64 || b11 == 36) {
                stringBuffer.append(ASCIIPropertyListParser.QUOTEDSTRING_ESCAPE_TOKEN);
                stringBuffer.append((char) b11);
            } else {
                stringBuffer.append((char) b11);
            }
        }
        return stringBuffer.toString();
    }

    public static Name concatenate(Name name2, Name name3) {
        if (name2.isAbsolute()) {
            return name2;
        }
        Name name4 = new Name();
        copy(name2, name4);
        name4.append(name3.name, name3.offset(0), name3.getlabels());
        return name4;
    }

    private static final void copy(Name name2, Name name3) {
        int i10 = 0;
        if (name2.offset(0) == 0) {
            name3.name = name2.name;
            name3.offsets = name2.offsets;
            return;
        }
        int offset = name2.offset(0);
        int length = name2.name.length - offset;
        int labels = name2.labels();
        byte[] bArr = new byte[length];
        name3.name = bArr;
        System.arraycopy(name2.name, offset, bArr, 0, length);
        while (i10 < labels && i10 < 7) {
            name3.setoffset(i10, name2.offset(i10) - offset);
            i10++;
        }
        name3.setlabels(labels);
    }

    private final boolean equals(byte[] bArr, int i10) {
        int labels = labels();
        int offset = offset(0);
        int i11 = 0;
        while (i11 < labels) {
            byte b10 = this.name[offset];
            if (b10 != bArr[i10]) {
                return false;
            }
            offset++;
            i10++;
            if (b10 <= 63) {
                int i12 = 0;
                while (i12 < b10) {
                    byte[] bArr2 = lowercase;
                    int i13 = offset + 1;
                    int i14 = i10 + 1;
                    if (bArr2[this.name[offset] & UnsignedBytes.MAX_VALUE] != bArr2[bArr[i10] & UnsignedBytes.MAX_VALUE]) {
                        return false;
                    }
                    i12++;
                    i10 = i14;
                    offset = i13;
                }
                i11++;
            } else {
                throw new IllegalStateException("invalid label");
            }
        }
        return true;
    }

    public static Name fromConstantString(String str) {
        try {
            return fromString(str, (Name) null);
        } catch (Exception unused) {
            throw new IllegalArgumentException("Invalid name '" + str + "'");
        }
    }

    public static Name fromString(String str, Name name2) {
        if (!str.equals("@") || name2 == null) {
            return str.equals(".") ? root : new Name(str, name2);
        }
        return name2;
    }

    private final int getlabels() {
        return (int) (this.offsets & 255);
    }

    private final int offset(int i10) {
        if (i10 == 0 && getlabels() == 0) {
            return 0;
        }
        if (i10 < 0 || i10 >= getlabels()) {
            throw new IllegalArgumentException("label out of range");
        } else if (i10 < 7) {
            return ((int) (this.offsets >>> ((7 - i10) * 8))) & 255;
        } else {
            int offset = offset(6);
            for (int i11 = 6; i11 < i10; i11++) {
                offset += this.name[offset] + 1;
            }
            return offset;
        }
    }

    private static Exception parseException(String str, String str2) {
        return new Exception("'" + str + "': " + str2);
    }

    private final void setlabels(int i10) {
        this.offsets = (this.offsets & -256) | ((long) i10);
    }

    private final void setoffset(int i10, int i11) {
        if (i10 < 7) {
            int i12 = (7 - i10) * 8;
            this.offsets = (((long) i11) << i12) | (this.offsets & ((255 << i12) ^ -1));
        }
    }

    public Name canonicalize() {
        boolean z10;
        int i10 = 0;
        int i11 = 0;
        while (true) {
            byte[] bArr = this.name;
            if (i11 >= bArr.length) {
                z10 = true;
                break;
            }
            byte[] bArr2 = lowercase;
            byte b10 = bArr[i11];
            if (bArr2[b10 & UnsignedBytes.MAX_VALUE] != b10) {
                z10 = false;
                break;
            }
            i11++;
        }
        if (z10) {
            return this;
        }
        Name name2 = new Name();
        name2.appendSafe(this.name, offset(0), getlabels());
        while (true) {
            byte[] bArr3 = name2.name;
            if (i10 >= bArr3.length) {
                return name2;
            }
            bArr3[i10] = lowercase[bArr3[i10] & UnsignedBytes.MAX_VALUE];
            i10++;
        }
    }

    /* JADX WARNING: type inference failed for: r18v0, types: [java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int compareTo(java.lang.Object r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            com.hpplay.sdk.source.mdns.xbill.dns.Name r1 = (com.hpplay.sdk.source.mdns.xbill.dns.Name) r1
            r2 = 0
            if (r0 != r1) goto L_0x000a
            return r2
        L_0x000a:
            int r3 = r17.labels()
            int r4 = r1.labels()
            if (r3 <= r4) goto L_0x0016
            r5 = r4
            goto L_0x0017
        L_0x0016:
            r5 = r3
        L_0x0017:
            r6 = 1
            r7 = 1
        L_0x0019:
            if (r7 > r5) goto L_0x005b
            int r8 = r3 - r7
            int r8 = r0.offset(r8)
            int r9 = r4 - r7
            int r9 = r1.offset(r9)
            byte[] r10 = r0.name
            byte r10 = r10[r8]
            byte[] r11 = r1.name
            byte r11 = r11[r9]
            r12 = 0
        L_0x0030:
            if (r12 >= r10) goto L_0x0054
            if (r12 >= r11) goto L_0x0054
            byte[] r13 = lowercase
            byte[] r14 = r0.name
            int r15 = r12 + r8
            int r15 = r15 + r6
            byte r14 = r14[r15]
            r14 = r14 & 255(0xff, float:3.57E-43)
            byte r14 = r13[r14]
            byte[] r15 = r1.name
            int r16 = r12 + r9
            int r16 = r16 + 1
            byte r15 = r15[r16]
            r15 = r15 & 255(0xff, float:3.57E-43)
            byte r13 = r13[r15]
            int r14 = r14 - r13
            if (r14 == 0) goto L_0x0051
            return r14
        L_0x0051:
            int r12 = r12 + 1
            goto L_0x0030
        L_0x0054:
            if (r10 == r11) goto L_0x0058
            int r10 = r10 - r11
            return r10
        L_0x0058:
            int r7 = r7 + 1
            goto L_0x0019
        L_0x005b:
            int r3 = r3 - r4
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hpplay.sdk.source.mdns.xbill.dns.Name.compareTo(java.lang.Object):int");
    }

    public Name fromDNAME(DNAMERecord dNAMERecord) {
        Name name2 = dNAMERecord.getName();
        Name target = dNAMERecord.getTarget();
        if (!subdomain(name2)) {
            return null;
        }
        int labels = labels() - name2.labels();
        int length = length() - name2.length();
        int i10 = 0;
        int offset = offset(0);
        int labels2 = target.labels();
        short length2 = target.length();
        int i11 = length + length2;
        if (i11 <= 255) {
            Name name3 = new Name();
            int i12 = labels + labels2;
            name3.setlabels(i12);
            byte[] bArr = new byte[i11];
            name3.name = bArr;
            System.arraycopy(this.name, offset, bArr, 0, length);
            System.arraycopy(target.name, 0, name3.name, length, length2);
            int i13 = 0;
            while (i10 < 7 && i10 < i12) {
                name3.setoffset(i10, i13);
                i13 += name3.name[i13] + 1;
                i10++;
            }
            return name3;
        }
        throw new Exception();
    }

    public byte[] getLabel(int i10) {
        int offset = offset(i10);
        byte[] bArr = this.name;
        int i11 = (byte) (bArr[offset] + 1);
        byte[] bArr2 = new byte[i11];
        System.arraycopy(bArr, offset, bArr2, 0, i11);
        return bArr2;
    }

    public String getLabelString(int i10) {
        return byteString(this.name, offset(i10));
    }

    public int hashCode() {
        int i10 = this.hashcode;
        if (i10 != 0) {
            return i10;
        }
        int i11 = 0;
        int offset = offset(0);
        while (true) {
            byte[] bArr = this.name;
            if (offset < bArr.length) {
                i11 += (i11 << 3) + lowercase[bArr[offset] & UnsignedBytes.MAX_VALUE];
                offset++;
            } else {
                this.hashcode = i11;
                return i11;
            }
        }
    }

    public boolean isAbsolute() {
        int labels = labels();
        if (labels != 0 && this.name[offset(labels - 1)] == 0) {
            return true;
        }
        return false;
    }

    public boolean isWild() {
        if (labels() == 0) {
            return false;
        }
        byte[] bArr = this.name;
        if (bArr[0] == 1 && bArr[1] == 42) {
            return true;
        }
        return false;
    }

    public int labels() {
        return getlabels();
    }

    public short length() {
        if (getlabels() == 0) {
            return 0;
        }
        return (short) (this.name.length - offset(0));
    }

    public Name relativize(Name name2) {
        if (name2 == null || !subdomain(name2)) {
            return this;
        }
        Name name3 = new Name();
        copy(this, name3);
        int length = length() - name2.length();
        name3.setlabels(name3.labels() - name2.labels());
        name3.name = new byte[length];
        System.arraycopy(this.name, offset(0), name3.name, 0, length);
        return name3;
    }

    public boolean subdomain(Name name2) {
        int labels = labels();
        int labels2 = name2.labels();
        if (labels2 > labels) {
            return false;
        }
        if (labels2 == labels) {
            return equals(name2);
        }
        return name2.equals(this.name, offset(labels - labels2));
    }

    public String toString(boolean z10) {
        int labels = labels();
        if (labels == 0) {
            return "@";
        }
        int i10 = 0;
        if (labels == 1 && this.name[offset(0)] == 0) {
            return ".";
        }
        StringBuffer stringBuffer = new StringBuffer();
        int offset = offset(0);
        while (true) {
            if (i10 >= labels) {
                break;
            }
            byte b10 = this.name[offset];
            if (b10 > 63) {
                throw new IllegalStateException("invalid label");
            } else if (b10 != 0) {
                if (i10 > 0) {
                    stringBuffer.append('.');
                }
                stringBuffer.append(byteString(this.name, offset));
                offset += b10 + 1;
                i10++;
            } else if (!z10) {
                stringBuffer.append('.');
            }
        }
        return stringBuffer.toString();
    }

    public void toWire(DNSOutput dNSOutput, Compression compression) {
        Name name2;
        if (isAbsolute()) {
            int labels = labels();
            for (int i10 = 0; i10 < labels - 1; i10++) {
                if (i10 == 0) {
                    name2 = this;
                } else {
                    name2 = new Name(this, i10);
                }
                int i11 = compression != null ? compression.get(name2) : -1;
                if (i11 >= 0) {
                    dNSOutput.writeU16(49152 | i11);
                    return;
                }
                if (compression != null) {
                    compression.add(dNSOutput.current(), name2);
                }
                int offset = offset(i10);
                byte[] bArr = this.name;
                dNSOutput.writeByteArray(bArr, offset, bArr[offset] + 1);
            }
            dNSOutput.writeU8(0);
            return;
        }
        throw new IllegalArgumentException("toWire() called on non-absolute name");
    }

    public void toWireCanonical(DNSOutput dNSOutput) {
        dNSOutput.writeByteArray(toWireCanonical());
    }

    public Name wild(int i10) {
        if (i10 >= 1) {
            try {
                Name name2 = new Name();
                copy(wild, name2);
                name2.append(this.name, offset(i10), getlabels() - i10);
                return name2;
            } catch (Exception unused) {
                throw new IllegalStateException("Name.wild: concatenate failed");
            }
        } else {
            throw new IllegalArgumentException("must replace 1 or more labels");
        }
    }

    public Name(String str, Name name2) {
        if (str.equals("")) {
            throw parseException(str, "empty name");
        } else if (str.equals("@")) {
            if (name2 == null) {
                copy(empty, this);
            } else {
                copy(name2, this);
            }
        } else if (str.equals(".")) {
            copy(root, this);
        } else {
            byte[] bArr = new byte[64];
            boolean z10 = true;
            int i10 = -1;
            boolean z11 = false;
            int i11 = 1;
            int i12 = 0;
            int i13 = 0;
            for (int i14 = 0; i14 < str.length(); i14++) {
                byte charAt = (byte) str.charAt(i14);
                if (z11) {
                    if (charAt >= 48 && charAt <= 57 && i12 < 3) {
                        i12++;
                        i13 = (i13 * 10) + (charAt - 48);
                        if (i12 >= 3) {
                            charAt = (byte) i13;
                        }
                    }
                    bArr[i11] = charAt;
                    z11 = false;
                    int i15 = i11;
                    i11++;
                    i10 = i15;
                } else if (charAt == 92) {
                    z11 = true;
                    i12 = 0;
                    i13 = 0;
                } else if (charAt == 46) {
                    bArr[0] = (byte) (i11 - 1);
                    appendFromString(str, bArr, 0, 1);
                    i10 = -1;
                    i11 = 1;
                } else {
                    i10 = i10 == -1 ? i14 : i10;
                    bArr[i11] = charAt;
                    i11++;
                }
            }
            if (i10 == -1) {
                appendFromString(str, emptyLabel, 0, 1);
            } else {
                bArr[0] = (byte) (i11 - 1);
                appendFromString(str, bArr, 0, 1);
                z10 = false;
            }
            if (name2 != null && !z10) {
                appendFromString(str, name2.name, name2.offset(0), name2.getlabels());
            }
        }
    }

    public static Name fromString(String str) {
        return fromString(str, (Name) null);
    }

    public byte[] toWireCanonical() {
        int labels = labels();
        if (labels == 0) {
            return new byte[0];
        }
        byte[] bArr = new byte[(this.name.length - offset(0))];
        int offset = offset(0);
        int i10 = 0;
        int i11 = 0;
        while (i10 < labels) {
            byte b10 = this.name[offset];
            if (b10 <= 63) {
                offset++;
                bArr[i11] = b10;
                i11++;
                int i12 = 0;
                while (i12 < b10) {
                    bArr[i11] = lowercase[this.name[offset] & UnsignedBytes.MAX_VALUE];
                    i12++;
                    i11++;
                    offset++;
                }
                i10++;
            } else {
                throw new IllegalStateException("invalid label");
            }
        }
        return bArr;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof Name)) {
            return false;
        }
        Name name2 = (Name) obj;
        if (name2.hashcode == 0) {
            name2.hashCode();
        }
        if (this.hashcode == 0) {
            hashCode();
        }
        if (name2.hashcode == this.hashcode && name2.labels() == labels()) {
            return equals(name2.name, name2.offset(0));
        }
        return false;
    }

    public String toString() {
        return toString(false);
    }

    public byte[] toWire() {
        DNSOutput dNSOutput = new DNSOutput();
        toWire(dNSOutput, (Compression) null);
        return dNSOutput.toByteArray();
    }

    public void toWire(DNSOutput dNSOutput, Compression compression, boolean z10) {
        if (z10) {
            toWireCanonical(dNSOutput);
        } else {
            toWire(dNSOutput, compression);
        }
    }

    public Name(String str) {
        this(str, (Name) null);
    }

    public Name(DNSInput dNSInput) {
        byte[] bArr = new byte[64];
        boolean z10 = false;
        boolean z11 = false;
        while (!z10) {
            int readU8 = dNSInput.readU8();
            int i10 = readU8 & 192;
            if (i10 != 0) {
                if (i10 == 192) {
                    int readU82 = dNSInput.readU8() + ((readU8 & -193) << 8);
                    if (Options.check("verbosecompression")) {
                        PrintStream printStream = System.err;
                        printStream.println("currently " + dNSInput.current() + ", pointer to " + readU82);
                    }
                    if (readU82 < dNSInput.current() - 2) {
                        if (!z11) {
                            dNSInput.save();
                            z11 = true;
                        }
                        dNSInput.jump(readU82);
                        if (Options.check("verbosecompression")) {
                            PrintStream printStream2 = System.err;
                            printStream2.println("current name '" + this + "', seeking to " + readU82);
                        }
                    } else {
                        throw new Exception("bad compression");
                    }
                } else {
                    throw new Exception("bad label type");
                }
            } else if (getlabels() >= 128) {
                throw new Exception("too many labels");
            } else if (readU8 == 0) {
                append(emptyLabel, 0, 1);
                z10 = true;
            } else {
                bArr[0] = (byte) readU8;
                dNSInput.readByteArray(bArr, 1, readU8);
                append(bArr, 0, 1);
            }
        }
        if (z11) {
            dNSInput.restore();
        }
    }

    public Name(byte[] bArr) {
        this(new DNSInput(bArr));
    }

    public Name(Name name2, int i10) {
        int labels = name2.labels();
        if (i10 <= labels) {
            this.name = name2.name;
            int i11 = labels - i10;
            setlabels(i11);
            int i12 = 0;
            while (i12 < 7 && i12 < i11) {
                setoffset(i12, name2.offset(i12 + i10));
                i12++;
            }
            return;
        }
        throw new IllegalArgumentException("attempted to remove too many labels");
    }
}
