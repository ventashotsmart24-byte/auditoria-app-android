package ca;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import s9.l;
import t9.g;
import t9.i;

public final class r {

    /* renamed from: a  reason: collision with root package name */
    public final Object f11540a;

    /* renamed from: b  reason: collision with root package name */
    public final h f11541b;

    /* renamed from: c  reason: collision with root package name */
    public final l f11542c;

    /* renamed from: d  reason: collision with root package name */
    public final Object f11543d;

    /* renamed from: e  reason: collision with root package name */
    public final Throwable f11544e;

    public r(Object obj, h hVar, l lVar, Object obj2, Throwable th) {
        this.f11540a = obj;
        this.f11541b = hVar;
        this.f11542c = lVar;
        this.f11543d = obj2;
        this.f11544e = th;
    }

    public static /* synthetic */ r b(r rVar, Object obj, h hVar, l lVar, Object obj2, Throwable th, int i10, Object obj3) {
        if ((i10 & 1) != 0) {
            obj = rVar.f11540a;
        }
        if ((i10 & 2) != 0) {
            hVar = rVar.f11541b;
        }
        h hVar2 = hVar;
        if ((i10 & 4) != 0) {
            lVar = rVar.f11542c;
        }
        l lVar2 = lVar;
        if ((i10 & 8) != 0) {
            obj2 = rVar.f11543d;
        }
        Object obj4 = obj2;
        if ((i10 & 16) != 0) {
            th = rVar.f11544e;
        }
        return rVar.a(obj, hVar2, lVar2, obj4, th);
    }

    public final r a(Object obj, h hVar, l lVar, Object obj2, Throwable th) {
        return new r(obj, hVar, lVar, obj2, th);
    }

    public final boolean c() {
        if (this.f11544e != null) {
            return true;
        }
        return false;
    }

    public final void d(k kVar, Throwable th) {
        h hVar = this.f11541b;
        if (hVar != null) {
            kVar.i(hVar, th);
        }
        l lVar = this.f11542c;
        if (lVar != null) {
            kVar.k(lVar, th);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof r)) {
            return false;
        }
        r rVar = (r) obj;
        return i.b(this.f11540a, rVar.f11540a) && i.b(this.f11541b, rVar.f11541b) && i.b(this.f11542c, rVar.f11542c) && i.b(this.f11543d, rVar.f11543d) && i.b(this.f11544e, rVar.f11544e);
    }

    public int hashCode() {
        Object obj = this.f11540a;
        int i10 = 0;
        int hashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        h hVar = this.f11541b;
        int hashCode2 = (hashCode + (hVar == null ? 0 : hVar.hashCode())) * 31;
        l lVar = this.f11542c;
        int hashCode3 = (hashCode2 + (lVar == null ? 0 : lVar.hashCode())) * 31;
        Object obj2 = this.f11543d;
        int hashCode4 = (hashCode3 + (obj2 == null ? 0 : obj2.hashCode())) * 31;
        Throwable th = this.f11544e;
        if (th != null) {
            i10 = th.hashCode();
        }
        return hashCode4 + i10;
    }

    public String toString() {
        return "CompletedContinuation(result=" + this.f11540a + ", cancelHandler=" + this.f11541b + ", onCancellation=" + this.f11542c + ", idempotentResume=" + this.f11543d + ", cancelCause=" + this.f11544e + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ r(Object obj, h hVar, l lVar, Object obj2, Throwable th, int i10, g gVar) {
        this(obj, (i10 & 2) != 0 ? null : hVar, (i10 & 4) != 0 ? null : lVar, (i10 & 8) != 0 ? null : obj2, (i10 & 16) != 0 ? null : th);
    }
}
