package com.mobile.brasiltv.view.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.mobile.brasiltv.R$id;
import com.msandroid.mobile.R;
import com.umeng.analytics.pro.f;
import s9.a;
import t9.i;

public final class VodGestureGuideDialog extends Dialog {
    private a mListener;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VodGestureGuideDialog(Context context) {
        super(context, R.style.guideDialgTheme);
        i.g(context, f.X);
    }

    private final void fullScreenImmersive(View view) {
        view.setSystemUiVisibility(5894);
    }

    /* access modifiers changed from: private */
    public static final void onCreate$lambda$0(VodGestureGuideDialog vodGestureGuideDialog, DialogInterface dialogInterface) {
        i.g(vodGestureGuideDialog, "this$0");
        GuideDialog.Companion.setMIsShowing(false);
        a aVar = vodGestureGuideDialog.mListener;
        if (aVar != null) {
            aVar.invoke();
        }
    }

    /* access modifiers changed from: private */
    public static final void onCreate$lambda$1(VodGestureGuideDialog vodGestureGuideDialog, View view) {
        i.g(vodGestureGuideDialog, "this$0");
        vodGestureGuideDialog.dismiss();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.dialog_guide_vod_gesture);
        Window window = getWindow();
        if (window != null) {
            window.setLayout(-1, -1);
        }
        setOnDismissListener(new l1(this));
        int i10 = R$id.ivGuide;
        ((ImageView) findViewById(i10)).setImageResource(R.drawable.intro_vod_full_screen);
        ((ImageView) findViewById(i10)).setOnClickListener(new m1(this));
    }

    public final void setOnButtonClickListener(a aVar) {
        i.g(aVar, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.mListener = aVar;
    }

    public void show() {
        View decorView;
        Window window = getWindow();
        if (window != null) {
            window.addFlags(8);
        }
        super.show();
        GuideDialog.Companion.setMIsShowing(true);
        Window window2 = getWindow();
        if (!(window2 == null || (decorView = window2.getDecorView()) == null)) {
            fullScreenImmersive(decorView);
        }
        Window window3 = getWindow();
        if (window3 != null) {
            window3.clearFlags(8);
        }
    }
}
