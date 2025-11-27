package com.mobile.brasiltv.view.adView;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.advertlib.bean.AdInfo;
import com.mobile.brasiltv.R$id;
import com.umeng.analytics.pro.f;
import d6.b;
import h9.t;
import s1.m;
import s1.q;
import s9.l;
import t9.i;
import t9.j;

public final class PauseAdView$loadSelfAdOnAdmob$1 extends j implements l {
    final /* synthetic */ AdInfo $adInfo;
    final /* synthetic */ String $adtype;
    final /* synthetic */ PauseAdView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PauseAdView$loadSelfAdOnAdmob$1(PauseAdView pauseAdView, AdInfo adInfo, String str) {
        super(1);
        this.this$0 = pauseAdView;
        this.$adInfo = adInfo;
        this.$adtype = str;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Boolean) obj).booleanValue());
        return t.f17319a;
    }

    public final void invoke(boolean z10) {
        if (z10) {
            ((FrameLayout) this.this$0._$_findCachedViewById(R$id.mFlAdmob)).setVisibility(0);
            ((ImageView) this.this$0._$_findCachedViewById(R$id.mIvOwnerAd2)).setVisibility(0);
            this.this$0.adjustSelfAdOnAdmob();
            if (!this.$adInfo.isShowFlag()) {
                ((TextView) this.this$0._$_findCachedViewById(R$id.mTvLandFlag)).setVisibility(8);
                ((TextView) this.this$0._$_findCachedViewById(R$id.mTvPortFlag)).setVisibility(8);
            } else if (this.this$0.getResources().getConfiguration().orientation == 1) {
                ((TextView) this.this$0._$_findCachedViewById(R$id.mTvPortFlag)).setVisibility(0);
                ((TextView) this.this$0._$_findCachedViewById(R$id.mTvLandFlag)).setVisibility(8);
            } else {
                ((TextView) this.this$0._$_findCachedViewById(R$id.mTvPortFlag)).setVisibility(8);
                ((TextView) this.this$0._$_findCachedViewById(R$id.mTvLandFlag)).setVisibility(0);
            }
            q qVar = q.f9311a;
            Context context = this.this$0.getContext();
            i.f(context, f.X);
            b bVar = b.f6366a;
            Context context2 = this.this$0.getContext();
            i.f(context2, f.X);
            qVar.j(context, bVar.m(context2), this.$adtype, this.$adInfo);
            m mVar = m.f9270a;
            Context context3 = this.this$0.getContext();
            i.f(context3, f.X);
            mVar.d0(context3, this.$adtype, this.$adInfo.getAd_id());
            return;
        }
        ((TextView) this.this$0._$_findCachedViewById(R$id.mTvLandFlag)).setVisibility(8);
        ((TextView) this.this$0._$_findCachedViewById(R$id.mTvPortFlag)).setVisibility(8);
    }
}
