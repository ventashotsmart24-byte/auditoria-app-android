package f9;

import com.google.common.base.Preconditions;
import com.google.common.collect.ForwardingMap;
import com.hpplay.cybergarage.upnp.ssdp.SSDP;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import y8.a;
import y8.k;
import y8.k1;
import y8.o0;
import y8.o1;
import y8.p;
import y8.q;
import y8.v0;
import y8.x;
import z8.c2;
import z8.j2;

public final class e extends o0 {

    /* renamed from: k  reason: collision with root package name */
    public static final a.c f16766k = a.c.a("addressTrackerKey");

    /* renamed from: c  reason: collision with root package name */
    public final c f16767c = new c();

    /* renamed from: d  reason: collision with root package name */
    public final o1 f16768d;

    /* renamed from: e  reason: collision with root package name */
    public final o0.d f16769e;

    /* renamed from: f  reason: collision with root package name */
    public final d f16770f;

    /* renamed from: g  reason: collision with root package name */
    public j2 f16771g;

    /* renamed from: h  reason: collision with root package name */
    public final ScheduledExecutorService f16772h;

    /* renamed from: i  reason: collision with root package name */
    public o1.d f16773i;

    /* renamed from: j  reason: collision with root package name */
    public Long f16774j;

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public g f16775a;

        /* renamed from: b  reason: collision with root package name */
        public volatile a f16776b = new a();

        /* renamed from: c  reason: collision with root package name */
        public a f16777c = new a();

        /* renamed from: d  reason: collision with root package name */
        public Long f16778d;

        /* renamed from: e  reason: collision with root package name */
        public int f16779e;

        /* renamed from: f  reason: collision with root package name */
        public final Set f16780f = new HashSet();

        public static class a {

            /* renamed from: a  reason: collision with root package name */
            public AtomicLong f16781a;

            /* renamed from: b  reason: collision with root package name */
            public AtomicLong f16782b;

            public a() {
                this.f16781a = new AtomicLong();
                this.f16782b = new AtomicLong();
            }

            public void a() {
                this.f16781a.set(0);
                this.f16782b.set(0);
            }
        }

        public b(g gVar) {
            this.f16775a = gVar;
        }

        public boolean b(i iVar) {
            if (m() && !iVar.n()) {
                iVar.m();
            } else if (!m() && iVar.n()) {
                iVar.p();
            }
            iVar.o(this);
            return this.f16780f.add(iVar);
        }

        public void c() {
            int i10;
            int i11 = this.f16779e;
            if (i11 == 0) {
                i10 = 0;
            } else {
                i10 = i11 - 1;
            }
            this.f16779e = i10;
        }

        public void d(long j10) {
            this.f16778d = Long.valueOf(j10);
            this.f16779e++;
            for (i m10 : this.f16780f) {
                m10.m();
            }
        }

        public double e() {
            double d10 = (double) this.f16777c.f16782b.get();
            double f10 = (double) f();
            Double.isNaN(d10);
            Double.isNaN(f10);
            return d10 / f10;
        }

        public long f() {
            return this.f16777c.f16781a.get() + this.f16777c.f16782b.get();
        }

        public void g(boolean z10) {
            g gVar = this.f16775a;
            if (gVar.f16793e != null || gVar.f16794f != null) {
                if (z10) {
                    this.f16776b.f16781a.getAndIncrement();
                } else {
                    this.f16776b.f16782b.getAndIncrement();
                }
            }
        }

        public boolean h(long j10) {
            if (j10 > this.f16778d.longValue() + Math.min(this.f16775a.f16790b.longValue() * ((long) this.f16779e), Math.max(this.f16775a.f16790b.longValue(), this.f16775a.f16791c.longValue()))) {
                return true;
            }
            return false;
        }

        public boolean i(i iVar) {
            iVar.l();
            return this.f16780f.remove(iVar);
        }

        public void j() {
            this.f16776b.a();
            this.f16777c.a();
        }

        public void k() {
            this.f16779e = 0;
        }

        public void l(g gVar) {
            this.f16775a = gVar;
        }

        public boolean m() {
            if (this.f16778d != null) {
                return true;
            }
            return false;
        }

        public double n() {
            double d10 = (double) this.f16777c.f16781a.get();
            double f10 = (double) f();
            Double.isNaN(d10);
            Double.isNaN(f10);
            return d10 / f10;
        }

        public void o() {
            this.f16777c.a();
            a aVar = this.f16776b;
            this.f16776b = this.f16777c;
            this.f16777c = aVar;
        }

        public void p() {
            boolean z10;
            if (this.f16778d != null) {
                z10 = true;
            } else {
                z10 = false;
            }
            Preconditions.checkState(z10, "not currently ejected");
            this.f16778d = null;
            for (i p10 : this.f16780f) {
                p10.p();
            }
        }
    }

    public static class c extends ForwardingMap {

        /* renamed from: a  reason: collision with root package name */
        public final Map f16783a = new HashMap();

        public void a() {
            for (b bVar : this.f16783a.values()) {
                if (bVar.m()) {
                    bVar.p();
                }
                bVar.k();
            }
        }

        public double b() {
            if (this.f16783a.isEmpty()) {
                return 0.0d;
            }
            int i10 = 0;
            int i11 = 0;
            for (b m10 : this.f16783a.values()) {
                i11++;
                if (m10.m()) {
                    i10++;
                }
            }
            double d10 = (double) i10;
            double d11 = (double) i11;
            Double.isNaN(d10);
            Double.isNaN(d11);
            return (d10 / d11) * 100.0d;
        }

        public void c(Long l10) {
            for (b bVar : this.f16783a.values()) {
                if (!bVar.m()) {
                    bVar.c();
                }
                if (bVar.m() && bVar.h(l10.longValue())) {
                    bVar.p();
                }
            }
        }

        public void d(g gVar, Collection collection) {
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                SocketAddress socketAddress = (SocketAddress) it.next();
                if (!this.f16783a.containsKey(socketAddress)) {
                    this.f16783a.put(socketAddress, new b(gVar));
                }
            }
        }

        public void e() {
            for (b j10 : this.f16783a.values()) {
                j10.j();
            }
        }

        public void f() {
            for (b o10 : this.f16783a.values()) {
                o10.o();
            }
        }

        public void g(g gVar) {
            for (b l10 : this.f16783a.values()) {
                l10.l(gVar);
            }
        }

        public Map delegate() {
            return this.f16783a;
        }
    }

    public class d extends b {

        /* renamed from: a  reason: collision with root package name */
        public o0.d f16784a;

        public d(o0.d dVar) {
            this.f16784a = dVar;
        }

        public o0.h a(o0.b bVar) {
            i iVar = new i(this.f16784a.a(bVar));
            List a10 = bVar.a();
            if (e.l(a10) && e.this.f16767c.containsKey(((x) a10.get(0)).a().get(0))) {
                b bVar2 = (b) e.this.f16767c.get(((x) a10.get(0)).a().get(0));
                bVar2.b(iVar);
                if (bVar2.f16778d != null) {
                    iVar.m();
                }
            }
            return iVar;
        }

        public void f(p pVar, o0.i iVar) {
            this.f16784a.f(pVar, new h(iVar));
        }

        public o0.d g() {
            return this.f16784a;
        }
    }

    /* renamed from: f9.e$e  reason: collision with other inner class name */
    public class C0222e implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public g f16786a;

        public C0222e(g gVar) {
            this.f16786a = gVar;
        }

        public void run() {
            e eVar = e.this;
            Long unused = eVar.f16774j = Long.valueOf(eVar.f16771g.a());
            e.this.f16767c.f();
            for (j a10 : f.a(this.f16786a)) {
                e eVar2 = e.this;
                a10.a(eVar2.f16767c, eVar2.f16774j.longValue());
            }
            e eVar3 = e.this;
            eVar3.f16767c.c(eVar3.f16774j);
        }
    }

    public static class f implements j {

        /* renamed from: a  reason: collision with root package name */
        public final g f16788a;

        public f(g gVar) {
            this.f16788a = gVar;
        }

        public void a(c cVar, long j10) {
            List<b> k10 = e.m(cVar, this.f16788a.f16794f.f16806d.intValue());
            if (k10.size() >= this.f16788a.f16794f.f16805c.intValue() && k10.size() != 0) {
                for (b bVar : k10) {
                    if (cVar.b() < ((double) this.f16788a.f16792d.intValue())) {
                        if (bVar.f() >= ((long) this.f16788a.f16794f.f16806d.intValue())) {
                            double intValue = (double) this.f16788a.f16794f.f16803a.intValue();
                            Double.isNaN(intValue);
                            if (bVar.e() > intValue / 100.0d && new Random().nextInt(100) < this.f16788a.f16794f.f16804b.intValue()) {
                                bVar.d(j10);
                            }
                        }
                    } else {
                        return;
                    }
                }
            }
        }
    }

    public static final class g {

        /* renamed from: a  reason: collision with root package name */
        public final Long f16789a;

        /* renamed from: b  reason: collision with root package name */
        public final Long f16790b;

        /* renamed from: c  reason: collision with root package name */
        public final Long f16791c;

        /* renamed from: d  reason: collision with root package name */
        public final Integer f16792d;

        /* renamed from: e  reason: collision with root package name */
        public final c f16793e;

        /* renamed from: f  reason: collision with root package name */
        public final b f16794f;

        /* renamed from: g  reason: collision with root package name */
        public final c2.b f16795g;

        public static class a {

            /* renamed from: a  reason: collision with root package name */
            public Long f16796a = 10000000000L;

            /* renamed from: b  reason: collision with root package name */
            public Long f16797b = 30000000000L;

            /* renamed from: c  reason: collision with root package name */
            public Long f16798c = 30000000000L;

            /* renamed from: d  reason: collision with root package name */
            public Integer f16799d = 10;

            /* renamed from: e  reason: collision with root package name */
            public c f16800e;

            /* renamed from: f  reason: collision with root package name */
            public b f16801f;

            /* renamed from: g  reason: collision with root package name */
            public c2.b f16802g;

            public g a() {
                boolean z10;
                if (this.f16802g != null) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                Preconditions.checkState(z10);
                return new g(this.f16796a, this.f16797b, this.f16798c, this.f16799d, this.f16800e, this.f16801f, this.f16802g);
            }

            public a b(Long l10) {
                boolean z10;
                if (l10 != null) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                Preconditions.checkArgument(z10);
                this.f16797b = l10;
                return this;
            }

            public a c(c2.b bVar) {
                boolean z10;
                if (bVar != null) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                Preconditions.checkState(z10);
                this.f16802g = bVar;
                return this;
            }

            public a d(b bVar) {
                this.f16801f = bVar;
                return this;
            }

            public a e(Long l10) {
                boolean z10;
                if (l10 != null) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                Preconditions.checkArgument(z10);
                this.f16796a = l10;
                return this;
            }

            public a f(Integer num) {
                boolean z10;
                if (num != null) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                Preconditions.checkArgument(z10);
                this.f16799d = num;
                return this;
            }

            public a g(Long l10) {
                boolean z10;
                if (l10 != null) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                Preconditions.checkArgument(z10);
                this.f16798c = l10;
                return this;
            }

            public a h(c cVar) {
                this.f16800e = cVar;
                return this;
            }
        }

        public static class b {

            /* renamed from: a  reason: collision with root package name */
            public final Integer f16803a;

            /* renamed from: b  reason: collision with root package name */
            public final Integer f16804b;

            /* renamed from: c  reason: collision with root package name */
            public final Integer f16805c;

            /* renamed from: d  reason: collision with root package name */
            public final Integer f16806d;

            public static class a {

                /* renamed from: a  reason: collision with root package name */
                public Integer f16807a = 85;

                /* renamed from: b  reason: collision with root package name */
                public Integer f16808b = 100;

                /* renamed from: c  reason: collision with root package name */
                public Integer f16809c = 5;

                /* renamed from: d  reason: collision with root package name */
                public Integer f16810d = 50;

                public b a() {
                    return new b(this.f16807a, this.f16808b, this.f16809c, this.f16810d);
                }

                public a b(Integer num) {
                    boolean z10;
                    boolean z11 = true;
                    if (num != null) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    Preconditions.checkArgument(z10);
                    if (num.intValue() < 0 || num.intValue() > 100) {
                        z11 = false;
                    }
                    Preconditions.checkArgument(z11);
                    this.f16808b = num;
                    return this;
                }

                public a c(Integer num) {
                    boolean z10;
                    boolean z11 = true;
                    if (num != null) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    Preconditions.checkArgument(z10);
                    if (num.intValue() < 0) {
                        z11 = false;
                    }
                    Preconditions.checkArgument(z11);
                    this.f16809c = num;
                    return this;
                }

                public a d(Integer num) {
                    boolean z10;
                    boolean z11 = true;
                    if (num != null) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    Preconditions.checkArgument(z10);
                    if (num.intValue() < 0) {
                        z11 = false;
                    }
                    Preconditions.checkArgument(z11);
                    this.f16810d = num;
                    return this;
                }

                public a e(Integer num) {
                    boolean z10;
                    boolean z11 = true;
                    if (num != null) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    Preconditions.checkArgument(z10);
                    if (num.intValue() < 0 || num.intValue() > 100) {
                        z11 = false;
                    }
                    Preconditions.checkArgument(z11);
                    this.f16807a = num;
                    return this;
                }
            }

            public b(Integer num, Integer num2, Integer num3, Integer num4) {
                this.f16803a = num;
                this.f16804b = num2;
                this.f16805c = num3;
                this.f16806d = num4;
            }
        }

        public static class c {

            /* renamed from: a  reason: collision with root package name */
            public final Integer f16811a;

            /* renamed from: b  reason: collision with root package name */
            public final Integer f16812b;

            /* renamed from: c  reason: collision with root package name */
            public final Integer f16813c;

            /* renamed from: d  reason: collision with root package name */
            public final Integer f16814d;

            public static final class a {

                /* renamed from: a  reason: collision with root package name */
                public Integer f16815a = Integer.valueOf(SSDP.PORT);

                /* renamed from: b  reason: collision with root package name */
                public Integer f16816b = 100;

                /* renamed from: c  reason: collision with root package name */
                public Integer f16817c = 5;

                /* renamed from: d  reason: collision with root package name */
                public Integer f16818d = 100;

                public c a() {
                    return new c(this.f16815a, this.f16816b, this.f16817c, this.f16818d);
                }

                public a b(Integer num) {
                    boolean z10;
                    boolean z11 = true;
                    if (num != null) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    Preconditions.checkArgument(z10);
                    if (num.intValue() < 0 || num.intValue() > 100) {
                        z11 = false;
                    }
                    Preconditions.checkArgument(z11);
                    this.f16816b = num;
                    return this;
                }

                public a c(Integer num) {
                    boolean z10;
                    boolean z11 = true;
                    if (num != null) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    Preconditions.checkArgument(z10);
                    if (num.intValue() < 0) {
                        z11 = false;
                    }
                    Preconditions.checkArgument(z11);
                    this.f16817c = num;
                    return this;
                }

                public a d(Integer num) {
                    boolean z10;
                    boolean z11 = true;
                    if (num != null) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    Preconditions.checkArgument(z10);
                    if (num.intValue() < 0) {
                        z11 = false;
                    }
                    Preconditions.checkArgument(z11);
                    this.f16818d = num;
                    return this;
                }

                public a e(Integer num) {
                    boolean z10;
                    if (num != null) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    Preconditions.checkArgument(z10);
                    this.f16815a = num;
                    return this;
                }
            }

            public c(Integer num, Integer num2, Integer num3, Integer num4) {
                this.f16811a = num;
                this.f16812b = num2;
                this.f16813c = num3;
                this.f16814d = num4;
            }
        }

        public boolean a() {
            if (this.f16793e == null && this.f16794f == null) {
                return false;
            }
            return true;
        }

        public g(Long l10, Long l11, Long l12, Integer num, c cVar, b bVar, c2.b bVar2) {
            this.f16789a = l10;
            this.f16790b = l11;
            this.f16791c = l12;
            this.f16792d = num;
            this.f16793e = cVar;
            this.f16794f = bVar;
            this.f16795g = bVar2;
        }
    }

    public class h extends o0.i {

        /* renamed from: a  reason: collision with root package name */
        public final o0.i f16819a;

        public class a extends y8.k {

            /* renamed from: a  reason: collision with root package name */
            public b f16821a;

            public a(b bVar) {
                this.f16821a = bVar;
            }

            public void i(k1 k1Var) {
                this.f16821a.g(k1Var.p());
            }
        }

        public class b extends k.a {

            /* renamed from: a  reason: collision with root package name */
            public final b f16823a;

            public b(b bVar) {
                this.f16823a = bVar;
            }

            public y8.k a(k.b bVar, v0 v0Var) {
                return new a(this.f16823a);
            }
        }

        public h(o0.i iVar) {
            this.f16819a = iVar;
        }

        public o0.e a(o0.f fVar) {
            o0.e a10 = this.f16819a.a(fVar);
            o0.h c10 = a10.c();
            if (c10 != null) {
                return o0.e.i(c10, new b((b) c10.c().b(e.f16766k)));
            }
            return a10;
        }
    }

    public class i extends c {

        /* renamed from: a  reason: collision with root package name */
        public final o0.h f16825a;

        /* renamed from: b  reason: collision with root package name */
        public b f16826b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f16827c;

        /* renamed from: d  reason: collision with root package name */
        public q f16828d;

        /* renamed from: e  reason: collision with root package name */
        public o0.j f16829e;

        public class a implements o0.j {

            /* renamed from: a  reason: collision with root package name */
            public final o0.j f16831a;

            public a(o0.j jVar) {
                this.f16831a = jVar;
            }

            public void a(q qVar) {
                q unused = i.this.f16828d = qVar;
                if (!i.this.f16827c) {
                    this.f16831a.a(qVar);
                }
            }
        }

        public i(o0.h hVar) {
            this.f16825a = hVar;
        }

        public y8.a c() {
            if (this.f16826b != null) {
                return this.f16825a.c().d().d(e.f16766k, this.f16826b).a();
            }
            return this.f16825a.c();
        }

        public void g(o0.j jVar) {
            this.f16829e = jVar;
            super.g(new a(jVar));
        }

        public void h(List list) {
            if (e.l(b()) && e.l(list)) {
                if (e.this.f16767c.containsValue(this.f16826b)) {
                    this.f16826b.i(this);
                }
                SocketAddress socketAddress = (SocketAddress) ((x) list.get(0)).a().get(0);
                if (e.this.f16767c.containsKey(socketAddress)) {
                    ((b) e.this.f16767c.get(socketAddress)).b(this);
                }
            } else if (!e.l(b()) || e.l(list)) {
                if (!e.l(b()) && e.l(list)) {
                    SocketAddress socketAddress2 = (SocketAddress) ((x) list.get(0)).a().get(0);
                    if (e.this.f16767c.containsKey(socketAddress2)) {
                        ((b) e.this.f16767c.get(socketAddress2)).b(this);
                    }
                }
            } else if (e.this.f16767c.containsKey(a().a().get(0))) {
                b bVar = (b) e.this.f16767c.get(a().a().get(0));
                bVar.i(this);
                bVar.j();
            }
            this.f16825a.h(list);
        }

        public o0.h i() {
            return this.f16825a;
        }

        public void l() {
            this.f16826b = null;
        }

        public void m() {
            this.f16827c = true;
            this.f16829e.a(q.b(k1.f20056u));
        }

        public boolean n() {
            return this.f16827c;
        }

        public void o(b bVar) {
            this.f16826b = bVar;
        }

        public void p() {
            this.f16827c = false;
            q qVar = this.f16828d;
            if (qVar != null) {
                this.f16829e.a(qVar);
            }
        }
    }

    public interface j {
        void a(c cVar, long j10);
    }

    public static class k implements j {

        /* renamed from: a  reason: collision with root package name */
        public final g f16833a;

        public k(g gVar) {
            boolean z10;
            if (gVar.f16793e != null) {
                z10 = true;
            } else {
                z10 = false;
            }
            Preconditions.checkArgument(z10, "success rate ejection config is null");
            this.f16833a = gVar;
        }

        public static double b(Collection collection) {
            Iterator it = collection.iterator();
            double d10 = 0.0d;
            while (it.hasNext()) {
                d10 += ((Double) it.next()).doubleValue();
            }
            double size = (double) collection.size();
            Double.isNaN(size);
            return d10 / size;
        }

        public static double c(Collection collection, double d10) {
            Iterator it = collection.iterator();
            double d11 = 0.0d;
            while (it.hasNext()) {
                double doubleValue = ((Double) it.next()).doubleValue() - d10;
                d11 += doubleValue * doubleValue;
            }
            double size = (double) collection.size();
            Double.isNaN(size);
            return Math.sqrt(d11 / size);
        }

        public void a(c cVar, long j10) {
            List<b> k10 = e.m(cVar, this.f16833a.f16793e.f16814d.intValue());
            if (k10.size() >= this.f16833a.f16793e.f16813c.intValue() && k10.size() != 0) {
                ArrayList arrayList = new ArrayList();
                for (b n10 : k10) {
                    arrayList.add(Double.valueOf(n10.n()));
                }
                double b10 = b(arrayList);
                double c10 = c(arrayList, b10);
                double intValue = (double) (((float) this.f16833a.f16793e.f16811a.intValue()) / 1000.0f);
                Double.isNaN(intValue);
                double d10 = b10 - (c10 * intValue);
                for (b bVar : k10) {
                    if (cVar.b() < ((double) this.f16833a.f16792d.intValue())) {
                        if (bVar.n() < d10 && new Random().nextInt(100) < this.f16833a.f16793e.f16812b.intValue()) {
                            bVar.d(j10);
                        }
                    } else {
                        return;
                    }
                }
            }
        }
    }

    public e(o0.d dVar, j2 j2Var) {
        d dVar2 = new d((o0.d) Preconditions.checkNotNull(dVar, "helper"));
        this.f16769e = dVar2;
        this.f16770f = new d(dVar2);
        this.f16768d = (o1) Preconditions.checkNotNull(dVar.d(), "syncContext");
        this.f16772h = (ScheduledExecutorService) Preconditions.checkNotNull(dVar.c(), "timeService");
        this.f16771g = j2Var;
    }

    public static boolean l(List list) {
        Iterator it = list.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            i10 += ((x) it.next()).a().size();
            if (i10 > 1) {
                return false;
            }
        }
        return true;
    }

    public static List m(c cVar, int i10) {
        ArrayList arrayList = new ArrayList();
        for (b bVar : cVar.values()) {
            if (bVar.f() >= ((long) i10)) {
                arrayList.add(bVar);
            }
        }
        return arrayList;
    }

    public boolean a(o0.g gVar) {
        Long l10;
        g gVar2 = (g) gVar.c();
        ArrayList arrayList = new ArrayList();
        for (x a10 : gVar.a()) {
            arrayList.addAll(a10.a());
        }
        this.f16767c.keySet().retainAll(arrayList);
        this.f16767c.g(gVar2);
        this.f16767c.d(gVar2, arrayList);
        this.f16770f.q(gVar2.f16795g.b());
        if (gVar2.a()) {
            if (this.f16774j == null) {
                l10 = gVar2.f16789a;
            } else {
                l10 = Long.valueOf(Math.max(0, gVar2.f16789a.longValue() - (this.f16771g.a() - this.f16774j.longValue())));
            }
            o1.d dVar = this.f16773i;
            if (dVar != null) {
                dVar.a();
                this.f16767c.e();
            }
            this.f16773i = this.f16768d.d(new C0222e(gVar2), l10.longValue(), gVar2.f16789a.longValue(), TimeUnit.NANOSECONDS, this.f16772h);
        } else {
            o1.d dVar2 = this.f16773i;
            if (dVar2 != null) {
                dVar2.a();
                this.f16774j = null;
                this.f16767c.a();
            }
        }
        this.f16770f.d(gVar.e().d(gVar2.f16795g.a()).a());
        return true;
    }

    public void c(k1 k1Var) {
        this.f16770f.c(k1Var);
    }

    public void e() {
        this.f16770f.e();
    }
}
