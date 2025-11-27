package com.raizlabs.android.dbflow.config;

import android.util.Log;

public class FlowLog {
    public static final String TAG = "FlowLog";
    private static Level level = Level.E;

    public enum Level {
        V {
            public void call(String str, String str2, Throwable th) {
            }
        },
        D {
            public void call(String str, String str2, Throwable th) {
            }
        },
        I {
            public void call(String str, String str2, Throwable th) {
            }
        },
        W {
            public void call(String str, String str2, Throwable th) {
            }
        },
        E {
            public void call(String str, String str2, Throwable th) {
                Log.e(str, str2, th);
            }
        },
        WTF {
            public void call(String str, String str2, Throwable th) {
                Log.wtf(str, str2, th);
            }
        };

        public abstract void call(String str, String str2, Throwable th);
    }

    public static boolean isEnabled(Level level2) {
        if (level2.ordinal() >= level.ordinal()) {
            return true;
        }
        return false;
    }

    public static void log(Level level2, String str) {
        log(level2, str, (Throwable) null);
    }

    public static void logError(Throwable th) {
        log(Level.E, th);
    }

    public static void setMinimumLoggingLevel(Level level2) {
        level = level2;
    }

    public static void log(Level level2, String str, Throwable th) {
        log(level2, TAG, str, th);
    }

    public static void log(Level level2, String str, String str2, Throwable th) {
        if (isEnabled(level2)) {
            level2.call(str, str2, th);
        }
    }

    public static void log(Level level2, Throwable th) {
        log(level2, TAG, "", th);
    }
}
