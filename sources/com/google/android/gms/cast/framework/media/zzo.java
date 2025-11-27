package com.google.android.gms.cast.framework.media;

import android.graphics.Bitmap;
import android.net.Uri;
import com.google.android.gms.common.images.WebImage;

final class zzo {
    public final Uri zza;
    public Bitmap zzb;

    public zzo(WebImage webImage) {
        Uri uri;
        if (webImage == null) {
            uri = null;
        } else {
            uri = webImage.getUrl();
        }
        this.zza = uri;
    }
}
