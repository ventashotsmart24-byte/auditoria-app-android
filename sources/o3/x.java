package o3;

import java.util.Map;
import n3.s;
import n3.t;

public abstract class x {

    /* renamed from: a  reason: collision with root package name */
    public final x f8548a;

    /* renamed from: b  reason: collision with root package name */
    public final Object f8549b;

    public static final class a extends x {

        /* renamed from: c  reason: collision with root package name */
        public final s f8550c;

        /* renamed from: d  reason: collision with root package name */
        public final String f8551d;

        public a(x xVar, Object obj, s sVar, String str) {
            super(xVar, obj);
            this.f8550c = sVar;
            this.f8551d = str;
        }

        public void a(Object obj) {
            this.f8550c.i(obj, this.f8551d, this.f8549b);
        }
    }

    public static final class b extends x {

        /* renamed from: c  reason: collision with root package name */
        public final Object f8552c;

        public b(x xVar, Object obj, Object obj2) {
            super(xVar, obj);
            this.f8552c = obj2;
        }

        public void a(Object obj) {
            ((Map) obj).put(this.f8552c, this.f8549b);
        }
    }

    public static final class c extends x {

        /* renamed from: c  reason: collision with root package name */
        public final t f8553c;

        public c(x xVar, Object obj, t tVar) {
            super(xVar, obj);
            this.f8553c = tVar;
        }

        public void a(Object obj) {
            this.f8553c.C(obj, this.f8549b);
        }
    }

    public x(x xVar, Object obj) {
        this.f8548a = xVar;
        this.f8549b = obj;
    }

    public abstract void a(Object obj);
}
