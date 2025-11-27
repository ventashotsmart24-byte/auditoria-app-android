package com.mobile.brasiltv.view.dialog;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.mobile.brasiltv.R$id;
import com.msandroid.mobile.R;
import com.umeng.analytics.pro.f;
import s9.l;
import t9.g;
import t9.i;

public class ConfirmDialog extends CommonDialog {
    private String content;
    private l mConfirmCallback;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ConfirmDialog(Context context, String str) {
        super(context, 0, 2, (g) null);
        i.g(context, f.X);
        i.g(str, "content");
        this.content = str;
    }

    /* access modifiers changed from: private */
    public static final void initListener$lambda$0(ConfirmDialog confirmDialog, View view) {
        i.g(confirmDialog, "this$0");
        l lVar = confirmDialog.mConfirmCallback;
        if (lVar != null) {
            lVar.invoke(confirmDialog);
        }
    }

    public final String getContent() {
        return this.content;
    }

    public int getDialogHeight() {
        return 420;
    }

    public int getDialogWidth() {
        return 560;
    }

    public int getLayoutId() {
        return R.layout.dialog_confirm;
    }

    public void initListener() {
        ((TextView) findViewById(R$id.mTvConfirm)).setOnClickListener(new n(this));
    }

    public void initView() {
        ((TextView) findViewById(R$id.mTvContent)).setText(this.content);
    }

    public final ConfirmDialog setConfirmCallback(l lVar) {
        i.g(lVar, "callback");
        this.mConfirmCallback = lVar;
        return this;
    }

    public final void setContent(String str) {
        i.g(str, "<set-?>");
        this.content = str;
    }
}
