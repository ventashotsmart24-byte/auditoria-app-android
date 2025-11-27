package com.google.android.gms.cast;

import android.hardware.display.DisplayManager;
import android.os.RemoteException;
import android.view.Display;
import android.view.Surface;
import com.google.android.gms.cast.CastRemoteDisplayLocalService;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.internal.cast.zzcf;
import com.google.android.gms.internal.cast.zzck;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.messaging.Constants;

final class zzy extends zzab {
    final /* synthetic */ TaskCompletionSource zza;
    final /* synthetic */ zzcf zzb;
    final /* synthetic */ CastRemoteDisplayClient zzc;
    final /* synthetic */ zzah zzd;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzy(CastRemoteDisplayClient castRemoteDisplayClient, TaskCompletionSource taskCompletionSource, zzcf zzcf, zzah zzah, byte[] bArr) {
        super((zzaa) null);
        this.zzc = castRemoteDisplayClient;
        this.zza = taskCompletionSource;
        this.zzb = zzcf;
        this.zzd = zzah;
    }

    public final void zzb(int i10, int i11, Surface surface) {
        this.zzc.zzc.d("onConnected", new Object[0]);
        DisplayManager displayManager = (DisplayManager) this.zzc.getApplicationContext().getSystemService(Constants.ScionAnalytics.MessageType.DISPLAY_NOTIFICATION);
        if (displayManager == null) {
            this.zzc.zzc.e("Unable to get the display manager", new Object[0]);
            TaskUtil.setResultOrApiException(Status.RESULT_INTERNAL_ERROR, null, this.zza);
            return;
        }
        CastRemoteDisplayClient.zzd(this.zzc);
        this.zzc.zzd = displayManager.createVirtualDisplay("private_display", i10, i11, (Math.min(i10, i11) * 320) / 1080, surface, 2);
        if (this.zzc.zzd == null) {
            this.zzc.zzc.e("Unable to create virtual display", new Object[0]);
            TaskUtil.setResultOrApiException(Status.RESULT_INTERNAL_ERROR, null, this.zza);
            return;
        }
        Display display = this.zzc.zzd.getDisplay();
        if (display == null) {
            this.zzc.zzc.e("Virtual display does not have a display", new Object[0]);
            TaskUtil.setResultOrApiException(Status.RESULT_INTERNAL_ERROR, null, this.zza);
            return;
        }
        try {
            ((zzck) this.zzb.getService()).zzf(this, display.getDisplayId());
        } catch (RemoteException | IllegalStateException unused) {
            this.zzc.zzc.e("Unable to provision the route's new virtual Display", new Object[0]);
            TaskUtil.setResultOrApiException(Status.RESULT_INTERNAL_ERROR, null, this.zza);
        }
    }

    public final void zzc() {
        this.zzc.zzc.d("onConnectedWithDisplay", new Object[0]);
        if (this.zzc.zzd == null) {
            this.zzc.zzc.e("There is no virtual display", new Object[0]);
            TaskUtil.setResultOrApiException(Status.RESULT_INTERNAL_ERROR, null, this.zza);
            return;
        }
        Display display = this.zzc.zzd.getDisplay();
        if (display != null) {
            TaskUtil.setResultOrApiException(Status.RESULT_SUCCESS, display, this.zza);
            return;
        }
        this.zzc.zzc.e("Virtual display no longer has a display", new Object[0]);
        TaskUtil.setResultOrApiException(Status.RESULT_INTERNAL_ERROR, null, this.zza);
    }

    public final void zzd(int i10) {
        this.zzc.zzc.d("onError: %d", Integer.valueOf(i10));
        CastRemoteDisplayClient.zzd(this.zzc);
        TaskUtil.setResultOrApiException(Status.RESULT_INTERNAL_ERROR, null, this.zza);
    }

    public final void zze(boolean z10) {
        this.zzc.zzc.d("onRemoteDisplayMuteStateChanged: %b", Boolean.valueOf(z10));
        zzah zzah = this.zzd;
        if (zzah != null) {
            CastRemoteDisplayLocalService castRemoteDisplayLocalService = zzah.zza;
            StringBuilder sb = new StringBuilder(38);
            sb.append("onRemoteDisplayMuteStateChanged: ");
            sb.append(z10);
            castRemoteDisplayLocalService.zzv(sb.toString());
            CastRemoteDisplayLocalService.Callbacks callbacks = (CastRemoteDisplayLocalService.Callbacks) zzah.zza.zzg.get();
            if (callbacks != null) {
                callbacks.onRemoteDisplayMuteStateChanged(z10);
            }
        }
    }
}
