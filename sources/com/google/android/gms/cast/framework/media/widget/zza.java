package com.google.android.gms.cast.framework.media.widget;

public final /* synthetic */ class zza implements Runnable {
    public final /* synthetic */ CastSeekBar zza;

    public /* synthetic */ zza(CastSeekBar castSeekBar) {
        this.zza = castSeekBar;
    }

    public final void run() {
        this.zza.sendAccessibilityEvent(4);
    }
}
