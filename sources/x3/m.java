package x3;

import c4.o;
import k3.e;
import k3.j;
import w3.c;

public class m extends k {

    /* renamed from: d  reason: collision with root package name */
    public final String f9692d;

    /* renamed from: e  reason: collision with root package name */
    public final String f9693e;

    public m(j jVar, o oVar, c cVar) {
        super(jVar, oVar, cVar);
        String name = jVar.q().getName();
        int lastIndexOf = name.lastIndexOf(46);
        if (lastIndexOf < 0) {
            this.f9692d = "";
            this.f9693e = ".";
            return;
        }
        this.f9693e = name.substring(0, lastIndexOf + 1);
        this.f9692d = name.substring(0, lastIndexOf);
    }

    public static m j(j jVar, m3.m mVar, c cVar) {
        return new m(jVar, mVar.z(), cVar);
    }

    public String a(Object obj) {
        String name = obj.getClass().getName();
        if (name.startsWith(this.f9693e)) {
            return name.substring(this.f9693e.length() - 1);
        }
        return name;
    }

    public j h(String str, e eVar) {
        if (str.startsWith(".")) {
            StringBuilder sb = new StringBuilder(str.length() + this.f9692d.length());
            if (this.f9692d.isEmpty()) {
                sb.append(str.substring(1));
            } else {
                sb.append(this.f9692d);
                sb.append(str);
            }
            str = sb.toString();
        }
        return super.h(str, eVar);
    }
}
