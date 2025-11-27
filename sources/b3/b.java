package b3;

import java.io.Serializable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface b {

    public static class a implements Serializable {

        /* renamed from: c  reason: collision with root package name */
        public static final a f4206c = new a((Object) null, (Boolean) null);

        /* renamed from: a  reason: collision with root package name */
        public final Object f4207a;

        /* renamed from: b  reason: collision with root package name */
        public final Boolean f4208b;

        public a(Object obj, Boolean bool) {
            this.f4207a = obj;
            this.f4208b = bool;
        }

        public static boolean a(Object obj, Boolean bool) {
            return obj == null && bool == null;
        }

        public static a b(Object obj, Boolean bool) {
            if ("".equals(obj)) {
                obj = null;
            }
            if (a(obj, bool)) {
                return f4206c;
            }
            return new a(obj, bool);
        }

        public static a c(Object obj) {
            return b(obj, (Boolean) null);
        }

        public static a d(b bVar) {
            if (bVar == null) {
                return f4206c;
            }
            return b(bVar.value(), bVar.useInput().a());
        }

        public Object e() {
            return this.f4207a;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj != null && obj.getClass() == getClass()) {
                a aVar = (a) obj;
                if (p0.b(this.f4208b, aVar.f4208b)) {
                    Object obj2 = this.f4207a;
                    if (obj2 != null) {
                        return obj2.equals(aVar.f4207a);
                    }
                    if (aVar.f4207a == null) {
                        return true;
                    }
                    return false;
                }
            }
            return false;
        }

        public boolean f() {
            if (this.f4207a != null) {
                return true;
            }
            return false;
        }

        public boolean g(boolean z10) {
            Boolean bool = this.f4208b;
            if (bool == null) {
                return z10;
            }
            return bool.booleanValue();
        }

        public a h(Object obj) {
            if (obj == null) {
                if (this.f4207a == null) {
                    return this;
                }
            } else if (obj.equals(this.f4207a)) {
                return this;
            }
            return new a(obj, this.f4208b);
        }

        public int hashCode() {
            Object obj = this.f4207a;
            int i10 = 1;
            if (obj != null) {
                i10 = 1 + obj.hashCode();
            }
            Boolean bool = this.f4208b;
            if (bool != null) {
                return i10 + bool.hashCode();
            }
            return i10;
        }

        public String toString() {
            return String.format("JacksonInject.Value(id=%s,useInput=%s)", new Object[]{this.f4207a, this.f4208b});
        }
    }

    p0 useInput() default p0.DEFAULT;

    String value() default "";
}
