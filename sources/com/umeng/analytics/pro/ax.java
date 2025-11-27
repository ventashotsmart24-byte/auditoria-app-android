package com.umeng.analytics.pro;

import com.google.common.primitives.UnsignedBytes;
import com.umeng.commonsdk.debug.UMRTLog;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class ax {
    public static byte[] a(byte[] bArr, byte[] bArr2) {
        if (!(bArr == null || bArr.length == 0 || bArr2 == null || bArr2.length == 0)) {
            for (int i10 = 0; i10 < bArr.length; i10++) {
                bArr[i10] = (byte) ((bArr[i10] ^ bArr2[i10 % bArr2.length]) ^ (i10 & UnsignedBytes.MAX_VALUE));
            }
        }
        return bArr;
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
                        as.a((Closeable) gZIPInputStream2);
                        return;
                    }
                }
            } catch (Throwable th) {
                th = th;
                gZIPInputStream = gZIPInputStream2;
                try {
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "unGzip error: " + th.getMessage());
                } finally {
                    as.a((Closeable) gZIPInputStream);
                }
            }
        } catch (Throwable th2) {
            th = th2;
            UMRTLog.e(UMRTLog.RTLOG_TAG, "unGzip error: " + th.getMessage());
        }
    }

    public static void a(byte[] bArr, OutputStream outputStream) {
        GZIPOutputStream gZIPOutputStream = null;
        try {
            GZIPOutputStream gZIPOutputStream2 = new GZIPOutputStream(outputStream);
            try {
                gZIPOutputStream2.write(bArr);
                as.a((Closeable) gZIPOutputStream2);
            } catch (Throwable th) {
                th = th;
                gZIPOutputStream = gZIPOutputStream2;
                try {
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "gzip error: " + th.getMessage());
                } finally {
                    as.a((Closeable) gZIPOutputStream);
                }
            }
        } catch (Throwable th2) {
            th = th2;
            UMRTLog.e(UMRTLog.RTLOG_TAG, "gzip error: " + th.getMessage());
        }
    }
}
