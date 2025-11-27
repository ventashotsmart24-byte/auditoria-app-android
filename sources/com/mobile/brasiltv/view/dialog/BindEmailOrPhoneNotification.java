package com.mobile.brasiltv.view.dialog;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.mine.activity.EmailAty;
import com.mobile.brasiltv.utils.b0;
import com.msandroid.mobile.R;
import f5.c;
import t9.g;
import t9.i;

public final class BindEmailOrPhoneNotification extends CommonDialog {
    private Context mContext;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BindEmailOrPhoneNotification(Context context) {
        super(context, 0, 2, (g) null);
        i.g(context, "mContext");
        this.mContext = context;
    }

    /* access modifiers changed from: private */
    public static final void initListener$lambda$0(BindEmailOrPhoneNotification bindEmailOrPhoneNotification, View view) {
        i.g(bindEmailOrPhoneNotification, "this$0");
        bindEmailOrPhoneNotification.dismiss();
    }

    /* access modifiers changed from: private */
    public static final void initListener$lambda$1(BindEmailOrPhoneNotification bindEmailOrPhoneNotification, View view) {
        i.g(bindEmailOrPhoneNotification, "this$0");
        Context context = bindEmailOrPhoneNotification.mContext;
        i.e(context, "null cannot be cast to non-null type com.mobile.brasiltv.activity.BaseActivity");
        b0.c0((c) context, EmailAty.class);
        bindEmailOrPhoneNotification.dismiss();
    }

    public int getDialogHeight() {
        return 460;
    }

    public int getDialogWidth() {
        return 600;
    }

    public int getLayoutId() {
        return R.layout.dialog_notification_bind_email_or_phone;
    }

    public final Context getMContext() {
        return this.mContext;
    }

    public void initListener() {
        ((ImageView) findViewById(R$id.mIvClose)).setOnClickListener(new g(this));
        ((TextView) findViewById(R$id.mTvGotoBind)).setOnClickListener(new h(this));
    }

    public void initView() {
    }

    public final void setMContext(Context context) {
        i.g(context, "<set-?>");
        this.mContext = context;
    }
}
