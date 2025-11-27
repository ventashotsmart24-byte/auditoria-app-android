package f4;

import android.util.Property;

public abstract class b extends Property {
    public b(String str) {
        super(Float.class, str);
    }

    /* renamed from: a */
    public final void set(Object obj, Float f10) {
        b(obj, f10.floatValue());
    }

    public abstract void b(Object obj, float f10);
}
