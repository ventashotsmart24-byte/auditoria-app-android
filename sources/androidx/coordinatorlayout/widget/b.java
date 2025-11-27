package androidx.coordinatorlayout.widget;

import a0.e;
import a0.f;
import androidx.collection.g;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public final e f1740a = new f(10);

    /* renamed from: b  reason: collision with root package name */
    public final g f1741b = new g();

    /* renamed from: c  reason: collision with root package name */
    public final ArrayList f1742c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public final HashSet f1743d = new HashSet();

    public void a(Object obj, Object obj2) {
        if (!this.f1741b.containsKey(obj) || !this.f1741b.containsKey(obj2)) {
            throw new IllegalArgumentException("All nodes must be present in the graph before being added as an edge");
        }
        ArrayList arrayList = (ArrayList) this.f1741b.get(obj);
        if (arrayList == null) {
            arrayList = f();
            this.f1741b.put(obj, arrayList);
        }
        arrayList.add(obj2);
    }

    public void b(Object obj) {
        if (!this.f1741b.containsKey(obj)) {
            this.f1741b.put(obj, (Object) null);
        }
    }

    public void c() {
        int size = this.f1741b.size();
        for (int i10 = 0; i10 < size; i10++) {
            ArrayList arrayList = (ArrayList) this.f1741b.valueAt(i10);
            if (arrayList != null) {
                k(arrayList);
            }
        }
        this.f1741b.clear();
    }

    public boolean d(Object obj) {
        return this.f1741b.containsKey(obj);
    }

    public final void e(Object obj, ArrayList arrayList, HashSet hashSet) {
        if (!arrayList.contains(obj)) {
            if (!hashSet.contains(obj)) {
                hashSet.add(obj);
                ArrayList arrayList2 = (ArrayList) this.f1741b.get(obj);
                if (arrayList2 != null) {
                    int size = arrayList2.size();
                    for (int i10 = 0; i10 < size; i10++) {
                        e(arrayList2.get(i10), arrayList, hashSet);
                    }
                }
                hashSet.remove(obj);
                arrayList.add(obj);
                return;
            }
            throw new RuntimeException("This graph contains cyclic dependencies");
        }
    }

    public final ArrayList f() {
        ArrayList arrayList = (ArrayList) this.f1740a.acquire();
        if (arrayList == null) {
            return new ArrayList();
        }
        return arrayList;
    }

    public List g(Object obj) {
        return (List) this.f1741b.get(obj);
    }

    public List h(Object obj) {
        int size = this.f1741b.size();
        ArrayList arrayList = null;
        for (int i10 = 0; i10 < size; i10++) {
            ArrayList arrayList2 = (ArrayList) this.f1741b.valueAt(i10);
            if (arrayList2 != null && arrayList2.contains(obj)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(this.f1741b.keyAt(i10));
            }
        }
        return arrayList;
    }

    public ArrayList i() {
        this.f1742c.clear();
        this.f1743d.clear();
        int size = this.f1741b.size();
        for (int i10 = 0; i10 < size; i10++) {
            e(this.f1741b.keyAt(i10), this.f1742c, this.f1743d);
        }
        return this.f1742c;
    }

    public boolean j(Object obj) {
        int size = this.f1741b.size();
        for (int i10 = 0; i10 < size; i10++) {
            ArrayList arrayList = (ArrayList) this.f1741b.valueAt(i10);
            if (arrayList != null && arrayList.contains(obj)) {
                return true;
            }
        }
        return false;
    }

    public final void k(ArrayList arrayList) {
        arrayList.clear();
        this.f1740a.release(arrayList);
    }
}
