package com.fasterxml.jackson.databind.deser.std;

import c3.k;
import c3.n;
import c4.f;
import d4.h;
import j3.q;
import java.io.File;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Currency;
import java.util.Locale;
import java.util.TimeZone;
import java.util.regex.Pattern;
import k3.g;
import k3.j;
import k3.l;
import m3.e;
import p3.c;

public abstract class o extends e0 {

    public static class a extends o {

        /* renamed from: a  reason: collision with root package name */
        public final int f5662a;

        public a(Class cls, int i10) {
            super(cls);
            this.f5662a = i10;
        }

        public Object a(String str, g gVar) {
            int i10;
            switch (this.f5662a) {
                case 1:
                    return new File(str);
                case 2:
                    return new URL(str);
                case 3:
                    return URI.create(str);
                case 4:
                    try {
                        return gVar.A(str);
                    } catch (Exception e10) {
                        return gVar.V(this._valueClass, str, h.F(e10));
                    }
                case 5:
                    return gVar.l().A(str);
                case 6:
                    return Currency.getInstance(str);
                case 7:
                    return Pattern.compile(str);
                case 8:
                    int h10 = h(str);
                    if (h10 < 0) {
                        return new Locale(str);
                    }
                    String substring = str.substring(0, h10);
                    String substring2 = str.substring(h10 + 1);
                    int h11 = h(substring2);
                    if (h11 < 0) {
                        return new Locale(substring, substring2);
                    }
                    return new Locale(substring, substring2.substring(0, h11), substring2.substring(h11 + 1));
                case 9:
                    return Charset.forName(str);
                case 10:
                    return TimeZone.getTimeZone(str);
                case 11:
                    return InetAddress.getByName(str);
                case 12:
                    if (str.startsWith("[")) {
                        int lastIndexOf = str.lastIndexOf(93);
                        if (lastIndexOf != -1) {
                            int indexOf = str.indexOf(58, lastIndexOf);
                            if (indexOf > -1) {
                                i10 = Integer.parseInt(str.substring(indexOf + 1));
                            } else {
                                i10 = 0;
                            }
                            return new InetSocketAddress(str.substring(0, lastIndexOf + 1), i10);
                        }
                        throw new c(gVar.S(), "Bracketed IPv6 address must contain closing bracket", str, InetSocketAddress.class);
                    }
                    int indexOf2 = str.indexOf(58);
                    if (indexOf2 >= 0) {
                        int i11 = indexOf2 + 1;
                        if (str.indexOf(58, i11) < 0) {
                            return new InetSocketAddress(str.substring(0, indexOf2), Integer.parseInt(str.substring(i11)));
                        }
                    }
                    return new InetSocketAddress(str, 0);
                default:
                    q.a();
                    return null;
            }
        }

        public Object d(g gVar) {
            return getEmptyValue(gVar);
        }

        public Object getEmptyValue(g gVar) {
            int i10 = this.f5662a;
            if (i10 == 3) {
                return URI.create("");
            }
            if (i10 != 8) {
                return super.getEmptyValue(gVar);
            }
            return Locale.ROOT;
        }

        public int h(String str) {
            int length = str.length();
            for (int i10 = 0; i10 < length; i10++) {
                char charAt = str.charAt(i10);
                if (charAt == '_' || charAt == '-') {
                    return i10;
                }
            }
            return -1;
        }
    }

    public static class b extends o {
        public b() {
            super(StringBuilder.class);
        }

        public Object a(String str, g gVar) {
            return new StringBuilder(str);
        }

        public Object deserialize(k kVar, g gVar) {
            String g02 = kVar.g0();
            if (g02 != null) {
                return a(g02, gVar);
            }
            return o.super.deserialize(kVar, gVar);
        }

        public Object getEmptyValue(g gVar) {
            return new StringBuilder();
        }

        public f logicalType() {
            return f.Textual;
        }
    }

    public o(Class cls) {
        super(cls);
    }

    public static o f(Class cls) {
        int i10;
        if (cls == File.class) {
            i10 = 1;
        } else if (cls == URL.class) {
            i10 = 2;
        } else if (cls == URI.class) {
            i10 = 3;
        } else if (cls == Class.class) {
            i10 = 4;
        } else if (cls == j.class) {
            i10 = 5;
        } else if (cls == Currency.class) {
            i10 = 6;
        } else if (cls == Pattern.class) {
            i10 = 7;
        } else if (cls == Locale.class) {
            i10 = 8;
        } else if (cls == Charset.class) {
            i10 = 9;
        } else if (cls == TimeZone.class) {
            i10 = 10;
        } else if (cls == InetAddress.class) {
            i10 = 11;
        } else if (cls == InetSocketAddress.class) {
            i10 = 12;
        } else if (cls == StringBuilder.class) {
            return new b();
        } else {
            return null;
        }
        return new a(cls, i10);
    }

    public static Class[] g() {
        return new Class[]{File.class, URL.class, URI.class, Class.class, j.class, Currency.class, Pattern.class, Locale.class, Charset.class, TimeZone.class, InetAddress.class, InetSocketAddress.class, StringBuilder.class};
    }

    public abstract Object a(String str, g gVar);

    public Object b(Object obj, g gVar) {
        gVar.z0(this, "Don't know how to convert embedded Object of type %s into %s", obj.getClass().getName(), this._valueClass.getName());
        return null;
    }

    public Object c(g gVar) {
        m3.b B = gVar.B(logicalType(), this._valueClass, e.EmptyString);
        if (B == m3.b.Fail) {
            gVar.z0(this, "Cannot coerce empty String (\"\") to %s (but could if enabling coercion using `CoercionConfig`)", _coercedTypeDesc());
        }
        if (B == m3.b.AsNull) {
            return getNullValue(gVar);
        }
        if (B == m3.b.AsEmpty) {
            return getEmptyValue(gVar);
        }
        return d(gVar);
    }

    public Object d(g gVar) {
        return getNullValue(gVar);
    }

    public Object deserialize(k kVar, g gVar) {
        String g02 = kVar.g0();
        if (g02 == null) {
            n n10 = kVar.n();
            if (n10 != n.START_OBJECT) {
                return e(kVar, gVar, n10);
            }
            g02 = gVar.z(kVar, this, this._valueClass);
        }
        if (!g02.isEmpty()) {
            String trim = g02.trim();
            if (!trim.isEmpty()) {
                try {
                    return a(trim, gVar);
                } catch (IllegalArgumentException | MalformedURLException e10) {
                    String message = e10.getMessage();
                    String str = "not a valid textual representation";
                    if (message != null) {
                        str = str + ", problem: " + message;
                    }
                    l L0 = gVar.L0(trim, this._valueClass, str);
                    L0.initCause(e10);
                    throw L0;
                }
            }
        }
        return c(gVar);
    }

    public Object e(k kVar, g gVar, n nVar) {
        if (nVar == n.START_ARRAY) {
            return _deserializeFromArray(kVar, gVar);
        }
        if (nVar != n.VALUE_EMBEDDED_OBJECT) {
            return gVar.a0(this._valueClass, kVar);
        }
        Object N = kVar.N();
        if (N == null) {
            return null;
        }
        if (this._valueClass.isAssignableFrom(N.getClass())) {
            return N;
        }
        return b(N, gVar);
    }

    public f logicalType() {
        return f.OtherScalar;
    }
}
