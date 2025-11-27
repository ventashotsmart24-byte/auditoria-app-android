package k3;

import b3.j0;
import java.io.Serializable;
import r3.i;

public class w implements Serializable {

    /* renamed from: h  reason: collision with root package name */
    public static final w f7485h = new w(Boolean.TRUE, (String) null, (Integer) null, (String) null, (a) null, (j0) null, (j0) null);

    /* renamed from: i  reason: collision with root package name */
    public static final w f7486i = new w(Boolean.FALSE, (String) null, (Integer) null, (String) null, (a) null, (j0) null, (j0) null);

    /* renamed from: j  reason: collision with root package name */
    public static final w f7487j = new w((Boolean) null, (String) null, (Integer) null, (String) null, (a) null, (j0) null, (j0) null);

    /* renamed from: a  reason: collision with root package name */
    public final Boolean f7488a;

    /* renamed from: b  reason: collision with root package name */
    public final String f7489b;

    /* renamed from: c  reason: collision with root package name */
    public final Integer f7490c;

    /* renamed from: d  reason: collision with root package name */
    public final String f7491d;

    /* renamed from: e  reason: collision with root package name */
    public final transient a f7492e;

    /* renamed from: f  reason: collision with root package name */
    public j0 f7493f;

    /* renamed from: g  reason: collision with root package name */
    public j0 f7494g;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final i f7495a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f7496b;

        public a(i iVar, boolean z10) {
            this.f7495a = iVar;
            this.f7496b = z10;
        }

        public static a a(i iVar) {
            return new a(iVar, true);
        }

        public static a b(i iVar) {
            return new a(iVar, false);
        }

        public static a c(i iVar) {
            return new a(iVar, false);
        }
    }

    public w(Boolean bool, String str, Integer num, String str2, a aVar, j0 j0Var, j0 j0Var2) {
        this.f7488a = bool;
        this.f7489b = str;
        this.f7490c = num;
        this.f7491d = (str2 == null || str2.isEmpty()) ? null : str2;
        this.f7492e = aVar;
        this.f7493f = j0Var;
        this.f7494g = j0Var2;
    }

    public static w a(Boolean bool, String str, Integer num, String str2) {
        if (str != null || num != null || str2 != null) {
            return new w(bool, str, num, str2, (a) null, (j0) null, (j0) null);
        }
        if (bool == null) {
            return f7487j;
        }
        if (bool.booleanValue()) {
            return f7485h;
        }
        return f7486i;
    }

    public j0 b() {
        return this.f7494g;
    }

    public Integer c() {
        return this.f7490c;
    }

    public a d() {
        return this.f7492e;
    }

    public j0 e() {
        return this.f7493f;
    }

    public boolean f() {
        if (this.f7490c != null) {
            return true;
        }
        return false;
    }

    public boolean g() {
        Boolean bool = this.f7488a;
        if (bool == null || !bool.booleanValue()) {
            return false;
        }
        return true;
    }

    public w h(String str) {
        return new w(this.f7488a, str, this.f7490c, this.f7491d, this.f7492e, this.f7493f, this.f7494g);
    }

    public w i(a aVar) {
        return new w(this.f7488a, this.f7489b, this.f7490c, this.f7491d, aVar, this.f7493f, this.f7494g);
    }

    public w j(j0 j0Var, j0 j0Var2) {
        return new w(this.f7488a, this.f7489b, this.f7490c, this.f7491d, this.f7492e, j0Var, j0Var2);
    }
}
