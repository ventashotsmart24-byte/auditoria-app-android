package com.mobile.brasiltv.view.dialog;

import android.content.Context;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.app.App;
import com.mobile.brasiltv.bean.event.CloseForceBindEvent;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.utils.f1;
import com.msandroid.mobile.R;
import com.umeng.analytics.pro.f;
import com.zhy.autolayout.utils.AutoUtils;
import ma.h;
import ma.l;
import org.greenrobot.eventbus.ThreadMode;
import s9.a;
import t9.i;
import xa.c;
import xa.j;

public final class ForceBindDialog extends BaseDialog {
    private final a bindCallback;
    private final Context context;
    private final a loginCallback;
    private long mTime;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ForceBindDialog(Context context2, a aVar, a aVar2) {
        super(context2);
        i.g(context2, f.X);
        i.g(aVar, "loginCallback");
        i.g(aVar2, "bindCallback");
        this.context = context2;
        this.loginCallback = aVar;
        this.bindCallback = aVar2;
    }

    /* access modifiers changed from: private */
    public static final void onCreate$lambda$1(ForceBindDialog forceBindDialog, View view) {
        i.g(forceBindDialog, "this$0");
        forceBindDialog.loginCallback.invoke();
    }

    /* access modifiers changed from: private */
    public static final void onCreate$lambda$2(ForceBindDialog forceBindDialog, View view) {
        i.g(forceBindDialog, "this$0");
        forceBindDialog.bindCallback.invoke();
    }

    @j(threadMode = ThreadMode.MAIN)
    public final void closeForceBindEvent(CloseForceBindEvent closeForceBindEvent) {
        i.g(closeForceBindEvent, "event");
        b0.j(this);
    }

    public void onBackPressed() {
        if (System.currentTimeMillis() - this.mTime > 2000) {
            f1.f12517a.w(R.string.press_again_to_exits);
            this.mTime = System.currentTimeMillis();
            return;
        }
        Toast c10 = f1.f12517a.c();
        if (c10 != null) {
            c10.cancel();
        }
        l.a("forceBind");
        h hVar = h.f18994a;
        App.a aVar = App.f6050e;
        App a10 = aVar.a();
        String packageName = aVar.a().getPackageName();
        i.f(packageName, "App.instance.getPackageName()");
        hVar.d(a10, packageName);
    }

    public void onCreate(Bundle bundle) {
        WindowManager.LayoutParams layoutParams;
        super.onCreate(bundle);
        setContentView((int) R.layout.dialog_force_bind);
        Window window = getWindow();
        if (window != null) {
            layoutParams = window.getAttributes();
        } else {
            layoutParams = null;
        }
        if (layoutParams != null) {
            layoutParams.gravity = 17;
            layoutParams.width = AutoUtils.getPercentWidthSize(630);
            Window window2 = getWindow();
            if (window2 != null) {
                window2.setAttributes(layoutParams);
            }
        }
        ((TextView) findViewById(R$id.tvContentOne)).setText(Html.fromHtml(this.context.getString(R.string.force_bind_content_one)));
        ((TextView) findViewById(R$id.tvContentTwo)).setText(Html.fromHtml(this.context.getString(R.string.force_bind_content_two)));
        ((TextView) findViewById(R$id.tvLogin)).setOnClickListener(new w(this));
        ((TextView) findViewById(R$id.tvBindNow)).setOnClickListener(new x(this));
        setCanceledOnTouchOutside(false);
        setCancelable(false);
        c.c().o(this);
    }
}
