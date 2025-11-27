package com.google.android.gms.cast.framework.media;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.cast.MediaMetadata;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.cast.zza;

public final class zzb extends zza implements zzd {
    public zzb(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.cast.framework.media.IImagePicker");
    }

    public final WebImage zze(MediaMetadata mediaMetadata, int i10) {
        throw null;
    }

    public final WebImage zzf(MediaMetadata mediaMetadata, ImageHints imageHints) {
        throw null;
    }

    public final IObjectWrapper zzg() {
        Parcel zzb = zzb(2, zza());
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zzb.readStrongBinder());
        zzb.recycle();
        return asInterface;
    }
}
