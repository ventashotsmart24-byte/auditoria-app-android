package ma;

import android.app.Activity;
import java.util.ArrayList;
import java.util.List;
import t9.i;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final b f18991a = new b();

    /* renamed from: b  reason: collision with root package name */
    public static List f18992b = new ArrayList();

    public final void a(Activity activity) {
        i.g(activity, "activity");
        f18992b.add(activity);
    }

    public final void b() {
        for (Activity activity : f18992b) {
            if (!activity.isFinishing()) {
                activity.finish();
            }
        }
    }

    public final Activity c() {
        List list = f18992b;
        return (Activity) list.get(list.size() - 1);
    }

    public final void d(Activity activity) {
        i.g(activity, "activity");
        f18992b.remove(activity);
    }
}
