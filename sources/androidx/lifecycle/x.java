package androidx.lifecycle;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class x {

    /* renamed from: a  reason: collision with root package name */
    public final HashMap f2346a = new HashMap();

    public final void a() {
        for (v a10 : this.f2346a.values()) {
            a10.a();
        }
        this.f2346a.clear();
    }

    public final v b(String str) {
        return (v) this.f2346a.get(str);
    }

    public Set c() {
        return new HashSet(this.f2346a.keySet());
    }

    public final void d(String str, v vVar) {
        v vVar2 = (v) this.f2346a.put(str, vVar);
        if (vVar2 != null) {
            vVar2.d();
        }
    }
}
