package com.uc.crashsdk.a;

import android.util.Log;
import com.uc.crashsdk.JNIBridge;
import com.uc.crashsdk.b;
import com.uc.crashsdk.g;

public final class a {
    public static void a(String str) {
        g.P();
    }

    public static void b(String str) {
        g.P();
    }

    public static void c(String str, String str2) {
        if (b.f13531d) {
            JNIBridge.nativeLog(5, str, str2);
        }
    }

    public static void d(String str, String str2) {
        if (b.f13531d) {
            JNIBridge.nativeLog(6, str, str2);
        } else {
            Log.e(str, str2);
        }
    }

    public static void a(String str, String str2) {
        g.P();
    }

    public static void b(String str, String str2) {
        if (b.f13531d) {
            JNIBridge.nativeLog(4, str, str2);
        }
    }

    public static void a(String str, String str2, Throwable th) {
        if (!g.P()) {
            return;
        }
        if (th == null) {
            Log.e(str, str2);
        } else {
            Log.e(str, str2, th);
        }
    }
}
