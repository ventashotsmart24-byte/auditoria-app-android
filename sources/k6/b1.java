package k6;

import android.app.Activity;
import android.app.Dialog;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import anet.channel.util.Utils;
import b6.z;
import c2.i;
import com.dcs.bean.DomainInfo;
import com.google.android.gms.cast.framework.CastContext;
import com.google.android.gms.cast.framework.SessionManager;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.dynamiclinks.PendingDynamicLinkData;
import com.google.firebase.dynamiclinks.ktx.FirebaseDynamicLinksKt;
import com.google.firebase.ktx.Firebase;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mobile.bean.UpdateBean;
import com.mobile.brasiltv.activity.MainAty;
import com.mobile.brasiltv.app.App;
import com.mobile.brasiltv.bean.MainTabEntity;
import com.mobile.brasiltv.bean.MemberInfo;
import com.mobile.brasiltv.bean.RootColumnId;
import com.mobile.brasiltv.bean.event.CancelFreezeAtyEvent;
import com.mobile.brasiltv.bean.event.CastToCloseOtherPlayEvent;
import com.mobile.brasiltv.bean.event.CloseForcePageEvent;
import com.mobile.brasiltv.bean.event.GetFreeTimeEvent;
import com.mobile.brasiltv.bean.event.HasNewUpdateEvent;
import com.mobile.brasiltv.bean.event.HomePageAdEvent;
import com.mobile.brasiltv.bean.event.InterstitialEvent;
import com.mobile.brasiltv.bean.event.LoginSuccessEvent;
import com.mobile.brasiltv.bean.event.RequestActiveEvent;
import com.mobile.brasiltv.bean.event.RequestAuthAndSlbEvent;
import com.mobile.brasiltv.bean.event.UpdateMineViewEvent;
import com.mobile.brasiltv.bean.event.UpdateRestrictEvent;
import com.mobile.brasiltv.db.MobileDao;
import com.mobile.brasiltv.db.SwitchAccountBean;
import com.mobile.brasiltv.mine.activity.ForceChangePwdAty;
import com.mobile.brasiltv.mine.activity.LoginAty;
import com.mobile.brasiltv.service.NetService;
import com.mobile.brasiltv.utils.CheckNoticeUtils;
import com.mobile.brasiltv.utils.f1;
import com.mobile.brasiltv.utils.i1;
import com.mobile.brasiltv.utils.n0;
import com.mobile.brasiltv.utils.y0;
import com.mobile.brasiltv.view.NoticeDialog;
import com.mobile.brasiltv.view.dialog.DialogManager;
import com.mobile.brasiltv.view.dialog.NumberLimitDialog;
import com.mobile.brasiltv.view.dialog.VersionForbiddenDialog;
import com.msandroid.mobile.R;
import com.taobao.accs.common.Constants;
import com.titans.entity.CdnType;
import com.umeng.analytics.pro.bt;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import mobile.com.requestframe.utils.bean.LoginThirdPartBean;
import mobile.com.requestframe.utils.bean.SnTokenBean;
import mobile.com.requestframe.utils.response.ActiveResult;
import mobile.com.requestframe.utils.response.ApkQueryCouponResult;
import mobile.com.requestframe.utils.response.AuthInfo;
import mobile.com.requestframe.utils.response.BaseResult;
import mobile.com.requestframe.utils.response.CheckForceBindResult;
import mobile.com.requestframe.utils.response.ChildColumnList;
import mobile.com.requestframe.utils.response.ColumnContentsBean;
import mobile.com.requestframe.utils.response.CouponCodeList;
import mobile.com.requestframe.utils.response.ForceBindData;
import mobile.com.requestframe.utils.response.FreeResult;
import mobile.com.requestframe.utils.response.GetAuthInfoData;
import mobile.com.requestframe.utils.response.GetAuthInfoResult;
import mobile.com.requestframe.utils.response.GetHomeData;
import mobile.com.requestframe.utils.response.GetHomeResult;
import mobile.com.requestframe.utils.response.HomeRecommend;
import mobile.com.requestframe.utils.response.LoginResult;
import mobile.com.requestframe.utils.response.PortalCodeList;
import mobile.com.requestframe.utils.response.QueryCouponData;
import mobile.com.requestframe.utils.response.SnTokenData;
import mobile.com.requestframe.utils.response.SnTokenResult;
import mobile.com.requestframe.utils.response.ThirdPartResult;
import mobile.com.requestframe.utils.response.UserData;
import w6.i;

public final class b1 implements i6.u {

    /* renamed from: a  reason: collision with root package name */
    public final f5.c f7502a;

    /* renamed from: b  reason: collision with root package name */
    public final i6.v f7503b;

    /* renamed from: c  reason: collision with root package name */
    public final String f7504c = "MainPresenter";

    /* renamed from: d  reason: collision with root package name */
    public boolean f7505d;

    /* renamed from: e  reason: collision with root package name */
    public Disposable f7506e;

    /* renamed from: f  reason: collision with root package name */
    public NoticeDialog f7507f;

    /* renamed from: g  reason: collision with root package name */
    public final h9.g f7508g = h9.h.b(b.f17589a);

    /* renamed from: h  reason: collision with root package name */
    public final h9.g f7509h = h9.h.b(c.f17592a);

    /* renamed from: i  reason: collision with root package name */
    public long f7510i;

    /* renamed from: j  reason: collision with root package name */
    public final h9.g f7511j = h9.h.b(w.f17636a);

    /* renamed from: k  reason: collision with root package name */
    public boolean f7512k = true;

    /* renamed from: l  reason: collision with root package name */
    public HashMap f7513l;

    /* renamed from: m  reason: collision with root package name */
    public BroadcastReceiver f7514m;

    /* renamed from: n  reason: collision with root package name */
    public Integer f7515n;

    public static final class a extends ha.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b1 f17585a;

        /* renamed from: k6.b1$a$a  reason: collision with other inner class name */
        public static final class C0238a extends t9.j implements s9.l {

            /* renamed from: a  reason: collision with root package name */
            public static final C0238a f17586a = new C0238a();

            public C0238a() {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return h9.t.f17319a;
            }

            public final void invoke(String str) {
                f1.f12517a.x(com.mobile.brasiltv.utils.y.p(com.mobile.brasiltv.utils.y.f12639a, "CUSTOM_NO_ASSOCIATED_PORTAL", (String) null, (String) null, 6, (Object) null));
            }
        }

        public static final class b extends t9.j implements s9.l {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f17587a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public b(String str) {
                super(1);
                this.f17587a = str;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return h9.t.f17319a;
            }

            public final void invoke(String str) {
                com.mobile.brasiltv.utils.y yVar = com.mobile.brasiltv.utils.y.f12639a;
                f1.f12517a.x(com.mobile.brasiltv.utils.y.p(yVar, this.f17587a, yVar.a(), (String) null, 4, (Object) null));
            }
        }

        public a(b1 b1Var) {
            this.f17585a = b1Var;
        }

        /* renamed from: f */
        public void onNext(ActiveResult activeResult) {
            List<PortalCodeList> list;
            boolean z10;
            boolean z11;
            t9.i.g(activeResult, "t");
            super.onNext(activeResult);
            UserData data = activeResult.getData();
            String str = null;
            if (data != null) {
                list = data.getPortalCodeList();
            } else {
                list = null;
            }
            if (com.mobile.brasiltv.utils.b0.I(list)) {
                i.c cVar = w6.i.f9510g;
                if (!t9.i.b(cVar.A(), "")) {
                    UserData data2 = activeResult.getData();
                    t9.i.d(data2);
                    if (!t9.i.b(data2.getRestrictedStatus(), cVar.A())) {
                        xa.c c10 = xa.c.c();
                        UserData data3 = activeResult.getData();
                        t9.i.d(data3);
                        c10.m(new UpdateRestrictEvent(data3.getRestrictedStatus(), false, 2, (t9.g) null));
                    }
                }
                d6.b bVar = d6.b.f6366a;
                f5.c t02 = this.f17585a.t0();
                UserData data4 = activeResult.getData();
                t9.i.d(data4);
                d6.b.G(bVar, t02, data4, "", "", (String) null, (String) null, (String) null, false, 240, (Object) null);
                if (TextUtils.isEmpty(cVar.E())) {
                    if (cVar.F().length() > 0) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    if (z11) {
                        i1.G(this.f17585a.t0(), CdnType.DIGITAL_TYPE_PEERSTAR, "6:2");
                    }
                }
                b1 b1Var = this.f17585a;
                String H = cVar.H();
                if (cVar.F().length() > 0) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                b1Var.d1(H, z10);
                this.f17585a.e1();
                xa.c c11 = xa.c.c();
                UserData data5 = activeResult.getData();
                if (data5 != null) {
                    str = data5.getHeartBeatTime();
                }
                c11.j(new LoginSuccessEvent(str));
                xa.c.c().j(new CancelFreezeAtyEvent());
                s6.a aVar = s6.a.f9335a;
                if (aVar.a().u()) {
                    LoginAty.C.a(this.f17585a.t0(), false, true);
                    return;
                }
                this.f17585a.a0(activeResult.getData());
                this.f17585a.h0();
                this.f17585a.M0();
                this.f17585a.L0();
                this.f17585a.q0(activeResult.getData());
                if (aVar.a().q()) {
                    this.f17585a.f0(activeResult.getData());
                }
                this.f17585a.S0();
                d6.a.f16338a.k();
                return;
            }
            com.mobile.brasiltv.utils.x.f12622a.w(this.f17585a.t0(), C0238a.f17586a);
        }

        public void onSubscribe(Disposable disposable) {
            t9.i.g(disposable, "d");
            super.onSubscribe(disposable);
            this.f17585a.f7506e = disposable;
        }

        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            xa.c.c().j(new CancelFreezeAtyEvent());
            if (t9.i.b("portal200001", str)) {
                MainAty.A.r(true);
                com.mobile.brasiltv.utils.b0.S(new VersionForbiddenDialog(this.f17585a.t0()), DialogManager.DIALOG_VERSION_FORBIDDEN);
                return;
            }
            if (t9.i.b("aaa100080", str)) {
                i.c cVar = w6.i.f9510g;
                cVar.u0("");
                cVar.a0("");
                cVar.w0("");
                y0.f12657a.N(this.f17585a.t0());
            } else if (t9.i.b("aaa100094", str)) {
                new NumberLimitDialog(this.f17585a.t0()).show();
                return;
            }
            com.mobile.brasiltv.utils.x.f12622a.w(this.f17585a.t0(), new b(str));
        }
    }

    public static final class a0 extends ha.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b1 f17588a;

        public a0(b1 b1Var) {
            this.f17588a = b1Var;
        }

        /* renamed from: f */
        public void onNext(CheckForceBindResult checkForceBindResult) {
            String str;
            Integer num;
            Integer num2;
            t9.i.g(checkForceBindResult, "t");
            if (t9.i.b(checkForceBindResult.getReturnCode(), "0") && checkForceBindResult.getData() != null) {
                ForceBindData data = checkForceBindResult.getData();
                Integer num3 = null;
                if (data != null) {
                    str = data.getBindMethod();
                } else {
                    str = null;
                }
                if (t9.i.b(Scopes.EMAIL, str)) {
                    ForceBindData data2 = checkForceBindResult.getData();
                    if (data2 != null) {
                        num = data2.getFreeBindTime();
                    } else {
                        num = null;
                    }
                    if (num != null) {
                        ForceBindData data3 = checkForceBindResult.getData();
                        if (data3 != null) {
                            num2 = data3.getFreeBindTime();
                        } else {
                            num2 = null;
                        }
                        t9.i.d(num2);
                        if (num2.intValue() > 0) {
                            b1 b1Var = this.f17588a;
                            ForceBindData data4 = checkForceBindResult.getData();
                            if (data4 != null) {
                                num3 = data4.getFreeBindTime();
                            }
                            t9.i.d(num3);
                            b1Var.b0(num3.intValue());
                            return;
                        }
                    }
                    b1.e0(this.f17588a, true, 0, 2, (Object) null);
                }
            }
        }

        public void onSubscribe(Disposable disposable) {
            t9.i.g(disposable, "d");
            super.onSubscribe(disposable);
        }

        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
        }
    }

    public static final class b extends t9.j implements s9.a {

        /* renamed from: a  reason: collision with root package name */
        public static final b f17589a = new b();

        public b() {
            super(0);
        }

        public final String invoke() {
            return na.f.f(na.a.f8315a, "key_user_id", "");
        }
    }

    public static final class b0 extends v2.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b1 f17590a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f17591b;

        public b0(b1 b1Var, boolean z10) {
            this.f17590a = b1Var;
            this.f17591b = z10;
        }

        public void b(String str) {
            t9.i.g(str, "returnCode");
            c2.i.f4633q.a().i(na.e.f19078d);
            String o10 = com.mobile.brasiltv.utils.y.f12639a.o(str, "v1", "EA6");
            if (!ba.t.o(o10, "EA6", false, 2, (Object) null)) {
                f1.f12517a.x(o10);
            } else if (!this.f17591b) {
                f1.f12517a.q(this.f17590a.t0(), o10);
            }
        }

        /* renamed from: c */
        public void onNext(String str) {
            t9.i.g(str, "t");
            na.e.f19078d = str;
            na.f.k(this.f17590a.t0(), "realtime_dcs", String.valueOf(SystemClock.elapsedRealtime()));
            c2.i.f4633q.a().i(na.e.f19078d);
            s1.m.f9270a.f0(Long.valueOf(i2.h.f7019a.a()));
            if (!this.f17591b) {
                this.f17590a.R0();
                this.f17590a.F0();
            }
        }
    }

    public static final class c extends t9.j implements s9.a {

        /* renamed from: a  reason: collision with root package name */
        public static final c f17592a = new c();

        public c() {
            super(0);
        }

        public final String invoke() {
            return na.f.f(na.a.f8315a, "key_user_identity", "");
        }
    }

    public static final class c0 extends t9.j implements s9.l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b1 f17593a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c0(b1 b1Var) {
            super(1);
            this.f17593a = b1Var;
        }

        public final void b(SwitchAccountBean switchAccountBean) {
            com.mobile.brasiltv.utils.b0.U(this.f17593a, "增加账号记录成功！");
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            b((SwitchAccountBean) obj);
            return h9.t.f17319a;
        }
    }

    public static final class d implements v1.b {
        public void a(String str, boolean z10) {
            t9.i.g(str, "adType");
            a6.a aVar = a6.a.f10646a;
            if (t9.i.b(str, aVar.i())) {
                xa.c.c().m(new HomePageAdEvent());
            } else if (t9.i.b(str, aVar.d())) {
                xa.c.c().m(new InterstitialEvent());
            }
        }

        public void b(boolean z10) {
        }
    }

    public static final class d0 extends t9.j implements s9.l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b1 f17594a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d0(b1 b1Var) {
            super(1);
            this.f17594a = b1Var;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Throwable) obj);
            return h9.t.f17319a;
        }

        public final void invoke(Throwable th) {
            com.mobile.brasiltv.utils.b0.U(this.f17594a, "增加账号记录失败！");
        }
    }

    public static final class e extends t9.j implements s9.l {

        /* renamed from: a  reason: collision with root package name */
        public static final e f17595a = new e();

        public e() {
            super(1);
        }

        /* renamed from: b */
        public final Boolean invoke(CheckNoticeUtils.NoteInfo noteInfo) {
            t9.i.g(noteInfo, "noteInfo");
            return Boolean.valueOf(!TextUtils.isEmpty(noteInfo.getInfo()));
        }
    }

    public static final class e0 extends t9.j implements s9.l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b1 f17596a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e0(b1 b1Var) {
            super(1);
            this.f17596a = b1Var;
        }

        /* renamed from: b */
        public final String invoke(String str) {
            String str2;
            String str3;
            Object obj;
            Object obj2;
            String str4 = str;
            t9.i.g(str4, "it");
            this.f17596a.m0();
            this.f17596a.Y0();
            this.f17596a.c0();
            na.c.d();
            Pair b10 = m7.c.b();
            if (b10 == null || (obj2 = b10.first) == null || (str2 = obj2.toString()) == null) {
                str2 = b2.a.f4205g;
            }
            if (b10 == null || (obj = b10.second) == null || (str3 = obj.toString()) == null) {
                str3 = b2.a.f4205g;
            }
            t2.a aVar = t2.a.f9350a;
            t9.i.f(str2, "bbMainDomain");
            t9.i.f(str3, "bbSecondDomain");
            DomainInfo b11 = aVar.b(str2, str3, "key_tdc");
            i.b bVar = c2.i.f4633q;
            bVar.a().u();
            c2.i a10 = bVar.a();
            String g10 = na.a.g();
            t9.i.f(g10, "getPackageName()");
            int b12 = na.a.b();
            String str5 = Build.VERSION.RELEASE;
            t9.i.f(str5, "RELEASE");
            String y10 = y0.f12657a.y(this.f17596a.t0());
            String str6 = na.c.f19073a;
            t9.i.f(str6, "reserve1");
            i.c cVar = w6.i.f9510g;
            c2.i.A(a10, false, b11, g10, b12, str5, y10, str6, cVar.E(), cVar.l(), MemberInfo.INSTANCE.getLastUserName(), false, 1024, (Object) null);
            this.f17596a.l0();
            this.f17596a.W0();
            this.f17596a.U0();
            if (Build.VERSION.SDK_INT < 31) {
                s6.a.f9335a.a().a();
            }
            return str4;
        }
    }

    public static final class f extends t9.j implements s9.l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b1 f17597a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(b1 b1Var) {
            super(1);
            this.f17597a = b1Var;
        }

        public final void b(CheckNoticeUtils.NoteInfo noteInfo) {
            if (noteInfo.getShowModel() == 2) {
                b1 b1Var = this.f17597a;
                f5.c t02 = this.f17597a.t0();
                t9.i.e(t02, "null cannot be cast to non-null type android.app.Activity");
                String info = noteInfo.getInfo();
                t9.i.f(info, "noteInfo.info");
                b1Var.f7507f = new NoticeDialog(t02, info);
                NoticeDialog G = this.f17597a.f7507f;
                t9.i.d(G);
                com.mobile.brasiltv.utils.b0.S(G, DialogManager.DIALOG_NOTICE);
                return;
            }
            i6.v G0 = this.f17597a.G0();
            String info2 = noteInfo.getInfo();
            t9.i.f(info2, "noteInfo.info");
            G0.s2(info2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            b((CheckNoticeUtils.NoteInfo) obj);
            return h9.t.f17319a;
        }
    }

    public static final class f0 extends t9.j implements s9.l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b1 f17598a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f0(b1 b1Var) {
            super(1);
            this.f17598a = b1Var;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((String) obj);
            return h9.t.f17319a;
        }

        public final void invoke(String str) {
            this.f17598a.t0().startService(NetService.f6158h.a());
        }
    }

    public static final class g extends t9.j implements s9.l {

        /* renamed from: a  reason: collision with root package name */
        public static final g f17599a = new g();

        public g() {
            super(1);
        }

        public final void invoke(Throwable th) {
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Throwable) obj);
            return h9.t.f17319a;
        }
    }

    public static final class g0 extends t9.j implements s9.l {

        /* renamed from: a  reason: collision with root package name */
        public static final g0 f17600a = new g0();

        public g0() {
            super(1);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Throwable) obj);
            return h9.t.f17319a;
        }

        public final void invoke(Throwable th) {
            th.printStackTrace();
        }
    }

    public static final class h implements h7.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b1 f17601a;

        public h(b1 b1Var) {
            this.f17601a = b1Var;
        }

        /* renamed from: a */
        public void onOver(UpdateBean updateBean) {
            t9.i.g(updateBean, "result");
            this.f17601a.I0(updateBean);
        }

        public void onCompleted() {
        }

        public void onError(Throwable th) {
            String str;
            if (th != null) {
                str = th.getLocalizedMessage();
            } else {
                str = null;
            }
            com.mobile.brasiltv.utils.b0.U(this, str);
            xa.c.c().m(new HasNewUpdateEvent(false));
        }
    }

    public static final class h0 extends ha.a {
        public void onNext(BaseResult baseResult) {
            t9.i.g(baseResult, "t");
        }

        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
        }
    }

    public static final class i extends ha.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b1 f17602a;

        public static final class a extends t9.j implements s9.l {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ GetAuthInfoResult f17603a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(GetAuthInfoResult getAuthInfoResult) {
                super(1);
                this.f17603a = getAuthInfoResult;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return h9.t.f17319a;
            }

            public final void invoke(String str) {
                com.mobile.brasiltv.utils.y yVar = com.mobile.brasiltv.utils.y.f12639a;
                String returnCode = this.f17603a.getReturnCode();
                t9.i.d(returnCode);
                f1.f12517a.x(com.mobile.brasiltv.utils.y.p(yVar, returnCode, (String) null, (String) null, 6, (Object) null));
            }
        }

        public static final class b extends t9.j implements s9.l {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f17604a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public b(String str) {
                super(1);
                this.f17604a = str;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return h9.t.f17319a;
            }

            public final void invoke(String str) {
                f1.f12517a.x(com.mobile.brasiltv.utils.y.p(com.mobile.brasiltv.utils.y.f12639a, this.f17604a, (String) null, (String) null, 6, (Object) null));
            }
        }

        public i(b1 b1Var) {
            this.f17602a = b1Var;
        }

        /* renamed from: f */
        public void onNext(GetAuthInfoResult getAuthInfoResult) {
            List<AuthInfo> list;
            String tips;
            int i10;
            int i11;
            t9.i.g(getAuthInfoResult, "t");
            k7.f.e("获取授权信息成功，result: " + getAuthInfoResult, new Object[0]);
            if (t9.i.b(getAuthInfoResult.getReturnCode(), "aaa100028")) {
                k7.f.f("授权信息接口，needToReLogin", new Object[0]);
                com.mobile.brasiltv.utils.b0.c0(this.f17602a.t0(), LoginAty.class);
            } else if (com.mobile.brasiltv.utils.b0.T(getAuthInfoResult.getReturnCode(), "aaa100027")) {
                com.mobile.brasiltv.utils.x.f12622a.w(this.f17602a.t0(), new a(getAuthInfoResult));
            } else {
                String str = "";
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
                    cVar.q0(data4.getRestrictedStatus());
                    GetAuthInfoData data5 = getAuthInfoResult.getData();
                    t9.i.d(data5);
                    cVar.h0(data5.getHasPwd());
                    GetAuthInfoData data6 = getAuthInfoResult.getData();
                    t9.i.d(data6);
                    cVar.y0(data6.getUserIdentity());
                    GetAuthInfoData data7 = getAuthInfoResult.getData();
                    t9.i.d(data7);
                    String childLockPwd = data7.getChildLockPwd();
                    if (childLockPwd == null) {
                        childLockPwd = str;
                    }
                    cVar.W(childLockPwd);
                    GetAuthInfoData data8 = getAuthInfoResult.getData();
                    t9.i.d(data8);
                    Integer remainingDays = data8.getRemainingDays();
                    if (remainingDays != null) {
                        i10 = remainingDays.intValue();
                    } else {
                        i10 = 0;
                    }
                    cVar.p0(i10);
                    GetAuthInfoData data9 = getAuthInfoResult.getData();
                    t9.i.d(data9);
                    Integer expRemainingDays = data9.getExpRemainingDays();
                    if (expRemainingDays != null) {
                        i11 = expRemainingDays.intValue();
                    } else {
                        i11 = 0;
                    }
                    cVar.c0(i11);
                    GetAuthInfoData data10 = getAuthInfoResult.getData();
                    t9.i.d(data10);
                    String qrcodeMessage = data10.getQrcodeMessage();
                    if (qrcodeMessage == null) {
                        qrcodeMessage = str;
                    }
                    cVar.o0(qrcodeMessage);
                    GetAuthInfoData data11 = getAuthInfoResult.getData();
                    t9.i.d(data11);
                    cVar.P(data11.getActiveTime());
                }
                d6.b bVar = d6.b.f6366a;
                GetAuthInfoData data12 = getAuthInfoResult.getData();
                if (data12 != null) {
                    list = data12.getAuthInfoList();
                } else {
                    list = null;
                }
                bVar.B(list);
                b1 b1Var = this.f17602a;
                GetAuthInfoData data13 = getAuthInfoResult.getData();
                if (!(data13 == null || (tips = data13.getTips()) == null)) {
                    str = tips;
                }
                b1Var.H0(str);
                i.c cVar2 = w6.i.f9510g;
                cVar2.S(cVar2.y() + "?lang=" + com.mobile.brasiltv.utils.f0.a() + "&userId=" + cVar2.H() + "&packageId=&appId=" + na.a.g() + "&packageType=1&appVersion=" + na.a.b() + "&timeStamp=" + System.currentTimeMillis() + "&tk=" + cVar2.J() + "&loginType=3");
                StringBuilder sb = new StringBuilder();
                sb.append("购买VIP连接：");
                sb.append(cVar2.g());
                k7.f.e(sb.toString(), new Object[0]);
                this.f17602a.B0();
                xa.c.c().m(new UpdateMineViewEvent());
            }
        }

        public void onComplete() {
        }

        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            com.mobile.brasiltv.utils.x.f12622a.w(this.f17602a.t0(), new b(str));
            this.f17602a.B0();
        }
    }

    public static final class j extends t9.j implements s9.l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b1 f17605a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public j(b1 b1Var) {
            super(1);
            this.f17605a = b1Var;
        }

        public final void b(PendingDynamicLinkData pendingDynamicLinkData) {
            Uri uri;
            if (pendingDynamicLinkData != null) {
                uri = pendingDynamicLinkData.getLink();
            } else {
                uri = null;
            }
            if (uri != null) {
                com.mobile.brasiltv.utils.b0.j0(this.f17605a.t0(), uri.toString(), true, false, true, false, 16, (Object) null);
            }
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            b((PendingDynamicLinkData) obj);
            return h9.t.f17319a;
        }
    }

    public static final class k extends ha.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b1 f17606a;

        public k(b1 b1Var) {
            this.f17606a = b1Var;
        }

        /* renamed from: f */
        public void onNext(FreeResult freeResult) {
            t9.i.g(freeResult, "t");
            super.onNext(freeResult);
            xa.c.c().m(new GetFreeTimeEvent());
        }

        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            String c10 = com.mobile.brasiltv.utils.y.f12639a.c(str);
            String I = this.f17606a.f7504c;
            k7.f.e(I, "getFreeTime " + c10);
        }
    }

    public static final class l extends ha.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b1 f17607a;

        public static final class a extends t9.j implements s9.l {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f17608a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(String str) {
                super(1);
                this.f17608a = str;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return h9.t.f17319a;
            }

            public final void invoke(String str) {
                com.mobile.brasiltv.utils.y yVar = com.mobile.brasiltv.utils.y.f12639a;
                String p10 = com.mobile.brasiltv.utils.y.p(yVar, this.f17608a, (String) null, (String) null, 6, (Object) null);
                if (!t9.i.b(na.d.c(this.f17608a), "no_report_type")) {
                    p10 = com.mobile.brasiltv.utils.y.p(yVar, this.f17608a, (String) null, (String) null, 6, (Object) null);
                }
                f1.f12517a.x(p10);
            }
        }

        public l(b1 b1Var) {
            this.f17607a = b1Var;
        }

        /* renamed from: f */
        public void onNext(ChildColumnList childColumnList) {
            t9.i.g(childColumnList, "childColumn");
        }

        public void onComplete() {
            com.mobile.brasiltv.utils.b0.U(this, "loadMainColumn:onCompleted");
            this.f17607a.G0().s();
            this.f17607a.G0().p0();
            this.f17607a.v0();
        }

        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            this.f17607a.G0().onError();
            com.mobile.brasiltv.utils.x.f12622a.w(this.f17607a.t0(), new a(str));
        }
    }

    public static final class m extends t9.j implements s9.l {

        /* renamed from: a  reason: collision with root package name */
        public static final m f17609a = new m();

        public m() {
            super(1);
        }

        /* renamed from: b */
        public final String invoke(String str) {
            t9.i.g(str, Constants.KEY_HOST);
            return r5.i.f19378a.y(str);
        }
    }

    public static final class n extends t9.j implements s9.l {

        /* renamed from: a  reason: collision with root package name */
        public static final n f17610a = new n();

        public n() {
            super(1);
        }

        /* renamed from: b */
        public final SnTokenData invoke(SnTokenResult snTokenResult) {
            t9.i.g(snTokenResult, "it");
            return snTokenResult.getData();
        }
    }

    public static final class o extends ha.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b1 f17611a;

        public static final class a extends t9.j implements s9.l {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f17612a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(String str) {
                super(1);
                this.f17612a = str;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return h9.t.f17319a;
            }

            public final void invoke(String str) {
                com.mobile.brasiltv.utils.y yVar = com.mobile.brasiltv.utils.y.f12639a;
                f1.f12517a.x(com.mobile.brasiltv.utils.y.p(yVar, this.f17612a, yVar.l(), (String) null, 4, (Object) null));
            }
        }

        public o(b1 b1Var) {
            this.f17611a = b1Var;
        }

        /* renamed from: f */
        public void onNext(SnTokenData snTokenData) {
            boolean z10;
            String str;
            t9.i.g(snTokenData, "t");
            super.onNext(snTokenData);
            String str2 = "";
            if ("1".equals(snTokenData.isNew())) {
                i.c cVar = w6.i.f9510g;
                String sn = snTokenData.getSn();
                if (sn == null || sn.length() == 0) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (!z10) {
                    str = snTokenData.getSn();
                    if (str == null) {
                        str = str2;
                    }
                } else {
                    str = ma.m.c(snTokenData.getSnToken());
                    t9.i.f(str, "{\n                      …                        }");
                }
                cVar.u0(str);
                if (TextUtils.isEmpty(cVar.E())) {
                    i1.G(this.f17611a.t0(), CdnType.DIGITAL_TYPE_PEERSTAR, "6:1");
                }
                b1 b1Var = this.f17611a;
                String userId = snTokenData.getUserId();
                if (userId != null) {
                    str2 = userId;
                }
                b1Var.d1(str2, true);
            } else {
                i.c cVar2 = w6.i.f9510g;
                String c10 = ma.m.c(snTokenData.getSnToken());
                t9.i.f(c10, "getMd5(t.snToken)");
                cVar2.u0(c10);
                String snToken = snTokenData.getSnToken();
                if (snToken != null) {
                    str2 = snToken;
                }
                cVar2.v0(str2);
            }
            na.f.k(Utils.context, "key_sn", w6.i.f9510g.E());
            this.f17611a.Z();
        }

        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            if (t9.i.b("portal200001", str)) {
                MainAty.A.r(true);
                com.mobile.brasiltv.utils.b0.S(new VersionForbiddenDialog(this.f17611a.t0()), DialogManager.DIALOG_VERSION_FORBIDDEN);
                return;
            }
            com.mobile.brasiltv.utils.x.f12622a.w(this.f17611a.t0(), new a(str));
        }
    }

    public static final class p extends ha.a {
        /* renamed from: f */
        public void onNext(ThirdPartResult thirdPartResult) {
            t9.i.g(thirdPartResult, "t");
            a6.f.f10686a.b(thirdPartResult.getData());
        }

        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            com.mobile.brasiltv.utils.b0.U(this, "get third part fail.");
        }
    }

    public static final class q implements v2.b {
        public void a(long j10, long j11, String str, String str2, int i10, boolean z10) {
            String str3 = str;
            t9.i.g(str3, "uri");
            String str4 = str2;
            t9.i.g(str4, "domain");
            c2.d.e(c2.d.f4594a, j10, SystemClock.elapsedRealtime(), str3, str4, i10, na.e.f19079e, (HashMap) null, z10, 64, (Object) null);
        }
    }

    public static final class r extends ha.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b1 f17613a;

        public static final class a extends t9.j implements s9.l {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f17614a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ b1 f17615b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(String str, b1 b1Var) {
                super(1);
                this.f17614a = str;
                this.f17615b = b1Var;
            }

            public static final void c(t9.w wVar) {
                t9.i.g(wVar, "$msg");
                f1.f12517a.x((String) wVar.f19600a);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return h9.t.f17319a;
            }

            public final void invoke(String str) {
                t9.w wVar = new t9.w();
                com.mobile.brasiltv.utils.y yVar = com.mobile.brasiltv.utils.y.f12639a;
                wVar.f19600a = com.mobile.brasiltv.utils.y.p(yVar, this.f17614a, yVar.e(), (String) null, 4, (Object) null);
                this.f17615b.t0().runOnUiThread(new c1(wVar));
            }
        }

        public r(b1 b1Var) {
            this.f17613a = b1Var;
        }

        /* renamed from: f */
        public void onNext(GetHomeResult getHomeResult) {
            t9.i.g(getHomeResult, "t");
            if (getHomeResult.getData() != null) {
                GetHomeData data = getHomeResult.getData();
                t9.i.d(data);
                if (com.mobile.brasiltv.utils.b0.I(data.getRecommendList())) {
                    com.mobile.brasiltv.utils.b0.U(this, "首页数据获取成功 " + getHomeResult);
                    n0 n0Var = n0.f12601a;
                    f5.c t02 = this.f17613a.t0();
                    GetHomeData data2 = getHomeResult.getData();
                    t9.i.d(data2);
                    n0Var.j(t02, "home_data_version", data2.getVersion());
                    f5.c t03 = this.f17613a.t0();
                    GetHomeData data3 = getHomeResult.getData();
                    t9.i.d(data3);
                    n0Var.j(t03, "home_data_free_version", data3.getFreeVersion());
                    Gson gson = new Gson();
                    GetHomeData data4 = getHomeResult.getData();
                    t9.i.d(data4);
                    na.f.m(this.f17613a.t0(), "home", "home_data", gson.toJson((Object) data4.getRecommendList()));
                    MainAty.a aVar = MainAty.A;
                    aVar.g().clear();
                    ArrayList g10 = aVar.g();
                    GetHomeData data5 = getHomeResult.getData();
                    t9.i.d(data5);
                    ArrayList<HomeRecommend> recommendList = data5.getRecommendList();
                    t9.i.d(recommendList);
                    g10.addAll(recommendList);
                }
            }
        }

        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            if (t9.i.b(str, "304")) {
                com.mobile.brasiltv.utils.b0.U(this, "首页数据有缓存");
                MainAty.a aVar = MainAty.A;
                if (com.mobile.brasiltv.utils.b0.I(aVar.a())) {
                    aVar.j(true);
                    aVar.g().clear();
                    aVar.g().addAll(aVar.a());
                    return;
                }
                n0.f12601a.k(this.f17613a.t0(), new String[]{"home_data_version", "home_data_free_version"}, new String[]{"", ""});
            }
            MainAty.A.j(false);
            com.mobile.brasiltv.utils.x.f12622a.w(this.f17613a.t0(), new a(str, this.f17613a));
        }
    }

    public static final class s extends TypeToken<ArrayList<HomeRecommend>> {
    }

    public static final class t extends t9.j implements s9.l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ t9.w f17616a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b1 f17617b;

        public static final class a extends t9.j implements s9.a {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b1 f17618a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(b1 b1Var) {
                super(0);
                this.f17618a = b1Var;
            }

            public final void invoke() {
                this.f17618a.G0().s();
                this.f17618a.G0().p0();
                this.f17618a.v0();
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public t(t9.w wVar, b1 b1Var) {
            super(1);
            this.f17616a = wVar;
            this.f17617b = b1Var;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Boolean) obj);
            return h9.t.f17319a;
        }

        public final void invoke(Boolean bool) {
            t9.i.f(bool, "it");
            if (bool.booleanValue()) {
                w6.i b10 = w6.i.f9510g.b();
                Object obj = this.f17616a.f19600a;
                t9.i.d(obj);
                b10.N1((ColumnContentsBean) obj, new a(this.f17617b));
                return;
            }
            this.f17617b.A0();
        }
    }

    public static final class u extends ha.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b1 f17619a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ t9.w f17620b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f17621c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f17622d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f17623e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f17624f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ t9.w f17625g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f17626h;

        public static final class a extends t9.j implements s9.l {

            /* renamed from: a  reason: collision with root package name */
            public static final a f17627a = new a();

            public a() {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return h9.t.f17319a;
            }

            public final void invoke(String str) {
                f1.f12517a.x(com.mobile.brasiltv.utils.y.p(com.mobile.brasiltv.utils.y.f12639a, "CUSTOM_NO_ASSOCIATED_PORTAL", (String) null, (String) null, 6, (Object) null));
            }
        }

        public static final class b extends t9.j implements s9.l {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f17628a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ t9.w f17629b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ b1 f17630c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public b(String str, t9.w wVar, b1 b1Var) {
                super(1);
                this.f17628a = str;
                this.f17629b = wVar;
                this.f17630c = b1Var;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return h9.t.f17319a;
            }

            public final void invoke(String str) {
                com.mobile.brasiltv.utils.y yVar = com.mobile.brasiltv.utils.y.f12639a;
                String p10 = com.mobile.brasiltv.utils.y.p(yVar, this.f17628a, yVar.i(), (String) null, 4, (Object) null);
                if (!t9.i.b(this.f17629b.f19600a, "7") || !t9.i.b(this.f17628a, "aaa100003")) {
                    f1.f12517a.x(p10);
                } else {
                    na.f.k(this.f17630c.t0(), "qr_auth_code", "");
                }
            }
        }

        public u(b1 b1Var, t9.w wVar, String str, String str2, String str3, String str4, t9.w wVar2, String str5) {
            this.f17619a = b1Var;
            this.f17620b = wVar;
            this.f17621c = str;
            this.f17622d = str2;
            this.f17623e = str3;
            this.f17624f = str4;
            this.f17625g = wVar2;
            this.f17626h = str5;
        }

        /* renamed from: f */
        public void onNext(LoginResult loginResult) {
            List<PortalCodeList> list;
            String str;
            String str2;
            String str3;
            String str4;
            String str5;
            String areaCode;
            String str6;
            String str7;
            t9.i.g(loginResult, "t");
            super.onNext(loginResult);
            UserData data = loginResult.getData();
            String str8 = null;
            if (data != null) {
                list = data.getPortalCodeList();
            } else {
                list = null;
            }
            if (com.mobile.brasiltv.utils.b0.I(list)) {
                d6.b bVar = d6.b.f6366a;
                f5.c t02 = this.f17619a.t0();
                UserData data2 = loginResult.getData();
                t9.i.d(data2);
                d6.b.G(bVar, t02, data2, this.f17621c, this.f17622d, (String) null, (String) null, this.f17623e, false, 48, (Object) null);
                if (!TextUtils.isEmpty((CharSequence) this.f17620b.f19600a)) {
                    UserData data3 = loginResult.getData();
                    if (data3 != null) {
                        str6 = data3.getPwdTip();
                    } else {
                        str6 = null;
                    }
                    if (t9.i.b(str6, "yes")) {
                        UserData data4 = loginResult.getData();
                        if (data4 != null) {
                            str7 = data4.getHasPwd();
                        } else {
                            str7 = null;
                        }
                        if (t9.i.b(str7, "1")) {
                            com.mobile.brasiltv.utils.b0.c0(this.f17619a.t0(), ForceChangePwdAty.class);
                            SwitchAccountBean switchAccountBean = new SwitchAccountBean();
                            switchAccountBean.setAccountType((String) this.f17620b.f19600a);
                            switchAccountBean.setAreaCode(this.f17624f);
                            switchAccountBean.setUserName((String) this.f17625g.f19600a);
                            switchAccountBean.setPassword(this.f17622d);
                            switchAccountBean.setVerificationToken(this.f17626h);
                            s5.e.f19464a.n(s5.c.QUICK_LOGIN, switchAccountBean, (String) null);
                            return;
                        }
                    }
                }
                this.f17619a.e1();
                SwitchAccountBean switchAccountBean2 = new SwitchAccountBean();
                String str9 = "";
                if (t9.i.b(this.f17620b.f19600a, "7")) {
                    UserData data5 = loginResult.getData();
                    if (data5 == null || (str = data5.getUserId()) == null) {
                        str = str9;
                    }
                } else {
                    str = this.f17621c;
                }
                switchAccountBean2.setUserName(str);
                switchAccountBean2.setPassword(this.f17622d);
                UserData data6 = loginResult.getData();
                if (data6 == null || (str2 = data6.getUserId()) == null) {
                    str2 = str9;
                }
                switchAccountBean2.setUserId(str2);
                switchAccountBean2.setAccountType((String) this.f17620b.f19600a);
                UserData data7 = loginResult.getData();
                if (data7 == null || (str3 = data7.getAreaCode()) == null) {
                    str3 = str9;
                }
                switchAccountBean2.setAreaCode(str3);
                switchAccountBean2.setVerificationToken(this.f17626h);
                UserData data8 = loginResult.getData();
                if (data8 == null || (str4 = data8.getEmail()) == null) {
                    str4 = str9;
                }
                switchAccountBean2.setEmail(str4);
                UserData data9 = loginResult.getData();
                if (data9 == null || (str5 = data9.getMobile()) == null) {
                    str5 = str9;
                }
                switchAccountBean2.setPhone(str5);
                UserData data10 = loginResult.getData();
                if (!(data10 == null || (areaCode = data10.getAreaCode()) == null)) {
                    str9 = areaCode;
                }
                switchAccountBean2.setAreaCode(str9);
                this.f17619a.Z0(switchAccountBean2);
                xa.c.c().j(new CloseForcePageEvent());
                xa.c c10 = xa.c.c();
                UserData data11 = loginResult.getData();
                if (data11 != null) {
                    str8 = data11.getHeartBeatTime();
                }
                c10.j(new LoginSuccessEvent(str8));
                this.f17619a.a0(loginResult.getData());
                this.f17619a.h0();
                this.f17619a.M0();
                this.f17619a.L0();
                this.f17619a.q0(loginResult.getData());
                this.f17619a.S0();
                d6.a.f16338a.k();
                return;
            }
            com.mobile.brasiltv.utils.x.f12622a.w(this.f17619a.t0(), a.f17627a);
        }

        public void handleVerifyTokenError() {
            super.handleVerifyTokenError();
            MemberInfo memberInfo = MemberInfo.INSTANCE;
            memberInfo.putUserName("");
            memberInfo.putPassword("", false);
            na.f.k(this.f17619a.t0(), "verification_token", "");
        }

        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            if (t9.i.b("portal200001", str)) {
                MainAty.A.r(true);
                com.mobile.brasiltv.utils.b0.S(new VersionForbiddenDialog(this.f17619a.t0()), DialogManager.DIALOG_VERSION_FORBIDDEN);
            } else if (t9.i.b("aaa100094", str)) {
                new NumberLimitDialog(this.f17619a.t0()).show();
            } else {
                com.mobile.brasiltv.utils.x.f12622a.w(this.f17619a.t0(), new b(str, this.f17620b, this.f17619a));
                com.mobile.brasiltv.utils.b0.c0(this.f17619a.t0(), LoginAty.class);
                this.f17619a.G0().onError();
            }
        }
    }

    public static final class v extends ha.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b1 f17631a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f17632b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f17633c;

        public static final class a extends t9.j implements s9.l {

            /* renamed from: a  reason: collision with root package name */
            public static final a f17634a = new a();

            public a() {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return h9.t.f17319a;
            }

            public final void invoke(String str) {
                f1.f12517a.x(com.mobile.brasiltv.utils.y.p(com.mobile.brasiltv.utils.y.f12639a, "CUSTOM_NO_ASSOCIATED_PORTAL", (String) null, (String) null, 6, (Object) null));
            }
        }

        public static final class b extends t9.j implements s9.l {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f17635a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public b(String str) {
                super(1);
                this.f17635a = str;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return h9.t.f17319a;
            }

            public final void invoke(String str) {
                com.mobile.brasiltv.utils.y yVar = com.mobile.brasiltv.utils.y.f12639a;
                f1.f12517a.x(com.mobile.brasiltv.utils.y.p(yVar, this.f17635a, yVar.j(), (String) null, 4, (Object) null));
            }
        }

        public v(b1 b1Var, String str, String str2) {
            this.f17631a = b1Var;
            this.f17632b = str;
            this.f17633c = str2;
        }

        /* renamed from: f */
        public void onNext(LoginResult loginResult) {
            List<PortalCodeList> list;
            String str;
            String str2;
            String str3;
            String str4;
            String areaCode;
            String str5;
            String str6;
            t9.i.g(loginResult, "t");
            UserData data = loginResult.getData();
            String str7 = null;
            if (data != null) {
                list = data.getPortalCodeList();
            } else {
                list = null;
            }
            if (com.mobile.brasiltv.utils.b0.I(list)) {
                d6.b bVar = d6.b.f6366a;
                f5.c t02 = this.f17631a.t0();
                UserData data2 = loginResult.getData();
                t9.i.d(data2);
                d6.b.G(bVar, t02, data2, "", "", this.f17632b, this.f17633c, (String) null, false, 64, (Object) null);
                if (!TextUtils.isEmpty(this.f17632b)) {
                    UserData data3 = loginResult.getData();
                    if (data3 != null) {
                        str5 = data3.getPwdTip();
                    } else {
                        str5 = null;
                    }
                    if (t9.i.b(str5, "yes")) {
                        UserData data4 = loginResult.getData();
                        if (data4 != null) {
                            str6 = data4.getHasPwd();
                        } else {
                            str6 = null;
                        }
                        if (t9.i.b(str6, "1")) {
                            com.mobile.brasiltv.utils.b0.c0(this.f17631a.t0(), ForceChangePwdAty.class);
                            x7.a aVar = new x7.a();
                            aVar.b(this.f17633c);
                            s5.e.f19464a.o(s5.c.THIRD_PART_LOGIN, this.f17632b, aVar, "0", "1", (String) null);
                            return;
                        }
                    }
                }
                this.f17631a.e1();
                SwitchAccountBean switchAccountBean = new SwitchAccountBean();
                switchAccountBean.setAccountType(this.f17632b);
                UserData data5 = loginResult.getData();
                String str8 = "";
                if (data5 == null || (str = data5.getEmail()) == null) {
                    str = str8;
                }
                switchAccountBean.setUserName(str);
                UserData data6 = loginResult.getData();
                if (data6 == null || (str2 = data6.getEmail()) == null) {
                    str2 = str8;
                }
                switchAccountBean.setEmail(str2);
                UserData data7 = loginResult.getData();
                if (data7 == null || (str3 = data7.getMobile()) == null) {
                    str3 = str8;
                }
                switchAccountBean.setPhone(str3);
                UserData data8 = loginResult.getData();
                if (data8 == null || (str4 = data8.getUserId()) == null) {
                    str4 = str8;
                }
                switchAccountBean.setUserId(str4);
                switchAccountBean.setAuthCode(this.f17633c);
                UserData data9 = loginResult.getData();
                if (!(data9 == null || (areaCode = data9.getAreaCode()) == null)) {
                    str8 = areaCode;
                }
                switchAccountBean.setAreaCode(str8);
                this.f17631a.Z0(switchAccountBean);
                xa.c.c().j(new CloseForcePageEvent());
                xa.c c10 = xa.c.c();
                UserData data10 = loginResult.getData();
                if (data10 != null) {
                    str7 = data10.getHeartBeatTime();
                }
                c10.j(new LoginSuccessEvent(str7));
                this.f17631a.a0(loginResult.getData());
                this.f17631a.h0();
                this.f17631a.M0();
                this.f17631a.L0();
                this.f17631a.q0(loginResult.getData());
                this.f17631a.S0();
                d6.a.f16338a.k();
                return;
            }
            com.mobile.brasiltv.utils.x.f12622a.w(this.f17631a.t0(), a.f17634a);
        }

        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            if (t9.i.b("portal200001", str)) {
                MainAty.A.r(true);
                com.mobile.brasiltv.utils.b0.S(new VersionForbiddenDialog(this.f17631a.t0()), DialogManager.DIALOG_VERSION_FORBIDDEN);
            } else if (t9.i.b("aaa100094", str)) {
                new NumberLimitDialog(this.f17631a.t0()).show();
            } else {
                com.mobile.brasiltv.utils.x.f12622a.w(this.f17631a.t0(), new b(str));
                com.mobile.brasiltv.utils.b0.c0(this.f17631a.t0(), LoginAty.class);
                this.f17631a.G0().onError();
            }
        }
    }

    public static final class w extends t9.j implements s9.a {

        /* renamed from: a  reason: collision with root package name */
        public static final w f17636a = new w();

        public w() {
            super(0);
        }

        /* renamed from: b */
        public final c5.a invoke() {
            return new c5.a(new ja.c(".update"), new la.a(".update"));
        }
    }

    public static final class x extends t9.j implements s9.l {

        /* renamed from: a  reason: collision with root package name */
        public static final x f17637a = new x();

        public x() {
            super(1);
        }

        /* renamed from: b */
        public final Boolean invoke(ApkQueryCouponResult apkQueryCouponResult) {
            boolean z10;
            t9.i.g(apkQueryCouponResult, "it");
            if (apkQueryCouponResult.getData() != null) {
                z10 = true;
            } else {
                z10 = false;
            }
            return Boolean.valueOf(z10);
        }
    }

    public static final class y extends ha.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ t9.w f17638a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b1 f17639b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f17640c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f17641d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f17642e;

        public y(t9.w wVar, b1 b1Var, String str, String str2, String str3) {
            this.f17638a = wVar;
            this.f17639b = b1Var;
            this.f17640c = str;
            this.f17641d = str2;
            this.f17642e = str3;
        }

        /* renamed from: f */
        public void onNext(ApkQueryCouponResult apkQueryCouponResult) {
            List<CouponCodeList> list;
            boolean z10;
            t9.i.g(apkQueryCouponResult, "apkQueryCouponResult");
            long j10 = y6.a.j();
            QueryCouponData data = apkQueryCouponResult.getData();
            String str = null;
            if (data != null) {
                list = data.getCouponCodeList();
            } else {
                list = null;
            }
            if (com.mobile.brasiltv.utils.b0.I(list)) {
                QueryCouponData data2 = apkQueryCouponResult.getData();
                t9.i.d(data2);
                List<CouponCodeList> couponCodeList = data2.getCouponCodeList();
                t9.i.d(couponCodeList);
                this.f17639b.k1(couponCodeList, j10 / ((long) 1000));
            }
            QueryCouponData data3 = apkQueryCouponResult.getData();
            if (data3 != null) {
                str = data3.getReceiveFlag();
            }
            if (str == null || str.length() == 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (!z10) {
                QueryCouponData data4 = apkQueryCouponResult.getData();
                t9.i.d(data4);
                boolean b10 = t9.i.b(data4.getReceiveFlag(), "1");
                w6.i.f9510g.i0(b10);
                na.f.i(this.f17639b.t0(), this.f17640c, b10);
                na.f.k(this.f17639b.t0(), this.f17641d, String.valueOf(j10));
                f5.c t02 = this.f17639b.t0();
                String str2 = this.f17642e;
                QueryCouponData data5 = apkQueryCouponResult.getData();
                t9.i.d(data5);
                na.f.k(t02, str2, String.valueOf(((long) (data5.getDataCacheTime() * 60)) * 1000));
            }
        }

        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            if (this.f17638a.f19600a != null) {
                w6.i.f9510g.i0(false);
            }
        }
    }

    public static final class z extends BroadcastReceiver {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b1 f17643a;

        public z(b1 b1Var) {
            this.f17643a = b1Var;
        }

        public void onReceive(Context context, Intent intent) {
            int i10;
            int i11 = 0;
            if (intent != null) {
                i10 = intent.getIntExtra(FirebaseAnalytics.Param.LEVEL, 0);
            } else {
                i10 = 0;
            }
            if (intent != null) {
                i11 = intent.getIntExtra("scale", 0);
            }
            Integer F = this.f17643a.f7515n;
            if (F == null || F.intValue() != i10) {
                q8.e.b(bt.Z, (i10 * 100) / i11);
            }
            this.f17643a.f7515n = Integer.valueOf(i10);
        }
    }

    public b1(f5.c cVar, i6.v vVar) {
        t9.i.g(cVar, com.umeng.analytics.pro.f.X);
        t9.i.g(vVar, "view");
        this.f7502a = cVar;
        this.f7503b = vVar;
        vVar.Y0(this);
        this.f7513l = new HashMap();
    }

    public static final SnTokenData D0(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        return (SnTokenData) lVar.invoke(obj);
    }

    public static final void J0(b1 b1Var, DialogInterface dialogInterface, boolean z10) {
        t9.i.g(b1Var, "this$0");
        if (!z10) {
            if (MainAty.A.i()) {
                DialogManager dialogManager = DialogManager.INSTANCE;
                if (!dialogManager.hasDialogSaved(DialogManager.DIALOG_VERSION_FORBIDDEN)) {
                    dialogManager.showByManager(new VersionForbiddenDialog(b1Var.f7502a), DialogManager.DIALOG_VERSION_FORBIDDEN);
                }
            }
            DialogManager dialogManager2 = DialogManager.INSTANCE;
            t9.i.e(dialogInterface, "null cannot be cast to non-null type android.app.Dialog");
            dialogManager2.showNext((Dialog) dialogInterface);
        }
    }

    public static final void N0(t9.w wVar, b1 b1Var, t9.w wVar2, ObservableEmitter observableEmitter) {
        boolean z10;
        t9.i.g(wVar, "$cacheColumnData");
        t9.i.g(b1Var, "this$0");
        t9.i.g(wVar2, "$columnContentsBean");
        t9.i.g(observableEmitter, "it");
        Object b10 = n7.a.b(b1Var.f7502a, "root_column", "");
        t9.i.e(b10, "null cannot be cast to non-null type kotlin.String");
        String str = (String) b10;
        wVar.f19600a = str;
        if (!com.mobile.brasiltv.utils.b0.J(str)) {
            Gson a10 = s2.b.a();
            Object obj = wVar.f19600a;
            t9.i.d(obj);
            wVar2.f19600a = a10.fromJson((String) obj, ColumnContentsBean.class);
        }
        if (wVar2.f19600a != null) {
            int d10 = na.f.d(b1Var.f7502a, "column_cache_time", 0);
            String f10 = na.f.f(b1Var.f7502a, "service_time_root_column", "0");
            t9.i.f(f10, "getStrings(context, Cons…CE_TIME_ROOT_COLUMN, \"0\")");
            long parseLong = Long.parseLong(f10);
            String f11 = na.f.f(na.a.f8315a, "realtime_dcs", "0");
            t9.i.f(f11, "getStrings(AppHelper.mCo…nstant.REALTIME_DCS, \"0\")");
            long a11 = (i2.h.f7019a.a() + SystemClock.elapsedRealtime()) - Long.parseLong(f11);
            StringBuilder sb = new StringBuilder();
            sb.append("root column: nowTime: ");
            sb.append(a11);
            sb.append(", lastCacheTime: ");
            sb.append(parseLong);
            sb.append(", cacheTime: ");
            int i10 = 60000 * d10;
            sb.append(i10);
            sb.append(", needRequest= ");
            if (a11 > ((long) i10) + parseLong) {
                z10 = true;
            } else {
                z10 = false;
            }
            sb.append(z10);
            k7.f.e(sb.toString(), new Object[0]);
            if (parseLong == 0 || d10 == 0 || a11 >= parseLong + ((long) (d10 * 60 * 1000))) {
                observableEmitter.onNext(Boolean.FALSE);
            } else {
                observableEmitter.onNext(Boolean.TRUE);
            }
        } else {
            observableEmitter.onNext(Boolean.FALSE);
        }
    }

    public static final void O0(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final boolean T0(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        return ((Boolean) lVar.invoke(obj)).booleanValue();
    }

    public static final void a1(b1 b1Var, SwitchAccountBean switchAccountBean, ObservableEmitter observableEmitter) {
        t9.i.g(b1Var, "this$0");
        t9.i.g(switchAccountBean, "$account");
        t9.i.g(observableEmitter, "it");
        Context applicationContext = b1Var.f7502a.getApplicationContext();
        t9.i.f(applicationContext, "context.applicationContext");
        MobileDao mobileDao = new MobileDao(applicationContext);
        if (mobileDao.queryAccount(switchAccountBean.getUserId()) == null) {
            mobileDao.addAccount(switchAccountBean);
        }
        observableEmitter.onNext(switchAccountBean);
        observableEmitter.onComplete();
    }

    public static final void b1(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void c1(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static /* synthetic */ void e0(b1 b1Var, boolean z10, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = 0;
        }
        b1Var.d0(z10, i10);
    }

    public static final void f1(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void g1(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void h1(b1 b1Var, ObservableEmitter observableEmitter) {
        t9.i.g(b1Var, "this$0");
        t9.i.g(observableEmitter, "it");
        y0 y0Var = y0.f12657a;
        y0Var.K(b1Var.f7502a);
        y0Var.L();
        b1Var.K0();
        observableEmitter.onNext("cold launcher");
        observableEmitter.onComplete();
    }

    public static final boolean i0(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        return ((Boolean) lVar.invoke(obj)).booleanValue();
    }

    public static final String i1(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        return (String) lVar.invoke(obj);
    }

    public static final void j0(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void k0(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void w0(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void x0(Exception exc) {
        t9.i.g(exc, "e");
        exc.printStackTrace();
    }

    public final void A0() {
        w6.i.f9510g.b().I1().compose(this.f7502a.O1()).subscribe(new l(this));
    }

    public final void B0() {
        r5.i iVar = r5.i.f19378a;
        iVar.L("");
        iVar.s(this.f7502a);
        iVar.v();
        la.b.f18842b.a(m.f17609a);
    }

    public final void C0() {
        w6.i b10 = w6.i.f9510g.b();
        y0 y0Var = y0.f12657a;
        SnTokenBean snTokenBean = r2;
        SnTokenBean snTokenBean2 = new SnTokenBean(y0Var.l(this.f7502a), y0Var.y(this.f7502a), y0Var.q(), y0Var.w(), y0Var.n(), y0Var.u(this.f7502a), y0Var.v(this.f7502a), y0Var.r(), y0Var.m(), ma.h.f18994a.e(this.f7502a), (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 2096128, (t9.g) null);
        b10.l2(snTokenBean).compose(this.f7502a.O1()).map(new o0(n.f17610a)).subscribe(new o(this));
    }

    public ArrayList E0() {
        ArrayList arrayList = new ArrayList();
        String string = this.f7502a.getString(R.string.nav_button_home);
        t9.i.f(string, "context.getString(R.string.nav_button_home)");
        arrayList.add(new MainTabEntity(string, R.drawable.icon_home_select, R.drawable.icon_home, (String) null, (String) null, (String) null, (String) null, false, 0, 504, (t9.g) null));
        String string2 = this.f7502a.getString(R.string.nav_button_live);
        t9.i.f(string2, "context.getString(R.string.nav_button_live)");
        arrayList.add(new MainTabEntity(string2, R.drawable.icon_tv_select, R.drawable.icon_tv, (String) null, (String) null, (String) null, (String) null, false, 0, 504, (t9.g) null));
        arrayList.add(u0());
        return arrayList;
    }

    public final void F0() {
        w6.i.f9510g.b().S1().compose(this.f7502a.O1()).subscribe(new p());
    }

    public final i6.v G0() {
        return this.f7503b;
    }

    public final void H0(String str) {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13 = true;
        if (str == null || str.length() == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10) {
            i.c cVar = w6.i.f9510g;
            if (t9.i.b(cVar.e(), "1")) {
                String I = cVar.I();
                switch (I.hashCode()) {
                    case 50:
                        if (I.equals("2")) {
                            String o10 = d6.b.f6366a.o();
                            String str2 = "vip_expire_key" + cVar.H();
                            if (com.mobile.brasiltv.utils.b0.K(o10)) {
                                App.a aVar = App.f6050e;
                                if (!t9.i.b(o10, na.f.e(aVar.a(), str2))) {
                                    this.f7503b.Y(0, str);
                                    na.f.k(aVar.a(), str2, o10);
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        return;
                    case 51:
                        if (I.equals("3")) {
                            int n10 = cVar.n();
                            String n11 = d6.b.f6366a.n();
                            String str3 = "vip_expire_soon_key" + cVar.H();
                            if (4 > n10 || n10 >= 8) {
                                z11 = false;
                            } else {
                                z11 = true;
                            }
                            if (z11 && com.mobile.brasiltv.utils.b0.K(n11)) {
                                App.a aVar2 = App.f6050e;
                                if (!t9.i.b(n11, na.f.e(aVar2.a(), str3))) {
                                    this.f7503b.Y(cVar.n(), str);
                                    na.f.k(aVar2.a(), str3, n11);
                                    return;
                                }
                            }
                            if (1 > n10 || n10 >= 4) {
                                z13 = false;
                            }
                            if (z13) {
                                Object obj = this.f7513l.get(cVar.H());
                                Boolean bool = Boolean.TRUE;
                                if (!t9.i.b(obj, bool)) {
                                    this.f7503b.Y(cVar.n(), str);
                                    this.f7513l.put(cVar.H(), bool);
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        return;
                    case 52:
                        if (I.equals("4")) {
                            int z14 = cVar.z();
                            String o11 = d6.b.f6366a.o();
                            String str4 = "vip_expire_soon_key" + cVar.H();
                            if (4 > z14 || z14 >= 8) {
                                z12 = false;
                            } else {
                                z12 = true;
                            }
                            if (z12 && com.mobile.brasiltv.utils.b0.K(o11)) {
                                App.a aVar3 = App.f6050e;
                                if (!t9.i.b(o11, na.f.e(aVar3.a(), str4))) {
                                    this.f7503b.Y(cVar.z(), str);
                                    na.f.k(aVar3.a(), str4, o11);
                                    return;
                                }
                            }
                            if (1 > z14 || z14 >= 4) {
                                z13 = false;
                            }
                            if (z13) {
                                Object obj2 = this.f7513l.get(cVar.H());
                                Boolean bool2 = Boolean.TRUE;
                                if (!t9.i.b(obj2, bool2)) {
                                    this.f7503b.Y(cVar.z(), str);
                                    this.f7513l.put(cVar.H(), bool2);
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }
    }

    public final void I0(UpdateBean updateBean) {
        boolean z10;
        d5.c cVar = new d5.c();
        boolean z11 = false;
        if (updateBean.getForceUpdate() == 1) {
            z10 = true;
        } else {
            z10 = false;
        }
        cVar.q(z10);
        cVar.w(updateBean.getMd5());
        cVar.y(updateBean.getUrl());
        cVar.x(updateBean.getSpareUrl());
        cVar.p(s6.a.f9335a.a().i());
        cVar.t(updateBean.getDefaultDownloadUrl());
        com.mobile.brasiltv.utils.x xVar = com.mobile.brasiltv.utils.x.f12622a;
        cVar.v(xVar.h());
        cVar.u(y5.a.f19919a);
        cVar.s(R.mipmap.ic_logo);
        cVar.r(R.mipmap.ic_logo);
        cVar.n(na.a.c());
        String r02 = r0();
        if (r02.length() == 0) {
            z11 = true;
        }
        if (z11) {
            r02 = w6.i.f9510g.l();
        }
        cVar.z(r02);
        cVar.o(xVar.h());
        i7.a m10 = new i7.a(this.f7502a, updateBean, cVar, Boolean.FALSE).m(new r0(this));
        t9.i.f(m10, "CommonUpgradeDialog(cont…Dialog)\n                }");
        com.mobile.brasiltv.utils.b0.S(m10, DialogManager.DIALOG_UPDATE);
        xa.c.c().m(new HasNewUpdateEvent(true));
    }

    public final void K0() {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        q qVar = new q();
        String obj = m7.c.i().first.toString();
        String obj2 = m7.c.i().second.toString();
        String f10 = na.f.f(this.f7502a, "DCS_URL", "");
        t9.i.f(f10, "urlStr");
        boolean z15 = true;
        if (f10.length() > 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            List<String> M = ba.t.M(ba.s.j(ba.s.j(ba.s.j(ba.s.j(f10, obj, "", false, 4, (Object) null), obj2, "", false, 4, (Object) null), "http://", "", false, 4, (Object) null), "https://", "", false, 4, (Object) null), new String[]{"|"}, false, 0, 6, (Object) null);
            if (com.mobile.brasiltv.utils.b0.I(M)) {
                String str = "";
                String str2 = str;
                for (String str3 : M) {
                    if (str3.length() > 0) {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                    if (z12) {
                        if (str.length() == 0) {
                            z13 = true;
                        } else {
                            z13 = false;
                        }
                        if (z13) {
                            str = str3;
                        } else {
                            if (str2.length() == 0) {
                                z14 = true;
                            } else {
                                z14 = false;
                            }
                            if (z14) {
                                str2 = str3;
                            }
                        }
                    }
                }
                if (str.length() > 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (z11) {
                    obj = str;
                }
                if (str2.length() <= 0) {
                    z15 = false;
                }
                if (z15) {
                    obj2 = str2;
                }
            }
            na.f.k(this.f7502a, "DCS_URL", "");
        }
        t2.a.f9350a.k(App.f6050e.a(), new h9.k(obj, obj2), qVar, new ja.c(".dcs"));
    }

    public final void L0() {
        if (s6.a.f9335a.a().t()) {
            MainAty.a aVar = MainAty.A;
            if (!com.mobile.brasiltv.utils.b0.I(aVar.g())) {
                String h10 = na.f.h(this.f7502a, "home", "home_data");
                if (!TextUtils.isEmpty(h10)) {
                    ArrayList arrayList = (ArrayList) new Gson().fromJson(h10, new s().getType());
                    if (com.mobile.brasiltv.utils.b0.I(arrayList)) {
                        aVar.a().clear();
                        aVar.a().addAll(arrayList);
                    }
                }
                n0 n0Var = n0.f12601a;
                String str = "";
                String e10 = n0Var.e(this.f7502a, "home_data_version", str);
                String e11 = n0Var.e(this.f7502a, "home_data_free_version", str);
                w6.i b10 = w6.i.f9510g.b();
                if (e10 == null) {
                    e10 = str;
                }
                if (e11 != null) {
                    str = e11;
                }
                b10.x1(e10, str).compose(this.f7502a.O1()).subscribe(new r(this));
            }
        }
    }

    public final void M0() {
        g0();
        if (RootColumnId.mainId != -1) {
            k7.f.e("请求过根栏目，已加载fragment，不再加载根栏目", new Object[0]);
            return;
        }
        t9.w wVar = new t9.w();
        t9.w wVar2 = new t9.w();
        Observable.create(new v0(wVar, this, wVar2)).compose(ma.q.b()).subscribe(new w0(new t(wVar2, this)));
    }

    public final void P0(String str, String str2, String str3, String str4, String str5) {
        String str6 = str;
        String str7 = str4;
        t9.i.g(str6, "userName");
        t9.i.g(str2, "password");
        t9.i.g(str3, "verificationToken");
        t9.i.g(str7, "qrAuthCode");
        t9.i.g(str5, "areaCode");
        d6.b bVar = d6.b.f6366a;
        bVar.h(this.f7502a);
        t9.w wVar = new t9.w();
        wVar.f19600a = bVar.j(this.f7502a);
        boolean z10 = false;
        k7.f.e("loginType:" + ((String) wVar.f19600a), new Object[0]);
        t9.w wVar2 = new t9.w();
        wVar2.f19600a = str6;
        if (TextUtils.equals((CharSequence) wVar.f19600a, "4")) {
            wVar.f19600a = CdnType.DIGITAL_TYPE_PCDN;
        }
        if (t9.i.b(wVar.f19600a, "7")) {
            if (str4.length() > 0) {
                z10 = true;
            }
            if (z10) {
                wVar2.f19600a = str7;
            }
        }
        w6.i.f9510g.b().W1((String) wVar.f19600a, str5, (String) wVar2.f19600a, str2, (String) null, (String) null, str3).compose(this.f7502a.O1()).subscribe(new u(this, wVar, str, str2, str4, str5, wVar2, str3));
    }

    public final void Q0(String str, String str2) {
        w6.i.f9510g.b().Z1(new LoginThirdPartBean(str, str2, "0", "1", (String) null, 16, (t9.g) null)).compose(this.f7502a.O1()).subscribe(new v(this, str, str2));
    }

    public final void R0() {
        if (!TextUtils.isEmpty(w6.i.f9510g.E())) {
            MemberInfo memberInfo = MemberInfo.INSTANCE;
            String lastUserName = memberInfo.getLastUserName();
            String lastPassword = memberInfo.getLastPassword();
            String e10 = na.f.e(this.f7502a, "verification_token");
            String e11 = na.f.e(this.f7502a, "qr_auth_code");
            String e12 = na.f.e(this.f7502a, "login_area_code");
            d6.b bVar = d6.b.f6366a;
            bVar.h(this.f7502a);
            String j10 = bVar.j(this.f7502a);
            String k10 = bVar.k(this.f7502a);
            if (bVar.v(this.f7502a) && com.mobile.brasiltv.utils.b0.K(k10)) {
                com.mobile.brasiltv.utils.b0.U(this, "tp type login");
                Q0(j10, k10);
            } else if (!TextUtils.isEmpty(e11) || (!TextUtils.isEmpty(lastUserName) && (!TextUtils.isEmpty(lastPassword) || !TextUtils.isEmpty(e10)))) {
                k7.f.e("存在用户名密码，登录", new Object[0]);
                t9.i.f(e10, "verificationToken");
                t9.i.f(e11, "qrAuthCode");
                t9.i.f(e12, "areaCode");
                P0(lastUserName, lastPassword, e10, e11, e12);
            } else {
                k7.f.e("存在SN，不存在用户名密码，激活", new Object[0]);
                Z();
            }
        } else {
            k7.f.e("不存在SN，获取SNToken", new Object[0]);
            C0();
        }
    }

    public final void S0() {
        t9.w wVar = new t9.w();
        StringBuilder sb = new StringBuilder();
        i.c cVar = w6.i.f9510g;
        sb.append(cVar.H());
        sb.append("isHasCouponQualification");
        String sb2 = sb.toString();
        String str = cVar.H() + "couponQualificationTime";
        String str2 = cVar.H() + "couponQualificationInvalidTime";
        String f10 = na.f.f(this.f7502a, str, "0");
        t9.i.f(f10, "getStrings(context, spKeyTime, \"0\")");
        long parseLong = Long.parseLong(f10);
        String f11 = na.f.f(this.f7502a, str2, "0");
        t9.i.f(f11, "getStrings(context, spKeyInvalidTime, \"0\")");
        if (y6.a.j() - parseLong < Long.parseLong(f11)) {
            cVar.i0(na.f.c(this.f7502a, sb2, false));
        } else {
            wVar.f19600a = "1";
        }
        cVar.b().M0("0", (String) wVar.f19600a).compose(this.f7502a.O1()).filter(new x0(x.f17637a)).observeOn(Schedulers.computation()).subscribe(new y(wVar, this, sb2, str, str2));
    }

    public final void U0() {
        IntentFilter intentFilter = new IntentFilter("android.intent.action.BATTERY_CHANGED");
        z zVar = new z(this);
        this.f7514m = zVar;
        this.f7502a.registerReceiver(zVar, intentFilter);
    }

    public final void V0() {
        w6.i.f9510g.b().U0().compose(this.f7502a.O1()).subscribe(new a0(this));
    }

    public final void W0() {
        boolean z10;
        String str;
        RootColumnId.mainId = -1;
        i.c cVar = w6.i.f9510g;
        if (cVar.E().length() > 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            str = cVar.E();
        } else {
            str = "";
        }
        k7.f.e("sn：" + str, new Object[0]);
        boolean j10 = t2.a.f9350a.j();
        z2.c a10 = z2.c.f9923d.a();
        String E = cVar.E();
        String g10 = na.a.g();
        t9.i.f(g10, "getPackageName()");
        String str2 = Build.VERSION.RELEASE;
        t9.i.f(str2, "RELEASE");
        String str3 = na.c.f19074b;
        t9.i.f(str3, "encryptReserve1");
        a10.g(E, "", "", (String) null, (String) null, g10, str2, str3, 1, r0(), s0()).compose(this.f7502a.P1(t8.a.DESTROY)).subscribe(new b0(this, j10));
        if (j10) {
            R0();
            F0();
        }
    }

    public final void X0() {
        String str;
        i.c cVar = w6.i.f9510g;
        String I = cVar.I();
        if (t9.i.b(I, "3") || t9.i.b(I, "4") || t9.i.b(cVar.e(), "0")) {
            n0 n0Var = n0.f12601a;
            if (!n0.c(n0Var, this.f7502a, "live_first_play_free_column", false, 4, (Object) null)) {
                n0Var.i(this.f7502a, "live_last_play_column_index", 0);
                z.a aVar = b6.z.f4508u;
                if (com.mobile.brasiltv.utils.b0.H(aVar.c())) {
                    str = aVar.c();
                } else {
                    str = "";
                }
                n0Var.j(this.f7502a, "live_last_play_chanel", str);
                aVar.n(str);
            }
            n0.h(n0Var, this.f7502a, "live_first_play_free_column", false, 4, (Object) null);
        }
    }

    public final void Y0() {
        DialogManager.INSTANCE.reset();
    }

    public final void Z() {
        Disposable disposable = this.f7506e;
        if (disposable != null) {
            disposable.dispose();
        }
        w6.i.f9510g.b().J0().subscribe(new a(this));
    }

    public final void Z0(SwitchAccountBean switchAccountBean) {
        Observable.create(new l0(this, switchAccountBean)).compose(ma.q.b()).subscribe(new m0(new c0(this)), new n0(new d0(this)));
    }

    public final void a0(UserData userData) {
        String str;
        String str2;
        k7.f.e("cacheColumnTime: userData: " + userData, new Object[0]);
        String str3 = null;
        if (userData != null) {
            str = userData.getCacheTime();
        } else {
            str = null;
        }
        if (!com.mobile.brasiltv.utils.b0.J(str)) {
            if (userData != null) {
                str2 = userData.getCacheTime();
            } else {
                str2 = null;
            }
            if (!t9.i.b(str2, "0")) {
                if (userData != null) {
                    str3 = userData.getCacheTime();
                }
                String str4 = str3;
                t9.i.d(str4);
                List M = ba.t.M(str4, new String[]{","}, false, 0, 6, (Object) null);
                if (M.isEmpty()) {
                    f5.c cVar = this.f7502a;
                    String cacheTime = userData.getCacheTime();
                    t9.i.d(cacheTime);
                    na.f.j(cVar, "column_cache_time", Integer.parseInt(cacheTime));
                } else if (M.size() > 1) {
                    na.f.j(this.f7502a, "column_cache_time", Integer.parseInt((String) M.get(0)) + Integer.parseInt((String) M.get(1)));
                }
            }
        }
    }

    public final void b0(int i10) {
        long days = ((long) i10) - TimeUnit.MILLISECONDS.toDays(Math.abs(new Date(com.mobile.brasiltv.utils.b0.Z(na.e.f19078d)).getTime() - new Date(com.mobile.brasiltv.utils.b0.Z(n0.f12601a.e(this.f7502a, "first_active_time_new", "0"))).getTime()));
        if (days > 0) {
            d0(false, (int) days);
        } else {
            e0(this, true, 0, 2, (Object) null);
        }
    }

    public final void c0() {
        s1.m mVar = s1.m.f9270a;
        f5.c cVar = this.f7502a;
        i.c cVar2 = w6.i.f9510g;
        s1.m.Z(mVar, cVar, cVar2.E(), cVar2.l(), new ja.c(".advert"), new d(), (String) null, false, new la.a(".advert"), 96, (Object) null);
    }

    public final void d0(boolean z10, int i10) {
        if (z10) {
            this.f7503b.m1();
        } else {
            this.f7503b.a2(i10);
        }
    }

    public final void d1(String str, boolean z10) {
        i.c cVar = w6.i.f9510g;
        cVar.a0(str);
        cVar.w0("1");
        s1.m.f9270a.e0(cVar.E(), cVar.l());
        c2.l.f4666a.e(cVar.l(), cVar.E());
        if (z10) {
            y0.f12657a.N(this.f7502a);
        }
    }

    public void e() {
        if (!xa.c.c().h(this)) {
            xa.c.c().o(this);
        }
        Observable.create(new k0(this)).map(new s0(new e0(this))).compose(ma.q.b()).subscribe(new t0(new f0(this)), new u0(g0.f17600a));
    }

    public final void e1() {
        if (w6.i.f9510g.N()) {
            com.mobile.brasiltv.utils.e0.f12514a.e(App.f6050e.a(), "keyShowVodFreeIntro", true);
        }
    }

    public final void f0(UserData userData) {
        String str;
        if (userData != null) {
            str = userData.getBindMail();
        } else {
            str = null;
        }
        if (t9.i.b(str, "0")) {
            n0 n0Var = n0.f12601a;
            if (t9.i.b(n0Var.e(this.f7502a, "first_active_time_new", "0"), "0")) {
                n0Var.j(this.f7502a, "first_active_time_new", na.e.f19078d);
            }
            V0();
        }
    }

    public void g() {
        if (xa.c.c().h(this)) {
            xa.c.c().r(this);
        }
        z0().f();
        Disposable disposable = this.f7506e;
        if (disposable != null) {
            disposable.dispose();
        }
        this.f7502a.stopService(NetService.f6158h.a());
        String language = Locale.getDefault().getLanguage();
        StringBuilder sb = new StringBuilder();
        sb.append("old language: ");
        MainAty.a aVar = MainAty.A;
        sb.append(aVar.b());
        sb.append(" cur language: ");
        sb.append(language);
        com.mobile.brasiltv.utils.b0.U(this, sb.toString());
        if (TextUtils.equals(aVar.b(), language)) {
            aVar.p(false);
            v5.g.f19670a.p();
            r5.i.f19378a.J();
            d6.b.f6366a.A();
            w5.m.f19701a.X();
            f1.f12517a.v();
            j1();
            ma.l.a("MainAty");
            return;
        }
        t9.i.f(language, "curLanguage");
        aVar.k(language);
    }

    public final void g0() {
        if (!this.f7505d) {
            if (!com.mobile.brasiltv.utils.b0.h(this.f7502a, "com.android.vending")) {
                i1.q(this.f7502a, w6.i.f9510g.l());
            }
            w7.a aVar = w7.a.f19762a;
            f5.c cVar = this.f7502a;
            String string = cVar.getResources().getString(R.string.server_client_id);
            t9.i.f(string, "context.resources.getStr….string.server_client_id)");
            z7.b a10 = aVar.a(cVar, 1, string);
            int c10 = a10.c(this.f7502a);
            this.f7505d = true;
            if (!a10.a(c10)) {
                i1.x(this.f7502a, w6.i.f9510g.l(), c10);
            }
        }
    }

    @xa.j
    public final void getFreeTimeEvent(GetFreeTimeEvent getFreeTimeEvent) {
        t9.i.g(getFreeTimeEvent, "event");
        p0();
        S0();
    }

    public final void h0() {
        f5.c cVar = this.f7502a;
        i.c cVar2 = w6.i.f9510g;
        CheckNoticeUtils.b(cVar, cVar2.l(), cVar2.H()).filter(new y0(e.f17595a)).subscribe(new z0(new f(this)), new a1(g.f17599a));
    }

    public final void j1() {
        BroadcastReceiver broadcastReceiver = this.f7514m;
        if (broadcastReceiver != null) {
            this.f7502a.unregisterReceiver(broadcastReceiver);
            this.f7514m = null;
            this.f7515n = null;
        }
    }

    public final void k1(List list, long j10) {
        boolean z10;
        boolean z11;
        boolean z12;
        String i10 = y6.a.i(j10, "yyyy-MM-dd");
        v5.g gVar = v5.g.f19670a;
        boolean z13 = false;
        gVar.v(0);
        gVar.g(list.size());
        Iterator it = list.iterator();
        String str = "";
        while (it.hasNext()) {
            CouponCodeList couponCodeList = (CouponCodeList) it.next();
            if (t9.i.b(couponCodeList.getStatus(), "0")) {
                if (couponCodeList.getInvalidTime().length() > 0) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (z10) {
                    long m10 = y6.a.m(couponCodeList.getInvalidTime(), "yyyy-MM-dd HH:mm:ss") / ((long) 1000);
                    String substring = couponCodeList.getInvalidTime().substring(0, 11);
                    t9.i.f(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                    if (str.length() > 0) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    if (!z11 || substring.compareTo(str) <= 0) {
                        long j11 = m10 - j10;
                        if (j11 > 0 && j11 < 259200) {
                            if (str.length() == 0) {
                                z12 = true;
                            } else {
                                z12 = false;
                            }
                            if (z12 || str.compareTo(substring) > 0) {
                                str = substring;
                            }
                            if (t9.i.b(str, i10)) {
                                break;
                            }
                        }
                    }
                } else {
                    continue;
                }
            }
        }
        if (str.length() == 0) {
            z13 = true;
        }
        if (!z13) {
            f5.c cVar = this.f7502a;
            StringBuilder sb = new StringBuilder();
            i.c cVar2 = w6.i.f9510g;
            sb.append(cVar2.H());
            sb.append("coupon_date_key");
            String f10 = na.f.f(cVar, sb.toString(), "");
            if (!t9.i.b(f10, str) && f10.compareTo(str) < 0) {
                f5.c cVar3 = this.f7502a;
                na.f.k(cVar3, cVar2.H() + "coupon_date_key", str);
                this.f7503b.v1();
            }
        }
    }

    public final void l0() {
        h7.h.f(new u6.c());
        c5.a z02 = z0();
        f5.c cVar = this.f7502a;
        i.c cVar2 = w6.i.f9510g;
        z02.g(cVar, cVar2.E(), cVar2.l(), new h(this));
    }

    public final void l1() {
        boolean z10;
        String e10 = na.a.e();
        t9.i.f(e10, "getDeviceToken()");
        if (e10.length() == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10) {
            w6.i.f9510g.b().o2().compose(this.f7502a.O1()).subscribe(new h0());
        }
    }

    @xa.j
    public final void loginSuccess(LoginSuccessEvent loginSuccessEvent) {
        t9.i.g(loginSuccessEvent, "event");
        com.mobile.brasiltv.utils.k.f12594a.a();
        X0();
        DialogManager.INSTANCE.clearSaveDialog(DialogManager.DIALOG_EXPIRED, DialogManager.DIALOG_NEW_BIND);
        this.f7503b.k0();
        MainAty.A.o(true);
        n0();
        l1();
    }

    public final void m0() {
        String f10 = s6.a.f9335a.a().f(this.f7502a);
        List M = ba.t.M(f10, new String[]{File.separator + "%s"}, false, 0, 6, (Object) null);
        if (M != null && !M.isEmpty()) {
            try {
                z6.a.b(new File((String) M.get(0)));
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
    }

    public final void n0() {
        String str;
        com.mobile.brasiltv.utils.h hVar = com.mobile.brasiltv.utils.h.f12562a;
        if (hVar.o()) {
            if (hVar.s()) {
                str = "VOD";
            } else {
                str = "LIVE";
            }
            xa.c.c().j(new CastToCloseOtherPlayEvent(str, true));
        }
    }

    public void o0() {
        SessionManager sessionManager;
        if (System.currentTimeMillis() - this.f7510i > 2000) {
            f1.f12517a.w(R.string.twice_end_koocan);
            this.f7510i = System.currentTimeMillis();
            return;
        }
        if (s6.a.f9335a.a().p()) {
            com.mobile.brasiltv.utils.g0.f12538a.b();
            CastContext sharedInstance = CastContext.getSharedInstance();
            if (!(sharedInstance == null || (sessionManager = sharedInstance.getSessionManager()) == null)) {
                sessionManager.endCurrentSession(true);
            }
        }
        Object systemService = this.f7502a.getSystemService("notification");
        t9.i.e(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        ((NotificationManager) systemService).cancelAll();
        q8.e.a("stop");
        c2.i.f4633q.a().h();
        b6.z.f4508u.g().clear();
        this.f7502a.finish();
        ma.h.f18994a.d(this.f7502a, "");
    }

    public final void p0() {
        w6.i.f9510g.b().d1().subscribe(new i(this));
    }

    public final void q0(UserData userData) {
        int i10;
        int i11;
        k7.f.e("不请求授权信息接口", new Object[0]);
        i.c cVar = w6.i.f9510g;
        t9.i.d(userData);
        cVar.t0(userData.getShowFlag());
        String bindMail = userData.getBindMail();
        if (bindMail == null) {
            bindMail = "0";
        }
        cVar.T(bindMail);
        cVar.g0(userData.getHasPay());
        cVar.q0(userData.getRestrictedStatus());
        cVar.h0(userData.getHasPwd());
        cVar.y0(userData.getUserIdentity());
        String childLockPwd = userData.getChildLockPwd();
        String str = "";
        if (childLockPwd == null) {
            childLockPwd = str;
        }
        cVar.W(childLockPwd);
        Integer remainingDays = userData.getRemainingDays();
        if (remainingDays != null) {
            i10 = remainingDays.intValue();
        } else {
            i10 = 0;
        }
        cVar.p0(i10);
        Integer expRemainingDays = userData.getExpRemainingDays();
        if (expRemainingDays != null) {
            i11 = expRemainingDays.intValue();
        } else {
            i11 = 0;
        }
        cVar.c0(i11);
        String qrcodeMessage = userData.getQrcodeMessage();
        if (qrcodeMessage == null) {
            qrcodeMessage = str;
        }
        cVar.o0(qrcodeMessage);
        cVar.P(userData.getActiveTime());
        String playlistUrl = userData.getPlaylistUrl();
        if (playlistUrl == null) {
            playlistUrl = str;
        }
        cVar.k0(playlistUrl);
        d6.b.f6366a.B(userData.getAuthInfoList());
        String tips = userData.getTips();
        if (tips != null) {
            str = tips;
        }
        H0(str);
        cVar.S(cVar.y() + "?lang=" + com.mobile.brasiltv.utils.f0.a() + "&userId=" + cVar.H() + "&packageId=&appId=" + na.a.g() + "&packageType=1&appVersion=" + na.a.b() + "&timeStamp=" + System.currentTimeMillis() + "&tk=" + cVar.J() + "&loginType=3");
        StringBuilder sb = new StringBuilder();
        sb.append("购买VIP连接：");
        sb.append(cVar.g());
        k7.f.e(sb.toString(), new Object[0]);
        if (t9.i.b(userData.getGetFreeAuthFlag(), "yes") && t9.i.b(userData.getUserIdentity(), "1") && t9.i.b(userData.getHasPay(), "0") && t9.i.b(userData.getHasFreeAuth(), "0")) {
            y0();
        }
        B0();
        xa.c.c().m(new UpdateMineViewEvent());
    }

    public final String r0() {
        return (String) this.f7508g.getValue();
    }

    @xa.j
    public final void requestActive(RequestActiveEvent requestActiveEvent) {
        NoticeDialog noticeDialog;
        t9.i.g(requestActiveEvent, "event");
        boolean z10 = false;
        k7.f.e("收到请求激活事件", new Object[0]);
        Z();
        DialogManager.INSTANCE.clearSaveDialog(DialogManager.DIALOG_EXPIRED, DialogManager.DIALOG_NEW_BIND, DialogManager.DIALOG_NOTICE);
        this.f7503b.k0();
        NoticeDialog noticeDialog2 = this.f7507f;
        if (noticeDialog2 != null && noticeDialog2.isShowing()) {
            z10 = true;
        }
        if (z10 && (noticeDialog = this.f7507f) != null) {
            com.mobile.brasiltv.utils.b0.j(noticeDialog);
        }
        MainAty.A.o(true);
        n0();
    }

    @xa.j
    public final void requestAuthAndSlb(RequestAuthAndSlbEvent requestAuthAndSlbEvent) {
        t9.i.g(requestAuthAndSlbEvent, "event");
        k7.f.e("收到请求授权信息和slb事件", new Object[0]);
        h0();
        M0();
        L0();
        if (requestAuthAndSlbEvent.isNeedGetAuthInfo() || requestAuthAndSlbEvent.getUserData() == null) {
            p0();
        } else {
            q0(requestAuthAndSlbEvent.getUserData());
        }
        S0();
        d6.a.f16338a.k();
    }

    public final String s0() {
        return (String) this.f7509h.getValue();
    }

    public final f5.c t0() {
        return this.f7502a;
    }

    public final MainTabEntity u0() {
        String d10 = y6.a.d("MM-dd HH:mm");
        if (d10.compareTo("10-28 00:00:00") > 0 && d10.compareTo("11-04 00:00:00") < 0) {
            String string = this.f7502a.getString(R.string.nav_button_mine);
            t9.i.f(string, "context.getString(R.string.nav_button_mine)");
            return new MainTabEntity(string, R.drawable.icon_my_halloween_select, R.drawable.icon_my_halloween, (String) null, (String) null, (String) null, (String) null, false, 0, 504, (t9.g) null);
        } else if (d10.compareTo("12-22 00:00:00") > 0 && d10.compareTo("12-29 00:00:00") < 0) {
            String string2 = this.f7502a.getString(R.string.nav_button_mine);
            t9.i.f(string2, "context.getString(R.string.nav_button_mine)");
            return new MainTabEntity(string2, R.drawable.icon_my_christmas_select, R.drawable.icon_my_christmas, (String) null, (String) null, (String) null, (String) null, false, 0, 504, (t9.g) null);
        } else if (d10.compareTo("12-29 00:00:00") > 0 || d10.compareTo("01-05 00:00:00") < 0) {
            String string3 = this.f7502a.getString(R.string.nav_button_mine);
            t9.i.f(string3, "context.getString(R.string.nav_button_mine)");
            return new MainTabEntity(string3, R.drawable.icon_my_new_years_select, R.drawable.icon_my_new_years, (String) null, (String) null, (String) null, (String) null, false, 0, 504, (t9.g) null);
        } else {
            String string4 = this.f7502a.getString(R.string.nav_button_mine);
            t9.i.f(string4, "context.getString(R.string.nav_button_mine)");
            return new MainTabEntity(string4, R.drawable.icon_my_select, R.drawable.icon_my, (String) null, (String) null, (String) null, (String) null, false, 0, 504, (t9.g) null);
        }
    }

    public final void v0() {
        FirebaseDynamicLinksKt.getDynamicLinks(Firebase.INSTANCE).getDynamicLink(this.f7502a.getIntent()).addOnSuccessListener((Activity) this.f7502a, new p0(new j(this))).addOnFailureListener((Activity) this.f7502a, (OnFailureListener) new q0());
    }

    public final void y0() {
        w6.i.f9510g.b().w1().compose(this.f7502a.O1()).subscribe(new k(this));
    }

    public final c5.a z0() {
        return (c5.a) this.f7511j.getValue();
    }
}
