package a5;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public final Object f10644a;

    /* renamed from: b  reason: collision with root package name */
    public final Object f10645b;

    public d(Object obj, Object obj2) {
        this.f10644a = obj;
        this.f10645b = obj2;
    }

    public static d b(Object obj, Object obj2) {
        return new d(obj, obj2);
    }

    public Object a() {
        return this.f10644a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || d.class != obj.getClass()) {
            return false;
        }
        d dVar = (d) obj;
        Object obj2 = this.f10644a;
        if (obj2 == null) {
            if (dVar.f10644a != null) {
                return false;
            }
        } else if (!obj2.equals(dVar.f10644a)) {
            return false;
        }
        Object obj3 = this.f10645b;
        if (obj3 == null) {
            if (dVar.f10645b != null) {
                return false;
            }
        } else if (!obj3.equals(dVar.f10645b)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i10;
        Object obj = this.f10644a;
        int i11 = 0;
        if (obj == null) {
            i10 = 0;
        } else {
            i10 = obj.hashCode();
        }
        int i12 = (i10 + 31) * 31;
        Object obj2 = this.f10645b;
        if (obj2 != null) {
            i11 = obj2.hashCode();
        }
        return i12 + i11;
    }
}
