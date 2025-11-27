package b3;

import java.io.Serializable;

public abstract class k0 implements Serializable {

    public static final class a implements Serializable {

        /* renamed from: a  reason: collision with root package name */
        public final Class f4278a;

        /* renamed from: b  reason: collision with root package name */
        public final Class f4279b;

        /* renamed from: c  reason: collision with root package name */
        public final Object f4280c;

        /* renamed from: d  reason: collision with root package name */
        public final int f4281d;

        public a(Class cls, Class cls2, Object obj) {
            if (obj != null) {
                this.f4278a = cls;
                this.f4279b = cls2;
                this.f4280c = obj;
                int hashCode = obj.hashCode() + cls.getName().hashCode();
                this.f4281d = cls2 != null ? hashCode ^ cls2.getName().hashCode() : hashCode;
                return;
            }
            throw new IllegalArgumentException("Can not construct IdKey for null key");
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj == null || obj.getClass() != a.class) {
                return false;
            }
            a aVar = (a) obj;
            if (aVar.f4280c.equals(this.f4280c) && aVar.f4278a == this.f4278a && aVar.f4279b == this.f4279b) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.f4281d;
        }

        public String toString() {
            String str;
            Object[] objArr = new Object[3];
            objArr[0] = this.f4280c;
            Class cls = this.f4278a;
            String str2 = "NONE";
            if (cls == null) {
                str = str2;
            } else {
                str = cls.getName();
            }
            objArr[1] = str;
            Class cls2 = this.f4279b;
            if (cls2 != null) {
                str2 = cls2.getName();
            }
            objArr[2] = str2;
            return String.format("[ObjectId: key=%s, type=%s, scope=%s]", objArr);
        }
    }

    public abstract boolean a(k0 k0Var);

    public abstract k0 b(Class cls);

    public abstract Object c(Object obj);

    public abstract Class d();

    public boolean e(String str, Object obj) {
        return false;
    }

    public abstract a f(Object obj);

    public boolean g() {
        return false;
    }

    public abstract k0 h(Object obj);
}
