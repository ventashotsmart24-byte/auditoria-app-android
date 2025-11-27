package n0;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class q0 {

    /* renamed from: a  reason: collision with root package name */
    public final List f8002a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f8003b;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public List f8004a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f8005b = false;

        public a a(n0 n0Var) {
            if (n0Var != null) {
                List list = this.f8004a;
                if (list == null) {
                    this.f8004a = new ArrayList();
                } else if (list.contains(n0Var)) {
                    throw new IllegalArgumentException("route descriptor already added");
                }
                this.f8004a.add(n0Var);
                return this;
            }
            throw new IllegalArgumentException("route must not be null");
        }

        public a b(Collection collection) {
            if (collection != null) {
                if (!collection.isEmpty()) {
                    Iterator it = collection.iterator();
                    while (it.hasNext()) {
                        a((n0) it.next());
                    }
                }
                return this;
            }
            throw new IllegalArgumentException("routes must not be null");
        }

        public q0 c() {
            return new q0(this.f8004a, this.f8005b);
        }

        public a d(boolean z10) {
            this.f8005b = z10;
            return this;
        }
    }

    public q0(List list, boolean z10) {
        this.f8002a = list == null ? Collections.emptyList() : list;
        this.f8003b = z10;
    }

    public static q0 a(Bundle bundle) {
        ArrayList arrayList = null;
        if (bundle == null) {
            return null;
        }
        ArrayList parcelableArrayList = bundle.getParcelableArrayList("routes");
        if (parcelableArrayList != null && !parcelableArrayList.isEmpty()) {
            int size = parcelableArrayList.size();
            ArrayList arrayList2 = new ArrayList(size);
            for (int i10 = 0; i10 < size; i10++) {
                arrayList2.add(n0.d((Bundle) parcelableArrayList.get(i10)));
            }
            arrayList = arrayList2;
        }
        return new q0(arrayList, bundle.getBoolean("supportsDynamicGroupRoute", false));
    }

    public List b() {
        return this.f8002a;
    }

    public boolean c() {
        int size = b().size();
        for (int i10 = 0; i10 < size; i10++) {
            n0 n0Var = (n0) this.f8002a.get(i10);
            if (n0Var == null || !n0Var.x()) {
                return false;
            }
        }
        return true;
    }

    public boolean d() {
        return this.f8003b;
    }

    public String toString() {
        return "MediaRouteProviderDescriptor{ " + "routes=" + Arrays.toString(b().toArray()) + ", isValid=" + c() + " }";
    }
}
