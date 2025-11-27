package com.mobile.brasiltv.view.dialog;

import android.content.Context;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.utils.i1;
import com.msandroid.mobile.R;
import com.umeng.analytics.pro.f;
import com.zhy.autolayout.utils.AutoUtils;
import java.util.Arrays;
import s9.a;
import t9.i;
import t9.z;

public final class ForceBindNormalDialog extends BaseDialog {
    private final a callback;
    private final Context context;
    private int restDays;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ForceBindNormalDialog(Context context2, int i10, a aVar) {
        super(context2);
        i.g(context2, f.X);
        i.g(aVar, "callback");
        this.context = context2;
        this.restDays = i10;
        this.callback = aVar;
    }

    /* access modifiers changed from: private */
    public static final void onCreate$lambda$1(ForceBindNormalDialog forceBindNormalDialog, View view) {
        i.g(forceBindNormalDialog, "this$0");
        i1.z(forceBindNormalDialog.context);
        b0.j(forceBindNormalDialog);
    }

    /* access modifiers changed from: private */
    public static final void onCreate$lambda$2(ForceBindNormalDialog forceBindNormalDialog, View view) {
        i.g(forceBindNormalDialog, "this$0");
        b0.j(forceBindNormalDialog);
        forceBindNormalDialog.callback.invoke();
    }

    /* access modifiers changed from: private */
    public static final void onCreate$lambda$3(ForceBindNormalDialog forceBindNormalDialog, View view) {
        i.g(forceBindNormalDialog, "this$0");
        b0.j(forceBindNormalDialog);
    }

    public void onBackPressed() {
        b0.j(this);
    }

    public void onCreate(Bundle bundle) {
        WindowManager.LayoutParams layoutParams;
        super.onCreate(bundle);
        setContentView((int) R.layout.dialog_force_bind_normal);
        Window window = getWindow();
        if (window != null) {
            layoutParams = window.getAttributes();
        } else {
            layoutParams = null;
        }
        if (layoutParams != null) {
            layoutParams.gravity = 17;
            layoutParams.width = AutoUtils.getPercentWidthSize(630);
            Window window2 = getWindow();
            if (window2 != null) {
                window2.setAttributes(layoutParams);
            }
        }
        z zVar = z.f19601a;
        String string = this.context.getString(R.string.force_bind_normal_content_one);
        i.f(string, "context.getString(R.stri…_bind_normal_content_one)");
        String format = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(this.restDays)}, 1));
        i.f(format, "format(format, *args)");
        ((TextView) findViewById(R$id.tvContentOne)).setText(Html.fromHtml(format));
        ((TextView) findViewById(R$id.tvContentTwo)).setText(Html.fromHtml(this.context.getString(R.string.force_bind_normal_content_two)));
        ((TextView) findViewById(R$id.tvBindLater)).setOnClickListener(new y(this));
        ((TextView) findViewById(R$id.tvBindNow)).setOnClickListener(new z(this));
        ((ImageView) findViewById(R$id.ivClose)).setOnClickListener(new a0(this));
        setCanceledOnTouchOutside(false);
    }
}
