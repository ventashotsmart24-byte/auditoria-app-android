package z8;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Verify;
import com.google.common.base.VerifyException;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.hpplay.cybergarage.upnp.Service;
import com.umeng.analytics.pro.f;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import y8.k1;
import y8.p0;
import y8.q0;
import y8.y0;
import z8.x1;

public abstract class c2 {

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final String f20448a;

        /* renamed from: b  reason: collision with root package name */
        public final Map f20449b;

        public a(String str, Map map) {
            this.f20448a = (String) Preconditions.checkNotNull(str, "policyName");
            this.f20449b = (Map) Preconditions.checkNotNull(map, "rawConfigValue");
        }

        public String a() {
            return this.f20448a;
        }

        public Map b() {
            return this.f20449b;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (!this.f20448a.equals(aVar.f20448a) || !this.f20449b.equals(aVar.f20449b)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return Objects.hashCode(this.f20448a, this.f20449b);
        }

        public String toString() {
            return MoreObjects.toStringHelper((Object) this).add("policyName", (Object) this.f20448a).add("rawConfigValue", (Object) this.f20449b).toString();
        }
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final p0 f20450a;

        /* renamed from: b  reason: collision with root package name */
        public final Object f20451b;

        public b(p0 p0Var, Object obj) {
            this.f20450a = (p0) Preconditions.checkNotNull(p0Var, f.M);
            this.f20451b = obj;
        }

        public Object a() {
            return this.f20451b;
        }

        public p0 b() {
            return this.f20450a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || b.class != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            if (!Objects.equal(this.f20450a, bVar.f20450a) || !Objects.equal(this.f20451b, bVar.f20451b)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return Objects.hashCode(this.f20450a, this.f20451b);
        }

        public String toString() {
            return MoreObjects.toStringHelper((Object) this).add(f.M, (Object) this.f20450a).add("config", this.f20451b).toString();
        }
    }

    public static List A(List list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(z((Map) it.next()));
        }
        return Collections.unmodifiableList(arrayList);
    }

    public static Double a(Map map) {
        return a1.h(map, "backoffMultiplier");
    }

    public static Map b(Map map) {
        if (map == null) {
            return null;
        }
        return a1.j(map, "healthCheckConfig");
    }

    public static Long c(Map map) {
        return a1.l(map, "hedgingDelay");
    }

    public static Map d(Map map) {
        return a1.j(map, "hedgingPolicy");
    }

    public static Long e(Map map) {
        return a1.l(map, "initialBackoff");
    }

    public static Set f(Map map, String str) {
        List e10 = a1.e(map, str);
        if (e10 == null) {
            return null;
        }
        return u(e10);
    }

    public static List g(Map map) {
        String k10;
        ArrayList arrayList = new ArrayList();
        if (map.containsKey("loadBalancingConfig")) {
            arrayList.addAll(a1.f(map, "loadBalancingConfig"));
        }
        if (arrayList.isEmpty() && (k10 = a1.k(map, "loadBalancingPolicy")) != null) {
            arrayList.add(Collections.singletonMap(k10.toLowerCase(Locale.ROOT), Collections.emptyMap()));
        }
        return Collections.unmodifiableList(arrayList);
    }

    public static Integer h(Map map) {
        return a1.i(map, "maxAttempts");
    }

    public static Integer i(Map map) {
        return a1.i(map, "maxAttempts");
    }

    public static Long j(Map map) {
        return a1.l(map, "maxBackoff");
    }

    public static Integer k(Map map) {
        return a1.i(map, "maxRequestMessageBytes");
    }

    public static Integer l(Map map) {
        return a1.i(map, "maxResponseMessageBytes");
    }

    public static List m(Map map) {
        return a1.f(map, "methodConfig");
    }

    public static String n(Map map) {
        return a1.k(map, FirebaseAnalytics.Param.METHOD);
    }

    public static List o(Map map) {
        return a1.f(map, "name");
    }

    public static Set p(Map map) {
        Set f10 = f(map, "nonFatalStatusCodes");
        if (f10 == null) {
            return Collections.unmodifiableSet(EnumSet.noneOf(k1.b.class));
        }
        Verify.verify(!f10.contains(k1.b.OK), "%s must not contain OK", (Object) "nonFatalStatusCodes");
        return f10;
    }

    public static Long q(Map map) {
        return a1.l(map, "perAttemptRecvTimeout");
    }

    public static Map r(Map map) {
        return a1.j(map, "retryPolicy");
    }

    public static Set s(Map map) {
        boolean z10;
        Set f10 = f(map, "retryableStatusCodes");
        if (f10 != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        Verify.verify(z10, "%s is required in retry policy", (Object) "retryableStatusCodes");
        Verify.verify(true ^ f10.contains(k1.b.OK), "%s must not contain OK", (Object) "retryableStatusCodes");
        return f10;
    }

    public static String t(Map map) {
        return a1.k(map, Service.ELEM_NAME);
    }

    public static Set u(List list) {
        k1.b bVar;
        boolean z10;
        EnumSet<E> noneOf = EnumSet.noneOf(k1.b.class);
        for (Object next : list) {
            if (next instanceof Double) {
                Double d10 = (Double) next;
                int intValue = d10.intValue();
                boolean z11 = true;
                if (((double) intValue) == d10.doubleValue()) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                Verify.verify(z10, "Status code %s is not integral", next);
                bVar = k1.i(intValue).n();
                if (bVar.c() != d10.intValue()) {
                    z11 = false;
                }
                Verify.verify(z11, "Status code %s is not valid", next);
            } else if (next instanceof String) {
                try {
                    bVar = k1.b.valueOf((String) next);
                } catch (IllegalArgumentException e10) {
                    throw new VerifyException("Status code " + next + " is not valid", e10);
                }
            } else {
                throw new VerifyException("Can not convert status code " + next + " to Status.Code, because its type is " + next.getClass());
            }
            noneOf.add(bVar);
        }
        return Collections.unmodifiableSet(noneOf);
    }

    public static x1.c0 v(Map map) {
        Map j10;
        boolean z10;
        if (map == null || (j10 = a1.j(map, "retryThrottling")) == null) {
            return null;
        }
        float floatValue = a1.h(j10, "maxTokens").floatValue();
        float floatValue2 = a1.h(j10, "tokenRatio").floatValue();
        boolean z11 = true;
        if (floatValue > 0.0f) {
            z10 = true;
        } else {
            z10 = false;
        }
        Preconditions.checkState(z10, "maxToken should be greater than zero");
        if (floatValue2 <= 0.0f) {
            z11 = false;
        }
        Preconditions.checkState(z11, "tokenRatio should be greater than zero");
        return new x1.c0(floatValue, floatValue2);
    }

    public static Long w(Map map) {
        return a1.l(map, "timeout");
    }

    public static Boolean x(Map map) {
        return a1.d(map, "waitForReady");
    }

    public static y0.b y(List list, q0 q0Var) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            String a10 = aVar.a();
            p0 d10 = q0Var.d(a10);
            if (d10 == null) {
                arrayList.add(a10);
            } else {
                if (!arrayList.isEmpty()) {
                    Logger.getLogger(c2.class.getName()).log(Level.FINEST, "{0} specified by Service Config are not available", arrayList);
                }
                y0.b e10 = d10.e(aVar.b());
                if (e10.d() != null) {
                    return e10;
                }
                return y0.b.a(new b(d10, e10.c()));
            }
        }
        k1 k1Var = k1.f20043h;
        return y0.b.b(k1Var.r("None of " + arrayList + " specified by Service Config are available."));
    }

    public static a z(Map map) {
        if (map.size() == 1) {
            String str = (String) ((Map.Entry) map.entrySet().iterator().next()).getKey();
            return new a(str, a1.j(map, str));
        }
        throw new RuntimeException("There are " + map.size() + " fields in a LoadBalancingConfig object. Exactly one is expected. Config=" + map);
    }
}
