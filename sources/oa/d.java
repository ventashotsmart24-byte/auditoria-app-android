package oa;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import java.net.Proxy;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.X509TrustManager;
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
import okhttp3.Dispatcher;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

public class d {

    /* renamed from: a  reason: collision with root package name */
    public qa.b f19156a;

    /* renamed from: b  reason: collision with root package name */
    public qa.b f19157b;

    /* renamed from: c  reason: collision with root package name */
    public qa.b f19158c;

    /* renamed from: d  reason: collision with root package name */
    public qa.b f19159d;

    /* renamed from: e  reason: collision with root package name */
    public Interceptor f19160e;

    /* renamed from: f  reason: collision with root package name */
    public Gson f19161f;

    /* renamed from: g  reason: collision with root package name */
    public int f19162g;

    public class a extends fa.a {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f19163b;

        public a(String str) {
            this.f19163b = str;
        }

        /* renamed from: c */
        public Observable a(Throwable th) {
            if (d.this.f19157b == null || (th instanceof ResultException)) {
                return Observable.error(th);
            }
            return d.this.f19157b.l(this.f19163b);
        }
    }

    public class a0 extends fa.a {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f19165b;

        public a0(String str) {
            this.f19165b = str;
        }

        /* renamed from: c */
        public Observable a(Throwable th) {
            if (d.this.f19157b == null || (th instanceof ResultException)) {
                return Observable.error(th);
            }
            return d.this.f19157b.h0(this.f19165b);
        }
    }

    public class a1 extends fa.a {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f19167b;

        public a1(String str) {
            this.f19167b = str;
        }

        /* renamed from: c */
        public Observable a(Throwable th) {
            if (d.this.f19157b == null || (th instanceof ResultException)) {
                return Observable.error(th);
            }
            return d.this.f19157b.O(this.f19167b);
        }
    }

    public class b extends fa.a {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f19169b;

        public b(String str) {
            this.f19169b = str;
        }

        /* renamed from: c */
        public Observable a(Throwable th) {
            if (d.this.f19157b == null || (th instanceof ResultException)) {
                return Observable.error(th);
            }
            return d.this.f19157b.i0(this.f19169b);
        }
    }

    public class b0 extends fa.a {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f19171b;

        public b0(String str) {
            this.f19171b = str;
        }

        /* renamed from: c */
        public Observable a(Throwable th) {
            if (d.this.f19157b == null || (th instanceof ResultException)) {
                return Observable.error(th);
            }
            return d.this.f19157b.D(this.f19171b);
        }
    }

    public class b1 extends fa.a {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f19173b;

        public b1(String str) {
            this.f19173b = str;
        }

        /* renamed from: c */
        public Observable a(Throwable th) {
            if (d.this.f19157b == null || (th instanceof ResultException)) {
                return Observable.error(th);
            }
            return d.this.f19157b.v0(this.f19173b);
        }
    }

    public class c extends fa.a {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f19175b;

        public c(String str) {
            this.f19175b = str;
        }

        /* renamed from: c */
        public Observable a(Throwable th) {
            if (d.this.f19159d == null || (th instanceof ResultException)) {
                return Observable.error(th);
            }
            return d.this.f19159d.f0(this.f19175b);
        }
    }

    public class c0 extends fa.a {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f19177b;

        public c0(String str) {
            this.f19177b = str;
        }

        /* renamed from: c */
        public Observable a(Throwable th) {
            if (d.this.f19157b == null || (th instanceof ResultException)) {
                return Observable.error(th);
            }
            return d.this.f19157b.n0(this.f19177b);
        }
    }

    public class c1 extends fa.a {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f19179b;

        public c1(String str) {
            this.f19179b = str;
        }

        /* renamed from: c */
        public Observable a(Throwable th) {
            if (d.this.f19157b == null || (th instanceof ResultException)) {
                return Observable.error(th);
            }
            return d.this.f19157b.c(this.f19179b);
        }
    }

    /* renamed from: oa.d$d  reason: collision with other inner class name */
    public class C0279d extends fa.a {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f19181b;

        public C0279d(String str) {
            this.f19181b = str;
        }

        /* renamed from: c */
        public Observable a(Throwable th) {
            if (d.this.f19157b == null || (th instanceof ResultException)) {
                return Observable.error(th);
            }
            return d.this.f19157b.g0(this.f19181b);
        }
    }

    public class d0 extends fa.a {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f19183b;

        public d0(String str) {
            this.f19183b = str;
        }

        /* renamed from: c */
        public Observable a(Throwable th) {
            if (d.this.f19157b == null || (th instanceof ResultException)) {
                return Observable.error(th);
            }
            return d.this.f19157b.m(this.f19183b);
        }
    }

    public class d1 extends fa.a {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f19185b;

        public d1(String str) {
            this.f19185b = str;
        }

        /* renamed from: c */
        public Observable a(Throwable th) {
            if (d.this.f19157b == null || (th instanceof ResultException)) {
                return Observable.error(th);
            }
            return d.this.f19157b.K0(this.f19185b);
        }
    }

    public class e extends fa.a {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f19187b;

        public e(String str) {
            this.f19187b = str;
        }

        /* renamed from: c */
        public Observable a(Throwable th) {
            if (d.this.f19157b == null || (th instanceof ResultException)) {
                return Observable.error(th);
            }
            return d.this.f19157b.S(this.f19187b);
        }
    }

    public class e0 extends fa.a {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f19189b;

        public e0(String str) {
            this.f19189b = str;
        }

        /* renamed from: c */
        public Observable a(Throwable th) {
            if (d.this.f19157b == null || (th instanceof ResultException)) {
                return Observable.error(th);
            }
            return d.this.f19157b.k0(this.f19189b);
        }
    }

    public class e1 extends fa.a {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f19191b;

        public e1(String str) {
            this.f19191b = str;
        }

        /* renamed from: c */
        public Observable a(Throwable th) {
            if (d.this.f19157b == null || (th instanceof ResultException)) {
                return Observable.error(th);
            }
            return d.this.f19157b.n(this.f19191b);
        }
    }

    public class f extends fa.a {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f19193b;

        public f(String str) {
            this.f19193b = str;
        }

        /* renamed from: c */
        public Observable a(Throwable th) {
            if (d.this.f19157b == null || (th instanceof ResultException)) {
                return Observable.error(th);
            }
            return d.this.f19157b.a0(this.f19193b);
        }
    }

    public class f0 extends fa.a {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f19195b;

        public f0(String str) {
            this.f19195b = str;
        }

        /* renamed from: c */
        public Observable a(Throwable th) {
            if (d.this.f19157b == null || (th instanceof ResultException)) {
                return Observable.error(th);
            }
            return d.this.f19157b.s0(this.f19195b);
        }
    }

    public class f1 extends fa.a {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f19197b;

        public f1(String str) {
            this.f19197b = str;
        }

        /* renamed from: c */
        public Observable a(Throwable th) {
            if (d.this.f19157b == null || (th instanceof ResultException)) {
                return Observable.error(th);
            }
            return d.this.f19157b.C0(this.f19197b);
        }
    }

    public class g extends fa.a {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f19199b;

        public g(String str) {
            this.f19199b = str;
        }

        /* renamed from: c */
        public Observable a(Throwable th) {
            if (d.this.f19157b == null || (th instanceof ResultException)) {
                return Observable.error(th);
            }
            return d.this.f19157b.y0(this.f19199b);
        }
    }

    public class g0 extends fa.a {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f19201b;

        public g0(String str) {
            this.f19201b = str;
        }

        /* renamed from: c */
        public Observable a(Throwable th) {
            if (d.this.f19157b == null || (th instanceof ResultException)) {
                return Observable.error(th);
            }
            return d.this.f19157b.j(this.f19201b);
        }
    }

    public class g1 extends fa.a {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f19203b;

        public g1(String str) {
            this.f19203b = str;
        }

        /* renamed from: c */
        public Observable a(Throwable th) {
            if (d.this.f19157b == null || (th instanceof ResultException)) {
                return Observable.error(th);
            }
            return d.this.f19157b.z(this.f19203b);
        }
    }

    public class h extends fa.a {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f19205b;

        public h(String str) {
            this.f19205b = str;
        }

        /* renamed from: c */
        public Observable a(Throwable th) {
            if (d.this.f19157b == null || (th instanceof ResultException)) {
                return Observable.error(th);
            }
            return d.this.f19157b.K(this.f19205b);
        }
    }

    public class h0 extends fa.a {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f19207b;

        public h0(String str) {
            this.f19207b = str;
        }

        /* renamed from: c */
        public Observable a(Throwable th) {
            if (d.this.f19157b == null || (th instanceof ResultException)) {
                return Observable.error(th);
            }
            return d.this.f19157b.o0(this.f19207b);
        }
    }

    public class h1 extends fa.a {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f19209b;

        public h1(String str) {
            this.f19209b = str;
        }

        /* renamed from: c */
        public Observable a(Throwable th) {
            if (d.this.f19157b == null || (th instanceof ResultException)) {
                return Observable.error(th);
            }
            return d.this.f19157b.a(this.f19209b);
        }
    }

    public class i extends fa.a {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f19211b;

        public i(String str) {
            this.f19211b = str;
        }

        /* renamed from: c */
        public Observable a(Throwable th) {
            if (d.this.f19157b == null || (th instanceof ResultException)) {
                return Observable.error(th);
            }
            return d.this.f19157b.M(this.f19211b);
        }
    }

    public class i0 extends fa.a {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f19213b;

        public i0(String str) {
            this.f19213b = str;
        }

        /* renamed from: c */
        public Observable a(Throwable th) {
            if (d.this.f19157b == null || (th instanceof ResultException)) {
                return Observable.error(th);
            }
            return d.this.f19157b.u0(this.f19213b);
        }
    }

    public class i1 extends fa.a {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f19215b;

        public i1(String str) {
            this.f19215b = str;
        }

        /* renamed from: c */
        public Observable a(Throwable th) {
            if (d.this.f19157b == null || (th instanceof ResultException)) {
                return Observable.error(th);
            }
            return d.this.f19157b.b(this.f19215b);
        }
    }

    public class j extends fa.a {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f19217b;

        public j(String str) {
            this.f19217b = str;
        }

        /* renamed from: c */
        public Observable a(Throwable th) {
            if (d.this.f19157b == null || (th instanceof ResultException)) {
                return Observable.error(th);
            }
            return d.this.f19157b.g(this.f19217b);
        }
    }

    public class j0 extends fa.a {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f19219b;

        public j0(String str) {
            this.f19219b = str;
        }

        /* renamed from: c */
        public Observable a(Throwable th) {
            if (d.this.f19157b == null || (th instanceof ResultException)) {
                return Observable.error(th);
            }
            return d.this.f19157b.v(this.f19219b);
        }
    }

    public class j1 extends fa.a {
        public j1() {
        }

        /* renamed from: c */
        public Observable a(Throwable th) {
            if (d.this.f19157b == null || (th instanceof ResultException)) {
                return Observable.error(th);
            }
            return d.this.f19157b.x("");
        }
    }

    public class k extends fa.a {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f19222b;

        public k(String str) {
            this.f19222b = str;
        }

        /* renamed from: c */
        public Observable a(Throwable th) {
            if (d.this.f19157b == null || (th instanceof ResultException)) {
                return Observable.error(th);
            }
            return d.this.f19157b.o(this.f19222b);
        }
    }

    public class k0 extends fa.a {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f19224b;

        public k0(String str) {
            this.f19224b = str;
        }

        /* renamed from: c */
        public Observable a(Throwable th) {
            if (d.this.f19157b == null || (th instanceof ResultException)) {
                return Observable.error(th);
            }
            return d.this.f19157b.q0(this.f19224b);
        }
    }

    public class k1 extends fa.a {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f19226b;

        public k1(String str) {
            this.f19226b = str;
        }

        /* renamed from: c */
        public Observable a(Throwable th) {
            if (d.this.f19157b == null || (th instanceof ResultException)) {
                return Observable.error(th);
            }
            return d.this.f19157b.s(this.f19226b);
        }
    }

    public class l extends fa.a {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f19228b;

        public l(String str) {
            this.f19228b = str;
        }

        /* renamed from: c */
        public Observable a(Throwable th) {
            if (d.this.f19157b == null || (th instanceof ResultException)) {
                return Observable.error(th);
            }
            return d.this.f19157b.i(this.f19228b);
        }
    }

    public class l0 extends fa.a {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f19230b;

        public l0(String str) {
            this.f19230b = str;
        }

        /* renamed from: c */
        public Observable a(Throwable th) {
            if (d.this.f19157b == null || (th instanceof ResultException)) {
                return Observable.error(th);
            }
            return d.this.f19157b.d(this.f19230b);
        }
    }

    public class l1 extends fa.a {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f19232b;

        public l1(String str) {
            this.f19232b = str;
        }

        /* renamed from: c */
        public Observable a(Throwable th) {
            if (d.this.f19157b == null || (th instanceof ResultException)) {
                return Observable.error(th);
            }
            return d.this.f19157b.d0(this.f19232b);
        }
    }

    public class m extends fa.a {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f19234b;

        public m(String str) {
            this.f19234b = str;
        }

        /* renamed from: c */
        public Observable a(Throwable th) {
            if (d.this.f19157b == null || (th instanceof ResultException)) {
                return Observable.error(th);
            }
            return d.this.f19157b.y(this.f19234b);
        }
    }

    public class m0 extends fa.a {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f19236b;

        public m0(String str) {
            this.f19236b = str;
        }

        /* renamed from: c */
        public Observable a(Throwable th) {
            if (d.this.f19157b == null || (th instanceof ResultException)) {
                return Observable.error(th);
            }
            return d.this.f19157b.t0(this.f19236b);
        }
    }

    public class m1 extends fa.a {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f19238b;

        public m1(String str) {
            this.f19238b = str;
        }

        /* renamed from: c */
        public Observable a(Throwable th) {
            if (d.this.f19157b == null || (th instanceof ResultException)) {
                return Observable.error(th);
            }
            return d.this.f19157b.D0(this.f19238b);
        }
    }

    public class n extends fa.a {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f19240b;

        public n(String str) {
            this.f19240b = str;
        }

        /* renamed from: c */
        public Observable a(Throwable th) {
            if (d.this.f19157b == null || (th instanceof ResultException)) {
                return Observable.error(th);
            }
            return d.this.f19157b.L0(this.f19240b);
        }
    }

    public class n0 extends fa.a {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f19242b;

        public n0(String str) {
            this.f19242b = str;
        }

        /* renamed from: c */
        public Observable a(Throwable th) {
            if (d.this.f19157b == null || (th instanceof ResultException)) {
                return Observable.error(th);
            }
            return d.this.f19157b.t(this.f19242b);
        }
    }

    public class n1 extends fa.a {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f19244b;

        public n1(String str) {
            this.f19244b = str;
        }

        /* renamed from: c */
        public Observable a(Throwable th) {
            if (d.this.f19157b == null || (th instanceof ResultException)) {
                return Observable.error(th);
            }
            return d.this.f19157b.C(this.f19244b);
        }
    }

    public class o extends fa.a {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f19246b;

        public o(String str) {
            this.f19246b = str;
        }

        /* renamed from: c */
        public Observable a(Throwable th) {
            if (d.this.f19157b == null || (th instanceof ResultException)) {
                return Observable.error(th);
            }
            return d.this.f19157b.x0(this.f19246b);
        }
    }

    public class o0 extends fa.a {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f19248b;

        public o0(String str) {
            this.f19248b = str;
        }

        /* renamed from: c */
        public Observable a(Throwable th) {
            if (d.this.f19157b == null || (th instanceof ResultException)) {
                return Observable.error(th);
            }
            return d.this.f19157b.w0(this.f19248b);
        }
    }

    public class o1 extends fa.a {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f19250b;

        public o1(String str) {
            this.f19250b = str;
        }

        /* renamed from: c */
        public Observable a(Throwable th) {
            if (d.this.f19157b == null || (th instanceof ResultException)) {
                return Observable.error(th);
            }
            return d.this.f19157b.T(this.f19250b);
        }
    }

    public class p extends fa.a {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f19252b;

        public p(String str) {
            this.f19252b = str;
        }

        /* renamed from: c */
        public Observable a(Throwable th) {
            if (d.this.f19157b == null || (th instanceof ResultException)) {
                return Observable.error(th);
            }
            return d.this.f19157b.x0(this.f19252b);
        }
    }

    public class p0 extends fa.a {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f19254b;

        public p0(String str) {
            this.f19254b = str;
        }

        /* renamed from: c */
        public Observable a(Throwable th) {
            if (d.this.f19157b == null || (th instanceof ResultException)) {
                return Observable.error(th);
            }
            return d.this.f19157b.N(this.f19254b);
        }
    }

    public class q extends fa.a {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f19256b;

        public q(String str) {
            this.f19256b = str;
        }

        /* renamed from: c */
        public Observable a(Throwable th) {
            if (d.this.f19157b == null || (th instanceof ResultException)) {
                return Observable.error(th);
            }
            return d.this.f19157b.e(this.f19256b);
        }
    }

    public class q0 extends fa.a {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f19258b;

        public q0(String str) {
            this.f19258b = str;
        }

        /* renamed from: c */
        public Observable a(Throwable th) {
            if (d.this.f19157b == null || (th instanceof ResultException)) {
                return Observable.error(th);
            }
            return d.this.f19157b.z0(this.f19258b);
        }
    }

    public class r extends fa.a {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f19260b;

        public r(String str) {
            this.f19260b = str;
        }

        /* renamed from: c */
        public Observable a(Throwable th) {
            if (d.this.f19157b == null || (th instanceof ResultException)) {
                return Observable.error(th);
            }
            return d.this.f19157b.J0(this.f19260b);
        }
    }

    public class r0 extends fa.a {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f19262b;

        public r0(String str) {
            this.f19262b = str;
        }

        /* renamed from: c */
        public Observable a(Throwable th) {
            if (d.this.f19157b == null || (th instanceof ResultException)) {
                return Observable.error(th);
            }
            return d.this.f19157b.B0(this.f19262b);
        }
    }

    public class s extends fa.a {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f19264b;

        public s(String str) {
            this.f19264b = str;
        }

        /* renamed from: c */
        public Observable a(Throwable th) {
            if (d.this.f19157b == null || (th instanceof ResultException)) {
                return Observable.error(th);
            }
            return d.this.f19157b.U(this.f19264b);
        }
    }

    public class s0 extends fa.a {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f19266b;

        public s0(String str) {
            this.f19266b = str;
        }

        /* renamed from: c */
        public Observable a(Throwable th) {
            if (d.this.f19157b == null || (th instanceof ResultException)) {
                return Observable.error(th);
            }
            return d.this.f19157b.w(this.f19266b);
        }
    }

    public class t extends fa.a {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f19268b;

        public t(String str) {
            this.f19268b = str;
        }

        /* renamed from: c */
        public Observable a(Throwable th) {
            if (d.this.f19157b == null || (th instanceof ResultException)) {
                return Observable.error(th);
            }
            return d.this.f19157b.Z(this.f19268b);
        }
    }

    public class t0 extends fa.a {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f19270b;

        public t0(String str) {
            this.f19270b = str;
        }

        /* renamed from: c */
        public Observable a(Throwable th) {
            if (d.this.f19157b == null || (th instanceof ResultException)) {
                return Observable.error(th);
            }
            return d.this.f19157b.J(this.f19270b);
        }
    }

    public class u extends fa.a {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f19272b;

        public u(String str) {
            this.f19272b = str;
        }

        /* renamed from: c */
        public Observable a(Throwable th) {
            if (d.this.f19157b == null || (th instanceof ResultException)) {
                return Observable.error(th);
            }
            return d.this.f19157b.A(this.f19272b);
        }
    }

    public class u0 extends fa.a {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f19274b;

        public u0(String str) {
            this.f19274b = str;
        }

        /* renamed from: c */
        public Observable a(Throwable th) {
            if (d.this.f19157b == null || (th instanceof ResultException)) {
                return Observable.error(th);
            }
            return d.this.f19157b.e0(this.f19274b);
        }
    }

    public class v extends fa.a {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f19276b;

        public v(String str) {
            this.f19276b = str;
        }

        /* renamed from: c */
        public Observable a(Throwable th) {
            if (d.this.f19157b == null || (th instanceof ResultException)) {
                return Observable.error(th);
            }
            return d.this.f19157b.I(this.f19276b);
        }
    }

    public class v0 extends fa.a {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f19278b;

        public v0(String str) {
            this.f19278b = str;
        }

        /* renamed from: c */
        public Observable a(Throwable th) {
            if (d.this.f19157b == null || (th instanceof ResultException)) {
                return Observable.error(th);
            }
            return d.this.f19157b.q(this.f19278b);
        }
    }

    public class w extends fa.a {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f19280b;

        public w(String str) {
            this.f19280b = str;
        }

        /* renamed from: c */
        public Observable a(Throwable th) {
            if (d.this.f19157b == null || (th instanceof ResultException)) {
                return Observable.error(th);
            }
            return d.this.f19157b.I(this.f19280b);
        }
    }

    public class w0 extends fa.a {
        public w0() {
        }

        /* renamed from: c */
        public Observable a(Throwable th) {
            if (d.this.f19157b == null || (th instanceof ResultException)) {
                return Observable.error(th);
            }
            return d.this.f19157b.p0("");
        }
    }

    public class x extends fa.a {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f19283b;

        public x(String str) {
            this.f19283b = str;
        }

        /* renamed from: c */
        public Observable a(Throwable th) {
            if (d.this.f19157b == null || (th instanceof ResultException)) {
                return Observable.error(th);
            }
            return d.this.f19157b.r0(this.f19283b);
        }
    }

    public class x0 extends fa.a {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f19285b;

        public x0(String str) {
            this.f19285b = str;
        }

        /* renamed from: c */
        public Observable a(Throwable th) {
            if (d.this.f19157b == null || (th instanceof ResultException)) {
                return Observable.error(th);
            }
            return d.this.f19157b.j0(this.f19285b);
        }
    }

    public class y extends fa.a {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f19287b;

        public y(String str) {
            this.f19287b = str;
        }

        /* renamed from: c */
        public Observable a(Throwable th) {
            if (d.this.f19157b == null || (th instanceof ResultException)) {
                return Observable.error(th);
            }
            return d.this.f19157b.B(this.f19287b);
        }
    }

    public class y0 extends fa.a {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f19289b;

        public y0(String str) {
            this.f19289b = str;
        }

        /* renamed from: c */
        public Observable a(Throwable th) {
            if (d.this.f19157b == null || (th instanceof ResultException)) {
                return Observable.error(th);
            }
            return d.this.f19157b.R(this.f19289b);
        }
    }

    public class z extends fa.a {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f19291b;

        public z(String str) {
            this.f19291b = str;
        }

        /* renamed from: c */
        public Observable a(Throwable th) {
            if (d.this.f19157b == null || (th instanceof ResultException)) {
                return Observable.error(th);
            }
            return d.this.f19157b.V(this.f19291b);
        }
    }

    public class z0 extends fa.a {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f19293b;

        public z0(String str) {
            this.f19293b = str;
        }

        /* renamed from: c */
        public Observable a(Throwable th) {
            if (d.this.f19157b == null || (th instanceof ResultException)) {
                return Observable.error(th);
            }
            return d.this.f19157b.P(this.f19293b);
        }
    }

    public d() {
        this.f19162g = 15;
        this.f19161f = new GsonBuilder().disableHtmlEscaping().create();
    }

    public Observable A(ConfigBean configBean) {
        String json = this.f19161f.toJson((Object) configBean);
        return this.f19156a.s(json).onErrorResumeNext(new k1(json)).observeOn(AndroidSchedulers.mainThread());
    }

    public Observable B(CustomerService customerService) {
        String json = this.f19161f.toJson((Object) customerService);
        return this.f19156a.a(json).onErrorResumeNext(new h1(json)).observeOn(AndroidSchedulers.mainThread());
    }

    public Observable C(GetDelFavorite getDelFavorite) {
        String json = this.f19161f.toJson((Object) getDelFavorite);
        return this.f19156a.B(json).onErrorResumeNext(new y(json)).observeOn(AndroidSchedulers.mainThread());
    }

    public Observable D() {
        return this.f19156a.p0("").onErrorResumeNext(new w0()).observeOn(AndroidSchedulers.mainThread());
    }

    public Observable E(ExchangeCodeBean exchangeCodeBean) {
        String json = this.f19161f.toJson((Object) exchangeCodeBean);
        return this.f19156a.J(json).onErrorResumeNext(new t0(json)).observeOn(AndroidSchedulers.mainThread());
    }

    public Observable F(GetExchangeOrderBean getExchangeOrderBean) {
        String json = this.f19161f.toJson((Object) getExchangeOrderBean);
        return this.f19156a.A(json).onErrorResumeNext(new u(json)).observeOn(AndroidSchedulers.mainThread());
    }

    public Observable G(GetFavorite getFavorite) {
        String json = this.f19161f.toJson((Object) getFavorite);
        return this.f19156a.V(json).onErrorResumeNext(new z(json)).observeOn(AndroidSchedulers.mainThread());
    }

    public Observable H(FreeTimeBean freeTimeBean) {
        String json = this.f19161f.toJson((Object) freeTimeBean);
        return this.f19156a.D0(json).onErrorResumeNext(new m1(json)).observeOn(AndroidSchedulers.mainThread());
    }

    public Observable I(GetHomeBean getHomeBean) {
        String json = this.f19161f.toJson((Object) getHomeBean);
        return this.f19156a.q(json).onErrorResumeNext(new v0(json)).observeOn(Schedulers.computation());
    }

    public Observable J(GetItemDataBean getItemDataBean) {
        String json = this.f19161f.toJson((Object) getItemDataBean);
        return this.f19156a.K(json).onErrorResumeNext(new h(json)).observeOn(AndroidSchedulers.mainThread());
    }

    public Observable K(GetLiveDataBean getLiveDataBean) {
        String json = this.f19161f.toJson((Object) getLiveDataBean);
        return this.f19156a.i(json).onErrorResumeNext(new l(json)).observeOn(Schedulers.computation());
    }

    public Observable L(GetOrderInfoBean getOrderInfoBean) {
        String json = this.f19161f.toJson((Object) getOrderInfoBean);
        return this.f19156a.I(json).onErrorResumeNext(new v(json)).observeOn(AndroidSchedulers.mainThread());
    }

    public Observable M(OrderInfoBean orderInfoBean) {
        String json = this.f19161f.toJson((Object) orderInfoBean);
        return this.f19156a.I(json).onErrorResumeNext(new w(json)).observeOn(AndroidSchedulers.mainThread());
    }

    public Observable N(GetPriorityVipBean getPriorityVipBean) {
        String json = this.f19161f.toJson((Object) getPriorityVipBean);
        return this.f19156a.C0(json).onErrorResumeNext(new f1(json)).observeOn(AndroidSchedulers.mainThread());
    }

    public Observable O(GetProgramBean getProgramBean) {
        String json = this.f19161f.toJson((Object) getProgramBean);
        return this.f19156a.m(json).onErrorResumeNext(new d0(json)).observeOn(Schedulers.computation());
    }

    public Observable P() {
        return this.f19156a.x("").onErrorResumeNext(new j1()).observeOn(AndroidSchedulers.mainThread());
    }

    public Observable Q(VodRecommendsRequestBean vodRecommendsRequestBean) {
        String json = this.f19161f.toJson((Object) vodRecommendsRequestBean);
        return this.f19156a.M(json).onErrorResumeNext(new i(json)).observeOn(AndroidSchedulers.mainThread());
    }

    public Observable R(ShelveDataRequestBean shelveDataRequestBean) {
        String json = this.f19161f.toJson((Object) shelveDataRequestBean);
        return this.f19156a.y0(json).onErrorResumeNext(new g(json)).observeOn(AndroidSchedulers.mainThread());
    }

    public Observable S(GetShortVideoBean getShortVideoBean) {
        String json = this.f19161f.toJson((Object) getShortVideoBean);
        return this.f19156a.j0(json).onErrorResumeNext(new x0(json)).observeOn(AndroidSchedulers.mainThread());
    }

    public Observable T(GetSlbInfoBean getSlbInfoBean) {
        String json = this.f19161f.toJson((Object) getSlbInfoBean);
        return this.f19156a.y(json).onErrorResumeNext(new m(json)).observeOn(Schedulers.computation());
    }

    public Observable U(ThirdPartBean thirdPartBean) {
        String json = this.f19161f.toJson((Object) thirdPartBean);
        return this.f19156a.j(json).onErrorResumeNext(new g0(json)).observeOn(AndroidSchedulers.mainThread());
    }

    public Observable V(TypeQuestionBean typeQuestionBean) {
        String json = this.f19161f.toJson((Object) typeQuestionBean);
        return this.f19156a.z(json).onErrorResumeNext(new g1(json)).observeOn(AndroidSchedulers.mainThread());
    }

    public Observable W(VerificationBean verificationBean) {
        String json = this.f19161f.toJson((Object) verificationBean);
        return this.f19156a.T(json).onErrorResumeNext(new o1(json)).observeOn(AndroidSchedulers.mainThread());
    }

    public Observable X(HeartBeatBean heartBeatBean) {
        String json = this.f19161f.toJson((Object) heartBeatBean);
        return this.f19156a.i0(json).onErrorResumeNext(new b(json)).observeOn(AndroidSchedulers.mainThread());
    }

    public Observable Y(LoginBean loginBean) {
        String json = this.f19161f.toJson((Object) loginBean);
        return this.f19156a.q0(json).onErrorResumeNext(new k0(json)).observeOn(AndroidSchedulers.mainThread());
    }

    public Observable Z(LoginThirdPartBean loginThirdPartBean) {
        String json = this.f19161f.toJson((Object) loginThirdPartBean);
        return this.f19156a.o0(json).onErrorResumeNext(new h0(json)).observeOn(AndroidSchedulers.mainThread());
    }

    public Observable a0(LogoutBean logoutBean) {
        String json = this.f19161f.toJson((Object) logoutBean);
        return this.f19156a.z0(json).onErrorResumeNext(new q0(json)).observeOn(AndroidSchedulers.mainThread());
    }

    public final qa.b b0(String str, boolean z10) {
        String a10 = ma.t.f19008a.a(str);
        new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
        if (a10 != null) {
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            builder.proxy(Proxy.NO_PROXY);
            Interceptor interceptor = this.f19160e;
            if (interceptor != null) {
                builder.addInterceptor(interceptor);
            }
            TimeUnit timeUnit = TimeUnit.SECONDS;
            builder.connectTimeout((long) this.f19162g, timeUnit).readTimeout((long) this.f19162g, timeUnit).writeTimeout((long) this.f19162g, timeUnit).dispatcher(new Dispatcher(na.a.f())).addInterceptor(new la.c()).addInterceptor(new la.b()).dns(new ja.c(".portal"));
            X509TrustManager a11 = ma.f.a();
            if (a11 != null) {
                builder.sslSocketFactory(new ma.r(a11), a11);
            }
            return (qa.b) new Retrofit.Builder().client(builder.build()).baseUrl(a10).addCallAdapterFactory(RxJava2CallAdapterFactory.createAsync()).addConverterFactory(ia.a.b(z10)).build().create(qa.b.class);
        }
        throw new NullPointerException("url can't be null!");
    }

    public Observable c(ActiveBean activeBean) {
        String json = this.f19161f.toJson((Object) activeBean);
        return this.f19156a.D(json).onErrorResumeNext(new b0(json)).observeOn(AndroidSchedulers.mainThread());
    }

    public Observable c0(PwdCheckBean pwdCheckBean) {
        String json = this.f19161f.toJson((Object) pwdCheckBean);
        return this.f19156a.S(json).onErrorResumeNext(new e(json)).observeOn(AndroidSchedulers.mainThread());
    }

    public Observable d(GetAddSubscribe getAddSubscribe) {
        String json = this.f19161f.toJson((Object) getAddSubscribe);
        return this.f19156a.h0(json).onErrorResumeNext(new a0(json)).observeOn(AndroidSchedulers.mainThread());
    }

    public Observable d0(QrGetResultBean qrGetResultBean) {
        String json = this.f19161f.toJson((Object) qrGetResultBean);
        return this.f19156a.e(json).onErrorResumeNext(new q(json)).observeOn(AndroidSchedulers.mainThread());
    }

    public Observable e(ApkQueryCouponBean apkQueryCouponBean) {
        String json = this.f19161f.toJson((Object) apkQueryCouponBean);
        return this.f19156a.B0(json).onErrorResumeNext(new r0(json)).observeOn(AndroidSchedulers.mainThread());
    }

    public Observable e0(QueryMsgNumParams queryMsgNumParams) {
        String json = this.f19161f.toJson((Object) queryMsgNumParams);
        return this.f19156a.v0(json).onErrorResumeNext(new b1(json)).observeOn(AndroidSchedulers.mainThread());
    }

    public Observable f(ApkReceiveCouponBean apkReceiveCouponBean) {
        String json = this.f19161f.toJson((Object) apkReceiveCouponBean);
        return this.f19156a.w(json).onErrorResumeNext(new s0(json)).observeOn(AndroidSchedulers.mainThread());
    }

    public Observable f0(ReadMsgParams readMsgParams) {
        String json = this.f19161f.toJson((Object) readMsgParams);
        return this.f19156a.O(json).onErrorResumeNext(new a1(json)).observeOn(AndroidSchedulers.mainThread());
    }

    public Observable g(AreaCodeBean areaCodeBean) {
        String json = this.f19161f.toJson((Object) areaCodeBean);
        return this.f19156a.l(json).onErrorResumeNext(new a(json)).observeOn(AndroidSchedulers.mainThread());
    }

    public Observable g0(ResetPwdEmailBean resetPwdEmailBean) {
        String json = this.f19161f.toJson((Object) resetPwdEmailBean);
        return this.f19156a.N(json).onErrorResumeNext(new p0(json)).observeOn(AndroidSchedulers.mainThread());
    }

    public Observable h(GiftDaysBean giftDaysBean) {
        String json = this.f19161f.toJson((Object) giftDaysBean);
        return this.f19156a.g0(json).onErrorResumeNext(new C0279d(json)).observeOn(AndroidSchedulers.mainThread());
    }

    public Observable h0(GetSearchByContentBean getSearchByContentBean) {
        String json = this.f19161f.toJson((Object) getSearchByContentBean);
        return this.f19156a.x0(json).onErrorResumeNext(new o(json)).observeOn(AndroidSchedulers.mainThread());
    }

    public Observable i(BindEmailV2Bean bindEmailV2Bean) {
        String json = this.f19161f.toJson((Object) bindEmailV2Bean);
        return this.f19156a.t(json).onErrorResumeNext(new n0(json)).observeOn(AndroidSchedulers.mainThread());
    }

    public Observable i0(SearchByNameBean searchByNameBean) {
        String json = this.f19161f.toJson((Object) searchByNameBean);
        return this.f19156a.g(json).onErrorResumeNext(new j(json)).observeOn(AndroidSchedulers.mainThread());
    }

    public Observable j(BindPhoneBean bindPhoneBean) {
        String json = this.f19161f.toJson((Object) bindPhoneBean);
        return this.f19156a.d0(json).onErrorResumeNext(new l1(json)).observeOn(AndroidSchedulers.mainThread());
    }

    public Observable j0(EmailVerifyCodeBean emailVerifyCodeBean) {
        String json = this.f19161f.toJson((Object) emailVerifyCodeBean);
        return this.f19156a.d(json).onErrorResumeNext(new l0(json)).observeOn(AndroidSchedulers.mainThread());
    }

    public Observable k(BindBean bindBean) {
        String json = this.f19161f.toJson((Object) bindBean);
        return this.f19156a.u0(json).onErrorResumeNext(new i0(json)).observeOn(AndroidSchedulers.mainThread());
    }

    public Observable k0(SnTokenBean snTokenBean) {
        String json = this.f19161f.toJson((Object) snTokenBean);
        return this.f19156a.o(json).onErrorResumeNext(new k(json)).observeOn(AndroidSchedulers.mainThread());
    }

    public Observable l(GetBlSearchByContentBean getBlSearchByContentBean) {
        String json = this.f19161f.toJson((Object) getBlSearchByContentBean);
        return this.f19156a.X(json).onErrorResumeNext(new p(json)).observeOn(AndroidSchedulers.mainThread());
    }

    public Observable l0(StartPlayVODBean startPlayVODBean) {
        String json = this.f19161f.toJson((Object) startPlayVODBean);
        return this.f19156a.L0(json).onErrorResumeNext(new n(json)).observeOn(Schedulers.computation());
    }

    public Observable m(ChangeBindEmailBean changeBindEmailBean) {
        String json = this.f19161f.toJson((Object) changeBindEmailBean);
        return this.f19156a.w0(json).onErrorResumeNext(new o0(json)).observeOn(AndroidSchedulers.mainThread());
    }

    public Observable m0(UnbindBean unbindBean) {
        String json = this.f19161f.toJson((Object) unbindBean);
        return this.f19156a.v(json).onErrorResumeNext(new j0(json)).observeOn(AndroidSchedulers.mainThread());
    }

    public Observable n(CheckVerifyCodeBean checkVerifyCodeBean) {
        String json = this.f19161f.toJson((Object) checkVerifyCodeBean);
        return this.f19156a.t0(json).onErrorResumeNext(new m0(json)).observeOn(AndroidSchedulers.mainThread());
    }

    public Observable n0(UpdateDeviceTokenBean updateDeviceTokenBean) {
        String json = this.f19161f.toJson((Object) updateDeviceTokenBean);
        return this.f19156a.R(json).onErrorResumeNext(new y0(json)).observeOn(AndroidSchedulers.mainThread());
    }

    public Observable o(ForceBindBean forceBindBean) {
        String json = this.f19161f.toJson((Object) forceBindBean);
        return this.f19156a.n(json).onErrorResumeNext(new e1(json)).observeOn(AndroidSchedulers.mainThread());
    }

    public Observable o0(UpdatePwdBean updatePwdBean) {
        String json = this.f19161f.toJson((Object) updatePwdBean);
        return this.f19156a.J0(json).onErrorResumeNext(new r(json)).observeOn(AndroidSchedulers.mainThread());
    }

    public Observable p(CheckGetVipBean checkGetVipBean) {
        String json = this.f19161f.toJson((Object) checkGetVipBean);
        return this.f19156a.K0(json).onErrorResumeNext(new d1(json)).observeOn(AndroidSchedulers.mainThread());
    }

    public Observable p0(UpdateRestrictBean updateRestrictBean) {
        String json = this.f19161f.toJson((Object) updateRestrictBean);
        return this.f19156a.Z(json).onErrorResumeNext(new t(json)).observeOn(AndroidSchedulers.mainThread());
    }

    public Observable q(CheckVerificationBean checkVerificationBean) {
        String json = this.f19161f.toJson((Object) checkVerificationBean);
        return this.f19156a.C(json).onErrorResumeNext(new n1(json)).observeOn(AndroidSchedulers.mainThread());
    }

    public Observable q0(UserFeedBean userFeedBean) {
        String json = this.f19161f.toJson((Object) userFeedBean);
        return this.f19156a.b(json).onErrorResumeNext(new i1(json)).observeOn(AndroidSchedulers.mainThread());
    }

    public Observable r(GetDelSubscribe getDelSubscribe) {
        String json = this.f19161f.toJson((Object) getDelSubscribe);
        return this.f19156a.n0(json).onErrorResumeNext(new c0(json)).observeOn(AndroidSchedulers.mainThread());
    }

    public Observable r0(WaitConfirmBean waitConfirmBean) {
        String json = this.f19161f.toJson((Object) waitConfirmBean);
        return this.f19156a.k0(json).onErrorResumeNext(new e0(json)).observeOn(AndroidSchedulers.mainThread());
    }

    public Observable s(DeleteMsgParams deleteMsgParams) {
        String json = this.f19161f.toJson((Object) deleteMsgParams);
        return this.f19156a.c(json).onErrorResumeNext(new c1(json)).observeOn(AndroidSchedulers.mainThread());
    }

    public Observable t(EmailResetPwdBean emailResetPwdBean) {
        String json = this.f19161f.toJson((Object) emailResetPwdBean);
        return this.f19156a.U(json).onErrorResumeNext(new s(json)).observeOn(AndroidSchedulers.mainThread());
    }

    public Observable u(ExchangeBean exchangeBean) {
        String json = this.f19161f.toJson((Object) exchangeBean);
        return this.f19156a.s0(json).onErrorResumeNext(new f0(json)).observeOn(AndroidSchedulers.mainThread());
    }

    public Observable v(GetAddFavorite getAddFavorite) {
        String json = this.f19161f.toJson((Object) getAddFavorite);
        return this.f19156a.r0(json).onErrorResumeNext(new x(json)).observeOn(AndroidSchedulers.mainThread());
    }

    public Observable w(GetAuthInfoBean getAuthInfoBean) {
        String json = this.f19161f.toJson((Object) getAuthInfoBean);
        return this.f19158c.f0(json).onErrorResumeNext(new c(json)).observeOn(AndroidSchedulers.mainThread());
    }

    public Observable x(UserBindInfo userBindInfo) {
        String json = this.f19161f.toJson((Object) userBindInfo);
        return this.f19156a.e0(json).onErrorResumeNext(new u0(json)).observeOn(AndroidSchedulers.mainThread());
    }

    public Observable y(MsgBoxParams msgBoxParams) {
        String json = this.f19161f.toJson((Object) msgBoxParams);
        return this.f19156a.P(json).onErrorResumeNext(new z0(json)).observeOn(AndroidSchedulers.mainThread());
    }

    public Observable z(GetColumnContentsBean getColumnContentsBean) {
        String json = this.f19161f.toJson((Object) getColumnContentsBean);
        return this.f19156a.a0(json).onErrorResumeNext(new f(json)).observeOn(AndroidSchedulers.mainThread());
    }

    public d(String str, String str2, Interceptor interceptor) {
        this();
        this.f19160e = interceptor;
        this.f19156a = b0(str, true);
        this.f19157b = b0(str2, true);
        this.f19158c = b0(str, false);
        this.f19159d = b0(str2, false);
    }
}
