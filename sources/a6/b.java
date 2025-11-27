package a6;

import ba.t;
import w6.i;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final b f10666a = new b();

    public final String a(String str) {
        boolean z10;
        if (str == null || str.length() == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            return "";
        }
        if (t.o(str, "_Recommended", false, 2, (Object) null)) {
            return i.f9510g.v() + "_1";
        } else if (t.o(str, "_movies", false, 2, (Object) null)) {
            return i.f9510g.v() + "_2";
        } else if (t.o(str, "_series", false, 2, (Object) null)) {
            return i.f9510g.v() + "_3";
        } else if (t.o(str, "_kids", false, 2, (Object) null)) {
            return i.f9510g.v() + "_4";
        } else if (!t.o(str, "_animes", false, 2, (Object) null)) {
            return "";
        } else {
            return i.f9510g.v() + "_5";
        }
    }
}
