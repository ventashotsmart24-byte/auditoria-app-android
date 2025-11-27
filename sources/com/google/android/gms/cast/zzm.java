package com.google.android.gms.cast;

import android.os.RemoteException;
import com.google.android.gms.cast.Cast;
import com.google.android.gms.cast.LaunchOptions;
import com.google.android.gms.cast.internal.zzai;
import com.google.android.gms.cast.internal.zzw;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.ShowFirstParty;
import java.io.IOException;

public final class zzm implements Cast.CastApi {
    public final int getActiveInputState(GoogleApiClient googleApiClient) {
        return ((zzw) googleApiClient.getClient(zzai.zza)).zzr();
    }

    public final ApplicationMetadata getApplicationMetadata(GoogleApiClient googleApiClient) {
        return ((zzw) googleApiClient.getClient(zzai.zza)).zzt();
    }

    public final String getApplicationStatus(GoogleApiClient googleApiClient) {
        return ((zzw) googleApiClient.getClient(zzai.zza)).zzz();
    }

    public final int getStandbyState(GoogleApiClient googleApiClient) {
        return ((zzw) googleApiClient.getClient(zzai.zza)).zzs();
    }

    public final double getVolume(GoogleApiClient googleApiClient) {
        return ((zzw) googleApiClient.getClient(zzai.zza)).zzq();
    }

    public final boolean isMute(GoogleApiClient googleApiClient) {
        return ((zzw) googleApiClient.getClient(zzai.zza)).zzX();
    }

    public final PendingResult<Cast.ApplicationConnectionResult> joinApplication(GoogleApiClient googleApiClient) {
        return zza(googleApiClient, (String) null, (String) null, (zzbq) null);
    }

    public final PendingResult<Cast.ApplicationConnectionResult> launchApplication(GoogleApiClient googleApiClient, String str) {
        return googleApiClient.execute(new zzg(this, googleApiClient, str));
    }

    public final PendingResult<Status> leaveApplication(GoogleApiClient googleApiClient) {
        return googleApiClient.execute(new zzj(this, googleApiClient));
    }

    public final void removeMessageReceivedCallbacks(GoogleApiClient googleApiClient, String str) {
        try {
            ((zzw) googleApiClient.getClient(zzai.zza)).zzO(str);
        } catch (RemoteException unused) {
            throw new IOException("service error");
        }
    }

    public final void requestStatus(GoogleApiClient googleApiClient) {
        try {
            ((zzw) googleApiClient.getClient(zzai.zza)).zzP();
        } catch (RemoteException unused) {
            throw new IOException("service error");
        }
    }

    public final PendingResult<Status> sendMessage(GoogleApiClient googleApiClient, String str, String str2) {
        return googleApiClient.execute(new zzf(this, googleApiClient, str, str2));
    }

    public final void setMessageReceivedCallbacks(GoogleApiClient googleApiClient, String str, Cast.MessageReceivedCallback messageReceivedCallback) {
        try {
            ((zzw) googleApiClient.getClient(zzai.zza)).zzS(str, messageReceivedCallback);
        } catch (RemoteException unused) {
            throw new IOException("service error");
        }
    }

    public final void setMute(GoogleApiClient googleApiClient, boolean z10) {
        try {
            ((zzw) googleApiClient.getClient(zzai.zza)).zzT(z10);
        } catch (RemoteException unused) {
            throw new IOException("service error");
        }
    }

    public final void setVolume(GoogleApiClient googleApiClient, double d10) {
        try {
            ((zzw) googleApiClient.getClient(zzai.zza)).zzU(d10);
        } catch (RemoteException unused) {
            throw new IOException("service error");
        }
    }

    public final PendingResult<Status> stopApplication(GoogleApiClient googleApiClient) {
        return googleApiClient.execute(new zzk(this, googleApiClient));
    }

    @ShowFirstParty
    public final PendingResult<Cast.ApplicationConnectionResult> zza(GoogleApiClient googleApiClient, String str, String str2, zzbq zzbq) {
        return googleApiClient.execute(new zzi(this, googleApiClient, str, str2, (zzbq) null));
    }

    public final PendingResult<Cast.ApplicationConnectionResult> joinApplication(GoogleApiClient googleApiClient, String str) {
        return zza(googleApiClient, str, (String) null, (zzbq) null);
    }

    public final PendingResult<Cast.ApplicationConnectionResult> launchApplication(GoogleApiClient googleApiClient, String str, LaunchOptions launchOptions) {
        return googleApiClient.execute(new zzh(this, googleApiClient, str, launchOptions));
    }

    public final PendingResult<Status> stopApplication(GoogleApiClient googleApiClient, String str) {
        return googleApiClient.execute(new zzl(this, googleApiClient, str));
    }

    public final PendingResult<Cast.ApplicationConnectionResult> joinApplication(GoogleApiClient googleApiClient, String str, String str2) {
        return zza(googleApiClient, str, str2, (zzbq) null);
    }

    @Deprecated
    public final PendingResult<Cast.ApplicationConnectionResult> launchApplication(GoogleApiClient googleApiClient, String str, boolean z10) {
        LaunchOptions.Builder builder = new LaunchOptions.Builder();
        builder.setRelaunchIfRunning(z10);
        return googleApiClient.execute(new zzh(this, googleApiClient, str, builder.build()));
    }
}
