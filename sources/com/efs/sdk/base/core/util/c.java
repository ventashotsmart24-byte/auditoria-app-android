package com.efs.sdk.base.core.util;

import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import java.io.File;
import java.util.UUID;

public class c {

    /* renamed from: a  reason: collision with root package name */
    private static volatile String f5311a = "";

    public static String a(Context context) {
        if (TextUtils.isEmpty(f5311a)) {
            synchronized (c.class) {
                if (TextUtils.isEmpty(f5311a)) {
                    String b10 = b(context);
                    f5311a = b10;
                    if (TextUtils.isEmpty(b10)) {
                        f5311a = c(context);
                    }
                }
            }
        }
        return f5311a;
    }

    private static String b(Context context) {
        try {
            File file = new File(a.a(context), "efsid");
            if (file.exists()) {
                return FileUtil.read(file);
            }
            return null;
        } catch (Exception e10) {
            Log.e("efs.base", "get uuid error", e10);
            return null;
        }
    }

    private static String c(Context context) {
        String str = "";
        int i10 = 0;
        while (i10 < 3) {
            try {
                str = UUID.randomUUID().toString();
                if (TextUtils.isEmpty(str)) {
                    i10++;
                }
            } catch (Throwable unused) {
            }
        }
        try {
            File a10 = a.a(context);
            File file = new File(a10, "efsid" + Process.myPid());
            if (file.exists()) {
                file.delete();
            }
            file.createNewFile();
            FileUtil.write(file, str);
            if (file.renameTo(new File(a10, "efsid"))) {
                file.delete();
            }
        } catch (Exception e10) {
            Log.e("efs.base", "save uuid '" + str + "' error", e10);
        }
        return str;
    }
}
