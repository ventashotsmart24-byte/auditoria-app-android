package com.fasterxml.jackson.databind.deser.std;

import d4.h;
import d4.y;
import f3.f;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.Calendar;
import java.util.Currency;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;
import k3.g;
import k3.k;
import k3.p;
import r3.j;

public class c0 extends p implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    public final int f5573a;

    /* renamed from: b  reason: collision with root package name */
    public final Class f5574b;

    /* renamed from: c  reason: collision with root package name */
    public final o f5575c;

    public static final class a extends p implements Serializable {

        /* renamed from: a  reason: collision with root package name */
        public final Class f5576a;

        /* renamed from: b  reason: collision with root package name */
        public final k f5577b;

        public a(Class cls, k kVar) {
            this.f5576a = cls;
            this.f5577b = kVar;
        }

        public final Object a(String str, g gVar) {
            if (str == null) {
                return null;
            }
            y yVar = new y(gVar.S(), gVar);
            yVar.z0(str);
            try {
                c3.k R0 = yVar.R0();
                R0.s0();
                Object deserialize = this.f5577b.deserialize(R0, gVar);
                if (deserialize != null) {
                    return deserialize;
                }
                return gVar.g0(this.f5576a, str, "not a valid representation", new Object[0]);
            } catch (Exception e10) {
                return gVar.g0(this.f5576a, str, "not a valid representation: %s", e10.getMessage());
            }
        }
    }

    public static final class b extends c0 {

        /* renamed from: d  reason: collision with root package name */
        public final d4.k f5578d;

        /* renamed from: e  reason: collision with root package name */
        public final j f5579e;

        /* renamed from: f  reason: collision with root package name */
        public d4.k f5580f;

        /* renamed from: g  reason: collision with root package name */
        public final Enum f5581g;

        public b(d4.k kVar, j jVar) {
            super(-1, kVar.n());
            this.f5578d = kVar;
            this.f5579e = jVar;
            this.f5581g = kVar.m();
        }

        public Object b(String str, g gVar) {
            d4.k kVar;
            j jVar = this.f5579e;
            if (jVar != null) {
                try {
                    return jVar.s(str);
                } catch (Exception e10) {
                    h.l0(e10);
                }
            }
            if (gVar.n0(k3.h.READ_ENUMS_USING_TO_STRING)) {
                kVar = h(gVar);
            } else {
                kVar = this.f5578d;
            }
            Enum l10 = kVar.l(str);
            if (l10 != null) {
                return l10;
            }
            if (this.f5581g != null && gVar.n0(k3.h.READ_UNKNOWN_ENUM_VALUES_USING_DEFAULT_VALUE)) {
                return this.f5581g;
            }
            if (gVar.n0(k3.h.READ_UNKNOWN_ENUM_VALUES_AS_NULL)) {
                return l10;
            }
            return gVar.g0(this.f5574b, str, "not one of the values accepted for Enum class: %s", kVar.o());
        }

        public final d4.k h(g gVar) {
            d4.k kVar = this.f5580f;
            if (kVar == null) {
                synchronized (this) {
                    kVar = d4.k.k(gVar.k(), this.f5578d.n());
                    this.f5580f = kVar;
                }
            }
            return kVar;
        }
    }

    public static final class c extends c0 {

        /* renamed from: d  reason: collision with root package name */
        public final Constructor f5582d;

        public c(Constructor constructor) {
            super(-1, constructor.getDeclaringClass());
            this.f5582d = constructor;
        }

        public Object b(String str, g gVar) {
            return this.f5582d.newInstance(new Object[]{str});
        }
    }

    public static final class d extends c0 {

        /* renamed from: d  reason: collision with root package name */
        public final Method f5583d;

        public d(Method method) {
            super(-1, method.getDeclaringClass());
            this.f5583d = method;
        }

        public Object b(String str, g gVar) {
            return this.f5583d.invoke((Object) null, new Object[]{str});
        }
    }

    public static final class e extends c0 {

        /* renamed from: d  reason: collision with root package name */
        public static final e f5584d = new e(String.class);

        /* renamed from: e  reason: collision with root package name */
        public static final e f5585e = new e(Object.class);

        public e(Class cls) {
            super(-1, cls);
        }

        public static e h(Class cls) {
            if (cls == String.class) {
                return f5584d;
            }
            if (cls == Object.class) {
                return f5585e;
            }
            return new e(cls);
        }

        public Object a(String str, g gVar) {
            return str;
        }
    }

    public c0(int i10, Class cls) {
        this(i10, cls, (o) null);
    }

    public static c0 g(Class cls) {
        int i10;
        if (cls == String.class || cls == Object.class || cls == CharSequence.class || cls == Serializable.class) {
            return e.h(cls);
        }
        if (cls == UUID.class) {
            i10 = 12;
        } else if (cls == Integer.class) {
            i10 = 5;
        } else if (cls == Long.class) {
            i10 = 6;
        } else if (cls == Date.class) {
            i10 = 10;
        } else if (cls == Calendar.class) {
            i10 = 11;
        } else if (cls == Boolean.class) {
            i10 = 1;
        } else if (cls == Byte.class) {
            i10 = 2;
        } else if (cls == Character.class) {
            i10 = 4;
        } else if (cls == Short.class) {
            i10 = 3;
        } else if (cls == Float.class) {
            i10 = 7;
        } else if (cls == Double.class) {
            i10 = 8;
        } else if (cls == URI.class) {
            i10 = 13;
        } else if (cls == URL.class) {
            i10 = 14;
        } else if (cls == Class.class) {
            i10 = 15;
        } else {
            Class<Locale> cls2 = Locale.class;
            if (cls == cls2) {
                return new c0(9, cls, o.f(cls2));
            }
            Class<Currency> cls3 = Currency.class;
            if (cls == cls3) {
                return new c0(16, cls, o.f(cls3));
            }
            if (cls != byte[].class) {
                return null;
            }
            i10 = 17;
        }
        return new c0(i10, cls);
    }

    public Object a(String str, g gVar) {
        if (str == null) {
            return null;
        }
        try {
            Object b10 = b(str, gVar);
            if (b10 != null) {
                return b10;
            }
            if (!h.L(this.f5574b) || !gVar.k().j0(k3.h.READ_UNKNOWN_ENUM_VALUES_AS_NULL)) {
                return gVar.g0(this.f5574b, str, "not a valid representation", new Object[0]);
            }
            return null;
        } catch (Exception e10) {
            return gVar.g0(this.f5574b, str, "not a valid representation, problem: (%s) %s", e10.getClass().getName(), h.o(e10));
        }
    }

    public Object b(String str, g gVar) {
        switch (this.f5573a) {
            case 1:
                if ("true".equals(str)) {
                    return Boolean.TRUE;
                }
                if ("false".equals(str)) {
                    return Boolean.FALSE;
                }
                return gVar.g0(this.f5574b, str, "value not 'true' or 'false'", new Object[0]);
            case 2:
                int d10 = d(str);
                if (d10 < -128 || d10 > 255) {
                    return gVar.g0(this.f5574b, str, "overflow, value cannot be represented as 8-bit value", new Object[0]);
                }
                return Byte.valueOf((byte) d10);
            case 3:
                int d11 = d(str);
                if (d11 < -32768 || d11 > 32767) {
                    return gVar.g0(this.f5574b, str, "overflow, value cannot be represented as 16-bit value", new Object[0]);
                }
                return Short.valueOf((short) d11);
            case 4:
                if (str.length() == 1) {
                    return Character.valueOf(str.charAt(0));
                }
                return gVar.g0(this.f5574b, str, "can only convert 1-character Strings", new Object[0]);
            case 5:
                return Integer.valueOf(d(str));
            case 6:
                return Long.valueOf(e(str));
            case 7:
                return Float.valueOf((float) c(str));
            case 8:
                return Double.valueOf(c(str));
            case 9:
                try {
                    return this.f5575c.a(str, gVar);
                } catch (IllegalArgumentException e10) {
                    return f(gVar, str, e10);
                }
            case 10:
                return gVar.s0(str);
            case 11:
                return gVar.v(gVar.s0(str));
            case 12:
                try {
                    return UUID.fromString(str);
                } catch (Exception e11) {
                    return f(gVar, str, e11);
                }
            case 13:
                try {
                    return URI.create(str);
                } catch (Exception e12) {
                    return f(gVar, str, e12);
                }
            case 14:
                try {
                    return new URL(str);
                } catch (MalformedURLException e13) {
                    return f(gVar, str, e13);
                }
            case 15:
                try {
                    return gVar.A(str);
                } catch (Exception unused) {
                    return gVar.g0(this.f5574b, str, "unable to parse key as Class", new Object[0]);
                }
            case 16:
                try {
                    return this.f5575c.a(str, gVar);
                } catch (IllegalArgumentException e14) {
                    return f(gVar, str, e14);
                }
            case 17:
                try {
                    return gVar.k().h().f(str);
                } catch (IllegalArgumentException e15) {
                    return f(gVar, str, e15);
                }
            default:
                throw new IllegalStateException("Internal error: unknown key type " + this.f5574b);
        }
    }

    public double c(String str) {
        return f.i(str);
    }

    public int d(String str) {
        return Integer.parseInt(str);
    }

    public long e(String str) {
        return Long.parseLong(str);
    }

    public Object f(g gVar, String str, Exception exc) {
        return gVar.g0(this.f5574b, str, "problem: %s", h.o(exc));
    }

    public c0(int i10, Class cls, o oVar) {
        this.f5573a = i10;
        this.f5574b = cls;
        this.f5575c = oVar;
    }
}
