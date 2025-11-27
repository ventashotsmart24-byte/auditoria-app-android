package com.mobile.brasiltv.view.dialog;

import a6.a;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.advertlib.bean.AdInfo;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.app.App;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.utils.c;
import com.mobile.brasiltv.utils.i1;
import com.mobile.brasiltv.utils.r0;
import com.mobile.brasiltv.view.AutoCardView;
import com.mobile.brasiltv.view.RoundedImageView;
import com.msandroid.mobile.R;
import com.titans.entity.CdnType;
import com.umeng.analytics.pro.f;
import com.zhy.autolayout.utils.AutoUtils;
import d6.b;
import io.reactivex.disposables.Disposable;
import ma.m;
import s1.q;
import s9.l;
import t9.i;

public final class InterstitialDialog extends BaseDialog {
    private final AdInfo adInfo;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public InterstitialDialog(Context context, AdInfo adInfo2) {
        super(context);
        i.g(context, f.X);
        i.g(adInfo2, "adInfo");
        this.adInfo = adInfo2;
    }

    /* access modifiers changed from: private */
    public static final void onCreate$lambda$0(InterstitialDialog interstitialDialog, View view) {
        i.g(interstitialDialog, "this$0");
        b0.j(interstitialDialog);
    }

    /* access modifiers changed from: private */
    public static final void onCreate$lambda$1(InterstitialDialog interstitialDialog, View view) {
        String str;
        boolean z10;
        i.g(interstitialDialog, "this$0");
        AdInfo adInfo2 = interstitialDialog.adInfo;
        String str2 = null;
        if (adInfo2 != null) {
            str = adInfo2.getAction_type();
        } else {
            str = null;
        }
        if (i.b(str, "1")) {
            String action = interstitialDialog.adInfo.getAction();
            if (action == null || action.length() <= 0) {
                z10 = false;
            } else {
                z10 = true;
            }
            if (z10) {
                q qVar = q.f9311a;
                Context context = interstitialDialog.getContext();
                i.f(context, f.X);
                b bVar = b.f6366a;
                Context context2 = interstitialDialog.getContext();
                i.f(context2, f.X);
                qVar.h(context, bVar.m(context2), a.f10646a.d(), interstitialDialog.adInfo);
                i1.e(interstitialDialog.getContext(), "EVENT_AD_CLICK_INTERSTITIA");
                String c10 = r0.c(r0.f12611a, interstitialDialog.adInfo.getAction(), false, 2, (Object) null);
                Context context3 = interstitialDialog.getContext();
                i.f(context3, f.X);
                b0.j0(context3, c10, false, true, false, false, 24, (Object) null);
                b0.j(interstitialDialog);
                return;
            }
        }
        AdInfo adInfo3 = interstitialDialog.adInfo;
        if (adInfo3 != null) {
            str2 = adInfo3.getAction_type();
        }
        if (i.b(str2, CdnType.DIGITAL_TYPE_PCDN)) {
            Context context4 = interstitialDialog.getContext();
            i.f(context4, f.X);
            b0.m(context4);
        }
    }

    /* access modifiers changed from: private */
    public static final void onCreate$lambda$2(Disposable disposable, DialogInterface dialogInterface) {
        if (!disposable.isDisposed()) {
            disposable.dispose();
        }
    }

    public final AdInfo getAdInfo() {
        return this.adInfo;
    }

    public void onBackPressed() {
        b0.j(this);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.dialog_interstitial);
        Window window = getWindow();
        if (window != null) {
            window.setDimAmount(0.3f);
        }
        setCanceledOnTouchOutside(false);
        ((AutoCardView) findViewById(R$id.mAcvWrapper)).setRadius((float) AutoUtils.getPercentWidthSize(20));
        if (this.adInfo.isShowFlag()) {
            ((TextView) findViewById(R$id.mTvFlag)).setVisibility(0);
        } else {
            ((TextView) findViewById(R$id.mTvFlag)).setVisibility(8);
        }
        ((ImageView) findViewById(R$id.ivClose)).setOnClickListener(new l0(this));
        c j10 = App.f6050e.a().j();
        String e10 = m.e(this.adInfo.getUrl());
        i.f(e10, "md5(adInfo.url)");
        j10.l(e10);
        s1.m mVar = s1.m.f9270a;
        Context context = getContext();
        i.f(context, f.X);
        int i10 = R$id.ivInterstitial;
        RoundedImageView roundedImageView = (RoundedImageView) findViewById(i10);
        i.f(roundedImageView, "ivInterstitial");
        a aVar = a.f10646a;
        s1.m.h0(mVar, context, roundedImageView, aVar.d(), this.adInfo, (Integer) null, (l) null, (Integer) null, false, 0, 496, (Object) null);
        ((RoundedImageView) findViewById(i10)).setOnClickListener(new m0(this));
        q qVar = q.f9311a;
        Context context2 = getContext();
        i.f(context2, f.X);
        b bVar = b.f6366a;
        Context context3 = getContext();
        i.f(context3, f.X);
        qVar.j(context2, bVar.m(context3), aVar.d(), this.adInfo);
        Context context4 = getContext();
        i.f(context4, f.X);
        mVar.d0(context4, aVar.d(), this.adInfo.getAd_id());
        i1.e(getContext(), "EVENT_AD_SHOW_INTERSTITIA");
        setOnDismissListener(new n0(i1.p(getContext(), "EVENT_AD_LONG_SHOW_INTERSTITIA")));
    }
}
