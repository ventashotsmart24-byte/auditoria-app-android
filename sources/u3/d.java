package u3;

import java.util.HashMap;
import java.util.Map;

public enum d {
    STRING,
    NUMBER,
    INTEGER,
    BOOLEAN,
    OBJECT,
    ARRAY,
    NULL,
    ANY;
    

    /* renamed from: i  reason: collision with root package name */
    public static final Map f9446i = null;

    /* access modifiers changed from: public */
    static {
        int i10;
        f9446i = new HashMap();
        for (d dVar : values()) {
            f9446i.put(dVar.name().toLowerCase(), dVar);
        }
    }
}
