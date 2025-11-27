package f4;

import android.util.Property;

public abstract class c extends Property {
    public c(String str) {
        super(Integer.class, str);
    }

    /* renamed from: a */
    public final void set(Object obj, Integer num) {
        b(obj, num.intValue());
    }

    public abstract void b(Object obj, int i10);
}
