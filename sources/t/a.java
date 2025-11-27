package t;

import android.content.Context;
import java.util.WeakHashMap;

public final class a {

    /* renamed from: b  reason: collision with root package name */
    public static final WeakHashMap f9337b = new WeakHashMap();

    /* renamed from: a  reason: collision with root package name */
    public final Context f9338a;

    public a(Context context) {
        this.f9338a = context;
    }

    public static a a(Context context) {
        a aVar;
        WeakHashMap weakHashMap = f9337b;
        synchronized (weakHashMap) {
            aVar = (a) weakHashMap.get(context);
            if (aVar == null) {
                aVar = new a(context);
                weakHashMap.put(context, aVar);
            }
        }
        return aVar;
    }
}
