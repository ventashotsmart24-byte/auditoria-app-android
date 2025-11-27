package z2;

import com.dcs.bean.DomainInfo;
import com.dcs.bean.V1Data;
import com.dcs.bean.V1Result;
import h9.h;
import h9.t;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import retrofit2.HttpException;
import s9.l;
import t9.i;
import t9.j;

public final class c {

    /* renamed from: d  reason: collision with root package name */
    public static final b f9923d = new b((t9.g) null);

    /* renamed from: e  reason: collision with root package name */
    public static final h9.g f9924e = h.b(a.f9928a);

    /* renamed from: a  reason: collision with root package name */
    public final String f9925a = c.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    public final h9.g f9926b = h.b(C0140c.f9929a);

    /* renamed from: c  reason: collision with root package name */
    public final h9.g f9927c = h.b(new d(this));

    public static final class a extends j implements s9.a {

        /* renamed from: a  reason: collision with root package name */
        public static final a f9928a = new a();

        public a() {
            super(0);
        }

        /* renamed from: b */
        public final c invoke() {
            return new c();
        }
    }

    public static final class b {
        public b() {
        }

        public /* synthetic */ b(t9.g gVar) {
            this();
        }

        public final c a() {
            return b();
        }

        public final c b() {
            return (c) c.f9924e.getValue();
        }
    }

    /* renamed from: z2.c$c  reason: collision with other inner class name */
    public static final class C0140c extends j implements s9.a {

        /* renamed from: a  reason: collision with root package name */
        public static final C0140c f9929a = new C0140c();

        public C0140c() {
            super(0);
        }

        /* renamed from: b */
        public final DomainInfo invoke() {
            return t2.a.f9350a.c();
        }
    }

    public static final class d extends j implements s9.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f9930a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(c cVar) {
            super(0);
            this.f9930a = cVar;
        }

        /* renamed from: b */
        public final x2.a invoke() {
            return new x2.a("https://" + this.f9930a.e().getFirst(), "https://" + this.f9930a.e().getSecond());
        }
    }

    public static final class e extends j implements l {

        /* renamed from: a  reason: collision with root package name */
        public static final e f9931a = new e();

        public e() {
            super(1);
        }

        public final void b(V1Result v1Result) {
            t2.a aVar = t2.a.f9350a;
            i.f(v1Result, "it");
            aVar.s(v1Result);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            b((V1Result) obj);
            return t.f17319a;
        }
    }

    public static final class f extends j implements l {

        /* renamed from: a  reason: collision with root package name */
        public static final f f9932a = new f();

        public f() {
            super(1);
        }

        /* renamed from: b */
        public final String invoke(V1Result v1Result) {
            i.g(v1Result, "it");
            String i10 = t2.a.f9350a.i();
            if (i10 == null) {
                return "";
            }
            return i10;
        }
    }

    public static final class g extends u2.a {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f9933b;

        public g(c cVar) {
            this.f9933b = cVar;
        }

        /* renamed from: d */
        public Observable a(Throwable th) {
            Observable observable;
            i.g(th, "it");
            if (th instanceof HttpException) {
                HttpException httpException = (HttpException) th;
                if (ba.t.o("304,500,404,400,506,401", String.valueOf(httpException.code()), false, 2, (Object) null)) {
                    if (httpException.code() == 304) {
                        String i10 = t2.a.f9350a.i();
                        if (i10 == null) {
                            i10 = "";
                        }
                        observable = Observable.just(i10);
                    } else {
                        observable = Observable.error(th);
                    }
                    i.f(observable, "{\n                    if…      }\n                }");
                    return observable;
                }
            }
            t2.a.f9350a.r(this.f9933b.e().getFirst(), this.f9933b.e().getSecond(), this.f9933b.e().getDomainType());
            Observable error = Observable.error(th);
            i.f(error, "{\n                    Do…ror(it)\n                }");
            return error;
        }
    }

    public static final void h(l lVar, Object obj) {
        i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final String i(l lVar, Object obj) {
        i.g(lVar, "$tmp0");
        return (String) lVar.invoke(obj);
    }

    public final DomainInfo e() {
        return (DomainInfo) this.f9926b.getValue();
    }

    public final x2.a f() {
        return (x2.a) this.f9927c.getValue();
    }

    public final Observable g(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i10, String str9, String str10) {
        String str11 = str;
        i.g(str11, "sn");
        String str12 = str2;
        i.g(str12, "authCode");
        String str13 = str3;
        i.g(str13, "authVersion");
        String str14 = str6;
        i.g(str14, "appId");
        String str15 = str7;
        i.g(str15, "spkgVer");
        String str16 = str8;
        i.g(str16, "reserve1");
        Observable observeOn = f().c(new V1Data("all", str11, str12, str13, str4, str5, str14, String.valueOf(a3.j.f171a.a()), str15, str16, i10, str9, str10)).doOnNext(new a(e.f9931a)).map(new b(f.f9932a)).onErrorResumeNext(new g(this)).observeOn(AndroidSchedulers.mainThread());
        i.f(observeOn, "fun v1(sn: String, authC…lers.mainThread())\n\n    }");
        return observeOn;
    }
}
