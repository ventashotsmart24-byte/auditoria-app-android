package com.google.firebase.crashlytics.internal.stacktrace;

public class TrimmedThrowableData {
    public final TrimmedThrowableData cause;
    public final String className;
    public final String localizedMessage;
    public final StackTraceElement[] stacktrace;

    public TrimmedThrowableData(Throwable th, StackTraceTrimmingStrategy stackTraceTrimmingStrategy) {
        TrimmedThrowableData trimmedThrowableData;
        this.localizedMessage = th.getLocalizedMessage();
        this.className = th.getClass().getName();
        this.stacktrace = stackTraceTrimmingStrategy.getTrimmedStackTrace(th.getStackTrace());
        Throwable cause2 = th.getCause();
        if (cause2 != null) {
            trimmedThrowableData = new TrimmedThrowableData(cause2, stackTraceTrimmingStrategy);
        } else {
            trimmedThrowableData = null;
        }
        this.cause = trimmedThrowableData;
    }
}
