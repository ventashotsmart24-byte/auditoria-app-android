package a3;

import ba.g;
import s9.l;
import t9.i;
import t9.j;

public abstract class e {

    public static final class a extends j implements l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f163a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(String str) {
            super(1);
            this.f163a = str;
        }

        /* renamed from: b */
        public final CharSequence invoke(g gVar) {
            i.g(gVar, "matchResult");
            return ((String) gVar.a().get(1)) + this.f163a + ((String) gVar.a().get(3));
        }
    }

    public static final String a(String str, String str2) {
        boolean z10;
        i.g(str2, "domainKey");
        String h10 = t2.a.f9350a.h(str2);
        boolean z11 = true;
        if (h10.length() > 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10) {
            return str;
        }
        if (!(str == null || str.length() == 0)) {
            z11 = false;
        }
        if (!z11) {
            return new ba.i("^(https?://)([^/]+)(.*)").d(str, new a(h10));
        }
        return str;
    }
}
