package com.umeng.commonsdk.stateless;

import android.content.Context;
import android.content.IntentFilter;
import android.os.FileObserver;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import android.util.Base64;
import com.umeng.analytics.pro.bt;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.SdkVersion;
import com.umeng.commonsdk.statistics.UMServerURL;
import com.umeng.commonsdk.statistics.common.ULog;
import java.io.File;
import java.util.LinkedList;

public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final int f14854a = 273;

    /* renamed from: b  reason: collision with root package name */
    private static Context f14855b = null;

    /* renamed from: c  reason: collision with root package name */
    private static HandlerThread f14856c = null;

    /* renamed from: d  reason: collision with root package name */
    private static Handler f14857d = null;

    /* renamed from: e  reason: collision with root package name */
    private static Object f14858e = new Object();

    /* renamed from: f  reason: collision with root package name */
    private static final int f14859f = 274;

    /* renamed from: g  reason: collision with root package name */
    private static final int f14860g = 275;

    /* renamed from: h  reason: collision with root package name */
    private static final int f14861h = 512;

    /* renamed from: i  reason: collision with root package name */
    private static a f14862i = null;

    /* renamed from: j  reason: collision with root package name */
    private static IntentFilter f14863j = null;

    /* renamed from: k  reason: collision with root package name */
    private static volatile boolean f14864k = false;

    /* renamed from: l  reason: collision with root package name */
    private static LinkedList<String> f14865l = new LinkedList<>();

    public static class a extends FileObserver {
        public a(String str) {
            super(str);
        }

        public void onEvent(int i10, String str) {
            if ((i10 & 8) == 8) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> envelope file created >>> " + str);
                b.a((int) b.f14859f);
            }
        }
    }

    public b(Context context) {
        synchronized (f14858e) {
            if (context != null) {
                try {
                    Context applicationContext = context.getApplicationContext();
                    f14855b = applicationContext;
                    if (applicationContext != null && f14856c == null) {
                        HandlerThread handlerThread = new HandlerThread("SL-NetWorkSender");
                        f14856c = handlerThread;
                        handlerThread.start();
                        if (f14862i == null) {
                            String str = f14855b.getFilesDir() + File.separator + a.f14849f;
                            File file = new File(str);
                            if (!file.exists()) {
                                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 2号数据仓目录不存在，创建之。");
                                file.mkdir();
                            }
                            a aVar = new a(str);
                            f14862i = aVar;
                            aVar.startWatching();
                            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 2号数据仓File Monitor启动.");
                        }
                        if (f14857d == null) {
                            f14857d = new Handler(f14856c.getLooper()) {
                                public void handleMessage(Message message) {
                                    int i10 = message.what;
                                    if (i10 != 512) {
                                        switch (i10) {
                                            case 273:
                                                b.l();
                                                return;
                                            case b.f14859f /*274*/:
                                                b.n();
                                                return;
                                            case b.f14860g /*275*/:
                                                b.p();
                                                break;
                                            default:
                                                return;
                                        }
                                    }
                                    b.q();
                                }
                            };
                        }
                    }
                } catch (Throwable th) {
                    UMCrashManager.reportCrash(context, th);
                }
            }
        }
    }

    public static void a(boolean z10) {
        f14864k = z10;
        if (z10) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>>网络可用： 触发2号数据仓信封消费动作。");
            b(f14859f);
            return;
        }
        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>>网络断连： 2号数据仓");
    }

    public static void b(int i10) {
        Handler handler;
        try {
            if (f14864k && (handler = f14857d) != null && !handler.hasMessages(i10)) {
                Message obtainMessage = f14857d.obtainMessage();
                obtainMessage.what = i10;
                f14857d.sendMessage(obtainMessage);
            }
        } catch (Throwable th) {
            UMCrashManager.reportCrash(f14855b, th);
        }
    }

    public static void c() {
        b(f14860g);
    }

    public static void d() {
        b(512);
    }

    private static void i() {
        File[] c10 = d.c(f14855b);
        if (c10 != null) {
            if (f14865l.size() > 0) {
                f14865l.clear();
            }
            for (File absolutePath : c10) {
                f14865l.add(absolutePath.getAbsolutePath());
            }
        }
    }

    private static String j() {
        String str = null;
        try {
            String peek = f14865l.peek();
            if (peek == null) {
                return peek;
            }
            try {
                f14865l.removeFirst();
                return peek;
            } catch (Throwable unused) {
                str = peek;
            }
        } catch (Throwable unused2) {
            return str;
        }
    }

    private static void k() {
        String pollFirst;
        byte[] bArr;
        String str;
        String str2;
        if (f14865l.size() <= 0) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> todoList无内容，无需处理。");
            return;
        }
        do {
            pollFirst = f14865l.pollFirst();
            if (!TextUtils.isEmpty(pollFirst)) {
                File file = new File(pollFirst);
                if (!file.exists()) {
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 信封文件不存在，处理下一个文件。");
                    continue;
                } else {
                    c cVar = new c(f14855b);
                    try {
                        bArr = d.a(pollFirst);
                    } catch (Exception unused) {
                        bArr = null;
                    }
                    String name = file.getName();
                    if (!TextUtils.isEmpty(name)) {
                        str = name.substring(0, 1);
                    } else {
                        str = "u";
                    }
                    String c10 = d.c(d.d(name));
                    if (SdkVersion.SDK_TYPE == 0) {
                        cVar.a();
                    } else {
                        a.f14850g = a.f14853j;
                        cVar.b();
                    }
                    if (com.umeng.commonsdk.vchannel.a.f15148c.equalsIgnoreCase(c10)) {
                        str2 = com.umeng.commonsdk.vchannel.a.f15146a;
                    } else {
                        str2 = a.f14851h;
                    }
                    if (cVar.a(bArr, c10, str2, str) && !file.delete()) {
                        file.delete();
                        continue;
                    }
                }
            }
        } while (pollFirst != null);
        f14865l.clear();
    }

    /* access modifiers changed from: private */
    public static void l() {
        File a10;
        byte[] bArr;
        String str;
        if (f14864k && f14855b != null) {
            do {
                try {
                    a10 = d.a(f14855b);
                    if (!(a10 == null || a10.getParentFile() == null || TextUtils.isEmpty(a10.getParentFile().getName()))) {
                        c cVar = new c(f14855b);
                        String str2 = new String(Base64.decode(a10.getParentFile().getName(), 0));
                        if (!com.umeng.commonsdk.internal.a.f14750a.equalsIgnoreCase(str2) && !com.umeng.commonsdk.internal.a.f14751b.equalsIgnoreCase(str2)) {
                            if (!com.umeng.commonsdk.internal.a.H.equalsIgnoreCase(str2)) {
                                ULog.i("walle", "[stateless] handleProcessNext, pathUrl is " + str2);
                                try {
                                    bArr = d.a(a10.getAbsolutePath());
                                } catch (Exception unused) {
                                    bArr = null;
                                }
                                String str3 = "u";
                                if (UMServerURL.PATH_SHARE.equalsIgnoreCase(str2)) {
                                    str3 = "s";
                                }
                                if (UMServerURL.PATH_PUSH_LAUNCH.equalsIgnoreCase(str2) || UMServerURL.PATH_PUSH_REGIST.equalsIgnoreCase(str2) || UMServerURL.PATH_PUSH_LOG.equalsIgnoreCase(str2)) {
                                    str3 = bt.aD;
                                }
                                if (SdkVersion.SDK_TYPE == 0) {
                                    cVar.a();
                                } else {
                                    a.f14850g = a.f14853j;
                                    cVar.b();
                                }
                                if (com.umeng.commonsdk.vchannel.a.f15148c.equalsIgnoreCase(str2)) {
                                    str = com.umeng.commonsdk.vchannel.a.f15146a;
                                } else {
                                    str = a.f14851h;
                                }
                                if (cVar.a(bArr, str2, str, str3)) {
                                    ULog.i("walle", "[stateless] Send envelope file success, delete it.");
                                    File file = new File(a10.getAbsolutePath());
                                    if (!file.delete()) {
                                        ULog.i("walle", "[stateless] Failed to delete already processed file. We try again after delete failed.");
                                        file.delete();
                                        continue;
                                    } else {
                                        continue;
                                    }
                                } else {
                                    ULog.i("walle", "[stateless] Send envelope file failed, abandon and wait next trigger!");
                                    return;
                                }
                            }
                        }
                        new File(a10.getAbsolutePath()).delete();
                        continue;
                    }
                } catch (Throwable th) {
                    UMCrashManager.reportCrash(f14855b, th);
                }
            } while (a10 != null);
            m();
        }
    }

    private static void m() {
        try {
            File file = new File(f14855b.getFilesDir() + File.separator + a.f14848e);
            if (file.exists() && file.isDirectory()) {
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 2号数据仓：删除stateless目录。");
                d.a(file);
            }
        } catch (Throwable unused) {
        }
    }

    /* access modifiers changed from: private */
    public static void n() {
        if (f14864k && f14855b != null) {
            i();
            k();
            c();
        }
    }

    private static void o() {
        try {
            File file = new File(f14855b.getFilesDir() + File.separator + a.f14848e);
            if (file.exists() && file.isDirectory()) {
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>>2号数据仓：检测到stateless目录。");
                b(273);
            }
        } catch (Throwable unused) {
        }
    }

    /* access modifiers changed from: private */
    public static void p() {
        o();
    }

    /* access modifiers changed from: private */
    public static void q() {
    }

    public static boolean a() {
        synchronized (f14858e) {
            if (f14862i != null) {
                return true;
            }
            return false;
        }
    }

    public static void b() {
        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>>信封构建成功： 触发2号数据仓信封消费动作。");
        b(f14859f);
    }

    public static void a(int i10) {
        Handler handler;
        if (f14864k && (handler = f14857d) != null) {
            Message obtainMessage = handler.obtainMessage();
            obtainMessage.what = i10;
            f14857d.sendMessage(obtainMessage);
        }
    }
}
