package com.hpplay.component.protocol.plist;

public class NSNumber extends NSObject implements Comparable<Object> {
    public static final int BOOLEAN = 2;
    public static final int INTEGER = 0;
    public static final int REAL = 1;
    private boolean boolValue;
    private double doubleValue;
    private long longValue;
    private int type;

    public NSNumber(byte[] bArr, int i10) {
        this(bArr, 0, bArr.length, i10);
    }

    public boolean boolValue() {
        if (this.type == 2) {
            return this.boolValue;
        }
        if (doubleValue() != 0.0d) {
            return true;
        }
        return false;
    }

    public int compareTo(Object obj) {
        double doubleValue2 = doubleValue();
        if (obj instanceof NSNumber) {
            double doubleValue3 = ((NSNumber) obj).doubleValue();
            if (doubleValue2 < doubleValue3) {
                return -1;
            }
            if (doubleValue2 == doubleValue3) {
                return 0;
            }
            return 1;
        } else if (!(obj instanceof Number)) {
            return -1;
        } else {
            double doubleValue4 = ((Number) obj).doubleValue();
            if (doubleValue2 < doubleValue4) {
                return -1;
            }
            if (doubleValue2 == doubleValue4) {
                return 0;
            }
            return 1;
        }
    }

    public double doubleValue() {
        return this.doubleValue;
    }

    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        NSNumber nSNumber = (NSNumber) obj;
        if (this.type == nSNumber.type && this.longValue == nSNumber.longValue && this.doubleValue == nSNumber.doubleValue && this.boolValue == nSNumber.boolValue) {
            return true;
        }
        return false;
    }

    public float floatValue() {
        return (float) this.doubleValue;
    }

    public int hashCode() {
        long j10 = this.longValue;
        return (((((this.type * 37) + ((int) (j10 ^ (j10 >>> 32)))) * 37) + ((int) (Double.doubleToLongBits(this.doubleValue) ^ (Double.doubleToLongBits(this.doubleValue) >>> 32)))) * 37) + (boolValue() ? 1 : 0);
    }

    public int intValue() {
        return (int) this.longValue;
    }

    public boolean isBoolean() {
        if (this.type == 2) {
            return true;
        }
        return false;
    }

    public boolean isInteger() {
        if (this.type == 0) {
            return true;
        }
        return false;
    }

    public boolean isReal() {
        if (this.type == 1) {
            return true;
        }
        return false;
    }

    public long longValue() {
        return this.longValue;
    }

    public String stringValue() {
        int i10 = this.type;
        if (i10 == 0) {
            return String.valueOf(longValue());
        }
        if (i10 == 1) {
            return String.valueOf(doubleValue());
        }
        if (i10 == 2) {
            return String.valueOf(boolValue());
        }
        throw new IllegalStateException("The NSNumber instance has an invalid type: " + this.type);
    }

    public void toASCII(StringBuilder sb, int i10) {
        String str;
        indent(sb, i10);
        if (isBoolean()) {
            if (boolValue()) {
                str = "YES";
            } else {
                str = "NO";
            }
            sb.append(str);
            return;
        }
        sb.append(toString());
    }

    public void toASCIIGnuStep(StringBuilder sb, int i10) {
        indent(sb, i10);
        int type2 = type();
        if (type2 == 0) {
            sb.append("<*I");
            sb.append(toString());
            sb.append(ASCIIPropertyListParser.DATA_END_TOKEN);
        } else if (type2 == 1) {
            sb.append("<*R");
            sb.append(toString());
            sb.append(ASCIIPropertyListParser.DATA_END_TOKEN);
        } else if (type2 == 2) {
            if (boolValue()) {
                sb.append("<*BY>");
            } else {
                sb.append("<*BN>");
            }
        }
    }

    public void toBinary(BinaryPropertyListWriter binaryPropertyListWriter) {
        int type2 = type();
        int i10 = 8;
        if (type2 != 0) {
            if (type2 == 1) {
                binaryPropertyListWriter.write(35);
                binaryPropertyListWriter.writeDouble(doubleValue());
            } else if (type2 == 2) {
                if (boolValue()) {
                    i10 = 9;
                }
                binaryPropertyListWriter.write(i10);
            }
        } else if (longValue() < 0) {
            binaryPropertyListWriter.write(19);
            binaryPropertyListWriter.writeBytes(longValue(), 8);
        } else if (longValue() <= 255) {
            binaryPropertyListWriter.write(16);
            binaryPropertyListWriter.writeBytes(longValue(), 1);
        } else if (longValue() <= 65535) {
            binaryPropertyListWriter.write(17);
            binaryPropertyListWriter.writeBytes(longValue(), 2);
        } else if (longValue() <= 4294967295L) {
            binaryPropertyListWriter.write(18);
            binaryPropertyListWriter.writeBytes(longValue(), 4);
        } else {
            binaryPropertyListWriter.write(19);
            binaryPropertyListWriter.writeBytes(longValue(), 8);
        }
    }

    public String toString() {
        int type2 = type();
        if (type2 == 0) {
            return String.valueOf(longValue());
        }
        if (type2 == 1) {
            return String.valueOf(doubleValue());
        }
        if (type2 != 2) {
            return super.toString();
        }
        return String.valueOf(boolValue());
    }

    public void toXML(StringBuilder sb, int i10) {
        indent(sb, i10);
        int type2 = type();
        if (type2 == 0) {
            sb.append("<integer>");
            sb.append(longValue());
            sb.append("</integer>");
        } else if (type2 == 1) {
            sb.append("<real>");
            sb.append(doubleValue());
            sb.append("</real>");
        } else if (type2 == 2) {
            if (boolValue()) {
                sb.append("<true/>");
            } else {
                sb.append("<false/>");
            }
        }
    }

    public int type() {
        return this.type;
    }

    public NSNumber(byte[] bArr, int i10, int i11, int i12) {
        if (i12 == 0) {
            long parseLong = BinaryPropertyListParser.parseLong(bArr, i10, i11);
            this.longValue = parseLong;
            this.doubleValue = (double) parseLong;
        } else if (i12 == 1) {
            double parseDouble = BinaryPropertyListParser.parseDouble(bArr, i10, i11);
            this.doubleValue = parseDouble;
            this.longValue = Math.round(parseDouble);
        } else {
            throw new IllegalArgumentException("Type argument is not valid.");
        }
        this.type = i12;
    }

    public NSNumber clone() {
        int i10 = this.type;
        if (i10 == 0) {
            return new NSNumber(this.longValue);
        }
        if (i10 == 1) {
            return new NSNumber(this.doubleValue);
        }
        if (i10 == 2) {
            return new NSNumber(this.boolValue);
        }
        throw new IllegalStateException("The NSNumber instance has an invalid type: " + this.type);
    }

    public NSNumber(String str) {
        long j10;
        if (str != null) {
            boolean z10 = false;
            try {
                if (str.startsWith("0x")) {
                    j10 = Long.parseLong(str.substring(2), 16);
                } else {
                    j10 = Long.parseLong(str);
                }
                this.longValue = j10;
                this.doubleValue = (double) j10;
                this.type = 0;
            } catch (Exception unused) {
                try {
                    double parseDouble = Double.parseDouble(str);
                    this.doubleValue = parseDouble;
                    this.longValue = Math.round(parseDouble);
                    this.type = 1;
                } catch (Exception unused2) {
                    z10 = (str.equalsIgnoreCase("true") || str.equalsIgnoreCase("yes")) ? true : z10;
                    this.boolValue = z10;
                    if (!z10 && !str.equalsIgnoreCase("false")) {
                        if (!str.equalsIgnoreCase("no")) {
                            throw new Exception("not a boolean");
                        }
                    }
                    this.type = 2;
                    long j11 = this.boolValue ? 1 : 0;
                    this.longValue = j11;
                    this.doubleValue = (double) j11;
                } catch (Exception unused3) {
                    throw new IllegalArgumentException("The given string neither represents a double, an int nor a boolean value.");
                }
            }
        } else {
            throw new IllegalArgumentException("The given string is null and cannot be parsed as number.");
        }
    }

    public NSNumber(int i10) {
        long j10 = (long) i10;
        this.longValue = j10;
        this.doubleValue = (double) j10;
        this.type = 0;
    }

    public NSNumber(long j10) {
        this.longValue = j10;
        this.doubleValue = (double) j10;
        this.type = 0;
    }

    public NSNumber(double d10) {
        this.doubleValue = d10;
        this.longValue = (long) d10;
        this.type = 1;
    }

    public NSNumber(boolean z10) {
        this.boolValue = z10;
        long j10 = z10 ? 1 : 0;
        this.longValue = j10;
        this.doubleValue = (double) j10;
        this.type = 2;
    }
}
