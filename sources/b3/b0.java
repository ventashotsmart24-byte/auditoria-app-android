package b3;

import java.io.Serializable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface b0 {

    public static class a implements Serializable {

        /* renamed from: c  reason: collision with root package name */
        public static final a f4209c;

        /* renamed from: a  reason: collision with root package name */
        public final j0 f4210a;

        /* renamed from: b  reason: collision with root package name */
        public final j0 f4211b;

        static {
            j0 j0Var = j0.DEFAULT;
            f4209c = new a(j0Var, j0Var);
        }

        public a(j0 j0Var, j0 j0Var2) {
            this.f4210a = j0Var;
            this.f4211b = j0Var2;
        }

        public static boolean a(j0 j0Var, j0 j0Var2) {
            j0 j0Var3 = j0.DEFAULT;
            if (j0Var == j0Var3 && j0Var2 == j0Var3) {
                return true;
            }
            return false;
        }

        public static a b(j0 j0Var, j0 j0Var2) {
            if (j0Var == null) {
                j0Var = j0.DEFAULT;
            }
            if (j0Var2 == null) {
                j0Var2 = j0.DEFAULT;
            }
            if (a(j0Var, j0Var2)) {
                return f4209c;
            }
            return new a(j0Var, j0Var2);
        }

        public static a c() {
            return f4209c;
        }

        public static a d(b0 b0Var) {
            if (b0Var == null) {
                return f4209c;
            }
            return b(b0Var.nulls(), b0Var.contentNulls());
        }

        public j0 e() {
            j0 j0Var = this.f4211b;
            if (j0Var == j0.DEFAULT) {
                return null;
            }
            return j0Var;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj == null || obj.getClass() != getClass()) {
                return false;
            }
            a aVar = (a) obj;
            if (aVar.f4210a == this.f4210a && aVar.f4211b == this.f4211b) {
                return true;
            }
            return false;
        }

        public j0 f() {
            j0 j0Var = this.f4210a;
            if (j0Var == j0.DEFAULT) {
                return null;
            }
            return j0Var;
        }

        public int hashCode() {
            return this.f4210a.ordinal() + (this.f4211b.ordinal() << 2);
        }

        public String toString() {
            return String.format("JsonSetter.Value(valueNulls=%s,contentNulls=%s)", new Object[]{this.f4210a, this.f4211b});
        }
    }

    j0 contentNulls() default j0.DEFAULT;

    j0 nulls() default j0.DEFAULT;

    String value() default "";
}
