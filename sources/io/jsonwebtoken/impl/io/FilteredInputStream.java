package io.jsonwebtoken.impl.io;

import io.jsonwebtoken.impl.lang.Bytes;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public abstract class FilteredInputStream extends FilterInputStream {
    public FilteredInputStream(InputStream inputStream) {
        super(inputStream);
    }

    public void afterRead(int i10) {
    }

    public int available() {
        try {
            return super.available();
        } catch (Throwable th) {
            onThrowable(th);
            return 0;
        }
    }

    public void beforeRead(int i10) {
    }

    public void close() {
        try {
            super.close();
        } catch (Throwable th) {
            onThrowable(th);
        }
    }

    public synchronized void mark(int i10) {
        this.in.mark(i10);
    }

    public boolean markSupported() {
        return this.in.markSupported();
    }

    public void onThrowable(Throwable th) {
        if (th instanceof IOException) {
            throw ((IOException) th);
        }
        throw new IOException("IO Exception: " + th.getMessage(), th);
    }

    public int read() {
        int i10 = 1;
        try {
            beforeRead(1);
            int read = this.in.read();
            if (read == -1) {
                i10 = -1;
            }
            afterRead(i10);
            return read;
        } catch (Throwable th) {
            onThrowable(th);
            return -1;
        }
    }

    public synchronized void reset() {
        try {
            this.in.reset();
        } catch (Throwable th) {
            onThrowable(th);
        }
        return;
    }

    public long skip(long j10) {
        try {
            return this.in.skip(j10);
        } catch (Throwable th) {
            onThrowable(th);
            return 0;
        }
    }

    public int read(byte[] bArr) {
        try {
            beforeRead(Bytes.length(bArr));
            int read = this.in.read(bArr);
            afterRead(read);
            return read;
        } catch (Throwable th) {
            onThrowable(th);
            return -1;
        }
    }

    public int read(byte[] bArr, int i10, int i11) {
        try {
            beforeRead(i11);
            int read = this.in.read(bArr, i10, i11);
            afterRead(read);
            return read;
        } catch (Throwable th) {
            onThrowable(th);
            return -1;
        }
    }
}
