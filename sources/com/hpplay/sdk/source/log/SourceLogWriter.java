package com.hpplay.sdk.source.log;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.hpplay.common.log.ILogCallback;
import com.hpplay.common.log.LeLog;
import com.hpplay.component.common.utils.CLog;
import com.hpplay.logwriter.ILogcatCollect;
import com.hpplay.logwriter.f;
import com.hpplay.sdk.source.common.store.Session;
import com.hpplay.sdk.source.config.LelinkConfig;
import com.hpplay.sdk.source.utils.LogcatLogCollect;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class SourceLogWriter implements ISourceLog {
    private static final String TAG = "hpplay-java:SWR";
    private static final int WHAT_WRITE_LOG = 1;
    /* access modifiers changed from: private */
    public static f sLogWriter;
    private static LogcatLogCollect sLogcat;
    /* access modifiers changed from: private */
    public Handler mHandler = null;
    private HandlerThread mHandlerThread = null;
    private String mLogDir = null;
    private CLog.IComponentLogCallback sClogCallback = new CLog.IComponentLogCallback() {
        public void onCastLog(int i10, String str) {
            try {
                SourceLogWriter.this.mHandler.sendMessage(SourceLogWriter.this.mHandler.obtainMessage(1, str));
            } catch (Exception unused) {
            }
        }
    };
    private Date sDate = new Date();
    private SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS", Locale.getDefault());
    private ILogCallback sLogCallback = new ILogCallback() {
        public void onLogCallback(Object... objArr) {
            try {
                SourceLogWriter.this.mHandler.sendMessage(SourceLogWriter.this.mHandler.obtainMessage(1, objArr[0]));
            } catch (Exception unused) {
            }
        }
    };

    public SourceLogWriter() {
        HandlerThread handlerThread = new HandlerThread("bu log writer");
        this.mHandlerThread = handlerThread;
        handlerThread.start();
        this.mHandler = new Handler(this.mHandlerThread.getLooper()) {
            public void handleMessage(Message message) {
                super.handleMessage(message);
                if (message.what == 1) {
                    try {
                        SourceLogWriter.this.writeLogImpl(message.obj.toString());
                    } catch (Exception unused) {
                    }
                }
            }
        };
    }

    private static void callbackLog(int i10, String str) {
        com.hpplay.sdk.source.api.ILogCallback logCallback;
        if (Session.getInstance() != null && (logCallback = Session.getInstance().getLogCallback()) != null) {
            logCallback.onCastLog(i10, str);
        }
    }

    private void checkLogWrite(Context context, int i10) {
        try {
            f a10 = f.a();
            sLogWriter = a10;
            if (!a10.e()) {
                this.mLogDir = LogCache.getLogDir();
                StringBuilder sb = new StringBuilder();
                sb.append("enableLog ");
                sb.append(this.mLogDir);
                if (sLogcat == null && !LelinkConfig.isMultiProgress()) {
                    sLogcat = new LogcatLogCollect();
                }
                sLogWriter.a((ILogcatCollect) sLogcat);
                sLogWriter.a(context, this.mLogDir, i10);
            }
        } catch (Exception unused) {
        }
    }

    private String getDate() {
        try {
            this.sDate.setTime(System.currentTimeMillis());
            return this.sDateFormat.format(this.sDate);
        } catch (Exception unused) {
            return "";
        }
    }

    public static void testLog() {
        new Thread(new Runnable() {
            public void run() {
                int i10 = 0;
                while (SourceLogWriter.sLogWriter != null) {
                    try {
                        Thread.sleep(10);
                    } catch (Exception unused) {
                    }
                    f access$200 = SourceLogWriter.sLogWriter;
                    access$200.a("testLog *****************  " + i10);
                    i10++;
                }
            }
        }).start();
    }

    /* access modifiers changed from: private */
    public void writeLogImpl(String str) {
        try {
            f fVar = sLogWriter;
            if (fVar != null) {
                fVar.a(getDate() + str);
            }
        } catch (Exception e10) {
            SourceLog.w(TAG, (Throwable) e10);
        }
    }

    public void D(String str, String str2) {
        callbackLog(3, LeLog.D(str, str2));
    }

    public void E(String str, String str2) {
        callbackLog(6, LeLog.E(str, str2));
    }

    public void I(String str, String str2) {
        callbackLog(4, LeLog.I(str, str2));
    }

    public void V(String str, String str2) {
        callbackLog(2, LeLog.V(str, str2));
    }

    public void W(String str, String str2) {
        callbackLog(5, LeLog.W(str, str2));
    }

    public void d(String str, String str2) {
        callbackLog(3, LeLog.d(str, str2));
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:5|6|7|9) */
    /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x000b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void disableLogAndWriter() {
        /*
            r2 = this;
            r0 = 0
            com.hpplay.logwriter.f r1 = sLogWriter     // Catch:{ Exception -> 0x000b }
            if (r1 != 0) goto L_0x0006
            return
        L_0x0006:
            r1.c()     // Catch:{ Exception -> 0x000b }
            sLogWriter = r0     // Catch:{ Exception -> 0x000b }
        L_0x000b:
            com.hpplay.common.log.LeLog.disableTrace()     // Catch:{ Exception -> 0x0011 }
            com.hpplay.component.common.utils.CLog.setLogCallback(r0)     // Catch:{ Exception -> 0x0011 }
        L_0x0011:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hpplay.sdk.source.log.SourceLogWriter.disableLogAndWriter():void");
    }

    public void disableLogButWriter(Context context, int i10) {
        LeLog.disableTrace(this.sLogCallback);
        CLog.setLogCallback(this.sClogCallback);
        checkLogWrite(context, i10);
    }

    public void e(String str, String str2) {
        callbackLog(6, LeLog.e(str, str2));
    }

    public void enableLogAndWriter(Context context, int i10) {
        LeLog.enableTrace(this.sLogCallback);
        CLog.setLogCallback(this.sClogCallback);
        checkLogWrite(context, i10);
    }

    public void enableLogNotWriter() {
        try {
            LeLog.enableTrace((ILogCallback) null);
            CLog.setLogCallback((CLog.IComponentLogCallback) null);
        } catch (Exception unused) {
        }
    }

    public void flushLogWriter() {
        try {
            f fVar = sLogWriter;
            if (fVar != null) {
                fVar.b();
            }
        } catch (Exception e10) {
            SourceLog.w(TAG, (Throwable) e10);
        }
    }

    public String getLogDir() {
        return this.mLogDir;
    }

    public void i(String str, String str2) {
        callbackLog(4, LeLog.i(str, str2));
    }

    public void v(String str, String str2) {
        callbackLog(2, LeLog.v(str, str2));
    }

    public void w(String str, String str2) {
        callbackLog(5, LeLog.w(str, str2));
    }

    public void writeLog(String str) {
        try {
            Handler handler = this.mHandler;
            handler.sendMessage(handler.obtainMessage(1, str));
        } catch (Exception unused) {
        }
    }

    public void D(String str, String str2, Throwable th) {
        callbackLog(3, LeLog.D(str, str2, th));
    }

    public void E(String str, String str2, Throwable th) {
        callbackLog(6, LeLog.E(str, str2, th));
    }

    public void I(String str, String str2, Throwable th) {
        callbackLog(4, LeLog.I(str, str2, th));
    }

    public void V(String str, String str2, Throwable th) {
        callbackLog(2, LeLog.V(str, str2, th));
    }

    public void W(String str, String str2, Throwable th) {
        callbackLog(5, LeLog.W(str, str2, th));
    }

    public void d(String str, String str2, Throwable th) {
        callbackLog(3, LeLog.d(str, str2, th));
    }

    public void e(String str, String str2, Throwable th) {
        callbackLog(6, LeLog.e(str, str2, th));
    }

    public void i(String str, String str2, Throwable th) {
        callbackLog(4, LeLog.i(str, str2, th));
    }

    public void v(String str, String str2, Throwable th) {
        callbackLog(2, LeLog.v(str, str2, th));
    }

    public void w(String str, String str2, Throwable th) {
        callbackLog(5, LeLog.w(str, str2, th));
    }

    public void W(String str, Throwable th) {
        callbackLog(5, LeLog.W(str, th));
    }

    public void w(String str, Throwable th) {
        callbackLog(5, LeLog.w(str, th));
    }
}
