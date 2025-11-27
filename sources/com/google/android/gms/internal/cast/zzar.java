package com.google.android.gms.internal.cast;

import com.google.android.gms.cast.SessionState;
import com.google.android.gms.cast.framework.CastSession;
import com.google.android.gms.cast.framework.SessionManager;
import com.google.android.gms.cast.framework.TransferCallback;
import com.google.android.gms.cast.framework.media.RemoteMediaClient;
import com.google.android.gms.cast.internal.Logger;
import java.util.HashSet;
import java.util.Set;
import n0.t0;
import org.json.JSONObject;

public final class zzar {
    private static final Logger zza = new Logger("TransferController");
    private final Set<TransferCallback> zzb = new HashSet();
    private int zzc = 0;
    private SessionManager zzd;
    private zzno<Void> zze;
    private SessionState zzf;

    public static /* synthetic */ void zza(zzar zzar, Exception exc) {
        zza.w(exc, "Error storing session", new Object[0]);
        zzno<Void> zzno = zzar.zze;
        if (zzno != null) {
            zzno.cancel(false);
        }
    }

    public static /* synthetic */ void zzb(zzar zzar, SessionState sessionState) {
        if (sessionState != null) {
            zzar.zzf = sessionState;
            zzno<Void> zzno = zzar.zze;
            if (zzno != null) {
                zzno.zzj(null);
            }
        }
    }

    private final void zzf() {
        CastSession currentCastSession;
        SessionManager sessionManager = this.zzd;
        if (sessionManager != null && (currentCastSession = sessionManager.getCurrentCastSession()) != null) {
            currentCastSession.zzi((zzar) null);
        }
    }

    public final void zzc(SessionManager sessionManager) {
        this.zzd = sessionManager;
    }

    public final void zzd() {
        SessionState sessionState;
        int i10 = this.zzc;
        if (i10 != 0 && (sessionState = this.zzf) != null) {
            zza.d("notify transferred with type = %d, sessionState = %s", Integer.valueOf(i10), this.zzf);
            for (TransferCallback onTransfer : new HashSet(this.zzb)) {
                onTransfer.onTransfer(this.zzc, sessionState);
            }
            this.zzc = 0;
            this.zzf = null;
            zzf();
        }
    }

    public final void zze(t0.i iVar, t0.i iVar2, zzno<Void> zzno) {
        CastSession castSession;
        if (new HashSet(this.zzb).isEmpty()) {
            zza.d("No need to prepare transfer without any callback", new Object[0]);
            zzno.zzj(null);
        } else if (iVar.o() == 1 && iVar2.o() == 0) {
            SessionManager sessionManager = this.zzd;
            if (sessionManager == null) {
                castSession = null;
            } else {
                castSession = sessionManager.getCurrentCastSession();
                if (castSession != null) {
                    castSession.zzi(this);
                }
            }
            if (castSession == null) {
                zza.d("No need to prepare transfer when there is no Cast session", new Object[0]);
                zzno.zzj(null);
                return;
            }
            RemoteMediaClient remoteMediaClient = castSession.getRemoteMediaClient();
            if (remoteMediaClient == null || !remoteMediaClient.hasMediaSession()) {
                zza.d("No need to prepare transfer when there is no media session", new Object[0]);
                zzf();
                zzno.zzj(null);
                return;
            }
            zza.d("Prepare route transfer for changing endpoint", new Object[0]);
            this.zzf = null;
            this.zzc = 1;
            this.zze = zzno;
            remoteMediaClient.zzi((JSONObject) null).addOnSuccessListener(new zzaq(this)).addOnFailureListener(new zzap(this));
            zzl.zzd(zzju.CAST_TRANSFER_TO_LOCAL_USED);
        } else {
            zza.d("No need to prepare transfer for non cast-to-phone case", new Object[0]);
            zzno.zzj(null);
        }
    }
}
