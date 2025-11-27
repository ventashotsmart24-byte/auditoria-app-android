package io.jsonwebtoken.impl.io;

import io.jsonwebtoken.impl.lang.Bytes;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class FilteredOutputStream extends FilterOutputStream {
    public FilteredOutputStream(OutputStream outputStream) {
        super(outputStream);
    }

    public void afterWrite(int i10) {
    }

    public void beforeWrite(int i10) {
    }

    public void close() {
        try {
            super.close();
        } catch (Throwable th) {
            onThrowable(th);
        }
    }

    public void flush() {
        try {
            this.out.flush();
        } catch (Throwable th) {
            onThrowable(th);
        }
    }

    public void onThrowable(Throwable th) {
        if (th instanceof IOException) {
            throw ((IOException) th);
        }
        throw new IOException("IO Exception " + th.getMessage(), th);
    }

    public void write(byte[] bArr) {
        try {
            int length = Bytes.length(bArr);
            beforeWrite(length);
            this.out.write(bArr);
            afterWrite(length);
        } catch (Throwable th) {
            onThrowable(th);
        }
    }

    public void write(byte[] bArr, int i10, int i11) {
        try {
            beforeWrite(i11);
            this.out.write(bArr, i10, i11);
            afterWrite(i11);
        } catch (Throwable th) {
            onThrowable(th);
        }
    }

    public void write(int i10) {
        try {
            beforeWrite(1);
            this.out.write(i10);
            afterWrite(1);
        } catch (Throwable th) {
            onThrowable(th);
        }
    }
}
