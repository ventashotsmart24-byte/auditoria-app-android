package anet.channel.strategy;

import android.content.Context;
import anet.channel.GlobalAppRuntimeInfo;
import anet.channel.statist.StrategyStatObject;
import anet.channel.util.ALog;
import anet.channel.util.SerializeHelper;
import java.io.File;
import java.io.Serializable;
import java.util.Comparator;

class m {

    /* renamed from: a  reason: collision with root package name */
    private static File f3984a = null;

    /* renamed from: b  reason: collision with root package name */
    private static volatile boolean f3985b = false;

    /* renamed from: c  reason: collision with root package name */
    private static Comparator<File> f3986c = new n();

    public static void a(Context context) {
        if (context != null) {
            try {
                File file = new File(context.getFilesDir(), "awcn_strategy");
                f3984a = file;
                if (!a(file)) {
                    ALog.e("awcn.StrategySerializeHelper", "create directory failed!!!", (String) null, "dir", f3984a.getAbsolutePath());
                }
                if (!GlobalAppRuntimeInfo.isTargetProcess()) {
                    String currentProcess = GlobalAppRuntimeInfo.getCurrentProcess();
                    File file2 = new File(f3984a, currentProcess.substring(currentProcess.indexOf(58) + 1));
                    f3984a = file2;
                    if (!a(file2)) {
                        ALog.e("awcn.StrategySerializeHelper", "create directory failed!!!", (String) null, "dir", f3984a.getAbsolutePath());
                    }
                }
                ALog.i("awcn.StrategySerializeHelper", "StrateyFolder", (String) null, "path", f3984a.getAbsolutePath());
                if (f3985b) {
                    a();
                    f3985b = false;
                    return;
                }
                c();
            } catch (Throwable th) {
                ALog.e("awcn.StrategySerializeHelper", "StrategySerializeHelper initialize failed!!!", (String) null, th, new Object[0]);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0016, code lost:
        return r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized java.io.File[] b() {
        /*
            java.lang.Class<anet.channel.strategy.m> r0 = anet.channel.strategy.m.class
            monitor-enter(r0)
            java.io.File r1 = f3984a     // Catch:{ all -> 0x0017 }
            if (r1 != 0) goto L_0x000a
            monitor-exit(r0)
            r0 = 0
            return r0
        L_0x000a:
            java.io.File[] r1 = r1.listFiles()     // Catch:{ all -> 0x0017 }
            if (r1 == 0) goto L_0x0015
            java.util.Comparator<java.io.File> r2 = f3986c     // Catch:{ all -> 0x0017 }
            java.util.Arrays.sort(r1, r2)     // Catch:{ all -> 0x0017 }
        L_0x0015:
            monitor-exit(r0)
            return r1
        L_0x0017:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: anet.channel.strategy.m.b():java.io.File[]");
    }

    public static synchronized void c() {
        synchronized (m.class) {
            File[] b10 = b();
            if (b10 != null) {
                int i10 = 0;
                for (File file : b10) {
                    if (!file.isDirectory()) {
                        if (System.currentTimeMillis() - file.lastModified() > 172800000) {
                            file.delete();
                        } else if (file.getName().startsWith("WIFI")) {
                            int i11 = i10 + 1;
                            if (((long) i10) > 10) {
                                file.delete();
                            }
                            i10 = i11;
                        }
                    }
                }
            }
        }
    }

    private static boolean a(File file) {
        if (file == null || file.exists()) {
            return true;
        }
        return file.mkdir();
    }

    public static File a(String str) {
        a(f3984a);
        return new File(f3984a, str);
    }

    public static synchronized void a() {
        synchronized (m.class) {
            ALog.i("awcn.StrategySerializeHelper", "clear start.", (String) null, new Object[0]);
            File file = f3984a;
            if (file == null) {
                ALog.w("awcn.StrategySerializeHelper", "folder path not initialized, wait to clear", (String) null, new Object[0]);
                f3985b = true;
                return;
            }
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (File file2 : listFiles) {
                    if (file2.isFile()) {
                        file2.delete();
                    }
                }
                ALog.i("awcn.StrategySerializeHelper", "clear end.", (String) null, new Object[0]);
            }
        }
    }

    public static synchronized void a(Serializable serializable, String str, StrategyStatObject strategyStatObject) {
        synchronized (m.class) {
            SerializeHelper.persist(serializable, a(str), strategyStatObject);
        }
    }

    public static synchronized <T> T a(String str, StrategyStatObject strategyStatObject) {
        T restore;
        synchronized (m.class) {
            restore = SerializeHelper.restore(a(str), strategyStatObject);
        }
        return restore;
    }
}
