package com.umeng.commonsdk;

import android.content.Context;
import android.content.SharedPreferences;
import com.umeng.analytics.pro.bd;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.utils.onMessageSendListener;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class UMConfigureImpl {

    /* renamed from: a  reason: collision with root package name */
    private static String f14606a = bd.b().b(bd.f13855o);

    /* renamed from: b  reason: collision with root package name */
    private static CopyOnWriteArrayList<onMessageSendListener> f14607b = new CopyOnWriteArrayList<>();
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static int f14608c = 0;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public static boolean f14609d = false;

    /* renamed from: e  reason: collision with root package name */
    private static final int f14610e = 1000;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public static ScheduledExecutorService f14611f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public static Context f14612g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public static int f14613h = 0;

    /* renamed from: i  reason: collision with root package name */
    private static Runnable f14614i = new Runnable() {
        public void run() {
            try {
                if (UMConfigureImpl.f14608c == 0 || UMConfigureImpl.f14613h >= 10) {
                    if (!UMConfigureImpl.f14609d) {
                        boolean unused = UMConfigureImpl.f14609d = true;
                        UMConfigureImpl.b(UMConfigureImpl.f14612g);
                    }
                    if (UMConfigureImpl.f14611f != null) {
                        UMConfigureImpl.f14611f.shutdown();
                        ScheduledExecutorService unused2 = UMConfigureImpl.f14611f = null;
                    }
                }
                UMConfigureImpl.f();
            } catch (Exception unused3) {
            }
        }
    };

    public static /* synthetic */ int f() {
        int i10 = f14613h;
        f14613h = i10 + 1;
        return i10;
    }

    public static void init(Context context) {
        if (context != null) {
            f14612g = context;
            try {
                if (f14608c < 1) {
                    UMEnvelopeBuild.setTransmissionSendFlag(true);
                } else if (!d(context)) {
                    UMEnvelopeBuild.setTransmissionSendFlag(false);
                    c(context);
                    if (f14611f == null) {
                        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1);
                        f14611f = newScheduledThreadPool;
                        newScheduledThreadPool.scheduleAtFixedRate(f14614i, 0, 100, TimeUnit.MILLISECONDS);
                    }
                } else {
                    UMEnvelopeBuild.setTransmissionSendFlag(true);
                }
            } catch (Exception unused) {
            }
        }
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized void registerInterruptFlag() {
        /*
            java.lang.Class<com.umeng.commonsdk.UMConfigureImpl> r0 = com.umeng.commonsdk.UMConfigureImpl.class
            monitor-enter(r0)
            int r1 = f14608c     // Catch:{ Exception -> 0x000d, all -> 0x000a }
            int r1 = r1 + 1
            f14608c = r1     // Catch:{ Exception -> 0x000d, all -> 0x000a }
            goto L_0x000d
        L_0x000a:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        L_0x000d:
            monitor-exit(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.UMConfigureImpl.registerInterruptFlag():void");
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized void registerMessageSendListener(com.umeng.commonsdk.utils.onMessageSendListener r2) {
        /*
            java.lang.Class<com.umeng.commonsdk.UMConfigureImpl> r0 = com.umeng.commonsdk.UMConfigureImpl.class
            monitor-enter(r0)
            java.util.concurrent.CopyOnWriteArrayList<com.umeng.commonsdk.utils.onMessageSendListener> r1 = f14607b     // Catch:{ Exception -> 0x0033, all -> 0x0030 }
            if (r1 == 0) goto L_0x000a
            r1.add(r2)     // Catch:{ Exception -> 0x0033, all -> 0x0030 }
        L_0x000a:
            boolean r2 = com.umeng.commonsdk.framework.UMEnvelopeBuild.getTransmissionSendFlag()     // Catch:{ Exception -> 0x0033, all -> 0x0030 }
            if (r2 == 0) goto L_0x0033
            java.util.concurrent.CopyOnWriteArrayList<com.umeng.commonsdk.utils.onMessageSendListener> r2 = f14607b     // Catch:{ Exception -> 0x0033, all -> 0x0030 }
            if (r2 == 0) goto L_0x0033
            int r2 = r2.size()     // Catch:{ Exception -> 0x0033, all -> 0x0030 }
            if (r2 <= 0) goto L_0x0033
            java.util.concurrent.CopyOnWriteArrayList<com.umeng.commonsdk.utils.onMessageSendListener> r2 = f14607b     // Catch:{ Exception -> 0x0033, all -> 0x0030 }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ Exception -> 0x0033, all -> 0x0030 }
        L_0x0020:
            boolean r1 = r2.hasNext()     // Catch:{ Exception -> 0x0033, all -> 0x0030 }
            if (r1 == 0) goto L_0x0033
            java.lang.Object r1 = r2.next()     // Catch:{ Exception -> 0x0033, all -> 0x0030 }
            com.umeng.commonsdk.utils.onMessageSendListener r1 = (com.umeng.commonsdk.utils.onMessageSendListener) r1     // Catch:{ Exception -> 0x0033, all -> 0x0030 }
            r1.onMessageSend()     // Catch:{ Exception -> 0x0033, all -> 0x0030 }
            goto L_0x0020
        L_0x0030:
            r2 = move-exception
            monitor-exit(r0)
            throw r2
        L_0x0033:
            monitor-exit(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.UMConfigureImpl.registerMessageSendListener(com.umeng.commonsdk.utils.onMessageSendListener):void");
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized void removeInterruptFlag() {
        /*
            java.lang.Class<com.umeng.commonsdk.UMConfigureImpl> r0 = com.umeng.commonsdk.UMConfigureImpl.class
            monitor-enter(r0)
            int r1 = f14608c     // Catch:{ Exception -> 0x000d, all -> 0x000a }
            int r1 = r1 + -1
            f14608c = r1     // Catch:{ Exception -> 0x000d, all -> 0x000a }
            goto L_0x000d
        L_0x000a:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        L_0x000d:
            monitor-exit(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.UMConfigureImpl.removeInterruptFlag():void");
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized void removeMessageSendListener(com.umeng.commonsdk.utils.onMessageSendListener r2) {
        /*
            java.lang.Class<com.umeng.commonsdk.UMConfigureImpl> r0 = com.umeng.commonsdk.UMConfigureImpl.class
            monitor-enter(r0)
            java.util.concurrent.CopyOnWriteArrayList<com.umeng.commonsdk.utils.onMessageSendListener> r1 = f14607b     // Catch:{ Exception -> 0x000e, all -> 0x000b }
            if (r1 == 0) goto L_0x000e
            r1.remove(r2)     // Catch:{ Exception -> 0x000e, all -> 0x000b }
            goto L_0x000e
        L_0x000b:
            r2 = move-exception
            monitor-exit(r0)
            throw r2
        L_0x000e:
            monitor-exit(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.UMConfigureImpl.removeMessageSendListener(com.umeng.commonsdk.utils.onMessageSendListener):void");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized void b(android.content.Context r2) {
        /*
            java.lang.Class<com.umeng.commonsdk.UMConfigureImpl> r2 = com.umeng.commonsdk.UMConfigureImpl.class
            monitor-enter(r2)
            r0 = 1
            com.umeng.commonsdk.framework.UMEnvelopeBuild.setTransmissionSendFlag(r0)     // Catch:{ Exception -> 0x002a, all -> 0x0027 }
            java.util.concurrent.CopyOnWriteArrayList<com.umeng.commonsdk.utils.onMessageSendListener> r0 = f14607b     // Catch:{ Exception -> 0x002a, all -> 0x0027 }
            if (r0 == 0) goto L_0x002a
            int r0 = r0.size()     // Catch:{ Exception -> 0x002a, all -> 0x0027 }
            if (r0 <= 0) goto L_0x002a
            java.util.concurrent.CopyOnWriteArrayList<com.umeng.commonsdk.utils.onMessageSendListener> r0 = f14607b     // Catch:{ Exception -> 0x002a, all -> 0x0027 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ Exception -> 0x002a, all -> 0x0027 }
        L_0x0017:
            boolean r1 = r0.hasNext()     // Catch:{ Exception -> 0x002a, all -> 0x0027 }
            if (r1 == 0) goto L_0x002a
            java.lang.Object r1 = r0.next()     // Catch:{ Exception -> 0x002a, all -> 0x0027 }
            com.umeng.commonsdk.utils.onMessageSendListener r1 = (com.umeng.commonsdk.utils.onMessageSendListener) r1     // Catch:{ Exception -> 0x002a, all -> 0x0027 }
            r1.onMessageSend()     // Catch:{ Exception -> 0x002a, all -> 0x0027 }
            goto L_0x0017
        L_0x0027:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        L_0x002a:
            monitor-exit(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.UMConfigureImpl.b(android.content.Context):void");
    }

    private static void c(Context context) {
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences(f14606a, 0);
            if (sharedPreferences != null) {
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putBoolean(f14606a, true);
                edit.commit();
            }
        } catch (Throwable unused) {
        }
    }

    private static boolean d(Context context) {
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences(f14606a, 0);
            if (sharedPreferences != null) {
                return sharedPreferences.getBoolean(f14606a, false);
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }
}
