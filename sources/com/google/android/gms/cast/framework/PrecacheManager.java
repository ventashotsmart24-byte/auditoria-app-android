package com.google.android.gms.cast.framework;

import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.cast.framework.media.RemoteMediaClient;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.cast.internal.zzh;
import com.google.android.gms.cast.internal.zzn;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.internal.cast.zzju;
import com.google.android.gms.internal.cast.zzl;
import java.util.List;

public class PrecacheManager {
    private final Logger zza = new Logger("PrecacheManager");
    private final CastOptions zzb;
    private final SessionManager zzc;
    private final zzn zzd;

    public PrecacheManager(CastOptions castOptions, SessionManager sessionManager, zzn zzn) {
        this.zzb = castOptions;
        this.zzc = sessionManager;
        this.zzd = zzn;
    }

    public void precache(@RecentlyNonNull String str) {
        zzl.zzd(zzju.PRECACHE);
        Session currentSession = this.zzc.getCurrentSession();
        if (str == null) {
            throw new IllegalArgumentException("No precache data found to be precached");
        } else if (currentSession == null) {
            zzn zzn = this.zzd;
            zzn.doWrite(TaskApiCall.builder().setMethodKey(8423).run(new zzh(zzn, new String[]{this.zzb.getReceiverApplicationId()}, str, (List) null)).build());
        } else if (currentSession instanceof CastSession) {
            RemoteMediaClient remoteMediaClient = ((CastSession) currentSession).getRemoteMediaClient();
            if (remoteMediaClient != null) {
                remoteMediaClient.zze(str, (List) null);
            } else {
                this.zza.e("Failed to get RemoteMediaClient from current cast session.", new Object[0]);
            }
        } else {
            this.zza.e("Current session is not a CastSession. Precache is not supported.", new Object[0]);
        }
    }
}
