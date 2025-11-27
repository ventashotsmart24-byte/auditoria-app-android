package q2;

import android.os.Build;
import java.lang.reflect.Field;

public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f8934a;

    public static void a() {
        if (!f8934a) {
            f8934a = true;
            try {
                Class<?> cls = Class.forName("android.app.QueuedWork");
                if (Build.VERSION.SDK_INT >= 26) {
                    Field declaredField = cls.getDeclaredField("sFinishers");
                    declaredField.setAccessible(true);
                    declaredField.set((Object) null, new c());
                    return;
                }
                Field declaredField2 = cls.getDeclaredField("sPendingWorkFinishers");
                declaredField2.setAccessible(true);
                declaredField2.set((Object) null, new b());
            } catch (Throwable th) {
                th.printStackTrace();
                m2.a.a(th, "FIX SP ANR FAIL");
            }
        }
    }
}
