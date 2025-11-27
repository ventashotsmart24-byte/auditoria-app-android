package com.umeng.commonsdk.internal.utils;

import android.os.Build;
import com.umeng.commonsdk.internal.utils.e;
import java.io.File;

public class h {
    public static boolean a() {
        if (!b() && !c() && !d() && !e()) {
            return false;
        }
        return true;
    }

    private static boolean b() {
        String str = Build.TAGS;
        if (str == null || !str.contains("test-keys")) {
            return false;
        }
        return true;
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x000f */
    /* JADX WARNING: Removed duplicated region for block: B:11:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x001c A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean c() {
        /*
            r0 = 1
            java.io.File r1 = new java.io.File     // Catch:{ Exception -> 0x000f }
            java.lang.String r2 = "/system/app/Superuser.apk"
            r1.<init>(r2)     // Catch:{ Exception -> 0x000f }
            boolean r1 = r1.exists()     // Catch:{ Exception -> 0x000f }
            if (r1 == 0) goto L_0x000f
            return r0
        L_0x000f:
            java.io.File r1 = new java.io.File     // Catch:{ Exception -> 0x001d }
            java.lang.String r2 = "/system/app/Kinguser.apk"
            r1.<init>(r2)     // Catch:{ Exception -> 0x001d }
            boolean r1 = r1.exists()     // Catch:{ Exception -> 0x001d }
            if (r1 == 0) goto L_0x001d
            return r0
        L_0x001d:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.internal.utils.h.c():boolean");
    }

    private static boolean d() {
        if (new e().a(e.a.check_su_binary) != null) {
            return true;
        }
        return false;
    }

    private static boolean e() {
        String[] strArr = {"/bin", "/system/bin/", "/system/xbin/", "/system/sbin/", "/sbin/", "/vendor/bin/", "/su/bin/", "/data/local/xbin/", "/data/local/bin/", "/system/sd/xbin/", "/system/bin/failsafe/", "/data/local/"};
        for (int i10 = 0; i10 < 12; i10++) {
            String str = strArr[i10];
            if (new File(str + "su").exists()) {
                return true;
            }
        }
        return false;
    }
}
