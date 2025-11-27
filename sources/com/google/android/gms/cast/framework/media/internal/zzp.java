package com.google.android.gms.cast.framework.media.internal;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.cast.MediaInfo;
import com.google.android.gms.cast.MediaMetadata;
import com.google.android.gms.cast.MediaQueueItem;
import com.google.android.gms.cast.MediaStatus;
import com.google.android.gms.cast.framework.CastOptions;
import com.google.android.gms.cast.framework.R;
import com.google.android.gms.cast.framework.ReconnectionService;
import com.google.android.gms.cast.framework.media.MediaNotificationService;
import com.google.android.gms.cast.framework.media.RemoteMediaClient;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.internal.cast.zzaj;
import com.google.android.gms.internal.cast.zzcn;
import com.google.android.gms.internal.cast.zzco;

public final class zzp implements RemoteMediaClient.Listener {
    private static final Logger zza = new Logger("MediaSessionManager");
    private final Context zzb;
    private final CastOptions zzc;
    private final zzaj zzd;
    private final ComponentName zze;
    private final zzb zzf;
    private final zzb zzg;
    private final Handler zzh;
    private final Runnable zzi;
    /* access modifiers changed from: private */
    public RemoteMediaClient zzj;
    private CastDevice zzk;
    private MediaSessionCompat zzl;
    private MediaSessionCompat.b zzm;
    private boolean zzn;

    public zzp(Context context, CastOptions castOptions, zzaj zzaj) {
        this.zzb = context;
        this.zzc = castOptions;
        this.zzd = zzaj;
        if (castOptions.getCastMediaOptions() == null || TextUtils.isEmpty(castOptions.getCastMediaOptions().getExpandedControllerActivityClassName())) {
            this.zze = null;
        } else {
            this.zze = new ComponentName(context, castOptions.getCastMediaOptions().getExpandedControllerActivityClassName());
        }
        zzb zzb2 = new zzb(context);
        this.zzf = zzb2;
        zzb2.zzc(new zzm(this));
        zzb zzb3 = new zzb(context);
        this.zzg = zzb3;
        zzb3.zzc(new zzn(this));
        this.zzh = new zzco(Looper.getMainLooper());
        this.zzi = new zzl(this);
    }

    public static Bitmap zza(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float f10 = (float) width;
        int i10 = (int) (((9.0f * f10) / 16.0f) + 0.5f);
        float f11 = (float) ((i10 - height) / 2);
        RectF rectF = new RectF(0.0f, f11, f10, ((float) height) + f11);
        Bitmap.Config config = bitmap.getConfig();
        if (config == null) {
            config = Bitmap.Config.ARGB_8888;
        }
        Bitmap createBitmap = Bitmap.createBitmap(width, i10, config);
        new Canvas(createBitmap).drawBitmap(bitmap, (Rect) null, rectF, (Paint) null);
        return createBitmap;
    }

    private final Uri zzh(MediaMetadata mediaMetadata, int i10) {
        WebImage webImage;
        if (this.zzc.getCastMediaOptions().getImagePicker() != null) {
            webImage = this.zzc.getCastMediaOptions().getImagePicker().onPickImage(mediaMetadata, i10);
        } else if (mediaMetadata.hasImages()) {
            webImage = mediaMetadata.getImages().get(0);
        } else {
            webImage = null;
        }
        if (webImage == null) {
            return null;
        }
        return webImage.getUrl();
    }

    private final MediaMetadataCompat.b zzi() {
        MediaMetadataCompat mediaMetadataCompat;
        MediaSessionCompat mediaSessionCompat = this.zzl;
        if (mediaSessionCompat == null) {
            mediaMetadataCompat = null;
        } else {
            mediaMetadataCompat = mediaSessionCompat.d().a();
        }
        if (mediaMetadataCompat == null) {
            return new MediaMetadataCompat.b();
        }
        return new MediaMetadataCompat.b(mediaMetadataCompat);
    }

    /* access modifiers changed from: private */
    public final void zzj(Bitmap bitmap, int i10) {
        MediaSessionCompat mediaSessionCompat = this.zzl;
        if (mediaSessionCompat != null) {
            if (i10 == 0) {
                if (bitmap != null) {
                    mediaSessionCompat.n(zzi().b("android.media.metadata.DISPLAY_ICON", bitmap).a());
                    return;
                }
                Bitmap createBitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
                createBitmap.eraseColor(0);
                this.zzl.n(zzi().b("android.media.metadata.DISPLAY_ICON", createBitmap).a());
            } else if (i10 == 3) {
                mediaSessionCompat.n(zzi().b("android.media.metadata.ALBUM_ART", bitmap).a());
            }
        }
    }

    private final void zzk(boolean z10) {
        if (this.zzc.getEnableReconnectionService()) {
            this.zzh.removeCallbacks(this.zzi);
            Intent intent = new Intent(this.zzb, ReconnectionService.class);
            intent.setPackage(this.zzb.getPackageName());
            try {
                this.zzb.startService(intent);
            } catch (IllegalStateException unused) {
                if (z10) {
                    this.zzh.postDelayed(this.zzi, 1000);
                }
            }
        }
    }

    private final void zzl() {
        if (this.zzc.getCastMediaOptions().getNotificationOptions() != null) {
            zza.d("Stopping notification service.", new Object[0]);
            if (Build.VERSION.SDK_INT >= 26) {
                MediaNotificationService.zze();
                return;
            }
            Intent intent = new Intent(this.zzb, MediaNotificationService.class);
            intent.setPackage(this.zzb.getPackageName());
            intent.setAction(MediaNotificationService.ACTION_UPDATE_NOTIFICATION);
            this.zzb.stopService(intent);
        }
    }

    private final void zzm() {
        if (this.zzc.getEnableReconnectionService()) {
            this.zzh.removeCallbacks(this.zzi);
            Intent intent = new Intent(this.zzb, ReconnectionService.class);
            intent.setPackage(this.zzb.getPackageName());
            this.zzb.stopService(intent);
        }
    }

    private final void zzn(int i10, MediaInfo mediaInfo) {
        long j10;
        long j11;
        PendingIntent pendingIntent;
        MediaSessionCompat mediaSessionCompat = this.zzl;
        if (mediaSessionCompat != null) {
            long j12 = 0;
            if (i10 == 0) {
                mediaSessionCompat.o(new PlaybackStateCompat.b().c(0, 0, 1.0f).a());
                this.zzl.n(new MediaMetadataCompat.b().a());
                return;
            }
            if (true != this.zzj.isLiveStream()) {
                j10 = 768;
            } else {
                j10 = 512;
            }
            if (this.zzj.isLiveStream()) {
                j11 = 0;
            } else {
                j11 = this.zzj.getApproximateStreamPosition();
            }
            this.zzl.o(new PlaybackStateCompat.b().c(i10, j11, 1.0f).b(j10).a());
            MediaSessionCompat mediaSessionCompat2 = this.zzl;
            if (this.zze == null) {
                pendingIntent = null;
            } else {
                Intent intent = new Intent();
                intent.setComponent(this.zze);
                pendingIntent = zzcn.zza(this.zzb, 0, intent, zzcn.zza | 134217728);
            }
            mediaSessionCompat2.r(pendingIntent);
            if (this.zzl != null) {
                MediaMetadata metadata = mediaInfo.getMetadata();
                if (!this.zzj.isLiveStream()) {
                    j12 = mediaInfo.getStreamDuration();
                }
                this.zzl.n(zzi().d("android.media.metadata.TITLE", metadata.getString(MediaMetadata.KEY_TITLE)).d("android.media.metadata.DISPLAY_TITLE", metadata.getString(MediaMetadata.KEY_TITLE)).d("android.media.metadata.DISPLAY_SUBTITLE", metadata.getString(MediaMetadata.KEY_SUBTITLE)).c("android.media.metadata.DURATION", j12).a());
                Uri zzh2 = zzh(metadata, 0);
                if (zzh2 != null) {
                    this.zzf.zzd(zzh2);
                } else {
                    zzj((Bitmap) null, 0);
                }
                Uri zzh3 = zzh(metadata, 3);
                if (zzh3 != null) {
                    this.zzg.zzd(zzh3);
                } else {
                    zzj((Bitmap) null, 3);
                }
            }
        }
    }

    public final void onAdBreakStatusUpdated() {
        zzg(false);
    }

    public final void onMetadataUpdated() {
        zzg(false);
    }

    public final void onPreloadStatusUpdated() {
        zzg(false);
    }

    public final void onQueueStatusUpdated() {
        zzg(false);
    }

    public final void onSendingRemoteMediaRequest() {
    }

    public final void onStatusUpdated() {
        zzg(false);
    }

    public final void zzd(RemoteMediaClient remoteMediaClient, CastDevice castDevice) {
        CastOptions castOptions;
        if (!this.zzn && (castOptions = this.zzc) != null && castOptions.getCastMediaOptions() != null && remoteMediaClient != null && castDevice != null) {
            this.zzj = remoteMediaClient;
            remoteMediaClient.addListener(this);
            this.zzk = castDevice;
            if (!PlatformVersion.isAtLeastLollipop()) {
                ((AudioManager) this.zzb.getSystemService("audio")).requestAudioFocus((AudioManager.OnAudioFocusChangeListener) null, 3, 3);
            }
            ComponentName componentName = new ComponentName(this.zzb, this.zzc.getCastMediaOptions().getMediaIntentReceiverClassName());
            Intent intent = new Intent("android.intent.action.MEDIA_BUTTON");
            intent.setComponent(componentName);
            PendingIntent zzb2 = zzcn.zzb(this.zzb, 0, intent, zzcn.zza);
            if (this.zzc.getCastMediaOptions().getMediaSessionEnabled()) {
                this.zzl = new MediaSessionCompat(this.zzb, "CastMediaSession", componentName, zzb2);
                zzn(0, (MediaInfo) null);
                CastDevice castDevice2 = this.zzk;
                if (castDevice2 != null && !TextUtils.isEmpty(castDevice2.getFriendlyName())) {
                    this.zzl.n(new MediaMetadataCompat.b().d("android.media.metadata.ALBUM_ARTIST", this.zzb.getResources().getString(R.string.cast_casting_to_device, new Object[]{this.zzk.getFriendlyName()})).a());
                }
                zzo zzo = new zzo(this);
                this.zzm = zzo;
                this.zzl.l(zzo);
                this.zzl.k(true);
                this.zzd.zzq(this.zzl);
            }
            this.zzn = true;
            zzg(false);
        }
    }

    public final void zze(int i10) {
        if (this.zzn) {
            this.zzn = false;
            RemoteMediaClient remoteMediaClient = this.zzj;
            if (remoteMediaClient != null) {
                remoteMediaClient.removeListener(this);
            }
            if (!PlatformVersion.isAtLeastLollipop()) {
                ((AudioManager) this.zzb.getSystemService("audio")).abandonAudioFocus((AudioManager.OnAudioFocusChangeListener) null);
            }
            this.zzd.zzq((MediaSessionCompat) null);
            this.zzf.zza();
            zzb zzb2 = this.zzg;
            if (zzb2 != null) {
                zzb2.zza();
            }
            MediaSessionCompat mediaSessionCompat = this.zzl;
            if (mediaSessionCompat != null) {
                mediaSessionCompat.r((PendingIntent) null);
                this.zzl.l((MediaSessionCompat.b) null);
                this.zzl.n(new MediaMetadataCompat.b().a());
                zzn(0, (MediaInfo) null);
                this.zzl.k(false);
                this.zzl.i();
                this.zzl = null;
            }
            this.zzj = null;
            this.zzk = null;
            this.zzm = null;
            zzl();
            if (i10 == 0) {
                zzm();
            }
        }
    }

    public final /* synthetic */ void zzf() {
        zzk(false);
    }

    public final void zzg(boolean z10) {
        boolean z11;
        boolean z12;
        MediaQueueItem loadingItem;
        RemoteMediaClient remoteMediaClient = this.zzj;
        if (remoteMediaClient != null) {
            MediaInfo mediaInfo = remoteMediaClient.getMediaInfo();
            int i10 = 6;
            if (!this.zzj.isBuffering()) {
                if (this.zzj.isPlaying()) {
                    i10 = 3;
                } else if (this.zzj.isPaused()) {
                    i10 = 2;
                } else if (!this.zzj.isLoadingNextItem() || (loadingItem = this.zzj.getLoadingItem()) == null || loadingItem.getMedia() == null) {
                    i10 = 0;
                } else {
                    mediaInfo = loadingItem.getMedia();
                }
            }
            if (mediaInfo == null || mediaInfo.getMetadata() == null) {
                i10 = 0;
            }
            zzn(i10, mediaInfo);
            if (!this.zzj.hasMediaSession()) {
                zzl();
                zzm();
            } else if (i10 != 0) {
                if (this.zzk != null && MediaNotificationService.isNotificationOptionsValid(this.zzc)) {
                    Intent intent = new Intent(this.zzb, MediaNotificationService.class);
                    intent.putExtra("extra_media_notification_force_update", z10);
                    intent.setPackage(this.zzb.getPackageName());
                    intent.setAction(MediaNotificationService.ACTION_UPDATE_NOTIFICATION);
                    intent.putExtra("extra_media_info", this.zzj.getMediaInfo());
                    intent.putExtra("extra_remote_media_client_player_state", this.zzj.getPlayerState());
                    intent.putExtra("extra_cast_device", this.zzk);
                    MediaSessionCompat mediaSessionCompat = this.zzl;
                    if (mediaSessionCompat != null) {
                        intent.putExtra("extra_media_session_token", mediaSessionCompat.f());
                    }
                    MediaStatus mediaStatus = this.zzj.getMediaStatus();
                    int queueRepeatMode = mediaStatus.getQueueRepeatMode();
                    if (queueRepeatMode == 1 || queueRepeatMode == 2 || queueRepeatMode == 3) {
                        z11 = true;
                        z12 = true;
                    } else {
                        Integer indexById = mediaStatus.getIndexById(mediaStatus.getCurrentItemId());
                        if (indexById != null) {
                            if (indexById.intValue() > 0) {
                                z12 = true;
                            } else {
                                z12 = false;
                            }
                            if (indexById.intValue() < mediaStatus.getQueueItemCount() - 1) {
                                z11 = true;
                            } else {
                                z11 = false;
                            }
                        } else {
                            z11 = false;
                            z12 = false;
                        }
                    }
                    intent.putExtra("extra_can_skip_next", z11);
                    intent.putExtra("extra_can_skip_prev", z12);
                    zza.d("Starting notification service.", new Object[0]);
                    if (Build.VERSION.SDK_INT >= 26) {
                        ComponentName unused = this.zzb.startForegroundService(intent);
                    } else {
                        this.zzb.startService(intent);
                    }
                }
                if (!this.zzj.isLoadingNextItem()) {
                    zzk(true);
                }
            }
        }
    }
}
