package com.mobile.brasiltv.view.dialog;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.mobile.brasiltv.R$id;
import com.msandroid.mobile.R;
import com.umeng.analytics.pro.f;
import s9.l;
import t9.g;
import t9.i;

public final class AdRewardedDialog extends BaseDialog {
    private final l mBottomBntListener;
    private final String mBottomBntStr;
    private final String mContent;
    private final String mTopBntStr;
    private final l mTopListener;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AdRewardedDialog(Context context, String str, String str2, String str3, l lVar, l lVar2, int i10, g gVar) {
        this(context, str, str2, str3, (i10 & 16) != 0 ? null : lVar, (i10 & 32) != 0 ? null : lVar2);
    }

    /* access modifiers changed from: private */
    public static final void onCreate$lambda$0(AdRewardedDialog adRewardedDialog, View view) {
        i.g(adRewardedDialog, "this$0");
        adRewardedDialog.dismiss();
    }

    /* access modifiers changed from: private */
    public static final void onCreate$lambda$1(AdRewardedDialog adRewardedDialog, View view) {
        i.g(adRewardedDialog, "this$0");
        adRewardedDialog.dismiss();
        l lVar = adRewardedDialog.mTopListener;
        if (lVar != null) {
            lVar.invoke(adRewardedDialog);
        }
    }

    /* access modifiers changed from: private */
    public static final void onCreate$lambda$2(AdRewardedDialog adRewardedDialog, View view) {
        i.g(adRewardedDialog, "this$0");
        adRewardedDialog.dismiss();
        l lVar = adRewardedDialog.mBottomBntListener;
        if (lVar != null) {
            lVar.invoke(adRewardedDialog);
        }
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

    public final String getMTopBntStr() {
        return this.mTopBntStr;
    }

    public final l getMTopListener() {
        return this.mTopListener;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.dialog_ad_rewarded);
        Window window = getWindow();
        if (window != null) {
            window.setDimAmount(0.3f);
        }
        ((ImageView) findViewById(R$id.ivClose)).setOnClickListener(new d(this));
        ((TextView) findViewById(R$id.ivContent)).setText(this.mContent);
        int i10 = R$id.tvTop;
        ((TextView) findViewById(i10)).setText(this.mTopBntStr);
        int i11 = R$id.tvBottom;
        ((TextView) findViewById(i11)).setText(this.mBottomBntStr);
        ((TextView) findViewById(i10)).setSelected(true);
        ((TextView) findViewById(i11)).setSelected(true);
        ((TextView) findViewById(i10)).setOnClickListener(new e(this));
        ((TextView) findViewById(i11)).setOnClickListener(new f(this));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AdRewardedDialog(Context context, String str, String str2, String str3, l lVar, l lVar2) {
        super(context);
        i.g(context, f.X);
        i.g(str, "mContent");
        i.g(str2, "mTopBntStr");
        i.g(str3, "mBottomBntStr");
        this.mContent = str;
        this.mTopBntStr = str2;
        this.mBottomBntStr = str3;
        this.mTopListener = lVar;
        this.mBottomBntListener = lVar2;
    }
}
