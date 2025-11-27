package com.umeng.analytics.pro;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ds extends du {

    /* renamed from: a  reason: collision with root package name */
    protected InputStream f14171a;

    /* renamed from: b  reason: collision with root package name */
    protected OutputStream f14172b;

    public ds() {
        this.f14171a = null;
        this.f14172b = null;
    }

    public boolean a() {
        return true;
    }

    public void b() {
    }

    public void c() {
        InputStream inputStream = this.f14171a;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e10) {
                e10.printStackTrace();
            }
            this.f14171a = null;
        }
        OutputStream outputStream = this.f14172b;
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException e11) {
                e11.printStackTrace();
            }
            this.f14172b = null;
        }
    }

    public void d() {
        OutputStream outputStream = this.f14172b;
        if (outputStream != null) {
            try {
                outputStream.flush();
            } catch (IOException e10) {
                throw new dv(0, (Throwable) e10);
            }
        } else {
            throw new dv(1, "Cannot flush null outputStream");
        }
    }

    public int a(byte[] bArr, int i10, int i11) {
        InputStream inputStream = this.f14171a;
        if (inputStream != null) {
            try {
                int read = inputStream.read(bArr, i10, i11);
                if (read >= 0) {
                    return read;
                }
                throw new dv(4);
            } catch (IOException e10) {
                throw new dv(0, (Throwable) e10);
            }
        } else {
            throw new dv(1, "Cannot read from null inputStream");
        }
    }

    public void b(byte[] bArr, int i10, int i11) {
        OutputStream outputStream = this.f14172b;
        if (outputStream != null) {
            try {
                outputStream.write(bArr, i10, i11);
            } catch (IOException e10) {
                throw new dv(0, (Throwable) e10);
            }
        } else {
            throw new dv(1, "Cannot write to null outputStream");
        }
    }

    public ds(InputStream inputStream) {
        this.f14172b = null;
        this.f14171a = inputStream;
    }

    public ds(OutputStream outputStream) {
        this.f14171a = null;
        this.f14172b = outputStream;
    }

    public ds(InputStream inputStream, OutputStream outputStream) {
        this.f14171a = inputStream;
        this.f14172b = outputStream;
    }
}
