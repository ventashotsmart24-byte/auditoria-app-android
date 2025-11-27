package la;

import android.os.Build;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.taobao.accs.common.Constants;
import com.umeng.analytics.pro.bt;
import java.util.Map;
import java.util.Set;
import t9.j;

public final class c extends d {

    /* renamed from: b  reason: collision with root package name */
    public final h9.g f18845b = h9.h.b(a.f18854a);

    /* renamed from: c  reason: collision with root package name */
    public final h9.g f18846c = h9.h.b(i.f18862a);

    /* renamed from: d  reason: collision with root package name */
    public final h9.g f18847d = h9.h.b(b.f18855a);

    /* renamed from: e  reason: collision with root package name */
    public final h9.g f18848e = h9.h.b(e.f18858a);

    /* renamed from: f  reason: collision with root package name */
    public final h9.g f18849f = h9.h.b(f.f18859a);

    /* renamed from: g  reason: collision with root package name */
    public final h9.g f18850g = h9.h.b(g.f18860a);

    /* renamed from: h  reason: collision with root package name */
    public final h9.g f18851h = h9.h.b(C0273c.f18856a);

    /* renamed from: i  reason: collision with root package name */
    public final h9.g f18852i = h9.h.b(d.f18857a);

    /* renamed from: j  reason: collision with root package name */
    public final h9.g f18853j = h9.h.b(h.f18861a);

    public static final class a extends j implements s9.a {

        /* renamed from: a  reason: collision with root package name */
        public static final a f18854a = new a();

        public a() {
            super(0);
        }

        public final Integer invoke() {
            return Integer.valueOf(na.a.b());
        }
    }

    public static final class b extends j implements s9.a {

        /* renamed from: a  reason: collision with root package name */
        public static final b f18855a = new b();

        public b() {
            super(0);
        }

        public final String invoke() {
            return na.a.g();
        }
    }

    /* renamed from: la.c$c  reason: collision with other inner class name */
    public static final class C0273c extends j implements s9.a {

        /* renamed from: a  reason: collision with root package name */
        public static final C0273c f18856a = new C0273c();

        public C0273c() {
            super(0);
        }

        public final String invoke() {
            return Build.CPU_ABI;
        }
    }

    public static final class d extends j implements s9.a {

        /* renamed from: a  reason: collision with root package name */
        public static final d f18857a = new d();

        public d() {
            super(0);
        }

        public final String invoke() {
            return na.a.e();
        }
    }

    public static final class e extends j implements s9.a {

        /* renamed from: a  reason: collision with root package name */
        public static final e f18858a = new e();

        public e() {
            super(0);
        }

        public final String invoke() {
            return Build.HARDWARE;
        }
    }

    public static final class f extends j implements s9.a {

        /* renamed from: a  reason: collision with root package name */
        public static final f f18859a = new f();

        public f() {
            super(0);
        }

        public final String invoke() {
            return Build.MODEL;
        }
    }

    public static final class g extends j implements s9.a {

        /* renamed from: a  reason: collision with root package name */
        public static final g f18860a = new g();

        public g() {
            super(0);
        }

        public final String invoke() {
            return Build.PRODUCT;
        }
    }

    public static final class h extends j implements s9.a {

        /* renamed from: a  reason: collision with root package name */
        public static final h f18861a = new h();

        public h() {
            super(0);
        }

        public final String invoke() {
            return na.c.f19074b;
        }
    }

    public static final class i extends j implements s9.a {

        /* renamed from: a  reason: collision with root package name */
        public static final i f18862a = new i();

        public i() {
            super(0);
        }

        public final String invoke() {
            return Build.VERSION.RELEASE;
        }
    }

    public Iterable a() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("loginType", "3");
        jsonObject.addProperty("appLanguage", na.a.a());
        jsonObject.addProperty("apkVersion", String.valueOf(d()));
        jsonObject.addProperty("sysVersion", l());
        jsonObject.addProperty("appId", e());
        jsonObject.addProperty("hardwareInfo", h());
        jsonObject.addProperty(Constants.KEY_MODEL, i());
        jsonObject.addProperty("product", j());
        jsonObject.addProperty(bt.f13929w, f());
        jsonObject.addProperty("deviceToken", g());
        jsonObject.addProperty("reserve1", k());
        jsonObject.addProperty("sn", na.a.h());
        jsonObject.addProperty("drmId", na.a.d());
        Set<Map.Entry<String, JsonElement>> entrySet = jsonObject.entrySet();
        t9.i.f(entrySet, "newParams.entrySet()");
        return entrySet;
    }

    public boolean c() {
        return true;
    }

    public final int d() {
        return ((Number) this.f18845b.getValue()).intValue();
    }

    public final String e() {
        return (String) this.f18847d.getValue();
    }

    public final String f() {
        return (String) this.f18851h.getValue();
    }

    public final String g() {
        return (String) this.f18852i.getValue();
    }

    public final String h() {
        return (String) this.f18848e.getValue();
    }

    public final String i() {
        return (String) this.f18849f.getValue();
    }

    public final String j() {
        return (String) this.f18850g.getValue();
    }

    public final String k() {
        return (String) this.f18853j.getValue();
    }

    public final String l() {
        return (String) this.f18846c.getValue();
    }
}
