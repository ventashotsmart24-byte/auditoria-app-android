package anet.channel.util;

import java.io.InputStream;

public class a extends InputStream {

    /* renamed from: a  reason: collision with root package name */
    private InputStream f4005a = null;

    /* renamed from: b  reason: collision with root package name */
    private long f4006b = 0;

    public a(InputStream inputStream) {
        if (inputStream != null) {
            this.f4005a = inputStream;
            return;
        }
        throw new NullPointerException("input stream cannot be null");
    }

    public long a() {
        return this.f4006b;
    }

    public int read() {
        this.f4006b++;
        return this.f4005a.read();
    }

    public int read(byte[] bArr, int i10, int i11) {
        int read = this.f4005a.read(bArr, i10, i11);
        if (read != -1) {
            this.f4006b += (long) read;
        }
        return read;
    }
}
