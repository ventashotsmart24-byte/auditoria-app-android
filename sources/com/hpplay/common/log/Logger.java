package com.hpplay.common.log;

import android.util.Log;
import com.hpplay.cybergarage.soap.SOAP;

class Logger implements ILog {
    private static final String LEBO_TAG = "hpplay-java";
    private static final String PERFERMANCE = "hpplay-java:perfermance";

    public static String formatMessage(String str, String str2) {
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "";
        }
        return "[" + Thread.currentThread().getName() + "]:" + (str + SOAP.DELIM + str2);
    }

    public String D(String str, String str2) {
        return formatMessage(str, str2);
    }

    public String E(String str, String str2) {
        String formatMessage = formatMessage(str, str2);
        Log.e(PERFERMANCE, formatMessage);
        return formatMessage;
    }

    public String I(String str, String str2) {
        return formatMessage(str, str2);
    }

    public String V(String str, String str2) {
        return formatMessage(str, str2);
    }

    public String W(String str, String str2) {
        return formatMessage(str, str2);
    }

    public String d(String str, String str2) {
        return formatMessage(str, str2);
    }

    public String e(String str, String str2) {
        String formatMessage = formatMessage(str, str2);
        Log.e(LEBO_TAG, formatMessage);
        return formatMessage;
    }

    public String i(String str, String str2) {
        return formatMessage(str, str2);
    }

    public String v(String str, String str2) {
        return formatMessage(str, str2);
    }

    public String w(String str, String str2) {
        return formatMessage(str, str2);
    }

    public String D(String str, String str2, Throwable th) {
        String stackTraceString = Log.getStackTraceString(th);
        return formatMessage(str, str2 + 10 + stackTraceString);
    }

    public String I(String str, String str2, Throwable th) {
        String stackTraceString = Log.getStackTraceString(th);
        return formatMessage(str, str2 + 10 + stackTraceString);
    }

    public String V(String str, String str2, Throwable th) {
        String stackTraceString = Log.getStackTraceString(th);
        return formatMessage(str, str2 + 10 + stackTraceString);
    }

    public String W(String str, String str2, Throwable th) {
        String stackTraceString = Log.getStackTraceString(th);
        return formatMessage(str, str2 + 10 + stackTraceString);
    }

    public String d(String str, String str2, Throwable th) {
        String stackTraceString = Log.getStackTraceString(th);
        return formatMessage(str, str2 + 10 + stackTraceString);
    }

    public String i(String str, String str2, Throwable th) {
        String stackTraceString = Log.getStackTraceString(th);
        return formatMessage(str, str2 + 10 + stackTraceString);
    }

    public String v(String str, String str2, Throwable th) {
        String stackTraceString = Log.getStackTraceString(th);
        return formatMessage(str, str2 + 10 + stackTraceString);
    }

    public String w(String str, String str2, Throwable th) {
        String stackTraceString = Log.getStackTraceString(th);
        return formatMessage(str, str2 + 10 + stackTraceString);
    }

    public String E(String str, String str2, Throwable th) {
        String stackTraceString = Log.getStackTraceString(th);
        String formatMessage = formatMessage(str, str2 + 10 + stackTraceString);
        Log.e(PERFERMANCE, formatMessage, th);
        return formatMessage;
    }

    public String e(String str, String str2, Throwable th) {
        String stackTraceString = Log.getStackTraceString(th);
        String formatMessage = formatMessage(str, str2 + 10 + stackTraceString);
        Log.e(LEBO_TAG, formatMessage, th);
        return formatMessage;
    }

    public String W(String str, Throwable th) {
        return formatMessage(str, Log.getStackTraceString(th));
    }

    public String w(String str, Throwable th) {
        return formatMessage(str, Log.getStackTraceString(th));
    }
}
