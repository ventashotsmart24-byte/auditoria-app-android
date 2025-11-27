package com.mobile.brasiltv.view.dialog;

import android.content.Context;
import android.widget.TextView;
import com.mobile.brasiltv.R$id;
import com.msandroid.mobile.R;
import com.umeng.analytics.pro.f;
import t9.i;

public final class OkDialog extends ConfirmDialog {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OkDialog(Context context, String str) {
        super(context, str);
        i.g(context, f.X);
        i.g(str, "content");
    }

    public void initView() {
        super.initView();
        ((TextView) findViewById(R$id.mTvConfirm)).setText(getContext().getResources().getString(R.string.common_ok));
    }
}
