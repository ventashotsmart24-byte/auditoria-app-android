package l6;

import android.content.Context;
import com.mobile.brasiltv.db.Album;
import com.mobile.brasiltv.db.VodDao;
import com.mobile.brasiltv.mine.activity.LoginAty;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.utils.f1;
import com.mobile.brasiltv.utils.x;
import com.mobile.brasiltv.utils.y;
import h9.t;
import i9.r;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import j6.i;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import mobile.com.requestframe.utils.response.AuthInfo;
import mobile.com.requestframe.utils.response.FreeProduct;
import mobile.com.requestframe.utils.response.GetAuthInfoData;
import mobile.com.requestframe.utils.response.GetAuthInfoResult;
import mobile.com.requestframe.utils.response.GiftDaysData;
import mobile.com.requestframe.utils.response.GiftDaysResult;
import mobile.com.requestframe.utils.response.MsgNumData;
import mobile.com.requestframe.utils.response.MsgNumResult;
import mobile.com.requestframe.utils.response.PropertiesInfoData;
import mobile.com.requestframe.utils.response.PropertiesInfoResult;
import mobile.com.requestframe.utils.response.UpdateRestrictResult;
import s9.l;
import t9.j;
import w6.i;

public final class m1 implements l5.a {

    /* renamed from: a  reason: collision with root package name */
    public final b6.f f18520a;

    /* renamed from: b  reason: collision with root package name */
    public final i f18521b;

    /* renamed from: c  reason: collision with root package name */
    public VodDao f18522c;

    public static final class a extends ha.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ m1 f18523a;

        /* renamed from: l6.m1$a$a  reason: collision with other inner class name */
        public static final class C0267a extends j implements l {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f18524a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C0267a(String str) {
                super(1);
                this.f18524a = str;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return t.f17319a;
            }

            public final void invoke(String str) {
                f1.f12517a.x(y.p(y.f12639a, this.f18524a, (String) null, (String) null, 6, (Object) null));
            }
        }

        public a(m1 m1Var) {
            this.f18523a = m1Var;
        }

        /* renamed from: f */
        public void onNext(MsgNumResult msgNumResult) {
            int i10;
            t9.i.g(msgNumResult, "t");
            v5.g gVar = v5.g.f19670a;
            MsgNumData data = msgNumResult.getData();
            int i11 = 0;
            if (data != null) {
                i10 = data.getSysNum();
            } else {
                i10 = 0;
            }
            gVar.w(i10);
            MsgNumData data2 = msgNumResult.getData();
            if (data2 != null) {
                i11 = data2.getActNum();
            }
            gVar.q(i11);
            int m10 = gVar.m();
            if (m10 <= 0) {
                this.f18523a.o().x2();
            } else {
                this.f18523a.o().A2(m10);
            }
        }

        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            Context context = this.f18523a.l().getContext();
            if (context != null) {
                x.f12622a.w(context, new C0267a(str));
            }
        }
    }

    public static final class b extends ha.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ m1 f18525a;

        public static final class a extends j implements l {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f18526a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(String str) {
                super(1);
                this.f18526a = str;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return t.f17319a;
            }

            public final void invoke(String str) {
                f1.f12517a.x(y.p(y.f12639a, this.f18526a, (String) null, (String) null, 6, (Object) null));
            }
        }

        public b(m1 m1Var) {
            this.f18525a = m1Var;
        }

        /* renamed from: f */
        public void onNext(GiftDaysResult giftDaysResult) {
            t9.i.g(giftDaysResult, "t");
            if (giftDaysResult.getData() != null) {
                GiftDaysData data = giftDaysResult.getData();
                t9.i.d(data);
                List<FreeProduct> freeProductList = data.getFreeProductList();
                m1 m1Var = this.f18525a;
                for (FreeProduct freeProduct : freeProductList) {
                    String productCode = freeProduct.getProductCode();
                    GiftDaysData data2 = giftDaysResult.getData();
                    t9.i.d(data2);
                    if (t9.i.b(productCode, data2.getProductCode())) {
                        k7.f.e("绑定邮箱赠送时长请求成功，" + freeProduct.getPreAuthDays(), new Object[0]);
                        w6.i.f9510g.m0(freeProduct.getPreAuthDays());
                        m1Var.o().x1();
                        if (na.f.c(m1Var.l().getContext(), "keyShowGiftDaysDialog", true)) {
                            m1Var.o().s0();
                        }
                    }
                }
            }
        }

        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            Context context = this.f18525a.l().getContext();
            if (context != null) {
                x.f12622a.w(context, new a(str));
            }
        }
    }

    public static final class c extends ha.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ m1 f18527a;

        public static final class a extends j implements l {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f18528a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(String str) {
                super(1);
                this.f18528a = str;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return t.f17319a;
            }

            public final void invoke(String str) {
                f1.f12517a.x(y.p(y.f12639a, this.f18528a, (String) null, (String) null, 6, (Object) null));
            }
        }

        public c(m1 m1Var) {
            this.f18527a = m1Var;
        }

        /* renamed from: f */
        public void onNext(PropertiesInfoResult propertiesInfoResult) {
            t9.i.g(propertiesInfoResult, "t");
            PropertiesInfoData data = propertiesInfoResult.getData();
            if (data != null) {
                i.c cVar = w6.i.f9510g;
                String customerEmail = data.getCustomerEmail();
                String str = "";
                if (customerEmail == null) {
                    customerEmail = str;
                }
                cVar.Z(customerEmail);
                String shareLinkUrl = data.getShareLinkUrl();
                if (shareLinkUrl != null) {
                    str = shareLinkUrl;
                }
                cVar.s0(str);
            }
        }

        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            Context context = this.f18527a.l().getContext();
            if (context != null) {
                x.f12622a.w(context, new a(str));
            }
        }
    }

    public static final class d extends j implements l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ m1 f18529a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(m1 m1Var) {
            super(1);
            this.f18529a = m1Var;
        }

        public final void b(List list) {
            t9.i.f(list, "it");
            if (!list.isEmpty()) {
                this.f18529a.o().F(list);
                return;
            }
            k7.f.c("无历史记录，不展示", new Object[0]);
            this.f18529a.o().l();
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            b((List) obj);
            return t.f17319a;
        }
    }

    public static final class e extends j implements l {

        /* renamed from: a  reason: collision with root package name */
        public static final e f18530a = new e();

        public e() {
            super(1);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Throwable) obj);
            return t.f17319a;
        }

        public final void invoke(Throwable th) {
            k7.f.d("查询历史数据失败!", new Object[0]);
            th.printStackTrace();
        }
    }

    public static final class f implements Comparator {
        public final int compare(Object obj, Object obj2) {
            return j9.a.a(((Album) obj2).getSaveTime(), ((Album) obj).getSaveTime());
        }
    }

    public static final class g extends ha.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ m1 f18531a;

        public static final class a extends j implements l {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ GetAuthInfoResult f18532a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(GetAuthInfoResult getAuthInfoResult) {
                super(1);
                this.f18532a = getAuthInfoResult;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return t.f17319a;
            }

            public final void invoke(String str) {
                y yVar = y.f12639a;
                String returnCode = this.f18532a.getReturnCode();
                t9.i.d(returnCode);
                f1.f12517a.x(y.p(yVar, returnCode, (String) null, (String) null, 6, (Object) null));
            }
        }

        public static final class b extends j implements l {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f18533a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public b(String str) {
                super(1);
                this.f18533a = str;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return t.f17319a;
            }

            public final void invoke(String str) {
                f1.f12517a.x(y.p(y.f12639a, this.f18533a, (String) null, (String) null, 6, (Object) null));
            }
        }

        public g(m1 m1Var) {
            this.f18531a = m1Var;
        }

        /* renamed from: f */
        public void onNext(GetAuthInfoResult getAuthInfoResult) {
            List<AuthInfo> list;
            int i10;
            t9.i.g(getAuthInfoResult, "t");
            b0.U(this, "获取授权信息成功，result: " + getAuthInfoResult);
            int i11 = 0;
            if (t9.i.b(getAuthInfoResult.getReturnCode(), "aaa100028")) {
                k7.f.f("授权信息接口，needToReLogin", new Object[0]);
                b0.a0(this.f18531a.l(), LoginAty.class);
            } else if (b0.T(getAuthInfoResult.getReturnCode(), "aaa100027")) {
                Context context = this.f18531a.l().getContext();
                if (context != null) {
                    x.f12622a.w(context, new a(getAuthInfoResult));
                }
            } else {
                if (getAuthInfoResult.getData() != null) {
                    i.c cVar = w6.i.f9510g;
                    GetAuthInfoData data = getAuthInfoResult.getData();
                    t9.i.d(data);
                    cVar.t0(data.getShowFlag());
                    GetAuthInfoData data2 = getAuthInfoResult.getData();
                    t9.i.d(data2);
                    cVar.T(data2.getBindMail());
                    GetAuthInfoData data3 = getAuthInfoResult.getData();
                    t9.i.d(data3);
                    cVar.g0(data3.getHasPay());
                    GetAuthInfoData data4 = getAuthInfoResult.getData();
                    t9.i.d(data4);
                    cVar.h0(data4.getHasPwd());
                    GetAuthInfoData data5 = getAuthInfoResult.getData();
                    t9.i.d(data5);
                    cVar.y0(data5.getUserIdentity());
                    GetAuthInfoData data6 = getAuthInfoResult.getData();
                    t9.i.d(data6);
                    String childLockPwd = data6.getChildLockPwd();
                    String str = "";
                    if (childLockPwd == null) {
                        childLockPwd = str;
                    }
                    cVar.W(childLockPwd);
                    GetAuthInfoData data7 = getAuthInfoResult.getData();
                    t9.i.d(data7);
                    Integer remainingDays = data7.getRemainingDays();
                    if (remainingDays != null) {
                        i10 = remainingDays.intValue();
                    } else {
                        i10 = 0;
                    }
                    cVar.p0(i10);
                    GetAuthInfoData data8 = getAuthInfoResult.getData();
                    t9.i.d(data8);
                    Integer expRemainingDays = data8.getExpRemainingDays();
                    if (expRemainingDays != null) {
                        i11 = expRemainingDays.intValue();
                    }
                    cVar.c0(i11);
                    GetAuthInfoData data9 = getAuthInfoResult.getData();
                    t9.i.d(data9);
                    String qrcodeMessage = data9.getQrcodeMessage();
                    if (qrcodeMessage == null) {
                        qrcodeMessage = str;
                    }
                    cVar.o0(qrcodeMessage);
                    GetAuthInfoData data10 = getAuthInfoResult.getData();
                    t9.i.d(data10);
                    String playlistUrl = data10.getPlaylistUrl();
                    if (playlistUrl != null) {
                        str = playlistUrl;
                    }
                    cVar.k0(str);
                }
                d6.b bVar = d6.b.f6366a;
                GetAuthInfoData data11 = getAuthInfoResult.getData();
                if (data11 != null) {
                    list = data11.getAuthInfoList();
                } else {
                    list = null;
                }
                bVar.B(list);
                this.f18531a.o().l1();
            }
        }

        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            Context context = this.f18531a.l().getContext();
            if (context != null) {
                x.f12622a.w(context, new b(str));
            }
        }
    }

    public static final class h extends ha.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ m1 f18534a;

        public static final class a extends j implements l {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f18535a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(String str) {
                super(1);
                this.f18535a = str;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return t.f17319a;
            }

            public final void invoke(String str) {
                f1.f12517a.x(y.p(y.f12639a, this.f18535a, (String) null, (String) null, 6, (Object) null));
            }
        }

        public h(m1 m1Var) {
            this.f18534a = m1Var;
        }

        /* renamed from: f */
        public void onNext(UpdateRestrictResult updateRestrictResult) {
            t9.i.g(updateRestrictResult, "t");
            k7.f.e("更新限制级状态成功，关闭", new Object[0]);
            this.f18534a.o().showLoading(false);
        }

        public void onSubscribe(Disposable disposable) {
            t9.i.g(disposable, "d");
            super.onSubscribe(disposable);
            this.f18534a.o().showLoading(true);
        }

        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            this.f18534a.o().showLoading(false);
            Context context = this.f18534a.l().getContext();
            if (context != null) {
                x.f12622a.w(context, new a(str));
            }
        }
    }

    public m1(b6.f fVar, j6.i iVar) {
        t9.i.g(fVar, "frag");
        t9.i.g(iVar, "view");
        this.f18520a = fVar;
        this.f18521b = iVar;
        Context requireContext = fVar.requireContext();
        t9.i.f(requireContext, "frag.requireContext()");
        this.f18522c = new VodDao(requireContext);
    }

    public static final void r(m1 m1Var, ObservableEmitter observableEmitter) {
        t9.i.g(m1Var, "this$0");
        t9.i.g(observableEmitter, "it");
        List queryAllRecord = m1Var.f18522c.queryAllRecord();
        if (!queryAllRecord.isEmpty()) {
            List C = r.C(queryAllRecord, new f());
            if (!C.isEmpty()) {
                queryAllRecord = new ArrayList(C);
            }
        }
        observableEmitter.onNext(queryAllRecord);
    }

    public static final void s(l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void t(l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public void e() {
        m();
        n();
    }

    public void g() {
        this.f18521b.showLoading(false);
    }

    public void k() {
        boolean z10;
        String l10 = d6.b.f6366a.l();
        if (l10 == null || l10.length() == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10) {
            w6.i.f9510g.b().f2().compose(this.f18520a.O2()).subscribe(new a(this));
        }
    }

    public final b6.f l() {
        return this.f18520a;
    }

    public final void m() {
        i.c cVar = w6.i.f9510g;
        if (t9.i.b(cVar.I(), "1") && t9.i.b(cVar.e(), "1")) {
            cVar.b().P0().compose(this.f18520a.O2()).subscribe(new b(this));
        }
    }

    public final void n() {
        w6.i.f9510g.b().G1().compose(this.f18520a.O2()).subscribe(new c(this));
    }

    public final j6.i o() {
        return this.f18521b;
    }

    public void p() {
        boolean z10;
        String l10 = d6.b.f6366a.l();
        boolean z11 = false;
        if (l10 == null || l10.length() == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10) {
            StringBuilder sb = new StringBuilder();
            sb.append("coupon num is ");
            v5.g gVar = v5.g.f19670a;
            sb.append(gVar.l());
            b0.U(this, sb.toString());
            j6.i iVar = this.f18521b;
            if (gVar.l() != 0) {
                z11 = true;
            }
            iVar.t1(z11);
        }
    }

    public void q() {
        Observable.create(new j1(this)).compose(this.f18520a.O2()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new k1(new d(this)), new l1(e.f18530a));
    }

    public void u() {
        boolean z10;
        String l10 = d6.b.f6366a.l();
        if (l10 == null || l10.length() == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10) {
            w6.i.f9510g.b().d1().compose(this.f18520a.O2()).subscribe(new g(this));
        }
    }

    public void v() {
        w6.i.f9510g.b().q2((String) null, "0").subscribe(new h(this));
    }
}
