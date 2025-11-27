package o;

import android.app.AppOpsManager;
import android.app.NotificationManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import com.taobao.accs.flowcontrol.FlowControl;
import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.Set;

public final class i1 {

    /* renamed from: c  reason: collision with root package name */
    public static final Object f8335c = new Object();

    /* renamed from: d  reason: collision with root package name */
    public static Set f8336d = new HashSet();

    /* renamed from: e  reason: collision with root package name */
    public static final Object f8337e = new Object();

    /* renamed from: a  reason: collision with root package name */
    public final Context f8338a;

    /* renamed from: b  reason: collision with root package name */
    public final NotificationManager f8339b;

    public i1(Context context) {
        this.f8338a = context;
        this.f8339b = (NotificationManager) context.getSystemService("notification");
    }

    public static i1 b(Context context) {
        return new i1(context);
    }

    public boolean a() {
        if (Build.VERSION.SDK_INT >= 24) {
            return this.f8339b.areNotificationsEnabled();
        }
        AppOpsManager appOpsManager = (AppOpsManager) this.f8338a.getSystemService("appops");
        ApplicationInfo applicationInfo = this.f8338a.getApplicationInfo();
        String packageName = this.f8338a.getApplicationContext().getPackageName();
        int i10 = applicationInfo.uid;
        try {
            Class<?> cls = Class.forName(AppOpsManager.class.getName());
            Class cls2 = Integer.TYPE;
            if (((Integer) cls.getMethod("checkOpNoThrow", new Class[]{cls2, cls2, String.class}).invoke(appOpsManager, new Object[]{Integer.valueOf(((Integer) cls.getDeclaredField("OP_POST_NOTIFICATION").get(Integer.class)).intValue()), Integer.valueOf(i10), packageName})).intValue() == 0) {
                return true;
            }
            return false;
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException | NoSuchMethodException | RuntimeException | InvocationTargetException unused) {
            return true;
        }
    }

    public int c() {
        if (Build.VERSION.SDK_INT >= 24) {
            return this.f8339b.getImportance();
        }
        return FlowControl.DELAY_MAX_BRUSH;
    }
}
