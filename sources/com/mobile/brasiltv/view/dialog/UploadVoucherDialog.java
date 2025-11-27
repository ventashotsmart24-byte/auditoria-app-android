package com.mobile.brasiltv.view.dialog;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.utils.b0;
import com.msandroid.mobile.R;
import com.umeng.analytics.pro.f;
import t9.g;
import t9.i;

public final class UploadVoucherDialog extends CommonDialog {
    private String uploadVorcherUrl;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UploadVoucherDialog(Context context, String str) {
        super(context, 0, 2, (g) null);
        i.g(context, f.X);
        i.g(str, "uploadVorcherUrl");
        this.uploadVorcherUrl = str;
    }

    /* access modifiers changed from: private */
    public static final void initListener$lambda$0(UploadVoucherDialog uploadVoucherDialog, View view) {
        i.g(uploadVoucherDialog, "this$0");
        uploadVoucherDialog.dismiss();
    }

    /* access modifiers changed from: private */
    public static final void initListener$lambda$1(UploadVoucherDialog uploadVoucherDialog, View view) {
        i.g(uploadVoucherDialog, "this$0");
        Context context = uploadVoucherDialog.getContext();
        i.f(context, f.X);
        b0.j0(context, uploadVoucherDialog.uploadVorcherUrl, false, true, false, false, 24, (Object) null);
    }

    /* access modifiers changed from: private */
    public static final void initListener$lambda$2(UploadVoucherDialog uploadVoucherDialog, View view) {
        i.g(uploadVoucherDialog, "this$0");
        uploadVoucherDialog.dismiss();
    }

    public int getDialogHeight() {
        return 615;
    }

    public int getDialogWidth() {
        return 600;
    }

    public int getLayoutId() {
        return R.layout.dialog_upload_voucher;
    }

    public final String getUploadVorcherUrl() {
        return this.uploadVorcherUrl;
    }

    public void initListener() {
        ((ImageView) findViewById(R$id.mIvClose)).setOnClickListener(new d1(this));
        ((TextView) findViewById(R$id.mKbUpload)).setOnClickListener(new e1(this));
        ((TextView) findViewById(R$id.mKbCancel)).setOnClickListener(new f1(this));
    }

    public void initView() {
    }

    public final void setUploadVorcherUrl(String str) {
        i.g(str, "<set-?>");
        this.uploadVorcherUrl = str;
    }
}
