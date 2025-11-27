package com.google.android.gms.internal.cast;

import com.google.android.gms.cast.framework.CastSession;
import com.google.android.gms.cast.framework.Session;
import com.google.android.gms.cast.framework.SessionManagerListener;
import com.google.android.gms.common.internal.Preconditions;
import com.taobao.accs.common.Constants;

final class zzg implements SessionManagerListener<CastSession> {
    final /* synthetic */ zzh zza;

    public /* synthetic */ zzg(zzh zzh, zzf zzf) {
        this.zza = zzh;
    }

    public final /* synthetic */ void onSessionEnded(Session session, int i10) {
        zzh.zzj(this.zza, (CastSession) session, i10);
    }

    public final /* bridge */ /* synthetic */ void onSessionEnding(Session session) {
        CastSession castSession = (CastSession) session;
    }

    public final /* synthetic */ void onSessionResumeFailed(Session session, int i10) {
        zzh.zzj(this.zza, (CastSession) session, i10);
    }

    public final /* bridge */ /* synthetic */ void onSessionResumed(Session session, boolean z10) {
        this.zza.zzq((CastSession) session);
        Preconditions.checkNotNull(this.zza.zzg);
        this.zza.zzb.zzb(this.zza.zzc.zzb(this.zza.zzg, z10), 227);
        this.zza.zzg.zzc(this.zza.zzf);
        this.zza.zzs();
    }

    public final /* bridge */ /* synthetic */ void onSessionResuming(Session session, String str) {
        CastSession castSession = (CastSession) session;
        zzh zzh = this.zza;
        zzh.zzk(zzh, zzh.zzf, str);
        Preconditions.checkNotNull(this.zza.zzg);
        this.zza.zzb.zzb(this.zza.zzc.zzc(this.zza.zzg), 226);
    }

    public final /* synthetic */ void onSessionStartFailed(Session session, int i10) {
        zzh.zzj(this.zza, (CastSession) session, i10);
    }

    public final /* bridge */ /* synthetic */ void onSessionStarted(Session session, String str) {
        this.zza.zzq((CastSession) session);
        this.zza.zzg.zzf = str;
        this.zza.zzb.zzb(this.zza.zzc.zza(this.zza.zzg), 222);
        this.zza.zzg.zzc(this.zza.zzf);
        this.zza.zzs();
    }

    public final /* bridge */ /* synthetic */ void onSessionStarting(Session session) {
        CastSession castSession = (CastSession) session;
        if (this.zza.zzg != null) {
            zzh.zza.w("Start a session while there's already an active session. Create a new one.", new Object[0]);
        }
        this.zza.zzr(castSession);
        this.zza.zzb.zzb(this.zza.zzc.zzd(this.zza.zzg), Constants.SDK_VERSION_CODE);
    }

    public final /* bridge */ /* synthetic */ void onSessionSuspended(Session session, int i10) {
        this.zza.zzq((CastSession) session);
        Preconditions.checkNotNull(this.zza.zzg);
        this.zza.zzb.zzb(this.zza.zzc.zze(this.zza.zzg, i10), 225);
        this.zza.zzg.zzc(this.zza.zzf);
        this.zza.zzp();
    }
}
