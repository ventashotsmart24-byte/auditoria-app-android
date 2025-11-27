package okio;

import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Arrays;

final class SegmentedByteString extends ByteString {
    final transient int[] directory;
    final transient byte[][] segments;

    public SegmentedByteString(Buffer buffer, int i10) {
        super((byte[]) null);
        Util.checkOffsetAndCount(buffer.size, 0, (long) i10);
        Segment segment = buffer.head;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        while (i12 < i10) {
            int i14 = segment.limit;
            int i15 = segment.pos;
            if (i14 != i15) {
                i12 += i14 - i15;
                i13++;
                segment = segment.next;
            } else {
                throw new AssertionError("s.limit == s.pos");
            }
        }
        this.segments = new byte[i13][];
        this.directory = new int[(i13 * 2)];
        Segment segment2 = buffer.head;
        int i16 = 0;
        while (i11 < i10) {
            byte[][] bArr = this.segments;
            bArr[i16] = segment2.data;
            int i17 = segment2.limit;
            int i18 = segment2.pos;
            i11 += i17 - i18;
            if (i11 > i10) {
                i11 = i10;
            }
            int[] iArr = this.directory;
            iArr[i16] = i11;
            iArr[bArr.length + i16] = i18;
            segment2.shared = true;
            i16++;
            segment2 = segment2.next;
        }
    }

    private int segment(int i10) {
        int binarySearch = Arrays.binarySearch(this.directory, 0, this.segments.length, i10 + 1);
        if (binarySearch >= 0) {
            return binarySearch;
        }
        return binarySearch ^ -1;
    }

    private ByteString toByteString() {
        return new ByteString(toByteArray());
    }

    private Object writeReplace() {
        return toByteString();
    }

    public ByteBuffer asByteBuffer() {
        return ByteBuffer.wrap(toByteArray()).asReadOnlyBuffer();
    }

    public String base64() {
        return toByteString().base64();
    }

    public String base64Url() {
        return toByteString().base64Url();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            if (byteString.size() != size() || !rangeEquals(0, byteString, 0, size())) {
                return false;
            }
            return true;
        }
        return false;
    }

    public byte getByte(int i10) {
        int i11;
        Util.checkOffsetAndCount((long) this.directory[this.segments.length - 1], (long) i10, 1);
        int segment = segment(i10);
        if (segment == 0) {
            i11 = 0;
        } else {
            i11 = this.directory[segment - 1];
        }
        int[] iArr = this.directory;
        byte[][] bArr = this.segments;
        return bArr[segment][(i10 - i11) + iArr[bArr.length + segment]];
    }

    public int hashCode() {
        int i10 = this.hashCode;
        if (i10 != 0) {
            return i10;
        }
        int length = this.segments.length;
        int i11 = 0;
        int i12 = 0;
        int i13 = 1;
        while (i11 < length) {
            byte[] bArr = this.segments[i11];
            int[] iArr = this.directory;
            int i14 = iArr[length + i11];
            int i15 = iArr[i11];
            int i16 = (i15 - i12) + i14;
            while (i14 < i16) {
                i13 = (i13 * 31) + bArr[i14];
                i14++;
            }
            i11++;
            i12 = i15;
        }
        this.hashCode = i13;
        return i13;
    }

    public String hex() {
        return toByteString().hex();
    }

    public ByteString hmacSha1(ByteString byteString) {
        return toByteString().hmacSha1(byteString);
    }

    public ByteString hmacSha256(ByteString byteString) {
        return toByteString().hmacSha256(byteString);
    }

    public int indexOf(byte[] bArr, int i10) {
        return toByteString().indexOf(bArr, i10);
    }

    public byte[] internalArray() {
        return toByteArray();
    }

    public int lastIndexOf(byte[] bArr, int i10) {
        return toByteString().lastIndexOf(bArr, i10);
    }

    public ByteString md5() {
        return toByteString().md5();
    }

    public boolean rangeEquals(int i10, ByteString byteString, int i11, int i12) {
        int i13;
        if (i10 < 0 || i10 > size() - i12) {
            return false;
        }
        int segment = segment(i10);
        while (i12 > 0) {
            if (segment == 0) {
                i13 = 0;
            } else {
                i13 = this.directory[segment - 1];
            }
            int min = Math.min(i12, ((this.directory[segment] - i13) + i13) - i10);
            int[] iArr = this.directory;
            byte[][] bArr = this.segments;
            if (!byteString.rangeEquals(i11, bArr[segment], (i10 - i13) + iArr[bArr.length + segment], min)) {
                return false;
            }
            i10 += min;
            i11 += min;
            i12 -= min;
            segment++;
        }
        return true;
    }

    public ByteString sha1() {
        return toByteString().sha1();
    }

    public ByteString sha256() {
        return toByteString().sha256();
    }

    public int size() {
        return this.directory[this.segments.length - 1];
    }

    public String string(Charset charset) {
        return toByteString().string(charset);
    }

    public ByteString substring(int i10) {
        return toByteString().substring(i10);
    }

    public ByteString toAsciiLowercase() {
        return toByteString().toAsciiLowercase();
    }

    public ByteString toAsciiUppercase() {
        return toByteString().toAsciiUppercase();
    }

    public byte[] toByteArray() {
        int[] iArr = this.directory;
        byte[][] bArr = this.segments;
        byte[] bArr2 = new byte[iArr[bArr.length - 1]];
        int length = bArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            int[] iArr2 = this.directory;
            int i12 = iArr2[length + i10];
            int i13 = iArr2[i10];
            System.arraycopy(this.segments[i10], i12, bArr2, i11, i13 - i11);
            i10++;
            i11 = i13;
        }
        return bArr2;
    }

    public String toString() {
        return toByteString().toString();
    }

    public String utf8() {
        return toByteString().utf8();
    }

    public void write(OutputStream outputStream) {
        if (outputStream != null) {
            int length = this.segments.length;
            int i10 = 0;
            int i11 = 0;
            while (i10 < length) {
                int[] iArr = this.directory;
                int i12 = iArr[length + i10];
                int i13 = iArr[i10];
                outputStream.write(this.segments[i10], i12, i13 - i11);
                i10++;
                i11 = i13;
            }
            return;
        }
        throw new IllegalArgumentException("out == null");
    }

    public ByteString substring(int i10, int i11) {
        return toByteString().substring(i10, i11);
    }

    public void write(Buffer buffer) {
        int length = this.segments.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            int[] iArr = this.directory;
            int i12 = iArr[length + i10];
            int i13 = iArr[i10];
            Segment segment = new Segment(this.segments[i10], i12, (i12 + i13) - i11, true, false);
            Segment segment2 = buffer.head;
            if (segment2 == null) {
                segment.prev = segment;
                segment.next = segment;
                buffer.head = segment;
            } else {
                segment2.prev.push(segment);
            }
            i10++;
            i11 = i13;
        }
        buffer.size += (long) i11;
    }

    public boolean rangeEquals(int i10, byte[] bArr, int i11, int i12) {
        int i13;
        if (i10 < 0 || i10 > size() - i12 || i11 < 0 || i11 > bArr.length - i12) {
            return false;
        }
        int segment = segment(i10);
        while (i12 > 0) {
            if (segment == 0) {
                i13 = 0;
            } else {
                i13 = this.directory[segment - 1];
            }
            int min = Math.min(i12, ((this.directory[segment] - i13) + i13) - i10);
            int[] iArr = this.directory;
            byte[][] bArr2 = this.segments;
            if (!Util.arrayRangeEquals(bArr2[segment], (i10 - i13) + iArr[bArr2.length + segment], bArr, i11, min)) {
                return false;
            }
            i10 += min;
            i11 += min;
            i12 -= min;
            segment++;
        }
        return true;
    }
}
