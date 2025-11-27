package k3;

import c3.q;
import d4.h;
import f3.i;
import j3.g;
import java.io.Serializable;
import m3.m;

public class x implements Serializable {

    /* renamed from: d  reason: collision with root package name */
    public static final x f7497d = new x("", (String) null);

    /* renamed from: e  reason: collision with root package name */
    public static final x f7498e = new x(new String(""), (String) null);

    /* renamed from: a  reason: collision with root package name */
    public final String f7499a;

    /* renamed from: b  reason: collision with root package name */
    public final String f7500b;

    /* renamed from: c  reason: collision with root package name */
    public q f7501c;

    public x(String str) {
        this(str, (String) null);
    }

    public static x a(String str) {
        if (str == null || str.isEmpty()) {
            return f7497d;
        }
        return new x(g.f7164b.a(str), (String) null);
    }

    public static x b(String str, String str2) {
        if (str == null) {
            str = "";
        }
        if (str2 != null || !str.isEmpty()) {
            return new x(g.f7164b.a(str), str2);
        }
        return f7497d;
    }

    public String c() {
        return this.f7499a;
    }

    public boolean d() {
        if (this.f7500b != null) {
            return true;
        }
        return false;
    }

    public boolean e() {
        return !this.f7499a.isEmpty();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        x xVar = (x) obj;
        String str = this.f7499a;
        if (str == null) {
            if (xVar.f7499a != null) {
                return false;
            }
        } else if (!str.equals(xVar.f7499a)) {
            return false;
        }
        String str2 = this.f7500b;
        if (str2 != null) {
            return str2.equals(xVar.f7500b);
        }
        if (xVar.f7500b == null) {
            return true;
        }
        return false;
    }

    public boolean f(String str) {
        return this.f7499a.equals(str);
    }

    public x g() {
        String a10;
        if (!this.f7499a.isEmpty() && (a10 = g.f7164b.a(this.f7499a)) != this.f7499a) {
            return new x(a10, this.f7500b);
        }
        return this;
    }

    public boolean h() {
        if (this.f7500b != null || !this.f7499a.isEmpty()) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.f7500b;
        if (str == null) {
            return this.f7499a.hashCode();
        }
        return str.hashCode() ^ this.f7499a.hashCode();
    }

    public q i(m mVar) {
        q qVar;
        q qVar2 = this.f7501c;
        if (qVar2 != null) {
            return qVar2;
        }
        if (mVar == null) {
            qVar = new i(this.f7499a);
        } else {
            qVar = mVar.d(this.f7499a);
        }
        q qVar3 = qVar;
        this.f7501c = qVar3;
        return qVar3;
    }

    public x j(String str) {
        if (str == null) {
            str = "";
        }
        if (str.equals(this.f7499a)) {
            return this;
        }
        return new x(str, this.f7500b);
    }

    public String toString() {
        if (this.f7500b == null) {
            return this.f7499a;
        }
        return "{" + this.f7500b + "}" + this.f7499a;
    }

    public x(String str, String str2) {
        this.f7499a = h.Z(str);
        this.f7500b = str2;
    }
}
