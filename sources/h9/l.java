package h9;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.io.Serializable;
import t9.g;
import t9.i;

public abstract class l implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    public static final a f17317a = new a((g) null);

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }

    public static final class b implements Serializable {

        /* renamed from: a  reason: collision with root package name */
        public final Throwable f17318a;

        public b(Throwable th) {
            i.g(th, "exception");
            this.f17318a = th;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof b) || !i.b(this.f17318a, ((b) obj).f17318a)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return this.f17318a.hashCode();
        }

        public String toString() {
            return "Failure(" + this.f17318a + ASCIIPropertyListParser.ARRAY_END_TOKEN;
        }
    }

    public static Object a(Object obj) {
        return obj;
    }

    public static final Throwable b(Object obj) {
        if (obj instanceof b) {
            return ((b) obj).f17318a;
        }
        return null;
    }

    public static final boolean c(Object obj) {
        return obj instanceof b;
    }

    public static final boolean d(Object obj) {
        return !(obj instanceof b);
    }
}
