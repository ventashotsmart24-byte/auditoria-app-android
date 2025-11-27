package n0;

import android.content.IntentFilter;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class s0 {

    /* renamed from: c  reason: collision with root package name */
    public static final s0 f8047c = new s0(new Bundle(), (List) null);

    /* renamed from: a  reason: collision with root package name */
    public final Bundle f8048a;

    /* renamed from: b  reason: collision with root package name */
    public List f8049b;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public ArrayList f8050a;

        public a() {
        }

        public a a(Collection collection) {
            if (collection != null) {
                if (!collection.isEmpty()) {
                    Iterator it = collection.iterator();
                    while (it.hasNext()) {
                        b((String) it.next());
                    }
                }
                return this;
            }
            throw new IllegalArgumentException("categories must not be null");
        }

        public a b(String str) {
            if (str != null) {
                if (this.f8050a == null) {
                    this.f8050a = new ArrayList();
                }
                if (!this.f8050a.contains(str)) {
                    this.f8050a.add(str);
                }
                return this;
            }
            throw new IllegalArgumentException("category must not be null");
        }

        public a c(s0 s0Var) {
            if (s0Var != null) {
                a(s0Var.e());
                return this;
            }
            throw new IllegalArgumentException("selector must not be null");
        }

        public s0 d() {
            if (this.f8050a == null) {
                return s0.f8047c;
            }
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("controlCategories", this.f8050a);
            return new s0(bundle, this.f8050a);
        }

        public a(s0 s0Var) {
            if (s0Var != null) {
                s0Var.c();
                if (!s0Var.f8049b.isEmpty()) {
                    this.f8050a = new ArrayList(s0Var.f8049b);
                    return;
                }
                return;
            }
            throw new IllegalArgumentException("selector must not be null");
        }
    }

    public s0(Bundle bundle, List list) {
        this.f8048a = bundle;
        this.f8049b = list;
    }

    public static s0 d(Bundle bundle) {
        if (bundle != null) {
            return new s0(bundle, (List) null);
        }
        return null;
    }

    public Bundle a() {
        return this.f8048a;
    }

    public boolean b(s0 s0Var) {
        if (s0Var == null) {
            return false;
        }
        c();
        s0Var.c();
        return this.f8049b.containsAll(s0Var.f8049b);
    }

    public void c() {
        if (this.f8049b == null) {
            ArrayList<String> stringArrayList = this.f8048a.getStringArrayList("controlCategories");
            this.f8049b = stringArrayList;
            if (stringArrayList == null || stringArrayList.isEmpty()) {
                this.f8049b = Collections.emptyList();
            }
        }
    }

    public List e() {
        c();
        return this.f8049b;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof s0)) {
            return false;
        }
        s0 s0Var = (s0) obj;
        c();
        s0Var.c();
        return this.f8049b.equals(s0Var.f8049b);
    }

    public boolean f() {
        c();
        return this.f8049b.isEmpty();
    }

    public boolean g() {
        c();
        if (this.f8049b.contains((Object) null)) {
            return false;
        }
        return true;
    }

    public boolean h(List list) {
        if (list != null) {
            c();
            int size = this.f8049b.size();
            if (size != 0) {
                int size2 = list.size();
                for (int i10 = 0; i10 < size2; i10++) {
                    IntentFilter intentFilter = (IntentFilter) list.get(i10);
                    if (intentFilter != null) {
                        for (int i11 = 0; i11 < size; i11++) {
                            if (intentFilter.hasCategory((String) this.f8049b.get(i11))) {
                                return true;
                            }
                        }
                        continue;
                    }
                }
            }
        }
        return false;
    }

    public int hashCode() {
        c();
        return this.f8049b.hashCode();
    }

    public String toString() {
        return "MediaRouteSelector{ " + "controlCategories=" + Arrays.toString(e().toArray()) + " }";
    }
}
