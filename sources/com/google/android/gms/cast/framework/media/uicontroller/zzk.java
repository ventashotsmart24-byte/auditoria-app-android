package com.google.android.gms.cast.framework.media.uicontroller;

import android.view.View;

final class zzk implements View.OnClickListener {
    final /* synthetic */ UIMediaController zza;

    public zzk(UIMediaController uIMediaController) {
        this.zza = uIMediaController;
    }

    public final void onClick(View view) {
        this.zza.onClosedCaptionClicked(view);
    }
}
