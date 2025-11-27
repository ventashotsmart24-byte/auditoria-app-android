package com.mobile.brasiltv.view.adView;

import com.mobile.brasiltv.utils.b0;
import h9.t;
import s9.l;
import t9.j;

public final class PlayingAdView$innerScheduleLoadPlayingAd$2 extends j implements l {
    final /* synthetic */ PlayingAdView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PlayingAdView$innerScheduleLoadPlayingAd$2(PlayingAdView playingAdView) {
        super(1);
        this.this$0 = playingAdView;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return t.f17319a;
    }

    public final void invoke(Throwable th) {
        th.printStackTrace();
        b0.U(this.this$0, "schedule load playing ad failure.");
    }
}
