package com.mobile.brasiltv.app;

import android.app.Notification;
import android.content.Context;
import android.content.ServiceConnection;
import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.Task;
import com.google.firebase.installations.FirebaseInstallations;
import com.google.gson.Gson;
import com.hpplay.sdk.source.common.global.Constant;
import com.mobile.brasiltv.base.BaseAPP;
import com.mobile.brasiltv.bean.event.CheckHeartEvent;
import com.mobile.brasiltv.bean.event.LoginSuccessEvent;
import com.mobile.brasiltv.db.MobileDao;
import com.mobile.brasiltv.db.UmengMessage;
import com.mobile.brasiltv.db.VodDao;
import com.taobao.accs.AccsClientConfig;
import com.taobao.accs.common.Constants;
import com.umeng.analytics.MobclickAgent;
import com.umeng.message.PushAgent;
import com.umeng.message.entity.UMessage;
import com.umeng.umcrash.UMCrash;
import com.umeng.umcrash.UMCrashCallback;
import com.zhy.autolayout.config.AutoLayoutConifg;
import h9.h;
import m7.f;
import ma.l;
import ma.o;
import o8.k;
import t9.i;
import t9.j;
import w6.i;

public final class App extends BaseAPP {

    /* renamed from: e  reason: collision with root package name */
    public static final a f6050e = new a((t9.g) null);

    /* renamed from: f  reason: collision with root package name */
    public static App f6051f;

    /* renamed from: a  reason: collision with root package name */
    public final h9.g f6052a = h.b(new d(this));

    /* renamed from: b  reason: collision with root package name */
    public final h9.g f6053b = h.b(new c(this));

    /* renamed from: c  reason: collision with root package name */
    public final h9.g f6054c = h.b(new e(this));

    /* renamed from: d  reason: collision with root package name */
    public long f6055d;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(t9.g gVar) {
            this();
        }

        public final App a() {
            App app = App.f6051f;
            if (app != null) {
                return app;
            }
            i.w("instance");
            return null;
        }

        public final void b(App app) {
            i.g(app, "<set-?>");
            App.f6051f = app;
        }
    }

    public static final class b extends k7.a {
        public b(k7.h hVar) {
            super(hVar);
        }

        public boolean b(int i10, String str) {
            return false;
        }
    }

    public static final class c extends j implements s9.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ App f6056a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(App app) {
            super(0);
            this.f6056a = app;
        }

        /* renamed from: b */
        public final VodDao invoke() {
            return new VodDao(this.f6056a);
        }
    }

    public static final class d extends j implements s9.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ App f6057a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(App app) {
            super(0);
            this.f6057a = app;
        }

        /* renamed from: b */
        public final MobileDao invoke() {
            return new MobileDao(this.f6057a);
        }
    }

    public static final class e extends j implements s9.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ App f6058a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(App app) {
            super(0);
            this.f6058a = app;
        }

        /* renamed from: b */
        public final com.mobile.brasiltv.utils.c invoke() {
            return new com.mobile.brasiltv.utils.c(this.f6058a);
        }
    }

    public static final class f implements f.d {
        public void a(PushAgent pushAgent, String str) {
            i.g(str, "deviceToken");
        }

        public void b(PushAgent pushAgent) {
            i.g(pushAgent, "mPushAgent");
            pushAgent.setNotificationOnForeground(false);
            pushAgent.setNotificationPlaySound(1);
        }

        public void c(PushAgent pushAgent, String str, String str2) {
        }
    }

    public static final class g extends m7.e {
        public Notification c(Context context, UMessage uMessage) {
            Notification c10 = super.c(context, uMessage);
            i.f(c10, "super.getNotification(context, msg)");
            return c10;
        }

        public void d(Context context, UMessage uMessage) {
            i.g(context, com.umeng.analytics.pro.f.X);
            i.g(uMessage, Constant.KEY_MSG);
            try {
                UmengMessage umengMessage = (UmengMessage) new Gson().fromJson(uMessage.custom, UmengMessage.class);
                umengMessage.setMsgId(uMessage.msg_id);
                umengMessage.setTicker(uMessage.ticker);
                umengMessage.setTitle(uMessage.title);
                umengMessage.setText(uMessage.text);
                umengMessage.setMessageTime(y6.a.c());
                UmengMessage.Companion companion = UmengMessage.Companion;
                umengMessage.setStatus(companion.getUN_READ());
                if (i.b(companion.getTYPE_LOGIN(), umengMessage.getMessageType())) {
                    xa.c c10 = xa.c.c();
                    i.f(umengMessage, Constants.SHARED_MESSAGE_ID_FILE);
                    c10.j(new CheckHeartEvent(umengMessage));
                }
            } catch (Exception e10) {
                e10.printStackTrace();
            }
            super.d(context, uMessage);
        }
    }

    public App() {
        f6050e.b(this);
    }

    public static final void h(Task task) {
        i.g(task, "task");
        if (!task.isSuccessful()) {
            task.getException();
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("firebase id=");
        sb.append((String) task.getResult());
        na.a.i((String) task.getResult());
    }

    public static final void o(App app) {
        i.g(app, "this$0");
        app.s();
        q8.e.a("start");
    }

    public static final void p(App app, boolean z10, String str) {
        i.g(app, "this$0");
    }

    public static final void q(App app, boolean z10, String str) {
        i.g(app, "this$0");
    }

    public static final void t(App app, Context context, UMessage uMessage) {
        i.g(app, "this$0");
        i.g(context, "p0");
        i.g(uMessage, "p1");
    }

    public static final String u() {
        return d6.b.f6366a.l() + "_" + l.b();
    }

    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        if (com.mobile.brasiltv.utils.e.d(this)) {
            o0.a.l(this);
        }
    }

    public final void g() {
        FirebaseInstallations.getInstance().getId().addOnCompleteListener(new h5.d());
    }

    public final MobileDao i() {
        return (MobileDao) this.f6052a.getValue();
    }

    public final com.mobile.brasiltv.utils.c j() {
        return (com.mobile.brasiltv.utils.c) this.f6054c.getValue();
    }

    public final void k() {
        AutoLayoutConifg.getInstance().useDeviceSize().init(this);
    }

    public final void l() {
        ja.b.f7201f.b(this);
    }

    public final void m() {
        s6.a aVar = s6.a.f9335a;
        v7.b.f9475a = aVar.a().j();
        v7.b.f9476b = aVar.a().k();
    }

    public final void n() {
        k7.f.a(new b(k7.h.k().b(false).c("MobileLog").a()));
    }

    public void onCreate() {
        super.onCreate();
        m7.f.d(this);
        if (!com.mobile.brasiltv.utils.e.d(this)) {
            s();
            return;
        }
        n2.a.a(this);
        q8.a.b(this);
        this.f6055d = System.currentTimeMillis() / ((long) 1000);
        na.a.f8315a = this;
        g8.a.f6838a.b(this);
        s6.a.f9335a.b(new e5.a());
        m();
        n();
        k();
        new Thread(new h5.c(this)).start();
        l8.h a10 = l8.h.f7639m.a();
        String absolutePath = getApplicationContext().getDir("luna", 0).getAbsolutePath();
        i.f(absolutePath, "this.applicationContext.…ODE_PRIVATE).absolutePath");
        k kVar = k.f8567a;
        a10.r(absolutePath, kVar.f(), kVar.g());
        r();
        c6.a.a().b(this);
        g();
        l();
        c2.i.l(c2.i.f4633q.a(), this, false, (h2.a) null, (d2.c) null, new o(this), new ma.c(this), 12, (Object) null);
        t2.a.f9350a.l(this);
    }

    public void onTerminate() {
        super.onTerminate();
        if (xa.c.c().h(this)) {
            xa.c.c().r(this);
        }
        q8.e.a("stop");
    }

    public void onTrimMemory(int i10) {
        super.onTrimMemory(i10);
        Glide.get(this).trimMemory(i10);
    }

    public final void r() {
        if (!xa.c.c().h(this)) {
            xa.c.c().o(this);
        }
    }

    @xa.j
    public final void registPushTagAndAlias(LoginSuccessEvent loginSuccessEvent) {
        i.g(loginSuccessEvent, "event");
        PushAgent instance = PushAgent.getInstance(this);
        i.c cVar = w6.i.f9510g;
        instance.setAlias(cVar.H(), "userId", new h5.a(this));
        PushAgent.getInstance(this).setAlias(cVar.E(), "sn", new h5.b(this));
    }

    public final void s() {
        MobclickAgent.setPageCollectionMode(MobclickAgent.PageMode.LEGACY_MANUAL);
        String b10 = a5.g.b(this);
        if (b10 == null) {
            b10 = AccsClientConfig.DEFAULT_CONFIGTAG;
        }
        m7.f.b(this, com.mobile.brasiltv.utils.e.c(this, "UMENG_APPKEY"), b10, m7.a.DEVICE_TYPE_PHONE, com.mobile.brasiltv.utils.e.c(this, "UMENG_MSG_SECRET"), new f(), "com.mobile.brasiltv");
        m7.f.e(new g());
        PushAgent.getInstance(this).setNotificationClickHandler(new h5.e(this));
        UMCrash.registerUMCrashCallback((UMCrashCallback) new h5.f());
    }

    public void unbindService(ServiceConnection serviceConnection) {
        t9.i.g(serviceConnection, "conn");
        try {
            super.unbindService(serviceConnection);
        } catch (IllegalArgumentException e10) {
            e10.printStackTrace();
        }
    }
}
