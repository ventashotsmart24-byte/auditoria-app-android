package com.google.protobuf;

final class Android {
    private static boolean ASSUME_ANDROID;
    private static final boolean IS_ROBOLECTRIC;
    private static final Class<?> MEMORY_CLASS = getClassForName("libcore.io.Memory");

    static {
        boolean z10;
        if (ASSUME_ANDROID || getClassForName("org.robolectric.Robolectric") == null) {
            z10 = false;
        } else {
            z10 = true;
        }
        IS_ROBOLECTRIC = z10;
    }

    private Android() {
    }

    private static <T> Class<T> getClassForName(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Class<?> getMemoryClass() {
        return MEMORY_CLASS;
    }

    public static boolean isOnAndroidDevice() {
        if (ASSUME_ANDROID || (MEMORY_CLASS != null && !IS_ROBOLECTRIC)) {
            return true;
        }
        return false;
    }
}
