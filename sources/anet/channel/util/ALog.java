package anet.channel.util;

import android.text.TextUtils;
import android.util.Log;
import com.hpplay.cybergarage.soap.SOAP;

public class ALog {
    private static Object LOG_BREAK = "|";
    private static boolean canUseTlog = true;
    private static boolean isPrintLog = true;
    private static volatile ILog log;
    public static Logcat logcat;

    public interface ILog {
        void d(String str, String str2);

        void e(String str, String str2);

        void e(String str, String str2, Throwable th);

        void i(String str, String str2);

        boolean isPrintLog(int i10);

        boolean isValid();

        void setLogLevel(int i10);

        void w(String str, String str2);

        void w(String str, String str2, Throwable th);
    }

    public static class Level {
        public static final int D = 1;
        public static final int E = 4;
        public static final int I = 2;
        public static final int N = 5;
        public static final int V = 0;
        public static final int W = 3;
    }

    public static class Logcat implements ILog {
        int defaultLevel = 1;

        public void d(String str, String str2) {
        }

        public void e(String str, String str2) {
            Log.e(str, str2);
        }

        public void i(String str, String str2) {
        }

        public boolean isPrintLog(int i10) {
            if (i10 >= this.defaultLevel) {
                return true;
            }
            return false;
        }

        public boolean isValid() {
            return true;
        }

        public void setLogLevel(int i10) {
            if (i10 < 0 || i10 > 5) {
                this.defaultLevel = 5;
            } else {
                this.defaultLevel = i10;
            }
        }

        public void w(String str, String str2) {
        }

        public void e(String str, String str2, Throwable th) {
            Log.e(str, str2, th);
        }

        public void w(String str, String str2, Throwable th) {
        }
    }

    static {
        Logcat logcat2 = new Logcat();
        logcat = logcat2;
        log = logcat2;
    }

    private static String buildLogMsg(String str, String str2, Object... objArr) {
        if (str == null && str2 == null && objArr == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder(64);
        if (!TextUtils.isEmpty(str2)) {
            sb.append(LOG_BREAK);
            sb.append("[seq:");
            sb.append(str2);
            sb.append("] ");
        }
        if (str != null) {
            sb.append(str);
        }
        if (objArr != null) {
            int i10 = 0;
            while (true) {
                int i11 = i10 + 1;
                if (i11 >= objArr.length) {
                    break;
                }
                sb.append(" ");
                Object obj = objArr[i10];
                if (obj == null) {
                    obj = "";
                }
                sb.append(obj);
                sb.append(SOAP.DELIM);
                Object obj2 = objArr[i11];
                if (obj2 == null) {
                    obj2 = "";
                }
                sb.append(obj2);
                i10 += 2;
            }
            if (i10 < objArr.length) {
                sb.append(" ");
                sb.append(objArr[i10]);
            }
        }
        return sb.toString();
    }

    private static String buildLogTag(String str) {
        return str;
    }

    public static void d(String str, String str2, String str3, Object... objArr) {
        if (isPrintLog(1) && log != null) {
            log.d(buildLogTag(str), buildLogMsg(str2, str3, objArr));
        }
    }

    public static void e(String str, String str2, String str3, Object... objArr) {
        if (isPrintLog(4) && log != null) {
            log.e(buildLogTag(str), buildLogMsg(str2, str3, objArr));
        }
    }

    public static ILog getLog() {
        return log;
    }

    public static void i(String str, String str2, String str3, Object... objArr) {
        if (isPrintLog(2) && log != null) {
            log.i(buildLogTag(str), buildLogMsg(str2, str3, objArr));
        }
    }

    public static boolean isPrintLog(int i10) {
        if (isPrintLog && log != null) {
            return log.isPrintLog(i10);
        }
        return false;
    }

    public static void setLevel(int i10) {
        if (log != null) {
            log.setLogLevel(i10);
        }
    }

    public static void setLog(ILog iLog) {
        if (iLog != null) {
            if ((canUseTlog || !iLog.getClass().getSimpleName().toLowerCase().contains("tlog")) && iLog.isValid()) {
                log = iLog;
            }
        }
    }

    public static void setPrintLog(boolean z10) {
        isPrintLog = z10;
    }

    @Deprecated
    public static void setUseTlog(boolean z10) {
        if (!z10) {
            canUseTlog = false;
            log = logcat;
            return;
        }
        canUseTlog = true;
    }

    public static void w(String str, String str2, String str3, Object... objArr) {
        if (isPrintLog(3) && log != null) {
            log.w(buildLogTag(str), buildLogMsg(str2, str3, objArr));
        }
    }

    public static void e(String str, String str2, String str3, Throwable th, Object... objArr) {
        if (isPrintLog(4) && log != null) {
            log.e(buildLogTag(str), buildLogMsg(str2, str3, objArr), th);
        }
    }

    public static void w(String str, String str2, String str3, Throwable th, Object... objArr) {
        if (isPrintLog(3) && log != null) {
            log.w(buildLogTag(str), buildLogMsg(str2, str3, objArr), th);
        }
    }
}
