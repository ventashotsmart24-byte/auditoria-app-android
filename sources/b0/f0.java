package b0;

import android.content.Context;
import android.os.Build;
import android.view.PointerIcon;

public final class f0 {

    /* renamed from: a  reason: collision with root package name */
    public Object f4070a;

    public f0(Object obj) {
        this.f4070a = obj;
    }

    public static f0 b(Context context, int i10) {
        if (Build.VERSION.SDK_INT >= 24) {
            return new f0(PointerIcon.getSystemIcon(context, i10));
        }
        return new f0((Object) null);
    }

    public Object a() {
        return this.f4070a;
    }
}
