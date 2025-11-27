package com.umeng.message.proguard;

import com.umeng.message.common.UPLog;
import io.jsonwebtoken.Header;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public final class bq {
    public static void a(byte[] bArr, OutputStream outputStream) {
        GZIPOutputStream gZIPOutputStream = null;
        try {
            GZIPOutputStream gZIPOutputStream2 = new GZIPOutputStream(outputStream);
            try {
                gZIPOutputStream2.write(bArr);
                f.a((Closeable) gZIPOutputStream2);
            } catch (Throwable th) {
                th = th;
                gZIPOutputStream = gZIPOutputStream2;
                try {
                    UPLog.e(Header.COMPRESSION_ALGORITHM, th.getMessage());
                } finally {
                    f.a((Closeable) gZIPOutputStream);
                }
            }
        } catch (Throwable th2) {
            th = th2;
            UPLog.e(Header.COMPRESSION_ALGORITHM, th.getMessage());
        }
    }

    public static void b(byte[] bArr, OutputStream outputStream) {
        GZIPInputStream gZIPInputStream = null;
        try {
            GZIPInputStream gZIPInputStream2 = new GZIPInputStream(new ByteArrayInputStream(bArr));
            try {
                byte[] bArr2 = new byte[1024];
                while (true) {
                    int read = gZIPInputStream2.read(bArr2);
                    if (read != -1) {
                        outputStream.write(bArr2, 0, read);
                    } else {
                        f.a((Closeable) gZIPInputStream2);
                        return;
                    }
                }
            } catch (Throwable th) {
                th = th;
                gZIPInputStream = gZIPInputStream2;
                try {
                    UPLog.e("unzip", th.getMessage());
                } finally {
                    f.a((Closeable) gZIPInputStream);
                }
            }
        } catch (Throwable th2) {
            th = th2;
            UPLog.e("unzip", th.getMessage());
        }
    }
}
