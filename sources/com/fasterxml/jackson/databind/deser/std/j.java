package com.fasterxml.jackson.databind.deser.std;

import b3.k;
import c3.k;
import c3.n;
import c4.f;
import d4.h;
import d4.x;
import java.lang.reflect.Constructor;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Locale;
import java.util.TimeZone;
import k3.g;
import n3.i;

public abstract class j {

    /* renamed from: a  reason: collision with root package name */
    public static final HashSet f5628a;

    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f5629a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                m3.b[] r0 = m3.b.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f5629a = r0
                m3.b r1 = m3.b.AsEmpty     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f5629a     // Catch:{ NoSuchFieldError -> 0x001d }
                m3.b r1 = m3.b.AsNull     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f5629a     // Catch:{ NoSuchFieldError -> 0x0028 }
                m3.b r1 = m3.b.TryConvert     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.deser.std.j.a.<clinit>():void");
        }
    }

    public static class d extends c {

        /* renamed from: c  reason: collision with root package name */
        public static final d f5633c = new d();

        public d() {
            super(Date.class);
        }

        /* renamed from: b */
        public Date deserialize(k kVar, g gVar) {
            return _parseDate(kVar, gVar);
        }

        /* renamed from: c */
        public d a(DateFormat dateFormat, String str) {
            return new d(this, dateFormat, str);
        }

        public /* bridge */ /* synthetic */ k3.k createContextual(g gVar, k3.d dVar) {
            return super.createContextual(gVar, dVar);
        }

        public Object getEmptyValue(g gVar) {
            return new Date(0);
        }

        public /* bridge */ /* synthetic */ f logicalType() {
            return super.logicalType();
        }

        public d(d dVar, DateFormat dateFormat, String str) {
            super(dVar, dateFormat, str);
        }
    }

    static {
        HashSet hashSet = new HashSet();
        f5628a = hashSet;
        hashSet.add("java.util.Calendar");
        hashSet.add("java.util.GregorianCalendar");
        hashSet.add("java.util.Date");
    }

    public static k3.k a(Class cls, String str) {
        if (!f5628a.contains(str)) {
            return null;
        }
        if (cls == Calendar.class) {
            return new b();
        }
        if (cls == Date.class) {
            return d.f5633c;
        }
        Class<GregorianCalendar> cls2 = GregorianCalendar.class;
        if (cls == cls2) {
            return new b(cls2);
        }
        return null;
    }

    public static class b extends c {

        /* renamed from: c  reason: collision with root package name */
        public final Constructor f5630c;

        public b() {
            super(Calendar.class);
            this.f5630c = null;
        }

        /* renamed from: b */
        public Calendar deserialize(k kVar, g gVar) {
            Date _parseDate = _parseDate(kVar, gVar);
            if (_parseDate == null) {
                return null;
            }
            Constructor constructor = this.f5630c;
            if (constructor == null) {
                return gVar.v(_parseDate);
            }
            try {
                Calendar calendar = (Calendar) constructor.newInstance(new Object[0]);
                calendar.setTimeInMillis(_parseDate.getTime());
                TimeZone T = gVar.T();
                if (T != null) {
                    calendar.setTimeZone(T);
                }
                return calendar;
            } catch (Exception e10) {
                return (Calendar) gVar.V(handledType(), _parseDate, e10);
            }
        }

        /* renamed from: c */
        public b a(DateFormat dateFormat, String str) {
            return new b(this, dateFormat, str);
        }

        public /* bridge */ /* synthetic */ k3.k createContextual(g gVar, k3.d dVar) {
            return super.createContextual(gVar, dVar);
        }

        public Object getEmptyValue(g gVar) {
            GregorianCalendar gregorianCalendar = new GregorianCalendar();
            gregorianCalendar.setTimeInMillis(0);
            return gregorianCalendar;
        }

        public /* bridge */ /* synthetic */ f logicalType() {
            return super.logicalType();
        }

        public b(Class cls) {
            super(cls);
            this.f5630c = h.q(cls, false);
        }

        public b(b bVar, DateFormat dateFormat, String str) {
            super(bVar, dateFormat, str);
            this.f5630c = bVar.f5630c;
        }
    }

    public static abstract class c extends e0 implements i {

        /* renamed from: a  reason: collision with root package name */
        public final DateFormat f5631a;

        /* renamed from: b  reason: collision with root package name */
        public final String f5632b;

        public c(Class cls) {
            super(cls);
            this.f5631a = null;
            this.f5632b = null;
        }

        public Date _parseDate(k kVar, g gVar) {
            Date parse;
            if (this.f5631a == null || !kVar.j0(n.VALUE_STRING)) {
                return super._parseDate(kVar, gVar);
            }
            String trim = kVar.Y().trim();
            if (trim.isEmpty()) {
                if (a.f5629a[_checkFromStringCoercion(gVar, trim).ordinal()] != 1) {
                    return null;
                }
                return new Date(0);
            }
            synchronized (this.f5631a) {
                try {
                    parse = this.f5631a.parse(trim);
                } catch (ParseException unused) {
                    return (Date) gVar.j0(handledType(), trim, "expected format \"%s\"", this.f5632b);
                } catch (Throwable th) {
                    throw th;
                }
            }
            return parse;
        }

        public abstract c a(DateFormat dateFormat, String str);

        public k3.k createContextual(g gVar, k3.d dVar) {
            x xVar;
            x xVar2;
            Locale locale;
            Locale locale2;
            k.d findFormatOverrides = findFormatOverrides(gVar, dVar, handledType());
            if (findFormatOverrides != null) {
                TimeZone j10 = findFormatOverrides.j();
                Boolean f10 = findFormatOverrides.f();
                if (findFormatOverrides.m()) {
                    String h10 = findFormatOverrides.h();
                    if (findFormatOverrides.l()) {
                        locale2 = findFormatOverrides.g();
                    } else {
                        locale2 = gVar.Q();
                    }
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(h10, locale2);
                    if (j10 == null) {
                        j10 = gVar.T();
                    }
                    simpleDateFormat.setTimeZone(j10);
                    if (f10 != null) {
                        simpleDateFormat.setLenient(f10.booleanValue());
                    }
                    return a(simpleDateFormat, h10);
                }
                Class<x> cls = x.class;
                if (j10 != null) {
                    DateFormat k10 = gVar.k().k();
                    if (k10.getClass() == cls) {
                        if (findFormatOverrides.l()) {
                            locale = findFormatOverrides.g();
                        } else {
                            locale = gVar.Q();
                        }
                        x u10 = ((x) k10).v(j10).u(locale);
                        xVar2 = u10;
                        if (f10 != null) {
                            xVar2 = u10.t(f10);
                        }
                    } else {
                        DateFormat dateFormat = (DateFormat) k10.clone();
                        dateFormat.setTimeZone(j10);
                        xVar2 = dateFormat;
                        if (f10 != null) {
                            dateFormat.setLenient(f10.booleanValue());
                            xVar2 = dateFormat;
                        }
                    }
                    return a(xVar2, this.f5632b);
                } else if (f10 != null) {
                    DateFormat k11 = gVar.k().k();
                    String str = this.f5632b;
                    if (k11.getClass() == cls) {
                        x t10 = ((x) k11).t(f10);
                        str = t10.s();
                        xVar = t10;
                    } else {
                        DateFormat dateFormat2 = (DateFormat) k11.clone();
                        dateFormat2.setLenient(f10.booleanValue());
                        boolean z10 = dateFormat2 instanceof SimpleDateFormat;
                        xVar = dateFormat2;
                        if (z10) {
                            ((SimpleDateFormat) dateFormat2).toPattern();
                            xVar = dateFormat2;
                        }
                    }
                    if (str == null) {
                        str = "[unknown]";
                    }
                    return a(xVar, str);
                }
            }
            return this;
        }

        public f logicalType() {
            return f.DateTime;
        }

        public c(c cVar, DateFormat dateFormat, String str) {
            super((Class) cVar._valueClass);
            this.f5631a = dateFormat;
            this.f5632b = str;
        }
    }
}
