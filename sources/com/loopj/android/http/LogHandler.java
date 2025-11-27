package com.loopj.android.http;

import android.os.Build;
import android.util.Log;

public class LogHandler implements LogInterface {
    boolean mLoggingEnabled = true;
    int mLoggingLevel = 2;

    private void checkedWtf(String str, String str2, Throwable th) {
        Log.wtf(str, str2, th);
    }

    public void d(String str, String str2) {
        log(2, str, str2);
    }

    public void e(String str, String str2) {
        log(6, str, str2);
    }

    public int getLoggingLevel() {
        return this.mLoggingLevel;
    }

    public void i(String str, String str2) {
        log(4, str, str2);
    }

    public boolean isLoggingEnabled() {
        return this.mLoggingEnabled;
    }

    public void log(int i10, String str, String str2) {
        logWithThrowable(i10, str, str2, (Throwable) null);
    }

    public void logWithThrowable(int i10, String str, String str2, Throwable th) {
        if (isLoggingEnabled() && shouldLog(i10)) {
            if (i10 == 6) {
                Log.e(str, str2, th);
            } else if (i10 == 8) {
                if (Integer.valueOf(Build.VERSION.SDK).intValue() > 8) {
                    checkedWtf(str, str2, th);
                } else {
                    Log.e(str, str2, th);
                }
            }
        }
    }

    public void setLoggingEnabled(boolean z10) {
        this.mLoggingEnabled = z10;
    }

    public void setLoggingLevel(int i10) {
        this.mLoggingLevel = i10;
    }

    public boolean shouldLog(int i10) {
        if (i10 >= this.mLoggingLevel) {
            return true;
        }
        return false;
    }

    public void v(String str, String str2) {
        log(2, str, str2);
    }

    public void w(String str, String str2) {
        log(5, str, str2);
    }

    public void wtf(String str, String str2) {
        log(8, str, str2);
    }

    public void d(String str, String str2, Throwable th) {
        logWithThrowable(3, str, str2, th);
    }

    public void e(String str, String str2, Throwable th) {
        logWithThrowable(6, str, str2, th);
    }

    public void i(String str, String str2, Throwable th) {
        logWithThrowable(4, str, str2, th);
    }

    public void v(String str, String str2, Throwable th) {
        logWithThrowable(2, str, str2, th);
    }

    public void w(String str, String str2, Throwable th) {
        logWithThrowable(5, str, str2, th);
    }

    public void wtf(String str, String str2, Throwable th) {
        logWithThrowable(8, str, str2, th);
    }
}
