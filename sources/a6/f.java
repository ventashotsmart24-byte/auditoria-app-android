package a6;

import com.mobile.brasiltv.utils.b0;
import i9.j;
import java.util.ArrayList;
import t9.i;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    public static final f f10686a = new f();

    /* renamed from: b  reason: collision with root package name */
    public static final String f10687b = "google";

    /* renamed from: c  reason: collision with root package name */
    public static final String f10688c = "facebook";

    /* renamed from: d  reason: collision with root package name */
    public static final ArrayList f10689d = j.c("google");

    public final boolean a() {
        return f10689d.contains(f10687b);
    }

    public final void b(ArrayList arrayList) {
        ArrayList arrayList2 = f10689d;
        arrayList2.clear();
        if (!b0.G(arrayList)) {
            i.d(arrayList);
            arrayList2.addAll(arrayList);
        }
    }
}
