package io.jsonwebtoken.impl.io;

import java.io.FilterInputStream;
import java.io.InputStream;
import java.util.concurrent.atomic.AtomicLong;

public class CountingInputStream extends FilterInputStream {
    private final AtomicLong count = new AtomicLong(0);

    public CountingInputStream(InputStream inputStream) {
        super(inputStream);
    }

    private void add(long j10) {
        if (j10 > 0) {
            this.count.addAndGet(j10);
        }
    }

    public long getCount() {
        return this.count.get();
    }

    public int read() {
        int read = super.read();
        add(read == -1 ? -1 : 1);
        return read;
    }

    public long skip(long j10) {
        long skip = super.skip(j10);
        add(skip);
        return skip;
    }

    public int read(byte[] bArr) {
        int read = super.read(bArr);
        add((long) read);
        return read;
    }

    public int read(byte[] bArr, int i10, int i11) {
        int read = super.read(bArr, i10, i11);
        add((long) read);
        return read;
    }
}
