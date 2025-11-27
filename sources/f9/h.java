package f9;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.hpplay.sdk.source.common.global.Constant;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import y8.a;
import y8.k1;
import y8.o0;
import y8.p;
import y8.q;
import y8.x;

public final class h extends o0 {

    /* renamed from: h  reason: collision with root package name */
    public static final a.c f16834h = a.c.a("state-info");

    /* renamed from: i  reason: collision with root package name */
    public static final k1 f16835i = k1.f20041f.r("no subchannels ready");

    /* renamed from: c  reason: collision with root package name */
    public final o0.d f16836c;

    /* renamed from: d  reason: collision with root package name */
    public final Map f16837d = new HashMap();

    /* renamed from: e  reason: collision with root package name */
    public final Random f16838e;

    /* renamed from: f  reason: collision with root package name */
    public p f16839f;

    /* renamed from: g  reason: collision with root package name */
    public e f16840g = new b(f16835i);

    public class a implements o0.j {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ o0.h f16841a;

        public a(o0.h hVar) {
            this.f16841a = hVar;
        }

        public void a(q qVar) {
            h.this.k(this.f16841a, qVar);
        }
    }

    public static final class b extends e {

        /* renamed from: a  reason: collision with root package name */
        public final k1 f16843a;

        public b(k1 k1Var) {
            super((a) null);
            this.f16843a = (k1) Preconditions.checkNotNull(k1Var, Constant.KEY_STATUS);
        }

        public o0.e a(o0.f fVar) {
            if (this.f16843a.p()) {
                return o0.e.g();
            }
            return o0.e.f(this.f16843a);
        }

        public boolean b(e eVar) {
            if (eVar instanceof b) {
                b bVar = (b) eVar;
                if (Objects.equal(this.f16843a, bVar.f16843a) || (this.f16843a.p() && bVar.f16843a.p())) {
                    return true;
                }
            }
            return false;
        }

        public String toString() {
            return MoreObjects.toStringHelper((Class<?>) b.class).add(Constant.KEY_STATUS, (Object) this.f16843a).toString();
        }
    }

    public static final class c extends e {

        /* renamed from: c  reason: collision with root package name */
        public static final AtomicIntegerFieldUpdater f16844c = AtomicIntegerFieldUpdater.newUpdater(c.class, c8.b.f11376b);

        /* renamed from: a  reason: collision with root package name */
        public final List f16845a;

        /* renamed from: b  reason: collision with root package name */
        public volatile int f16846b;

        public c(List list, int i10) {
            super((a) null);
            Preconditions.checkArgument(!list.isEmpty(), "empty list");
            this.f16845a = list;
            this.f16846b = i10 - 1;
        }

        public o0.e a(o0.f fVar) {
            return o0.e.h(c());
        }

        public boolean b(e eVar) {
            if (!(eVar instanceof c)) {
                return false;
            }
            c cVar = (c) eVar;
            if (cVar == this || (this.f16845a.size() == cVar.f16845a.size() && new HashSet(this.f16845a).containsAll(cVar.f16845a))) {
                return true;
            }
            return false;
        }

        public final o0.h c() {
            int size = this.f16845a.size();
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f16844c;
            int incrementAndGet = atomicIntegerFieldUpdater.incrementAndGet(this);
            if (incrementAndGet >= size) {
                int i10 = incrementAndGet % size;
                atomicIntegerFieldUpdater.compareAndSet(this, incrementAndGet, i10);
                incrementAndGet = i10;
            }
            return (o0.h) this.f16845a.get(incrementAndGet);
        }

        public String toString() {
            return MoreObjects.toStringHelper((Class<?>) c.class).add("list", (Object) this.f16845a).toString();
        }
    }

    public static final class d {

        /* renamed from: a  reason: collision with root package name */
        public Object f16847a;

        public d(Object obj) {
            this.f16847a = obj;
        }
    }

    public static abstract class e extends o0.i {
        public e() {
        }

        public abstract boolean b(e eVar);

        public /* synthetic */ e(a aVar) {
            this();
        }
    }

    public h(o0.d dVar) {
        this.f16836c = (o0.d) Preconditions.checkNotNull(dVar, "helper");
        this.f16838e = new Random();
    }

    public static List g(Collection collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            o0.h hVar = (o0.h) it.next();
            if (j(hVar)) {
                arrayList.add(hVar);
            }
        }
        return arrayList;
    }

    public static d h(o0.h hVar) {
        return (d) Preconditions.checkNotNull((d) hVar.c().b(f16834h), "STATE_INFO");
    }

    public static boolean j(o0.h hVar) {
        if (((q) h(hVar).f16847a).c() == p.READY) {
            return true;
        }
        return false;
    }

    public static Set l(Set set, Set set2) {
        HashSet hashSet = new HashSet(set);
        hashSet.removeAll(set2);
        return hashSet;
    }

    public static Map n(List list) {
        HashMap hashMap = new HashMap(list.size() * 2);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            x xVar = (x) it.next();
            hashMap.put(o(xVar), xVar);
        }
        return hashMap;
    }

    public static x o(x xVar) {
        return new x(xVar.a());
    }

    public boolean a(o0.g gVar) {
        if (gVar.a().isEmpty()) {
            k1 k1Var = k1.f20056u;
            c(k1Var.r("NameResolver returned no usable address. addrs=" + gVar.a() + ", attrs=" + gVar.b()));
            return false;
        }
        List a10 = gVar.a();
        Set keySet = this.f16837d.keySet();
        Map n10 = n(a10);
        Set<x> l10 = l(keySet, n10.keySet());
        for (Map.Entry entry : n10.entrySet()) {
            x xVar = (x) entry.getKey();
            x xVar2 = (x) entry.getValue();
            o0.h hVar = (o0.h) this.f16837d.get(xVar);
            if (hVar != null) {
                hVar.h(Collections.singletonList(xVar2));
            } else {
                o0.h hVar2 = (o0.h) Preconditions.checkNotNull(this.f16836c.a(o0.b.c().e(xVar2).f(y8.a.c().d(f16834h, new d(q.a(p.IDLE))).a()).b()), "subchannel");
                hVar2.g(new a(hVar2));
                this.f16837d.put(xVar, hVar2);
                hVar2.e();
            }
        }
        ArrayList arrayList = new ArrayList();
        for (x remove : l10) {
            arrayList.add((o0.h) this.f16837d.remove(remove));
        }
        p();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            m((o0.h) it.next());
        }
        return true;
    }

    public void c(k1 k1Var) {
        if (this.f16839f != p.READY) {
            q(p.TRANSIENT_FAILURE, new b(k1Var));
        }
    }

    public void e() {
        for (o0.h m10 : i()) {
            m(m10);
        }
        this.f16837d.clear();
    }

    public Collection i() {
        return this.f16837d.values();
    }

    public final void k(o0.h hVar, q qVar) {
        if (this.f16837d.get(o(hVar.a())) == hVar) {
            p c10 = qVar.c();
            p pVar = p.TRANSIENT_FAILURE;
            if (c10 == pVar || qVar.c() == p.IDLE) {
                this.f16836c.e();
            }
            p c11 = qVar.c();
            p pVar2 = p.IDLE;
            if (c11 == pVar2) {
                hVar.e();
            }
            d h10 = h(hVar);
            if (!((q) h10.f16847a).c().equals(pVar) || (!qVar.c().equals(p.CONNECTING) && !qVar.c().equals(pVar2))) {
                h10.f16847a = qVar;
                p();
            }
        }
    }

    public final void m(o0.h hVar) {
        hVar.f();
        h(hVar).f16847a = q.a(p.SHUTDOWN);
    }

    public final void p() {
        p pVar;
        List g10 = g(i());
        if (g10.isEmpty()) {
            k1 k1Var = f16835i;
            boolean z10 = false;
            for (o0.h h10 : i()) {
                q qVar = (q) h(h10).f16847a;
                if (qVar.c() == p.CONNECTING || qVar.c() == p.IDLE) {
                    z10 = true;
                }
                if (k1Var == f16835i || !k1Var.p()) {
                    k1Var = qVar.d();
                }
            }
            if (z10) {
                pVar = p.CONNECTING;
            } else {
                pVar = p.TRANSIENT_FAILURE;
            }
            q(pVar, new b(k1Var));
            return;
        }
        q(p.READY, new c(g10, this.f16838e.nextInt(g10.size())));
    }

    public final void q(p pVar, e eVar) {
        if (pVar != this.f16839f || !eVar.b(this.f16840g)) {
            this.f16836c.f(pVar, eVar);
            this.f16839f = pVar;
            this.f16840g = eVar;
        }
    }
}
