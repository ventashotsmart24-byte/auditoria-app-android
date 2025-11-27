package d4;

import java.io.Serializable;

public class b0 implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    public static final b0 f6244a = new b0();

    public static final class a extends b0 {

        /* renamed from: b  reason: collision with root package name */
        public final Class[] f6245b;

        public a(Class[] clsArr) {
            this.f6245b = clsArr;
        }

        public boolean b(Class cls) {
            for (Class cls2 : this.f6245b) {
                if (cls == cls2 || cls2.isAssignableFrom(cls)) {
                    return true;
                }
            }
            return false;
        }
    }

    public static final class b extends b0 {

        /* renamed from: b  reason: collision with root package name */
        public final Class f6246b;

        public b(Class cls) {
            this.f6246b = cls;
        }

        public boolean b(Class cls) {
            Class cls2 = this.f6246b;
            if (cls == cls2 || cls2.isAssignableFrom(cls)) {
                return true;
            }
            return false;
        }
    }

    public static b0 a(Class[] clsArr) {
        if (clsArr == null) {
            return f6244a;
        }
        int length = clsArr.length;
        if (length == 0) {
            return f6244a;
        }
        if (length != 1) {
            return new a(clsArr);
        }
        return new b(clsArr[0]);
    }

    public boolean b(Class cls) {
        return false;
    }
}
