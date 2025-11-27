package com.google.android.gms.cast.framework.media.uicontroller;

import android.view.View;

final class zzj implements View.OnClickListener {
    final /* synthetic */ UIMediaController zza;

    public zzj(UIMediaController uIMediaController) {
        this.zza = uIMediaController;
    }

    public final void onClick(View view) {
        this.zza.onLaunchExpandedControllerClicked(view);
    }
}
