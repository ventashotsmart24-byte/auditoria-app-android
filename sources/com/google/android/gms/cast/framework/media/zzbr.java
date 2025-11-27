package com.google.android.gms.cast.framework.media;

import android.content.DialogInterface;

final class zzbr implements DialogInterface.OnClickListener {
    final /* synthetic */ TracksChooserDialogFragment zza;

    public zzbr(TracksChooserDialogFragment tracksChooserDialogFragment) {
        this.zza = tracksChooserDialogFragment;
    }

    public final void onClick(DialogInterface dialogInterface, int i10) {
        if (this.zza.zze != null) {
            this.zza.zze.cancel();
            this.zza.zze = null;
        }
    }
}
