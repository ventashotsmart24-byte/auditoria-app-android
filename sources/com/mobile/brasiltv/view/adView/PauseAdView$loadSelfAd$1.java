package com.mobile.brasiltv.view.adView;

import a6.a;
import android.content.Context;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.advertlib.bean.AdInfo;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.utils.i1;
import com.umeng.analytics.pro.f;
import d6.b;
import h9.t;
import s1.m;
import s1.q;
import s9.l;
import t9.i;
import t9.j;

public final class PauseAdView$loadSelfAd$1 extends j implements l {
    final /* synthetic */ AdInfo $adInfo;
    final /* synthetic */ PauseAdView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PauseAdView$loadSelfAd$1(AdInfo adInfo, PauseAdView pauseAdView) {
        super(1);
        this.$adInfo = adInfo;
        this.this$0 = pauseAdView;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Boolean) obj).booleanValue());
        return t.f17319a;
    }

    public final void invoke(boolean z10) {
        if (z10) {
            if (this.$adInfo.isShowFlag()) {
                ((TextView) this.this$0._$_findCachedViewById(R$id.mTvOwnerFlag)).setVisibility(0);
            } else {
                ((TextView) this.this$0._$_findCachedViewById(R$id.mTvOwnerFlag)).setVisibility(8);
            }
            ((FrameLayout) this.this$0._$_findCachedViewById(R$id.mFlOwner)).setVisibility(0);
            i1.e(this.this$0.getContext(), "EVENT_AD_SHOW_PAUSE");
            PauseAdView pauseAdView = this.this$0;
            pauseAdView.reportDelayedSubp = i1.p(pauseAdView.getContext(), "EVENT_AD_LONG_SHOW_PAUSE");
            q qVar = q.f9311a;
            Context context = this.this$0.getContext();
            i.f(context, f.X);
            b bVar = b.f6366a;
            Context context2 = this.this$0.getContext();
            i.f(context2, f.X);
            String m10 = bVar.m(context2);
            a aVar = a.f10646a;
            qVar.j(context, m10, aVar.k(), this.$adInfo);
            m mVar = m.f9270a;
            Context context3 = this.this$0.getContext();
            i.f(context3, f.X);
            mVar.d0(context3, aVar.k(), this.$adInfo.getAd_id());
            return;
        }
        ((TextView) this.this$0._$_findCachedViewById(R$id.mTvOwnerFlag)).setVisibility(8);
    }
}
