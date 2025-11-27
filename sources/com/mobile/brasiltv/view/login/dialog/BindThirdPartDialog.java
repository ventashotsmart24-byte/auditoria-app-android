package com.mobile.brasiltv.view.login.dialog;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.view.KoocanButton;
import com.mobile.brasiltv.view.dialog.CommonDialog;
import com.msandroid.mobile.R;
import com.umeng.analytics.pro.f;
import t9.g;
import t9.i;
import x7.a;

public final class BindThirdPartDialog extends CommonDialog {
    private IBindThirdPartCallback mBindThirdPartCallback;
    private a socialInfo;
    private String thirdPartType;
    private String tpSource;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BindThirdPartDialog(Context context, String str, String str2, a aVar) {
        super(context, 0, 2, (g) null);
        i.g(context, f.X);
        i.g(str, "thirdPartType");
        i.g(str2, "tpSource");
        i.g(aVar, "socialInfo");
        this.thirdPartType = str;
        this.tpSource = str2;
        this.socialInfo = aVar;
    }

    /* access modifiers changed from: private */
    public static final void initListener$lambda$0(BindThirdPartDialog bindThirdPartDialog, View view) {
        i.g(bindThirdPartDialog, "this$0");
        IBindThirdPartCallback iBindThirdPartCallback = bindThirdPartDialog.mBindThirdPartCallback;
        if (iBindThirdPartCallback != null) {
            iBindThirdPartCallback.dialogRevokeAccessGoogle();
        }
        bindThirdPartDialog.dismiss();
    }

    /* access modifiers changed from: private */
    public static final void initListener$lambda$1(BindThirdPartDialog bindThirdPartDialog, View view) {
        i.g(bindThirdPartDialog, "this$0");
        IBindThirdPartCallback iBindThirdPartCallback = bindThirdPartDialog.mBindThirdPartCallback;
        if (iBindThirdPartCallback != null) {
            iBindThirdPartCallback.onBindThirdPart(bindThirdPartDialog.thirdPartType, bindThirdPartDialog.tpSource, bindThirdPartDialog.socialInfo);
        }
        bindThirdPartDialog.dismiss();
    }

    /* access modifiers changed from: private */
    public static final void initListener$lambda$2(BindThirdPartDialog bindThirdPartDialog, View view) {
        i.g(bindThirdPartDialog, "this$0");
        IBindThirdPartCallback iBindThirdPartCallback = bindThirdPartDialog.mBindThirdPartCallback;
        if (iBindThirdPartCallback != null) {
            iBindThirdPartCallback.onClickCreateNewAccount(bindThirdPartDialog.thirdPartType, bindThirdPartDialog.tpSource, bindThirdPartDialog.socialInfo);
        }
        bindThirdPartDialog.dismiss();
    }

    public int getDialogHeight() {
        return 420;
    }

    public int getDialogWidth() {
        return 560;
    }

    public int getLayoutId() {
        return R.layout.dialog_bind_third_part;
    }

    public final a getSocialInfo() {
        return this.socialInfo;
    }

    public final String getThirdPartType() {
        return this.thirdPartType;
    }

    public final String getTpSource() {
        return this.tpSource;
    }

    public void initListener() {
        ((ImageView) findViewById(R$id.mIvClose)).setOnClickListener(new a(this));
        ((KoocanButton) findViewById(R$id.mKbOk)).setOnClickListener(new b(this));
        ((TextView) findViewById(R$id.mTvCreateNewAccount)).setOnClickListener(new c(this));
    }

    public void initView() {
        ((TextView) findViewById(R$id.mTvHint)).setText(getContext().getResources().getString(R.string.bind_google_account_with_device));
        int i10 = R$id.mTvCreateNewAccount;
        ((TextView) findViewById(i10)).getPaint().setFlags(8);
        ((TextView) findViewById(i10)).getPaint().setAntiAlias(true);
        setCancelable(false);
    }

    public final BindThirdPartDialog setBindThirdPartCallback(IBindThirdPartCallback iBindThirdPartCallback) {
        i.g(iBindThirdPartCallback, "callback");
        this.mBindThirdPartCallback = iBindThirdPartCallback;
        return this;
    }

    public final void setSocialInfo(a aVar) {
        i.g(aVar, "<set-?>");
        this.socialInfo = aVar;
    }

    public final void setThirdPartType(String str) {
        i.g(str, "<set-?>");
        this.thirdPartType = str;
    }

    public final void setTpSource(String str) {
        i.g(str, "<set-?>");
        this.tpSource = str;
    }
}
