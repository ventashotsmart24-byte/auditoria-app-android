package com.hpplay.component.protocol.plist;

import java.util.Arrays;

public class NSArray extends NSObject {
    private NSObject[] array;

    public NSArray(int i10) {
        this.array = new NSObject[i10];
    }

    public void assignIDs(BinaryPropertyListWriter binaryPropertyListWriter) {
        super.assignIDs(binaryPropertyListWriter);
        for (NSObject assignIDs : this.array) {
            assignIDs.assignIDs(binaryPropertyListWriter);
        }
    }

    public boolean containsObject(Object obj) {
        NSObject fromJavaObject = NSObject.fromJavaObject(obj);
        for (NSObject nSObject : this.array) {
            if (nSObject == null) {
                if (obj == null) {
                    return true;
                }
            } else if (nSObject.equals(fromJavaObject)) {
                return true;
            }
        }
        return false;
    }

    public int count() {
        return this.array.length;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        Class<NSArray> cls = NSArray.class;
        if (obj.getClass().equals(cls)) {
            return Arrays.equals(((NSArray) obj).getArray(), this.array);
        }
        NSObject fromJavaObject = NSObject.fromJavaObject(obj);
        if (fromJavaObject.getClass().equals(cls)) {
            return Arrays.equals(((NSArray) fromJavaObject).getArray(), this.array);
        }
        return false;
    }

    public NSObject[] getArray() {
        return this.array;
    }

    public int hashCode() {
        return 623 + Arrays.deepHashCode(this.array);
    }

    public int indexOfIdenticalObject(Object obj) {
        NSObject fromJavaObject = NSObject.fromJavaObject(obj);
        int i10 = 0;
        while (true) {
            NSObject[] nSObjectArr = this.array;
            if (i10 >= nSObjectArr.length) {
                return -1;
            }
            if (nSObjectArr[i10] == fromJavaObject) {
                return i10;
            }
            i10++;
        }
    }

    public int indexOfObject(Object obj) {
        NSObject fromJavaObject = NSObject.fromJavaObject(obj);
        int i10 = 0;
        while (true) {
            NSObject[] nSObjectArr = this.array;
            if (i10 >= nSObjectArr.length) {
                return -1;
            }
            if (nSObjectArr[i10].equals(fromJavaObject)) {
                return i10;
            }
            i10++;
        }
    }

    public NSObject lastObject() {
        NSObject[] nSObjectArr = this.array;
        return nSObjectArr[nSObjectArr.length - 1];
    }

    public NSObject objectAtIndex(int i10) {
        return this.array[i10];
    }

    public NSObject[] objectsAtIndexes(int... iArr) {
        NSObject[] nSObjectArr = new NSObject[iArr.length];
        Arrays.sort(iArr);
        for (int i10 = 0; i10 < iArr.length; i10++) {
            nSObjectArr[i10] = this.array[iArr[i10]];
        }
        return nSObjectArr;
    }

    public void remove(int i10) {
        NSObject[] nSObjectArr = this.array;
        if (i10 >= nSObjectArr.length || i10 < 0) {
            throw new ArrayIndexOutOfBoundsException("invalid index:" + i10 + ";the array length is " + this.array.length);
        }
        NSObject[] nSObjectArr2 = new NSObject[(nSObjectArr.length - 1)];
        System.arraycopy(nSObjectArr, 0, nSObjectArr2, 0, i10);
        NSObject[] nSObjectArr3 = this.array;
        System.arraycopy(nSObjectArr3, i10 + 1, nSObjectArr2, i10, (nSObjectArr3.length - i10) - 1);
        this.array = nSObjectArr2;
    }

    public void setValue(int i10, Object obj) {
        this.array[i10] = NSObject.fromJavaObject(obj);
    }

    public void toASCII(StringBuilder sb, int i10) {
        indent(sb, i10);
        sb.append(ASCIIPropertyListParser.ARRAY_BEGIN_TOKEN);
        int lastIndexOf = sb.lastIndexOf(NSObject.NEWLINE);
        int i11 = 0;
        while (true) {
            NSObject[] nSObjectArr = this.array;
            if (i11 < nSObjectArr.length) {
                Class<?> cls = nSObjectArr[i11].getClass();
                if ((cls.equals(NSDictionary.class) || cls.equals(NSArray.class) || cls.equals(NSData.class)) && lastIndexOf != sb.length()) {
                    sb.append(NSObject.NEWLINE);
                    lastIndexOf = sb.length();
                    this.array[i11].toASCII(sb, i10 + 1);
                } else {
                    if (i11 != 0) {
                        sb.append(' ');
                    }
                    this.array[i11].toASCII(sb, 0);
                }
                if (i11 != this.array.length - 1) {
                    sb.append(ASCIIPropertyListParser.ARRAY_ITEM_DELIMITER_TOKEN);
                }
                if (sb.length() - lastIndexOf > 80) {
                    sb.append(NSObject.NEWLINE);
                    lastIndexOf = sb.length();
                }
                i11++;
            } else {
                sb.append(ASCIIPropertyListParser.ARRAY_END_TOKEN);
                return;
            }
        }
    }

    public void toASCIIGnuStep(StringBuilder sb, int i10) {
        indent(sb, i10);
        sb.append(ASCIIPropertyListParser.ARRAY_BEGIN_TOKEN);
        int lastIndexOf = sb.lastIndexOf(NSObject.NEWLINE);
        int i11 = 0;
        while (true) {
            NSObject[] nSObjectArr = this.array;
            if (i11 < nSObjectArr.length) {
                Class<?> cls = nSObjectArr[i11].getClass();
                if ((cls.equals(NSDictionary.class) || cls.equals(NSArray.class) || cls.equals(NSData.class)) && lastIndexOf != sb.length()) {
                    sb.append(NSObject.NEWLINE);
                    lastIndexOf = sb.length();
                    this.array[i11].toASCIIGnuStep(sb, i10 + 1);
                } else {
                    if (i11 != 0) {
                        sb.append(' ');
                    }
                    this.array[i11].toASCIIGnuStep(sb, 0);
                }
                if (i11 != this.array.length - 1) {
                    sb.append(ASCIIPropertyListParser.ARRAY_ITEM_DELIMITER_TOKEN);
                }
                if (sb.length() - lastIndexOf > 80) {
                    sb.append(NSObject.NEWLINE);
                    lastIndexOf = sb.length();
                }
                i11++;
            } else {
                sb.append(ASCIIPropertyListParser.ARRAY_END_TOKEN);
                return;
            }
        }
    }

    public String toASCIIPropertyList() {
        StringBuilder sb = new StringBuilder();
        toASCII(sb, 0);
        sb.append(NSObject.NEWLINE);
        return sb.toString();
    }

    public void toBinary(BinaryPropertyListWriter binaryPropertyListWriter) {
        binaryPropertyListWriter.writeIntHeader(10, this.array.length);
        for (NSObject id : this.array) {
            binaryPropertyListWriter.writeID(binaryPropertyListWriter.getID(id));
        }
    }

    public String toGnuStepASCIIPropertyList() {
        StringBuilder sb = new StringBuilder();
        toASCIIGnuStep(sb, 0);
        sb.append(NSObject.NEWLINE);
        return sb.toString();
    }

    public void toXML(StringBuilder sb, int i10) {
        indent(sb, i10);
        sb.append("<array>");
        sb.append(NSObject.NEWLINE);
        for (NSObject xml : this.array) {
            xml.toXML(sb, i10 + 1);
            sb.append(NSObject.NEWLINE);
        }
        indent(sb, i10);
        sb.append("</array>");
    }

    public NSArray(NSObject... nSObjectArr) {
        this.array = nSObjectArr;
    }

    public NSArray clone() {
        NSObject[] nSObjectArr = new NSObject[this.array.length];
        int i10 = 0;
        while (true) {
            NSObject[] nSObjectArr2 = this.array;
            if (i10 >= nSObjectArr2.length) {
                return new NSArray(nSObjectArr);
            }
            NSObject nSObject = nSObjectArr2[i10];
            nSObjectArr[i10] = nSObject != null ? nSObject.clone() : null;
            i10++;
        }
    }
}
