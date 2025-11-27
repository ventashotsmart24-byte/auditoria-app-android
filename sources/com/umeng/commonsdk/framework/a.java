package com.umeng.commonsdk.framework;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkRequest;
import android.os.Build;
import android.os.FileObserver;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.umeng.analytics.pro.by;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.internal.b;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.c;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.statistics.common.ULog;
import com.umeng.commonsdk.statistics.idtracking.ImprintHandler;
import com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback;
import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;
import org.android.agoo.common.AgooConstants;

public class a implements UMImprintChangeCallback {

    /* renamed from: a  reason: collision with root package name */
    private static HandlerThread f14724a = null;

    /* renamed from: b  reason: collision with root package name */
    private static Handler f14725b = null;

    /* renamed from: c  reason: collision with root package name */
    private static Handler f14726c = null;

    /* renamed from: d  reason: collision with root package name */
    private static final int f14727d = 200;

    /* renamed from: e  reason: collision with root package name */
    private static final int f14728e = 273;

    /* renamed from: f  reason: collision with root package name */
    private static final int f14729f = 274;

    /* renamed from: g  reason: collision with root package name */
    private static final int f14730g = 512;

    /* renamed from: h  reason: collision with root package name */
    private static final int f14731h = 769;

    /* renamed from: i  reason: collision with root package name */
    private static C0201a f14732i = null;

    /* renamed from: j  reason: collision with root package name */
    private static ConnectivityManager f14733j = null;

    /* renamed from: k  reason: collision with root package name */
    private static IntentFilter f14734k = null;

    /* renamed from: l  reason: collision with root package name */
    private static volatile boolean f14735l = false;

    /* renamed from: m  reason: collision with root package name */
    private static ArrayList<UMSenderStateNotify> f14736m = null;

    /* renamed from: n  reason: collision with root package name */
    private static Object f14737n = new Object();
    /* access modifiers changed from: private */

    /* renamed from: o  reason: collision with root package name */
    public static ReentrantLock f14738o = new ReentrantLock();

    /* renamed from: p  reason: collision with root package name */
    private static final String f14739p = "report_policy";

    /* renamed from: q  reason: collision with root package name */
    private static final String f14740q = "report_interval";

    /* renamed from: r  reason: collision with root package name */
    private static boolean f14741r = false;

    /* renamed from: s  reason: collision with root package name */
    private static final int f14742s = 15;

    /* renamed from: t  reason: collision with root package name */
    private static final int f14743t = 3;

    /* renamed from: u  reason: collision with root package name */
    private static final int f14744u = 90;

    /* renamed from: v  reason: collision with root package name */
    private static int f14745v = 15;

    /* renamed from: w  reason: collision with root package name */
    private static Object f14746w = new Object();

    /* renamed from: x  reason: collision with root package name */
    private static BroadcastReceiver f14747x = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                UMWorkDispatch.sendEvent(context, com.umeng.commonsdk.internal.a.E, b.a(context).a(), (Object) null);
            }
        }
    };

    /* renamed from: com.umeng.commonsdk.framework.a$a  reason: collision with other inner class name */
    public static class C0201a extends FileObserver {
        public C0201a(String str) {
            super(str);
        }

        public void onEvent(int i10, String str) {
            if ((i10 & 8) == 8) {
                ULog.d("--->>> envelope file created >>> " + str);
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> envelope file created >>> " + str);
                a.c(273);
            }
        }
    }

    static {
        Context appContext = UMGlobalContext.getAppContext();
        if (appContext != null) {
            f14733j = (ConnectivityManager) appContext.getSystemService("connectivity");
        }
    }

    public a(Context context, Handler handler) {
        if (f14733j == null) {
            Context appContext = UMGlobalContext.getAppContext();
            if (f14733j != null) {
                f14733j = (ConnectivityManager) appContext.getSystemService("connectivity");
            }
        }
        f14726c = handler;
        try {
            if (f14724a == null) {
                HandlerThread handlerThread = new HandlerThread("NetWorkSender");
                f14724a = handlerThread;
                handlerThread.start();
                if (f14732i == null) {
                    C0201a aVar = new C0201a(UMFrUtils.getEnvelopeDirPath(context));
                    f14732i = aVar;
                    aVar.startWatching();
                    ULog.d("--->>> FileMonitor has already started!");
                }
                j();
                if (f14725b == null) {
                    f14725b = new Handler(f14724a.getLooper()) {
                        /* JADX WARNING: Can't wrap try/catch for region: R(7:9|10|11|12|13|14|16) */
                        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x002a */
                        /* Code decompiled incorrectly, please refer to instructions dump. */
                        public void handleMessage(android.os.Message r4) {
                            /*
                                r3 = this;
                                int r4 = r4.what
                                r0 = 273(0x111, float:3.83E-43)
                                if (r4 == r0) goto L_0x0017
                                r0 = 274(0x112, float:3.84E-43)
                                if (r4 == r0) goto L_0x0013
                                r0 = 512(0x200, float:7.175E-43)
                                if (r4 == r0) goto L_0x000f
                                goto L_0x0031
                            L_0x000f:
                                com.umeng.commonsdk.framework.a.m()
                                goto L_0x0031
                            L_0x0013:
                                com.umeng.commonsdk.framework.a.l()
                                goto L_0x0031
                            L_0x0017:
                                java.lang.String r4 = "--->>> handleMessage: recv MSG_PROCESS_NEXT msg."
                                com.umeng.commonsdk.statistics.common.ULog.d((java.lang.String) r4)
                                java.util.concurrent.locks.ReentrantLock r4 = com.umeng.commonsdk.framework.a.f14738o     // Catch:{ all -> 0x0031 }
                                java.util.concurrent.TimeUnit r0 = java.util.concurrent.TimeUnit.SECONDS     // Catch:{ all -> 0x0031 }
                                r1 = 1
                                r4.tryLock(r1, r0)     // Catch:{ all -> 0x0031 }
                                com.umeng.commonsdk.framework.a.n()     // Catch:{ all -> 0x002a }
                            L_0x002a:
                                java.util.concurrent.locks.ReentrantLock r4 = com.umeng.commonsdk.framework.a.f14738o     // Catch:{ all -> 0x0031 }
                                r4.unlock()     // Catch:{ all -> 0x0031 }
                            L_0x0031:
                                return
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.framework.a.AnonymousClass3.handleMessage(android.os.Message):void");
                        }
                    };
                }
                ImprintHandler.getImprintService(context).registImprintCallback(f14739p, this);
                ImprintHandler.getImprintService(context).registImprintCallback(f14740q, this);
            }
        } catch (Throwable th) {
            UMCrashManager.reportCrash(context, th);
        }
    }

    public static int b() {
        int i10;
        synchronized (f14746w) {
            i10 = f14745v;
        }
        return i10;
    }

    public static void c() {
    }

    public static void d() {
        if (f14738o.tryLock()) {
            try {
                b(273);
            } finally {
                f14738o.unlock();
            }
        }
    }

    public static void e() {
        a((int) f14729f, 3000);
    }

    private void j() {
        synchronized (f14746w) {
            if (AgooConstants.ACK_BODY_NULL.equals(UMEnvelopeBuild.imprintProperty(UMModuleRegister.getAppContext(), f14739p, ""))) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> switch to report_policy 11");
                f14741r = true;
                f14745v = 15;
                int intValue = Integer.valueOf(UMEnvelopeBuild.imprintProperty(UMModuleRegister.getAppContext(), f14740q, AgooConstants.ACK_PACK_ERROR)).intValue();
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> set report_interval value to: " + intValue);
                if (intValue >= 3) {
                    if (intValue <= 90) {
                        f14745v = intValue * 1000;
                    }
                }
                f14745v = 15;
            } else {
                f14741r = false;
            }
        }
    }

    private static void k() {
        if (f14724a != null) {
            f14724a = null;
        }
        if (f14725b != null) {
            f14725b = null;
        }
        if (f14726c != null) {
            f14726c = null;
        }
    }

    /* access modifiers changed from: private */
    public static void l() {
        int size;
        synchronized (f14737n) {
            ArrayList<UMSenderStateNotify> arrayList = f14736m;
            if (arrayList != null && (size = arrayList.size()) > 0) {
                for (int i10 = 0; i10 < size; i10++) {
                    f14736m.get(i10).onSenderIdle();
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public static void m() {
    }

    /* access modifiers changed from: private */
    public static void n() {
        ULog.d("--->>> handleProcessNext: Enter...");
        if (f14735l) {
            Context appContext = UMModuleRegister.getAppContext();
            try {
                if (UMFrUtils.envelopeFileNumber(appContext) > 0) {
                    ULog.d("--->>> The envelope file exists.");
                    if (UMFrUtils.envelopeFileNumber(appContext) > 200) {
                        ULog.d("--->>> Number of envelope files is greater than 200, remove old files first.");
                        UMFrUtils.removeRedundantEnvelopeFiles(appContext, 200);
                    }
                    File envelopeFile = UMFrUtils.getEnvelopeFile(appContext);
                    if (envelopeFile != null) {
                        String path = envelopeFile.getPath();
                        ULog.d("--->>> Ready to send envelope file [" + path + "].");
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> send envelope file [ " + path + "].");
                        if (new c(appContext).a(envelopeFile)) {
                            ULog.d("--->>> Send envelope file success, delete it.");
                            if (!UMFrUtils.removeEnvelopeFile(envelopeFile)) {
                                ULog.d("--->>> Failed to delete already processed file. We try again after delete failed.");
                                UMFrUtils.removeEnvelopeFile(envelopeFile);
                            }
                            c(273);
                            return;
                        }
                        ULog.d("--->>> Send envelope file failed, abandon and wait next trigger!");
                        return;
                    }
                }
                e();
            } catch (Throwable th) {
                UMCrashManager.reportCrash(appContext, th);
            }
        }
    }

    public void onImprintValueChanged(String str, String str2) {
        synchronized (f14746w) {
            if (f14739p.equals(str)) {
                if (AgooConstants.ACK_BODY_NULL.equals(str2)) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> switch to report_policy 11");
                    f14741r = true;
                } else {
                    f14741r = false;
                }
            }
            if (f14740q.equals(str)) {
                int intValue = Integer.valueOf(str2).intValue();
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> set report_interval value to: " + intValue);
                if (intValue >= 3) {
                    if (intValue <= 90) {
                        f14745v = intValue * 1000;
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> really set report_interval value to: " + f14745v);
                    }
                }
                f14745v = by.f13999b;
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> really set report_interval value to: " + f14745v);
            }
        }
    }

    public static void a(Context context) {
        if (f14733j == null && context != null) {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            f14733j = connectivityManager;
            if (connectivityManager != null) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> createCMIfNeeded:注册网络状态监听器。");
                b(context);
            }
        }
    }

    /* access modifiers changed from: private */
    public static void c(int i10) {
        Handler handler;
        if (f14735l && (handler = f14725b) != null) {
            Message obtainMessage = handler.obtainMessage();
            obtainMessage.what = i10;
            f14725b.sendMessage(obtainMessage);
        }
    }

    public static void b(Context context) {
        if (context == null) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> registerNetReceiver: context is null, registerNetReceiver failed.");
        } else if (Build.VERSION.SDK_INT >= 33) {
            if (DeviceConfig.checkPermission(context, "android.permission.ACCESS_NETWORK_STATE")) {
                NetworkRequest a10 = new NetworkRequest.Builder().addTransportType(0).addTransportType(1).build();
                if (f14733j != null) {
                    final Context applicationContext = context.getApplicationContext();
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> 注册网络状态监听器:registerNetworkCallback");
                    f14733j.registerNetworkCallback(a10, new ConnectivityManager.NetworkCallback() {
                        public void onAvailable(Network network) {
                            Context context = applicationContext;
                            UMWorkDispatch.sendEvent(context, com.umeng.commonsdk.internal.a.E, b.a(context).a(), (Object) null);
                        }

                        public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
                            super.onCapabilitiesChanged(network, networkCapabilities);
                        }

                        public void onLost(Network network) {
                            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> onLost");
                            Context context = applicationContext;
                            UMWorkDispatch.sendEvent(context, com.umeng.commonsdk.internal.a.E, b.a(context).a(), (Object) null, 2000);
                        }
                    });
                    return;
                }
                return;
            }
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> ACCESS_NETWORK_STATE permission access denied.");
        } else if (!DeviceConfig.checkPermission(context, "android.permission.ACCESS_NETWORK_STATE")) {
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> ACCESS_NETWORK_STATE permission access denied.");
        } else if (f14733j != null && f14734k == null) {
            IntentFilter intentFilter = new IntentFilter();
            f14734k = intentFilter;
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            if (f14747x != null) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> 注册网络状态监听器:registerReceiver");
                context.registerReceiver(f14747x, f14734k);
            }
        }
    }

    public static void a(UMSenderStateNotify uMSenderStateNotify) {
        synchronized (f14737n) {
            try {
                if (f14736m == null) {
                    f14736m = new ArrayList<>();
                }
                if (uMSenderStateNotify != null) {
                    for (int i10 = 0; i10 < f14736m.size(); i10++) {
                        if (uMSenderStateNotify == f14736m.get(i10)) {
                            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> addConnStateObserver: input item has exist.");
                            return;
                        }
                    }
                    f14736m.add(uMSenderStateNotify);
                }
            } catch (Throwable th) {
                UMCrashManager.reportCrash(UMModuleRegister.getAppContext(), th);
            }
        }
    }

    public static boolean a() {
        boolean z10;
        synchronized (f14746w) {
            z10 = f14741r;
        }
        return z10;
    }

    public static void a(boolean z10) {
        int size;
        f14735l = z10;
        if (z10) {
            synchronized (f14737n) {
                ArrayList<UMSenderStateNotify> arrayList = f14736m;
                if (arrayList != null && (size = arrayList.size()) > 0) {
                    for (int i10 = 0; i10 < size; i10++) {
                        f14736m.get(i10).onConnectionAvailable();
                    }
                }
            }
            UMRTLog.e(UMRTLog.RTLOG_TAG, "网络状态通知：尝试发送 MSG_PROCESS_NEXT");
            d();
            return;
        }
        ULog.i("--->>> network disconnected.");
        f14735l = false;
    }

    private static void b(int i10) {
        Handler handler;
        if (f14735l && (handler = f14725b) != null && !handler.hasMessages(i10)) {
            Message obtainMessage = f14725b.obtainMessage();
            obtainMessage.what = i10;
            f14725b.sendMessage(obtainMessage);
        }
    }

    private static void a(int i10, long j10) {
        Handler handler;
        if (f14735l && (handler = f14725b) != null) {
            Message obtainMessage = handler.obtainMessage();
            obtainMessage.what = i10;
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> sendMsgDelayed: " + j10);
            f14725b.sendMessageDelayed(obtainMessage, j10);
        }
    }

    private static void a(int i10, int i11) {
        Handler handler;
        if (f14735l && (handler = f14725b) != null) {
            handler.removeMessages(i10);
            Message obtainMessage = f14725b.obtainMessage();
            obtainMessage.what = i10;
            f14725b.sendMessageDelayed(obtainMessage, (long) i11);
        }
    }
}
