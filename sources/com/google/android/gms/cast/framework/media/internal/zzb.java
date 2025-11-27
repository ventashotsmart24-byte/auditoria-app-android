package com.google.android.gms.cast.framework.media.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import com.google.android.gms.cast.framework.media.ImageHints;
import com.google.android.gms.common.internal.Preconditions;

public final class zzb {
    private final Context zza;
    private final ImageHints zzb;
    private Uri zzc;
    private zzf zzd;
    private zzc zze;
    private Bitmap zzf;
    private boolean zzg;
    private zza zzh;

    public zzb(Context context) {
        this(context, new ImageHints(-1, 0, 0));
    }

    private final void zze() {
        zzf zzf2 = this.zzd;
        if (zzf2 != null) {
            zzf2.cancel(true);
            this.zzd = null;
        }
        this.zzc = null;
        this.zzf = null;
        this.zzg = false;
    }

    public final void zza() {
        zze();
        this.zzh = null;
    }

    public final void zzb(Bitmap bitmap) {
        this.zzf = bitmap;
        this.zzg = true;
        zza zza2 = this.zzh;
        if (zza2 != null) {
            zza2.zza(bitmap);
        }
        this.zzd = null;
    }

    public final void zzc(zza zza2) {
        this.zzh = zza2;
    }

    public final boolean zzd(Uri uri) {
        Uri uri2 = uri;
        if (uri2 == null) {
            zze();
            return true;
        } else if (!uri2.equals(this.zzc)) {
            zze();
            this.zzc = uri2;
            if (this.zzb.getWidthInPixels() == 0 || this.zzb.getHeightInPixels() == 0) {
                this.zzd = new zzf(this.zza, 0, 0, false, 2097152, 5, 333, 10000, this, (byte[]) null);
            } else {
                this.zzd = new zzf(this.zza, this.zzb.getWidthInPixels(), this.zzb.getHeightInPixels(), false, 2097152, 5, 333, 10000, this, (byte[]) null);
            }
            ((zzf) Preconditions.checkNotNull(this.zzd)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Uri[]{(Uri) Preconditions.checkNotNull(this.zzc)});
            return false;
        } else if (this.zzg) {
            return true;
        } else {
            return false;
        }
    }

    public zzb(Context context, ImageHints imageHints) {
        this.zza = context;
        this.zzb = imageHints;
        this.zze = new zzc();
        zze();
    }
}
