package a4;

import java.util.Collections;
import java.util.List;
import k3.a0;
import k3.c;
import k3.o;
import k3.q;
import r3.i;

public class e {

    /* renamed from: i  reason: collision with root package name */
    public static final c[] f202i = new c[0];

    /* renamed from: a  reason: collision with root package name */
    public final c f203a;

    /* renamed from: b  reason: collision with root package name */
    public a0 f204b;

    /* renamed from: c  reason: collision with root package name */
    public List f205c = Collections.emptyList();

    /* renamed from: d  reason: collision with root package name */
    public c[] f206d;

    /* renamed from: e  reason: collision with root package name */
    public a f207e;

    /* renamed from: f  reason: collision with root package name */
    public Object f208f;

    /* renamed from: g  reason: collision with root package name */
    public i f209g;

    /* renamed from: h  reason: collision with root package name */
    public b4.i f210h;

    public e(c cVar) {
        this.f203a = cVar;
    }

    public o a() {
        c[] cVarArr;
        if (this.f209g != null && this.f204b.D(q.CAN_OVERRIDE_ACCESS_MODIFIERS)) {
            this.f209g.i(this.f204b.D(q.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
        }
        a aVar = this.f207e;
        if (aVar != null) {
            aVar.a(this.f204b);
        }
        List list = this.f205c;
        if (list != null && !list.isEmpty()) {
            List list2 = this.f205c;
            cVarArr = (c[]) list2.toArray(new c[list2.size()]);
            if (this.f204b.D(q.CAN_OVERRIDE_ACCESS_MODIFIERS)) {
                for (c o10 : cVarArr) {
                    o10.o(this.f204b);
                }
            }
        } else if (this.f207e == null && this.f210h == null) {
            return null;
        } else {
            cVarArr = f202i;
        }
        c[] cVarArr2 = this.f206d;
        if (cVarArr2 == null || cVarArr2.length == this.f205c.size()) {
            return new d(this.f203a.z(), this, cVarArr, this.f206d);
        }
        throw new IllegalStateException(String.format("Mismatch between `properties` size (%d), `filteredProperties` (%s): should have as many (or `null` for latter)", new Object[]{Integer.valueOf(this.f205c.size()), Integer.valueOf(this.f206d.length)}));
    }

    public d b() {
        return d.p(this.f203a.z(), this);
    }

    public a c() {
        return this.f207e;
    }

    public c d() {
        return this.f203a;
    }

    public Object e() {
        return this.f208f;
    }

    public b4.i f() {
        return this.f210h;
    }

    public List g() {
        return this.f205c;
    }

    public i h() {
        return this.f209g;
    }

    public void i(a aVar) {
        this.f207e = aVar;
    }

    public void j(a0 a0Var) {
        this.f204b = a0Var;
    }

    public void k(Object obj) {
        this.f208f = obj;
    }

    public void l(c[] cVarArr) {
        if (cVarArr == null || cVarArr.length == this.f205c.size()) {
            this.f206d = cVarArr;
        } else {
            throw new IllegalArgumentException(String.format("Trying to set %d filtered properties; must match length of non-filtered `properties` (%d)", new Object[]{Integer.valueOf(cVarArr.length), Integer.valueOf(this.f205c.size())}));
        }
    }

    public void m(b4.i iVar) {
        this.f210h = iVar;
    }

    public void n(List list) {
        this.f205c = list;
    }

    public void o(i iVar) {
        if (this.f209g == null) {
            this.f209g = iVar;
            return;
        }
        throw new IllegalArgumentException("Multiple type ids specified with " + this.f209g + " and " + iVar);
    }
}
