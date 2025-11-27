package com.mobile.brasiltv.view.dialog;

import android.content.Context;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.utils.f0;
import com.mobile.brasiltv.utils.i1;
import com.msandroid.mobile.R;
import com.umeng.analytics.pro.f;
import java.util.Date;
import m7.c;
import na.a;
import t9.i;
import w6.i;

public final class PriorityVipDialog$initView$1 extends ClickableSpan {
    final /* synthetic */ PriorityVipDialog this$0;

    public PriorityVipDialog$initView$1(PriorityVipDialog priorityVipDialog) {
        this.this$0 = priorityVipDialog;
    }

    public void onClick(View view) {
        i.g(view, "widget");
        i1.w(this.this$0.getContext(), "Help");
        i.c cVar = w6.i.f9510g;
        boolean b10 = t9.i.b(cVar.e(), "0");
        Context context = this.this$0.getContext();
        t9.i.f(context, f.X);
        b0.j0(context, b0.x(c.g()) + "/#/app-help?isFree=" + b10 + "&appId=" + a.g() + "&userId=" + cVar.H() + "&lang=" + f0.a() + "&appVersion=" + a.b() + "&timestamp=" + new Date().getTime() + "&portalCode=" + cVar.v(), false, true, false, false, 24, (Object) null);
    }

    public void updateDrawState(TextPaint textPaint) {
        t9.i.g(textPaint, "ds");
        super.updateDrawState(textPaint);
        textPaint.setColor(this.this$0.getContext().getResources().getColor(R.color.color_important));
    }
}
