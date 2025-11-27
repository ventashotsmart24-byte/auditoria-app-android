package b3;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.io.Serializable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface r {

    public enum a {
        ALWAYS,
        NON_NULL,
        NON_ABSENT,
        NON_EMPTY,
        NON_DEFAULT,
        CUSTOM,
        USE_DEFAULTS
    }

    public static class b implements Serializable {

        /* renamed from: e  reason: collision with root package name */
        public static final b f4309e;

        /* renamed from: a  reason: collision with root package name */
        public final a f4310a;

        /* renamed from: b  reason: collision with root package name */
        public final a f4311b;

        /* renamed from: c  reason: collision with root package name */
        public final Class f4312c;

        /* renamed from: d  reason: collision with root package name */
        public final Class f4313d;

        static {
            a aVar = a.USE_DEFAULTS;
            f4309e = new b(aVar, aVar, (Class) null, (Class) null);
        }

        public b(a aVar, a aVar2, Class cls, Class cls2) {
            this.f4310a = aVar == null ? a.USE_DEFAULTS : aVar;
            this.f4311b = aVar2 == null ? a.USE_DEFAULTS : aVar2;
            Class<Void> cls3 = Void.class;
            this.f4312c = cls == cls3 ? null : cls;
            this.f4313d = cls2 == cls3 ? null : cls2;
        }

        public static b a(a aVar, a aVar2) {
            a aVar3 = a.USE_DEFAULTS;
            if ((aVar == aVar3 || aVar == null) && (aVar2 == aVar3 || aVar2 == null)) {
                return f4309e;
            }
            return new b(aVar, aVar2, (Class) null, (Class) null);
        }

        public static b b(a aVar, a aVar2, Class cls, Class cls2) {
            Class<Void> cls3 = Void.class;
            if (cls == cls3) {
                cls = null;
            }
            if (cls2 == cls3) {
                cls2 = null;
            }
            a aVar3 = a.USE_DEFAULTS;
            if ((aVar == aVar3 || aVar == null) && ((aVar2 == aVar3 || aVar2 == null) && cls == null && cls2 == null)) {
                return f4309e;
            }
            return new b(aVar, aVar2, cls, cls2);
        }

        public static b c() {
            return f4309e;
        }

        public static b d(r rVar) {
            if (rVar == null) {
                return f4309e;
            }
            a value = rVar.value();
            a content = rVar.content();
            a aVar = a.USE_DEFAULTS;
            if (value == aVar && content == aVar) {
                return f4309e;
            }
            Class<Void> valueFilter = rVar.valueFilter();
            Class<Void> cls = null;
            Class<Void> cls2 = Void.class;
            if (valueFilter == cls2) {
                valueFilter = null;
            }
            Class<Void> contentFilter = rVar.contentFilter();
            if (contentFilter != cls2) {
                cls = contentFilter;
            }
            return new b(value, content, valueFilter, cls);
        }

        public static b i(b bVar, b bVar2) {
            if (bVar == null) {
                return bVar2;
            }
            return bVar.m(bVar2);
        }

        public static b j(b... bVarArr) {
            b bVar = null;
            for (b bVar2 : bVarArr) {
                if (bVar2 != null) {
                    if (bVar != null) {
                        bVar2 = bVar.m(bVar2);
                    }
                    bVar = bVar2;
                }
            }
            return bVar;
        }

        public Class e() {
            return this.f4313d;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj == null || obj.getClass() != getClass()) {
                return false;
            }
            b bVar = (b) obj;
            if (bVar.f4310a == this.f4310a && bVar.f4311b == this.f4311b && bVar.f4312c == this.f4312c && bVar.f4313d == this.f4313d) {
                return true;
            }
            return false;
        }

        public a f() {
            return this.f4311b;
        }

        public Class g() {
            return this.f4312c;
        }

        public a h() {
            return this.f4310a;
        }

        public int hashCode() {
            return (this.f4310a.hashCode() << 2) + this.f4311b.hashCode();
        }

        public b k(Class cls) {
            a aVar;
            if (cls == null || cls == Void.class) {
                aVar = a.USE_DEFAULTS;
                cls = null;
            } else {
                aVar = a.CUSTOM;
            }
            return b(this.f4310a, aVar, this.f4312c, cls);
        }

        public b l(a aVar) {
            if (aVar == this.f4311b) {
                return this;
            }
            return new b(this.f4310a, aVar, this.f4312c, this.f4313d);
        }

        public b m(b bVar) {
            boolean z10;
            boolean z11;
            if (!(bVar == null || bVar == f4309e)) {
                a aVar = bVar.f4310a;
                a aVar2 = bVar.f4311b;
                Class cls = bVar.f4312c;
                Class cls2 = bVar.f4313d;
                a aVar3 = this.f4310a;
                boolean z12 = true;
                if (aVar == aVar3 || aVar == a.USE_DEFAULTS) {
                    z10 = false;
                } else {
                    z10 = true;
                }
                a aVar4 = this.f4311b;
                if (aVar2 == aVar4 || aVar2 == a.USE_DEFAULTS) {
                    z11 = false;
                } else {
                    z11 = true;
                }
                Class cls3 = this.f4312c;
                if (cls == cls3 && cls2 == cls3) {
                    z12 = false;
                }
                if (z10) {
                    if (z11) {
                        return new b(aVar, aVar2, cls, cls2);
                    }
                    return new b(aVar, aVar4, cls, cls2);
                } else if (z11) {
                    return new b(aVar3, aVar2, cls, cls2);
                } else {
                    if (z12) {
                        return new b(aVar3, aVar4, cls, cls2);
                    }
                }
            }
            return this;
        }

        public b n(a aVar) {
            if (aVar == this.f4310a) {
                return this;
            }
            return new b(aVar, this.f4311b, this.f4312c, this.f4313d);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(80);
            sb.append("JsonInclude.Value(value=");
            sb.append(this.f4310a);
            sb.append(",content=");
            sb.append(this.f4311b);
            if (this.f4312c != null) {
                sb.append(",valueFilter=");
                sb.append(this.f4312c.getName());
                sb.append(".class");
            }
            if (this.f4313d != null) {
                sb.append(",contentFilter=");
                sb.append(this.f4313d.getName());
                sb.append(".class");
            }
            sb.append(ASCIIPropertyListParser.ARRAY_END_TOKEN);
            return sb.toString();
        }
    }

    a content() default a.ALWAYS;

    Class contentFilter() default Void.class;

    a value() default a.ALWAYS;

    Class valueFilter() default Void.class;
}
