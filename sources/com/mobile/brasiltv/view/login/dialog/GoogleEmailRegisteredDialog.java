package com.mobile.brasiltv.view.login.dialog;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.gms.common.Scopes;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.view.KoocanButton;
import com.mobile.brasiltv.view.dialog.CommonDialog;
import com.msandroid.mobile.R;
import com.umeng.analytics.pro.f;
import java.util.Arrays;
import t9.g;
import t9.i;
import t9.z;

public final class GoogleEmailRegisteredDialog extends CommonDialog {
    private String email;
    private IBindThirdPartCallback mBindThirdPartCallback;

    public interface IBindThirdPartCallback {
        void dialogRevokeAccessGoogle();

        void onBindThirdPart();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GoogleEmailRegisteredDialog(Context context, String str) {
        super(context, 0, 2, (g) null);
        i.g(context, f.X);
        i.g(str, Scopes.EMAIL);
        this.email = str;
    }

    /* access modifiers changed from: private */
    public static final void initListener$lambda$0(GoogleEmailRegisteredDialog googleEmailRegisteredDialog, View view) {
        i.g(googleEmailRegisteredDialog, "this$0");
        IBindThirdPartCallback iBindThirdPartCallback = googleEmailRegisteredDialog.mBindThirdPartCallback;
        if (iBindThirdPartCallback != null) {
            iBindThirdPartCallback.dialogRevokeAccessGoogle();
        }
        googleEmailRegisteredDialog.dismiss();
    }

    /* access modifiers changed from: private */
    public static final void initListener$lambda$1(GoogleEmailRegisteredDialog googleEmailRegisteredDialog, View view) {
        i.g(googleEmailRegisteredDialog, "this$0");
        IBindThirdPartCallback iBindThirdPartCallback = googleEmailRegisteredDialog.mBindThirdPartCallback;
        if (iBindThirdPartCallback != null) {
            iBindThirdPartCallback.onBindThirdPart();
        }
        googleEmailRegisteredDialog.dismiss();
    }

    public int getDialogHeight() {
        return -2;
    }

    public int getDialogWidth() {
        return 600;
    }

    public final String getEmail() {
        return this.email;
    }

    public int getLayoutId() {
        return R.layout.dialog_google_email_registered;
    }

    public void initListener() {
        ((ImageView) findViewById(R$id.mIvClose)).setOnClickListener(new f(this));
        ((KoocanButton) findViewById(R$id.mKbOk)).setOnClickListener(new g(this));
    }

    public void initView() {
        z zVar = z.f19601a;
        String string = getContext().getResources().getString(R.string.google_email_has_registered);
        i.f(string, "context.resources.getStr…gle_email_has_registered)");
        String format = String.format(string, Arrays.copyOf(new Object[]{this.email}, 1));
        i.f(format, "format(format, *args)");
        ((TextView) findViewById(R$id.mTvContent)).setText(format);
        setCancelable(false);
    }

    public final GoogleEmailRegisteredDialog setBindThirdPartCallback(IBindThirdPartCallback iBindThirdPartCallback) {
        i.g(iBindThirdPartCallback, "callback");
        this.mBindThirdPartCallback = iBindThirdPartCallback;
        return this;
    }

    public final void setEmail(String str) {
        i.g(str, "<set-?>");
        this.email = str;
    }
}
