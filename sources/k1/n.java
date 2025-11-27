package k1;

import a1.k;
import android.content.Context;
import android.os.PowerManager;
import java.util.HashMap;
import java.util.WeakHashMap;

public abstract class n {

    /* renamed from: a  reason: collision with root package name */
    public static final String f7256a = k.f("WakeLocks");

    /* renamed from: b  reason: collision with root package name */
    public static final WeakHashMap f7257b = new WeakHashMap();

    public static void a() {
        HashMap hashMap = new HashMap();
        WeakHashMap weakHashMap = f7257b;
        synchronized (weakHashMap) {
            hashMap.putAll(weakHashMap);
        }
        for (PowerManager.WakeLock wakeLock : hashMap.keySet()) {
            if (wakeLock != null && wakeLock.isHeld()) {
                k.c().h(f7256a, String.format("WakeLock held for %s", new Object[]{hashMap.get(wakeLock)}), new Throwable[0]);
            }
        }
    }

    public static PowerManager.WakeLock b(Context context, String str) {
        String str2 = "WorkManager: " + str;
        PowerManager.WakeLock newWakeLock = ((PowerManager) context.getApplicationContext().getSystemService("power")).newWakeLock(1, str2);
        WeakHashMap weakHashMap = f7257b;
        synchronized (weakHashMap) {
            weakHashMap.put(newWakeLock, str2);
        }
        return newWakeLock;
    }
}
