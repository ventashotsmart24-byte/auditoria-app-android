package s1;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.widget.ImageView;
import com.advertlib.bean.AdInfo;
import com.advertlib.bean.AdInfoWrapper;
import com.advertlib.bean.AdReportBean;
import com.advertlib.bean.AdReportBeanWrapper;
import com.advertlib.bean.AdReportRequest;
import com.advertlib.bean.AdvertBean;
import com.advertlib.bean.AdvertPosition;
import com.advertlib.bean.AdvertResult;
import com.advertlib.bean.ReportResult;
import com.advertlib.bean.TimeInfoBean;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.taobao.accs.utl.BaseMonitor;
import h9.t;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import okhttp3.Dns;
import okhttp3.Interceptor;
import s2.d;
import v1.c;

public final class m {

    /* renamed from: a  reason: collision with root package name */
    public static final m f9270a = new m();

    /* renamed from: b  reason: collision with root package name */
    public static final String f9271b = q.class.getSimpleName();

    /* renamed from: c  reason: collision with root package name */
    public static TimeInfoBean f9272c;

    /* renamed from: d  reason: collision with root package name */
    public static TimeInfoBean f9273d;

    /* renamed from: e  reason: collision with root package name */
    public static final long f9274e = 15;

    /* renamed from: f  reason: collision with root package name */
    public static Disposable f9275f;

    /* renamed from: g  reason: collision with root package name */
    public static v1.c f9276g = new v1.d();

    /* renamed from: h  reason: collision with root package name */
    public static v1.e f9277h = new v1.e();

    /* renamed from: i  reason: collision with root package name */
    public static final String f9278i = "ad_exist_status";

    /* renamed from: j  reason: collision with root package name */
    public static final String f9279j = "apk_booting";

    /* renamed from: k  reason: collision with root package name */
    public static final ScheduledThreadPoolExecutor f9280k = s2.d.c();

    /* renamed from: l  reason: collision with root package name */
    public static HashMap f9281l = new HashMap();

    /* renamed from: m  reason: collision with root package name */
    public static final ArrayList f9282m = new ArrayList();

    /* renamed from: n  reason: collision with root package name */
    public static Handler f9283n = new Handler(Looper.getMainLooper());

    /* renamed from: o  reason: collision with root package name */
    public static String f9284o;

    /* renamed from: p  reason: collision with root package name */
    public static String f9285p;

    /* renamed from: q  reason: collision with root package name */
    public static Dns f9286q;

    /* renamed from: r  reason: collision with root package name */
    public static Interceptor f9287r;

    /* renamed from: s  reason: collision with root package name */
    public static HashMap f9288s = new HashMap();

    /* renamed from: t  reason: collision with root package name */
    public static HashMap f9289t = new HashMap();

    /* renamed from: u  reason: collision with root package name */
    public static f f9290u = new f();

    /* renamed from: v  reason: collision with root package name */
    public static final h9.g f9291v = h9.h.b(e.f9297a);

    /* renamed from: w  reason: collision with root package name */
    public static final h9.g f9292w = h9.h.b(a.f9294a);

    /* renamed from: x  reason: collision with root package name */
    public static AdvertResult f9293x;

    public static final class a extends t9.j implements s9.a {

        /* renamed from: a  reason: collision with root package name */
        public static final a f9294a = new a();

        public a() {
            super(0);
        }

        /* renamed from: b */
        public final x1.d invoke() {
            m mVar = m.f9270a;
            return new x1.d(mVar.L(), mVar.N());
        }
    }

    public static final class b extends t9.j implements s9.l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ v1.f f9295a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(v1.f fVar) {
            super(1);
            this.f9295a = fVar;
        }

        public final void b(AdInfoWrapper adInfoWrapper) {
            this.f9295a.a(adInfoWrapper);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            b((AdInfoWrapper) obj);
            return t.f17319a;
        }
    }

    public static final class c extends t9.j implements s9.l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ v1.f f9296a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(v1.f fVar) {
            super(1);
            this.f9296a = fVar;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Throwable) obj);
            return t.f17319a;
        }

        public final void invoke(Throwable th) {
            th.printStackTrace();
            this.f9296a.a(new AdInfoWrapper((AdInfo) null, ""));
        }
    }

    public static final class d extends TypeToken<List<AdInfo>> {
    }

    public static final class e extends t9.j implements s9.a {

        /* renamed from: a  reason: collision with root package name */
        public static final e f9297a = new e();

        public e() {
            super(0);
        }

        /* renamed from: b */
        public final HashMap invoke() {
            HashMap hashMap = new HashMap();
            hashMap.put("picture", new w1.c());
            hashMap.put("video", new w1.f(m.f9270a.G()));
            return hashMap;
        }
    }

    public static final class f implements v1.a {
        public void a(String str) {
            t9.i.g(str, "mediaType");
            m.f9288s.put(str, Boolean.TRUE);
            ArrayList<v1.a> arrayList = (ArrayList) m.f9289t.remove(str);
            if (arrayList != null) {
                for (v1.a a10 : arrayList) {
                    a10.a(str);
                }
            }
            if (arrayList != null) {
                arrayList.clear();
            }
        }
    }

    public static final class g extends t9.j implements s9.l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ List f9298a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(List list) {
            super(1);
            this.f9298a = list;
        }

        public final void b(ReportResult reportResult) {
            q.f9311a.d(this.f9298a);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            b((ReportResult) obj);
            return t.f17319a;
        }
    }

    public static final class h extends t9.j implements s9.l {

        /* renamed from: a  reason: collision with root package name */
        public static final h f9299a = new h();

        public h() {
            super(1);
        }

        public final void invoke(Throwable th) {
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Throwable) obj);
            return t.f17319a;
        }
    }

    public static final class i extends t9.j implements s9.l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f9300a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f9301b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ v1.b f9302c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public i(Context context, boolean z10, v1.b bVar) {
            super(1);
            this.f9300a = context;
            this.f9301b = z10;
            this.f9302c = bVar;
        }

        public static final void d(v1.b bVar) {
            if (bVar != null) {
                bVar.b(true);
            }
        }

        public final void c(AdvertResult advertResult) {
            boolean z10;
            m.f9293x = advertResult;
            y1.e.f9866a.c(this.f9300a, m.f9279j, "");
            HashMap hashMap = new HashMap();
            List<AdvertPosition> ad_positions = advertResult.getAd_positions();
            if (ad_positions != null) {
                Context context = this.f9300a;
                boolean z11 = this.f9301b;
                for (AdvertPosition advertPosition : ad_positions) {
                    String ad_type = advertPosition.getAd_type();
                    boolean z12 = false;
                    if (ad_type == null || ad_type.length() == 0) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    if (!z10) {
                        List<AdInfo> ads = advertPosition.getAds();
                        if (ads != null && !ads.isEmpty()) {
                            z12 = true;
                        }
                        if (z12) {
                            String ad_type2 = advertPosition.getAd_type();
                            t9.i.d(ad_type2);
                            List<AdInfo> ads2 = advertPosition.getAds();
                            t9.i.d(ads2);
                            hashMap.put(ad_type2, ads2);
                            String ad_type3 = advertPosition.getAd_type();
                            if (t9.i.b(m.f9279j, ad_type3)) {
                                Gson gson = new Gson();
                                List<AdInfo> ads3 = advertPosition.getAds();
                                t9.i.d(ads3);
                                y1.e.f9866a.c(context, m.f9279j, gson.toJson((Object) ads3));
                            }
                            if (z11) {
                                m mVar = m.f9270a;
                                t9.i.d(ad_type3);
                                List<AdInfo> ads4 = advertPosition.getAds();
                                t9.i.d(ads4);
                                mVar.y(context, ad_type3, ads4);
                            }
                        }
                    }
                }
            }
            m.f9281l = hashMap;
            m.f9270a.P().post(new n(this.f9302c));
            if (!hashMap.isEmpty()) {
                Context context2 = this.f9300a;
                v1.b bVar = this.f9302c;
                for (Map.Entry entry : hashMap.entrySet()) {
                    for (AdInfo adInfo : (Iterable) entry.getValue()) {
                        w1.a aVar = (w1.a) m.f9270a.O().get(adInfo.getMedia_type());
                        if (aVar != null) {
                            aVar.a(context2, (String) entry.getKey(), adInfo, bVar);
                        }
                    }
                }
            }
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            c((AdvertResult) obj);
            return t.f17319a;
        }
    }

    public static final class j extends t9.j implements s9.l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f9303a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public j(Context context) {
            super(1);
            this.f9303a = context;
        }

        public final void b(AdvertResult advertResult) {
            long j10;
            long j11;
            m mVar = m.f9270a;
            mVar.M().a("picture");
            Long timestamp = advertResult.getTimestamp();
            if (timestamp != null) {
                j10 = timestamp.longValue();
            } else {
                j10 = System.currentTimeMillis();
            }
            m.f9272c = new TimeInfoBean(j10, SystemClock.elapsedRealtime());
            q.f9311a.c();
            Context applicationContext = this.f9303a.getApplicationContext();
            t9.i.f(applicationContext, "context.applicationContext");
            Integer reporting_interval = advertResult.getReporting_interval();
            if (reporting_interval != null) {
                j11 = (long) reporting_interval.intValue();
            } else {
                j11 = m.f9274e;
            }
            mVar.k0(applicationContext, j11);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            b((AdvertResult) obj);
            return t.f17319a;
        }
    }

    public static final class k extends t9.j implements s9.l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ v1.b f9304a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f9305b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public k(v1.b bVar, Context context) {
            super(1);
            this.f9304a = bVar;
            this.f9305b = context;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Throwable) obj);
            return t.f17319a;
        }

        public final void invoke(Throwable th) {
            v1.b bVar = this.f9304a;
            if (bVar != null) {
                bVar.b(false);
            }
            m.f9270a.U(this.f9305b);
        }
    }

    public static final class l extends t9.j implements s9.l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f9306a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public l(Context context) {
            super(1);
            this.f9306a = context;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Long) obj);
            return t.f17319a;
        }

        public final void invoke(Long l10) {
            m.f9270a.U(this.f9306a);
        }
    }

    static {
        Dns dns = Dns.SYSTEM;
        t9.i.f(dns, "SYSTEM");
        f9286q = dns;
    }

    public static /* synthetic */ void C(m mVar, Context context, String str, v1.f fVar, String str2, boolean z10, String str3, int i10, Object obj) {
        boolean z11;
        if ((i10 & 16) != 0) {
            z11 = false;
        } else {
            z11 = z10;
        }
        mVar.B(context, str, fVar, str2, z11, str3);
    }

    public static final void D(Context context, String str, String str2, boolean z10, String str3, ObservableEmitter observableEmitter) {
        boolean z11;
        File file;
        Context context2 = context;
        String str4 = str;
        ObservableEmitter observableEmitter2 = observableEmitter;
        t9.i.g(context, "$context");
        t9.i.g(str, "$adType");
        t9.i.g(str2, "$userIdentity");
        t9.i.g(str3, "$hasPay");
        t9.i.g(observableEmitter2, "it");
        y1.f fVar = y1.f.f9867a;
        List z12 = f9270a.z(str);
        TimeInfoBean timeInfoBean = f9272c;
        long j10 = 0;
        int i10 = 1;
        if (timeInfoBean != null) {
            j10 = TimeInfoBean.getCurrTime$default(timeInfoBean, 0, 1, (Object) null);
        }
        ArrayList c10 = fVar.c(context, str, z12, str2, j10, z10, str3);
        if (c10 == null || c10.isEmpty()) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            observableEmitter2.onNext(new AdInfoWrapper((AdInfo) null, ""));
            observableEmitter.onComplete();
            return;
        }
        int size = c10.size();
        if (1 <= size) {
            while (true) {
                AdInfo a10 = c.a.a(f9276g, str, c10, (String) null, 4, (Object) null);
                if (a10 != null) {
                    w1.a aVar = (w1.a) f9270a.O().get(a10.getMedia_type());
                    if (aVar != null) {
                        file = aVar.b(context, str, a10);
                    } else {
                        file = null;
                    }
                    if (file != null) {
                        String absolutePath = file.getAbsolutePath();
                        t9.i.f(absolutePath, "cacheFile.absolutePath");
                        observableEmitter2.onNext(new AdInfoWrapper(a10, absolutePath));
                        observableEmitter.onComplete();
                        return;
                    }
                }
                if (i10 == size) {
                    break;
                }
                i10++;
            }
        }
        observableEmitter2.onNext(new AdInfoWrapper((AdInfo) null, ""));
        observableEmitter.onComplete();
    }

    public static final void E(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void F(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static /* synthetic */ AdInfo J(m mVar, Context context, String str, String str2, String str3, boolean z10, String str4, int i10, Object obj) {
        boolean z11;
        if ((i10 & 8) != 0) {
            str3 = "picture";
        }
        String str5 = str3;
        if ((i10 & 16) != 0) {
            z11 = false;
        } else {
            z11 = z10;
        }
        return mVar.I(context, str, str2, str5, z11, str4);
    }

    public static /* synthetic */ void T(m mVar, v1.a aVar, String str, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str = "picture";
        }
        mVar.S(aVar, str);
    }

    public static final void V(Context context) {
        t9.i.g(context, "$context");
        List<AdReportBeanWrapper> f10 = q.f9311a.f(context);
        ArrayList arrayList = new ArrayList();
        if (f10 != null && !f10.isEmpty()) {
            ArrayList arrayList2 = new ArrayList();
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (AdReportBeanWrapper adReportBeanWrapper : f10) {
                arrayList.add(Integer.valueOf(adReportBeanWrapper.getId()));
                String str = "unknown";
                if (!t9.i.b(adReportBeanWrapper.getBean().getAd_id(), "0") || adReportBeanWrapper.getBean().getGame_stay_time() <= 0) {
                    String str2 = adReportBeanWrapper.getBean().getAd_id() + adReportBeanWrapper.getBean().getUser_name() + adReportBeanWrapper.getBean().getAd_type();
                    AdReportBean adReportBean = (AdReportBean) linkedHashMap.get(str2);
                    if (adReportBean == null) {
                        AdReportBean bean = adReportBeanWrapper.getBean();
                        String str3 = f9284o;
                        if (str3 == null) {
                            str3 = str;
                        }
                        bean.setSn(str3);
                        AdReportBean bean2 = adReportBeanWrapper.getBean();
                        String str4 = f9285p;
                        if (str4 != null) {
                            str = str4;
                        }
                        bean2.setUser_id(str);
                        AdReportBean bean3 = adReportBeanWrapper.getBean();
                        String packageName = context.getPackageName();
                        t9.i.f(packageName, "context.packageName");
                        bean3.setApp_id(packageName);
                        linkedHashMap.put(str2, adReportBeanWrapper.getBean());
                        arrayList2.add(adReportBeanWrapper.getBean());
                    } else {
                        adReportBean.setDisplay_times(adReportBean.getDisplay_times() + adReportBeanWrapper.getBean().getDisplay_times());
                        adReportBean.setClick_times(adReportBean.getClick_times() + adReportBeanWrapper.getBean().getClick_times());
                        if (adReportBeanWrapper.getBean().getLast_update_timestamp() > adReportBean.getLast_update_timestamp()) {
                            adReportBean.setLast_update_timestamp(adReportBeanWrapper.getBean().getLast_update_timestamp());
                        }
                    }
                } else {
                    AdReportBean bean4 = adReportBeanWrapper.getBean();
                    String str5 = f9284o;
                    if (str5 == null) {
                        str5 = str;
                    }
                    bean4.setSn(str5);
                    AdReportBean bean5 = adReportBeanWrapper.getBean();
                    String str6 = f9285p;
                    if (str6 != null) {
                        str = str6;
                    }
                    bean5.setUser_id(str);
                    AdReportBean bean6 = adReportBeanWrapper.getBean();
                    String packageName2 = context.getPackageName();
                    t9.i.f(packageName2, "context.packageName");
                    bean6.setApp_id(packageName2);
                    arrayList2.add(adReportBeanWrapper.getBean());
                }
            }
            f9270a.G().k(new AdReportRequest(arrayList2)).subscribeOn(Schedulers.io()).subscribe(new b(new g(arrayList)), new c(h.f9299a));
        }
    }

    public static final void W(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void X(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static /* synthetic */ void Z(m mVar, Context context, String str, String str2, Dns dns, v1.b bVar, String str3, boolean z10, Interceptor interceptor, int i10, Object obj) {
        String str4;
        boolean z11;
        Interceptor interceptor2;
        int i11 = i10;
        if ((i11 & 32) != 0) {
            str4 = "1.0";
        } else {
            str4 = str3;
        }
        if ((i11 & 64) != 0) {
            z11 = false;
        } else {
            z11 = z10;
        }
        if ((i11 & 128) != 0) {
            interceptor2 = null;
        } else {
            interceptor2 = interceptor;
        }
        mVar.Y(context, str, str2, dns, bVar, str4, z11, interceptor2);
    }

    public static final void a0(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void b0(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void c0(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static /* synthetic */ void h0(m mVar, Context context, ImageView imageView, String str, AdInfo adInfo, Integer num, s9.l lVar, Integer num2, boolean z10, int i10, int i11, Object obj) {
        Integer num3;
        s9.l lVar2;
        Integer num4;
        boolean z11;
        int i12;
        int i13 = i11;
        if ((i13 & 16) != 0) {
            num3 = null;
        } else {
            num3 = num;
        }
        if ((i13 & 32) != 0) {
            lVar2 = null;
        } else {
            lVar2 = lVar;
        }
        if ((i13 & 64) != 0) {
            num4 = null;
        } else {
            num4 = num2;
        }
        if ((i13 & 128) != 0) {
            z11 = false;
        } else {
            z11 = z10;
        }
        if ((i13 & 256) != 0) {
            i12 = -1;
        } else {
            i12 = i10;
        }
        mVar.g0(context, imageView, str, adInfo, num3, lVar2, num4, z11, i12);
    }

    public static final void i0(Context context, String str, AdInfo adInfo, ImageView imageView, Integer num, s9.l lVar, Integer num2, boolean z10, int i10) {
        File file;
        Context context2 = context;
        String str2 = str;
        t9.i.g(context, "$context");
        t9.i.g(str, "$adType");
        ImageView imageView2 = imageView;
        t9.i.g(imageView, "$iv");
        w1.a aVar = (w1.a) f9270a.O().get("picture");
        AdInfo adInfo2 = adInfo;
        if (aVar != null) {
            file = aVar.b(context, str, adInfo);
        } else {
            file = null;
        }
        f9283n.post(new g(context, imageView, adInfo, file, num, lVar, num2, z10, i10));
    }

    public static final void j0(Context context, ImageView imageView, AdInfo adInfo, File file, Integer num, s9.l lVar, Integer num2, boolean z10, int i10) {
        Context context2 = context;
        t9.i.g(context, "$context");
        ImageView imageView2 = imageView;
        t9.i.g(imageView, "$iv");
        r1.a aVar = r1.a.f8975a;
        String url = adInfo.getUrl();
        if (url == null) {
            url = "";
        }
        aVar.h(context, imageView, url, file, num, lVar, num2, z10, i10);
    }

    public static final void l0(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public final List A(Context context, String str, String str2, boolean z10, String str3) {
        long j10;
        t9.i.g(context, com.umeng.analytics.pro.f.X);
        t9.i.g(str2, "userIdentity");
        t9.i.g(str3, "hasPay");
        if (str == null) {
            return null;
        }
        y1.f fVar = y1.f.f9867a;
        List list = (List) f9281l.get(str);
        TimeInfoBean timeInfoBean = f9272c;
        if (timeInfoBean != null) {
            j10 = TimeInfoBean.getCurrTime$default(timeInfoBean, 0, 1, (Object) null);
        } else {
            j10 = 0;
        }
        return fVar.c(context, str, list, str2, j10, z10, str3);
    }

    public final void B(Context context, String str, v1.f fVar, String str2, boolean z10, String str3) {
        t9.i.g(context, com.umeng.analytics.pro.f.X);
        t9.i.g(str, "adType");
        t9.i.g(fVar, "callback");
        t9.i.g(str2, "userIdentity");
        t9.i.g(str3, "hasPay");
        Observable.create(new i(context, str, str2, z10, str3)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new j(new b(fVar)), new k(new c(fVar)));
    }

    public final x1.d G() {
        return (x1.d) f9292w.getValue();
    }

    public final AdInfo H(Context context, String str, String str2, String str3, boolean z10, String str4) {
        boolean z11;
        String str5 = str;
        Context context2 = context;
        t9.i.g(context, com.umeng.analytics.pro.f.X);
        t9.i.g(str, "adType");
        String str6 = str2;
        t9.i.g(str2, "mediaType");
        t9.i.g(str3, "userIdentity");
        t9.i.g(str4, "hasPay");
        List list = (List) f9281l.get(str);
        if (list == null || list.isEmpty()) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            return null;
        }
        v1.e eVar = f9277h;
        TimeInfoBean timeInfoBean = f9272c;
        long j10 = 0;
        if (timeInfoBean != null) {
            j10 = TimeInfoBean.getCurrTime$default(timeInfoBean, 0, 1, (Object) null);
        }
        return eVar.a(context, str, list, str2, str3, j10, z10, str4);
    }

    public final AdInfo I(Context context, String str, String str2, String str3, boolean z10, String str4) {
        boolean z11;
        long j10;
        String str5 = str;
        String str6 = str3;
        t9.i.g(context, com.umeng.analytics.pro.f.X);
        t9.i.g(str5, "adType");
        t9.i.g(str2, "userIdentity");
        t9.i.g(str6, "mediaType");
        t9.i.g(str4, "hasPay");
        List<AdInfo> list = (List) f9281l.get(str5);
        if (list == null || list.isEmpty()) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            return null;
        }
        for (AdInfo adInfo : list) {
            if (t9.i.b(adInfo.getMedia_type(), str6)) {
                y1.f fVar = y1.f.f9867a;
                TimeInfoBean timeInfoBean = f9272c;
                if (timeInfoBean != null) {
                    j10 = TimeInfoBean.getCurrTime$default(timeInfoBean, 0, 1, (Object) null);
                } else {
                    j10 = 0;
                }
                AdInfo a10 = fVar.a(context, str, adInfo, str2, j10, z10, str4);
                if (a10 != null) {
                    return a10;
                }
            }
        }
        return null;
    }

    public final AdInfo K(Context context, String str) {
        boolean z10;
        List list;
        t9.i.g(context, com.umeng.analytics.pro.f.X);
        y1.e eVar = y1.e.f9866a;
        String str2 = f9279j;
        String str3 = (String) eVar.a(context, str2, "");
        if (str3.length() > 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10 || (list = (List) new Gson().fromJson(str3, new d().getType())) == null || list.isEmpty()) {
            return null;
        }
        return f9276g.a(str2, list, str);
    }

    public final Dns L() {
        return f9286q;
    }

    public final v1.a M() {
        return f9290u;
    }

    public final Interceptor N() {
        return f9287r;
    }

    public final HashMap O() {
        return (HashMap) f9291v.getValue();
    }

    public final Handler P() {
        return f9283n;
    }

    public final ScheduledThreadPoolExecutor Q() {
        return f9280k;
    }

    public final TimeInfoBean R() {
        TimeInfoBean timeInfoBean = f9272c;
        if (timeInfoBean != null) {
            return timeInfoBean;
        }
        return f9273d;
    }

    public final void S(v1.a aVar, String str) {
        t9.i.g(aVar, "callback");
        t9.i.g(str, "mediaType");
        if (t9.i.b(f9288s.get(str), Boolean.TRUE)) {
            aVar.a(str);
            return;
        }
        ArrayList arrayList = (ArrayList) f9289t.get(str);
        if (arrayList == null) {
            arrayList = new ArrayList();
            f9289t.put(str, arrayList);
        }
        arrayList.add(aVar);
    }

    public final void U(Context context) {
        f9280k.execute(new d.e("report ad", (Runnable) new h(context), false));
    }

    public final void Y(Context context, String str, String str2, Dns dns, v1.b bVar, String str3, boolean z10, Interceptor interceptor) {
        String str4;
        Context context2 = context;
        Dns dns2 = dns;
        v1.b bVar2 = bVar;
        t9.i.g(context, com.umeng.analytics.pro.f.X);
        t9.i.g(dns2, BaseMonitor.COUNT_POINT_DNS);
        t9.i.g(str3, "ad_version");
        String str5 = Build.VERSION.RELEASE;
        t9.i.f(str5, "RELEASE");
        if (str == null) {
            str4 = "";
        } else {
            str4 = str;
        }
        String language = Locale.getDefault().getLanguage();
        t9.i.f(language, "getDefault().language");
        String packageName = context.getPackageName();
        t9.i.f(packageName, "context.packageName");
        AdvertBean advertBean = new AdvertBean("android", str5, str3, str4, language, "jpg/png/bmp", "mp4/rmvb/flv", packageName, String.valueOf(y1.f.f9867a.b(context)));
        f9284o = str;
        f9285p = str2;
        f9286q = dns2;
        f9287r = interceptor;
        G().g(advertBean).subscribeOn(Schedulers.io()).doOnNext(new d(new i(context, z10, bVar2))).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new j(context)), new f(new k(bVar2, context)));
    }

    public final void d0(Context context, String str, String str2) {
        t9.i.g(context, com.umeng.analytics.pro.f.X);
        t9.i.g(str, "ad_type");
        t9.i.g(str2, "ad_id");
        y1.e eVar = y1.e.f9866a;
        TimeInfoBean timeInfoBean = f9272c;
        long j10 = 0;
        if (timeInfoBean != null) {
            j10 = TimeInfoBean.getCurrTime$default(timeInfoBean, 0, 1, (Object) null);
        }
        eVar.d(context, str, str2, Long.valueOf(j10));
    }

    public final void e0(String str, String str2) {
        f9284o = str;
        f9285p = str2;
    }

    public final void f0(Long l10) {
        if (l10 != null) {
            f9273d = new TimeInfoBean(l10.longValue(), SystemClock.elapsedRealtime());
            q.f9311a.c();
        }
    }

    public final void g0(Context context, ImageView imageView, String str, AdInfo adInfo, Integer num, s9.l lVar, Integer num2, boolean z10, int i10) {
        Context context2 = context;
        t9.i.g(context, com.umeng.analytics.pro.f.X);
        ImageView imageView2 = imageView;
        t9.i.g(imageView, "iv");
        String str2 = str;
        t9.i.g(str, "adType");
        if (adInfo != null && !r1.a.f8975a.b(context)) {
            s2.d.b("showAdGetCache", new a(context, str, adInfo, imageView, num, lVar, num2, z10, i10), false);
        }
    }

    public final void k0(Context context, long j10) {
        boolean z10;
        Disposable disposable;
        Disposable disposable2 = f9275f;
        if (disposable2 != null) {
            z10 = disposable2.isDisposed();
        } else {
            z10 = true;
        }
        if (!z10 && (disposable = f9275f) != null) {
            disposable.dispose();
        }
        f9275f = Observable.interval(0, j10, TimeUnit.MINUTES).subscribe(new l(new l(context)));
    }

    public final void y(Context context, String str, List list) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(str, 0);
        if (!sharedPreferences.getAll().isEmpty()) {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            Map<String, ?> all = sharedPreferences.getAll();
            t9.i.f(all, "sp.all");
            for (Map.Entry next : all.entrySet()) {
                Iterator it = list.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (t9.i.b(next.getKey(), ((AdInfo) it.next()).getAd_id())) {
                            break;
                        }
                    } else {
                        edit.remove((String) next.getKey());
                        break;
                    }
                }
            }
            edit.apply();
        }
    }

    public final List z(String str) {
        if (str == null) {
            return null;
        }
        return (List) f9281l.get(str);
    }
}
