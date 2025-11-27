package com.mobile.brasiltv.view.dialog;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.mobile.brasiltv.R$id;
import com.msandroid.mobile.R;
import com.umeng.analytics.pro.f;
import s9.l;
import t9.i;

public final class CommTipsDialog extends BaseDialog {
    private final boolean isCancelable;
    private final l mBottomBntListener;
    private final String mBottomBntStr;
    private final String mContent;
    private final String mTipStr;
    private final String mTitle;
    private final String mTopBntStr;
    private final l mTopListener;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ CommTipsDialog(android.content.Context r14, java.lang.String r15, java.lang.String r16, java.lang.String r17, java.lang.String r18, java.lang.String r19, s9.l r20, s9.l r21, boolean r22, int r23, t9.g r24) {
        /*
            r13 = this;
            r0 = r23
            r1 = r0 & 4
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r6 = r2
            goto L_0x000b
        L_0x0009:
            r6 = r16
        L_0x000b:
            r1 = r0 & 8
            if (r1 == 0) goto L_0x0011
            r7 = r2
            goto L_0x0013
        L_0x0011:
            r7 = r17
        L_0x0013:
            r1 = r0 & 16
            if (r1 == 0) goto L_0x0019
            r8 = r2
            goto L_0x001b
        L_0x0019:
            r8 = r18
        L_0x001b:
            r1 = r0 & 32
            if (r1 == 0) goto L_0x0021
            r9 = r2
            goto L_0x0023
        L_0x0021:
            r9 = r19
        L_0x0023:
            r1 = r0 & 64
            if (r1 == 0) goto L_0x0029
            r10 = r2
            goto L_0x002b
        L_0x0029:
            r10 = r20
        L_0x002b:
            r1 = r0 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x0031
            r11 = r2
            goto L_0x0033
        L_0x0031:
            r11 = r21
        L_0x0033:
            r0 = r0 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x003a
            r0 = 1
            r12 = 1
            goto L_0x003c
        L_0x003a:
            r12 = r22
        L_0x003c:
            r3 = r13
            r4 = r14
            r5 = r15
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mobile.brasiltv.view.dialog.CommTipsDialog.<init>(android.content.Context, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, s9.l, s9.l, boolean, int, t9.g):void");
    }

    /* access modifiers changed from: private */
    public static final void onCreate$lambda$0(CommTipsDialog commTipsDialog, View view) {
        i.g(commTipsDialog, "this$0");
        commTipsDialog.dismiss();
    }

    /* access modifiers changed from: private */
    public static final void onCreate$lambda$1(CommTipsDialog commTipsDialog, View view) {
        i.g(commTipsDialog, "this$0");
        commTipsDialog.dismiss();
        l lVar = commTipsDialog.mTopListener;
        if (lVar != null) {
            lVar.invoke(commTipsDialog);
        }
    }

    /* access modifiers changed from: private */
    public static final void onCreate$lambda$2(CommTipsDialog commTipsDialog, View view) {
        i.g(commTipsDialog, "this$0");
        commTipsDialog.dismiss();
        l lVar = commTipsDialog.mBottomBntListener;
        if (lVar != null) {
            lVar.invoke(commTipsDialog);
        }
    }

    private final void setTextView(TextView textView, String str) {
        if (TextUtils.isEmpty(str)) {
            textView.setVisibility(8);
            return;
        }
        textView.setVisibility(0);
        textView.setText(str);
        textView.setSelected(true);
    }

    public final l getMBottomBntListener() {
        return this.mBottomBntListener;
    }

    public final String getMBottomBntStr() {
        return this.mBottomBntStr;
    }

    public final String getMContent() {
        return this.mContent;
    }

    public final String getMTipStr() {
        return this.mTipStr;
    }

    public final String getMTitle() {
        return this.mTitle;
    }

    public final String getMTopBntStr() {
        return this.mTopBntStr;
    }

    public final l getMTopListener() {
        return this.mTopListener;
    }

    public final boolean isCancelable() {
        return this.isCancelable;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.dialog_comm_tips);
        Window window = getWindow();
        if (window != null) {
            window.setDimAmount(0.3f);
        }
        setCancelable(this.isCancelable);
        ((ImageView) findViewById(R$id.ivClose)).setOnClickListener(new i(this));
        ((TextView) findViewById(R$id.ivContent)).setText(this.mContent);
        TextView textView = (TextView) findViewById(R$id.tvTitle);
        i.f(textView, "tvTitle");
        setTextView(textView, this.mTitle);
        int i10 = R$id.tvTop;
        TextView textView2 = (TextView) findViewById(i10);
        i.f(textView2, "tvTop");
        setTextView(textView2, this.mTopBntStr);
        int i11 = R$id.tvBottom;
        TextView textView3 = (TextView) findViewById(i11);
        i.f(textView3, "tvBottom");
        setTextView(textView3, this.mBottomBntStr);
        TextView textView4 = (TextView) findViewById(R$id.mtvTips);
        i.f(textView4, "mtvTips");
        setTextView(textView4, this.mTipStr);
        ((TextView) findViewById(i10)).setOnClickListener(new j(this));
        ((TextView) findViewById(i11)).setOnClickListener(new k(this));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CommTipsDialog(Context context, String str, String str2, String str3, String str4, String str5, l lVar, l lVar2, boolean z10) {
        super(context);
        i.g(context, f.X);
        i.g(str, "mContent");
        this.mContent = str;
        this.mTitle = str2;
        this.mTopBntStr = str3;
        this.mBottomBntStr = str4;
        this.mTipStr = str5;
        this.mTopListener = lVar;
        this.mBottomBntListener = lVar2;
        this.isCancelable = z10;
    }
}
