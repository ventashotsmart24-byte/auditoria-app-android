package com.fasterxml.jackson.databind.ser.std;

import a4.i;
import b3.k;
import c3.h;
import c3.k;
import d4.x;
import h3.b;
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicReference;
import k3.b0;
import k3.c0;
import k3.d;
import k3.j;
import k3.o;
import u3.f;
import u3.m;

public abstract class l extends h0 implements i {

    /* renamed from: a  reason: collision with root package name */
    public final Boolean f5768a;

    /* renamed from: b  reason: collision with root package name */
    public final DateFormat f5769b;

    /* renamed from: c  reason: collision with root package name */
    public final AtomicReference f5770c;

    public l(Class cls, Boolean bool, DateFormat dateFormat) {
        super(cls);
        AtomicReference atomicReference;
        this.f5768a = bool;
        this.f5769b = dateFormat;
        if (dateFormat == null) {
            atomicReference = null;
        } else {
            atomicReference = new AtomicReference();
        }
        this.f5770c = atomicReference;
    }

    public void acceptJsonFormatVisitor(f fVar, j jVar) {
        c(fVar, jVar, d(fVar.getProvider()));
    }

    public o b(c0 c0Var, d dVar) {
        boolean z10;
        SimpleDateFormat simpleDateFormat;
        Locale locale;
        TimeZone timeZone;
        k.d findFormatOverrides = findFormatOverrides(c0Var, dVar, handledType());
        if (findFormatOverrides == null) {
            return this;
        }
        k.c i10 = findFormatOverrides.i();
        if (i10.a()) {
            return f(Boolean.TRUE, (DateFormat) null);
        }
        if (findFormatOverrides.m()) {
            if (findFormatOverrides.l()) {
                locale = findFormatOverrides.g();
            } else {
                locale = c0Var.e0();
            }
            SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat(findFormatOverrides.h(), locale);
            if (findFormatOverrides.o()) {
                timeZone = findFormatOverrides.j();
            } else {
                timeZone = c0Var.f0();
            }
            simpleDateFormat2.setTimeZone(timeZone);
            return f(Boolean.FALSE, simpleDateFormat2);
        }
        boolean l10 = findFormatOverrides.l();
        boolean o10 = findFormatOverrides.o();
        boolean z11 = true;
        if (i10 == k.c.STRING) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!l10 && !o10 && !z10) {
            return this;
        }
        DateFormat k10 = c0Var.k().k();
        if (k10 instanceof x) {
            x xVar = (x) k10;
            if (findFormatOverrides.l()) {
                xVar = xVar.u(findFormatOverrides.g());
            }
            if (findFormatOverrides.o()) {
                xVar = xVar.v(findFormatOverrides.j());
            }
            return f(Boolean.FALSE, xVar);
        }
        if (!(k10 instanceof SimpleDateFormat)) {
            c0Var.p(handledType(), String.format("Configured `DateFormat` (%s) not a `SimpleDateFormat`; cannot configure `Locale` or `TimeZone`", new Object[]{k10.getClass().getName()}));
        }
        SimpleDateFormat simpleDateFormat3 = (SimpleDateFormat) k10;
        if (l10) {
            simpleDateFormat = new SimpleDateFormat(simpleDateFormat3.toPattern(), findFormatOverrides.g());
        } else {
            simpleDateFormat = (SimpleDateFormat) simpleDateFormat3.clone();
        }
        TimeZone j10 = findFormatOverrides.j();
        if (j10 == null || j10.equals(simpleDateFormat.getTimeZone())) {
            z11 = false;
        }
        if (z11) {
            simpleDateFormat.setTimeZone(j10);
        }
        return f(Boolean.FALSE, simpleDateFormat);
    }

    public void c(f fVar, j jVar, boolean z10) {
        if (z10) {
            visitIntFormat(fVar, jVar, k.b.LONG, m.UTC_MILLISEC);
        } else {
            visitStringFormat(fVar, jVar, m.DATE_TIME);
        }
    }

    public boolean d(c0 c0Var) {
        Boolean bool = this.f5768a;
        if (bool != null) {
            return bool.booleanValue();
        }
        if (this.f5769b != null) {
            return false;
        }
        if (c0Var != null) {
            return c0Var.m0(b0.WRITE_DATES_AS_TIMESTAMPS);
        }
        throw new IllegalArgumentException("Null SerializerProvider passed for " + handledType().getName());
    }

    public void e(Date date, h hVar, c0 c0Var) {
        if (this.f5769b == null) {
            c0Var.D(date, hVar);
            return;
        }
        DateFormat dateFormat = (DateFormat) this.f5770c.getAndSet((Object) null);
        if (dateFormat == null) {
            dateFormat = (DateFormat) this.f5769b.clone();
        }
        hVar.z0(dateFormat.format(date));
        b.a(this.f5770c, (Object) null, dateFormat);
    }

    public abstract l f(Boolean bool, DateFormat dateFormat);

    public k3.m getSchema(c0 c0Var, Type type) {
        String str;
        if (d(c0Var)) {
            str = "number";
        } else {
            str = "string";
        }
        return createSchemaNode(str, true);
    }

    public boolean isEmpty(c0 c0Var, Object obj) {
        return false;
    }
}
