package k8;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import t9.i;
import x8.a;

public final class a extends x8.a {

    /* renamed from: l  reason: collision with root package name */
    public final String f18216l;

    /* renamed from: m  reason: collision with root package name */
    public Gson f18217m = new Gson();

    /* renamed from: n  reason: collision with root package name */
    public Gson f18218n = new GsonBuilder().setPrettyPrinting().create();

    public a(int i10) {
        super(i10);
        String simpleName = a.class.getSimpleName();
        i.c(simpleName, "javaClass.simpleName");
        this.f18216l = simpleName;
    }

    public a.m p(a.k kVar) {
        return u(kVar);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v10, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final x8.a.m u(x8.a.k r4) {
        /*
            r3 = this;
            x8.a$l r0 = x8.a.l.GET
            r1 = 0
            if (r4 == 0) goto L_0x000a
            x8.a$l r2 = r4.getMethod()
            goto L_0x000b
        L_0x000a:
            r2 = r1
        L_0x000b:
            if (r0 != r2) goto L_0x0062
            java.lang.String r0 = r4.a()
            java.lang.String r2 = "/playinfo"
            boolean r0 = t9.i.b(r2, r0)
            if (r0 == 0) goto L_0x0062
            java.util.Map r4 = r4.getParameters()
            java.lang.String r0 = "instance"
            java.lang.Object r4 = r4.get(r0)
            java.util.List r4 = (java.util.List) r4
            if (r4 == 0) goto L_0x002f
            r0 = 0
            java.lang.Object r4 = r4.get(r0)
            r1 = r4
            java.lang.String r1 = (java.lang.String) r1
        L_0x002f:
            java.lang.String r4 = java.lang.String.valueOf(r1)
            int r4 = java.lang.Integer.parseInt(r4)
            l8.h$b r0 = l8.h.f7639m
            l8.h r0 = r0.a()
            java.lang.String r0 = r0.n(r4)
            com.google.gson.JsonParser r1 = new com.google.gson.JsonParser
            r1.<init>()
            com.google.gson.JsonElement r0 = r1.parse((java.lang.String) r0)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Request successfully:"
            r1.append(r2)
            r1.append(r4)
            java.lang.String r4 = r1.toString()
            r1 = 200(0xc8, float:2.8E-43)
            x8.a$m r4 = r3.v(r1, r0, r4)
            return r4
        L_0x0062:
            java.lang.String r4 = ""
            java.lang.String r0 = "Request not support!"
            r1 = 404(0x194, float:5.66E-43)
            x8.a$m r4 = r3.v(r1, r4, r0)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: k8.a.u(x8.a$k):x8.a$m");
    }

    public final a.m v(int i10, Object obj, String str) {
        a.m l10 = x8.a.l(this.f18218n.toJson((Object) new b(i10, obj, str)));
        i.c(l10, "newFixedLengthResponse(m…ttyGson.toJson(response))");
        return l10;
    }
}
