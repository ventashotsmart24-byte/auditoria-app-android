package com.mobile.brasiltv.utils;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static final d f12512a = new d();

    /* JADX WARNING: Can't wrap try/catch for region: R(4:7|8|9|12) */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0043, code lost:
        android.os.Process.killProcess(android.os.Process.myPid());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x004a, code lost:
        throw r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0032, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x003b, code lost:
        android.os.Process.killProcess(android.os.Process.myPid());
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0034 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(android.content.Context r3) {
        /*
            r2 = this;
            java.lang.String r0 = "context"
            t9.i.g(r3, r0)
            android.content.pm.PackageManager r0 = r3.getPackageManager()
            java.lang.String r1 = r3.getPackageName()
            android.content.Intent r0 = r0.getLaunchIntentForPackage(r1)
            if (r0 != 0) goto L_0x0014
            goto L_0x0042
        L_0x0014:
            android.content.ComponentName r0 = r0.getComponent()
            android.content.Intent r0 = android.content.Intent.makeRestartActivityTask(r0)
            r3.startActivity(r0)
            com.mobile.brasiltv.utils.a r3 = com.mobile.brasiltv.utils.a.b()     // Catch:{ Exception -> 0x0034 }
            r3.e()     // Catch:{ Exception -> 0x0034 }
            r3 = 0
            java.lang.System.exit(r3)     // Catch:{ Exception -> 0x0034 }
            java.lang.RuntimeException r3 = new java.lang.RuntimeException     // Catch:{ Exception -> 0x0034 }
            java.lang.String r0 = "System.exit returned normally, while it was supposed to halt JVM."
            r3.<init>(r0)     // Catch:{ Exception -> 0x0034 }
            throw r3     // Catch:{ Exception -> 0x0034 }
        L_0x0032:
            r3 = move-exception
            goto L_0x0043
        L_0x0034:
            int r3 = android.os.Process.myPid()     // Catch:{ all -> 0x0032 }
            android.os.Process.killProcess(r3)     // Catch:{ all -> 0x0032 }
            int r3 = android.os.Process.myPid()
            android.os.Process.killProcess(r3)
        L_0x0042:
            return
        L_0x0043:
            int r0 = android.os.Process.myPid()
            android.os.Process.killProcess(r0)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mobile.brasiltv.utils.d.a(android.content.Context):void");
    }
}
