package b3;

import java.io.Serializable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Retention(RetentionPolicy.RUNTIME)
public @interface s {

    public static class a implements Serializable {

        /* renamed from: b  reason: collision with root package name */
        public static final a f4314b = new a((Set) null);

        /* renamed from: a  reason: collision with root package name */
        public final Set f4315a;

        public a(Set set) {
            this.f4315a = set;
        }

        public static Set a(String[] strArr) {
            if (strArr == null || strArr.length == 0) {
                return Collections.emptySet();
            }
            HashSet hashSet = new HashSet(strArr.length);
            for (String add : strArr) {
                hashSet.add(add);
            }
            return hashSet;
        }

        public static boolean b(Set set, Set set2) {
            if (set != null) {
                return set.equals(set2);
            }
            if (set2 == null) {
                return true;
            }
            return false;
        }

        public static a c() {
            return f4314b;
        }

        public static a d(s sVar) {
            if (sVar == null) {
                return f4314b;
            }
            return new a(a(sVar.value()));
        }

        public Set e() {
            return this.f4315a;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj != null && obj.getClass() == getClass() && b(this.f4315a, ((a) obj).f4315a)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            Set set = this.f4315a;
            if (set == null) {
                return 0;
            }
            return set.size();
        }

        public String toString() {
            return String.format("JsonIncludeProperties.Value(included=%s)", new Object[]{this.f4315a});
        }
    }

    String[] value() default {};
}
