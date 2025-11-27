package com.google.common.io;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import java.io.FilterOutputStream;
import java.io.OutputStream;

@ElementTypesAreNonnullByDefault
@GwtIncompatible
public final class CountingOutputStream extends FilterOutputStream {
    private long count;

    public CountingOutputStream(OutputStream outputStream) {
        super((OutputStream) Preconditions.checkNotNull(outputStream));
    }

    public void close() {
        this.out.close();
    }

    public long getCount() {
        return this.count;
    }

    public void write(byte[] bArr, int i10, int i11) {
        this.out.write(bArr, i10, i11);
        this.count += (long) i11;
    }

    public void write(int i10) {
        this.out.write(i10);
        this.count++;
    }
}
