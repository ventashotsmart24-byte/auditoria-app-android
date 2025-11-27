package b1;

import a1.d;
import a1.k;
import a1.n;
import a1.r;
import a1.u;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import k1.b;

public class g extends r {

    /* renamed from: j  reason: collision with root package name */
    public static final String f4139j = k.f("WorkContinuationImpl");

    /* renamed from: a  reason: collision with root package name */
    public final j f4140a;

    /* renamed from: b  reason: collision with root package name */
    public final String f4141b;

    /* renamed from: c  reason: collision with root package name */
    public final d f4142c;

    /* renamed from: d  reason: collision with root package name */
    public final List f4143d;

    /* renamed from: e  reason: collision with root package name */
    public final List f4144e;

    /* renamed from: f  reason: collision with root package name */
    public final List f4145f;

    /* renamed from: g  reason: collision with root package name */
    public final List f4146g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f4147h;

    /* renamed from: i  reason: collision with root package name */
    public n f4148i;

    public g(j jVar, List list) {
        this(jVar, (String) null, d.KEEP, list, (List) null);
    }

    public static boolean i(g gVar, Set set) {
        set.addAll(gVar.c());
        Set l10 = l(gVar);
        Iterator it = set.iterator();
        while (it.hasNext()) {
            if (l10.contains((String) it.next())) {
                return true;
            }
        }
        List<g> e10 = gVar.e();
        if (e10 != null && !e10.isEmpty()) {
            for (g i10 : e10) {
                if (i(i10, set)) {
                    return true;
                }
            }
        }
        set.removeAll(gVar.c());
        return false;
    }

    public static Set l(g gVar) {
        HashSet hashSet = new HashSet();
        List<g> e10 = gVar.e();
        if (e10 != null && !e10.isEmpty()) {
            for (g c10 : e10) {
                hashSet.addAll(c10.c());
            }
        }
        return hashSet;
    }

    public n a() {
        if (!this.f4147h) {
            b bVar = new b(this);
            this.f4140a.o().b(bVar);
            this.f4148i = bVar.d();
        } else {
            k.c().h(f4139j, String.format("Already enqueued work ids (%s)", new Object[]{TextUtils.join(", ", this.f4144e)}), new Throwable[0]);
        }
        return this.f4148i;
    }

    public d b() {
        return this.f4142c;
    }

    public List c() {
        return this.f4144e;
    }

    public String d() {
        return this.f4141b;
    }

    public List e() {
        return this.f4146g;
    }

    public List f() {
        return this.f4143d;
    }

    public j g() {
        return this.f4140a;
    }

    public boolean h() {
        return i(this, new HashSet());
    }

    public boolean j() {
        return this.f4147h;
    }

    public void k() {
        this.f4147h = true;
    }

    public g(j jVar, String str, d dVar, List list, List list2) {
        this.f4140a = jVar;
        this.f4141b = str;
        this.f4142c = dVar;
        this.f4143d = list;
        this.f4146g = list2;
        this.f4144e = new ArrayList(list.size());
        this.f4145f = new ArrayList();
        if (list2 != null) {
            Iterator it = list2.iterator();
            while (it.hasNext()) {
                this.f4145f.addAll(((g) it.next()).f4145f);
            }
        }
        for (int i10 = 0; i10 < list.size(); i10++) {
            String a10 = ((u) list.get(i10)).a();
            this.f4144e.add(a10);
            this.f4145f.add(a10);
        }
    }
}
