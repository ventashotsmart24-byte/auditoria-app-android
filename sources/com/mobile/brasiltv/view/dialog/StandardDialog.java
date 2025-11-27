package com.mobile.brasiltv.view.dialog;

import android.app.Dialog;
import android.content.Context;
import android.text.Html;
import android.view.View;
import android.widget.TextView;
import ba.t;
import com.mobile.brasiltv.R$id;
import com.msandroid.mobile.R;
import com.taobao.accs.common.Constants;
import com.umeng.analytics.pro.f;
import t9.i;

public final class StandardDialog extends Dialog {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StandardDialog(Context context) {
        super(context, R.style.SimpleDialog);
        i.g(context, f.X);
        setContentView(R.layout.dialog_standard);
        setCancelable(false);
    }

    public final void setDialogConfig(String str, String str2, String str3, String str4, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        i.g(str, "title");
        i.g(str2, Constants.SHARED_MESSAGE_ID_FILE);
        i.g(str4, "btnRightText");
        i.g(onClickListener2, "btnRightListener");
        ((TextView) findViewById(R$id.mTvTitle)).setText(str);
        boolean z10 = false;
        if (t.o(str2, "<b>", false, 2, (Object) null)) {
            ((TextView) findViewById(R$id.mTvMessage)).setText(Html.fromHtml(str2));
        } else {
            ((TextView) findViewById(R$id.mTvMessage)).setText(str2);
        }
        if (str3 == null || str3.length() == 0) {
            z10 = true;
        }
        if (z10) {
            ((TextView) findViewById(R$id.mBtnLeft)).setVisibility(8);
            findViewById(R$id.mIvLine).setVisibility(8);
        } else {
            ((TextView) findViewById(R$id.mBtnLeft)).setText(str3);
        }
        if (onClickListener != null) {
            ((TextView) findViewById(R$id.mBtnLeft)).setOnClickListener(onClickListener);
        }
        int i10 = R$id.mBtnRight;
        ((TextView) findViewById(i10)).setText(str4);
        ((TextView) findViewById(i10)).setOnClickListener(onClickListener2);
    }
}
