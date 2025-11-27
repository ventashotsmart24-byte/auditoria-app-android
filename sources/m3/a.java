package m3;

import c4.o;
import java.io.Serializable;
import java.text.DateFormat;
import java.util.Locale;
import java.util.TimeZone;
import k3.b;
import k3.y;
import r3.a;
import r3.t;
import w3.c;
import w3.g;

public final class a implements Serializable {

    /* renamed from: k  reason: collision with root package name */
    public static final TimeZone f7808k = TimeZone.getTimeZone("UTC");

    /* renamed from: a  reason: collision with root package name */
    public final o f7809a;

    /* renamed from: b  reason: collision with root package name */
    public final t f7810b;

    /* renamed from: c  reason: collision with root package name */
    public final b f7811c;

    /* renamed from: d  reason: collision with root package name */
    public final a.C0120a f7812d;

    /* renamed from: e  reason: collision with root package name */
    public final g f7813e;

    /* renamed from: f  reason: collision with root package name */
    public final c f7814f;

    /* renamed from: g  reason: collision with root package name */
    public final DateFormat f7815g;

    /* renamed from: h  reason: collision with root package name */
    public final Locale f7816h;

    /* renamed from: i  reason: collision with root package name */
    public final TimeZone f7817i;

    /* renamed from: j  reason: collision with root package name */
    public final c3.a f7818j;

    public a(t tVar, b bVar, y yVar, o oVar, g gVar, DateFormat dateFormat, l lVar, Locale locale, TimeZone timeZone, c3.a aVar, c cVar, a.C0120a aVar2) {
        this.f7810b = tVar;
        this.f7811c = bVar;
        this.f7809a = oVar;
        this.f7813e = gVar;
        this.f7815g = dateFormat;
        this.f7816h = locale;
        this.f7817i = timeZone;
        this.f7818j = aVar;
        this.f7814f = cVar;
        this.f7812d = aVar2;
    }

    public a.C0120a a() {
        return this.f7812d;
    }

    public b b() {
        return this.f7811c;
    }

    public c3.a c() {
        return this.f7818j;
    }

    public t d() {
        return this.f7810b;
    }

    public DateFormat e() {
        return this.f7815g;
    }

    public l f() {
        return null;
    }

    public Locale g() {
        return this.f7816h;
    }

    public c h() {
        return this.f7814f;
    }

    public y i() {
        return null;
    }

    public TimeZone j() {
        TimeZone timeZone = this.f7817i;
        if (timeZone == null) {
            return f7808k;
        }
        return timeZone;
    }

    public o k() {
        return this.f7809a;
    }

    public g l() {
        return this.f7813e;
    }

    public a m(t tVar) {
        if (this.f7810b == tVar) {
            return this;
        }
        return new a(tVar, this.f7811c, (y) null, this.f7809a, this.f7813e, this.f7815g, (l) null, this.f7816h, this.f7817i, this.f7818j, this.f7814f, this.f7812d);
    }
}
