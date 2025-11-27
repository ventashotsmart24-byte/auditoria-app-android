package okhttp3.internal.cache2;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.ByteString;
import okio.Source;
import okio.Timeout;

final class Relay {
    private static final long FILE_HEADER_SIZE = 32;
    static final ByteString PREFIX_CLEAN = ByteString.encodeUtf8("OkHttp cache v1\n");
    static final ByteString PREFIX_DIRTY = ByteString.encodeUtf8("OkHttp DIRTY :(\n");
    private static final int SOURCE_FILE = 2;
    private static final int SOURCE_UPSTREAM = 1;
    final Buffer buffer = new Buffer();
    final long bufferMaxSize;
    boolean complete;
    RandomAccessFile file;
    private final ByteString metadata;
    int sourceCount;
    Source upstream;
    final Buffer upstreamBuffer = new Buffer();
    long upstreamPos;
    Thread upstreamReader;

    public class RelaySource implements Source {
        private FileOperator fileOperator;
        private long sourcePos;
        private final Timeout timeout = new Timeout();

        public RelaySource() {
            this.fileOperator = new FileOperator(Relay.this.file.getChannel());
        }

        public void close() {
            if (this.fileOperator != null) {
                RandomAccessFile randomAccessFile = null;
                this.fileOperator = null;
                synchronized (Relay.this) {
                    Relay relay = Relay.this;
                    int i10 = relay.sourceCount - 1;
                    relay.sourceCount = i10;
                    if (i10 == 0) {
                        RandomAccessFile randomAccessFile2 = relay.file;
                        relay.file = null;
                        randomAccessFile = randomAccessFile2;
                    }
                }
                if (randomAccessFile != null) {
                    Util.closeQuietly((Closeable) randomAccessFile);
                }
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:16:0x002f, code lost:
            r0 = 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0031, code lost:
            r5 = r7 - r0.buffer.size();
            r12 = r1.sourcePos;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x003d, code lost:
            if (r12 >= r5) goto L_0x00fc;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0040, code lost:
            r0 = 2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:74:?, code lost:
            r2 = java.lang.Math.min(r2, r7 - r12);
            r1.this$0.buffer.copyTo(r22, r1.sourcePos - r5, r2);
            r1.sourcePos += r2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:76:0x0115, code lost:
            return r2;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public long read(okio.Buffer r22, long r23) {
            /*
                r21 = this;
                r1 = r21
                r2 = r23
                okhttp3.internal.cache2.FileOperator r0 = r1.fileOperator
                if (r0 == 0) goto L_0x0119
                okhttp3.internal.cache2.Relay r4 = okhttp3.internal.cache2.Relay.this
                monitor-enter(r4)
            L_0x000b:
                long r5 = r1.sourcePos     // Catch:{ all -> 0x0116 }
                okhttp3.internal.cache2.Relay r0 = okhttp3.internal.cache2.Relay.this     // Catch:{ all -> 0x0116 }
                long r7 = r0.upstreamPos     // Catch:{ all -> 0x0116 }
                r9 = 2
                r10 = -1
                int r12 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
                if (r12 != 0) goto L_0x0031
                boolean r5 = r0.complete     // Catch:{ all -> 0x0116 }
                if (r5 == 0) goto L_0x001e
                monitor-exit(r4)     // Catch:{ all -> 0x0116 }
                return r10
            L_0x001e:
                java.lang.Thread r5 = r0.upstreamReader     // Catch:{ all -> 0x0116 }
                if (r5 == 0) goto L_0x0028
                okio.Timeout r5 = r1.timeout     // Catch:{ all -> 0x0116 }
                r5.waitUntilNotified(r0)     // Catch:{ all -> 0x0116 }
                goto L_0x000b
            L_0x0028:
                java.lang.Thread r5 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0116 }
                r0.upstreamReader = r5     // Catch:{ all -> 0x0116 }
                monitor-exit(r4)     // Catch:{ all -> 0x0116 }
                r0 = 1
                goto L_0x0041
            L_0x0031:
                okio.Buffer r0 = r0.buffer     // Catch:{ all -> 0x0116 }
                long r5 = r0.size()     // Catch:{ all -> 0x0116 }
                long r5 = r7 - r5
                long r12 = r1.sourcePos     // Catch:{ all -> 0x0116 }
                int r0 = (r12 > r5 ? 1 : (r12 == r5 ? 0 : -1))
                if (r0 >= 0) goto L_0x00fc
                monitor-exit(r4)     // Catch:{ all -> 0x0116 }
                r0 = 2
            L_0x0041:
                r4 = 32
                if (r0 != r9) goto L_0x005e
                long r9 = r1.sourcePos
                long r7 = r7 - r9
                long r2 = java.lang.Math.min(r2, r7)
                okhttp3.internal.cache2.FileOperator r9 = r1.fileOperator
                long r6 = r1.sourcePos
                long r10 = r6 + r4
                r12 = r22
                r13 = r2
                r9.read(r10, r12, r13)
                long r4 = r1.sourcePos
                long r4 = r4 + r2
                r1.sourcePos = r4
                return r2
            L_0x005e:
                r6 = 0
                okhttp3.internal.cache2.Relay r0 = okhttp3.internal.cache2.Relay.this     // Catch:{ all -> 0x00ec }
                okio.Source r9 = r0.upstream     // Catch:{ all -> 0x00ec }
                okio.Buffer r12 = r0.upstreamBuffer     // Catch:{ all -> 0x00ec }
                long r13 = r0.bufferMaxSize     // Catch:{ all -> 0x00ec }
                long r12 = r9.read(r12, r13)     // Catch:{ all -> 0x00ec }
                int r0 = (r12 > r10 ? 1 : (r12 == r10 ? 0 : -1))
                if (r0 != 0) goto L_0x0083
                okhttp3.internal.cache2.Relay r0 = okhttp3.internal.cache2.Relay.this     // Catch:{ all -> 0x00ec }
                r0.commit(r7)     // Catch:{ all -> 0x00ec }
                okhttp3.internal.cache2.Relay r2 = okhttp3.internal.cache2.Relay.this
                monitor-enter(r2)
                okhttp3.internal.cache2.Relay r0 = okhttp3.internal.cache2.Relay.this     // Catch:{ all -> 0x0080 }
                r0.upstreamReader = r6     // Catch:{ all -> 0x0080 }
                r0.notifyAll()     // Catch:{ all -> 0x0080 }
                monitor-exit(r2)     // Catch:{ all -> 0x0080 }
                return r10
            L_0x0080:
                r0 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x0080 }
                throw r0
            L_0x0083:
                long r2 = java.lang.Math.min(r12, r2)     // Catch:{ all -> 0x00ec }
                okhttp3.internal.cache2.Relay r0 = okhttp3.internal.cache2.Relay.this     // Catch:{ all -> 0x00ec }
                okio.Buffer r14 = r0.upstreamBuffer     // Catch:{ all -> 0x00ec }
                r16 = 0
                r15 = r22
                r18 = r2
                r14.copyTo((okio.Buffer) r15, (long) r16, (long) r18)     // Catch:{ all -> 0x00ec }
                long r9 = r1.sourcePos     // Catch:{ all -> 0x00ec }
                long r9 = r9 + r2
                r1.sourcePos = r9     // Catch:{ all -> 0x00ec }
                okhttp3.internal.cache2.FileOperator r15 = r1.fileOperator     // Catch:{ all -> 0x00ec }
                long r16 = r7 + r4
                okhttp3.internal.cache2.Relay r0 = okhttp3.internal.cache2.Relay.this     // Catch:{ all -> 0x00ec }
                okio.Buffer r0 = r0.upstreamBuffer     // Catch:{ all -> 0x00ec }
                okio.Buffer r18 = r0.clone()     // Catch:{ all -> 0x00ec }
                r19 = r12
                r15.write(r16, r18, r19)     // Catch:{ all -> 0x00ec }
                okhttp3.internal.cache2.Relay r4 = okhttp3.internal.cache2.Relay.this     // Catch:{ all -> 0x00ec }
                monitor-enter(r4)     // Catch:{ all -> 0x00ec }
                okhttp3.internal.cache2.Relay r0 = okhttp3.internal.cache2.Relay.this     // Catch:{ all -> 0x00e9 }
                okio.Buffer r5 = r0.buffer     // Catch:{ all -> 0x00e9 }
                okio.Buffer r0 = r0.upstreamBuffer     // Catch:{ all -> 0x00e9 }
                r5.write((okio.Buffer) r0, (long) r12)     // Catch:{ all -> 0x00e9 }
                okhttp3.internal.cache2.Relay r0 = okhttp3.internal.cache2.Relay.this     // Catch:{ all -> 0x00e9 }
                okio.Buffer r0 = r0.buffer     // Catch:{ all -> 0x00e9 }
                long r7 = r0.size()     // Catch:{ all -> 0x00e9 }
                okhttp3.internal.cache2.Relay r0 = okhttp3.internal.cache2.Relay.this     // Catch:{ all -> 0x00e9 }
                long r9 = r0.bufferMaxSize     // Catch:{ all -> 0x00e9 }
                int r5 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
                if (r5 <= 0) goto L_0x00d4
                okio.Buffer r0 = r0.buffer     // Catch:{ all -> 0x00e9 }
                long r7 = r0.size()     // Catch:{ all -> 0x00e9 }
                okhttp3.internal.cache2.Relay r5 = okhttp3.internal.cache2.Relay.this     // Catch:{ all -> 0x00e9 }
                long r9 = r5.bufferMaxSize     // Catch:{ all -> 0x00e9 }
                long r7 = r7 - r9
                r0.skip(r7)     // Catch:{ all -> 0x00e9 }
            L_0x00d4:
                okhttp3.internal.cache2.Relay r5 = okhttp3.internal.cache2.Relay.this     // Catch:{ all -> 0x00e9 }
                long r7 = r5.upstreamPos     // Catch:{ all -> 0x00e9 }
                long r7 = r7 + r12
                r5.upstreamPos = r7     // Catch:{ all -> 0x00e9 }
                monitor-exit(r4)     // Catch:{ all -> 0x00e9 }
                monitor-enter(r5)
                okhttp3.internal.cache2.Relay r0 = okhttp3.internal.cache2.Relay.this     // Catch:{ all -> 0x00e6 }
                r0.upstreamReader = r6     // Catch:{ all -> 0x00e6 }
                r0.notifyAll()     // Catch:{ all -> 0x00e6 }
                monitor-exit(r5)     // Catch:{ all -> 0x00e6 }
                return r2
            L_0x00e6:
                r0 = move-exception
                monitor-exit(r5)     // Catch:{ all -> 0x00e6 }
                throw r0
            L_0x00e9:
                r0 = move-exception
                monitor-exit(r4)     // Catch:{ all -> 0x00e9 }
                throw r0     // Catch:{ all -> 0x00ec }
            L_0x00ec:
                r0 = move-exception
                okhttp3.internal.cache2.Relay r2 = okhttp3.internal.cache2.Relay.this
                monitor-enter(r2)
                okhttp3.internal.cache2.Relay r3 = okhttp3.internal.cache2.Relay.this     // Catch:{ all -> 0x00f9 }
                r3.upstreamReader = r6     // Catch:{ all -> 0x00f9 }
                r3.notifyAll()     // Catch:{ all -> 0x00f9 }
                monitor-exit(r2)     // Catch:{ all -> 0x00f9 }
                throw r0
            L_0x00f9:
                r0 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x00f9 }
                throw r0
            L_0x00fc:
                long r7 = r7 - r12
                long r2 = java.lang.Math.min(r2, r7)     // Catch:{ all -> 0x0116 }
                okhttp3.internal.cache2.Relay r0 = okhttp3.internal.cache2.Relay.this     // Catch:{ all -> 0x0116 }
                okio.Buffer r9 = r0.buffer     // Catch:{ all -> 0x0116 }
                long r7 = r1.sourcePos     // Catch:{ all -> 0x0116 }
                long r11 = r7 - r5
                r10 = r22
                r13 = r2
                r9.copyTo((okio.Buffer) r10, (long) r11, (long) r13)     // Catch:{ all -> 0x0116 }
                long r5 = r1.sourcePos     // Catch:{ all -> 0x0116 }
                long r5 = r5 + r2
                r1.sourcePos = r5     // Catch:{ all -> 0x0116 }
                monitor-exit(r4)     // Catch:{ all -> 0x0116 }
                return r2
            L_0x0116:
                r0 = move-exception
                monitor-exit(r4)     // Catch:{ all -> 0x0116 }
                throw r0
            L_0x0119:
                java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                java.lang.String r2 = "closed"
                r0.<init>(r2)
                goto L_0x0122
            L_0x0121:
                throw r0
            L_0x0122:
                goto L_0x0121
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.cache2.Relay.RelaySource.read(okio.Buffer, long):long");
        }

        public Timeout timeout() {
            return this.timeout;
        }
    }

    private Relay(RandomAccessFile randomAccessFile, Source source, long j10, ByteString byteString, long j11) {
        boolean z10;
        this.file = randomAccessFile;
        this.upstream = source;
        if (source == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        this.complete = z10;
        this.upstreamPos = j10;
        this.metadata = byteString;
        this.bufferMaxSize = j11;
    }

    public static Relay edit(File file2, Source source, ByteString byteString, long j10) {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file2, "rw");
        Relay relay = new Relay(randomAccessFile, source, 0, byteString, j10);
        randomAccessFile.setLength(0);
        relay.writeHeader(PREFIX_DIRTY, -1, -1);
        return relay;
    }

    public static Relay read(File file2) {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file2, "rw");
        FileOperator fileOperator = new FileOperator(randomAccessFile.getChannel());
        Buffer buffer2 = new Buffer();
        fileOperator.read(0, buffer2, 32);
        ByteString byteString = PREFIX_CLEAN;
        if (buffer2.readByteString((long) byteString.size()).equals(byteString)) {
            long readLong = buffer2.readLong();
            long readLong2 = buffer2.readLong();
            Buffer buffer3 = new Buffer();
            fileOperator.read(readLong + 32, buffer3, readLong2);
            return new Relay(randomAccessFile, (Source) null, readLong, buffer3.readByteString(), 0);
        }
        throw new IOException("unreadable cache file");
    }

    private void writeHeader(ByteString byteString, long j10, long j11) {
        Buffer buffer2 = new Buffer();
        buffer2.write(byteString);
        buffer2.writeLong(j10);
        buffer2.writeLong(j11);
        if (buffer2.size() == 32) {
            new FileOperator(this.file.getChannel()).write(0, buffer2, 32);
            return;
        }
        throw new IllegalArgumentException();
    }

    private void writeMetadata(long j10) {
        Buffer buffer2 = new Buffer();
        buffer2.write(this.metadata);
        new FileOperator(this.file.getChannel()).write(32 + j10, buffer2, (long) this.metadata.size());
    }

    public void commit(long j10) {
        writeMetadata(j10);
        this.file.getChannel().force(false);
        writeHeader(PREFIX_CLEAN, j10, (long) this.metadata.size());
        this.file.getChannel().force(false);
        synchronized (this) {
            this.complete = true;
        }
        Util.closeQuietly((Closeable) this.upstream);
        this.upstream = null;
    }

    public boolean isClosed() {
        if (this.file == null) {
            return true;
        }
        return false;
    }

    public ByteString metadata() {
        return this.metadata;
    }

    public Source newSource() {
        synchronized (this) {
            if (this.file == null) {
                return null;
            }
            this.sourceCount++;
            return new RelaySource();
        }
    }
}
