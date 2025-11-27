package i8;

import t9.g;
import t9.i;

public enum b {
    IJK("ijk"),
    NATIVE("native"),
    EXO("exo"),
    NONE("none");
    

    /* renamed from: g  reason: collision with root package name */
    public static final a f17369g = null;

    /* renamed from: a  reason: collision with root package name */
    public String f17370a;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }

        public final b a(String str) {
            i.h(str, "property");
            for (b bVar : b.values()) {
                if (i.b(bVar.a(), str)) {
                    return bVar;
                }
            }
            return null;
        }
    }

    /* access modifiers changed from: public */
    static {
        f17369g = new a((g) null);
    }

    /* access modifiers changed from: public */
    b(String str) {
        i.h(str, "value");
        this.f17370a = str;
    }

    public final String a() {
        return this.f17370a;
    }
}
