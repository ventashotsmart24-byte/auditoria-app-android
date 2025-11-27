package com.mobile.brasiltv.view.adView;

import android.media.MediaPlayer;

public final /* synthetic */ class j implements MediaPlayer.OnErrorListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BeforeVodAdView f12695a;

    public /* synthetic */ j(BeforeVodAdView beforeVodAdView) {
        this.f12695a = beforeVodAdView;
    }

    public final boolean onError(MediaPlayer mediaPlayer, int i10, int i11) {
        return BeforeVodAdView.playVideo$lambda$6(this.f12695a, mediaPlayer, i10, i11);
    }
}
