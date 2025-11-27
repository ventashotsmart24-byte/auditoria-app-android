package r5;

import android.content.Context;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.utils.d0;
import h9.k;
import h9.t;
import i9.n;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import mobile.com.requestframe.utils.response.CdnListBeanResult;
import mobile.com.requestframe.utils.response.CdnUrl;
import mobile.com.requestframe.utils.response.GetSlbInfoBeanResult;
import mobile.com.requestframe.utils.response.GetSlbInfoBeanResultData;
import org.json.JSONObject;
import s9.l;
import t9.j;
import w6.i;

public final class i {

    /* renamed from: a  reason: collision with root package name */
    public static final i f19378a = new i();

    /* renamed from: b  reason: collision with root package name */
    public static boolean f19379b;

    /* renamed from: c  reason: collision with root package name */
    public static long f19380c;

    /* renamed from: d  reason: collision with root package name */
    public static long f19381d = 1800;

    /* renamed from: e  reason: collision with root package name */
    public static Context f19382e;

    /* renamed from: f  reason: collision with root package name */
    public static GetSlbInfoBeanResultData f19383f;

    /* renamed from: g  reason: collision with root package name */
    public static androidx.collection.a f19384g = new androidx.collection.a();

    /* renamed from: h  reason: collision with root package name */
    public static androidx.collection.a f19385h = new androidx.collection.a();

    /* renamed from: i  reason: collision with root package name */
    public static HashMap f19386i = new HashMap();

    /* renamed from: j  reason: collision with root package name */
    public static Disposable f19387j;

    /* renamed from: k  reason: collision with root package name */
    public static boolean f19388k;

    /* renamed from: l  reason: collision with root package name */
    public static String f19389l = "";

    public static final class a extends j implements l {

        /* renamed from: a  reason: collision with root package name */
        public static final a f19390a = new a();

        public a() {
            super(1);
        }

        /* renamed from: b */
        public final ObservableSource invoke(Long l10) {
            boolean z10;
            t9.i.g(l10, "it");
            Context l11 = i.f19382e;
            String str = null;
            if (l11 != null) {
                String g10 = na.f.g(l11, "deviceTag");
                t9.i.f(g10, "deviceTag");
                if (g10.length() > 0) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (z10) {
                    str = new JSONObject().put("deviceTag", g10).toString();
                }
            }
            i.c cVar = w6.i.f9510g;
            w6.i b10 = cVar.b();
            return b10.R1(i9.j.c(cVar.v() + "_live"), str);
        }
    }

    public static final class b extends j implements l {

        /* renamed from: a  reason: collision with root package name */
        public static final b f19391a = new b();

        public b() {
            super(1);
        }

        public final void b(GetSlbInfoBeanResult getSlbInfoBeanResult) {
            i iVar = i.f19378a;
            b0.U(iVar, "fetch slb success and handle result");
            t9.i.f(getSlbInfoBeanResult, "it");
            iVar.C(getSlbInfoBeanResult);
            iVar.D(getSlbInfoBeanResult);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            b((GetSlbInfoBeanResult) obj);
            return t.f17319a;
        }
    }

    public static final class c extends j implements l {

        /* renamed from: a  reason: collision with root package name */
        public static final c f19392a = new c();

        public c() {
            super(1);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Throwable) obj);
            return t.f17319a;
        }

        /* JADX WARNING: Removed duplicated region for block: B:40:0x0073 A[Catch:{ Exception -> 0x0080 }] */
        /* JADX WARNING: Removed duplicated region for block: B:41:0x007c A[Catch:{ Exception -> 0x0080 }] */
        /* JADX WARNING: Removed duplicated region for block: B:46:0x008a  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void invoke(java.lang.Throwable r11) {
            /*
                r10 = this;
                r5.i r0 = r5.i.f19378a
                java.lang.String r1 = "fetch slb occur exception"
                com.mobile.brasiltv.utils.b0.U(r0, r1)
                r11.printStackTrace()
                r1 = 1
                r0.K(r1)
                boolean r2 = r11 instanceof retrofit2.HttpException     // Catch:{ Exception -> 0x0080 }
                java.lang.String r3 = ""
                java.lang.String r4 = "20900"
                java.lang.String r5 = "25500"
                if (r2 == 0) goto L_0x004b
                r2 = r11
                retrofit2.HttpException r2 = (retrofit2.HttpException) r2     // Catch:{ Exception -> 0x0080 }
                int r2 = r2.code()     // Catch:{ Exception -> 0x0080 }
                r6 = 503(0x1f7, float:7.05E-43)
                r7 = 500(0x1f4, float:7.0E-43)
                r8 = 401(0x191, float:5.62E-43)
                r9 = 400(0x190, float:5.6E-43)
                if (r2 == r9) goto L_0x0031
                if (r2 == r8) goto L_0x0031
                if (r2 == r7) goto L_0x0031
                if (r2 == r6) goto L_0x0031
            L_0x002f:
                r3 = r5
                goto L_0x006d
            L_0x0031:
                retrofit2.HttpException r11 = (retrofit2.HttpException) r11     // Catch:{ Exception -> 0x0080 }
                int r11 = r11.code()     // Catch:{ Exception -> 0x0080 }
                if (r11 == r9) goto L_0x0048
                if (r11 == r8) goto L_0x0045
                if (r11 == r7) goto L_0x0042
                if (r11 == r6) goto L_0x0040
                goto L_0x006d
            L_0x0040:
                r3 = r4
                goto L_0x006d
            L_0x0042:
                java.lang.String r3 = "20700"
                goto L_0x006d
            L_0x0045:
                java.lang.String r3 = "20800"
                goto L_0x006d
            L_0x0048:
                java.lang.String r3 = "20600"
                goto L_0x006d
            L_0x004b:
                boolean r2 = r11 instanceof java.net.ConnectException     // Catch:{ Exception -> 0x0080 }
                if (r2 == 0) goto L_0x0051
                r2 = 1
                goto L_0x0053
            L_0x0051:
                boolean r2 = r11 instanceof java.net.SocketTimeoutException     // Catch:{ Exception -> 0x0080 }
            L_0x0053:
                if (r2 == 0) goto L_0x0057
                r2 = 1
                goto L_0x0059
            L_0x0057:
                boolean r2 = r11 instanceof java.util.concurrent.TimeoutException     // Catch:{ Exception -> 0x0080 }
            L_0x0059:
                if (r2 == 0) goto L_0x005e
                java.lang.String r3 = "25100"
                goto L_0x006d
            L_0x005e:
                boolean r2 = r11 instanceof java.text.ParseException     // Catch:{ Exception -> 0x0080 }
                if (r2 == 0) goto L_0x0063
                goto L_0x002f
            L_0x0063:
                boolean r2 = r11 instanceof mobile.com.requestframe.utils.bean.ResultException     // Catch:{ Exception -> 0x0080 }
                if (r2 == 0) goto L_0x006d
                mobile.com.requestframe.utils.bean.ResultException r11 = (mobile.com.requestframe.utils.bean.ResultException) r11     // Catch:{ Exception -> 0x0080 }
                java.lang.String r3 = r11.getReturnCode()     // Catch:{ Exception -> 0x0080 }
            L_0x006d:
                boolean r11 = android.text.TextUtils.isDigitsOnly(r3)     // Catch:{ Exception -> 0x0080 }
                if (r11 == 0) goto L_0x007c
                java.lang.String r11 = "errCode"
                t9.i.f(r3, r11)     // Catch:{ Exception -> 0x0080 }
                r0.L(r3)     // Catch:{ Exception -> 0x0080 }
                goto L_0x0084
            L_0x007c:
                r0.L(r4)     // Catch:{ Exception -> 0x0080 }
                goto L_0x0084
            L_0x0080:
                r11 = move-exception
                r11.printStackTrace()
            L_0x0084:
                boolean r11 = r5.i.f19379b
                if (r11 != 0) goto L_0x0099
                r5.i r11 = r5.i.f19378a
                java.lang.String r0 = "slb 请求失败重试"
                com.mobile.brasiltv.utils.b0.U(r11, r0)
                r2 = 300(0x12c, double:1.48E-321)
                r5.i.f19380c = r2
                r11.E()
            L_0x0099:
                r5.i.f19379b = r1
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: r5.i.c.invoke(java.lang.Throwable):void");
        }
    }

    public static final class d extends j implements l {

        /* renamed from: a  reason: collision with root package name */
        public static final d f19393a = new d();

        public d() {
            super(1);
        }

        /* renamed from: b */
        public final ObservableSource invoke(List list) {
            t9.i.g(list, "it");
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                CdnListBeanResult cdnListBeanResult = (CdnListBeanResult) it.next();
                String tag = cdnListBeanResult.getTag();
                if (t9.i.b(tag, k.LIVE.b())) {
                    arrayList.add(cdnListBeanResult);
                } else if (t9.i.b(tag, k.VOD.b())) {
                    arrayList2.add(cdnListBeanResult);
                } else if (t9.i.b(tag, k.RECORD.b())) {
                    arrayList3.add(cdnListBeanResult);
                }
            }
            return Observable.fromArray(arrayList, arrayList2, arrayList3);
        }
    }

    public static final class e extends j implements l {

        /* renamed from: a  reason: collision with root package name */
        public static final e f19394a = new e();

        public e() {
            super(1);
        }

        public static final int d(CdnListBeanResult cdnListBeanResult, CdnListBeanResult cdnListBeanResult2) {
            return t9.i.i(cdnListBeanResult.getSerial_number(), cdnListBeanResult2.getSerial_number());
        }

        /* renamed from: c */
        public final ArrayList invoke(ArrayList arrayList) {
            t9.i.g(arrayList, "it");
            n.m(arrayList, new j());
            return arrayList;
        }
    }

    public static final class f extends j implements l {

        /* renamed from: a  reason: collision with root package name */
        public static final f f19395a = new f();

        public f() {
            super(1);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((ArrayList) obj);
            return t.f17319a;
        }

        public final void invoke(ArrayList arrayList) {
            if (!b0.G(arrayList)) {
                String tag = ((CdnListBeanResult) arrayList.get(0)).getTag();
                i iVar = i.f19378a;
                b0.U(iVar, "cdn type is " + tag + " and size is " + arrayList.size());
                i.f19384g.put(tag, arrayList);
                if (b0.I(((CdnListBeanResult) arrayList.get(0)).getUrl_list())) {
                    ArrayList arrayList2 = new ArrayList();
                    List<CdnUrl> url_list = ((CdnListBeanResult) arrayList.get(0)).getUrl_list();
                    t9.i.d(url_list);
                    for (CdnUrl cdnUrl : url_list) {
                        if (b0.H(cdnUrl.getUrl())) {
                            arrayList2.add(cdnUrl.getTag());
                        }
                    }
                    i.f19385h.put(tag, arrayList2);
                    i iVar2 = i.f19378a;
                    b0.U(iVar2, "cdn type is " + tag + " and tags is " + arrayList2);
                }
            }
        }
    }

    public static final class g extends j implements l {

        /* renamed from: a  reason: collision with root package name */
        public static final g f19396a = new g();

        public g() {
            super(1);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Throwable) obj);
            return t.f17319a;
        }

        public final void invoke(Throwable th) {
            th.printStackTrace();
            i iVar = i.f19378a;
            b0.U(iVar, "update slb info occur exception");
            iVar.K(true);
        }
    }

    public static final ObservableSource F(l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        return (ObservableSource) lVar.invoke(obj);
    }

    public static final void G(l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void H(l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void N() {
        i iVar = f19378a;
        iVar.r(k.LIVE);
        iVar.r(k.VOD);
        b0.U(iVar, "update slb info finished");
        f19388k = true;
    }

    public static final ObservableSource O(l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        return (ObservableSource) lVar.invoke(obj);
    }

    public static final ArrayList P(l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        return (ArrayList) lVar.invoke(obj);
    }

    public static final void Q(l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void R(l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public final GetSlbInfoBeanResultData A() {
        return f19383f;
    }

    public final k B() {
        String str;
        GetSlbInfoBeanResultData getSlbInfoBeanResultData = f19383f;
        if (getSlbInfoBeanResultData != null) {
            str = getSlbInfoBeanResultData.getPlay_params();
        } else {
            str = null;
        }
        if (!b0.H(str)) {
            return new k("", "");
        }
        GetSlbInfoBeanResultData getSlbInfoBeanResultData2 = f19383f;
        t9.i.d(getSlbInfoBeanResultData2);
        String a10 = d0.a(getSlbInfoBeanResultData2.getPlay_params(), "svs_address");
        GetSlbInfoBeanResultData getSlbInfoBeanResultData3 = f19383f;
        t9.i.d(getSlbInfoBeanResultData3);
        return new k(a10, d0.a(getSlbInfoBeanResultData3.getPlay_params(), "svs_address_spare"));
    }

    public final void C(GetSlbInfoBeanResult getSlbInfoBeanResult) {
        String str;
        GetSlbInfoBeanResultData data = getSlbInfoBeanResult.getData();
        String str2 = null;
        if (data != null) {
            str = data.getInvalidTime();
        } else {
            str = null;
        }
        if (!b0.J(str)) {
            GetSlbInfoBeanResultData data2 = getSlbInfoBeanResult.getData();
            if (data2 != null) {
                str2 = data2.getInvalidTime();
            }
            long Z = b0.Z(str2) - ((long) 600);
            f19380c = Z;
            f19379b = false;
            if (Z < 600) {
                f19380c = 600;
            }
            t();
            E();
        }
    }

    public final void D(GetSlbInfoBeanResult getSlbInfoBeanResult) {
        String str;
        GetSlbInfoBeanResultData data = getSlbInfoBeanResult.getData();
        List<CdnListBeanResult> list = null;
        if (data != null) {
            str = data.getError_code();
        } else {
            str = null;
        }
        boolean z10 = false;
        if (b0.Y(str, 0) == 0) {
            GetSlbInfoBeanResultData data2 = getSlbInfoBeanResult.getData();
            if (data2 != null) {
                list = data2.getCdn_list();
            }
            if (list == null || list.isEmpty()) {
                z10 = true;
            }
            if (!z10) {
                GetSlbInfoBeanResultData data3 = getSlbInfoBeanResult.getData();
                t9.i.d(data3);
                M(data3);
                return;
            }
        }
        f19388k = true;
    }

    public final void E() {
        f19387j = Observable.timer(f19380c, TimeUnit.SECONDS).flatMap(new a(a.f19390a)).subscribe(new b(b.f19391a), new c(c.f19392a));
    }

    public final boolean I() {
        return f19388k;
    }

    public final void J() {
        f19381d = 1800;
        f19380c = 0;
        f19388k = false;
        f19384g.clear();
        f19386i.clear();
        f19385h.clear();
        t();
        f19382e = null;
        f19383f = null;
    }

    public final void K(boolean z10) {
        f19388k = z10;
    }

    public final void L(String str) {
        t9.i.g(str, "<set-?>");
        f19389l = str;
    }

    public final void M(GetSlbInfoBeanResultData getSlbInfoBeanResultData) {
        f19383f = getSlbInfoBeanResultData;
        f19384g.clear();
        f19386i.clear();
        f19385h.clear();
        q6.a aVar = q6.a.f19342a;
        Context context = f19382e;
        t9.i.d(context);
        aVar.b(context, getSlbInfoBeanResultData.getPlay_params());
        aVar.a();
        GetSlbInfoBeanResultData getSlbInfoBeanResultData2 = f19383f;
        t9.i.d(getSlbInfoBeanResultData2);
        Observable.just(getSlbInfoBeanResultData2.getCdn_list()).flatMap(new d(d.f19393a)).map(new e(e.f19394a)).subscribe(new f(f.f19395a), new g(g.f19396a), new h());
    }

    public final void r(k kVar) {
        boolean z10;
        List<CdnListBeanResult> w10 = w(kVar);
        if (w10 == null || w10.isEmpty()) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10) {
            for (CdnListBeanResult cdnListBeanResult : w10) {
                String str = "";
                if (b0.K(cdnListBeanResult.getMain_addr())) {
                    HashMap hashMap = f19386i;
                    String main_addr = cdnListBeanResult.getMain_addr();
                    t9.i.d(main_addr);
                    String main_addr_mark = cdnListBeanResult.getMain_addr_mark();
                    if (main_addr_mark == null) {
                        main_addr_mark = str;
                    }
                    hashMap.put(main_addr, main_addr_mark);
                    i iVar = f19378a;
                    b0.U(iVar, "assemble live main server mark and server is " + cdnListBeanResult.getMain_addr() + " and server mark is " + cdnListBeanResult.getMain_addr_mark());
                }
                if (b0.K(cdnListBeanResult.getSpared_addr())) {
                    HashMap hashMap2 = f19386i;
                    String spared_addr = cdnListBeanResult.getSpared_addr();
                    t9.i.d(spared_addr);
                    String spared_addr_mark = cdnListBeanResult.getSpared_addr_mark();
                    if (spared_addr_mark != null) {
                        str = spared_addr_mark;
                    }
                    hashMap2.put(spared_addr, str);
                    i iVar2 = f19378a;
                    b0.U(iVar2, "assemble live backup server mark and server is " + cdnListBeanResult.getSpared_addr() + " and server mark is " + cdnListBeanResult.getSpared_addr_mark());
                }
            }
        }
    }

    public final void s(Context context) {
        t9.i.g(context, com.umeng.analytics.pro.f.X);
        f19382e = context.getApplicationContext();
    }

    public final void t() {
        Disposable disposable;
        Disposable disposable2 = f19387j;
        boolean z10 = false;
        if (disposable2 != null && !disposable2.isDisposed()) {
            z10 = true;
        }
        if (z10 && (disposable = f19387j) != null) {
            disposable.dispose();
        }
        f19387j = null;
    }

    public final void u() {
        f19384g.clear();
        f19386i.clear();
        f19385h.clear();
    }

    public final void v() {
        f19380c = 0;
        f19381d = 1800;
        f19388k = false;
        f19379b = false;
        t();
        E();
    }

    public final List w(k kVar) {
        t9.i.g(kVar, "cdnType");
        return (List) f19384g.get(kVar.b());
    }

    public final List x(k kVar) {
        t9.i.g(kVar, "cdnType");
        return (List) f19385h.get(kVar.b());
    }

    public final String y(String str) {
        t9.i.g(str, "server");
        String str2 = (String) f19386i.get(str);
        if (str2 == null) {
            return "";
        }
        return str2;
    }

    public final String z() {
        return f19389l;
    }
}
