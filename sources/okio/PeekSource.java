package okio;

final class PeekSource implements Source {
    private final Buffer buffer;
    private boolean closed;
    private int expectedPos;
    private Segment expectedSegment;
    private long pos;
    private final BufferedSource upstream;

    public PeekSource(BufferedSource bufferedSource) {
        int i10;
        this.upstream = bufferedSource;
        Buffer buffer2 = bufferedSource.buffer();
        this.buffer = buffer2;
        Segment segment = buffer2.head;
        this.expectedSegment = segment;
        if (segment != null) {
            i10 = segment.pos;
        } else {
            i10 = -1;
        }
        this.expectedPos = i10;
    }

    public void close() {
        this.closed = true;
    }

    public long read(Buffer buffer2, long j10) {
        Segment segment;
        Segment segment2;
        if (j10 < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j10);
        } else if (!this.closed) {
            Segment segment3 = this.expectedSegment;
            if (segment3 != null && (segment3 != (segment2 = this.buffer.head) || this.expectedPos != segment2.pos)) {
                throw new IllegalStateException("Peek source is invalid because upstream source was used");
            } else if (j10 == 0) {
                return 0;
            } else {
                if (!this.upstream.request(this.pos + 1)) {
                    return -1;
                }
                if (this.expectedSegment == null && (segment = this.buffer.head) != null) {
                    this.expectedSegment = segment;
                    this.expectedPos = segment.pos;
                }
                long min = Math.min(j10, this.buffer.size - this.pos);
                this.buffer.copyTo(buffer2, this.pos, min);
                this.pos += min;
                return min;
            }
        } else {
            throw new IllegalStateException("closed");
        }
    }

    public Timeout timeout() {
        return this.upstream.timeout();
    }
}
