package b3;

import java.io.Serializable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Retention(RetentionPolicy.RUNTIME)
public @interface p {

    public static class a implements Serializable {

        /* renamed from: f  reason: collision with root package name */
        public static final a f4283f = new a(Collections.emptySet(), false, false, false, true);

        /* renamed from: a  reason: collision with root package name */
        public final Set f4284a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f4285b;

        /* renamed from: c  reason: collision with root package name */
        public final boolean f4286c;

        /* renamed from: d  reason: collision with root package name */
        public final boolean f4287d;

        /* renamed from: e  reason: collision with root package name */
        public final boolean f4288e;

        public a(Set set, boolean z10, boolean z11, boolean z12, boolean z13) {
            if (set == null) {
                this.f4284a = Collections.emptySet();
            } else {
                this.f4284a = set;
            }
            this.f4285b = z10;
            this.f4286c = z11;
            this.f4287d = z12;
            this.f4288e = z13;
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

        public static boolean b(Set set, boolean z10, boolean z11, boolean z12, boolean z13) {
            a aVar = f4283f;
            if (z10 != aVar.f4285b || z11 != aVar.f4286c || z12 != aVar.f4287d || z13 != aVar.f4288e) {
                return false;
            }
            if (set == null || set.size() == 0) {
                return true;
            }
            return false;
        }

        public static boolean c(a aVar, a aVar2) {
            if (aVar.f4285b == aVar2.f4285b && aVar.f4288e == aVar2.f4288e && aVar.f4286c == aVar2.f4286c && aVar.f4287d == aVar2.f4287d && aVar.f4284a.equals(aVar2.f4284a)) {
                return true;
            }
            return false;
        }

        public static Set d(Set set, Set set2) {
            if (set.isEmpty()) {
                return set2;
            }
            if (set2.isEmpty()) {
                return set;
            }
            HashSet hashSet = new HashSet(set.size() + set2.size());
            hashSet.addAll(set);
            hashSet.addAll(set2);
            return hashSet;
        }

        public static a e(Set set, boolean z10, boolean z11, boolean z12, boolean z13) {
            if (b(set, z10, z11, z12, z13)) {
                return f4283f;
            }
            return new a(set, z10, z11, z12, z13);
        }

        public static a f() {
            return f4283f;
        }

        public static a i(p pVar) {
            if (pVar == null) {
                return f4283f;
            }
            return e(a(pVar.value()), pVar.ignoreUnknown(), pVar.allowGetters(), pVar.allowSetters(), false);
        }

        public static a k(a aVar, a aVar2) {
            if (aVar == null) {
                return aVar2;
            }
            return aVar.l(aVar2);
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj != null && obj.getClass() == getClass() && c(this, (a) obj)) {
                return true;
            }
            return false;
        }

        public Set g() {
            if (this.f4287d) {
                return Collections.emptySet();
            }
            return this.f4284a;
        }

        public Set h() {
            if (this.f4286c) {
                return Collections.emptySet();
            }
            return this.f4284a;
        }

        public int hashCode() {
            int i10;
            int i11;
            int i12;
            int i13;
            int size = this.f4284a.size();
            if (this.f4285b) {
                i10 = 1;
            } else {
                i10 = -3;
            }
            int i14 = size + i10;
            if (this.f4286c) {
                i11 = 3;
            } else {
                i11 = -7;
            }
            int i15 = i14 + i11;
            if (this.f4287d) {
                i12 = 7;
            } else {
                i12 = -11;
            }
            int i16 = i15 + i12;
            if (this.f4288e) {
                i13 = 11;
            } else {
                i13 = -13;
            }
            return i16 + i13;
        }

        public boolean j() {
            return this.f4285b;
        }

        public a l(a aVar) {
            boolean z10;
            boolean z11;
            if (aVar == null || aVar == f4283f) {
                return this;
            }
            if (!aVar.f4288e) {
                return aVar;
            }
            if (c(this, aVar)) {
                return this;
            }
            Set d10 = d(this.f4284a, aVar.f4284a);
            boolean z12 = false;
            if (this.f4285b || aVar.f4285b) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (this.f4286c || aVar.f4286c) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (this.f4287d || aVar.f4287d) {
                z12 = true;
            }
            return e(d10, z10, z11, z12, true);
        }

        public String toString() {
            return String.format("JsonIgnoreProperties.Value(ignored=%s,ignoreUnknown=%s,allowGetters=%s,allowSetters=%s,merge=%s)", new Object[]{this.f4284a, Boolean.valueOf(this.f4285b), Boolean.valueOf(this.f4286c), Boolean.valueOf(this.f4287d), Boolean.valueOf(this.f4288e)});
        }
    }

    boolean allowGetters() default false;

    boolean allowSetters() default false;

    boolean ignoreUnknown() default false;

    String[] value() default {};
}
