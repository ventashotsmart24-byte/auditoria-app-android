package com.mobile.brasiltv.view.adView;

import com.advertlib.bean.AdInfo;
import h9.t;
import s9.p;
import t9.j;

public final class AdaptiveAdContainer$showOwnAdView$1 extends j implements p {
    final /* synthetic */ AdaptiveAdContainer this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AdaptiveAdContainer$showOwnAdView$1(AdaptiveAdContainer adaptiveAdContainer) {
        super(2);
        this.this$0 = adaptiveAdContainer;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((AdInfo) obj, ((Boolean) obj2).booleanValue());
        return t.f17319a;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x000c, code lost:
        if (r4.isShowFlag() == true) goto L_0x0010;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke(com.advertlib.bean.AdInfo r4, boolean r5) {
        /*
            r3 = this;
            r0 = 8
            if (r5 == 0) goto L_0x006b
            r5 = 0
            if (r4 == 0) goto L_0x000f
            boolean r1 = r4.isShowFlag()
            r2 = 1
            if (r1 != r2) goto L_0x000f
            goto L_0x0010
        L_0x000f:
            r2 = 0
        L_0x0010:
            if (r2 == 0) goto L_0x0020
            com.mobile.brasiltv.view.adView.AdaptiveAdContainer r0 = r3.this$0
            int r1 = com.mobile.brasiltv.R$id.mTvFlag
            android.view.View r0 = r0._$_findCachedViewById(r1)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r0.setVisibility(r5)
            goto L_0x002d
        L_0x0020:
            com.mobile.brasiltv.view.adView.AdaptiveAdContainer r1 = r3.this$0
            int r2 = com.mobile.brasiltv.R$id.mTvFlag
            android.view.View r1 = r1._$_findCachedViewById(r2)
            android.widget.TextView r1 = (android.widget.TextView) r1
            r1.setVisibility(r0)
        L_0x002d:
            com.mobile.brasiltv.view.adView.AdaptiveAdContainer r0 = r3.this$0
            com.mobile.brasiltv.view.adView.AdaptiveAdView$AdaptiveAdCallback r0 = r0.mListener
            if (r0 == 0) goto L_0x0038
            r0.onAdLoaded()
        L_0x0038:
            com.mobile.brasiltv.view.adView.AdaptiveAdContainer r0 = r3.this$0
            r0.reportEvent(r5)
            s1.m r5 = s1.m.f9270a
            com.mobile.brasiltv.view.adView.AdaptiveAdContainer r0 = r3.this$0
            android.content.Context r0 = r0.getContext()
            java.lang.String r1 = "context"
            t9.i.f(r0, r1)
            com.mobile.brasiltv.view.adView.AdaptiveAdContainer r1 = r3.this$0
            int r2 = com.mobile.brasiltv.R$id.mIvAd
            android.view.View r1 = r1._$_findCachedViewById(r2)
            com.mobile.brasiltv.view.adView.AdvertImageView r1 = (com.mobile.brasiltv.view.adView.AdvertImageView) r1
            java.lang.String r1 = r1.getAdType()
            java.lang.String r2 = ""
            if (r1 != 0) goto L_0x005d
            r1 = r2
        L_0x005d:
            if (r4 == 0) goto L_0x0067
            java.lang.String r4 = r4.getAd_id()
            if (r4 != 0) goto L_0x0066
            goto L_0x0067
        L_0x0066:
            r2 = r4
        L_0x0067:
            r5.d0(r0, r1, r2)
            goto L_0x0083
        L_0x006b:
            com.mobile.brasiltv.view.adView.AdaptiveAdContainer r4 = r3.this$0
            int r5 = com.mobile.brasiltv.R$id.mTvFlag
            android.view.View r4 = r4._$_findCachedViewById(r5)
            android.widget.TextView r4 = (android.widget.TextView) r4
            r4.setVisibility(r0)
            com.mobile.brasiltv.view.adView.AdaptiveAdContainer r4 = r3.this$0
            com.mobile.brasiltv.view.adView.AdaptiveAdView$AdaptiveAdCallback r4 = r4.mListener
            if (r4 == 0) goto L_0x0083
            r4.onAdFailedToLoad()
        L_0x0083:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mobile.brasiltv.view.adView.AdaptiveAdContainer$showOwnAdView$1.invoke(com.advertlib.bean.AdInfo, boolean):void");
    }
}
