package com.umeng.message.proguard;

import com.umeng.commonsdk.utils.UMUtils;
import java.io.File;

public final class ea {
    private static void a(File file) {
        if (!file.exists()) {
            file.mkdirs();
        }
    }

    public static File a(String str) {
        String lowerCase = UMUtils.MD5(str).toLowerCase();
        File file = new File(de.a().getExternalFilesDir((String) null), "UMCache");
        a(file);
        return new File(file, lowerCase);
    }
}
