package com.google.android.gms.cast.framework.media.uicontroller;

import android.view.View;

final class zze implements View.OnClickListener {
    final /* synthetic */ UIMediaController zza;

    public zze(UIMediaController uIMediaController) {
        this.zza = uIMediaController;
    }

    public final void onClick(View view) {
        this.zza.onSkipPrevClicked(view);
    }
}
