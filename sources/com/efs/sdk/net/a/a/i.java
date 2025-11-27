package com.efs.sdk.net.a.a;

import java.io.InputStream;
import java.io.OutputStream;

public final class i {
    public static void a(InputStream inputStream, OutputStream outputStream, byte[] bArr) {
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
            } else {
                return;
            }
        }
    }
}
