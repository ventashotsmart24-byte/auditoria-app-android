package com.google.android.gms.cast.framework;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.cast.Cast;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.cast.framework.media.CastMediaOptions;
import com.google.android.gms.cast.framework.media.NotificationOptions;
import com.google.android.gms.cast.framework.media.RemoteMediaClient;
import com.google.android.gms.cast.framework.media.internal.zzp;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.cast.internal.zzap;
import com.google.android.gms.cast.zzau;
import com.google.android.gms.cast.zzax;
import com.google.android.gms.cast.zzaz;
import com.google.android.gms.cast.zzbp;
import com.google.android.gms.cast.zzr;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.PendingResults;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.cast.zzao;
import com.google.android.gms.internal.cast.zzar;
import com.google.android.gms.internal.cast.zzm;
import com.google.android.gms.tasks.Task;
import java.util.HashSet;
import java.util.Set;
import n0.p1;

public class CastSession extends Session {
    public static final /* synthetic */ int zza = 0;
    /* access modifiers changed from: private */
    public static final Logger zzb = new Logger("CastSession");
    private final Context zzc;
    /* access modifiers changed from: private */
    public final Set<Cast.Listener> zzd = new HashSet();
    /* access modifiers changed from: private */
    public final zzz zze;
    private final CastOptions zzf;
    private final zzp zzg;
    /* access modifiers changed from: private */
    public zzr zzh;
    /* access modifiers changed from: private */
    public RemoteMediaClient zzi;
    private CastDevice zzj;
    private Cast.ApplicationConnectionResult zzk;
    private zzar zzl;
    private final zzf zzm;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CastSession(Context context, String str, String str2, CastOptions castOptions, zzp zzp) {
        super(context, str, str2);
        zzf zzf2 = zzf.zza;
        this.zzc = context.getApplicationContext();
        this.zzf = castOptions;
        this.zzg = zzp;
        this.zzm = zzf2;
        this.zze = zzm.zzb(context, castOptions, zzl(), new zzl(this, (zzk) null));
    }

    public static /* bridge */ /* synthetic */ void zzg(CastSession castSession, int i10) {
        castSession.zzg.zze(i10);
        zzr zzr = castSession.zzh;
        if (zzr != null) {
            zzr.zzf();
            castSession.zzh = null;
        }
        castSession.zzj = null;
        RemoteMediaClient remoteMediaClient = castSession.zzi;
        if (remoteMediaClient != null) {
            remoteMediaClient.zzo((zzr) null);
            castSession.zzi = null;
        }
        castSession.zzk = null;
    }

    public static /* bridge */ /* synthetic */ void zzh(CastSession castSession, String str, Task task) {
        if (castSession.zze != null) {
            try {
                if (task.isSuccessful()) {
                    Cast.ApplicationConnectionResult applicationConnectionResult = (Cast.ApplicationConnectionResult) task.getResult();
                    castSession.zzk = applicationConnectionResult;
                    if (applicationConnectionResult.getStatus() != null && applicationConnectionResult.getStatus().isSuccess()) {
                        zzb.d("%s() -> success result", str);
                        RemoteMediaClient remoteMediaClient = new RemoteMediaClient(new zzap((String) null));
                        castSession.zzi = remoteMediaClient;
                        remoteMediaClient.zzo(castSession.zzh);
                        castSession.zzi.zzn();
                        castSession.zzg.zzd(castSession.zzi, castSession.getCastDevice());
                        castSession.zze.zzf((ApplicationMetadata) Preconditions.checkNotNull(applicationConnectionResult.getApplicationMetadata()), applicationConnectionResult.getApplicationStatus(), (String) Preconditions.checkNotNull(applicationConnectionResult.getSessionId()), applicationConnectionResult.getWasLaunched());
                        return;
                    } else if (applicationConnectionResult.getStatus() != null) {
                        zzb.d("%s() -> failure result", str);
                        castSession.zze.zzg(applicationConnectionResult.getStatus().getStatusCode());
                        return;
                    }
                } else {
                    Exception exception = task.getException();
                    if (exception instanceof ApiException) {
                        castSession.zze.zzg(((ApiException) exception).getStatusCode());
                        return;
                    }
                }
                castSession.zze.zzg(2476);
            } catch (RemoteException e10) {
                zzb.d(e10, "Unable to call %s on %s.", "methods", zzz.class.getSimpleName());
            }
        }
    }

    private final void zzm(Bundle bundle) {
        CastMediaOptions castMediaOptions;
        NotificationOptions notificationOptions;
        boolean z10;
        CastDevice fromBundle = CastDevice.getFromBundle(bundle);
        this.zzj = fromBundle;
        if (fromBundle != null) {
            zzr zzr = this.zzh;
            if (zzr != null) {
                zzr.zzf();
                this.zzh = null;
            }
            boolean z11 = true;
            zzb.d("Acquiring a connection to Google Play Services for %s", this.zzj);
            CastDevice castDevice = (CastDevice) Preconditions.checkNotNull(this.zzj);
            Bundle bundle2 = new Bundle();
            CastOptions castOptions = this.zzf;
            if (castOptions == null) {
                castMediaOptions = null;
            } else {
                castMediaOptions = castOptions.getCastMediaOptions();
            }
            if (castMediaOptions == null) {
                notificationOptions = null;
            } else {
                notificationOptions = castMediaOptions.getNotificationOptions();
            }
            if (castMediaOptions == null || !castMediaOptions.zza()) {
                z10 = false;
            } else {
                z10 = true;
            }
            Intent intent = new Intent(this.zzc, p1.class);
            intent.setPackage(this.zzc.getPackageName());
            boolean z12 = !this.zzc.getPackageManager().queryBroadcastReceivers(intent, 0).isEmpty();
            if (notificationOptions == null) {
                z11 = false;
            }
            bundle2.putBoolean("com.google.android.gms.cast.EXTRA_CAST_FRAMEWORK_NOTIFICATION_ENABLED", z11);
            bundle2.putBoolean("com.google.android.gms.cast.EXTRA_CAST_REMOTE_CONTROL_NOTIFICATION_ENABLED", z10);
            bundle2.putBoolean("com.google.android.gms.cast.EXTRA_CAST_ALWAYS_FOLLOW_SESSION_ENABLED", z12);
            Cast.CastOptions.Builder builder = new Cast.CastOptions.Builder(castDevice, new zzn(this, (zzm) null));
            builder.zzc(bundle2);
            zzr zza2 = Cast.zza(this.zzc, builder.build());
            zza2.zzk(new zzp(this, (zzo) null));
            this.zzh = zza2;
            zza2.zze();
        } else if (isResuming()) {
            notifyFailedToResumeSession(2153);
        } else {
            notifyFailedToStartSession(2151);
        }
    }

    public void addCastListener(@RecentlyNonNull Cast.Listener listener) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (listener != null) {
            this.zzd.add(listener);
        }
    }

    public void end(boolean z10) {
        zzz zzz = this.zze;
        if (zzz != null) {
            try {
                zzz.zze(z10, 0);
            } catch (RemoteException e10) {
                zzb.d(e10, "Unable to call %s on %s.", "disconnectFromDevice", zzz.class.getSimpleName());
            }
            notifySessionEnded(0);
            zzar zzar = this.zzl;
            if (zzar != null) {
                zzar.zzd();
            }
        }
    }

    public int getActiveInputState() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        zzr zzr = this.zzh;
        if (zzr != null) {
            return zzr.zzb();
        }
        return -1;
    }

    @RecentlyNullable
    public Cast.ApplicationConnectionResult getApplicationConnectionResult() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        return this.zzk;
    }

    @RecentlyNullable
    public ApplicationMetadata getApplicationMetadata() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        zzr zzr = this.zzh;
        if (zzr != null) {
            return zzr.zzd();
        }
        return null;
    }

    @RecentlyNullable
    public String getApplicationStatus() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        zzr zzr = this.zzh;
        if (zzr != null) {
            return zzr.zzj();
        }
        return null;
    }

    @RecentlyNullable
    public CastDevice getCastDevice() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        return this.zzj;
    }

    @RecentlyNullable
    public RemoteMediaClient getRemoteMediaClient() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        return this.zzi;
    }

    public long getSessionRemainingTimeMs() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        RemoteMediaClient remoteMediaClient = this.zzi;
        if (remoteMediaClient == null) {
            return 0;
        }
        return remoteMediaClient.getStreamDuration() - this.zzi.getApproximateStreamPosition();
    }

    public int getStandbyState() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        zzr zzr = this.zzh;
        if (zzr != null) {
            return zzr.zzc();
        }
        return -1;
    }

    public double getVolume() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        zzr zzr = this.zzh;
        if (zzr != null) {
            return zzr.zza();
        }
        return 0.0d;
    }

    public boolean isMute() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        zzr zzr = this.zzh;
        if (zzr == null || !zzr.zzl()) {
            return false;
        }
        return true;
    }

    public void onResuming(@RecentlyNonNull Bundle bundle) {
        this.zzj = CastDevice.getFromBundle(bundle);
    }

    public void onStarting(@RecentlyNonNull Bundle bundle) {
        this.zzj = CastDevice.getFromBundle(bundle);
    }

    public void removeCastListener(@RecentlyNonNull Cast.Listener listener) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (listener != null) {
            this.zzd.remove(listener);
        }
    }

    public void removeMessageReceivedCallbacks(@RecentlyNonNull String str) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        zzr zzr = this.zzh;
        if (zzr != null) {
            zzr.zzg(str);
        }
    }

    public void requestStatus() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        zzr zzr = this.zzh;
        if (zzr != null) {
            ((zzbp) zzr).doWrite(TaskApiCall.builder().run(zzax.zza).setMethodKey(8404).build());
        }
    }

    public void resume(@RecentlyNonNull Bundle bundle) {
        zzm(bundle);
    }

    @RecentlyNonNull
    public PendingResult<Status> sendMessage(@RecentlyNonNull String str, @RecentlyNonNull String str2) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        zzr zzr = this.zzh;
        if (zzr == null) {
            return PendingResults.immediatePendingResult(new Status(17));
        }
        return zzao.zza(zzr.zzh(str, str2), zzh.zza, zzg.zza);
    }

    public void setMessageReceivedCallbacks(@RecentlyNonNull String str, @RecentlyNonNull Cast.MessageReceivedCallback messageReceivedCallback) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        zzr zzr = this.zzh;
        if (zzr != null) {
            zzr.zzi(str, messageReceivedCallback);
        }
    }

    public void setMute(boolean z10) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        zzr zzr = this.zzh;
        if (zzr != null) {
            zzbp zzbp = (zzbp) zzr;
            zzbp.doWrite(TaskApiCall.builder().run(new zzau(zzbp, z10)).setMethodKey(8412).build());
        }
    }

    public void setVolume(double d10) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        zzr zzr = this.zzh;
        if (zzr == null) {
            return;
        }
        if (Double.isInfinite(d10) || Double.isNaN(d10)) {
            StringBuilder sb = new StringBuilder(41);
            sb.append("Volume cannot be ");
            sb.append(d10);
            throw new IllegalArgumentException(sb.toString());
        }
        zzbp zzbp = (zzbp) zzr;
        zzbp.doWrite(TaskApiCall.builder().run(new zzaz(zzbp, d10)).setMethodKey(8411).build());
    }

    public void start(@RecentlyNonNull Bundle bundle) {
        zzm(bundle);
    }

    public final zzp zzd() {
        return this.zzg;
    }

    public final void zzi(zzar zzar) {
        this.zzl = zzar;
    }

    public final void zzj(@RecentlyNonNull Bundle bundle) {
        this.zzj = CastDevice.getFromBundle(bundle);
    }
}
