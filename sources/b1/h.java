package b1;

import a1.k;
import android.content.Context;
import android.os.Build;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public abstract class h {

    /* renamed from: a  reason: collision with root package name */
    public static final String f4149a = k.f("WrkDbPathHelper");

    /* renamed from: b  reason: collision with root package name */
    public static final String[] f4150b = {"-journal", "-shm", "-wal"};

    public static File a(Context context) {
        if (Build.VERSION.SDK_INT < 23) {
            return b(context);
        }
        return c(context, "androidx.work.workdb");
    }

    public static File b(Context context) {
        return context.getDatabasePath("androidx.work.workdb");
    }

    public static File c(Context context, String str) {
        return new File(context.getNoBackupFilesDir(), str);
    }

    public static String d() {
        return "androidx.work.workdb";
    }

    public static void e(Context context) {
        String str;
        File b10 = b(context);
        if (Build.VERSION.SDK_INT >= 23 && b10.exists()) {
            k.c().a(f4149a, "Migrating WorkDatabase to the no-backup directory", new Throwable[0]);
            Map f10 = f(context);
            for (File file : f10.keySet()) {
                File file2 = (File) f10.get(file);
                if (file.exists() && file2 != null) {
                    if (file2.exists()) {
                        k.c().h(f4149a, String.format("Over-writing contents of %s", new Object[]{file2}), new Throwable[0]);
                    }
                    if (file.renameTo(file2)) {
                        str = String.format("Migrated %s to %s", new Object[]{file, file2});
                    } else {
                        str = String.format("Renaming %s to %s failed", new Object[]{file, file2});
                    }
                    k.c().a(f4149a, str, new Throwable[0]);
                }
            }
        }
    }

    public static Map f(Context context) {
        HashMap hashMap = new HashMap();
        if (Build.VERSION.SDK_INT >= 23) {
            File b10 = b(context);
            File a10 = a(context);
            hashMap.put(b10, a10);
            for (String str : f4150b) {
                hashMap.put(new File(b10.getPath() + str), new File(a10.getPath() + str));
            }
        }
        return hashMap;
    }
}
