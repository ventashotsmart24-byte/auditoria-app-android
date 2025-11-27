package com.google.android.gms.cast.framework.media;

import com.google.android.gms.cast.MediaMetadata;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

final class zzj extends zzc {
    final /* synthetic */ ImagePicker zza;

    public /* synthetic */ zzj(ImagePicker imagePicker, zzi zzi) {
        this.zza = imagePicker;
    }

    public final WebImage zze(MediaMetadata mediaMetadata, int i10) {
        return this.zza.onPickImage(mediaMetadata, i10);
    }

    public final WebImage zzf(MediaMetadata mediaMetadata, ImageHints imageHints) {
        return this.zza.onPickImage(mediaMetadata, imageHints);
    }

    public final IObjectWrapper zzg() {
        return ObjectWrapper.wrap(this.zza);
    }
}
