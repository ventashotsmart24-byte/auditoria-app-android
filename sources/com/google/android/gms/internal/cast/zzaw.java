package com.google.android.gms.internal.cast;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;
import com.google.android.gms.cast.framework.CastContext;
import com.google.android.gms.cast.framework.CastSession;
import com.google.android.gms.cast.framework.media.CastMediaOptions;
import com.google.android.gms.cast.framework.media.ImageHints;
import com.google.android.gms.cast.framework.media.ImagePicker;
import com.google.android.gms.cast.framework.media.internal.zzb;
import com.google.android.gms.cast.framework.media.uicontroller.UIController;

public final class zzaw extends UIController {
    /* access modifiers changed from: private */
    public final ImageView zza;
    private final ImageHints zzb;
    private final Bitmap zzc;
    private final ImagePicker zzd;
    private final zzb zze;

    public zzaw(ImageView imageView, Context context, ImageHints imageHints, int i10) {
        this.zza = imageView;
        this.zzb = imageHints;
        this.zzc = BitmapFactory.decodeResource(context.getResources(), i10);
        CastContext zza2 = CastContext.zza(context);
        ImagePicker imagePicker = null;
        if (zza2 != null) {
            CastMediaOptions castMediaOptions = zza2.getCastOptions().getCastMediaOptions();
            this.zzd = castMediaOptions != null ? castMediaOptions.getImagePicker() : imagePicker;
        } else {
            this.zzd = null;
        }
        this.zze = new zzb(context.getApplicationContext());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0020, code lost:
        r1 = r1.onPickImage(r0.getMetadata(), r4.zzb);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzb() {
        /*
            r4 = this;
            com.google.android.gms.cast.framework.media.RemoteMediaClient r0 = r4.getRemoteMediaClient()
            if (r0 == 0) goto L_0x004c
            boolean r1 = r0.hasMediaSession()
            if (r1 != 0) goto L_0x000d
            goto L_0x004c
        L_0x000d:
            com.google.android.gms.cast.MediaQueueItem r0 = r0.getPreloadedItem()
            r1 = 0
            if (r0 != 0) goto L_0x0015
            goto L_0x003c
        L_0x0015:
            com.google.android.gms.cast.MediaInfo r0 = r0.getMedia()
            if (r0 != 0) goto L_0x001c
            goto L_0x003c
        L_0x001c:
            com.google.android.gms.cast.framework.media.ImagePicker r1 = r4.zzd
            if (r1 == 0) goto L_0x0037
            com.google.android.gms.cast.MediaMetadata r2 = r0.getMetadata()
            com.google.android.gms.cast.framework.media.ImageHints r3 = r4.zzb
            com.google.android.gms.common.images.WebImage r1 = r1.onPickImage((com.google.android.gms.cast.MediaMetadata) r2, (com.google.android.gms.cast.framework.media.ImageHints) r3)
            if (r1 == 0) goto L_0x0037
            android.net.Uri r2 = r1.getUrl()
            if (r2 == 0) goto L_0x0037
            android.net.Uri r1 = r1.getUrl()
            goto L_0x003c
        L_0x0037:
            r1 = 0
            android.net.Uri r1 = com.google.android.gms.cast.framework.media.MediaUtils.getImageUri(r0, r1)
        L_0x003c:
            if (r1 != 0) goto L_0x0046
            android.widget.ImageView r0 = r4.zza
            android.graphics.Bitmap r1 = r4.zzc
            r0.setImageBitmap(r1)
            return
        L_0x0046:
            com.google.android.gms.cast.framework.media.internal.zzb r0 = r4.zze
            r0.zzd(r1)
            return
        L_0x004c:
            android.widget.ImageView r0 = r4.zza
            android.graphics.Bitmap r1 = r4.zzc
            r0.setImageBitmap(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.cast.zzaw.zzb():void");
    }

    public final void onMediaStatusUpdated() {
        zzb();
    }

    public final void onSessionConnected(CastSession castSession) {
        super.onSessionConnected(castSession);
        this.zze.zzc(new zzav(this));
        this.zza.setImageBitmap(this.zzc);
        zzb();
    }

    public final void onSessionEnded() {
        this.zze.zza();
        this.zza.setImageBitmap(this.zzc);
        super.onSessionEnded();
    }
}
