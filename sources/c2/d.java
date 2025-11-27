package c2;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bigbee.bean.request.AppBean;
import com.bigbee.db.EventDbModel;
import com.google.firebase.dynamiclinks.DynamicLink;
import com.taobao.accs.common.Constants;
import h9.t;
import i2.d;
import i2.e;
import i2.h;
import io.reactivex.Observable;
import java.util.HashMap;
import s9.l;
import t9.i;
import t9.j;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static final d f4594a = new d();

    /* renamed from: b  reason: collision with root package name */
    public static final String f4595b = d.class.getSimpleName();

    /* renamed from: c  reason: collision with root package name */
    public static AppBean f4596c;

    /* renamed from: d  reason: collision with root package name */
    public static String f4597d = "";

    /* renamed from: e  reason: collision with root package name */
    public static HashMap f4598e = new HashMap();

    public static final class a implements d.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f4599a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ HashMap f4600b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f4601c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f4602d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f4603e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f4604f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ long f4605g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ long f4606h;

        public a(String str, HashMap hashMap, int i10, String str2, boolean z10, String str3, long j10, long j11) {
            this.f4599a = str;
            this.f4600b = hashMap;
            this.f4601c = i10;
            this.f4602d = str2;
            this.f4603e = z10;
            this.f4604f = str3;
            this.f4605g = j10;
            this.f4606h = j11;
        }

        public void a() {
            String str;
            if (!TextUtils.isEmpty(this.f4599a)) {
                str = this.f4599a;
            } else {
                str = l.f4666a.b().getUserName();
            }
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = this.f4600b;
            if (hashMap2 != null && hashMap2.size() > 0) {
                hashMap = this.f4600b;
            }
            HashMap hashMap3 = hashMap;
            hashMap3.put("httpStatus", Integer.valueOf(this.f4601c));
            hashMap3.put("uri", this.f4602d);
            if (this.f4603e) {
                hashMap3.put("domain|DES", this.f4604f);
            } else {
                hashMap3.put("domain", this.f4604f);
            }
            if (!TextUtils.isEmpty(str) || !TextUtils.isEmpty(l.f4666a.b().getUserName())) {
                if (str == null && (str = l.f4666a.b().getUserName()) == null) {
                    str = "";
                }
                hashMap3.put("uname", str);
            }
            h hVar = h.f7019a;
            long a10 = hVar.a();
            long j10 = this.f4605g;
            i2.a aVar = i2.a.f6993a;
            long g10 = (this.f4606h - aVar.g()) + hVar.a();
            i.f4633q.a().w(e.d(e.f4622a, "app_api", hashMap3, (j10 - aVar.g()) + a10, g10, false, 16, (Object) null));
        }
    }

    public static final class b implements d.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f4607a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f4608b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f4609c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f4610d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f4611e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f4612f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f4613g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f4614h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f4615i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ String f4616j;

        /* renamed from: k  reason: collision with root package name */
        public final /* synthetic */ String f4617k;

        /* renamed from: l  reason: collision with root package name */
        public final /* synthetic */ String f4618l;

        /* renamed from: m  reason: collision with root package name */
        public final /* synthetic */ HashMap f4619m;

        public b(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, HashMap hashMap) {
            this.f4607a = str;
            this.f4608b = str2;
            this.f4609c = str3;
            this.f4610d = str4;
            this.f4611e = str5;
            this.f4612f = str6;
            this.f4613g = str7;
            this.f4614h = str8;
            this.f4615i = str9;
            this.f4616j = str10;
            this.f4617k = str11;
            this.f4618l = str12;
            this.f4619m = hashMap;
        }

        public void a() {
            long a10 = h.f7019a.a() + (SystemClock.elapsedRealtime() - i2.a.f6993a.g());
            HashMap hashMap = new HashMap();
            l lVar = l.f4666a;
            String str = "";
            if (!TextUtils.isEmpty(lVar.b().getUserName())) {
                String userName = lVar.b().getUserName();
                if (userName == null) {
                    userName = str;
                }
                hashMap.put("uname", userName);
            }
            hashMap.put("mCode", this.f4607a);
            hashMap.put("cdnType", this.f4608b);
            hashMap.put("bussType", this.f4609c);
            hashMap.put("eCode", this.f4610d);
            String str2 = this.f4611e;
            if (str2 == null) {
                str2 = str;
            }
            hashMap.put("castMode", str2);
            String str3 = this.f4612f;
            if (str3 == null) {
                str3 = str;
            }
            hashMap.put("castDevice", str3);
            hashMap.put("title", this.f4613g);
            hashMap.put(Constants.KEY_HOST, this.f4614h);
            String str4 = this.f4615i;
            if (str4 == null) {
                str4 = str;
            }
            hashMap.put("transId", str4);
            String str5 = this.f4616j;
            if (str5 == null) {
                str5 = str;
            }
            hashMap.put(Constants.KEY_MODE, str5);
            String str6 = this.f4617k;
            if (str6 == null) {
                str6 = str;
            }
            hashMap.put("p2pErr", str6);
            String str7 = this.f4618l;
            if (str7 != null) {
                str = str7;
            }
            hashMap.put("p2pMode", str);
            HashMap hashMap2 = this.f4619m;
            if (hashMap2 != null) {
                for (String str8 : hashMap2.keySet()) {
                    if (!(str8 == null || this.f4619m.get(str8) == null)) {
                        hashMap.put(str8, String.valueOf(this.f4619m.get(str8)));
                    }
                }
            }
            i.f4633q.a().w(e.d(e.f4622a, "app_play_error", hashMap, a10, a10, false, 16, (Object) null));
        }
    }

    public static final class c extends j implements l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ long f4620a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(long j10) {
            super(1);
            this.f4620a = j10;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((String) obj);
            return t.f17319a;
        }

        public final void invoke(String str) {
            e.f7014b.a().c("server_time", Long.valueOf(h.f7019a.a()));
            d.f4594a.k(this.f4620a);
        }
    }

    /* renamed from: c2.d$d  reason: collision with other inner class name */
    public static final class C0069d extends j implements l {

        /* renamed from: a  reason: collision with root package name */
        public static final C0069d f4621a = new C0069d();

        public C0069d() {
            super(1);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Throwable) obj);
            return t.f17319a;
        }

        public final void invoke(Throwable th) {
            th.printStackTrace();
        }
    }

    public static /* synthetic */ void e(d dVar, long j10, long j11, String str, String str2, int i10, String str3, HashMap hashMap, boolean z10, int i11, Object obj) {
        String str4;
        HashMap hashMap2;
        if ((i11 & 32) != 0) {
            str4 = "";
        } else {
            str4 = str3;
        }
        if ((i11 & 64) != 0) {
            hashMap2 = null;
        } else {
            hashMap2 = hashMap;
        }
        dVar.d(j10, j11, str, str2, i10, str4, hashMap2, z10);
    }

    public static /* synthetic */ void l(d dVar, long j10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            j10 = 0;
        }
        dVar.k(j10);
    }

    public static final void n(l lVar, Object obj) {
        i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void o(l lVar, Object obj) {
        i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static /* synthetic */ void r(d dVar, boolean z10, boolean z11, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z11 = true;
        }
        dVar.q(z10, z11);
    }

    public final EventDbModel c(boolean z10) {
        String str;
        long j10;
        long j11;
        String str2;
        AppBean appBean = f4596c;
        if (appBean != null) {
            str = appBean.getTag();
        } else {
            str = null;
        }
        String str3 = "";
        if (!TextUtils.isEmpty(str)) {
            HashMap hashMap = f4598e;
            AppBean appBean2 = f4596c;
            if (appBean2 == null || (str2 = appBean2.getTag()) == null) {
                str2 = str3;
            }
            hashMap.put("tag", str2);
        }
        l lVar = l.f4666a;
        if (!TextUtils.isEmpty(lVar.b().getUserName())) {
            HashMap hashMap2 = f4598e;
            String userName = lVar.b().getUserName();
            if (userName != null) {
                str3 = userName;
            }
            hashMap2.put("uname", str3);
        }
        e eVar = e.f4622a;
        HashMap hashMap3 = f4598e;
        AppBean appBean3 = f4596c;
        if (appBean3 != null) {
            j10 = appBean3.getSt();
        } else {
            j10 = 0;
        }
        AppBean appBean4 = f4596c;
        if (appBean4 != null) {
            j11 = appBean4.getEt();
        } else {
            j11 = 0;
        }
        return eVar.c("app", hashMap3, j10, j11, z10);
    }

    public final void d(long j10, long j11, String str, String str2, int i10, String str3, HashMap hashMap, boolean z10) {
        i.g(str, "uri");
        i.g(str2, "domain");
        if (i10 >= 0) {
            i2.d.f7007c.a().f(new a(str3, hashMap, i10, str, z10, str2, j10, j11));
        }
    }

    public final void f() {
        AppBean appBean = f4596c;
        if (appBean != null && appBean != null) {
            appBean.setEt(h.f7019a.a() + (SystemClock.elapsedRealtime() - i2.a.f6993a.g()));
        }
    }

    public final void g(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        String str9 = str;
        String str10 = str2;
        String str11 = str3;
        String str12 = str4;
        String str13 = str5;
        String str14 = str6;
        String str15 = str7;
        i.g(str9, "mCode");
        i.g(str10, "title");
        i.g(str11, Constants.KEY_HOST);
        i.g(str12, "bussType");
        i.g(str13, "cdnType");
        i.g(str14, "hCode");
        i.g(str15, "eCode");
        i.g(str8, "uri");
        HashMap hashMap = new HashMap();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        hashMap.put("mCode", str9);
        hashMap.put("cdnType", str13);
        hashMap.put("bussType", str12);
        hashMap.put("eCode", str15);
        hashMap.put("title", str10);
        hashMap.put(Constants.KEY_HOST, str11);
        hashMap.put("hCode", str14);
        HashMap hashMap2 = hashMap;
        hashMap2.put("uri", str8);
        e.f4622a.a("app_error_hint", hashMap2, elapsedRealtime, elapsedRealtime, false, true);
    }

    public final void h(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, HashMap hashMap) {
        boolean z10;
        i.g(str, "mCode");
        i.g(str2, Constants.KEY_HOST);
        i.g(str3, "bussType");
        i.g(str4, "cdnType");
        i.g(str5, "title");
        i.g(str6, "eCode");
        if (str6.length() > 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            i2.d.f7007c.a().f(new b(str, str4, str3, str6, str8, str9, str5, str2, str7, str10, str11, str12, hashMap));
        }
    }

    public final void i() {
        if (f4596c != null) {
            i.f4633q.a().G(c(false));
        }
        f4596c = null;
    }

    public final void j(HashMap hashMap) {
        i.g(hashMap, DynamicLink.Builder.KEY_DYNAMIC_LINK_PARAMETERS);
        f4598e = hashMap;
    }

    public final void k(long j10) {
        if (f4596c == null) {
            if (j10 == 0) {
                j10 = h.f7019a.a() + (SystemClock.elapsedRealtime() - i2.a.f6993a.g());
            }
            long j11 = j10;
            l lVar = l.f4666a;
            f4596c = new AppBean(lVar.b().getAppVer(), lVar.b().getSysVer(), lVar.b().getUserId(), lVar.b().getUserName(), j11, ((long) 1000) + j11, f4597d);
            i.f4633q.a().G(c(true));
        }
    }

    public final void m(long j10) {
        Observable.just("ioSchedulers").compose(s2.c.b()).subscribe(new b(new c(j10)), new c(C0069d.f4621a));
    }

    public final void p(String str) {
        i.g(str, "reverseSign");
        f4597d = str;
    }

    public final void q(boolean z10, boolean z11) {
        long j10;
        long j11;
        if (f4596c != null) {
            long a10 = h.f7019a.a();
            long elapsedRealtime = SystemClock.elapsedRealtime();
            AppBean appBean = f4596c;
            long j12 = 0;
            if (appBean != null) {
                j10 = appBean.getEt();
            } else {
                j10 = 0;
            }
            i2.a aVar = i2.a.f6993a;
            if (aVar.g() < 1) {
                aVar.m(elapsedRealtime);
            } else {
                j10 = a10 + (elapsedRealtime - aVar.g());
            }
            AppBean appBean2 = f4596c;
            if (appBean2 != null) {
                if (appBean2 != null) {
                    j11 = appBean2.getSt();
                } else {
                    j11 = 0;
                }
                if (j10 < j11) {
                    long j13 = (long) 60000;
                    AppBean appBean3 = f4596c;
                    if (appBean3 != null) {
                        j12 = appBean3.getSt();
                    }
                    j10 = j13 + j12;
                }
                AppBean appBean4 = f4596c;
                if (appBean4 != null) {
                    appBean4.setEt(j10);
                }
                i.f4633q.a().G(c(z10));
                if (!z10) {
                    f4596c = null;
                }
            }
        }
    }
}
