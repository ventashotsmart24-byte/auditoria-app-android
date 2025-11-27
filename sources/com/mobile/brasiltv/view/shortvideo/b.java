package com.mobile.brasiltv.view.shortvideo;

import android.widget.SeekBar;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ShortVideoSeekBar f12852a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SeekBar f12853b;

    public /* synthetic */ b(ShortVideoSeekBar shortVideoSeekBar, SeekBar seekBar) {
        this.f12852a = shortVideoSeekBar;
        this.f12853b = seekBar;
    }

    public final void run() {
        ShortVideoSeekBar$initListener$1.onStopTrackingTouch$lambda$0(this.f12852a, this.f12853b);
    }
}
