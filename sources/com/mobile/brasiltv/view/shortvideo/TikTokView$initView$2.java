package com.mobile.brasiltv.view.shortvideo;

import android.widget.TextView;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.view.shortvideo.ShortVideoSeekBar;

public final class TikTokView$initView$2 implements ShortVideoSeekBar.OnSeekListener {
    final /* synthetic */ TikTokView this$0;

    public TikTokView$initView$2(TikTokView tikTokView) {
        this.this$0 = tikTokView;
    }

    public void onSeekReset() {
        ((TextView) this.this$0._$_findCachedViewById(R$id.mTvTitle)).setVisibility(0);
        ((TextView) this.this$0._$_findCachedViewById(R$id.mTvAuthor)).setVisibility(0);
    }

    public void onSeekStart() {
        this.this$0.isSeeking = true;
        ((TextView) this.this$0._$_findCachedViewById(R$id.mTvTitle)).setVisibility(8);
        ((TextView) this.this$0._$_findCachedViewById(R$id.mTvAuthor)).setVisibility(8);
    }

    public void onSeekStop(int i10) {
        this.this$0.isSeeking = false;
    }

    public void onSeeking(int i10) {
    }
}
