package com.bumptech.glide.util;

import java.io.FilterInputStream;
import java.io.InputStream;

public class MarkEnforcingInputStream extends FilterInputStream {
    private static final int END_OF_STREAM = -1;
    private static final int UNSET = Integer.MIN_VALUE;
    private int availableBytes = Integer.MIN_VALUE;

    public MarkEnforcingInputStream(InputStream inputStream) {
        super(inputStream);
    }

    private long getBytesToRead(long j10) {
        int i10 = this.availableBytes;
        if (i10 == 0) {
            return -1;
        }
        if (i10 == Integer.MIN_VALUE || j10 <= ((long) i10)) {
            return j10;
        }
        return (long) i10;
    }

    private void updateAvailableBytesAfterRead(long j10) {
        int i10 = this.availableBytes;
        if (i10 != Integer.MIN_VALUE && j10 != -1) {
            this.availableBytes = (int) (((long) i10) - j10);
        }
    }

    public int available() {
        int i10 = this.availableBytes;
        if (i10 == Integer.MIN_VALUE) {
            return super.available();
        }
        return Math.min(i10, super.available());
    }

    public synchronized void mark(int i10) {
        super.mark(i10);
        this.availableBytes = i10;
    }

    public int read() {
        if (getBytesToRead(1) == -1) {
            return -1;
        }
        int read = super.read();
        updateAvailableBytesAfterRead(1);
        return read;
    }

    public synchronized void reset() {
        super.reset();
        this.availableBytes = Integer.MIN_VALUE;
    }

    public long skip(long j10) {
        long bytesToRead = getBytesToRead(j10);
        if (bytesToRead == -1) {
            return 0;
        }
        long skip = super.skip(bytesToRead);
        updateAvailableBytesAfterRead(skip);
        return skip;
    }

    public int read(byte[] bArr, int i10, int i11) {
        int bytesToRead = (int) getBytesToRead((long) i11);
        if (bytesToRead == -1) {
            return -1;
        }
        int read = super.read(bArr, i10, bytesToRead);
        updateAvailableBytesAfterRead((long) read);
        return read;
    }
}
