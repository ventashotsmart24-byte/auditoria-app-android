package com.google.android.gms.internal.cast;

import android.hardware.display.DisplayManager;
import android.os.RemoteException;
import android.view.Display;
import android.view.Surface;
import com.google.android.gms.common.api.Status;
import com.google.firebase.messaging.Constants;

public final class zzca extends zzbz {
    final /* synthetic */ zzcc zza;
    private final zzch zzb;

    public zzca(zzcc zzcc, zzch zzch) {
        this.zza = zzcc;
        this.zzb = zzch;
    }

    public final void zzb(int i10, int i11, Surface surface) {
        int i12;
        zzce.zza.d("onConnected", new Object[0]);
        DisplayManager displayManager = (DisplayManager) this.zzb.getContext().getSystemService(Constants.ScionAnalytics.MessageType.DISPLAY_NOTIFICATION);
        if (displayManager == null) {
            zzce.zza.e("Unable to get the display manager", new Object[0]);
            this.zza.setResult(new zzcd(Status.RESULT_INTERNAL_ERROR));
            return;
        }
        zzce.zzf(this.zza.zzc);
        if (i10 < i11) {
            i12 = i10;
        } else {
            i12 = i11;
        }
        this.zza.zzc.zzc = displayManager.createVirtualDisplay("private_display", i10, i11, (i12 * 320) / 1080, surface, 2);
        if (this.zza.zzc.zzc == null) {
            zzce.zza.e("Unable to create virtual display", new Object[0]);
            this.zza.setResult(new zzcd(Status.RESULT_INTERNAL_ERROR));
        } else if (this.zza.zzc.zzc.getDisplay() == null) {
            zzce.zza.e("Virtual display does not have a display", new Object[0]);
            this.zza.setResult(new zzcd(Status.RESULT_INTERNAL_ERROR));
        } else {
            try {
                zzch zzch = this.zzb;
                ((zzck) zzch.getService()).zzf(this, this.zza.zzc.zzc.getDisplay().getDisplayId());
            } catch (RemoteException | IllegalStateException unused) {
                zzce.zza.e("Unable to provision the route's new virtual Display", new Object[0]);
                this.zza.setResult(new zzcd(Status.RESULT_INTERNAL_ERROR));
            }
        }
    }

    public final void zzc() {
        zzce.zza.d("onConnectedWithDisplay", new Object[0]);
        if (this.zza.zzc.zzc == null) {
            zzce.zza.e("There is no virtual display", new Object[0]);
            this.zza.setResult(new zzcd(Status.RESULT_INTERNAL_ERROR));
            return;
        }
        Display display = this.zza.zzc.zzc.getDisplay();
        if (display != null) {
            this.zza.setResult(new zzcd(display));
            return;
        }
        zzce.zza.e("Virtual display no longer has a display", new Object[0]);
        this.zza.setResult(new zzcd(Status.RESULT_INTERNAL_ERROR));
    }

    public final void zzd(int i10) {
        zzce.zza.d("onError: %d", Integer.valueOf(i10));
        zzce.zzf(this.zza.zzc);
        this.zza.setResult(new zzcd(Status.RESULT_INTERNAL_ERROR));
    }
}
