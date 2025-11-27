package f5;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.hpplay.sdk.source.common.global.Constant;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.activity.MainAty;
import com.mobile.brasiltv.activity.SplashAty;
import com.mobile.brasiltv.app.App;
import com.mobile.brasiltv.bean.event.ReCreateEvent;
import com.mobile.brasiltv.bean.event.RemoteLoginEvent;
import com.mobile.brasiltv.mine.activity.LoginAty;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.utils.f1;
import com.mobile.brasiltv.utils.i1;
import com.mobile.brasiltv.utils.x;
import com.mobile.brasiltv.view.BlackListDialog;
import com.mobile.brasiltv.view.LoadingView;
import com.mobile.brasiltv.view.dialog.DialogManager;
import com.mobile.brasiltv.view.dialog.RemoteLoginTipDialog;
import com.msandroid.mobile.R;
import com.umeng.analytics.MobclickAgent;
import com.umeng.message.PushAgent;
import h9.g;
import h9.h;
import h9.t;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import ma.n;
import ma.s;
import ma.u;
import mobile.com.requestframe.util.RemoteLoginAndMsgEvent;
import org.greenrobot.eventbus.ThreadMode;
import s9.l;
import t9.i;
import t9.j;

public abstract class c extends i5.a implements View.OnClickListener {

    /* renamed from: c  reason: collision with root package name */
    public boolean f6615c;

    /* renamed from: d  reason: collision with root package name */
    public Toast f6616d;

    /* renamed from: e  reason: collision with root package name */
    public RemoteLoginTipDialog f6617e;

    /* renamed from: f  reason: collision with root package name */
    public RemoteLoginTipDialog f6618f;

    /* renamed from: g  reason: collision with root package name */
    public BlackListDialog f6619g;

    /* renamed from: h  reason: collision with root package name */
    public LoadingView f6620h;

    /* renamed from: i  reason: collision with root package name */
    public final g f6621i = h.b(new d(this));

    /* renamed from: j  reason: collision with root package name */
    public Map f6622j = new LinkedHashMap();

    public static final class a extends j implements l {

        /* renamed from: a  reason: collision with root package name */
        public static final a f16550a = new a();

        public a() {
            super(1);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Long) obj);
            return t.f17319a;
        }

        public final void invoke(Long l10) {
            ma.l.a("dispatch");
            ma.h hVar = ma.h.f18994a;
            App.a aVar = App.f6050e;
            App a10 = aVar.a();
            String packageName = aVar.a().getPackageName();
            i.f(packageName, "App.instance.getPackageName()");
            hVar.d(a10, packageName);
        }
    }

    public static final class b extends j implements l {

        /* renamed from: a  reason: collision with root package name */
        public static final b f16551a = new b();

        public b() {
            super(1);
        }

        /* renamed from: b */
        public final Intent invoke(Intent intent) {
            i.g(intent, "it");
            Intent putExtra = intent.putExtra("can_back", false);
            i.f(putExtra, "it.putExtra(LoginAty.CAN_BACK, false)");
            return putExtra;
        }
    }

    /* renamed from: f5.c$c  reason: collision with other inner class name */
    public static final class C0220c extends j implements l {

        /* renamed from: a  reason: collision with root package name */
        public static final C0220c f16552a = new C0220c();

        public C0220c() {
            super(1);
        }

        /* renamed from: b */
        public final Intent invoke(Intent intent) {
            i.g(intent, "it");
            Intent putExtra = intent.putExtra("can_back", false);
            i.f(putExtra, "it.putExtra(LoginAty.CAN_BACK, false)");
            return putExtra;
        }
    }

    public static final class d extends j implements s9.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f16553a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(c cVar) {
            super(0);
            this.f16553a = cVar;
        }

        /* renamed from: b */
        public final com.mobile.brasiltv.utils.c invoke() {
            return new com.mobile.brasiltv.utils.c(this.f16553a);
        }
    }

    public static final class e extends j implements l {

        /* renamed from: a  reason: collision with root package name */
        public static final e f16554a = new e();

        public e() {
            super(1);
        }

        /* renamed from: b */
        public final Intent invoke(Intent intent) {
            i.g(intent, "it");
            Intent putExtra = intent.putExtra("can_back", false);
            i.f(putExtra, "it.putExtra(LoginAty.CAN_BACK, false)");
            return putExtra;
        }
    }

    public static final void K2(l lVar, Object obj) {
        i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void P2(c cVar, DialogInterface dialogInterface) {
        i.g(cVar, "this$0");
        cVar.f6620h = null;
        cVar.N2();
    }

    public final void J2() {
        RemoteLoginTipDialog remoteLoginTipDialog = this.f6617e;
        if (remoteLoginTipDialog != null) {
            remoteLoginTipDialog.dismiss();
        }
        RemoteLoginTipDialog remoteLoginTipDialog2 = this.f6618f;
        if (remoteLoginTipDialog2 != null) {
            remoteLoginTipDialog2.dismiss();
        }
        BlackListDialog blackListDialog = this.f6619g;
        if (blackListDialog != null) {
            blackListDialog.dismiss();
        }
    }

    public final BlackListDialog L2() {
        return this.f6619g;
    }

    public final com.mobile.brasiltv.utils.c M2() {
        return (com.mobile.brasiltv.utils.c) this.f6621i.getValue();
    }

    public void N2() {
    }

    public final void O2(boolean z10) {
        if (this.f6620h == null) {
            this.f6620h = LoadingView.Companion.create$default(LoadingView.Companion, this, false, false, new b(this), 6, (Object) null);
            t tVar = t.f17319a;
        }
        if (z10) {
            LoadingView loadingView = this.f6620h;
            if (loadingView != null) {
                loadingView.show();
                return;
            }
            return;
        }
        LoadingView loadingView2 = this.f6620h;
        if (loadingView2 != null) {
            loadingView2.dismiss();
        }
    }

    public final void Q2(String str, int i10) {
        i.g(str, "info");
        if (!isFinishing()) {
            Toast toast = this.f6616d;
            if (toast != null) {
                toast.cancel();
            }
            this.f6616d = new Toast(Q1());
            View inflate = LayoutInflater.from(Q1()).inflate(R.layout.toast_koocan_white_center, (ViewGroup) null);
            ((TextView) inflate.findViewById(R$id.mTvToast)).setText(str);
            Toast toast2 = this.f6616d;
            if (toast2 != null) {
                toast2.setView(inflate);
            }
            r2.a.a(this.f6616d);
            Toast toast3 = this.f6616d;
            if (toast3 != null) {
                toast3.setDuration(i10);
            }
            Toast toast4 = this.f6616d;
            if (toast4 != null) {
                toast4.show();
            }
        }
    }

    public void attachBaseContext(Context context) {
        i.g(context, "newBase");
        super.attachBaseContext(context);
    }

    @xa.j(threadMode = ThreadMode.MAIN)
    public final void blackList(ma.e eVar) {
        i.g(eVar, "event");
        boolean z10 = this instanceof MainAty;
        BlackListDialog blackListDialog = new BlackListDialog(this, w6.i.f9510g.H(), z10);
        this.f6619g = blackListDialog;
        if (z10) {
            b0.S(blackListDialog, DialogManager.DIALOG_BLACK_LIST);
        } else {
            blackListDialog.show();
        }
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        i.g(motionEvent, "ev");
        if (motionEvent.getToolType(motionEvent.getPointerCount() - 1) != 3) {
            return super.dispatchTouchEvent(motionEvent);
        }
        i1.M(Q1(), "2");
        f1.a aVar = f1.f12517a;
        f1.a.p(aVar, this, "EA31 " + x.f12622a.y(Q1(), R.string.contact_seller), 0, 4, (Object) null);
        Observable.timer(2, TimeUnit.SECONDS).subscribeOn(Schedulers.computation()).subscribe(new a(a.f16550a));
        return true;
    }

    @xa.j(threadMode = ThreadMode.MAIN)
    public final void needToLogin(n nVar) {
        i.g(nVar, "event");
        new IllegalStateException("查看登陆问题");
        b0.d0(this, LoginAty.class, b.f16551a);
    }

    @xa.j(threadMode = ThreadMode.MAIN)
    public final void notifyTokenInvalid(s sVar) {
        i.g(sVar, "event");
        b0.d0(this, LoginAty.class, C0220c.f16552a);
    }

    public void onClick(View view) {
        i.g(view, "view");
    }

    public void onCreate(Bundle bundle) {
        com.mobile.brasiltv.utils.a.b().f(this);
        super.onCreate(bundle);
        if (bundle == null || ((!TextUtils.isEmpty(ha.b.f17320a.a()) && t2.a.f9350a.d() != null) || (this instanceof SplashAty))) {
            if (!xa.c.c().h(this)) {
                xa.c.c().o(this);
            }
            PushAgent.getInstance(this).onAppStart();
            ma.b.f18991a.a(this);
            return;
        }
        if (this instanceof MainAty) {
            bundle.remove("android:support:fragments");
        }
        com.mobile.brasiltv.utils.d.f12512a.a(this);
        finish();
    }

    public void onDestroy() {
        com.mobile.brasiltv.utils.a.b().d(this);
        if (xa.c.c().h(this)) {
            xa.c.c().r(this);
        }
        c2.i.f4633q.a().n();
        ma.b.f18991a.d(this);
        super.onDestroy();
    }

    public void onPause() {
        super.onPause();
        this.f6615c = false;
        String simpleName = getClass().getSimpleName();
        i.f(simpleName, "javaClass.simpleName");
        if (!ba.t.o(simpleName, "MainAty", false, 2, (Object) null)) {
            MobclickAgent.onPageEnd(getClass().getSimpleName());
        }
        MobclickAgent.onPause(this);
        c2.i.f4633q.a().o(this);
    }

    public void onResume() {
        super.onResume();
        this.f6615c = true;
        String simpleName = getClass().getSimpleName();
        i.f(simpleName, "javaClass.simpleName");
        if (!ba.t.o(simpleName, "MainAty", false, 2, (Object) null)) {
            MobclickAgent.onPageStart(getClass().getSimpleName());
        }
        MobclickAgent.onResume(this);
        c2.i.f4633q.a().p(this);
    }

    @xa.j
    public final void receiveLoginEvent(ReCreateEvent reCreateEvent) {
        i.g(reCreateEvent, "event");
        recreate();
    }

    public void setContentView(int i10) {
        super.setContentView(i10);
    }

    @xa.j(threadMode = ThreadMode.MAIN)
    public final void showRemoteLoginTip(RemoteLoginEvent remoteLoginEvent) {
        i.g(remoteLoginEvent, Constant.KEY_MSG);
        if (this.f6615c) {
            RemoteLoginTipDialog remoteLoginTipDialog = new RemoteLoginTipDialog(this);
            this.f6617e = remoteLoginTipDialog;
            remoteLoginTipDialog.show(remoteLoginEvent.getMsg(), this instanceof MainAty);
        }
    }

    public void unbindService(ServiceConnection serviceConnection) {
        i.g(serviceConnection, "conn");
        try {
            super.unbindService(serviceConnection);
        } catch (IllegalArgumentException e10) {
            e10.printStackTrace();
        }
    }

    @xa.j(threadMode = ThreadMode.MAIN)
    public final void verifyTokenError(u uVar) {
        i.g(uVar, "event");
        new IllegalStateException("查看token验证问题");
        b0.d0(this, LoginAty.class, e.f16554a);
    }

    public final void z0(String str) {
        i.g(str, "info");
        Q2(str, 0);
    }

    @xa.j(threadMode = ThreadMode.MAIN)
    public final void showRemoteLoginTip(RemoteLoginAndMsgEvent remoteLoginAndMsgEvent) {
        i.g(remoteLoginAndMsgEvent, "event");
        if (this.f6615c) {
            RemoteLoginTipDialog remoteLoginTipDialog = this.f6618f;
            if (remoteLoginTipDialog != null && remoteLoginTipDialog.isShowing()) {
                if (this instanceof MainAty) {
                    b0.j(remoteLoginTipDialog);
                } else {
                    remoteLoginTipDialog.dismiss();
                }
            }
            RemoteLoginTipDialog remoteLoginTipDialog2 = new RemoteLoginTipDialog(this);
            this.f6618f = remoteLoginTipDialog2;
            remoteLoginTipDialog2.show(remoteLoginAndMsgEvent.getLoginCountry(), remoteLoginAndMsgEvent.getLoginCity(), remoteLoginAndMsgEvent.getLoginIp(), remoteLoginAndMsgEvent.getLoginTime(), this instanceof MainAty);
        }
    }
}
