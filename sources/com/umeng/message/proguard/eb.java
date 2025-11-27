package com.umeng.message.proguard;

import java.io.Closeable;

public final class eb {
    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }
}
