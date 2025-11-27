package com.google.android.gms.cast.framework.media;

import android.content.DialogInterface;

final class zzbs implements DialogInterface.OnClickListener {
    final /* synthetic */ zzbv zza;
    final /* synthetic */ zzbv zzb;
    final /* synthetic */ TracksChooserDialogFragment zzc;

    public zzbs(TracksChooserDialogFragment tracksChooserDialogFragment, zzbv zzbv, zzbv zzbv2) {
        this.zzc = tracksChooserDialogFragment;
        this.zza = zzbv;
        this.zzb = zzbv2;
    }

    public final void onClick(DialogInterface dialogInterface, int i10) {
        TracksChooserDialogFragment.zzc(this.zzc, this.zza, this.zzb);
    }
}
