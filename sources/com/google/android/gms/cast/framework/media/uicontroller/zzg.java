package com.google.android.gms.cast.framework.media.uicontroller;

import android.view.View;

final class zzg implements View.OnClickListener {
    final /* synthetic */ long zza;
    final /* synthetic */ UIMediaController zzb;

    public zzg(UIMediaController uIMediaController, long j10) {
        this.zzb = uIMediaController;
        this.zza = j10;
    }

    public final void onClick(View view) {
        this.zzb.onRewindClicked(view, this.zza);
    }
}
