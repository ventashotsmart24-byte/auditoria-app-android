package com.mobile.brasiltv.view.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.view.KoocanButton;
import com.msandroid.mobile.R;
import com.umeng.analytics.pro.f;
import com.zhy.autolayout.utils.AutoUtils;
import t9.i;

public final class DeleteConfirmDialog extends Dialog {
    private ConfirmCallback callback;
    private int deleteResId;

    public interface ConfirmCallback {
        void onConfirm();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DeleteConfirmDialog(Context context, int i10, ConfirmCallback confirmCallback) {
        super(context, R.style.OptionDialog);
        i.g(context, f.X);
        i.g(confirmCallback, "callback");
        this.deleteResId = i10;
        this.callback = confirmCallback;
    }

    /* access modifiers changed from: private */
    public static final void onCreate$lambda$1(DeleteConfirmDialog deleteConfirmDialog, View view) {
        i.g(deleteConfirmDialog, "this$0");
        deleteConfirmDialog.callback.onConfirm();
        deleteConfirmDialog.dismiss();
    }

    /* access modifiers changed from: private */
    public static final void onCreate$lambda$2(DeleteConfirmDialog deleteConfirmDialog, View view) {
        i.g(deleteConfirmDialog, "this$0");
        deleteConfirmDialog.dismiss();
    }

    public final ConfirmCallback getCallback() {
        return this.callback;
    }

    public final int getDeleteResId() {
        return this.deleteResId;
    }

    public void onCreate(Bundle bundle) {
        WindowManager.LayoutParams layoutParams;
        super.onCreate(bundle);
        setContentView(R.layout.dialog_delete_confirm);
        Window window = getWindow();
        if (window != null) {
            layoutParams = window.getAttributes();
        } else {
            layoutParams = null;
        }
        if (layoutParams != null) {
            layoutParams.gravity = 17;
            layoutParams.width = AutoUtils.getPercentWidthSize(520);
            layoutParams.height = AutoUtils.getPercentWidthSize(450);
            Window window2 = getWindow();
            if (window2 != null) {
                window2.setAttributes(layoutParams);
            }
        }
        ((TextView) findViewById(R$id.mTextDetail)).setText(getContext().getString(this.deleteResId));
        ((KoocanButton) findViewById(R$id.mButtonConfirm)).setOnClickListener(new q(this));
        ((KoocanButton) findViewById(R$id.mButtonCancel)).setOnClickListener(new r(this));
    }

    public final void setCallback(ConfirmCallback confirmCallback) {
        i.g(confirmCallback, "<set-?>");
        this.callback = confirmCallback;
    }

    public final void setDeleteResId(int i10) {
        this.deleteResId = i10;
    }
}
