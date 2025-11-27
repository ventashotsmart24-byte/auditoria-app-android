package com.google.firebase.platforminfo;

import h9.e;

public final class KotlinDetector {
    private KotlinDetector() {
    }

    public static String detectVersion() {
        try {
            return e.f17309f.toString();
        } catch (NoClassDefFoundError unused) {
            return null;
        }
    }
}
