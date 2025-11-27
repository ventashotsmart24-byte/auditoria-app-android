package com.mobile.brasiltv.view.dialog;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.view.AutoCardView;
import com.msandroid.mobile.R;
import com.zhy.autolayout.utils.AutoUtils;
import t9.g;
import t9.i;

public final class DeleteMsgDialog extends CommonDialog {
    private String content;
    private View.OnClickListener mConfirmListener;
    private Context mContext;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DeleteMsgDialog(Context context, String str) {
        super(context, 0, 2, (g) null);
        i.g(context, "mContext");
        i.g(str, "content");
        this.mContext = context;
        this.content = str;
    }

    /* access modifiers changed from: private */
    public static final void initListener$lambda$0(DeleteMsgDialog deleteMsgDialog, View view) {
        i.g(deleteMsgDialog, "this$0");
        deleteMsgDialog.dismiss();
    }

    /* access modifiers changed from: private */
    public static final void initListener$lambda$1(DeleteMsgDialog deleteMsgDialog, View view) {
        i.g(deleteMsgDialog, "this$0");
        View.OnClickListener onClickListener = deleteMsgDialog.mConfirmListener;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
        deleteMsgDialog.dismiss();
    }

    public final String getContent() {
        return this.content;
    }

    public int getDialogHeight() {
        return -2;
    }

    public int getDialogWidth() {
        return 600;
    }

    public int getLayoutId() {
        return R.layout.dialog_delete_msg;
    }

    public final Context getMContext() {
        return this.mContext;
    }

    public void initListener() {
        ((TextView) findViewById(R$id.mTvCancel)).setOnClickListener(new s(this));
        ((TextView) findViewById(R$id.mTvConfirm)).setOnClickListener(new t(this));
    }

    public void initView() {
        ((AutoCardView) findViewById(R$id.mAcvRoot)).setRadius((float) AutoUtils.getPercentWidthSize(16));
        ((TextView) findViewById(R$id.mTvContent)).setText(this.content);
    }

    public final DeleteMsgDialog setConfirmListener(View.OnClickListener onClickListener) {
        i.g(onClickListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.mConfirmListener = onClickListener;
        return this;
    }

    public final void setContent(String str) {
        i.g(str, "<set-?>");
        this.content = str;
    }

    public final void setMContext(Context context) {
        i.g(context, "<set-?>");
        this.mContext = context;
    }
}
