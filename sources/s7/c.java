package s7;

import java.util.LinkedHashMap;
import java.util.Map;

public final class c extends LinkedHashMap {

    /* renamed from: a  reason: collision with root package name */
    public int f19475a;

    public c() {
        this(256);
    }

    public boolean removeEldestEntry(Map.Entry entry) {
        if (size() > this.f19475a) {
            return true;
        }
        return false;
    }

    public c(int i10) {
        super(i10, 1.0f, true);
        this.f19475a = i10;
    }
}
