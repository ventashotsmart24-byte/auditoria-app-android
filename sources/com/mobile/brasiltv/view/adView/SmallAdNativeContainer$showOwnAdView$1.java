package com.mobile.brasiltv.view.adView;

import com.advertlib.bean.AdInfo;
import h9.t;
import s9.p;
import t9.j;

public final class SmallAdNativeContainer$showOwnAdView$1 extends j implements p {
    final /* synthetic */ SmallAdNativeContainer this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SmallAdNativeContainer$showOwnAdView$1(SmallAdNativeContainer smallAdNativeContainer) {
        super(2);
        this.this$0 = smallAdNativeContainer;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((AdInfo) obj, ((Boolean) obj2).booleanValue());
        return t.f17319a;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0049, code lost:
        if (r7.isShowFlag() == true) goto L_0x004d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke(com.advertlib.bean.AdInfo r7, boolean r8) {
        /*
            r6 = this;
            r0 = 8
            if (r8 == 0) goto L_0x006b
            com.mobile.brasiltv.view.adView.SmallAdNativeContainer r8 = r6.this$0
            r1 = 0
            r8.reportEvent(r1)
            s1.m r8 = s1.m.f9270a
            com.mobile.brasiltv.view.adView.SmallAdNativeContainer r2 = r6.this$0
            android.content.Context r2 = r2.getContext()
            java.lang.String r3 = "context"
            t9.i.f(r2, r3)
            com.mobile.brasiltv.view.adView.SmallAdNativeContainer r3 = r6.this$0
            int r4 = com.mobile.brasiltv.R$id.mIvAd
            android.view.View r3 = r3._$_findCachedViewById(r4)
            com.mobile.brasiltv.view.adView.AdvertImageView r3 = (com.mobile.brasiltv.view.adView.AdvertImageView) r3
            java.lang.String r3 = r3.getAdType()
            java.lang.String r4 = ""
            if (r3 != 0) goto L_0x002a
            r3 = r4
        L_0x002a:
            if (r7 == 0) goto L_0x0034
            java.lang.String r5 = r7.getAd_id()
            if (r5 != 0) goto L_0x0033
            goto L_0x0034
        L_0x0033:
            r4 = r5
        L_0x0034:
            r8.d0(r2, r3, r4)
            com.mobile.brasiltv.view.adView.SmallAdNativeContainer r8 = r6.this$0
            com.mobile.brasiltv.view.adView.SmallAdNativeView$NativeAdCallback r8 = r8.mCallback
            if (r8 == 0) goto L_0x0042
            r8.onAttachNativeAd()
        L_0x0042:
            if (r7 == 0) goto L_0x004c
            boolean r7 = r7.isShowFlag()
            r8 = 1
            if (r7 != r8) goto L_0x004c
            goto L_0x004d
        L_0x004c:
            r8 = 0
        L_0x004d:
            if (r8 == 0) goto L_0x005d
            com.mobile.brasiltv.view.adView.SmallAdNativeContainer r7 = r6.this$0
            int r8 = com.mobile.brasiltv.R$id.mTvFlag
            android.view.View r7 = r7._$_findCachedViewById(r8)
            android.widget.TextView r7 = (android.widget.TextView) r7
            r7.setVisibility(r1)
            goto L_0x0078
        L_0x005d:
            com.mobile.brasiltv.view.adView.SmallAdNativeContainer r7 = r6.this$0
            int r8 = com.mobile.brasiltv.R$id.mTvFlag
            android.view.View r7 = r7._$_findCachedViewById(r8)
            android.widget.TextView r7 = (android.widget.TextView) r7
            r7.setVisibility(r0)
            goto L_0x0078
        L_0x006b:
            com.mobile.brasiltv.view.adView.SmallAdNativeContainer r7 = r6.this$0
            int r8 = com.mobile.brasiltv.R$id.mTvFlag
            android.view.View r7 = r7._$_findCachedViewById(r8)
            android.widget.TextView r7 = (android.widget.TextView) r7
            r7.setVisibility(r0)
        L_0x0078:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mobile.brasiltv.view.adView.SmallAdNativeContainer$showOwnAdView$1.invoke(com.advertlib.bean.AdInfo, boolean):void");
    }
}
