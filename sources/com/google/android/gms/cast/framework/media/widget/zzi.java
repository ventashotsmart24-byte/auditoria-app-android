package com.google.android.gms.cast.framework.media.widget;

import android.view.View;
import com.google.android.gms.cast.framework.media.RemoteMediaClient;

final class zzi implements View.OnClickListener {
    final /* synthetic */ ExpandedControllerActivity zza;

    public zzi(ExpandedControllerActivity expandedControllerActivity) {
        this.zza = expandedControllerActivity;
    }

    public final void onClick(View view) {
        RemoteMediaClient zze;
        if (this.zza.zzG.isClickable() && (zze = this.zza.zzl()) != null) {
            zze.skipAd();
        }
    }
}
