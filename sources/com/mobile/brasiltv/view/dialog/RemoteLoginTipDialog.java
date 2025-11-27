package com.mobile.brasiltv.view.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import ba.t;
import com.hpplay.cybergarage.soap.SOAP;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.activity.ResetAty;
import com.mobile.brasiltv.bean.event.LoginSuccessEvent;
import com.mobile.brasiltv.db.UmengMessage;
import com.mobile.brasiltv.mine.activity.LoginAty;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.view.KoocanButton;
import com.msandroid.mobile.R;
import com.taobao.accs.common.Constants;
import com.umeng.analytics.pro.f;
import com.zhy.autolayout.utils.AutoUtils;
import t9.i;
import xa.c;
import xa.j;
import y6.a;

public final class RemoteLoginTipDialog extends Dialog {
    private boolean mIsPushMsg;
    private boolean mNeedManager;
    private UmengMessage msg;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RemoteLoginTipDialog(Context context) {
        super(context, R.style.OptionDialog);
        i.g(context, f.X);
    }

    private final int attachColor(SpannableString spannableString, String str, String str2, int i10, int i11) {
        int y10 = t.y(str, SOAP.DELIM, i10, false, 4, (Object) null) + 1;
        int length = str2.length() + y10 + 1;
        spannableString.setSpan(new ForegroundColorSpan(i11), y10, length, 33);
        return length;
    }

    /* access modifiers changed from: private */
    public static final void initData$lambda$2(RemoteLoginTipDialog remoteLoginTipDialog, View view) {
        i.g(remoteLoginTipDialog, "this$0");
        ResetAty.a aVar = ResetAty.A;
        Context context = remoteLoginTipDialog.getContext();
        i.f(context, f.X);
        aVar.a(context);
    }

    /* access modifiers changed from: private */
    public static final void initData$lambda$3(RemoteLoginTipDialog remoteLoginTipDialog, View view) {
        i.g(remoteLoginTipDialog, "this$0");
        Intent intent = new Intent(remoteLoginTipDialog.getContext(), LoginAty.class);
        intent.putExtra("can_back", true);
        remoteLoginTipDialog.getContext().startActivity(intent);
    }

    private final String tranCountryAndCity() {
        String str;
        boolean z10;
        String loginCity;
        UmengMessage umengMessage = this.msg;
        String str2 = "";
        if (umengMessage == null || (str = umengMessage.getLoginCountry()) == null) {
            str = str2;
        }
        UmengMessage umengMessage2 = this.msg;
        if (!(umengMessage2 == null || (loginCity = umengMessage2.getLoginCity()) == null)) {
            str2 = loginCity;
        }
        boolean z11 = true;
        if (str.length() == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10 && !i.b(str, "unknown")) {
            if (str2.length() != 0) {
                z11 = false;
            }
            if (!z11 && !i.b(str, "unknown")) {
                return str + ", " + str2;
            }
        }
        return "unknown";
    }

    private final String tranLoginIp() {
        String str;
        String str2;
        UmengMessage umengMessage = this.msg;
        String str3 = null;
        if (umengMessage != null) {
            str = umengMessage.getLoginIp();
        } else {
            str = null;
        }
        if (TextUtils.isEmpty(str)) {
            return "unknown";
        }
        UmengMessage umengMessage2 = this.msg;
        if (umengMessage2 != null) {
            str2 = umengMessage2.getLoginIp();
        } else {
            str2 = null;
        }
        if (TextUtils.equals(str2, "unknow")) {
            return "unknown";
        }
        UmengMessage umengMessage3 = this.msg;
        if (umengMessage3 != null) {
            str3 = umengMessage3.getLoginIp();
        }
        i.d(str3);
        return str3;
    }

    private final String tranLoginTime() {
        String str;
        long j10;
        String str2;
        UmengMessage umengMessage = this.msg;
        String str3 = null;
        if (umengMessage != null) {
            str = umengMessage.getLoginTime();
        } else {
            str = null;
        }
        if (!TextUtils.isEmpty(str)) {
            UmengMessage umengMessage2 = this.msg;
            if (umengMessage2 != null) {
                str2 = umengMessage2.getLoginTime();
            } else {
                str2 = null;
            }
            if (!TextUtils.equals(str2, "unknow")) {
                UmengMessage umengMessage3 = this.msg;
                if (umengMessage3 != null) {
                    str3 = umengMessage3.getLoginTime();
                }
                i.d(str3);
                j10 = Long.parseLong(str3);
                String i10 = a.i(j10, "MM/dd HH:mm");
                i.f(i10, "getPatternDate(loginTime, \"MM/dd HH:mm\")");
                return i10;
            }
        }
        j10 = System.currentTimeMillis();
        String i102 = a.i(j10, "MM/dd HH:mm");
        i.f(i102, "getPatternDate(loginTime, \"MM/dd HH:mm\")");
        return i102;
    }

    public final boolean getMIsPushMsg() {
        return this.mIsPushMsg;
    }

    public final boolean getMNeedManager() {
        return this.mNeedManager;
    }

    public final UmengMessage getMsg() {
        return this.msg;
    }

    public final void initData() {
        if (this.msg != null) {
            if (this.mIsPushMsg) {
                UmengMessage umengMessage = this.msg;
                i.d(umengMessage);
                ((TextView) findViewById(R$id.mTextDetail)).setText(umengMessage.getText());
            } else {
                String tranLoginIp = tranLoginIp();
                String tranLoginTime = tranLoginTime();
                String tranCountryAndCity = tranCountryAndCity();
                String string = getContext().getString(R.string.remote_login_info, new Object[]{tranLoginIp, tranLoginTime, tranCountryAndCity});
                i.f(string, "context.getString(R.stri…Ip, loginTime, loginArea)");
                int color = getContext().getResources().getColor(R.color.color_ff3333);
                SpannableString spannableString = new SpannableString(string);
                SpannableString spannableString2 = spannableString;
                String str = string;
                int i10 = color;
                attachColor(spannableString2, str, tranCountryAndCity, attachColor(spannableString2, str, tranLoginTime, attachColor(spannableString2, str, tranLoginIp, 0, i10), i10), i10);
                ((TextView) findViewById(R$id.mTextDetail)).setText(spannableString);
            }
        }
        ((KoocanButton) findViewById(R$id.mButtonChangePwd)).setOnClickListener(new w0(this));
        ((KoocanButton) findViewById(R$id.mButtonLoginOther)).setOnClickListener(new x0(this));
    }

    public void onCreate(Bundle bundle) {
        WindowManager.LayoutParams layoutParams;
        super.onCreate(bundle);
        setContentView(R.layout.dialog_remote_login_tips);
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
        c.c().o(this);
        setCancelable(false);
        setCanceledOnTouchOutside(false);
        initData();
    }

    public void onDetachedFromWindow() {
        c.c().r(this);
        super.onDetachedFromWindow();
    }

    public final void setMIsPushMsg(boolean z10) {
        this.mIsPushMsg = z10;
    }

    public final void setMNeedManager(boolean z10) {
        this.mNeedManager = z10;
    }

    public final void setMsg(UmengMessage umengMessage) {
        this.msg = umengMessage;
    }

    public final void show(UmengMessage umengMessage, boolean z10) {
        i.g(umengMessage, Constants.SHARED_MESSAGE_ID_FILE);
        this.msg = umengMessage;
        this.mIsPushMsg = true;
        this.mNeedManager = z10;
        if (z10) {
            b0.S(this, DialogManager.DIALOG_REMOTE_LOGIN);
        } else {
            super.show();
        }
    }

    @j
    public final void toClose(LoginSuccessEvent loginSuccessEvent) {
        i.g(loginSuccessEvent, "event");
        if (!isShowing()) {
            return;
        }
        if (this.mNeedManager) {
            b0.j(this);
        } else {
            dismiss();
        }
    }

    public final void show(String str, String str2, String str3, String str4, boolean z10) {
        UmengMessage umengMessage = new UmengMessage();
        umengMessage.setLoginCountry(str);
        umengMessage.setLoginCity(str2);
        umengMessage.setLoginIp(str3);
        umengMessage.setLoginTime(str4);
        this.msg = umengMessage;
        this.mIsPushMsg = false;
        this.mNeedManager = z10;
        if (z10) {
            b0.S(this, DialogManager.DIALOG_REMOTE_LOGIN);
        } else {
            super.show();
        }
    }
}
