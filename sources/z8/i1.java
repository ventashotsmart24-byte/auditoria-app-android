package z8;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import y8.c;
import y8.e0;
import y8.o0;
import y8.w0;
import z8.x1;

public final class i1 {

    /* renamed from: a  reason: collision with root package name */
    public final b f20684a;

    /* renamed from: b  reason: collision with root package name */
    public final Map f20685b;

    /* renamed from: c  reason: collision with root package name */
    public final Map f20686c;

    /* renamed from: d  reason: collision with root package name */
    public final x1.c0 f20687d;

    /* renamed from: e  reason: collision with root package name */
    public final Object f20688e;

    /* renamed from: f  reason: collision with root package name */
    public final Map f20689f;

    public static final class b {

        /* renamed from: g  reason: collision with root package name */
        public static final c.C0296c f20690g = c.C0296c.b("io.grpc.internal.ManagedChannelServiceConfig.MethodInfo");

        /* renamed from: a  reason: collision with root package name */
        public final Long f20691a;

        /* renamed from: b  reason: collision with root package name */
        public final Boolean f20692b;

        /* renamed from: c  reason: collision with root package name */
        public final Integer f20693c;

        /* renamed from: d  reason: collision with root package name */
        public final Integer f20694d;

        /* renamed from: e  reason: collision with root package name */
        public final y1 f20695e;

        /* renamed from: f  reason: collision with root package name */
        public final s0 f20696f;

        public b(Map map, boolean z10, int i10, int i11) {
            Map map2;
            y1 y1Var;
            Map map3;
            boolean z11;
            this.f20691a = c2.w(map);
            this.f20692b = c2.x(map);
            Integer l10 = c2.l(map);
            this.f20693c = l10;
            boolean z12 = true;
            if (l10 != null) {
                if (l10.intValue() >= 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                Preconditions.checkArgument(z11, "maxInboundMessageSize %s exceeds bounds", (Object) l10);
            }
            Integer k10 = c2.k(map);
            this.f20694d = k10;
            if (k10 != null) {
                Preconditions.checkArgument(k10.intValue() < 0 ? false : z12, "maxOutboundMessageSize %s exceeds bounds", (Object) k10);
            }
            s0 s0Var = null;
            if (z10) {
                map2 = c2.r(map);
            } else {
                map2 = null;
            }
            if (map2 == null) {
                y1Var = null;
            } else {
                y1Var = b(map2, i10);
            }
            this.f20695e = y1Var;
            if (z10) {
                map3 = c2.d(map);
            } else {
                map3 = null;
            }
            this.f20696f = map3 != null ? a(map3, i11) : s0Var;
        }

        public static s0 a(Map map, int i10) {
            boolean z10;
            int intValue = ((Integer) Preconditions.checkNotNull(c2.h(map), "maxAttempts cannot be empty")).intValue();
            boolean z11 = true;
            if (intValue >= 2) {
                z10 = true;
            } else {
                z10 = false;
            }
            Preconditions.checkArgument(z10, "maxAttempts must be greater than 1: %s", intValue);
            int min = Math.min(intValue, i10);
            long longValue = ((Long) Preconditions.checkNotNull(c2.c(map), "hedgingDelay cannot be empty")).longValue();
            if (longValue < 0) {
                z11 = false;
            }
            Preconditions.checkArgument(z11, "hedgingDelay must not be negative: %s", longValue);
            return new s0(min, longValue, c2.p(map));
        }

        public static y1 b(Map map, int i10) {
            boolean z10;
            boolean z11;
            boolean z12;
            boolean z13;
            boolean z14;
            int intValue = ((Integer) Preconditions.checkNotNull(c2.i(map), "maxAttempts cannot be empty")).intValue();
            boolean z15 = true;
            if (intValue >= 2) {
                z10 = true;
            } else {
                z10 = false;
            }
            Preconditions.checkArgument(z10, "maxAttempts must be greater than 1: %s", intValue);
            int min = Math.min(intValue, i10);
            long longValue = ((Long) Preconditions.checkNotNull(c2.e(map), "initialBackoff cannot be empty")).longValue();
            if (longValue > 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            Preconditions.checkArgument(z11, "initialBackoffNanos must be greater than 0: %s", longValue);
            long longValue2 = ((Long) Preconditions.checkNotNull(c2.j(map), "maxBackoff cannot be empty")).longValue();
            if (longValue2 > 0) {
                z12 = true;
            } else {
                z12 = false;
            }
            Preconditions.checkArgument(z12, "maxBackoff must be greater than 0: %s", longValue2);
            double doubleValue = ((Double) Preconditions.checkNotNull(c2.a(map), "backoffMultiplier cannot be empty")).doubleValue();
            if (doubleValue > 0.0d) {
                z13 = true;
            } else {
                z13 = false;
            }
            Preconditions.checkArgument(z13, "backoffMultiplier must be greater than 0: %s", (Object) Double.valueOf(doubleValue));
            Long q10 = c2.q(map);
            if (q10 == null || q10.longValue() >= 0) {
                z14 = true;
            } else {
                z14 = false;
            }
            Preconditions.checkArgument(z14, "perAttemptRecvTimeout cannot be negative: %s", (Object) q10);
            Set s10 = c2.s(map);
            if (q10 == null && s10.isEmpty()) {
                z15 = false;
            }
            Preconditions.checkArgument(z15, "retryableStatusCodes cannot be empty without perAttemptRecvTimeout");
            return new y1(min, longValue, longValue2, doubleValue, q10, s10);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            if (!Objects.equal(this.f20691a, bVar.f20691a) || !Objects.equal(this.f20692b, bVar.f20692b) || !Objects.equal(this.f20693c, bVar.f20693c) || !Objects.equal(this.f20694d, bVar.f20694d) || !Objects.equal(this.f20695e, bVar.f20695e) || !Objects.equal(this.f20696f, bVar.f20696f)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return Objects.hashCode(this.f20691a, this.f20692b, this.f20693c, this.f20694d, this.f20695e, this.f20696f);
        }

        public String toString() {
            return MoreObjects.toStringHelper((Object) this).add("timeoutNanos", (Object) this.f20691a).add("waitForReady", (Object) this.f20692b).add("maxInboundMessageSize", (Object) this.f20693c).add("maxOutboundMessageSize", (Object) this.f20694d).add("retryPolicy", (Object) this.f20695e).add("hedgingPolicy", (Object) this.f20696f).toString();
        }
    }

    public static final class c extends e0 {

        /* renamed from: b  reason: collision with root package name */
        public final i1 f20697b;

        public e0.b a(o0.f fVar) {
            return e0.b.d().b(this.f20697b).a();
        }

        public c(i1 i1Var) {
            this.f20697b = i1Var;
        }
    }

    public i1(b bVar, Map map, Map map2, x1.c0 c0Var, Object obj, Map map3) {
        Map map4;
        this.f20684a = bVar;
        this.f20685b = Collections.unmodifiableMap(new HashMap(map));
        this.f20686c = Collections.unmodifiableMap(new HashMap(map2));
        this.f20687d = c0Var;
        this.f20688e = obj;
        if (map3 != null) {
            map4 = Collections.unmodifiableMap(new HashMap(map3));
        } else {
            map4 = null;
        }
        this.f20689f = map4;
    }

    public static i1 a() {
        return new i1((b) null, new HashMap(), new HashMap(), (x1.c0) null, (Object) null, (Map) null);
    }

    public static i1 b(Map map, boolean z10, int i10, int i11, Object obj) {
        x1.c0 c0Var;
        boolean z11 = z10;
        if (z11) {
            c0Var = c2.v(map);
        } else {
            c0Var = null;
        }
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        Map b10 = c2.b(map);
        List<Map> m10 = c2.m(map);
        if (m10 == null) {
            return new i1((b) null, hashMap, hashMap2, c0Var, obj, b10);
        }
        b bVar = null;
        for (Map map2 : m10) {
            b bVar2 = new b(map2, z11, i10, i11);
            List<Map> o10 = c2.o(map2);
            if (o10 != null && !o10.isEmpty()) {
                for (Map map3 : o10) {
                    String t10 = c2.t(map3);
                    String n10 = c2.n(map3);
                    boolean z12 = true;
                    if (Strings.isNullOrEmpty(t10)) {
                        Preconditions.checkArgument(Strings.isNullOrEmpty(n10), "missing service name for method %s", (Object) n10);
                        if (bVar != null) {
                            z12 = false;
                        }
                        Preconditions.checkArgument(z12, "Duplicate default method config in service config %s", (Object) map);
                        bVar = bVar2;
                    } else {
                        Map map4 = map;
                        if (Strings.isNullOrEmpty(n10)) {
                            Preconditions.checkArgument(!hashMap2.containsKey(t10), "Duplicate service %s", (Object) t10);
                            hashMap2.put(t10, bVar2);
                        } else {
                            String b11 = w0.b(t10, n10);
                            Preconditions.checkArgument(!hashMap.containsKey(b11), "Duplicate method name %s", (Object) b11);
                            hashMap.put(b11, bVar2);
                        }
                    }
                }
            }
            Map map5 = map;
        }
        return new i1(bVar, hashMap, hashMap2, c0Var, obj, b10);
    }

    public e0 c() {
        if (!this.f20686c.isEmpty() || !this.f20685b.isEmpty() || this.f20684a != null) {
            return new c();
        }
        return null;
    }

    public Map d() {
        return this.f20689f;
    }

    public Object e() {
        return this.f20688e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || i1.class != obj.getClass()) {
            return false;
        }
        i1 i1Var = (i1) obj;
        if (!Objects.equal(this.f20684a, i1Var.f20684a) || !Objects.equal(this.f20685b, i1Var.f20685b) || !Objects.equal(this.f20686c, i1Var.f20686c) || !Objects.equal(this.f20687d, i1Var.f20687d) || !Objects.equal(this.f20688e, i1Var.f20688e)) {
            return false;
        }
        return true;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: z8.i1$b} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public z8.i1.b f(y8.w0 r3) {
        /*
            r2 = this;
            java.util.Map r0 = r2.f20685b
            java.lang.String r1 = r3.c()
            java.lang.Object r0 = r0.get(r1)
            z8.i1$b r0 = (z8.i1.b) r0
            if (r0 != 0) goto L_0x001b
            java.lang.String r3 = r3.d()
            java.util.Map r0 = r2.f20686c
            java.lang.Object r3 = r0.get(r3)
            r0 = r3
            z8.i1$b r0 = (z8.i1.b) r0
        L_0x001b:
            if (r0 != 0) goto L_0x001f
            z8.i1$b r0 = r2.f20684a
        L_0x001f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: z8.i1.f(y8.w0):z8.i1$b");
    }

    public x1.c0 g() {
        return this.f20687d;
    }

    public int hashCode() {
        return Objects.hashCode(this.f20684a, this.f20685b, this.f20686c, this.f20687d, this.f20688e);
    }

    public String toString() {
        return MoreObjects.toStringHelper((Object) this).add("defaultMethodConfig", (Object) this.f20684a).add("serviceMethodMap", (Object) this.f20685b).add("serviceMap", (Object) this.f20686c).add("retryThrottling", (Object) this.f20687d).add("loadBalancingConfig", this.f20688e).toString();
    }
}
