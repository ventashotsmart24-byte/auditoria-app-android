package com.mobile.brasiltv.view;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import com.mobile.brasiltv.bean.event.LoginSuccessEvent;
import com.mobile.brasiltv.bean.event.SetLoginAtySelectTabEvent;
import com.mobile.brasiltv.mine.activity.LoginAty;
import com.mobile.brasiltv.utils.b0;
import com.msandroid.mobile.R;
import com.umeng.analytics.pro.f;
import com.zhy.autolayout.utils.AutoUtils;
import ma.b;
import org.greenrobot.eventbus.ThreadMode;
import t9.i;
import xa.c;
import xa.j;

public final class BlackListDialog extends Dialog {
    private boolean mNeedManager;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BlackListDialog(Context context, String str, boolean z10) {
        super(context, R.style.OptionDialog);
        WindowManager.LayoutParams layoutParams;
        i.g(context, f.X);
        i.g(str, "userId");
        this.mNeedManager = z10;
        setContentView(R.layout.dialog_black_list);
        Window window = getWindow();
        if (window != null) {
            layoutParams = window.getAttributes();
        } else {
            layoutParams = null;
        }
        if (layoutParams != null) {
            layoutParams.gravity = 17;
            layoutParams.width = AutoUtils.getPercentWidthSize(520);
            Window window2 = getWindow();
            if (window2 != null) {
                window2.setAttributes(layoutParams);
            }
        }
        if (!TextUtils.isEmpty(str)) {
            TextView textView = (TextView) findViewById(R.id.tv_id);
            textView.setVisibility(0);
            textView.setText(context.getString(R.string.black_list_id, new Object[]{str}));
        }
        ((KoocanButton) findViewById(R.id.kb_login_other)).setOnClickListener(new f(context));
        setCanceledOnTouchOutside(false);
    }

    /* access modifiers changed from: private */
    public static final void _init_$lambda$1(Context context, View view) {
        i.g(context, "$context");
        if (i.b("LoginAty", b.f18991a.c().getClass().getSimpleName())) {
            c.c().j(new SetLoginAtySelectTabEvent(1));
        }
        context.startActivity(new Intent(context, LoginAty.class));
    }

    public final boolean getMNeedManager() {
        return this.mNeedManager;
    }

    @j(threadMode = ThreadMode.MAIN)
    public final void loginSuccess(LoginSuccessEvent loginSuccessEvent) {
        i.g(loginSuccessEvent, "event");
        if (this.mNeedManager) {
            b0.j(this);
        } else {
            dismiss();
        }
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        c.c().o(this);
    }

    public void onBackPressed() {
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        c.c().r(this);
    }

    public final void setMNeedManager(boolean z10) {
        this.mNeedManager = z10;
    }
}
