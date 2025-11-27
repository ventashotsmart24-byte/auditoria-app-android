package com.google.android.gms.cast.framework.media.uicontroller;

import android.view.View;

final class zzd implements View.OnClickListener {
    final /* synthetic */ UIMediaController zza;

    public zzd(UIMediaController uIMediaController) {
        this.zza = uIMediaController;
    }

    public final void onClick(View view) {
        this.zza.onSkipNextClicked(view);
    }
}
