package w6;

import android.content.Context;
import android.os.SystemClock;
import com.dcs.bean.DomainInfo;
import com.google.android.gms.common.Scopes;
import com.google.gson.Gson;
import com.hpplay.sdk.source.common.global.Constant;
import com.mobile.brasiltv.app.App;
import com.mobile.brasiltv.bean.RootColumnId;
import com.mobile.brasiltv.bean.event.CouponQualificationEvent;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.utils.f0;
import com.mobile.brasiltv.utils.p0;
import com.mobile.brasiltv.utils.y0;
import com.taobao.accs.AccsClientConfig;
import h9.t;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import mobile.com.requestframe.utils.bean.ActiveBean;
import mobile.com.requestframe.utils.bean.ApkQueryCouponBean;
import mobile.com.requestframe.utils.bean.ApkReceiveCouponBean;
import mobile.com.requestframe.utils.bean.AreaCodeBean;
import mobile.com.requestframe.utils.bean.BindBean;
import mobile.com.requestframe.utils.bean.BindEmailV2Bean;
import mobile.com.requestframe.utils.bean.BindPhoneBean;
import mobile.com.requestframe.utils.bean.ChangeBindEmailBean;
import mobile.com.requestframe.utils.bean.CheckGetVipBean;
import mobile.com.requestframe.utils.bean.CheckVerificationBean;
import mobile.com.requestframe.utils.bean.CheckVerifyCodeBean;
import mobile.com.requestframe.utils.bean.ConfigBean;
import mobile.com.requestframe.utils.bean.CustomerService;
import mobile.com.requestframe.utils.bean.DeleteMsgParams;
import mobile.com.requestframe.utils.bean.EmailResetPwdBean;
import mobile.com.requestframe.utils.bean.EmailVerifyCodeBean;
import mobile.com.requestframe.utils.bean.ExchangeBean;
import mobile.com.requestframe.utils.bean.ExchangeCodeBean;
import mobile.com.requestframe.utils.bean.ForceBindBean;
import mobile.com.requestframe.utils.bean.FreeTimeBean;
import mobile.com.requestframe.utils.bean.GetAddFavorite;
import mobile.com.requestframe.utils.bean.GetAddSubscribe;
import mobile.com.requestframe.utils.bean.GetAuthInfoBean;
import mobile.com.requestframe.utils.bean.GetBlSearchByContentBean;
import mobile.com.requestframe.utils.bean.GetColumnContentsBean;
import mobile.com.requestframe.utils.bean.GetDelFavorite;
import mobile.com.requestframe.utils.bean.GetDelSubscribe;
import mobile.com.requestframe.utils.bean.GetExchangeOrderBean;
import mobile.com.requestframe.utils.bean.GetFavorite;
import mobile.com.requestframe.utils.bean.GetHomeBean;
import mobile.com.requestframe.utils.bean.GetItemDataBean;
import mobile.com.requestframe.utils.bean.GetLiveDataBean;
import mobile.com.requestframe.utils.bean.GetOrderInfoBean;
import mobile.com.requestframe.utils.bean.GetPriorityVipBean;
import mobile.com.requestframe.utils.bean.GetProgramBean;
import mobile.com.requestframe.utils.bean.GetSearchByContentBean;
import mobile.com.requestframe.utils.bean.GetShortVideoBean;
import mobile.com.requestframe.utils.bean.GetSlbInfoBean;
import mobile.com.requestframe.utils.bean.GiftDaysBean;
import mobile.com.requestframe.utils.bean.HeartBeatBean;
import mobile.com.requestframe.utils.bean.LoginBean;
import mobile.com.requestframe.utils.bean.LoginThirdPartBean;
import mobile.com.requestframe.utils.bean.LogoutBean;
import mobile.com.requestframe.utils.bean.MsgBoxParams;
import mobile.com.requestframe.utils.bean.OrderInfoBean;
import mobile.com.requestframe.utils.bean.PwdCheckBean;
import mobile.com.requestframe.utils.bean.QrGetResultBean;
import mobile.com.requestframe.utils.bean.QueryMsgNumParams;
import mobile.com.requestframe.utils.bean.ReadMsgParams;
import mobile.com.requestframe.utils.bean.ResetPwdEmailBean;
import mobile.com.requestframe.utils.bean.ResultException;
import mobile.com.requestframe.utils.bean.SearchByNameBean;
import mobile.com.requestframe.utils.bean.ShelveDataRequestBean;
import mobile.com.requestframe.utils.bean.SnTokenBean;
import mobile.com.requestframe.utils.bean.StartPlayVODBean;
import mobile.com.requestframe.utils.bean.ThirdPartBean;
import mobile.com.requestframe.utils.bean.TypeQuestionBean;
import mobile.com.requestframe.utils.bean.UnbindBean;
import mobile.com.requestframe.utils.bean.UpdateDeviceTokenBean;
import mobile.com.requestframe.utils.bean.UpdatePwdBean;
import mobile.com.requestframe.utils.bean.UpdateRestrictBean;
import mobile.com.requestframe.utils.bean.UserBindInfo;
import mobile.com.requestframe.utils.bean.UserFeedBean;
import mobile.com.requestframe.utils.bean.VerificationBean;
import mobile.com.requestframe.utils.bean.VodRecommendsRequestBean;
import mobile.com.requestframe.utils.bean.WaitConfirmBean;
import mobile.com.requestframe.utils.response.ChildColumnList;
import mobile.com.requestframe.utils.response.ColumnContentsBean;
import mobile.com.requestframe.utils.response.FeedBackContactData;
import mobile.com.requestframe.utils.response.FeedBackContactResult;
import mobile.com.requestframe.utils.response.GetColumnContentsResult;
import org.android.agoo.message.MessageService;

public final class i {
    public static String A;
    public static String B = "0";
    public static String C = "1";
    public static String D = "";
    public static String E = "";
    public static String F = "";
    public static String G = "";
    public static int H;
    public static int I;
    public static String J = "";
    public static String K;
    public static String L;
    public static String M = "";
    public static String N = "";
    public static String O = "";
    public static String P = "";
    public static List Q = new ArrayList();
    public static String R = "";
    public static String S = "";
    public static boolean T;
    public static boolean U;
    public static int V;
    public static final h9.g W = h9.h.b(b.f19738a);

    /* renamed from: g  reason: collision with root package name */
    public static final c f9510g = new c((t9.g) null);

    /* renamed from: h  reason: collision with root package name */
    public static final h9.g f9511h = h9.h.b(a.f19737a);

    /* renamed from: i  reason: collision with root package name */
    public static String f9512i = "";

    /* renamed from: j  reason: collision with root package name */
    public static String f9513j = "";

    /* renamed from: k  reason: collision with root package name */
    public static String f9514k;

    /* renamed from: l  reason: collision with root package name */
    public static String f9515l = "";

    /* renamed from: m  reason: collision with root package name */
    public static String f9516m = "";

    /* renamed from: n  reason: collision with root package name */
    public static String f9517n = "";

    /* renamed from: o  reason: collision with root package name */
    public static String f9518o = "";

    /* renamed from: p  reason: collision with root package name */
    public static String f9519p = "";

    /* renamed from: q  reason: collision with root package name */
    public static String f9520q = "";

    /* renamed from: r  reason: collision with root package name */
    public static String f9521r = "0";

    /* renamed from: s  reason: collision with root package name */
    public static String f9522s = "";

    /* renamed from: t  reason: collision with root package name */
    public static String f9523t = "";

    /* renamed from: u  reason: collision with root package name */
    public static String f9524u = "";

    /* renamed from: v  reason: collision with root package name */
    public static String f9525v = "";

    /* renamed from: w  reason: collision with root package name */
    public static String f9526w = "";

    /* renamed from: x  reason: collision with root package name */
    public static String f9527x = "";

    /* renamed from: y  reason: collision with root package name */
    public static String f9528y = "";

    /* renamed from: z  reason: collision with root package name */
    public static String f9529z;

    /* renamed from: a  reason: collision with root package name */
    public final h9.g f9530a = h9.h.b(d.f19739a);

    /* renamed from: b  reason: collision with root package name */
    public final h9.g f9531b = h9.h.b(e.f19740a);

    /* renamed from: c  reason: collision with root package name */
    public final h9.g f9532c = h9.h.b(f.f19741a);

    /* renamed from: d  reason: collision with root package name */
    public final h9.g f9533d = h9.h.b(q.f19754a);

    /* renamed from: e  reason: collision with root package name */
    public final h9.g f9534e = h9.h.b(new p(this));

    /* renamed from: f  reason: collision with root package name */
    public final h9.g f9535f = h9.h.b(new o(this));

    public static final class c {
        public c() {
        }

        public /* synthetic */ c(t9.g gVar) {
            this();
        }

        public final String A() {
            return i.f9524u;
        }

        public final void A0(String str) {
            t9.i.g(str, "<set-?>");
            i.f9519p = str;
        }

        public final int B() {
            return i.V;
        }

        public final void B0(String str) {
            t9.i.g(str, "<set-?>");
            i.E = str;
        }

        public final String C() {
            return i.S;
        }

        public final String D() {
            return i.A;
        }

        public final String E() {
            return i.f9517n;
        }

        public final String F() {
            return i.f9516m;
        }

        public final String G() {
            return i.P;
        }

        public final String H() {
            return i.f9512i;
        }

        public final String I() {
            return i.f9527x;
        }

        public final String J() {
            return i.f9513j;
        }

        public final String K() {
            return i.f9519p;
        }

        public final boolean L() {
            return i.U;
        }

        public final boolean M() {
            return i.T;
        }

        public final boolean N() {
            if (!t9.i.b(e(), "1") || (!t9.i.b(I(), "3") && !t9.i.b(I(), "4"))) {
                return false;
            }
            return true;
        }

        public final void O(String str) {
            i.f9529z = str;
        }

        public final void P(String str) {
            i.K = str;
        }

        public final void Q(String str) {
            t9.i.g(str, "<set-?>");
            i.f9528y = str;
        }

        public final void R(String str) {
            t9.i.g(str, "<set-?>");
            i.f9518o = str;
        }

        public final void S(String str) {
            t9.i.g(str, "<set-?>");
            i.N = str;
        }

        public final void T(String str) {
            t9.i.g(str, "<set-?>");
            i.f9521r = str;
        }

        public final void U(String str) {
            t9.i.g(str, "<set-?>");
            i.C = str;
        }

        public final void V(String str) {
            t9.i.g(str, "<set-?>");
            i.B = str;
        }

        public final void W(String str) {
            t9.i.g(str, "<set-?>");
            i.f9526w = str;
        }

        public final void X(boolean z10) {
            i.U = z10;
        }

        public final void Y(String str) {
            i.f9514k = str;
        }

        public final void Z(String str) {
            t9.i.g(str, "<set-?>");
            i.R = str;
        }

        public final void a(Context context) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(H() + "isHasCouponQualification");
            arrayList.add(H() + "couponQualificationTime");
            arrayList.add(H() + "couponQualificationInvalidTime");
            na.f.n(context, (String[]) arrayList.toArray(new String[0]));
        }

        public final void a0(String str) {
            t9.i.g(str, "<set-?>");
            i.O = str;
        }

        public final i b() {
            return w();
        }

        public final void b0(String str) {
            t9.i.g(str, "<set-?>");
            i.f9522s = str;
        }

        public final String c() {
            return i.f9529z;
        }

        public final void c0(int i10) {
            i.I = i10;
        }

        public final String d() {
            return i.K;
        }

        public final void d0(String str) {
            t9.i.g(str, "<set-?>");
            i.F = str;
        }

        public final String e() {
            return i.f9528y;
        }

        public final void e0(String str) {
            t9.i.g(str, "<set-?>");
            i.G = str;
        }

        public final String f() {
            return i.f9518o;
        }

        public final void f0(boolean z10) {
            i.T = z10;
        }

        public final String g() {
            return i.N;
        }

        public final void g0(String str) {
            t9.i.g(str, "<set-?>");
            i.f9523t = str;
        }

        public final String h() {
            return i.f9521r;
        }

        public final void h0(String str) {
            t9.i.g(str, "<set-?>");
            i.f9525v = str;
        }

        public final String i() {
            return i.C;
        }

        public final void i0(boolean z10) {
            f0(z10);
            xa.c.c().j(new CouponQualificationEvent(M()));
        }

        public final String j() {
            return i.B;
        }

        public final void j0(String str) {
            t9.i.g(str, "<set-?>");
            i.D = str;
        }

        public final String k() {
            return i.R;
        }

        public final void k0(String str) {
            i.L = str;
        }

        public final String l() {
            return i.O;
        }

        public final void l0(String str) {
            t9.i.g(str, "<set-?>");
            i.f9515l = str;
        }

        public final String m() {
            return i.f9522s;
        }

        public final void m0(String str) {
            t9.i.g(str, "<set-?>");
            i.M = str;
        }

        public final int n() {
            return i.I;
        }

        public final void n0(String str) {
            t9.i.g(str, "<set-?>");
            i.f9520q = str;
        }

        public final List o() {
            return i.Q;
        }

        public final void o0(String str) {
            t9.i.g(str, "<set-?>");
            i.J = str;
        }

        public final String p() {
            return i.F;
        }

        public final void p0(int i10) {
            i.H = i10;
        }

        public final String q() {
            return i.G;
        }

        public final void q0(String str) {
            t9.i.g(str, "<set-?>");
            i.f9524u = str;
        }

        public final String r() {
            return i.f9523t;
        }

        public final void r0(int i10) {
            i.V = i10;
        }

        public final String s() {
            return i.f9525v;
        }

        public final void s0(String str) {
            t9.i.g(str, "<set-?>");
            i.S = str;
        }

        public final String t() {
            return i.D;
        }

        public final void t0(String str) {
            i.A = str;
        }

        public final DomainInfo u() {
            return (DomainInfo) i.f9511h.getValue();
        }

        public final void u0(String str) {
            t9.i.g(str, "<set-?>");
            i.f9517n = str;
        }

        public final String v() {
            return i.f9515l;
        }

        public final void v0(String str) {
            t9.i.g(str, "<set-?>");
            i.f9516m = str;
        }

        public final i w() {
            return (i) i.W.getValue();
        }

        public final void w0(String str) {
            t9.i.g(str, "<set-?>");
            i.P = str;
        }

        public final String x() {
            return i.M;
        }

        public final void x0(String str) {
            t9.i.g(str, "<set-?>");
            i.f9512i = str;
        }

        public final String y() {
            return i.J;
        }

        public final void y0(String str) {
            t9.i.g(str, "<set-?>");
            i.f9527x = str;
        }

        public final int z() {
            return i.H;
        }

        public final void z0(String str) {
            t9.i.g(str, "<set-?>");
            i.f9513j = str;
        }
    }

    public static final class a extends t9.j implements s9.a {

        /* renamed from: a  reason: collision with root package name */
        public static final a f19737a = new a();

        public a() {
            super(0);
        }

        /* renamed from: b */
        public final DomainInfo invoke() {
            return t2.a.f9350a.b(m7.c.i().first.toString(), m7.c.i().second.toString(), "key_portal");
        }
    }

    public static final class b extends t9.j implements s9.a {

        /* renamed from: a  reason: collision with root package name */
        public static final b f19738a = new b();

        public b() {
            super(0);
        }

        /* renamed from: b */
        public final i invoke() {
            return new i();
        }
    }

    public static final class d extends t9.j implements s9.a {

        /* renamed from: a  reason: collision with root package name */
        public static final d f19739a = new d();

        public d() {
            super(0);
        }

        public final String invoke() {
            return b0.x(m7.c.i().first.toString());
        }
    }

    public static final class e extends t9.j implements s9.a {

        /* renamed from: a  reason: collision with root package name */
        public static final e f19740a = new e();

        public e() {
            super(0);
        }

        public final String invoke() {
            return b0.x(m7.c.i().second.toString());
        }
    }

    public static final class f extends t9.j implements s9.a {

        /* renamed from: a  reason: collision with root package name */
        public static final f f19741a = new f();

        public f() {
            super(0);
        }

        /* renamed from: b */
        public final DomainInfo invoke() {
            return t2.a.f9350a.b(m7.c.f().first.toString(), m7.c.f().second.toString(), "key_epg");
        }
    }

    public static final class g extends t9.j implements s9.l {

        /* renamed from: a  reason: collision with root package name */
        public static final g f19742a = new g();

        public g() {
            super(1);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Throwable) obj);
            return t.f17319a;
        }

        public final void invoke(Throwable th) {
            d6.b.f6366a.f();
            if (!(th instanceof ResultException)) {
                t2.a.f9350a.q(i.f9510g.u(), "key_portal");
            }
        }
    }

    public static final class h extends t9.j implements s9.l {

        /* renamed from: a  reason: collision with root package name */
        public static final h f19743a = new h();

        public h() {
            super(1);
        }

        public final void b(FeedBackContactResult feedBackContactResult) {
            if (b0.I(feedBackContactResult.getData())) {
                c cVar = i.f9510g;
                cVar.o().clear();
                List o10 = cVar.o();
                List<FeedBackContactData> data = feedBackContactResult.getData();
                t9.i.d(data);
                o10.addAll(data);
            }
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            b((FeedBackContactResult) obj);
            return t.f17319a;
        }
    }

    /* renamed from: w6.i$i  reason: collision with other inner class name */
    public static final class C0289i extends t9.j implements s9.l {

        /* renamed from: a  reason: collision with root package name */
        public static final C0289i f19744a = new C0289i();

        public C0289i() {
            super(1);
        }

        /* renamed from: b */
        public final Boolean invoke(GetColumnContentsResult getColumnContentsResult) {
            List<ChildColumnList> list;
            t9.i.g(getColumnContentsResult, "columnContentsBean");
            if (t9.i.b(getColumnContentsResult.getReturnCode(), "0")) {
                if (getColumnContentsResult.getData() == null) {
                    ColumnContentsBean data = getColumnContentsResult.getData();
                    if (data != null) {
                        list = data.getChildColumnList();
                    } else {
                        list = null;
                    }
                    if (list == null) {
                        throw new NullPointerException("main column is null!");
                    }
                }
                return Boolean.TRUE;
            }
            throw new NullPointerException("main column is null!");
        }
    }

    public static final class j extends t9.j implements s9.l {

        /* renamed from: a  reason: collision with root package name */
        public static final j f19745a = new j();

        public static final class a extends t9.j implements s9.l {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ GetColumnContentsResult f19746a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(GetColumnContentsResult getColumnContentsResult) {
                super(1);
                this.f19746a = getColumnContentsResult;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return t.f17319a;
            }

            public final void invoke(String str) {
                Gson a10 = m8.a.a();
                ColumnContentsBean data = this.f19746a.getData();
                t9.i.d(data);
                n7.a.e(na.a.f8315a, "root_column", a10.toJson((Object) data));
                String f10 = na.f.f(na.a.f8315a, "realtime_dcs", "0");
                t9.i.f(f10, "getStrings(AppHelper.mCo…nstant.REALTIME_DCS, \"0\")");
                na.f.k(na.a.f8315a, "service_time_root_column", String.valueOf((i2.h.f7019a.a() + SystemClock.elapsedRealtime()) - Long.parseLong(f10)));
            }
        }

        public static final class b extends t9.j implements s9.l {

            /* renamed from: a  reason: collision with root package name */
            public static final b f19747a = new b();

            public b() {
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

        public j() {
            super(1);
        }

        public static final void e(s9.l lVar, Object obj) {
            t9.i.g(lVar, "$tmp0");
            lVar.invoke(obj);
        }

        public static final void f(s9.l lVar, Object obj) {
            t9.i.g(lVar, "$tmp0");
            lVar.invoke(obj);
        }

        /* renamed from: d */
        public final List invoke(GetColumnContentsResult getColumnContentsResult) {
            t9.i.g(getColumnContentsResult, "bean");
            Observable.just("ioSchedulers").compose(p0.c()).subscribe(new j(new a(getColumnContentsResult)), new k(b.f19747a));
            ColumnContentsBean data = getColumnContentsResult.getData();
            t9.i.d(data);
            return data.getChildColumnList();
        }
    }

    public static final class k extends t9.j implements s9.l {

        /* renamed from: a  reason: collision with root package name */
        public static final k f19748a = new k();

        public k() {
            super(1);
        }

        /* renamed from: b */
        public final ObservableSource invoke(List list) {
            t9.i.g(list, "list");
            int i10 = 0;
            for (Object next : list) {
                int i11 = i10 + 1;
                if (i10 < 0) {
                    i9.j.j();
                }
                ChildColumnList childColumnList = (ChildColumnList) next;
                String code = childColumnList.getCode();
                StringBuilder sb = new StringBuilder();
                c cVar = i.f9510g;
                sb.append(cVar.v());
                sb.append("_live");
                if (t9.i.b(code, sb.toString())) {
                    RootColumnId.tvId = childColumnList.getId();
                    RootColumnId.tvColumn = childColumnList;
                } else {
                    if (t9.i.b(code, cVar.v() + "_vod")) {
                        RootColumnId.mainId = childColumnList.getId();
                        RootColumnId.mainColumn = childColumnList;
                    } else {
                        if (t9.i.b(code, cVar.v() + "_special")) {
                            RootColumnId.specialId = childColumnList.getId();
                            RootColumnId.specialColumn = childColumnList;
                        } else {
                            if (t9.i.b(code, cVar.v() + "_hot")) {
                                RootColumnId.hotSearchId = childColumnList.getId();
                                RootColumnId.hotSearchColumn = childColumnList;
                            } else {
                                if (t9.i.b(code, cVar.v() + "_free")) {
                                    RootColumnId.freeVodId = childColumnList.getId();
                                    RootColumnId.freeVodColumn = childColumnList;
                                } else {
                                    if (t9.i.b(code, cVar.v() + "_Recommended")) {
                                        RootColumnId.recommendHomeId = childColumnList.getId();
                                        RootColumnId.recommendHomeColumn = childColumnList;
                                    }
                                }
                            }
                        }
                    }
                }
                i10 = i11;
            }
            return Observable.fromIterable(list);
        }
    }

    public static final class l extends t9.j implements s9.l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i f19749a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public l(i iVar) {
            super(1);
            this.f19749a = iVar;
        }

        public final void b(ChildColumnList childColumnList) {
            i iVar = this.f19749a;
            b0.U(iVar, "main " + childColumnList);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            b((ChildColumnList) obj);
            return t.f17319a;
        }
    }

    public static final class m extends t9.j implements s9.l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f19750a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public m(String str) {
            super(1);
            this.f19750a = str;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Throwable) obj);
            return t.f17319a;
        }

        public final void invoke(Throwable th) {
            d6.b.f6366a.f();
            if (!t9.i.b(this.f19750a, "0") && !(th instanceof ResultException)) {
                t2.a.f9350a.q(i.f9510g.u(), "key_portal");
            }
        }
    }

    public static final class n extends t9.j implements s9.l {

        /* renamed from: a  reason: collision with root package name */
        public static final n f19751a = new n();

        public n() {
            super(1);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Throwable) obj);
            return t.f17319a;
        }

        public final void invoke(Throwable th) {
            d6.b.f6366a.f();
            if (!(th instanceof ResultException)) {
                t2.a.f9350a.q(i.f9510g.u(), "key_portal");
            }
        }
    }

    public static final class o extends t9.j implements s9.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i f19752a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public o(i iVar) {
            super(0);
            this.f19752a = iVar;
        }

        /* renamed from: b */
        public final oa.b invoke() {
            return new oa.b(this.f19752a.p1());
        }
    }

    public static final class p extends t9.j implements s9.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i f19753a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public p(i iVar) {
            super(0);
            this.f19753a = iVar;
        }

        /* renamed from: b */
        public final oa.c invoke() {
            return new oa.c(this.f19753a.m1(), this.f19753a.n1());
        }
    }

    public static final class q extends t9.j implements s9.a {

        /* renamed from: a  reason: collision with root package name */
        public static final q f19754a = new q();

        public q() {
            super(0);
        }

        /* renamed from: b */
        public final oa.d invoke() {
            c cVar = i.f9510g;
            return new oa.d(cVar.u().getFirst(), cVar.u().getSecond(), new l());
        }
    }

    public static final boolean J1(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        return ((Boolean) lVar.invoke(obj)).booleanValue();
    }

    public static final void K0(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final List K1(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        return (List) lVar.invoke(obj);
    }

    public static final ObservableSource L1(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        return (ObservableSource) lVar.invoke(obj);
    }

    public static final void M1(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static /* synthetic */ Observable X1(i iVar, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i10, Object obj) {
        String str8;
        if ((i10 & 64) != 0) {
            str8 = null;
        } else {
            str8 = str7;
        }
        return iVar.W1(str, str2, str3, str4, str5, str6, str8);
    }

    public static final void Y1(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void a2(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static /* synthetic */ Observable c1(i iVar, String str, List list, boolean z10, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            z10 = false;
        }
        return iVar.b1(str, list, z10);
    }

    public static /* synthetic */ Observable i1(i iVar, int i10, boolean z10, int i11, int i12, int i13, Object obj) {
        if ((i13 & 2) != 0) {
            z10 = false;
        }
        if ((i13 & 4) != 0) {
            i11 = 1;
        }
        if ((i13 & 8) != 0) {
            i12 = 1000;
        }
        return iVar.h1(i10, z10, i11, i12);
    }

    public static final void l1(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static /* synthetic */ Observable v1(i iVar, String str, String str2, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str2 = "0";
        }
        return iVar.u1(str, str2);
    }

    public final oa.b A1() {
        return (oa.b) this.f9535f.getValue();
    }

    public final oa.d B1() {
        return (oa.d) this.f9533d.getValue();
    }

    public final Observable C1() {
        Observable L2 = B1().L(new GetOrderInfoBean(f9512i, f9513j));
        t9.i.f(L2, "mPortalModel.getOrderInfo(bean)");
        return L2;
    }

    public final Observable D1(String str) {
        t9.i.g(str, "orderId");
        Observable M2 = B1().M(new OrderInfoBean(f9512i, f9513j, str));
        t9.i.f(M2, "mPortalModel.getOrderInfoByOid(bean)");
        return M2;
    }

    public final Observable E1() {
        String str = f9512i;
        String str2 = f9513j;
        String str3 = f9515l;
        y0 y0Var = y0.f12657a;
        Context context = na.a.f8315a;
        t9.i.f(context, "mContext");
        Observable N2 = B1().N(new GetPriorityVipBean(str, str2, str3, y0Var.y(context)));
        t9.i.f(N2, "mPortalModel.getPriorityVip(bean)");
        return N2;
    }

    public final Observable F1(String str, int i10) {
        t9.i.g(str, "channelCode");
        Observable O2 = B1().O(new GetProgramBean(f9515l, str, i10, "0", f9512i, f9513j));
        t9.i.f(O2, "mPortalModel.getProgram(bean)");
        return O2;
    }

    public final Observable G1() {
        Observable P2 = B1().P();
        t9.i.f(P2, "mPortalModel.getPropertiesInfo()");
        return P2;
    }

    public final Observable H1(List list) {
        t9.i.g(list, "recommendCodeArr");
        Observable Q2 = B1().Q(new VodRecommendsRequestBean(f9513j, f9512i, f9515l, list));
        t9.i.f(Q2, "mPortalModel.getRecommends(bean)");
        return Q2;
    }

    public final Observable I1() {
        Observable doOnNext = B1().z(new GetColumnContentsBean(f9513j, f9512i, f9515l, (Integer) null, (String) null, 1, 1000, (Integer) null)).filter(new e(C0289i.f19744a)).map(new f(j.f19745a)).flatMap(new g(k.f19748a)).doOnNext(new h(new l(this)));
        t9.i.f(doOnNext, "fun getRootColumn(): Obs…)\n                }\n    }");
        return doOnNext;
    }

    public final Observable J0() {
        String b10 = a5.g.b(App.f6050e.a().getApplicationContext());
        if (b10 == null) {
            b10 = AccsClientConfig.DEFAULT_CONFIGTAG;
        }
        String str = f9516m;
        y0 y0Var = y0.f12657a;
        Context context = na.a.f8315a;
        t9.i.f(context, "mContext");
        Observable doOnError = B1().c(new ActiveBean(str, (String) null, (String) null, y0Var.y(context), b10)).doOnError(new b(g.f19742a));
        t9.i.f(doOnError, "mPortalModel.active(acti…)\n            }\n        }");
        return doOnError;
    }

    public final Observable L0(String str, String str2, String str3) {
        t9.i.g(str, "type");
        t9.i.g(str2, "name");
        t9.i.g(str3, "contentId");
        Observable d10 = B1().d(new GetAddSubscribe(f9513j, f9512i, str, str2, str3));
        t9.i.f(d10, "mPortalModel.addSubscribe(bean)");
        return d10;
    }

    public final Observable M0(String str, String str2) {
        Observable e10 = B1().e(new ApkQueryCouponBean(f9512i, f9513j, str, str2));
        t9.i.f(e10, "mPortalModel.apkQueryCoupon(bean)");
        return e10;
    }

    public final Observable N0() {
        Observable f10 = B1().f(new ApkReceiveCouponBean(f9512i, f9513j));
        t9.i.f(f10, "mPortalModel.apkReceiveCoupon(bean)");
        return f10;
    }

    public final void N1(ColumnContentsBean columnContentsBean, s9.a aVar) {
        t9.i.g(columnContentsBean, "bean");
        t9.i.g(aVar, "callback");
        List<ChildColumnList> childColumnList = columnContentsBean.getChildColumnList();
        t9.i.d(childColumnList);
        int i10 = 0;
        for (T next : childColumnList) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                i9.j.j();
            }
            ChildColumnList childColumnList2 = (ChildColumnList) next;
            String code = childColumnList2.getCode();
            if (t9.i.b(code, f9515l + "_live")) {
                RootColumnId.tvId = childColumnList2.getId();
                RootColumnId.tvColumn = childColumnList2;
            } else {
                if (t9.i.b(code, f9515l + "_vod")) {
                    RootColumnId.mainId = childColumnList2.getId();
                    RootColumnId.mainColumn = childColumnList2;
                } else {
                    if (t9.i.b(code, f9515l + "_special")) {
                        RootColumnId.specialId = childColumnList2.getId();
                        RootColumnId.specialColumn = childColumnList2;
                    } else {
                        if (t9.i.b(code, f9515l + "_hot")) {
                            RootColumnId.hotSearchId = childColumnList2.getId();
                            RootColumnId.hotSearchColumn = childColumnList2;
                        } else {
                            if (t9.i.b(code, f9515l + "_free")) {
                                RootColumnId.freeVodId = childColumnList2.getId();
                                RootColumnId.freeVodColumn = childColumnList2;
                            } else {
                                if (t9.i.b(code, f9515l + "_Recommended")) {
                                    RootColumnId.recommendHomeId = childColumnList2.getId();
                                    RootColumnId.recommendHomeColumn = childColumnList2;
                                }
                            }
                        }
                    }
                }
            }
            i10 = i11;
        }
        aVar.invoke();
    }

    public final Observable O0() {
        Observable g10 = B1().g(new AreaCodeBean(f9513j, f9512i));
        t9.i.f(g10, "mPortalModel.areaCode(areaCodeBean)");
        return g10;
    }

    public final Observable O1(String str, String str2) {
        t9.i.g(str, "contentId");
        t9.i.g(str2, "type");
        Observable h02 = B1().h0(new GetSearchByContentBean(f9513j, f9512i, f9515l, str2, str, "0", "50", "18"));
        t9.i.f(h02, "mPortalModel.searchByContent(bean)");
        return h02;
    }

    public final Observable P0() {
        Observable h10 = B1().h(new GiftDaysBean(f9513j, f9512i));
        t9.i.f(h10, "mPortalModel.bindEmailGiftDays(bean)");
        return h10;
    }

    public final Observable P1(ShelveDataRequestBean shelveDataRequestBean) {
        t9.i.g(shelveDataRequestBean, "bean");
        Observable R2 = B1().R(shelveDataRequestBean);
        t9.i.d(R2);
        return R2;
    }

    public final Observable Q0(BindEmailV2Bean bindEmailV2Bean) {
        t9.i.g(bindEmailV2Bean, "bean");
        Observable i10 = B1().i(bindEmailV2Bean);
        t9.i.f(i10, "mPortalModel.bindEmailV2(bean)");
        return i10;
    }

    public final Observable Q1() {
        String str = f9512i;
        String str2 = f9513j;
        String str3 = f9515l;
        y0 y0Var = y0.f12657a;
        Context context = na.a.f8315a;
        t9.i.f(context, "mContext");
        Observable S2 = B1().S(new GetShortVideoBean(str, str2, str3, y0Var.y(context)));
        t9.i.f(S2, "mPortalModel.getShortVideo(bean)");
        return S2;
    }

    public final Observable R0(BindBean bindBean) {
        t9.i.g(bindBean, "bean");
        Observable k10 = B1().k(bindBean);
        t9.i.f(k10, "mPortalModel.bindThirdPart(bean)");
        return k10;
    }

    public final Observable R1(List list, String str) {
        List list2 = list;
        t9.i.g(list2, "liveCodeList");
        Observable T2 = B1().T(new GetSlbInfoBean(1, str, list2, f9513j, f9512i, f9515l, "merge", String.valueOf(na.a.b()), "pt", "", "0", f9523t, f9527x));
        t9.i.f(T2, "mPortalModel.getSlbInfoCast(bean)");
        return T2;
    }

    public final Observable S0(ChangeBindEmailBean changeBindEmailBean) {
        t9.i.g(changeBindEmailBean, "bean");
        Observable m10 = B1().m(changeBindEmailBean);
        t9.i.f(m10, "mPortalModel.changeBindEmail(bean)");
        return m10;
    }

    public final Observable S1() {
        Observable U2 = B1().U(new ThirdPartBean(f9515l));
        t9.i.f(U2, "mPortalModel.getThirdPart(bean)");
        return U2;
    }

    public final Observable T0(CheckVerifyCodeBean checkVerifyCodeBean) {
        t9.i.g(checkVerifyCodeBean, "bean");
        Observable n10 = B1().n(checkVerifyCodeBean);
        t9.i.f(n10, "mPortalModel.checkEmailVerifyCode(bean)");
        return n10;
    }

    public final Observable T1(String str) {
        t9.i.g(str, "type");
        String g10 = na.a.g();
        t9.i.f(g10, "getPackageName()");
        String language = Locale.getDefault().getLanguage();
        t9.i.f(language, "getDefault().language");
        Observable V2 = B1().V(new TypeQuestionBean(g10, language, str));
        t9.i.f(V2, "mPortalModel.getTypeQuestion(bean)");
        return V2;
    }

    public final Observable U0() {
        String g10 = na.a.g();
        String str = f9512i;
        String str2 = f9513j;
        t9.i.f(g10, "appId");
        String h10 = na.a.h();
        t9.i.f(h10, "getSn()");
        Observable o10 = B1().o(new ForceBindBean(str, str2, g10, h10));
        t9.i.f(o10, "mPortalModel.checkForceBind(bean)");
        return o10;
    }

    public final Observable U1(String str, String str2, String str3) {
        t9.i.g(str, "phone");
        t9.i.g(str2, "areaCode");
        t9.i.g(str3, "type");
        Observable W2 = B1().W(new VerificationBean(str, str2, str3, f9513j, f9512i));
        t9.i.f(W2, "mPortalModel.getVerifiCode(verifiCodeBean)");
        return W2;
    }

    public final Observable V0() {
        String str = f9512i;
        String str2 = f9513j;
        String str3 = f9515l;
        y0 y0Var = y0.f12657a;
        Context context = na.a.f8315a;
        t9.i.f(context, "mContext");
        Observable p10 = B1().p(new CheckGetVipBean(str, str2, str3, y0Var.y(context)));
        t9.i.f(p10, "mPortalModel.checkGetVip(bean)");
        return p10;
    }

    public final Observable V1() {
        String str = f9513j;
        String str2 = f9512i;
        y0 y0Var = y0.f12657a;
        Context context = na.a.f8315a;
        t9.i.f(context, "mContext");
        Observable X = B1().X(new HeartBeatBean(str, str2, y0Var.y(context)));
        t9.i.f(X, "mPortalModel.heartBeat(bean)");
        return X;
    }

    public final Observable W0(String str, String str2, String str3, String str4) {
        t9.i.g(str, "phone");
        t9.i.g(str2, "areaCode");
        t9.i.g(str3, "verificationCode");
        t9.i.g(str4, "type");
        Observable q10 = B1().q(new CheckVerificationBean(str, str2, str3, str4, f9512i, f9513j, ""));
        t9.i.f(q10, "mPortalModel.checkVerifi…on(checkVerificationBean)");
        return q10;
    }

    public final Observable W1(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        LoginBean loginBean;
        String str8 = str6;
        String str9 = str;
        t9.i.g(str, "accountTypes");
        t9.i.g(str3, "userName");
        t9.i.g(str4, "password");
        na.e.f19079e = str3;
        if (t9.i.b(str8, "0")) {
            y0 y0Var = y0.f12657a;
            Context context = na.a.f8315a;
            t9.i.f(context, "mContext");
            loginBean = new LoginBean(str, str2, str3, str4, str6, y0Var.y(context), str5, str7, f9513j);
        } else {
            y0 y0Var2 = y0.f12657a;
            Context context2 = na.a.f8315a;
            t9.i.f(context2, "mContext");
            loginBean = new LoginBean(str, str2, str3, str4, str6, y0Var2.y(context2), str5, str7, (String) null);
        }
        Observable doOnError = B1().Y(loginBean).doOnError(new a(new m(str8)));
        t9.i.f(doOnError, "type: String?, verificat…)\n            }\n        }");
        return doOnError;
    }

    public final Observable X0(int[] iArr) {
        t9.i.g(iArr, "delList");
        Observable r10 = B1().r(new GetDelSubscribe(f9513j, f9512i, iArr));
        t9.i.f(r10, "mPortalModel.delSubscribe(bean)");
        return r10;
    }

    public final Observable Y0(String str) {
        t9.i.g(str, "messageType");
        Observable s10 = B1().s(new DeleteMsgParams(f9512i, str, f9513j));
        t9.i.f(s10, "mPortalModel.deleteMsg(bean)");
        return s10;
    }

    public final Observable Z0(String str) {
        t9.i.g(str, Scopes.EMAIL);
        String a10 = f0.a();
        t9.i.f(a10, "getLanguage()");
        Observable t10 = B1().t(new EmailResetPwdBean(str, a10));
        t9.i.f(t10, "mPortalModel.emailResetPwd(bean)");
        return t10;
    }

    public final Observable Z1(LoginThirdPartBean loginThirdPartBean) {
        t9.i.g(loginThirdPartBean, "bean");
        Observable doOnError = B1().Z(loginThirdPartBean).doOnError(new d(n.f19751a));
        t9.i.f(doOnError, "mPortalModel.loginThirdP…)\n            }\n        }");
        return doOnError;
    }

    public final Observable a1(String str) {
        t9.i.g(str, "exchangeCode");
        Observable u10 = B1().u(new ExchangeBean(f9513j, f9512i, str));
        t9.i.f(u10, "mPortalModel.exchange(bean)");
        return u10;
    }

    public final Observable b1(String str, List list, boolean z10) {
        String str2;
        t9.i.g(str, "type");
        t9.i.g(list, "contentIdList");
        if (z10) {
            str2 = "1";
        } else {
            str2 = "0";
        }
        Observable v10 = B1().v(new GetAddFavorite(f9513j, f9512i, str, list, str2));
        t9.i.f(v10, "mPortalModel.getAddFavorite(bean)");
        return v10;
    }

    public final Observable b2() {
        Observable a02 = B1().a0(new LogoutBean(f9512i, f9513j));
        t9.i.f(a02, "mPortalModel.logout(bean)");
        return a02;
    }

    public final Observable c2(String str, String str2, String str3, String str4) {
        t9.i.g(str, "phone");
        t9.i.g(str2, "areaCode");
        t9.i.g(str3, "verificationCode");
        Observable j10 = B1().j(new BindPhoneBean(str, str2, str3, str4, f9512i, f9513j));
        t9.i.f(j10, "mPortalModel.bindPhone(phoneBind)");
        return j10;
    }

    public final Observable d1() {
        String str = f9513j;
        String str2 = f9512i;
        String str3 = f9515l;
        String a10 = f0.a();
        t9.i.f(a10, "getLanguage()");
        Observable w10 = B1().w(new GetAuthInfoBean(str, str2, "3", str3, a10));
        t9.i.f(w10, "mPortalModel.getAuthInfo(bean)");
        return w10;
    }

    public final Observable d2(String str) {
        t9.i.g(str, "password");
        Observable c02 = B1().c0(new PwdCheckBean(f9513j, f9512i, str));
        t9.i.f(c02, "mPortalModel.pwdCheck(bean)");
        return c02;
    }

    public final Observable e1() {
        Observable x10 = B1().x(new UserBindInfo(f9512i, f9513j));
        t9.i.f(x10, "mPortalModel.getBindInfo(bindUserInfo)");
        return x10;
    }

    public final Observable e2(String str) {
        t9.i.g(str, "qrtoken");
        Observable d02 = B1().d0(new QrGetResultBean("1", str));
        t9.i.f(d02, "mPortalModel.qrGetResult(bean)");
        return d02;
    }

    public final Observable f1(String str) {
        t9.i.g(str, "contentId");
        Observable l10 = B1().l(new GetBlSearchByContentBean(f9513j, f9512i, f9515l, str, "18"));
        t9.i.f(l10, "mPortalModel.blSearchByContent(bean)");
        return l10;
    }

    public final Observable f2() {
        Observable e02 = B1().e0(new QueryMsgNumParams(f9512i, f9513j));
        t9.i.f(e02, "mPortalModel.queryMsgNum(bean)");
        return e02;
    }

    public final Observable g1(int i10, int i11, String str) {
        t9.i.g(str, "messageType");
        Observable y10 = B1().y(new MsgBoxParams(f9512i, i10, i11, str, f9513j));
        t9.i.f(y10, "mPortalModel.getBoxMsg(bean)");
        return y10;
    }

    public final Observable g2(String str, String str2) {
        t9.i.g(str, "messageId");
        t9.i.g(str2, "messageType");
        Observable f02 = B1().f0(new ReadMsgParams(f9512i, str, str2, "1", f9513j));
        t9.i.f(f02, "mPortalModel.readMsg(bean)");
        return f02;
    }

    public final Observable h1(int i10, boolean z10, int i11, int i12) {
        String str;
        if (z10) {
            str = "1";
        } else {
            str = "0";
        }
        Observable z11 = B1().z(new GetColumnContentsBean(f9513j, f9512i, f9515l, Integer.valueOf(i10), str, i11, Integer.valueOf(i12), (Integer) null));
        t9.i.f(z11, "mPortalModel.getColumnContents(bean)");
        return z11;
    }

    public final Observable h2(ResetPwdEmailBean resetPwdEmailBean) {
        t9.i.g(resetPwdEmailBean, "bean");
        Observable g02 = B1().g0(resetPwdEmailBean);
        t9.i.f(g02, "mPortalModel.resetEmailPwd(bean)");
        return g02;
    }

    public final Observable i2(SearchByNameBean searchByNameBean) {
        t9.i.g(searchByNameBean, "bean");
        Observable i02 = B1().i0(searchByNameBean);
        t9.i.f(i02, "mPortalModel.searchByName(bean)");
        return i02;
    }

    public final Observable j1() {
        String g10 = na.a.g();
        t9.i.f(g10, "getPackageName()");
        Observable A2 = B1().A(new ConfigBean("ApkConfig", g10));
        t9.i.f(A2, "mPortalModel.getConfig(bean)");
        return A2;
    }

    public final Observable j2(EmailVerifyCodeBean emailVerifyCodeBean) {
        t9.i.g(emailVerifyCodeBean, "bean");
        Observable j02 = B1().j0(emailVerifyCodeBean);
        t9.i.f(j02, "mPortalModel.sendEmailVerifyCode(bean)");
        return j02;
    }

    public final Observable k1() {
        String g10 = na.a.g();
        t9.i.f(g10, "getPackageName()");
        Observable doOnNext = B1().B(new CustomerService(g10)).doOnNext(new c(h.f19743a));
        t9.i.f(doOnNext, "mPortalModel.getCustomer…      }\n                }");
        return doOnNext;
    }

    public final Observable k2(String str, String str2, String str3, String str4, String str5) {
        t9.i.g(str, "phone");
        t9.i.g(str2, "areaCode");
        t9.i.g(str3, "verificationCode");
        t9.i.g(str4, "type");
        t9.i.g(str5, "password");
        Observable q10 = B1().q(new CheckVerificationBean(str, str2, str3, str4, f9512i, f9513j, str5));
        t9.i.f(q10, "mPortalModel.checkVerifi…on(checkVerificationBean)");
        return q10;
    }

    public final Observable l2(SnTokenBean snTokenBean) {
        t9.i.g(snTokenBean, "bean");
        Observable k02 = B1().k0(snTokenBean);
        t9.i.f(k02, "mPortalModel.snToken(bean)");
        return k02;
    }

    public final String m1() {
        return (String) this.f9530a.getValue();
    }

    public final Observable m2(String str, Integer num, String str2, String str3, String str4, int[] iArr) {
        t9.i.g(str, "columnPlayType");
        t9.i.g(str2, "contentId");
        String str5 = str3;
        t9.i.g(str5, "seriesContentId");
        Observable l02 = B1().l0(new StartPlayVODBean(f9513j, f9512i, f9515l, str4, iArr, str, num, str2, str5, 0));
        t9.i.f(l02, "mPortalModel.startPlayVOD(bean)");
        return l02;
    }

    public final String n1() {
        return (String) this.f9531b.getValue();
    }

    public final Observable n2(UnbindBean unbindBean) {
        t9.i.g(unbindBean, "bean");
        Observable m02 = B1().m0(unbindBean);
        t9.i.f(m02, "mPortalModel.unbind(bean)");
        return m02;
    }

    public final Observable o1(int[] iArr) {
        t9.i.g(iArr, "delList");
        Observable C2 = B1().C(new GetDelFavorite(f9513j, f9512i, iArr));
        t9.i.f(C2, "mPortalModel.getDelFavorite(bean)");
        return C2;
    }

    public final Observable o2() {
        Observable n02 = B1().n0(new UpdateDeviceTokenBean((Integer) null, f9512i, f9513j, (Integer) null, (String) null, (String) null, 57, (t9.g) null));
        t9.i.f(n02, "mPortalModel.updateDeviceToken(bean)");
        return n02;
    }

    public final DomainInfo p1() {
        return (DomainInfo) this.f9532c.getValue();
    }

    public final Observable p2(String str, String str2) {
        t9.i.g(str, "password");
        t9.i.g(str2, "newPwd");
        Observable o02 = B1().o0(new UpdatePwdBean(f9513j, f9512i, str, str2));
        t9.i.f(o02, "mPortalModel.updatePwd(bean)");
        return o02;
    }

    public final Observable q1() {
        Observable D2 = B1().D();
        t9.i.f(D2, "mPortalModel.getEmailSuffix()");
        return D2;
    }

    public final Observable q2(String str, String str2) {
        t9.i.g(str2, Constant.KEY_STATUS);
        Observable p02 = B1().p0(new UpdateRestrictBean(f9513j, f9512i, str, str2));
        t9.i.f(p02, "mPortalModel.updateRestrict(bean)");
        return p02;
    }

    public final oa.b r1() {
        return A1();
    }

    public final Observable r2(String str, String str2, String str3, String str4, String str5, String str6) {
        t9.i.g(str, "type");
        t9.i.g(str2, "programName");
        t9.i.g(str3, Scopes.EMAIL);
        String str7 = f9514k;
        String str8 = f9512i;
        String str9 = f9517n;
        String g10 = na.a.g();
        String str10 = g10;
        String valueOf = String.valueOf(na.a.b());
        t9.i.f(g10, "getPackageName()");
        UserFeedBean userFeedBean = r0;
        UserFeedBean userFeedBean2 = new UserFeedBean(str, str4, str5, str10, str9, str8, str2, (String) null, (String) null, (String) null, (String) null, str7, str6, str3, (String) null, valueOf, 18304, (t9.g) null);
        Observable q02 = B1().q0(userFeedBean);
        t9.i.f(q02, "mPortalModel.userFeedBack(bean)");
        return q02;
    }

    public final Observable s1() {
        Observable E2 = B1().E(new ExchangeCodeBean(f9512i, f9513j, (String) null, 4, (t9.g) null));
        t9.i.f(E2, "mPortalModel.getExchangeCode(bean)");
        return E2;
    }

    public final Observable s2(String str, String str2, String str3, String str4) {
        t9.i.g(str, "programName");
        t9.i.g(str2, "tvModel");
        t9.i.g(str3, "screenType");
        t9.i.g(str4, "definition");
        String str5 = f9514k;
        String str6 = f9512i;
        String str7 = f9517n;
        String g10 = na.a.g();
        String valueOf = String.valueOf(na.a.b());
        t9.i.f(g10, "getPackageName()");
        UserFeedBean userFeedBean = r0;
        UserFeedBean userFeedBean2 = new UserFeedBean(MessageService.MSG_ACCS_NOTIFY_CLICK, (String) null, (String) null, g10, str7, str6, str, (String) null, str2, str3, str4, str5, (String) null, (String) null, (String) null, valueOf, 28806, (t9.g) null);
        Observable q02 = B1().q0(userFeedBean);
        t9.i.f(q02, "mPortalModel.userFeedBack(bean)");
        return q02;
    }

    public final Observable t1() {
        Observable F2 = B1().F(new GetExchangeOrderBean(f9512i, f9513j));
        t9.i.f(F2, "mPortalModel.getExchangeOrderInfo(bean)");
        return F2;
    }

    public final Observable t2(String str) {
        t9.i.g(str, "qrtoken");
        Observable r02 = B1().r0(new WaitConfirmBean(str));
        t9.i.f(r02, "mPortalModel.waitConfirm(bean)");
        return r02;
    }

    public final Observable u1(String str, String str2) {
        t9.i.g(str, "queryType");
        t9.i.g(str2, "blFlag");
        Observable G2 = B1().G(new GetFavorite(f9513j, f9512i, f9515l, str, str2));
        t9.i.f(G2, "mPortalModel.getFavorite(bean)");
        return G2;
    }

    public final Observable w1() {
        Observable H2 = B1().H(new FreeTimeBean(f9513j, f9512i, f9515l));
        t9.i.f(H2, "mPortalModel.getFree(bean)");
        return H2;
    }

    public final Observable x1(String str, String str2) {
        t9.i.g(str, "version");
        t9.i.g(str2, "freeVersion");
        Observable I2 = B1().I(new GetHomeBean(f9515l + "_Recommended", str, f9515l + "_free", str2, f9512i, f9513j, f9515l));
        t9.i.f(I2, "mPortalModel.getHome(bean)");
        return I2;
    }

    public final Observable y1(String str, String str2, String str3, String str4) {
        t9.i.g(str, "contentId");
        t9.i.g(str2, "type");
        t9.i.g(str3, "sortType");
        t9.i.g(str4, "language");
        Observable J2 = B1().J(new GetItemDataBean(f9513j, f9512i, f9515l, str, str2, str3, str4));
        t9.i.f(J2, "mPortalModel.getItemData(bean)");
        return J2;
    }

    public final Observable z1(int i10, String str, String str2) {
        Observable K2 = B1().K(new GetLiveDataBean(f9513j, f9512i, f9515l, i10, str, str2, 1, 3000));
        t9.i.f(K2, "mPortalModel.getLiveData(bean)");
        return K2;
    }
}
