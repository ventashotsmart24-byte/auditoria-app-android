package okio;

import com.google.android.gms.cast.framework.media.NotificationOptions;
import com.google.common.base.Ascii;
import com.google.common.primitives.UnsignedBytes;
import com.hpplay.sdk.source.mdns.xbill.dns.TTL;
import java.io.Closeable;
import java.io.EOFException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public final class Buffer implements BufferedSource, BufferedSink, Cloneable, ByteChannel {
    private static final byte[] DIGITS = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};
    static final int REPLACEMENT_CHARACTER = 65533;
    @Nullable
    Segment head;
    long size;

    public static final class UnsafeCursor implements Closeable {
        public Buffer buffer;
        public byte[] data;
        public int end = -1;
        public long offset = -1;
        public boolean readWrite;
        private Segment segment;
        public int start = -1;

        public void close() {
            if (this.buffer != null) {
                this.buffer = null;
                this.segment = null;
                this.offset = -1;
                this.data = null;
                this.start = -1;
                this.end = -1;
                return;
            }
            throw new IllegalStateException("not attached to a buffer");
        }

        public final long expandBuffer(int i10) {
            if (i10 <= 0) {
                throw new IllegalArgumentException("minByteCount <= 0: " + i10);
            } else if (i10 <= 8192) {
                Buffer buffer2 = this.buffer;
                if (buffer2 == null) {
                    throw new IllegalStateException("not attached to a buffer");
                } else if (this.readWrite) {
                    long j10 = buffer2.size;
                    Segment writableSegment = buffer2.writableSegment(i10);
                    int i11 = 8192 - writableSegment.limit;
                    writableSegment.limit = 8192;
                    long j11 = (long) i11;
                    this.buffer.size = j10 + j11;
                    this.segment = writableSegment;
                    this.offset = j10;
                    this.data = writableSegment.data;
                    this.start = 8192 - i11;
                    this.end = 8192;
                    return j11;
                } else {
                    throw new IllegalStateException("expandBuffer() only permitted for read/write buffers");
                }
            } else {
                throw new IllegalArgumentException("minByteCount > Segment.SIZE: " + i10);
            }
        }

        public final int next() {
            long j10 = this.offset;
            if (j10 == this.buffer.size) {
                throw new IllegalStateException();
            } else if (j10 == -1) {
                return seek(0);
            } else {
                return seek(j10 + ((long) (this.end - this.start)));
            }
        }

        public final long resizeBuffer(long j10) {
            Buffer buffer2 = this.buffer;
            if (buffer2 == null) {
                throw new IllegalStateException("not attached to a buffer");
            } else if (this.readWrite) {
                long j11 = buffer2.size;
                if (j10 <= j11) {
                    if (j10 >= 0) {
                        long j12 = j11 - j10;
                        while (true) {
                            if (j12 <= 0) {
                                break;
                            }
                            Buffer buffer3 = this.buffer;
                            Segment segment2 = buffer3.head.prev;
                            int i10 = segment2.limit;
                            long j13 = (long) (i10 - segment2.pos);
                            if (j13 > j12) {
                                segment2.limit = (int) (((long) i10) - j12);
                                break;
                            }
                            buffer3.head = segment2.pop();
                            SegmentPool.recycle(segment2);
                            j12 -= j13;
                        }
                        this.segment = null;
                        this.offset = j10;
                        this.data = null;
                        this.start = -1;
                        this.end = -1;
                    } else {
                        throw new IllegalArgumentException("newSize < 0: " + j10);
                    }
                } else if (j10 > j11) {
                    long j14 = j10 - j11;
                    boolean z10 = true;
                    while (j14 > 0) {
                        Segment writableSegment = this.buffer.writableSegment(1);
                        int min = (int) Math.min(j14, (long) (8192 - writableSegment.limit));
                        int i11 = writableSegment.limit + min;
                        writableSegment.limit = i11;
                        j14 -= (long) min;
                        if (z10) {
                            this.segment = writableSegment;
                            this.offset = j11;
                            this.data = writableSegment.data;
                            this.start = i11 - min;
                            this.end = i11;
                            z10 = false;
                        }
                    }
                }
                this.buffer.size = j10;
                return j11;
            } else {
                throw new IllegalStateException("resizeBuffer() only permitted for read/write buffers");
            }
        }

        public final int seek(long j10) {
            if (j10 >= -1) {
                Buffer buffer2 = this.buffer;
                long j11 = buffer2.size;
                if (j10 <= j11) {
                    if (j10 == -1 || j10 == j11) {
                        this.segment = null;
                        this.offset = j10;
                        this.data = null;
                        this.start = -1;
                        this.end = -1;
                        return -1;
                    }
                    Segment segment2 = buffer2.head;
                    Segment segment3 = this.segment;
                    long j12 = 0;
                    if (segment3 != null) {
                        long j13 = this.offset - ((long) (this.start - segment3.pos));
                        if (j13 > j10) {
                            j11 = j13;
                            Segment segment4 = segment3;
                            segment3 = segment2;
                            segment2 = segment4;
                        } else {
                            j12 = j13;
                        }
                    } else {
                        segment3 = segment2;
                    }
                    if (j11 - j10 > j10 - j12) {
                        while (true) {
                            int i10 = segment3.limit;
                            int i11 = segment3.pos;
                            if (j10 < ((long) (i10 - i11)) + j12) {
                                break;
                            }
                            j12 += (long) (i10 - i11);
                            segment3 = segment3.next;
                        }
                    } else {
                        while (j11 > j10) {
                            segment2 = segment2.prev;
                            j11 -= (long) (segment2.limit - segment2.pos);
                        }
                        segment3 = segment2;
                        j12 = j11;
                    }
                    if (this.readWrite && segment3.shared) {
                        Segment unsharedCopy = segment3.unsharedCopy();
                        Buffer buffer3 = this.buffer;
                        if (buffer3.head == segment3) {
                            buffer3.head = unsharedCopy;
                        }
                        segment3 = segment3.push(unsharedCopy);
                        segment3.prev.pop();
                    }
                    this.segment = segment3;
                    this.offset = j10;
                    this.data = segment3.data;
                    int i12 = segment3.pos + ((int) (j10 - j12));
                    this.start = i12;
                    int i13 = segment3.limit;
                    this.end = i13;
                    return i13 - i12;
                }
            }
            throw new ArrayIndexOutOfBoundsException(String.format("offset=%s > size=%s", new Object[]{Long.valueOf(j10), Long.valueOf(this.buffer.size)}));
        }
    }

    private ByteString digest(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance(str);
            Segment segment = this.head;
            if (segment != null) {
                byte[] bArr = segment.data;
                int i10 = segment.pos;
                instance.update(bArr, i10, segment.limit - i10);
                Segment segment2 = this.head;
                while (true) {
                    segment2 = segment2.next;
                    if (segment2 == this.head) {
                        break;
                    }
                    byte[] bArr2 = segment2.data;
                    int i11 = segment2.pos;
                    instance.update(bArr2, i11, segment2.limit - i11);
                }
            }
            return ByteString.of(instance.digest());
        } catch (NoSuchAlgorithmException unused) {
            throw new AssertionError();
        }
    }

    private ByteString hmac(String str, ByteString byteString) {
        try {
            Mac instance = Mac.getInstance(str);
            instance.init(new SecretKeySpec(byteString.toByteArray(), str));
            Segment segment = this.head;
            if (segment != null) {
                byte[] bArr = segment.data;
                int i10 = segment.pos;
                instance.update(bArr, i10, segment.limit - i10);
                Segment segment2 = this.head;
                while (true) {
                    segment2 = segment2.next;
                    if (segment2 == this.head) {
                        break;
                    }
                    byte[] bArr2 = segment2.data;
                    int i11 = segment2.pos;
                    instance.update(bArr2, i11, segment2.limit - i11);
                }
            }
            return ByteString.of(instance.doFinal());
        } catch (NoSuchAlgorithmException unused) {
            throw new AssertionError();
        } catch (InvalidKeyException e10) {
            throw new IllegalArgumentException(e10);
        }
    }

    public Buffer buffer() {
        return this;
    }

    public final void clear() {
        try {
            skip(this.size);
        } catch (EOFException e10) {
            throw new AssertionError(e10);
        }
    }

    public void close() {
    }

    public final long completeSegmentByteCount() {
        long j10 = this.size;
        if (j10 == 0) {
            return 0;
        }
        Segment segment = this.head.prev;
        int i10 = segment.limit;
        if (i10 >= 8192 || !segment.owner) {
            return j10;
        }
        return j10 - ((long) (i10 - segment.pos));
    }

    public final Buffer copyTo(OutputStream outputStream) {
        return copyTo(outputStream, 0, this.size);
    }

    public BufferedSink emit() {
        return this;
    }

    public Buffer emitCompleteSegments() {
        return this;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Buffer)) {
            return false;
        }
        Buffer buffer = (Buffer) obj;
        long j10 = this.size;
        if (j10 != buffer.size) {
            return false;
        }
        long j11 = 0;
        if (j10 == 0) {
            return true;
        }
        Segment segment = this.head;
        Segment segment2 = buffer.head;
        int i10 = segment.pos;
        int i11 = segment2.pos;
        while (j11 < this.size) {
            long min = (long) Math.min(segment.limit - i10, segment2.limit - i11);
            int i12 = 0;
            while (((long) i12) < min) {
                int i13 = i10 + 1;
                int i14 = i11 + 1;
                if (segment.data[i10] != segment2.data[i11]) {
                    return false;
                }
                i12++;
                i10 = i13;
                i11 = i14;
            }
            if (i10 == segment.limit) {
                segment = segment.next;
                i10 = segment.pos;
            }
            if (i11 == segment2.limit) {
                segment2 = segment2.next;
                i11 = segment2.pos;
            }
            j11 += min;
        }
        return true;
    }

    public boolean exhausted() {
        if (this.size == 0) {
            return true;
        }
        return false;
    }

    public void flush() {
    }

    public Buffer getBuffer() {
        return this;
    }

    public final byte getByte(long j10) {
        int i10;
        Util.checkOffsetAndCount(this.size, j10, 1);
        long j11 = this.size;
        if (j11 - j10 > j10) {
            Segment segment = this.head;
            while (true) {
                int i11 = segment.limit;
                int i12 = segment.pos;
                long j12 = (long) (i11 - i12);
                if (j10 < j12) {
                    return segment.data[i12 + ((int) j10)];
                }
                j10 -= j12;
                segment = segment.next;
            }
        } else {
            long j13 = j10 - j11;
            Segment segment2 = this.head;
            do {
                segment2 = segment2.prev;
                int i13 = segment2.limit;
                i10 = segment2.pos;
                j13 += (long) (i13 - i10);
            } while (j13 < 0);
            return segment2.data[i10 + ((int) j13)];
        }
    }

    public int hashCode() {
        Segment segment = this.head;
        if (segment == null) {
            return 0;
        }
        int i10 = 1;
        do {
            int i11 = segment.limit;
            for (int i12 = segment.pos; i12 < i11; i12++) {
                i10 = (i10 * 31) + segment.data[i12];
            }
            segment = segment.next;
        } while (segment != this.head);
        return i10;
    }

    public final ByteString hmacSha1(ByteString byteString) {
        return hmac("HmacSHA1", byteString);
    }

    public final ByteString hmacSha256(ByteString byteString) {
        return hmac("HmacSHA256", byteString);
    }

    public final ByteString hmacSha512(ByteString byteString) {
        return hmac("HmacSHA512", byteString);
    }

    public long indexOf(byte b10) {
        return indexOf(b10, 0, Long.MAX_VALUE);
    }

    public long indexOfElement(ByteString byteString) {
        return indexOfElement(byteString, 0);
    }

    public InputStream inputStream() {
        return new InputStream() {
            public int available() {
                return (int) Math.min(Buffer.this.size, TTL.MAX_VALUE);
            }

            public void close() {
            }

            public int read() {
                Buffer buffer = Buffer.this;
                if (buffer.size > 0) {
                    return buffer.readByte() & UnsignedBytes.MAX_VALUE;
                }
                return -1;
            }

            public String toString() {
                return Buffer.this + ".inputStream()";
            }

            public int read(byte[] bArr, int i10, int i11) {
                return Buffer.this.read(bArr, i10, i11);
            }
        };
    }

    public boolean isOpen() {
        return true;
    }

    public final ByteString md5() {
        return digest("MD5");
    }

    public OutputStream outputStream() {
        return new OutputStream() {
            public void close() {
            }

            public void flush() {
            }

            public String toString() {
                return Buffer.this + ".outputStream()";
            }

            public void write(int i10) {
                Buffer.this.writeByte((int) (byte) i10);
            }

            public void write(byte[] bArr, int i10, int i11) {
                Buffer.this.write(bArr, i10, i11);
            }
        };
    }

    public BufferedSource peek() {
        return Okio.buffer((Source) new PeekSource(this));
    }

    public boolean rangeEquals(long j10, ByteString byteString) {
        return rangeEquals(j10, byteString, 0, byteString.size());
    }

    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    public long readAll(Sink sink) {
        long j10 = this.size;
        if (j10 > 0) {
            sink.write(this, j10);
        }
        return j10;
    }

    public final UnsafeCursor readAndWriteUnsafe() {
        return readAndWriteUnsafe(new UnsafeCursor());
    }

    public byte readByte() {
        long j10 = this.size;
        if (j10 != 0) {
            Segment segment = this.head;
            int i10 = segment.pos;
            int i11 = segment.limit;
            int i12 = i10 + 1;
            byte b10 = segment.data[i10];
            this.size = j10 - 1;
            if (i12 == i11) {
                this.head = segment.pop();
                SegmentPool.recycle(segment);
            } else {
                segment.pos = i12;
            }
            return b10;
        }
        throw new IllegalStateException("size == 0");
    }

    public byte[] readByteArray() {
        try {
            return readByteArray(this.size);
        } catch (EOFException e10) {
            throw new AssertionError(e10);
        }
    }

    public ByteString readByteString() {
        return new ByteString(readByteArray());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x004e, code lost:
        if (r2 != false) goto L_0x0053;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0050, code lost:
        r1.readByte();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x006d, code lost:
        throw new java.lang.NumberFormatException("Number too large: " + r1.readUtf8());
     */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x009f  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00a9  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x009d A[EDGE_INSN: B:48:0x009d->B:30:0x009d ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:5:0x001b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long readDecimalLong() {
        /*
            r17 = this;
            r0 = r17
            long r1 = r0.size
            r3 = 0
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 == 0) goto L_0x00bc
            r1 = 0
            r5 = -7
            r6 = r5
            r2 = 0
            r4 = r3
            r3 = 0
        L_0x0011:
            okio.Segment r8 = r0.head
            byte[] r9 = r8.data
            int r10 = r8.pos
            int r11 = r8.limit
        L_0x0019:
            if (r10 >= r11) goto L_0x009d
            byte r12 = r9[r10]
            r13 = 48
            if (r12 < r13) goto L_0x006e
            r13 = 57
            if (r12 > r13) goto L_0x006e
            int r13 = 48 - r12
            r14 = -922337203685477580(0xf333333333333334, double:-8.390303882365713E246)
            int r16 = (r4 > r14 ? 1 : (r4 == r14 ? 0 : -1))
            if (r16 < 0) goto L_0x0041
            int r16 = (r4 > r14 ? 1 : (r4 == r14 ? 0 : -1))
            if (r16 != 0) goto L_0x003a
            long r14 = (long) r13
            int r16 = (r14 > r6 ? 1 : (r14 == r6 ? 0 : -1))
            if (r16 >= 0) goto L_0x003a
            goto L_0x0041
        L_0x003a:
            r14 = 10
            long r4 = r4 * r14
            long r12 = (long) r13
            long r4 = r4 + r12
            goto L_0x0079
        L_0x0041:
            okio.Buffer r1 = new okio.Buffer
            r1.<init>()
            okio.Buffer r1 = r1.writeDecimalLong((long) r4)
            okio.Buffer r1 = r1.writeByte((int) r12)
            if (r2 != 0) goto L_0x0053
            r1.readByte()
        L_0x0053:
            java.lang.NumberFormatException r2 = new java.lang.NumberFormatException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Number too large: "
            r3.append(r4)
            java.lang.String r1 = r1.readUtf8()
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            r2.<init>(r1)
            throw r2
        L_0x006e:
            r13 = 45
            r14 = 1
            if (r12 != r13) goto L_0x007e
            if (r1 != 0) goto L_0x007e
            r12 = 1
            long r6 = r6 - r12
            r2 = 1
        L_0x0079:
            int r10 = r10 + 1
            int r1 = r1 + 1
            goto L_0x0019
        L_0x007e:
            if (r1 == 0) goto L_0x0082
            r3 = 1
            goto L_0x009d
        L_0x0082:
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Expected leading [0-9] or '-' character but was 0x"
            r2.append(r3)
            java.lang.String r3 = java.lang.Integer.toHexString(r12)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L_0x009d:
            if (r10 != r11) goto L_0x00a9
            okio.Segment r9 = r8.pop()
            r0.head = r9
            okio.SegmentPool.recycle(r8)
            goto L_0x00ab
        L_0x00a9:
            r8.pos = r10
        L_0x00ab:
            if (r3 != 0) goto L_0x00b1
            okio.Segment r8 = r0.head
            if (r8 != 0) goto L_0x0011
        L_0x00b1:
            long r6 = r0.size
            long r8 = (long) r1
            long r6 = r6 - r8
            r0.size = r6
            if (r2 == 0) goto L_0x00ba
            goto L_0x00bb
        L_0x00ba:
            long r4 = -r4
        L_0x00bb:
            return r4
        L_0x00bc:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "size == 0"
            r1.<init>(r2)
            goto L_0x00c5
        L_0x00c4:
            throw r1
        L_0x00c5:
            goto L_0x00c4
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.Buffer.readDecimalLong():long");
    }

    public final Buffer readFrom(InputStream inputStream) {
        readFrom(inputStream, Long.MAX_VALUE, true);
        return this;
    }

    public void readFully(Buffer buffer, long j10) {
        long j11 = this.size;
        if (j11 >= j10) {
            buffer.write(this, j10);
        } else {
            buffer.write(this, j11);
            throw new EOFException();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0091, code lost:
        if (r8 != r9) goto L_0x009d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0093, code lost:
        r15.head = r6.pop();
        okio.SegmentPool.recycle(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x009d, code lost:
        r6.pos = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x009f, code lost:
        if (r1 != false) goto L_0x00a5;
     */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0076 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long readHexadecimalUnsignedLong() {
        /*
            r15 = this;
            long r0 = r15.size
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 == 0) goto L_0x00ac
            r0 = 0
            r4 = r2
            r1 = 0
        L_0x000b:
            okio.Segment r6 = r15.head
            byte[] r7 = r6.data
            int r8 = r6.pos
            int r9 = r6.limit
        L_0x0013:
            if (r8 >= r9) goto L_0x0091
            byte r10 = r7[r8]
            r11 = 48
            if (r10 < r11) goto L_0x0022
            r11 = 57
            if (r10 > r11) goto L_0x0022
            int r11 = r10 + -48
            goto L_0x003a
        L_0x0022:
            r11 = 97
            if (r10 < r11) goto L_0x002f
            r11 = 102(0x66, float:1.43E-43)
            if (r10 > r11) goto L_0x002f
            int r11 = r10 + -97
        L_0x002c:
            int r11 = r11 + 10
            goto L_0x003a
        L_0x002f:
            r11 = 65
            if (r10 < r11) goto L_0x0072
            r11 = 70
            if (r10 > r11) goto L_0x0072
            int r11 = r10 + -65
            goto L_0x002c
        L_0x003a:
            r12 = -1152921504606846976(0xf000000000000000, double:-3.105036184601418E231)
            long r12 = r12 & r4
            int r14 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r14 != 0) goto L_0x004a
            r10 = 4
            long r4 = r4 << r10
            long r10 = (long) r11
            long r4 = r4 | r10
            int r8 = r8 + 1
            int r0 = r0 + 1
            goto L_0x0013
        L_0x004a:
            okio.Buffer r0 = new okio.Buffer
            r0.<init>()
            okio.Buffer r0 = r0.writeHexadecimalUnsignedLong((long) r4)
            okio.Buffer r0 = r0.writeByte((int) r10)
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Number too large: "
            r2.append(r3)
            java.lang.String r0 = r0.readUtf8()
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0)
            throw r1
        L_0x0072:
            if (r0 == 0) goto L_0x0076
            r1 = 1
            goto L_0x0091
        L_0x0076:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Expected leading [0-9a-fA-F] character but was 0x"
            r1.append(r2)
            java.lang.String r2 = java.lang.Integer.toHexString(r10)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x0091:
            if (r8 != r9) goto L_0x009d
            okio.Segment r7 = r6.pop()
            r15.head = r7
            okio.SegmentPool.recycle(r6)
            goto L_0x009f
        L_0x009d:
            r6.pos = r8
        L_0x009f:
            if (r1 != 0) goto L_0x00a5
            okio.Segment r6 = r15.head
            if (r6 != 0) goto L_0x000b
        L_0x00a5:
            long r1 = r15.size
            long r6 = (long) r0
            long r1 = r1 - r6
            r15.size = r1
            return r4
        L_0x00ac:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "size == 0"
            r0.<init>(r1)
            goto L_0x00b5
        L_0x00b4:
            throw r0
        L_0x00b5:
            goto L_0x00b4
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.Buffer.readHexadecimalUnsignedLong():long");
    }

    public int readInt() {
        long j10 = this.size;
        if (j10 >= 4) {
            Segment segment = this.head;
            int i10 = segment.pos;
            int i11 = segment.limit;
            if (i11 - i10 < 4) {
                return ((readByte() & UnsignedBytes.MAX_VALUE) << Ascii.CAN) | ((readByte() & UnsignedBytes.MAX_VALUE) << 16) | ((readByte() & UnsignedBytes.MAX_VALUE) << 8) | (readByte() & UnsignedBytes.MAX_VALUE);
            }
            byte[] bArr = segment.data;
            int i12 = i10 + 1;
            int i13 = i12 + 1;
            byte b10 = ((bArr[i10] & UnsignedBytes.MAX_VALUE) << Ascii.CAN) | ((bArr[i12] & UnsignedBytes.MAX_VALUE) << 16);
            int i14 = i13 + 1;
            byte b11 = b10 | ((bArr[i13] & UnsignedBytes.MAX_VALUE) << 8);
            int i15 = i14 + 1;
            byte b12 = b11 | (bArr[i14] & UnsignedBytes.MAX_VALUE);
            this.size = j10 - 4;
            if (i15 == i11) {
                this.head = segment.pop();
                SegmentPool.recycle(segment);
            } else {
                segment.pos = i15;
            }
            return b12;
        }
        throw new IllegalStateException("size < 4: " + this.size);
    }

    public int readIntLe() {
        return Util.reverseBytesInt(readInt());
    }

    public long readLong() {
        long j10 = this.size;
        if (j10 >= 8) {
            Segment segment = this.head;
            int i10 = segment.pos;
            int i11 = segment.limit;
            if (i11 - i10 < 8) {
                return ((((long) readInt()) & 4294967295L) << 32) | (4294967295L & ((long) readInt()));
            }
            byte[] bArr = segment.data;
            int i12 = i10 + 1;
            int i13 = i12 + 1;
            long j11 = (((long) bArr[i12]) & 255) << 48;
            int i14 = i13 + 1;
            int i15 = i14 + 1;
            int i16 = i15 + 1;
            int i17 = i16 + 1;
            int i18 = i17 + 1;
            int i19 = i18 + 1;
            long j12 = j11 | ((((long) bArr[i10]) & 255) << 56) | ((((long) bArr[i13]) & 255) << 40) | ((((long) bArr[i14]) & 255) << 32) | ((((long) bArr[i15]) & 255) << 24) | ((((long) bArr[i16]) & 255) << 16) | ((((long) bArr[i17]) & 255) << 8) | (((long) bArr[i18]) & 255);
            this.size = j10 - 8;
            if (i19 == i11) {
                this.head = segment.pop();
                SegmentPool.recycle(segment);
            } else {
                segment.pos = i19;
            }
            return j12;
        }
        throw new IllegalStateException("size < 8: " + this.size);
    }

    public long readLongLe() {
        return Util.reverseBytesLong(readLong());
    }

    public short readShort() {
        long j10 = this.size;
        if (j10 >= 2) {
            Segment segment = this.head;
            int i10 = segment.pos;
            int i11 = segment.limit;
            if (i11 - i10 < 2) {
                return (short) (((readByte() & UnsignedBytes.MAX_VALUE) << 8) | (readByte() & UnsignedBytes.MAX_VALUE));
            }
            byte[] bArr = segment.data;
            int i12 = i10 + 1;
            int i13 = i12 + 1;
            byte b10 = ((bArr[i10] & UnsignedBytes.MAX_VALUE) << 8) | (bArr[i12] & UnsignedBytes.MAX_VALUE);
            this.size = j10 - 2;
            if (i13 == i11) {
                this.head = segment.pop();
                SegmentPool.recycle(segment);
            } else {
                segment.pos = i13;
            }
            return (short) b10;
        }
        throw new IllegalStateException("size < 2: " + this.size);
    }

    public short readShortLe() {
        return Util.reverseBytesShort(readShort());
    }

    public String readString(Charset charset) {
        try {
            return readString(this.size, charset);
        } catch (EOFException e10) {
            throw new AssertionError(e10);
        }
    }

    public final UnsafeCursor readUnsafe() {
        return readUnsafe(new UnsafeCursor());
    }

    public String readUtf8() {
        try {
            return readString(this.size, Util.UTF_8);
        } catch (EOFException e10) {
            throw new AssertionError(e10);
        }
    }

    public int readUtf8CodePoint() {
        byte b10;
        int i10;
        byte b11;
        if (this.size != 0) {
            byte b12 = getByte(0);
            int i11 = 1;
            if ((b12 & UnsignedBytes.MAX_POWER_OF_TWO) == 0) {
                b11 = b12 & Ascii.DEL;
                i10 = 1;
                b10 = 0;
            } else if ((b12 & 224) == 192) {
                b11 = b12 & Ascii.US;
                i10 = 2;
                b10 = UnsignedBytes.MAX_POWER_OF_TWO;
            } else if ((b12 & 240) == 224) {
                b11 = b12 & 15;
                i10 = 3;
                b10 = 2048;
            } else if ((b12 & 248) == 240) {
                b11 = b12 & 7;
                i10 = 4;
                b10 = 65536;
            } else {
                skip(1);
                return REPLACEMENT_CHARACTER;
            }
            long j10 = (long) i10;
            if (this.size >= j10) {
                while (i11 < i10) {
                    long j11 = (long) i11;
                    byte b13 = getByte(j11);
                    if ((b13 & 192) == 128) {
                        b11 = (b11 << 6) | (b13 & 63);
                        i11++;
                    } else {
                        skip(j11);
                        return REPLACEMENT_CHARACTER;
                    }
                }
                skip(j10);
                if (b11 > 1114111) {
                    return REPLACEMENT_CHARACTER;
                }
                if ((b11 < 55296 || b11 > 57343) && b11 >= b10) {
                    return b11;
                }
                return REPLACEMENT_CHARACTER;
            }
            throw new EOFException("size < " + i10 + ": " + this.size + " (to read code point prefixed 0x" + Integer.toHexString(b12) + ")");
        }
        throw new EOFException();
    }

    @Nullable
    public String readUtf8Line() {
        long indexOf = indexOf((byte) 10);
        if (indexOf != -1) {
            return readUtf8Line(indexOf);
        }
        long j10 = this.size;
        if (j10 != 0) {
            return readUtf8(j10);
        }
        return null;
    }

    public String readUtf8LineStrict() {
        return readUtf8LineStrict(Long.MAX_VALUE);
    }

    public boolean request(long j10) {
        if (this.size >= j10) {
            return true;
        }
        return false;
    }

    public void require(long j10) {
        if (this.size < j10) {
            throw new EOFException();
        }
    }

    public List<Integer> segmentSizes() {
        if (this.head == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        Segment segment = this.head;
        arrayList.add(Integer.valueOf(segment.limit - segment.pos));
        Segment segment2 = this.head;
        while (true) {
            segment2 = segment2.next;
            if (segment2 == this.head) {
                return arrayList;
            }
            arrayList.add(Integer.valueOf(segment2.limit - segment2.pos));
        }
    }

    public int select(Options options) {
        int selectPrefix = selectPrefix(options, false);
        if (selectPrefix == -1) {
            return -1;
        }
        try {
            skip((long) options.byteStrings[selectPrefix].size());
            return selectPrefix;
        } catch (EOFException unused) {
            throw new AssertionError();
        }
    }

    public int selectPrefix(Options options, boolean z10) {
        int i10;
        int i11;
        boolean z11;
        int i12;
        Segment segment;
        int i13;
        Options options2 = options;
        Segment segment2 = this.head;
        int i14 = -2;
        if (segment2 != null) {
            byte[] bArr = segment2.data;
            int i15 = segment2.pos;
            int i16 = segment2.limit;
            int[] iArr = options2.trie;
            Segment segment3 = segment2;
            int i17 = 0;
            int i18 = -1;
            loop0:
            while (true) {
                int i19 = i17 + 1;
                int i20 = iArr[i17];
                int i21 = i19 + 1;
                int i22 = iArr[i19];
                if (i22 != -1) {
                    i18 = i22;
                }
                if (segment3 == null) {
                    break;
                }
                if (i20 < 0) {
                    int i23 = i21 + (i20 * -1);
                    while (true) {
                        int i24 = i15 + 1;
                        int i25 = i21 + 1;
                        if ((bArr[i15] & UnsignedBytes.MAX_VALUE) != iArr[i21]) {
                            return i18;
                        }
                        if (i25 == i23) {
                            z11 = true;
                        } else {
                            z11 = false;
                        }
                        if (i24 == i16) {
                            Segment segment4 = segment3.next;
                            i13 = segment4.pos;
                            byte[] bArr2 = segment4.data;
                            i12 = segment4.limit;
                            if (segment4 != segment2) {
                                byte[] bArr3 = bArr2;
                                segment = segment4;
                                bArr = bArr3;
                            } else if (!z11) {
                                break loop0;
                            } else {
                                bArr = bArr2;
                                segment = null;
                            }
                        } else {
                            Segment segment5 = segment3;
                            i12 = i16;
                            i13 = i24;
                            segment = segment5;
                        }
                        if (z11) {
                            i10 = iArr[i25];
                            i11 = i13;
                            i16 = i12;
                            segment3 = segment;
                            break;
                        }
                        i15 = i13;
                        i16 = i12;
                        i21 = i25;
                        segment3 = segment;
                    }
                } else {
                    int i26 = i15 + 1;
                    byte b10 = bArr[i15] & UnsignedBytes.MAX_VALUE;
                    int i27 = i21 + i20;
                    while (i21 != i27) {
                        if (b10 == iArr[i21]) {
                            i10 = iArr[i21 + i20];
                            if (i26 == i16) {
                                segment3 = segment3.next;
                                i11 = segment3.pos;
                                bArr = segment3.data;
                                i16 = segment3.limit;
                                if (segment3 == segment2) {
                                    segment3 = null;
                                }
                            } else {
                                i11 = i26;
                            }
                        } else {
                            i21++;
                        }
                    }
                    return i18;
                }
                if (i10 >= 0) {
                    return i10;
                }
                i17 = -i10;
                i15 = i11;
                i14 = -2;
            }
            if (z10) {
                return i14;
            }
            return i18;
        } else if (z10) {
            return -2;
        } else {
            return options2.indexOf(ByteString.EMPTY);
        }
    }

    public final ByteString sha1() {
        return digest("SHA-1");
    }

    public final ByteString sha256() {
        return digest("SHA-256");
    }

    public final ByteString sha512() {
        return digest("SHA-512");
    }

    public final long size() {
        return this.size;
    }

    public void skip(long j10) {
        while (j10 > 0) {
            Segment segment = this.head;
            if (segment != null) {
                int min = (int) Math.min(j10, (long) (segment.limit - segment.pos));
                long j11 = (long) min;
                this.size -= j11;
                j10 -= j11;
                Segment segment2 = this.head;
                int i10 = segment2.pos + min;
                segment2.pos = i10;
                if (i10 == segment2.limit) {
                    this.head = segment2.pop();
                    SegmentPool.recycle(segment2);
                }
            } else {
                throw new EOFException();
            }
        }
    }

    public final ByteString snapshot() {
        long j10 = this.size;
        if (j10 <= TTL.MAX_VALUE) {
            return snapshot((int) j10);
        }
        throw new IllegalArgumentException("size > Integer.MAX_VALUE: " + this.size);
    }

    public Timeout timeout() {
        return Timeout.NONE;
    }

    public String toString() {
        return snapshot().toString();
    }

    public Segment writableSegment(int i10) {
        if (i10 < 1 || i10 > 8192) {
            throw new IllegalArgumentException();
        }
        Segment segment = this.head;
        if (segment == null) {
            Segment take = SegmentPool.take();
            this.head = take;
            take.prev = take;
            take.next = take;
            return take;
        }
        Segment segment2 = segment.prev;
        if (segment2.limit + i10 > 8192 || !segment2.owner) {
            return segment2.push(SegmentPool.take());
        }
        return segment2;
    }

    public long writeAll(Source source) {
        if (source != null) {
            long j10 = 0;
            while (true) {
                long read = source.read(this, 8192);
                if (read == -1) {
                    return j10;
                }
                j10 += read;
            }
        } else {
            throw new IllegalArgumentException("source == null");
        }
    }

    public final Buffer writeTo(OutputStream outputStream) {
        return writeTo(outputStream, this.size);
    }

    public Buffer clone() {
        Buffer buffer = new Buffer();
        if (this.size == 0) {
            return buffer;
        }
        Segment sharedCopy = this.head.sharedCopy();
        buffer.head = sharedCopy;
        sharedCopy.prev = sharedCopy;
        sharedCopy.next = sharedCopy;
        Segment segment = this.head;
        while (true) {
            segment = segment.next;
            if (segment != this.head) {
                buffer.head.prev.push(segment.sharedCopy());
            } else {
                buffer.size = this.size;
                return buffer;
            }
        }
    }

    public final Buffer copyTo(OutputStream outputStream, long j10, long j11) {
        if (outputStream != null) {
            Util.checkOffsetAndCount(this.size, j10, j11);
            if (j11 == 0) {
                return this;
            }
            Segment segment = this.head;
            while (true) {
                int i10 = segment.limit;
                int i11 = segment.pos;
                if (j10 < ((long) (i10 - i11))) {
                    break;
                }
                j10 -= (long) (i10 - i11);
                segment = segment.next;
            }
            while (j11 > 0) {
                int i12 = (int) (((long) segment.pos) + j10);
                int min = (int) Math.min((long) (segment.limit - i12), j11);
                outputStream.write(segment.data, i12, min);
                j11 -= (long) min;
                segment = segment.next;
                j10 = 0;
            }
            return this;
        }
        throw new IllegalArgumentException("out == null");
    }

    public long indexOf(byte b10, long j10) {
        return indexOf(b10, j10, Long.MAX_VALUE);
    }

    public long indexOfElement(ByteString byteString, long j10) {
        int i10;
        int i11;
        long j11 = 0;
        if (j10 >= 0) {
            Segment segment = this.head;
            if (segment == null) {
                return -1;
            }
            long j12 = this.size;
            if (j12 - j10 < j10) {
                while (j12 > j10) {
                    segment = segment.prev;
                    j12 -= (long) (segment.limit - segment.pos);
                }
            } else {
                while (true) {
                    long j13 = ((long) (segment.limit - segment.pos)) + j11;
                    if (j13 >= j10) {
                        break;
                    }
                    segment = segment.next;
                    j11 = j13;
                }
                j12 = j11;
            }
            if (byteString.size() == 2) {
                byte b10 = byteString.getByte(0);
                byte b11 = byteString.getByte(1);
                while (j12 < this.size) {
                    byte[] bArr = segment.data;
                    i10 = (int) ((((long) segment.pos) + j10) - j12);
                    int i12 = segment.limit;
                    while (i10 < i12) {
                        byte b12 = bArr[i10];
                        if (b12 == b10 || b12 == b11) {
                            i11 = segment.pos;
                        } else {
                            i10++;
                        }
                    }
                    j12 += (long) (segment.limit - segment.pos);
                    segment = segment.next;
                    j10 = j12;
                }
                return -1;
            }
            byte[] internalArray = byteString.internalArray();
            while (j12 < this.size) {
                byte[] bArr2 = segment.data;
                int i13 = (int) ((((long) segment.pos) + j10) - j12);
                int i14 = segment.limit;
                while (i10 < i14) {
                    byte b13 = bArr2[i10];
                    int length = internalArray.length;
                    int i15 = 0;
                    while (i15 < length) {
                        if (b13 == internalArray[i15]) {
                            i11 = segment.pos;
                        } else {
                            i15++;
                        }
                    }
                    i13 = i10 + 1;
                }
                j12 += (long) (segment.limit - segment.pos);
                segment = segment.next;
                j10 = j12;
            }
            return -1;
            return ((long) (i10 - i11)) + j12;
        }
        throw new IllegalArgumentException("fromIndex < 0");
    }

    public boolean rangeEquals(long j10, ByteString byteString, int i10, int i11) {
        if (j10 < 0 || i10 < 0 || i11 < 0 || this.size - j10 < ((long) i11) || byteString.size() - i10 < i11) {
            return false;
        }
        for (int i12 = 0; i12 < i11; i12++) {
            if (getByte(((long) i12) + j10) != byteString.getByte(i10 + i12)) {
                return false;
            }
        }
        return true;
    }

    public int read(byte[] bArr, int i10, int i11) {
        Util.checkOffsetAndCount((long) bArr.length, (long) i10, (long) i11);
        Segment segment = this.head;
        if (segment == null) {
            return -1;
        }
        int min = Math.min(i11, segment.limit - segment.pos);
        System.arraycopy(segment.data, segment.pos, bArr, i10, min);
        int i12 = segment.pos + min;
        segment.pos = i12;
        this.size -= (long) min;
        if (i12 == segment.limit) {
            this.head = segment.pop();
            SegmentPool.recycle(segment);
        }
        return min;
    }

    public final UnsafeCursor readAndWriteUnsafe(UnsafeCursor unsafeCursor) {
        if (unsafeCursor.buffer == null) {
            unsafeCursor.buffer = this;
            unsafeCursor.readWrite = true;
            return unsafeCursor;
        }
        throw new IllegalStateException("already attached to a buffer");
    }

    public ByteString readByteString(long j10) {
        return new ByteString(readByteArray(j10));
    }

    public final Buffer readFrom(InputStream inputStream, long j10) {
        if (j10 >= 0) {
            readFrom(inputStream, j10, false);
            return this;
        }
        throw new IllegalArgumentException("byteCount < 0: " + j10);
    }

    public final UnsafeCursor readUnsafe(UnsafeCursor unsafeCursor) {
        if (unsafeCursor.buffer == null) {
            unsafeCursor.buffer = this;
            unsafeCursor.readWrite = false;
            return unsafeCursor;
        }
        throw new IllegalStateException("already attached to a buffer");
    }

    public String readUtf8LineStrict(long j10) {
        if (j10 >= 0) {
            long j11 = Long.MAX_VALUE;
            if (j10 != Long.MAX_VALUE) {
                j11 = j10 + 1;
            }
            long indexOf = indexOf((byte) 10, 0, j11);
            if (indexOf != -1) {
                return readUtf8Line(indexOf);
            }
            if (j11 < size() && getByte(j11 - 1) == 13 && getByte(j11) == 10) {
                return readUtf8Line(j11);
            }
            Buffer buffer = new Buffer();
            copyTo(buffer, 0, Math.min(32, size()));
            throw new EOFException("\\n not found: limit=" + Math.min(size(), j10) + " content=" + buffer.readByteString().hex() + 8230);
        }
        throw new IllegalArgumentException("limit < 0: " + j10);
    }

    public Buffer writeByte(int i10) {
        Segment writableSegment = writableSegment(1);
        byte[] bArr = writableSegment.data;
        int i11 = writableSegment.limit;
        writableSegment.limit = i11 + 1;
        bArr[i11] = (byte) i10;
        this.size++;
        return this;
    }

    public Buffer writeDecimalLong(long j10) {
        boolean z10;
        if (j10 == 0) {
            return writeByte(48);
        }
        int i10 = 1;
        if (j10 < 0) {
            j10 = -j10;
            if (j10 < 0) {
                return writeUtf8("-9223372036854775808");
            }
            z10 = true;
        } else {
            z10 = false;
        }
        if (j10 >= 100000000) {
            i10 = j10 < 1000000000000L ? j10 < 10000000000L ? j10 < 1000000000 ? 9 : 10 : j10 < 100000000000L ? 11 : 12 : j10 < 1000000000000000L ? j10 < 10000000000000L ? 13 : j10 < 100000000000000L ? 14 : 15 : j10 < 100000000000000000L ? j10 < 10000000000000000L ? 16 : 17 : j10 < 1000000000000000000L ? 18 : 19;
        } else if (j10 >= NotificationOptions.SKIP_STEP_TEN_SECONDS_IN_MS) {
            i10 = j10 < 1000000 ? j10 < 100000 ? 5 : 6 : j10 < 10000000 ? 7 : 8;
        } else if (j10 >= 100) {
            i10 = j10 < 1000 ? 3 : 4;
        } else if (j10 >= 10) {
            i10 = 2;
        }
        if (z10) {
            i10++;
        }
        Segment writableSegment = writableSegment(i10);
        byte[] bArr = writableSegment.data;
        int i11 = writableSegment.limit + i10;
        while (j10 != 0) {
            i11--;
            bArr[i11] = DIGITS[(int) (j10 % 10)];
            j10 /= 10;
        }
        if (z10) {
            bArr[i11 - 1] = 45;
        }
        writableSegment.limit += i10;
        this.size += (long) i10;
        return this;
    }

    public Buffer writeHexadecimalUnsignedLong(long j10) {
        if (j10 == 0) {
            return writeByte(48);
        }
        int numberOfTrailingZeros = (Long.numberOfTrailingZeros(Long.highestOneBit(j10)) / 4) + 1;
        Segment writableSegment = writableSegment(numberOfTrailingZeros);
        byte[] bArr = writableSegment.data;
        int i10 = writableSegment.limit;
        for (int i11 = (i10 + numberOfTrailingZeros) - 1; i11 >= i10; i11--) {
            bArr[i11] = DIGITS[(int) (15 & j10)];
            j10 >>>= 4;
        }
        writableSegment.limit += numberOfTrailingZeros;
        this.size += (long) numberOfTrailingZeros;
        return this;
    }

    public Buffer writeInt(int i10) {
        Segment writableSegment = writableSegment(4);
        byte[] bArr = writableSegment.data;
        int i11 = writableSegment.limit;
        int i12 = i11 + 1;
        bArr[i11] = (byte) ((i10 >>> 24) & 255);
        int i13 = i12 + 1;
        bArr[i12] = (byte) ((i10 >>> 16) & 255);
        int i14 = i13 + 1;
        bArr[i13] = (byte) ((i10 >>> 8) & 255);
        bArr[i14] = (byte) (i10 & 255);
        writableSegment.limit = i14 + 1;
        this.size += 4;
        return this;
    }

    public Buffer writeIntLe(int i10) {
        return writeInt(Util.reverseBytesInt(i10));
    }

    public Buffer writeLong(long j10) {
        Segment writableSegment = writableSegment(8);
        byte[] bArr = writableSegment.data;
        int i10 = writableSegment.limit;
        int i11 = i10 + 1;
        bArr[i10] = (byte) ((int) ((j10 >>> 56) & 255));
        int i12 = i11 + 1;
        bArr[i11] = (byte) ((int) ((j10 >>> 48) & 255));
        int i13 = i12 + 1;
        bArr[i12] = (byte) ((int) ((j10 >>> 40) & 255));
        int i14 = i13 + 1;
        bArr[i13] = (byte) ((int) ((j10 >>> 32) & 255));
        int i15 = i14 + 1;
        bArr[i14] = (byte) ((int) ((j10 >>> 24) & 255));
        int i16 = i15 + 1;
        bArr[i15] = (byte) ((int) ((j10 >>> 16) & 255));
        int i17 = i16 + 1;
        bArr[i16] = (byte) ((int) ((j10 >>> 8) & 255));
        bArr[i17] = (byte) ((int) (j10 & 255));
        writableSegment.limit = i17 + 1;
        this.size += 8;
        return this;
    }

    public Buffer writeLongLe(long j10) {
        return writeLong(Util.reverseBytesLong(j10));
    }

    public Buffer writeShort(int i10) {
        Segment writableSegment = writableSegment(2);
        byte[] bArr = writableSegment.data;
        int i11 = writableSegment.limit;
        int i12 = i11 + 1;
        bArr[i11] = (byte) ((i10 >>> 8) & 255);
        bArr[i12] = (byte) (i10 & 255);
        writableSegment.limit = i12 + 1;
        this.size += 2;
        return this;
    }

    public Buffer writeShortLe(int i10) {
        return writeShort((int) Util.reverseBytesShort((short) i10));
    }

    public final Buffer writeTo(OutputStream outputStream, long j10) {
        if (outputStream != null) {
            Util.checkOffsetAndCount(this.size, 0, j10);
            Segment segment = this.head;
            while (j10 > 0) {
                int min = (int) Math.min(j10, (long) (segment.limit - segment.pos));
                outputStream.write(segment.data, segment.pos, min);
                int i10 = segment.pos + min;
                segment.pos = i10;
                long j11 = (long) min;
                this.size -= j11;
                j10 -= j11;
                if (i10 == segment.limit) {
                    Segment pop = segment.pop();
                    this.head = pop;
                    SegmentPool.recycle(segment);
                    segment = pop;
                }
            }
            return this;
        }
        throw new IllegalArgumentException("out == null");
    }

    public Buffer writeUtf8CodePoint(int i10) {
        if (i10 < 128) {
            writeByte(i10);
        } else if (i10 < 2048) {
            writeByte((i10 >> 6) | 192);
            writeByte((i10 & 63) | 128);
        } else if (i10 < 65536) {
            if (i10 < 55296 || i10 > 57343) {
                writeByte((i10 >> 12) | 224);
                writeByte(((i10 >> 6) & 63) | 128);
                writeByte((i10 & 63) | 128);
            } else {
                writeByte(63);
            }
        } else if (i10 <= 1114111) {
            writeByte((i10 >> 18) | 240);
            writeByte(((i10 >> 12) & 63) | 128);
            writeByte(((i10 >> 6) & 63) | 128);
            writeByte((i10 & 63) | 128);
        } else {
            throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i10));
        }
        return this;
    }

    public long indexOf(byte b10, long j10, long j11) {
        Segment segment;
        long j12 = 0;
        if (j10 < 0 || j11 < j10) {
            throw new IllegalArgumentException(String.format("size=%s fromIndex=%s toIndex=%s", new Object[]{Long.valueOf(this.size), Long.valueOf(j10), Long.valueOf(j11)}));
        }
        long j13 = this.size;
        long j14 = j11 > j13 ? j13 : j11;
        if (j10 == j14 || (segment = this.head) == null) {
            return -1;
        }
        if (j13 - j10 < j10) {
            while (j13 > j10) {
                segment = segment.prev;
                j13 -= (long) (segment.limit - segment.pos);
            }
        } else {
            while (true) {
                long j15 = ((long) (segment.limit - segment.pos)) + j12;
                if (j15 >= j10) {
                    break;
                }
                segment = segment.next;
                j12 = j15;
            }
            j13 = j12;
        }
        long j16 = j10;
        while (j13 < j14) {
            byte[] bArr = segment.data;
            int min = (int) Math.min((long) segment.limit, (((long) segment.pos) + j14) - j13);
            for (int i10 = (int) ((((long) segment.pos) + j16) - j13); i10 < min; i10++) {
                if (bArr[i10] == b10) {
                    return ((long) (i10 - segment.pos)) + j13;
                }
            }
            byte b11 = b10;
            j13 += (long) (segment.limit - segment.pos);
            segment = segment.next;
            j16 = j13;
        }
        return -1;
    }

    public byte[] readByteArray(long j10) {
        Util.checkOffsetAndCount(this.size, 0, j10);
        if (j10 <= TTL.MAX_VALUE) {
            byte[] bArr = new byte[((int) j10)];
            readFully(bArr);
            return bArr;
        }
        throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j10);
    }

    public String readString(long j10, Charset charset) {
        Util.checkOffsetAndCount(this.size, 0, j10);
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        } else if (j10 > TTL.MAX_VALUE) {
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j10);
        } else if (j10 == 0) {
            return "";
        } else {
            Segment segment = this.head;
            int i10 = segment.pos;
            if (((long) i10) + j10 > ((long) segment.limit)) {
                return new String(readByteArray(j10), charset);
            }
            String str = new String(segment.data, i10, (int) j10, charset);
            int i11 = (int) (((long) segment.pos) + j10);
            segment.pos = i11;
            this.size -= j10;
            if (i11 == segment.limit) {
                this.head = segment.pop();
                SegmentPool.recycle(segment);
            }
            return str;
        }
    }

    public String readUtf8(long j10) {
        return readString(j10, Util.UTF_8);
    }

    public Buffer writeString(String str, Charset charset) {
        return writeString(str, 0, str.length(), charset);
    }

    public Buffer writeUtf8(String str) {
        return writeUtf8(str, 0, str.length());
    }

    private void readFrom(InputStream inputStream, long j10, boolean z10) {
        if (inputStream != null) {
            while (true) {
                if (j10 > 0 || z10) {
                    Segment writableSegment = writableSegment(1);
                    int read = inputStream.read(writableSegment.data, writableSegment.limit, (int) Math.min(j10, (long) (8192 - writableSegment.limit)));
                    if (read == -1) {
                        if (writableSegment.pos == writableSegment.limit) {
                            this.head = writableSegment.pop();
                            SegmentPool.recycle(writableSegment);
                        }
                        if (!z10) {
                            throw new EOFException();
                        }
                        return;
                    }
                    writableSegment.limit += read;
                    long j11 = (long) read;
                    this.size += j11;
                    j10 -= j11;
                } else {
                    return;
                }
            }
        } else {
            throw new IllegalArgumentException("in == null");
        }
    }

    public String readUtf8Line(long j10) {
        if (j10 > 0) {
            long j11 = j10 - 1;
            if (getByte(j11) == 13) {
                String readUtf8 = readUtf8(j11);
                skip(2);
                return readUtf8;
            }
        }
        String readUtf82 = readUtf8(j10);
        skip(1);
        return readUtf82;
    }

    public final ByteString snapshot(int i10) {
        if (i10 == 0) {
            return ByteString.EMPTY;
        }
        return new SegmentedByteString(this, i10);
    }

    public Buffer write(ByteString byteString) {
        if (byteString != null) {
            byteString.write(this);
            return this;
        }
        throw new IllegalArgumentException("byteString == null");
    }

    public Buffer writeString(String str, int i10, int i11, Charset charset) {
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        } else if (i10 < 0) {
            throw new IllegalAccessError("beginIndex < 0: " + i10);
        } else if (i11 < i10) {
            throw new IllegalArgumentException("endIndex < beginIndex: " + i11 + " < " + i10);
        } else if (i11 > str.length()) {
            throw new IllegalArgumentException("endIndex > string.length: " + i11 + " > " + str.length());
        } else if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        } else if (charset.equals(Util.UTF_8)) {
            return writeUtf8(str, i10, i11);
        } else {
            byte[] bytes = str.substring(i10, i11).getBytes(charset);
            return write(bytes, 0, bytes.length);
        }
    }

    public Buffer writeUtf8(String str, int i10, int i11) {
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        } else if (i10 < 0) {
            throw new IllegalArgumentException("beginIndex < 0: " + i10);
        } else if (i11 < i10) {
            throw new IllegalArgumentException("endIndex < beginIndex: " + i11 + " < " + i10);
        } else if (i11 <= str.length()) {
            while (i10 < i11) {
                char charAt = str.charAt(i10);
                if (charAt < 128) {
                    Segment writableSegment = writableSegment(1);
                    byte[] bArr = writableSegment.data;
                    int i12 = writableSegment.limit - i10;
                    int min = Math.min(i11, 8192 - i12);
                    int i13 = i10 + 1;
                    bArr[i10 + i12] = (byte) charAt;
                    while (i13 < min) {
                        char charAt2 = str.charAt(i13);
                        if (charAt2 >= 128) {
                            break;
                        }
                        bArr[i13 + i12] = (byte) charAt2;
                        i13++;
                    }
                    int i14 = writableSegment.limit;
                    int i15 = (i12 + i13) - i14;
                    writableSegment.limit = i14 + i15;
                    this.size += (long) i15;
                    i10 = i13;
                } else {
                    if (charAt < 2048) {
                        writeByte((charAt >> 6) | 192);
                        writeByte((int) (charAt & '?') | 128);
                    } else if (charAt < 55296 || charAt > 57343) {
                        writeByte((charAt >> 12) | 224);
                        writeByte(((charAt >> 6) & 63) | 128);
                        writeByte((int) (charAt & '?') | 128);
                    } else {
                        int i16 = i10 + 1;
                        char charAt3 = i16 < i11 ? str.charAt(i16) : 0;
                        if (charAt > 56319 || charAt3 < 56320 || charAt3 > 57343) {
                            writeByte(63);
                            i10 = i16;
                        } else {
                            int i17 = (((charAt & 10239) << 10) | (9215 & charAt3)) + Ascii.MIN;
                            writeByte((i17 >> 18) | 240);
                            writeByte(((i17 >> 12) & 63) | 128);
                            writeByte(((i17 >> 6) & 63) | 128);
                            writeByte((i17 & 63) | 128);
                            i10 += 2;
                        }
                    }
                    i10++;
                }
            }
            return this;
        } else {
            throw new IllegalArgumentException("endIndex > string.length: " + i11 + " > " + str.length());
        }
    }

    private boolean rangeEquals(Segment segment, int i10, ByteString byteString, int i11, int i12) {
        int i13 = segment.limit;
        byte[] bArr = segment.data;
        while (i11 < i12) {
            if (i10 == i13) {
                segment = segment.next;
                byte[] bArr2 = segment.data;
                int i14 = segment.pos;
                bArr = bArr2;
                i10 = i14;
                i13 = segment.limit;
            }
            if (bArr[i10] != byteString.getByte(i11)) {
                return false;
            }
            i10++;
            i11++;
        }
        return true;
    }

    public void readFully(byte[] bArr) {
        int i10 = 0;
        while (i10 < bArr.length) {
            int read = read(bArr, i10, bArr.length - i10);
            if (read != -1) {
                i10 += read;
            } else {
                throw new EOFException();
            }
        }
    }

    public Buffer write(byte[] bArr) {
        if (bArr != null) {
            return write(bArr, 0, bArr.length);
        }
        throw new IllegalArgumentException("source == null");
    }

    public Buffer write(byte[] bArr, int i10, int i11) {
        if (bArr != null) {
            long j10 = (long) i11;
            Util.checkOffsetAndCount((long) bArr.length, (long) i10, j10);
            int i12 = i11 + i10;
            while (i10 < i12) {
                Segment writableSegment = writableSegment(1);
                int min = Math.min(i12 - i10, 8192 - writableSegment.limit);
                System.arraycopy(bArr, i10, writableSegment.data, writableSegment.limit, min);
                i10 += min;
                writableSegment.limit += min;
            }
            this.size += j10;
            return this;
        }
        throw new IllegalArgumentException("source == null");
    }

    public final Buffer copyTo(Buffer buffer, long j10, long j11) {
        if (buffer != null) {
            Util.checkOffsetAndCount(this.size, j10, j11);
            if (j11 == 0) {
                return this;
            }
            buffer.size += j11;
            Segment segment = this.head;
            while (true) {
                int i10 = segment.limit;
                int i11 = segment.pos;
                if (j10 < ((long) (i10 - i11))) {
                    break;
                }
                j10 -= (long) (i10 - i11);
                segment = segment.next;
            }
            while (j11 > 0) {
                Segment sharedCopy = segment.sharedCopy();
                int i12 = (int) (((long) sharedCopy.pos) + j10);
                sharedCopy.pos = i12;
                sharedCopy.limit = Math.min(i12 + ((int) j11), sharedCopy.limit);
                Segment segment2 = buffer.head;
                if (segment2 == null) {
                    sharedCopy.prev = sharedCopy;
                    sharedCopy.next = sharedCopy;
                    buffer.head = sharedCopy;
                } else {
                    segment2.prev.push(sharedCopy);
                }
                j11 -= (long) (sharedCopy.limit - sharedCopy.pos);
                segment = segment.next;
                j10 = 0;
            }
            return this;
        }
        throw new IllegalArgumentException("out == null");
    }

    public int read(ByteBuffer byteBuffer) {
        Segment segment = this.head;
        if (segment == null) {
            return -1;
        }
        int min = Math.min(byteBuffer.remaining(), segment.limit - segment.pos);
        byteBuffer.put(segment.data, segment.pos, min);
        int i10 = segment.pos + min;
        segment.pos = i10;
        this.size -= (long) min;
        if (i10 == segment.limit) {
            this.head = segment.pop();
            SegmentPool.recycle(segment);
        }
        return min;
    }

    public int write(ByteBuffer byteBuffer) {
        if (byteBuffer != null) {
            int remaining = byteBuffer.remaining();
            int i10 = remaining;
            while (i10 > 0) {
                Segment writableSegment = writableSegment(1);
                int min = Math.min(i10, 8192 - writableSegment.limit);
                byteBuffer.get(writableSegment.data, writableSegment.limit, min);
                i10 -= min;
                writableSegment.limit += min;
            }
            this.size += (long) remaining;
            return remaining;
        }
        throw new IllegalArgumentException("source == null");
    }

    public long indexOf(ByteString byteString) {
        return indexOf(byteString, 0);
    }

    public long indexOf(ByteString byteString, long j10) {
        byte[] bArr;
        if (byteString.size() != 0) {
            long j11 = 0;
            if (j10 >= 0) {
                Segment segment = this.head;
                long j12 = -1;
                if (segment == null) {
                    return -1;
                }
                long j13 = this.size;
                if (j13 - j10 < j10) {
                    while (j13 > j10) {
                        segment = segment.prev;
                        j13 -= (long) (segment.limit - segment.pos);
                    }
                } else {
                    while (true) {
                        long j14 = ((long) (segment.limit - segment.pos)) + j11;
                        if (j14 >= j10) {
                            break;
                        }
                        segment = segment.next;
                        j11 = j14;
                    }
                    j13 = j11;
                }
                byte b10 = byteString.getByte(0);
                int size2 = byteString.size();
                long j15 = 1 + (this.size - ((long) size2));
                long j16 = j10;
                Segment segment2 = segment;
                long j17 = j13;
                while (j17 < j15) {
                    byte[] bArr2 = segment2.data;
                    int min = (int) Math.min((long) segment2.limit, (((long) segment2.pos) + j15) - j17);
                    int i10 = (int) ((((long) segment2.pos) + j16) - j17);
                    while (i10 < min) {
                        if (bArr2[i10] == b10) {
                            bArr = bArr2;
                            if (rangeEquals(segment2, i10 + 1, byteString, 1, size2)) {
                                return ((long) (i10 - segment2.pos)) + j17;
                            }
                        } else {
                            bArr = bArr2;
                        }
                        i10++;
                        bArr2 = bArr;
                    }
                    j17 += (long) (segment2.limit - segment2.pos);
                    segment2 = segment2.next;
                    j16 = j17;
                    j12 = -1;
                }
                return j12;
            }
            throw new IllegalArgumentException("fromIndex < 0");
        }
        throw new IllegalArgumentException("bytes is empty");
    }

    public long read(Buffer buffer, long j10) {
        if (buffer == null) {
            throw new IllegalArgumentException("sink == null");
        } else if (j10 >= 0) {
            long j11 = this.size;
            if (j11 == 0) {
                return -1;
            }
            if (j10 > j11) {
                j10 = j11;
            }
            buffer.write(this, j10);
            return j10;
        } else {
            throw new IllegalArgumentException("byteCount < 0: " + j10);
        }
    }

    public BufferedSink write(Source source, long j10) {
        while (j10 > 0) {
            long read = source.read(this, j10);
            if (read != -1) {
                j10 -= read;
            } else {
                throw new EOFException();
            }
        }
        return this;
    }

    public void write(Buffer buffer, long j10) {
        int i10;
        if (buffer == null) {
            throw new IllegalArgumentException("source == null");
        } else if (buffer != this) {
            Util.checkOffsetAndCount(buffer.size, 0, j10);
            while (j10 > 0) {
                Segment segment = buffer.head;
                if (j10 < ((long) (segment.limit - segment.pos))) {
                    Segment segment2 = this.head;
                    Segment segment3 = segment2 != null ? segment2.prev : null;
                    if (segment3 != null && segment3.owner) {
                        long j11 = ((long) segment3.limit) + j10;
                        if (segment3.shared) {
                            i10 = 0;
                        } else {
                            i10 = segment3.pos;
                        }
                        if (j11 - ((long) i10) <= 8192) {
                            segment.writeTo(segment3, (int) j10);
                            buffer.size -= j10;
                            this.size += j10;
                            return;
                        }
                    }
                    buffer.head = segment.split((int) j10);
                }
                Segment segment4 = buffer.head;
                long j12 = (long) (segment4.limit - segment4.pos);
                buffer.head = segment4.pop();
                Segment segment5 = this.head;
                if (segment5 == null) {
                    this.head = segment4;
                    segment4.prev = segment4;
                    segment4.next = segment4;
                } else {
                    segment5.prev.push(segment4).compact();
                }
                buffer.size -= j12;
                this.size += j12;
                j10 -= j12;
            }
        } else {
            throw new IllegalArgumentException("source == this");
        }
    }
}
