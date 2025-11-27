package ua;

import java.util.Date;

public class b {

    /* renamed from: a  reason: collision with root package name */
    public String f19642a;

    /* renamed from: b  reason: collision with root package name */
    public Object f19643b;

    public b(String str, Object obj) {
        this.f19642a = str;
        this.f19643b = obj;
    }

    public String a() {
        return this.f19642a;
    }

    public Object b() {
        Object obj = this.f19643b;
        if ((obj instanceof Date) || (obj instanceof java.sql.Date)) {
            return wa.b.f19766a.format(obj);
        }
        return obj;
    }
}
