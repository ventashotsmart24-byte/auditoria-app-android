package com.mobile.brasiltv.view.dialog;

import a6.a;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import com.advertlib.bean.AdInfo;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.app.App;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.utils.c;
import com.mobile.brasiltv.utils.i1;
import com.msandroid.mobile.R;
import com.umeng.analytics.pro.f;
import d6.b;
import io.reactivex.disposables.Disposable;
import ma.m;
import s1.q;
import s9.l;
import t9.i;

public final class HomeImportantAdDialog extends BaseDialog {
    private final AdInfo adInfo;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HomeImportantAdDialog(Context context, AdInfo adInfo2) {
        super(context);
        i.g(context, f.X);
        i.g(adInfo2, "adInfo");
        this.adInfo = adInfo2;
    }

    /* access modifiers changed from: private */
    public static final void onCreate$lambda$1(HomeImportantAdDialog homeImportantAdDialog, View view) {
        i.g(homeImportantAdDialog, "this$0");
        b0.j(homeImportantAdDialog);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0028, code lost:
        if (r14 == true) goto L_0x002c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void onCreate$lambda$2(com.mobile.brasiltv.view.dialog.HomeImportantAdDialog r13, android.view.View r14) {
        /*
            java.lang.String r14 = "this$0"
            t9.i.g(r13, r14)
            com.advertlib.bean.AdInfo r14 = r13.adInfo
            java.lang.String r14 = r14.getAction_type()
            java.lang.String r0 = "1"
            boolean r14 = t9.i.b(r14, r0)
            java.lang.String r0 = "context"
            if (r14 == 0) goto L_0x007b
            com.advertlib.bean.AdInfo r14 = r13.adInfo
            java.lang.String r14 = r14.getAction()
            r1 = 0
            if (r14 == 0) goto L_0x002b
            int r14 = r14.length()
            r2 = 1
            if (r14 <= 0) goto L_0x0027
            r14 = 1
            goto L_0x0028
        L_0x0027:
            r14 = 0
        L_0x0028:
            if (r14 != r2) goto L_0x002b
            goto L_0x002c
        L_0x002b:
            r2 = 0
        L_0x002c:
            if (r2 == 0) goto L_0x007b
            s1.q r14 = s1.q.f9311a
            android.content.Context r2 = r13.getContext()
            t9.i.f(r2, r0)
            d6.b r3 = d6.b.f6366a
            android.content.Context r4 = r13.getContext()
            t9.i.f(r4, r0)
            java.lang.String r3 = r3.m(r4)
            a6.a r4 = a6.a.f10646a
            java.lang.String r4 = r4.i()
            com.advertlib.bean.AdInfo r5 = r13.adInfo
            r14.h(r2, r3, r4, r5)
            android.content.Context r14 = r13.getContext()
            java.lang.String r2 = "EVENT_AD_CLICK_HOME_IMPORTANT"
            com.mobile.brasiltv.utils.i1.e(r14, r2)
            com.mobile.brasiltv.utils.r0 r14 = com.mobile.brasiltv.utils.r0.f12611a
            com.advertlib.bean.AdInfo r2 = r13.adInfo
            java.lang.String r2 = r2.getAction()
            r3 = 2
            r4 = 0
            java.lang.String r6 = com.mobile.brasiltv.utils.r0.c(r14, r2, r1, r3, r4)
            android.content.Context r5 = r13.getContext()
            t9.i.f(r5, r0)
            r7 = 0
            r8 = 1
            r9 = 0
            r10 = 0
            r11 = 24
            r12 = 0
            com.mobile.brasiltv.utils.b0.j0(r5, r6, r7, r8, r9, r10, r11, r12)
            com.mobile.brasiltv.utils.b0.j(r13)
            goto L_0x0093
        L_0x007b:
            com.advertlib.bean.AdInfo r14 = r13.adInfo
            java.lang.String r14 = r14.getAction_type()
            java.lang.String r1 = "5"
            boolean r14 = t9.i.b(r14, r1)
            if (r14 == 0) goto L_0x0093
            android.content.Context r13 = r13.getContext()
            t9.i.f(r13, r0)
            com.mobile.brasiltv.utils.b0.m(r13)
        L_0x0093:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mobile.brasiltv.view.dialog.HomeImportantAdDialog.onCreate$lambda$2(com.mobile.brasiltv.view.dialog.HomeImportantAdDialog, android.view.View):void");
    }

    /* access modifiers changed from: private */
    public static final void onCreate$lambda$3(Disposable disposable, DialogInterface dialogInterface) {
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
        WindowManager.LayoutParams layoutParams;
        super.onCreate(bundle);
        setContentView((int) R.layout.dialog_home_important_ad);
        Window window = getWindow();
        if (window != null) {
            window.setDimAmount(0.3f);
        }
        Window window2 = getWindow();
        if (window2 != null) {
            layoutParams = window2.getAttributes();
        } else {
            layoutParams = null;
        }
        if (layoutParams != null) {
            layoutParams.gravity = 17;
            layoutParams.width = -1;
            layoutParams.height = -1;
            Window window3 = getWindow();
            if (window3 != null) {
                window3.setAttributes(layoutParams);
            }
        }
        setCanceledOnTouchOutside(false);
        ((ImageView) findViewById(R$id.mIvClose)).setOnClickListener(new f0(this));
        App.a aVar = App.f6050e;
        c j10 = aVar.a().j();
        String e10 = m.e(this.adInfo.getUrl());
        i.f(e10, "md5(adInfo.url)");
        j10.i(e10);
        aVar.a().j().j(SystemClock.elapsedRealtime());
        s1.m mVar = s1.m.f9270a;
        Context context = getContext();
        i.f(context, f.X);
        int i10 = R$id.mIvAd;
        ImageView imageView = (ImageView) findViewById(i10);
        i.f(imageView, "mIvAd");
        a aVar2 = a.f10646a;
        s1.m.h0(mVar, context, imageView, aVar2.i(), this.adInfo, (Integer) null, (l) null, (Integer) null, false, 1, 240, (Object) null);
        ((ImageView) findViewById(i10)).setOnClickListener(new g0(this));
        q qVar = q.f9311a;
        Context context2 = getContext();
        i.f(context2, f.X);
        b bVar = b.f6366a;
        Context context3 = getContext();
        i.f(context3, f.X);
        qVar.j(context2, bVar.m(context3), aVar2.i(), this.adInfo);
        Context context4 = getContext();
        i.f(context4, f.X);
        mVar.d0(context4, aVar2.i(), this.adInfo.getAd_id());
        i1.e(getContext(), "EVENT_AD_SHOW_HOME_IMPORTANT");
        setOnDismissListener(new h0(i1.p(getContext(), "EVENT_AD_LONG_SHOW_HOME_IMPORTANT")));
    }
}
