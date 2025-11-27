package ta;

import ra.a;

public class e {

    /* renamed from: a  reason: collision with root package name */
    public Object f19605a;

    /* renamed from: b  reason: collision with root package name */
    public Class f19606b;

    /* renamed from: c  reason: collision with root package name */
    public Class f19607c;

    /* renamed from: d  reason: collision with root package name */
    public a f19608d;

    /* renamed from: e  reason: collision with root package name */
    public Object f19609e;

    /* renamed from: f  reason: collision with root package name */
    public Object f19610f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f19611g = false;

    public e(Object obj, Class cls, Class cls2, a aVar) {
        this.f19605a = obj;
        this.f19606b = cls;
        this.f19607c = cls2;
        this.f19608d = aVar;
    }

    public Object a() {
        if (this.f19610f == null && !this.f19611g) {
            this.f19608d.q((d) null, this.f19605a, this.f19606b, this.f19607c);
            this.f19611g = true;
        }
        return this.f19610f;
    }

    public Object b() {
        return this.f19609e;
    }

    public void c(Object obj) {
        this.f19610f = obj;
    }

    public void d(Object obj) {
        this.f19609e = obj;
    }
}
