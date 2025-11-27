package com.mobile.brasiltv.view;

import android.app.Dialog;
import android.content.Context;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.utils.b0;
import com.msandroid.mobile.R;
import com.umeng.analytics.pro.f;
import com.zhy.autolayout.utils.AutoUtils;
import t9.i;

public final class NoticeDialog extends Dialog {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NoticeDialog(Context context, String str) {
        super(context, R.style.OptionDialog);
        WindowManager.LayoutParams layoutParams;
        i.g(context, f.X);
        i.g(str, "noticeInfo");
        setContentView(R.layout.dialog_notice);
        Window window = getWindow();
        if (window != null) {
            layoutParams = window.getAttributes();
        } else {
            layoutParams = null;
        }
        if (layoutParams != null) {
            layoutParams.gravity = 17;
            layoutParams.width = AutoUtils.getPercentWidthSize(560);
            Window window2 = getWindow();
            if (window2 != null) {
                window2.setAttributes(layoutParams);
            }
        }
        int i10 = R$id.dialogContent;
        ((TextView) findViewById(i10)).setMovementMethod(ScrollingMovementMethod.getInstance());
        ((TextView) findViewById(i10)).setScrollbarFadingEnabled(false);
        ((TextView) findViewById(i10)).setText(str);
        setCanceledOnTouchOutside(false);
        ((Button) findViewById(R$id.dialogClose)).setOnClickListener(new a0(this));
    }

    /* access modifiers changed from: private */
    public static final void _init_$lambda$1(NoticeDialog noticeDialog, View view) {
        i.g(noticeDialog, "this$0");
        b0.j(noticeDialog);
    }

    public void onBackPressed() {
        b0.j(this);
    }
}
