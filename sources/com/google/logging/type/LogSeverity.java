package com.google.logging.type;

import com.google.protobuf.Internal;

public enum LogSeverity implements Internal.EnumLite {
    DEFAULT(0),
    DEBUG(100),
    INFO(200),
    NOTICE(300),
    WARNING(400),
    ERROR(500),
    CRITICAL(600),
    ALERT(700),
    EMERGENCY(800),
    UNRECOGNIZED(-1);
    
    public static final int ALERT_VALUE = 700;
    public static final int CRITICAL_VALUE = 600;
    public static final int DEBUG_VALUE = 100;
    public static final int DEFAULT_VALUE = 0;
    public static final int EMERGENCY_VALUE = 800;
    public static final int ERROR_VALUE = 500;
    public static final int INFO_VALUE = 200;
    public static final int NOTICE_VALUE = 300;
    public static final int WARNING_VALUE = 400;
    private static final Internal.EnumLiteMap<LogSeverity> internalValueMap = null;
    private final int value;

    public static final class LogSeverityVerifier implements Internal.EnumVerifier {
        static final Internal.EnumVerifier INSTANCE = null;

        static {
            INSTANCE = new LogSeverityVerifier();
        }

        private LogSeverityVerifier() {
        }

        public boolean isInRange(int i10) {
            if (LogSeverity.forNumber(i10) != null) {
                return true;
            }
            return false;
        }
    }

    /* access modifiers changed from: public */
    static {
        internalValueMap = new Internal.EnumLiteMap<LogSeverity>() {
            public LogSeverity findValueByNumber(int i10) {
                return LogSeverity.forNumber(i10);
            }
        };
    }

    private LogSeverity(int i10) {
        this.value = i10;
    }

    public static LogSeverity forNumber(int i10) {
        if (i10 == 0) {
            return DEFAULT;
        }
        if (i10 == 100) {
            return DEBUG;
        }
        if (i10 == 200) {
            return INFO;
        }
        if (i10 == 300) {
            return NOTICE;
        }
        if (i10 == 400) {
            return WARNING;
        }
        if (i10 == 500) {
            return ERROR;
        }
        if (i10 == 600) {
            return CRITICAL;
        }
        if (i10 == 700) {
            return ALERT;
        }
        if (i10 != 800) {
            return null;
        }
        return EMERGENCY;
    }

    public static Internal.EnumLiteMap<LogSeverity> internalGetValueMap() {
        return internalValueMap;
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return LogSeverityVerifier.INSTANCE;
    }

    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.value;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }

    @Deprecated
    public static LogSeverity valueOf(int i10) {
        return forNumber(i10);
    }
}
