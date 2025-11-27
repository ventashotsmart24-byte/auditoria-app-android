package r3;

import com.umeng.analytics.pro.bt;
import java.util.HashSet;
import java.util.Set;
import k3.q;
import l3.e;
import m3.m;
import r3.a;

public class w extends a {

    /* renamed from: a  reason: collision with root package name */
    public final m f9174a;

    /* renamed from: b  reason: collision with root package name */
    public final c f9175b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f9176c;

    /* renamed from: d  reason: collision with root package name */
    public final String f9177d;

    /* renamed from: e  reason: collision with root package name */
    public final String f9178e;

    /* renamed from: f  reason: collision with root package name */
    public final String f9179f;

    public interface a {
    }

    public static class b extends a.C0120a {

        /* renamed from: a  reason: collision with root package name */
        public final String f9180a;

        /* renamed from: b  reason: collision with root package name */
        public final String f9181b;

        /* renamed from: c  reason: collision with root package name */
        public final String f9182c;

        /* renamed from: d  reason: collision with root package name */
        public final String f9183d;

        public b() {
            this("set", "with", "get", bt.ae, (a) null);
        }

        public a a(m mVar, c cVar, k3.c cVar2) {
            k3.b bVar;
            String str;
            e.a aVar = null;
            if (mVar.C()) {
                bVar = mVar.g();
            } else {
                bVar = null;
            }
            if (bVar != null) {
                aVar = bVar.E(cVar);
            }
            if (aVar == null) {
                str = this.f9181b;
            } else {
                str = aVar.f7620b;
            }
            return new w(mVar, cVar, str, this.f9182c, this.f9183d, (a) null);
        }

        public a b(m mVar, c cVar) {
            return new w(mVar, cVar, this.f9180a, this.f9182c, this.f9183d, (a) null);
        }

        public a c(m mVar, c cVar) {
            return new c(mVar, cVar);
        }

        public b(String str, String str2, String str3, String str4, a aVar) {
            this.f9180a = str;
            this.f9181b = str2;
            this.f9182c = str3;
            this.f9183d = str4;
        }
    }

    public static class c extends w {

        /* renamed from: g  reason: collision with root package name */
        public final Set f9184g = new HashSet();

        public c(m mVar, c cVar) {
            super(mVar, cVar, (String) null, "get", bt.ae, (a) null);
            for (String add : s3.a.b(cVar.e())) {
                this.f9184g.add(add);
            }
        }

        public String c(j jVar, String str) {
            if (this.f9184g.contains(str)) {
                return str;
            }
            return w.super.c(jVar, str);
        }
    }

    public w(m mVar, c cVar, String str, String str2, String str3, a aVar) {
        this.f9174a = mVar;
        this.f9175b = cVar;
        this.f9176c = mVar.D(q.USE_STD_BEAN_NAMING);
        this.f9179f = str;
        this.f9177d = str2;
        this.f9178e = str3;
    }

    public String a(j jVar, String str) {
        if (this.f9178e == null) {
            return null;
        }
        Class<Boolean> e10 = jVar.e();
        if ((e10 != Boolean.class && e10 != Boolean.TYPE) || !str.startsWith(this.f9178e)) {
            return null;
        }
        if (this.f9176c) {
            return h(str, 2);
        }
        return g(str, 2);
    }

    public String b(j jVar, String str) {
        String str2 = this.f9179f;
        if (str2 == null || !str.startsWith(str2)) {
            return null;
        }
        if (this.f9176c) {
            return h(str, this.f9179f.length());
        }
        return g(str, this.f9179f.length());
    }

    public String c(j jVar, String str) {
        String str2 = this.f9177d;
        if (str2 == null || !str.startsWith(str2)) {
            return null;
        }
        if ("getCallbacks".equals(str)) {
            if (e(jVar)) {
                return null;
            }
        } else if ("getMetaClass".equals(str) && f(jVar)) {
            return null;
        }
        if (this.f9176c) {
            return h(str, this.f9177d.length());
        }
        return g(str, this.f9177d.length());
    }

    public String d(g gVar, String str) {
        return str;
    }

    public boolean e(j jVar) {
        Class e10 = jVar.e();
        if (!e10.isArray()) {
            return false;
        }
        String name = e10.getComponentType().getName();
        if (!name.contains(".cglib")) {
            return false;
        }
        if (name.startsWith("net.sf.cglib") || name.startsWith("org.hibernate.repackage.cglib") || name.startsWith("org.springframework.cglib")) {
            return true;
        }
        return false;
    }

    public boolean f(j jVar) {
        return jVar.e().getName().startsWith("groovy.lang");
    }

    public String g(String str, int i10) {
        int length = str.length();
        if (length == i10) {
            return null;
        }
        char charAt = str.charAt(i10);
        char lowerCase = Character.toLowerCase(charAt);
        if (charAt == lowerCase) {
            return str.substring(i10);
        }
        StringBuilder sb = new StringBuilder(length - i10);
        sb.append(lowerCase);
        while (true) {
            i10++;
            if (i10 >= length) {
                break;
            }
            char charAt2 = str.charAt(i10);
            char lowerCase2 = Character.toLowerCase(charAt2);
            if (charAt2 == lowerCase2) {
                sb.append(str, i10, length);
                break;
            }
            sb.append(lowerCase2);
        }
        return sb.toString();
    }

    public String h(String str, int i10) {
        int length = str.length();
        if (length == i10) {
            return null;
        }
        char charAt = str.charAt(i10);
        char lowerCase = Character.toLowerCase(charAt);
        if (charAt == lowerCase) {
            return str.substring(i10);
        }
        int i11 = i10 + 1;
        if (i11 < length && Character.isUpperCase(str.charAt(i11))) {
            return str.substring(i10);
        }
        StringBuilder sb = new StringBuilder(length - i10);
        sb.append(lowerCase);
        sb.append(str, i11, length);
        return sb.toString();
    }
}
