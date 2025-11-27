package com.mobile.brasiltv.view.adView;

import android.media.MediaPlayer;

public final /* synthetic */ class i implements MediaPlayer.OnPreparedListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BeforeVodAdView f12693a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MediaPlayer f12694b;

    public /* synthetic */ i(BeforeVodAdView beforeVodAdView, MediaPlayer mediaPlayer) {
        this.f12693a = beforeVodAdView;
        this.f12694b = mediaPlayer;
    }

    public final void onPrepared(MediaPlayer mediaPlayer) {
        BeforeVodAdView.playVideo$lambda$5(this.f12693a, this.f12694b, mediaPlayer);
    }
}
