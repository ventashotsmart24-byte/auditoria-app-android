package com.mobile.brasiltv.service;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import b8.a;
import com.hpplay.sdk.source.common.global.Constant;
import com.mobile.brasiltv.app.App;
import com.mobile.brasiltv.bean.event.CheckHeartEvent;
import com.mobile.brasiltv.bean.event.LoginSuccessEvent;
import com.mobile.brasiltv.bean.event.NetworkEvent;
import com.mobile.brasiltv.bean.event.RemoteLoginEvent;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.utils.f1;
import com.mobile.brasiltv.utils.x;
import com.mobile.brasiltv.utils.y;
import com.umeng.analytics.pro.f;
import h9.t;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.TimeUnit;
import mobile.com.requestframe.util.RemoteLoginAndMsgEvent;
import mobile.com.requestframe.utils.response.HeartBeatData;
import mobile.com.requestframe.utils.response.HeartBeatResult;
import s9.l;
import t9.g;
import t9.i;
import t9.j;
import w6.i;

public final class NetService extends Service {

    /* renamed from: h  reason: collision with root package name */
    public static final a f6158h = new a((g) null);

    /* renamed from: i  reason: collision with root package name */
    public static final String f6159i = "com.swl.amobile.service.netservice";

    /* renamed from: a  reason: collision with root package name */
    public String f6160a = "none";

    /* renamed from: b  reason: collision with root package name */
    public final e f6161b = new e(this);

    /* renamed from: c  reason: collision with root package name */
    public Disposable f6162c;

    /* renamed from: d  reason: collision with root package name */
    public long f6163d = 120;

    /* renamed from: e  reason: collision with root package name */
    public final long f6164e = 5;

    /* renamed from: f  reason: collision with root package name */
    public final TimeUnit f6165f = TimeUnit.MINUTES;

    /* renamed from: g  reason: collision with root package name */
    public Disposable f6166g;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }

        public final Intent a() {
            Intent intent = new Intent(NetService.f6159i);
            intent.setPackage(App.f6050e.a().getPackageName());
            return intent;
        }
    }

    public static final class b extends j implements l {

        /* renamed from: a  reason: collision with root package name */
        public static final b f12482a = new b();

        public b() {
            super(1);
        }

        /* renamed from: b */
        public final ObservableSource invoke(Long l10) {
            i.g(l10, "it");
            return w6.i.f9510g.b().V1();
        }
    }

    public static final class c extends ha.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ NetService f12483a;

        public static final class a extends j implements l {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f12484a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(String str) {
                super(1);
                this.f12484a = str;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return t.f17319a;
            }

            public final void invoke(String str) {
                f1.f12517a.x(y.p(y.f12639a, this.f12484a, (String) null, (String) null, 6, (Object) null));
            }
        }

        public c(NetService netService) {
            this.f12483a = netService;
        }

        /* renamed from: f */
        public void onNext(HeartBeatResult heartBeatResult) {
            boolean z10;
            i.g(heartBeatResult, "t");
            if (heartBeatResult.getData() != null) {
                b0.U(this, "心跳成功");
                HeartBeatData data = heartBeatResult.getData();
                i.d(data);
                String userToken = data.getUserToken();
                boolean z11 = false;
                if (userToken != null) {
                    if (userToken.length() == 0) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    if (!z10) {
                        z11 = true;
                    }
                }
                if (z11) {
                    i.c cVar = w6.i.f9510g;
                    HeartBeatData data2 = heartBeatResult.getData();
                    t9.i.d(data2);
                    String userToken2 = data2.getUserToken();
                    t9.i.d(userToken2);
                    cVar.z0(userToken2);
                }
                NetService netService = this.f12483a;
                netService.j(netService.f6163d);
                return;
            }
            b0.U(this, "心跳失败 返回的token为null");
            NetService netService2 = this.f12483a;
            netService2.j(netService2.f6164e);
        }

        public void onSubscribe(Disposable disposable) {
            t9.i.g(disposable, "d");
            super.onSubscribe(disposable);
            this.f12483a.f6162c = disposable;
        }

        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            b0.U(this, "心跳失败 " + str);
            x.f12622a.w(App.f6050e.a(), new a(str));
        }
    }

    public static final class d extends ha.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ NetService f12485a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CheckHeartEvent f12486b;

        public static final class a extends j implements l {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f12487a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(String str) {
                super(1);
                this.f12487a = str;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return t.f17319a;
            }

            public final void invoke(String str) {
                f1.f12517a.x(y.p(y.f12639a, this.f12487a, (String) null, (String) null, 6, (Object) null));
            }
        }

        public d(NetService netService, CheckHeartEvent checkHeartEvent) {
            this.f12485a = netService;
            this.f12486b = checkHeartEvent;
        }

        /* renamed from: f */
        public void onNext(HeartBeatResult heartBeatResult) {
            String str;
            t9.i.g(heartBeatResult, "t");
            b0.U(this, "心跳正常");
            i.c cVar = w6.i.f9510g;
            HeartBeatData data = heartBeatResult.getData();
            if (data == null || (str = data.getUserToken()) == null) {
                str = cVar.J();
            }
            cVar.z0(str);
        }

        public void handleNeedToLogin(String str) {
            t9.i.g(str, "errorCode");
            if (t9.i.b(str, "aaa100028")) {
                xa.c.c().j(new RemoteLoginEvent(this.f12486b.getMsg()));
            } else {
                super.handleNeedToLogin(str);
            }
        }

        public void onSubscribe(Disposable disposable) {
            t9.i.g(disposable, "d");
            super.onSubscribe(disposable);
            this.f12485a.f6166g = disposable;
        }

        public void sendRemoteLoginEvent(RemoteLoginAndMsgEvent remoteLoginAndMsgEvent) {
            xa.c.c().j(new RemoteLoginAndMsgEvent(this.f12486b.getMsg().getLoginIp(), this.f12486b.getMsg().getLoginTime(), this.f12486b.getMsg().getLoginCountry(), this.f12486b.getMsg().getLoginCity()));
        }

        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            b0.U(this, "心跳异常:" + str);
            x.f12622a.w(App.f6050e.a(), new a(str));
        }
    }

    public static final class e extends BroadcastReceiver {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ NetService f12488a;

        public e(NetService netService) {
            this.f12488a = netService;
        }

        public void onReceive(Context context, Intent intent) {
            t9.i.g(context, f.X);
            t9.i.g(intent, "intent");
            if (!t9.i.b(this.f12488a.f6160a, "none")) {
                q8.e.d(this.f12488a.f6160a, "stop");
            }
            a.C0148a aVar = b8.a.f11196a;
            if (!aVar.b(context)) {
                this.f12488a.f6160a = "none";
                xa.c.c().j(new NetworkEvent(NetworkEvent.NetState.NO_NET));
            } else if (aVar.c(context)) {
                q8.e.d("wlan", "start");
                this.f12488a.f6160a = "wlan";
                xa.c.c().j(new NetworkEvent(NetworkEvent.NetState.WIFI));
            } else if (aVar.a(context)) {
                q8.e.d("cellular", "start");
                this.f12488a.f6160a = "cellular";
                xa.c.c().j(new NetworkEvent(NetworkEvent.NetState.MOBILE));
            }
        }
    }

    public static final ObservableSource k(l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        return (ObservableSource) lVar.invoke(obj);
    }

    @xa.j
    public final void handRemoteLoginEvent(CheckHeartEvent checkHeartEvent) {
        t9.i.g(checkHeartEvent, Constant.KEY_MSG);
        b0.U(this, "异地登录通知, 开始检查心跳是否异常...");
        Disposable disposable = this.f6166g;
        if (disposable != null) {
            disposable.dispose();
        }
        w6.i.f9510g.b().V1().subscribe(new d(this, checkHeartEvent));
    }

    public final void j(long j10) {
        Disposable disposable = this.f6162c;
        if (disposable != null) {
            disposable.dispose();
        }
        Observable.timer(j10, this.f6165f).flatMap(new v6.a(b.f12482a)).subscribe(new c(this));
    }

    public final void l() {
        if (!xa.c.c().h(this)) {
            xa.c.c().o(this);
        }
    }

    public final void m() {
        registerReceiver(this.f6161b, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    }

    public final void n() {
        if (xa.c.c().h(this)) {
            xa.c.c().r(this);
        }
        Disposable disposable = this.f6162c;
        if (disposable != null) {
            disposable.dispose();
        }
        Disposable disposable2 = this.f6166g;
        if (disposable2 != null) {
            disposable2.dispose();
        }
    }

    public final void o() {
        unregisterReceiver(this.f6161b);
    }

    public IBinder onBind(Intent intent) {
        t9.i.g(intent, "arg0");
        return null;
    }

    public void onCreate() {
        super.onCreate();
        m();
        l();
    }

    public void onDestroy() {
        super.onDestroy();
        o();
        n();
    }

    @xa.j
    public final void receiveLoginEvent(LoginSuccessEvent loginSuccessEvent) {
        boolean z10;
        t9.i.g(loginSuccessEvent, "event");
        String heartBeatTime = loginSuccessEvent.getHeartBeatTime();
        if (heartBeatTime == null || heartBeatTime.length() == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10) {
            String heartBeatTime2 = loginSuccessEvent.getHeartBeatTime();
            t9.i.d(heartBeatTime2);
            this.f6163d = Long.parseLong(heartBeatTime2);
        }
        b0.U(this, "登录成功, " + this.f6163d + " 分钟开始心跳");
        j(this.f6163d);
    }
}
