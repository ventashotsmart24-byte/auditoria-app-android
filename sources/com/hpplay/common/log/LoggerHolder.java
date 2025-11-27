package com.hpplay.common.log;

import android.util.Log;

public class LoggerHolder extends Logger {
    private ILogCallback mLogCallback;

    public LoggerHolder(ILogCallback iLogCallback) {
        this.mLogCallback = iLogCallback;
    }

    public String D(String str, String str2) {
        if (this.mLogCallback == null) {
            return null;
        }
        String formatMessage = Logger.formatMessage(str, str2);
        this.mLogCallback.onLogCallback(formatMessage);
        return formatMessage;
    }

    public String E(String str, String str2) {
        if (this.mLogCallback == null) {
            return null;
        }
        String formatMessage = Logger.formatMessage(str, str2);
        this.mLogCallback.onLogCallback(formatMessage);
        return formatMessage;
    }

    public String I(String str, String str2) {
        if (this.mLogCallback == null) {
            return null;
        }
        String formatMessage = Logger.formatMessage(str, str2);
        this.mLogCallback.onLogCallback(formatMessage);
        return formatMessage;
    }

    public String V(String str, String str2) {
        if (this.mLogCallback == null) {
            return null;
        }
        String formatMessage = Logger.formatMessage(str, str2);
        this.mLogCallback.onLogCallback(formatMessage);
        return formatMessage;
    }

    public String W(String str, String str2) {
        if (this.mLogCallback == null) {
            return null;
        }
        String formatMessage = Logger.formatMessage(str, str2);
        this.mLogCallback.onLogCallback(formatMessage);
        return formatMessage;
    }

    public String d(String str, String str2) {
        if (this.mLogCallback == null) {
            return null;
        }
        String formatMessage = Logger.formatMessage(str, str2);
        this.mLogCallback.onLogCallback(formatMessage);
        return formatMessage;
    }

    public String e(String str, String str2) {
        if (this.mLogCallback == null) {
            return null;
        }
        String formatMessage = Logger.formatMessage(str, str2);
        this.mLogCallback.onLogCallback(formatMessage);
        return formatMessage;
    }

    public String i(String str, String str2) {
        if (this.mLogCallback == null) {
            return null;
        }
        String formatMessage = Logger.formatMessage(str, str2);
        this.mLogCallback.onLogCallback(formatMessage);
        return formatMessage;
    }

    public String v(String str, String str2) {
        if (this.mLogCallback == null) {
            return null;
        }
        String formatMessage = Logger.formatMessage(str, str2);
        this.mLogCallback.onLogCallback(formatMessage);
        return formatMessage;
    }

    public String w(String str, String str2) {
        if (this.mLogCallback == null) {
            return null;
        }
        String formatMessage = Logger.formatMessage(str, str2);
        this.mLogCallback.onLogCallback(formatMessage);
        return formatMessage;
    }

    public String D(String str, String str2, Throwable th) {
        if (this.mLogCallback == null) {
            return null;
        }
        String stackTraceString = Log.getStackTraceString(th);
        String formatMessage = Logger.formatMessage(str, str2 + 10 + stackTraceString);
        this.mLogCallback.onLogCallback(formatMessage);
        return formatMessage;
    }

    public String E(String str, String str2, Throwable th) {
        if (this.mLogCallback == null) {
            return null;
        }
        String stackTraceString = Log.getStackTraceString(th);
        String formatMessage = Logger.formatMessage(str, str2 + 10 + stackTraceString);
        this.mLogCallback.onLogCallback(formatMessage);
        return formatMessage;
    }

    public String I(String str, String str2, Throwable th) {
        if (this.mLogCallback == null) {
            return null;
        }
        String stackTraceString = Log.getStackTraceString(th);
        String formatMessage = Logger.formatMessage(str, str2 + 10 + stackTraceString);
        this.mLogCallback.onLogCallback(formatMessage);
        return formatMessage;
    }

    public String V(String str, String str2, Throwable th) {
        if (this.mLogCallback == null) {
            return null;
        }
        String stackTraceString = Log.getStackTraceString(th);
        String formatMessage = Logger.formatMessage(str, str2 + 10 + stackTraceString);
        this.mLogCallback.onLogCallback(formatMessage);
        return formatMessage;
    }

    public String W(String str, String str2, Throwable th) {
        if (this.mLogCallback == null) {
            return null;
        }
        String stackTraceString = Log.getStackTraceString(th);
        String formatMessage = Logger.formatMessage(str, str2 + 10 + stackTraceString);
        this.mLogCallback.onLogCallback(formatMessage);
        return formatMessage;
    }

    public String d(String str, String str2, Throwable th) {
        if (this.mLogCallback == null) {
            return null;
        }
        String stackTraceString = Log.getStackTraceString(th);
        String formatMessage = Logger.formatMessage(str, str2 + 10 + stackTraceString);
        this.mLogCallback.onLogCallback(formatMessage);
        return formatMessage;
    }

    public String e(String str, String str2, Throwable th) {
        if (this.mLogCallback == null) {
            return null;
        }
        String stackTraceString = Log.getStackTraceString(th);
        String formatMessage = Logger.formatMessage(str, str2 + 10 + stackTraceString);
        this.mLogCallback.onLogCallback(formatMessage);
        return formatMessage;
    }

    public String i(String str, String str2, Throwable th) {
        if (this.mLogCallback == null) {
            return null;
        }
        String stackTraceString = Log.getStackTraceString(th);
        String formatMessage = Logger.formatMessage(str, str2 + 10 + stackTraceString);
        this.mLogCallback.onLogCallback(formatMessage);
        return formatMessage;
    }

    public String v(String str, String str2, Throwable th) {
        if (this.mLogCallback == null) {
            return null;
        }
        String stackTraceString = Log.getStackTraceString(th);
        String formatMessage = Logger.formatMessage(str, str2 + 10 + stackTraceString);
        this.mLogCallback.onLogCallback(formatMessage);
        return formatMessage;
    }

    public String w(String str, String str2, Throwable th) {
        if (this.mLogCallback == null) {
            return null;
        }
        String stackTraceString = Log.getStackTraceString(th);
        String formatMessage = Logger.formatMessage(str, str2 + 10 + stackTraceString);
        this.mLogCallback.onLogCallback(formatMessage);
        return formatMessage;
    }

    public String W(String str, Throwable th) {
        if (this.mLogCallback == null) {
            return null;
        }
        String formatMessage = Logger.formatMessage(str, Log.getStackTraceString(th));
        this.mLogCallback.onLogCallback(formatMessage);
        return formatMessage;
    }

    public String w(String str, Throwable th) {
        if (this.mLogCallback == null) {
            return null;
        }
        String formatMessage = Logger.formatMessage(str, Log.getStackTraceString(th));
        this.mLogCallback.onLogCallback(formatMessage);
        return formatMessage;
    }
}
