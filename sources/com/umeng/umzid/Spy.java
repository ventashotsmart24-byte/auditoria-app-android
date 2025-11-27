package com.umeng.umzid;

import android.content.Context;
import android.os.Build;

public class Spy {
    public static boolean initSuccess = true;

    static {
        try {
            System.loadLibrary("umeng-spy");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static String getID() {
        if (!initSuccess) {
            return null;
        }
        return getNativeID(Build.VERSION.SDK_INT >= 29);
    }

    public static native String getNativeID(boolean z10);

    public static native String getNativeLibraryVersion();

    public static native String getNativeTag(boolean z10, boolean z11, boolean z12);

    public static synchronized String getTag(Context context) {
        boolean z10;
        String nativeTag;
        synchronized (Spy.class) {
            boolean z11 = false;
            if (context != null) {
                try {
                    z10 = d.j(context);
                } catch (Throwable th) {
                    throw th;
                }
            } else {
                z10 = false;
            }
            boolean i10 = context != null ? d.i(context) : false;
            if (Build.VERSION.SDK_INT >= 29) {
                z11 = true;
            }
            nativeTag = getNativeTag(z10, i10, z11);
        }
        return nativeTag;
    }

    public static String getVersion() {
        if (initSuccess) {
            return getNativeLibraryVersion();
        }
        return null;
    }
}
