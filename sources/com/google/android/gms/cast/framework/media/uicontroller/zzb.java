package com.google.android.gms.cast.framework.media.uicontroller;

import android.view.View;
import android.widget.ImageView;

final class zzb implements View.OnClickListener {
    final /* synthetic */ UIMediaController zza;

    public zzb(UIMediaController uIMediaController) {
        this.zza = uIMediaController;
    }

    public final void onClick(View view) {
        this.zza.onMuteToggleClicked((ImageView) view);
    }
}
