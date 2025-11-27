package com.google.android.gms.cast;

import android.app.PendingIntent;
import android.content.Context;
import android.hardware.display.VirtualDisplay;
import android.view.Display;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.cast.CastRemoteDisplay;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.cast.internal.zzai;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.internal.cast.zzcf;
import com.google.android.gms.tasks.Task;

@Deprecated
public class CastRemoteDisplayClient extends GoogleApi<Api.ApiOptions.NoOptions> {
    private static final Api.AbstractClientBuilder<zzcf, Api.ApiOptions.NoOptions> zza;
    private static final Api<Api.ApiOptions.NoOptions> zzb;
    /* access modifiers changed from: private */
    public final Logger zzc = new Logger("CastRemoteDisplay");
    /* access modifiers changed from: private */
    public VirtualDisplay zzd;

    static {
        zzx zzx = new zzx();
        zza = zzx;
        zzb = new Api<>("CastRemoteDisplay.API", zzx, zzai.zzd);
    }

    public CastRemoteDisplayClient(Context context) {
        super(context, zzb, Api.ApiOptions.NO_OPTIONS, GoogleApi.Settings.DEFAULT_SETTINGS);
    }

    public static /* bridge */ /* synthetic */ void zzd(CastRemoteDisplayClient castRemoteDisplayClient) {
        VirtualDisplay virtualDisplay = castRemoteDisplayClient.zzd;
        if (virtualDisplay != null) {
            if (virtualDisplay.getDisplay() != null) {
                Logger logger = castRemoteDisplayClient.zzc;
                int displayId = castRemoteDisplayClient.zzd.getDisplay().getDisplayId();
                StringBuilder sb = new StringBuilder(38);
                sb.append("releasing virtual display: ");
                sb.append(displayId);
                logger.d(sb.toString(), new Object[0]);
            }
            VirtualDisplay virtualDisplay2 = castRemoteDisplayClient.zzd;
            if (virtualDisplay2 != null) {
                virtualDisplay2.release();
                castRemoteDisplayClient.zzd = null;
            }
        }
    }

    @RecentlyNonNull
    public Task<Display> startRemoteDisplay(@RecentlyNonNull CastDevice castDevice, @RecentlyNonNull String str, @CastRemoteDisplay.Configuration int i10, PendingIntent pendingIntent) {
        return zze(castDevice, str, i10, pendingIntent, (zzah) null);
    }

    @RecentlyNonNull
    public Task<Void> stopRemoteDisplay() {
        return doWrite(TaskApiCall.builder().setMethodKey(8402).run(new zzv(this)).build());
    }

    public final Task<Display> zze(CastDevice castDevice, String str, @CastRemoteDisplay.Configuration int i10, PendingIntent pendingIntent, zzah zzah) {
        return doWrite(TaskApiCall.builder().setMethodKey(8401).run(new zzw(this, i10, zzah, pendingIntent, castDevice, str, (byte[]) null)).build());
    }
}
